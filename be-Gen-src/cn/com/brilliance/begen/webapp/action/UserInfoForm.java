package cn.com.brilliance.begen.webapp.action;

import cn.com.brilliance.begen.common.Constants;
import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.model.TuserInfo;
import cn.com.brilliance.begen.webapp.servlet.UserBean;

public class UserInfoForm extends BasePage  {
	private String oldPassword;
	
	private String password;
	
	private TuserInfo tuserInfo;
	
	public UserInfoForm(){
		this.setTuserInfo(this.getUserBean().getTuserInfo());
	}
	
	public String modifyPassword(){
		String pwd = this.getUserBean().getTuserInfo().getPassword();
		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO) getBean("tuserInfoDAO");
		if(!oldPassword.equals(pwd)){
			this.addMessageString("�������ԭ���벻��ȷ!");
			return null;
		}
		else{
			String id  = this.getUserBean().getTuserInfo().getId();
			TuserInfo tuserInfo = tuserInfoDAO.getTuserInfo(id);
			tuserInfo.setPassword(password);
			tuserInfoDAO.saveTuserInfo(tuserInfo);
			this.addMessageString("�����޸ĳɹ�!");
			return "success";
		}		
	}
	
	public String modifyUserInfo(){
		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO) getBean("tuserInfoDAO");
		tuserInfo = tuserInfoDAO.saveTuserInfo(tuserInfo);
		UserBean userBean = this.getUserBean();
		userBean.setTuserInfo(tuserInfo);
		this.getSession().setAttribute(Constants.SESSION_USER_INFO, userBean);
		this.addMessageString("�޸��û���Ϣ�ɹ�!");
		return "success";
	}

	/**
	 * @return the tuserInfo
	 */
	public TuserInfo getTuserInfo() {
		return tuserInfo;
	}

	/**
	 * @param tuserInfo the tuserInfo to set
	 */
	public void setTuserInfo(TuserInfo tuserInfo) {
		this.tuserInfo = tuserInfo;
	}

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
