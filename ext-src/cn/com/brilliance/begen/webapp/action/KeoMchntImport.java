package cn.com.brilliance.begen.webapp.action;
import java.io.BufferedInputStream;
import java.io.BufferedReader;

import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.apache.myfaces.custom.fileupload.UploadedFile;


import cn.com.brilliance.begen.common.webapp.action.ResultPage;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.TkeoMchnt;
import cn.com.brilliance.begen.model.Tmchnt;
import cn.com.brilliance.begen.service.TkeoMchntService;
import cn.com.brilliance.begen.service.TmchntService;

public class KeoMchntImport extends BasePage{
	private UploadedFile myFile;
	
	private String type;
	
	private String myResult;

	public UploadedFile getMyFile() {
		return myFile;
	}

	public void setMyFile(UploadedFile myFile) {
		this.myFile = myFile;
	}

	public String getMyResult() {
		return myResult;
	}

	public void setMyResult(String myResult) {
		this.myResult = myResult;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 导入文件
	 * @return
	 */
	public String processMyFile() {
		try {
			
		    InputStream in = new BufferedInputStream(
		    		myFile.getInputStream());
		    
		    BufferedReader reader = new BufferedReader(new InputStreamReader(
		    		in, "GBK"));

		    TkeoMchntService serv = (TkeoMchntService)getBean("tkeoMchntService");
		    TmchntService service = (TmchntService)getBean("tmchntService");
		    
		    String tmp = null;
		    int lineNumber = 0;
		    String errstr = "";
		    int errNumber = 0;
		    
		    while ((tmp = reader.readLine()) != null) {
		    	lineNumber++;
		    	if (tmp.indexOf(",") == -1) {
		    		errstr = errstr +"第" + lineNumber + "行 文件格式不合格\n";
		    		errNumber++;
		    		continue;
		    	}
		    	String[] entry = tmp.split(",");
		    	String subinst = entry[0].trim();
		    	String mchntNo = entry[1].trim();
		    	String network = entry[2].trim();
		    	String reason = entry[3].trim();
		    	
		    	
                // 检查商户id是否在商户表里存在
		    	Tmchnt mer = service.getTmchntByName(mchntNo,subinst,network);
		    	
		    	if (mer == null) {
		    		//商户不存在;
		    		errstr = errstr + "第" + lineNumber + "行 编号为:"+mchntNo+"的商户不存在\n";
		    		errNumber++;
		    		continue;// 继续读文件的下一行
		    	}

		    		//查询是否已经存在商户相同
			    TkeoMchnt tkeoMchnt =  serv.getKeoMchnt(mer.getId(),this.getType());
					
				if (tkeoMchnt!=null){
					tkeoMchnt.setReason(reason);
					serv.saveTkeoMchnt(tkeoMchnt);
				}else{
						TkeoMchnt keoMchnt = new TkeoMchnt();
				    	keoMchnt.setApprovedDate(mer.getApproveddate());
				    	keoMchnt.setBelongToInst(mer.getSubinst());
				    	keoMchnt.setSubInst(mer.getBelongToSubinst());
				    	keoMchnt.setMchntCd(mer.getMerchantno());
				    	keoMchnt.setMchntId(mer.getId());
				    	keoMchnt.setMchntName(mer.getBriefname());
				    	keoMchnt.setReason(reason);
				    	keoMchnt.setSettlementAccntNo(service.getTmchntAccountNo(mer.getId()));
				    	keoMchnt.setState(mer.getState());
				    	keoMchnt.setType(this.getType());
				    	keoMchnt.setWithdrawInputdate(mer.getWithdrawinputdate());
				    	
				    	serv.saveTkeoMchnt(keoMchnt);
					}
			    	
		    }
		    reader.close();
		    
		    if ("".equals(errstr)){
		    	return getSuccessAction();
		    }else{
		    	if (errNumber < lineNumber){
		    		int succNumber = lineNumber - errNumber;
		    		errstr = "本次批量导入数据共" +lineNumber +"条\n"  + "导入成功记录" +  succNumber + "条\n" +
		    					"导入失败记录" +  errNumber + "条\n" + "失败原因:\n" + errstr ;
		    	}
		    	/*this.addMessageString(ResultPage.MESSAGE_TYPE_OTHER_ERROR,
						"导入日志", errstr);*/
		    	this.addMessageString(ResultPage.MESSAGE_TYPE_IMPORT_REPORT,
						"请勾选查看导入汇总情况", errstr);
				return getSuccessAction();
		    }
		     
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.addMessage(e.hashCode(), e.getMessage(), e);
			return getFailureAction();
		}
	}

	 public String getHistoryUrlParameter(){
	    	
	    	return "";
	    }
	
	
}
