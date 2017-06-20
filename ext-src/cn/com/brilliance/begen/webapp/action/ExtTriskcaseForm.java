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
		this.addMessageString("�����ɹ�!");
		return this.getSuccessAction();
	}
	
	//ȡ��֧������ϵͳ����,�鿴�÷�֧�����������Ƿ���Ҫ�ֶ�����
	private String getOrganizeCheck() {
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		String organizeId = tuserInfo.getOrganizeId();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO.getTorganizeInfo(organizeId);
		return torganizeInfo.getIsCheck();
	}
	
	// �������������Ϻ󣬽�������ظ�����������Ȼ�󽫸��ݻ�����ϵͳ����ѡ����״̬Ϊ��������˻��߷�֧������������ˡ�
	public String submitToBelong() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		Set set = triskcase.getTriskcaseRecordGroup();
		Iterator it = set.iterator();
		if(!it.hasNext()) {
			this.addMessageString("��ǼǴ�����!");
			return null;
		}
		triskcase.setStatus("3");
		service.saveTriskcase(triskcase);
		this.addMessageString("�����ɹ�!");
		return this.getSuccessAction();
	}

	//��֧������˴�������ύ�����İ���������������Ҫ�������˻ش����������״̬��Ϊ������
	public String backToInst() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments6().length() > 255) {
			this.addMessageString("�ֹ�˾��������ĳ��ȹ���!");
			return null;
		}
		triskcase.setStatus("2");
		service.saveTriskcase(triskcase);
		return this.getSuccessAction();
	}

	//��֧����ͨ����������ύ�İ�����ˣ��������ύ���ܲ���Ȼ��״̬��Ϊ�����
	public String submitToParent() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments6() != null && triskcase.getComments6().length() > 255) {
			this.addMessageString("�ֹ�˾��������ĳ��ȹ���!");
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
		this.addMessageString("�����ɹ�!");
		return this.getSuccessAction();

	}

	//�ܲ��Է�֧�����ύ�����İ��������⣬�˻������������´�����״̬��Ϊ������
	public String backToBelong() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments8().length() > 255) {
			this.addMessageString("�ܹ�˾����ĳ��ȹ���!");
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
		this.addMessageString("�����ɹ�!");
		return this.getSuccessAction();
	}

	// �ܲ��Է�֧�����ύ�����İ������ͨ������״̬��Ϊ�᰸��
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
		this.addMessageString("�����ɹ�!");
		return this.getSuccessAction();
	}

	// �ܲ��������ѽ᰸�İ���ȡ���᰸����״̬��Ϊ�����
	public String startCase() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		triskcase.setStatus("5");
		service.saveTriskcase(triskcase);
		this.addMessageString("�����ɹ�!");
		return this.getSuccessAction();
	}
	
	//������˺����֧����������ˣ���֧����������˺󣬽�����״̬��Ϊ�����
	public String submitToParentByChief() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments7() != null && triskcase.getComments7().length() > 255) {
			this.addMessageString("�ֹ�˾��������ĳ��ȹ���!");
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
		this.addMessageString("�����ɹ�!");
		return this.getSuccessAction();

	}
	
	//��֧�������ܽ������˻�������,״̬��Ϊ�Ѵ����ȷ��
	public String backToInstByChief() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments7().length() > 255) {
			this.addMessageString("�ֹ�˾��������ĳ��ȹ���!");
			return null;
		}

		triskcase.setStatus("3");
		service.saveTriskcase(triskcase);
		this.addMessageString("�����ɹ�!");
		return this.getSuccessAction();
	}

	public String urgent() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		if(triskcase.getComments8().length() > 255) {
			this.addMessageString("�ܹ�˾����ĳ��ȹ���!");
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
		this.addMessageString("��������ɹ�!");
		return this.getSuccessAction();
	}
	
	public String backToBelongByWrongSubmit() {
		TriskcaseForm triskcaseForm = (TriskcaseForm) getValueBinding("#{triskcaseForm}");
		Triskcase triskcase = triskcaseForm.getTriskcase();
		triskcase.setStatus("1");
		service.saveTriskcase(triskcase);
		this.addMessageString("�����ɹ�!");
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
