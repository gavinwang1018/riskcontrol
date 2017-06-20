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
	 * �����ļ�
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
		    		errstr = errstr +"��" + lineNumber + "�� �ļ���ʽ���ϸ�\n";
		    		errNumber++;
		    		continue;
		    	}
		    	String[] entry = tmp.split(",");
		    	String subinst = entry[0].trim();
		    	String mchntNo = entry[1].trim();
		    	String network = entry[2].trim();
		    	String reason = entry[3].trim();
		    	
		    	
                // ����̻�id�Ƿ����̻��������
		    	Tmchnt mer = service.getTmchntByName(mchntNo,subinst,network);
		    	
		    	if (mer == null) {
		    		//�̻�������;
		    		errstr = errstr + "��" + lineNumber + "�� ���Ϊ:"+mchntNo+"���̻�������\n";
		    		errNumber++;
		    		continue;// �������ļ�����һ��
		    	}

		    		//��ѯ�Ƿ��Ѿ������̻���ͬ
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
		    		errstr = "���������������ݹ�" +lineNumber +"��\n"  + "����ɹ���¼" +  succNumber + "��\n" +
		    					"����ʧ�ܼ�¼" +  errNumber + "��\n" + "ʧ��ԭ��:\n" + errstr ;
		    	}
		    	/*this.addMessageString(ResultPage.MESSAGE_TYPE_OTHER_ERROR,
						"������־", errstr);*/
		    	this.addMessageString(ResultPage.MESSAGE_TYPE_IMPORT_REPORT,
						"�빴ѡ�鿴����������", errstr);
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
