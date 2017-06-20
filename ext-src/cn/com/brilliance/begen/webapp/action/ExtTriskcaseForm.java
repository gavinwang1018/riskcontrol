package cn.com.brilliance.begen.webapp.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.model.SelectItem;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.model.TorganizeInfo;
import cn.com.brilliance.begen.model.Triskcase;
import cn.com.brilliance.begen.model.TriskcaseRecord;
import cn.com.brilliance.begen.model.TuserInfo;
import cn.com.brilliance.begen.service.TriskcaseRecordService;
import cn.com.brilliance.begen.service.TriskcaseService;
import cn.com.brilliance.begen.webapp.servlet.UserBean;

public class ExtTriskcaseForm extends BasePage {

	private TriskcaseService service = (TriskcaseService) getBean("triskcaseService");
	private TriskcaseRecordService recordService = (TriskcaseRecordService) getBean("triskcaseRecordService");
	
	private String url;    
	
	private String successUrl;
	
	private String flag;

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String back() {
		if("1".equals(this.flag)) {
			backToInst();
		} else if("2".equals(this.flag)) {
			backToInstByChief();
		} else if("3".equals(this.flag)) {
			backToBelong();
		}
		this.addMessageString("操作成功!");
		return this.getSuccessAction();
	}
	
	//取分支机构的系统配置,查看该分支机构的主管是否需要手动审批
	private String getOrganizeCheck() {
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String organizeId = tuserInfo.getOrganizeId();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO.getTorganizeInfo(organizeId);
		return torganizeInfo.getIsCheck();
	}
	
	// 处理机构处理完毕后，将结果返回给所属机构，然后将根据机构的系统配置选择处理状态为部门已审核或者分支机构主管已审核。
	public String submitToBelong() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		Set set = triskcase.getTriskcaseRecordGroup();
		Iterator it = set.iterator();
		if(!it.hasNext()) {
			this.addMessageString("请登记处理结果!");
			return null;
		}
		triskcase.setStatus("3");
		service.saveTriskcase(triskcase);
		this.addMessageString("操作成功!");
		return this.getSuccessAction();
	}

	//分支机构审核处理机构提交上来的案例处理结果不符合要求，重新退回处理机构，将状态改为处理中
	public String backToInst() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments6().length() > 255) {
			this.addMessageString("分公司部门意见的长度过长!");
			return null;
		}
		triskcase.setStatus("2");
		service.saveTriskcase(triskcase);
		return this.getSuccessAction();
	}

	//分支机构通过处理机构提交的案例审核，将案例提交给总部，然后将状态改为已审核
	public String submitToParent() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments6() != null && triskcase.getComments6().length() > 255) {
			this.addMessageString("分公司部门意见的长度过长!");
			return null;
		}
		Set set = triskcase.getTriskcaseRecordGroup();
		if("0".equals(getOrganizeCheck())) {
			triskcase.setStatus("5");
			for(Iterator it = set.iterator();it.hasNext();) {
				TriskcaseRecord triskcaseRecord = (TriskcaseRecord)it.next();
				triskcaseRecord.setSubmit(Boolean.TRUE);
				triskcaseRecord.setIsLocked(Boolean.TRUE);
				recordService.saveTriskcaseRecord(triskcaseRecord);
			}
		} else{
			triskcase.setStatus("4");
		}
		service.saveTriskcase(triskcase);
		this.addMessageString("操作成功!");
		return this.getSuccessAction();

	}

	//总部对分支机构提交上来的案例不满意，退回所属机构重新处理，将状态改为待处理。
	public String backToBelong() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments8().length() > 255) {
			this.addMessageString("总公司意见的长度过长!");
			return null;
		}

		triskcase.setStatus("1");
		Integer backCntStr = triskcase.getBackCnt();
		int backCnt = 0;
		if(backCntStr != null) {
			backCnt = backCntStr.intValue();
		}
		backCnt++;
		triskcase.setBackCnt(Integer.valueOf(backCnt));
		service.saveTriskcase(triskcase);
		Set set = triskcase.getTriskcaseRecordGroup();
		for (Iterator it = set.iterator(); it.hasNext();) {
			TriskcaseRecord triskcaseRecord = (TriskcaseRecord) it.next();
			triskcaseRecord.setIsLocked(Boolean.TRUE);
			recordService.saveTriskcaseRecord(triskcaseRecord);
		}
		this.addMessageString("操作成功!");
		return this.getSuccessAction();
	}

	// 总部对分支机构提交上来的案例审核通过，将状态改为结案。
	public String closeCase() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		triskcase.setStatus("6");
		service.saveTriskcase(triskcase);
		Set set = triskcase.getTriskcaseRecordGroup();
		for(Iterator it = set.iterator();it.hasNext();) {
			TriskcaseRecord triskcaseRecord = (TriskcaseRecord)it.next();
			triskcaseRecord.setSubmit(Boolean.TRUE);
			recordService.saveTriskcaseRecord(triskcaseRecord);
		}
		this.addMessageString("操作成功!");
		return this.getSuccessAction();
	}

	// 总部机构对已结案的案例取消结案，将状态改为已审核
	public String startCase() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		triskcase.setStatus("5");
		service.saveTriskcase(triskcase);
		this.addMessageString("操作成功!");
		return this.getSuccessAction();
	}
	
	//部门审核后给分支机构主管审核，分支机构主管审核后，将案例状态置为已审核
	public String submitToParentByChief() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments7() != null && triskcase.getComments7().length() > 255) {
			this.addMessageString("分公司主管意见的长度过长!");
			return null;
		}

		triskcase.setStatus("5");
		service.saveTriskcase(triskcase);
		Set set = triskcase.getTriskcaseRecordGroup();
		for (Iterator it = set.iterator(); it.hasNext();) {
			TriskcaseRecord triskcaseRecord = (TriskcaseRecord) it.next();
			triskcaseRecord.setSubmit(Boolean.TRUE);
			recordService.saveTriskcaseRecord(triskcaseRecord);
		}
		this.addMessageString("操作成功!");
		return this.getSuccessAction();

	}
	
	//分支机构主管将案例退回至部门,状态改为已处理待确认
	public String backToInstByChief() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments7().length() > 255) {
			this.addMessageString("分公司主管意见的长度过长!");
			return null;
		}

		triskcase.setStatus("3");
		service.saveTriskcase(triskcase);
		this.addMessageString("操作成功!");
		return this.getSuccessAction();
	}

	public String urgent() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments8().length() > 255) {
			this.addMessageString("总公司意见的长度过长!");
			return null;
		}
		Integer urgentCnt = triskcase.getUrgentCnt();
		int j = 0;
		if(urgentCnt != null) {
			j = urgentCnt.intValue();
		}
		j++;
		triskcase.setUrgentCnt(Integer.valueOf(j));
		triskcase.setBeenUrgent(Boolean.TRUE);
		service.saveTriskcase(triskcase);
		this.addMessageString("案例督办成功!");
		return this.getSuccessAction();
	}
	
	public String backToBelongByWrongSubmit() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		triskcase.setStatus("1");
		service.saveTriskcase(triskcase);
		this.addMessageString("操作成功!");
		return this.getSuccessAction();
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getSuccessUrl() {
		return successUrl;
	}

	public void setSuccessUrl(String successUrl) {
		this.successUrl = successUrl;
	}
	
}
