package cn.com.brilliance.begen.webapp.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.webapp.action.FormPage;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.TuserInfo;
import cn.com.brilliance.begen.service.TuserInfoService;
import cn.com.brilliance.begen.webapp.servlet.UserBean;

/**
 * TuserInfo对象Form.
 * @author Administrator.
 *
 */
public class TuserInfoForm extends BasePage implements FormPage {

	private TuserInfoService service = (TuserInfoService)getBean("tuserInfoService");

    private String lookupKey;        
	
    /**
     * tuserInfo对象.
     */
    private TuserInfo tuserInfo;

    /**
     * TuserInfo对象主键.
     */
    private java.lang.String tuserInfoPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TuserInfo.
     * @return TuserInfo.
     */
    public TuserInfo getTuserInfo() {
        if(tuserInfo == null) {
            tuserInfo = new TuserInfo();
        }
        return tuserInfo;
    }

    /**
     * Sets the TuserInfo.
     * @param tuserInfo The tuserInfo to set.
     */
    public void setTuserInfo(TuserInfo tuserInfo) {
        this.tuserInfo = tuserInfo;
    }

    /**
     * Returns the tuserInfoPrimaryKey.
     * @return TuserInfoPrimaryKey.
     */
    public java.lang.String getTuserInfoPrimaryKey() {
        return tuserInfoPrimaryKey;
    }

    /**
     * Sets the tuserInfoPrimaryKey.
     * @param tuserInfoPrimaryKey The TuserInfoPrimaryKey to set.
     */
    public void setTuserInfoPrimaryKey(java.lang.String tuserInfoPrimaryKey) {
		this.tuserInfoPrimaryKey = tuserInfoPrimaryKey;
		initTuserInfo();
    }
	
	public void initTuserInfo(){
        try {
            if (tuserInfoPrimaryKey == null || tuserInfoPrimaryKey.equals("")) {
                return;
            }
            this.setTuserInfo(service.getTuserInfo(tuserInfoPrimaryKey));    
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	


    /**
     * 存储TuserInfo对象.
     * @return String.
     */
    public String save() {
		try {
			if (tuserInfoPrimaryKey == null && this.tuserInfo.getId() != null) {
				System.out.println("save 4");
				// 判断记录是否重复，并提示错误信息
				if (service.getTuserInfo(this.tuserInfo.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.tuserInfo.getId() + "]");
					return null;
				}
			}
			UserBean userBean = getUserBean();
			if (tuserInfoPrimaryKey == null && this.tuserInfo.getId() == null) {
				Map map = new HashMap();
				String loginName = this.tuserInfo.getLoginName();
				String name = this.tuserInfo.getName();
				map.put("loginName", loginName);
				if (loginName.getBytes().length > 20) {
					addMessage("tuserInfo.error.loginName.tooLarge", "");
					return null;
				}
				if (name.getBytes().length > 20) {
					addMessage("tuserInfo.error.name.tooLarge", "");
					return null;
				}
				List list = service.getTuserInfoListOfQuery(map);
				if (list == null || list.size() > 0) {
					addMessage("tuserInfo.message.duplicatekey", "["
							+ this.tuserInfo.getLoginName() + "]");
					return null;
				}
			}
			if (tuserInfoPrimaryKey == null
					|| tuserInfoPrimaryKey.equals(this.tuserInfo.getId())) {
				String loginName = this.tuserInfo.getLoginName();
				String name = this.tuserInfo.getName();
				if (loginName.getBytes().length > 20) {
					addMessage("tuserInfo.error.loginName.tooLarge", "");
					return null;
				}
				if (name.getBytes().length > 20) {
					addMessage("tuserInfo.error.name.tooLarge", "");
					return null;
				}
				this.tuserInfo = service.saveTuserInfo(this.tuserInfo);
				String key = tuserInfo.getId();
				this.tuserInfoPrimaryKey = key;
				if (tuserInfoPrimaryKey == null) {
					addMessage("tuserInfo.message.added", this.tuserInfo
							.getId());
				} else {
					addMessage("tuserInfo.message.saved", this.tuserInfo
							.getId());
				}
			} else {
				addMessageString("exception.save.primarykey");
				return null;
			}
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

    public String saveAndNew() {
        try {
            String action = save();
            if (action == null) {
                return null;
            }
            TuserInfo tuserInfo = new TuserInfo();
            this.tuserInfo = tuserInfo;
            tuserInfoPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TuserInfo对象.
     * @return String.
     */
    public String delete() {
        try {
            service.delete(this.tuserInfo.getId());
			CmsUtil.deleteFile("t_user_info/"+this.tuserInfo.getId());
            addMessage("tuserInfo.message.deleted", this.tuserInfo.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TuserInfo对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TuserInfo tuserInfo = service.getTuserInfo(this.tuserInfo.getId());
            service.delete(this.tuserInfo.getId());
            addMessage("tuserInfo.message.deleted", this.tuserInfo.getId());	
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }
	
    public String edit(){
    	
    	return getSuccessAction();
    }	

    public String getHistoryUrlParameter(){
    	if(this.tuserInfoPrimaryKey == null)
    		return "_key=" + this.tuserInfo.getId();
    	return "_key=" + this.tuserInfoPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.tuserInfo);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TuserInfo");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (tuserInfoPrimaryKey == null  && this.tuserInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTuserInfo(this.tuserInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tuserInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tuserInfoPrimaryKey == null || tuserInfoPrimaryKey.equals(this.tuserInfo.getId())) {
  
                this.tuserInfo = service.saveAll(this.tuserInfo);
                String key = tuserInfo.getId();
				this.tuserInfoPrimaryKey = key;
                if (tuserInfoPrimaryKey == null) {
                    addMessage("tuserInfo.message.added", this.tuserInfo.getId());				
                }
                else {
                    addMessage("tuserInfo.message.saved", this.tuserInfo.getId());					
                }				
            }
            else {
                addMessageString("exception.save.primarykey");
                return null;
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
    	return this.getSuccessAction();
    }	

    public String saveMultiAll(){
       try {
            if (tuserInfoPrimaryKey == null  && this.tuserInfo.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTuserInfo(this.tuserInfo.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.tuserInfo.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (tuserInfoPrimaryKey == null || tuserInfoPrimaryKey.equals(this.tuserInfo.getId())) {
                this.tuserInfo = service.saveAll(this.tuserInfo);

                String key = tuserInfo.getId();
				this.tuserInfoPrimaryKey = key;
                if (tuserInfoPrimaryKey == null) {
                    addMessage("tuserInfo.message.added", this.tuserInfo.getId());				
                }
                else {
                    addMessage("tuserInfo.message.saved", this.tuserInfo.getId());					
                }				
            }
            else {
                addMessageString("exception.save.primarykey");
                return null;
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }

    	return this.getSuccessAction();
    }	
	

	public void loadTuserInfo(){	
		TuserInfo tuserInfo = (TuserInfo)this.getRequest().getSession().getAttribute("__pop_object");
		this.tuserInfo = tuserInfo;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
	public String closeUser() {
		try {
			this.tuserInfo.setEnable(new Boolean(false));
			service.saveTuserInfo(this.tuserInfo);
			addMessage("tuserInfo.message.deleted", this.tuserInfo.getId());
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	public String roleControl(){
		return this.getSuccessAction();
	}

}
