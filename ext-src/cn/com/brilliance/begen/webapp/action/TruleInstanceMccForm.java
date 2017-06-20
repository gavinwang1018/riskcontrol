package cn.com.brilliance.begen.webapp.action;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;
import org.apache.myfaces.custom.fileupload.UploadedFile;

import cn.com.brilliance.begen.dao.TruleInstanceDAO;
import cn.com.brilliance.begen.dao.TruleInstanceMccDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.webapp.action.FormPage;

/**
 * TruleInstanceMcc对象Form.
 * 
 * @author Administrator.
 * 
 */
public class TruleInstanceMccForm extends BasePage implements FormPage {

	private TruleInstanceMccService service = (TruleInstanceMccService) getBean("truleInstanceMccService");

	private String lookupKey;

	/**
	 * truleInstanceMcc对象.
	 */
	private TruleInstanceMcc truleInstanceMcc;

	/**
	 * TruleInstanceMcc对象主键.
	 */
	private java.lang.String truleInstanceMccPrimaryKey;

	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}

	/**
	 * Returns the TruleInstanceMcc.
	 * 
	 * @return TruleInstanceMcc.
	 */
	public TruleInstanceMcc getTruleInstanceMcc() {
		if (truleInstanceMcc == null) {
			truleInstanceMcc = new TruleInstanceMcc();
		}
		return truleInstanceMcc;
	}

	/**
	 * Sets the TruleInstanceMcc.
	 * 
	 * @param truleInstanceMcc
	 *            The truleInstanceMcc to set.
	 */
	public void setTruleInstanceMcc(TruleInstanceMcc truleInstanceMcc) {
		this.truleInstanceMcc = truleInstanceMcc;
	}

	/**
	 * Returns the truleInstanceMccPrimaryKey.
	 * 
	 * @return TruleInstanceMccPrimaryKey.
	 */
	public java.lang.String getTruleInstanceMccPrimaryKey() {
		return truleInstanceMccPrimaryKey;
	}

	/**
	 * Sets the truleInstanceMccPrimaryKey.
	 * 
	 * @param truleInstanceMccPrimaryKey
	 *            The TruleInstanceMccPrimaryKey to set.
	 */
	public void setTruleInstanceMccPrimaryKey(
			java.lang.String truleInstanceMccPrimaryKey) {
		this.truleInstanceMccPrimaryKey = truleInstanceMccPrimaryKey;
		initTruleInstanceMcc();
	}

	public void initTruleInstanceMcc() {
		try {
			if (truleInstanceMccPrimaryKey == null
					|| truleInstanceMccPrimaryKey.equals("")) {
				return;
			}
			this.setTruleInstanceMcc(service
					.getTruleInstanceMcc(truleInstanceMccPrimaryKey));
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
	}

	/**
	 * 存储TruleInstanceMcc对象.
	 * 
	 * @return String.
	 */
	public String save() {
		try {
			if (truleInstanceMccPrimaryKey == null
					&& this.truleInstanceMcc.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getTruleInstanceMcc(this.truleInstanceMcc.getId()) != null) {
					addMessage("error.database.duplicatekey", "id["
							+ this.truleInstanceMcc.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleInstanceMccPrimaryKey == null
					|| truleInstanceMccPrimaryKey.equals(this.truleInstanceMcc
							.getId())) {
				this.truleInstanceMcc = service
						.saveTruleInstanceMcc(this.truleInstanceMcc);
				String key = truleInstanceMcc.getId();
				this.truleInstanceMccPrimaryKey = key;
				if (truleInstanceMccPrimaryKey == null) {
					addMessage("truleInstanceMcc.message.added",
							this.truleInstanceMcc.getId());
				} else {
					addMessage("truleInstanceMcc.message.saved",
							this.truleInstanceMcc.getId());
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
			TruleInstanceMcc truleInstanceMcc = new TruleInstanceMcc();
			this.truleInstanceMcc = truleInstanceMcc;
			truleInstanceMccPrimaryKey = null;
		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return null;
	}

	/**
	 * 删除TruleInstanceMcc对象.
	 * 
	 * @return String.
	 */
	public String delete() {
		try {
			service.delete(this.truleInstanceMcc.getId());
			CmsUtil.deleteFile("t_rule_instance_mcc/"
					+ this.truleInstanceMcc.getId());
			addMessage("truleInstanceMcc.message.deleted",
					this.truleInstanceMcc.getId());

		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	/**
	 * 删除TruleInstanceMcc对象 (子表有数据不允许删除）.
	 * 
	 * @return String.
	 */
	public String deleteOfNoChild() {
		try {
			TruleInstanceMcc truleInstanceMcc = service
					.getTruleInstanceMcc(this.truleInstanceMcc.getId());
			service.delete(this.truleInstanceMcc.getId());
			addMessage("truleInstanceMcc.message.deleted",
					this.truleInstanceMcc.getId());

		} catch (BeGenException e) {
			// TODO Auto-generated catch block
			this.addMessage(e.getCode(), e.getMsg(), e);
			return getFailureAction();
		}
		return getSuccessAction();
	}

	public String edit() {

		return getSuccessAction();
	}

	public String getHistoryUrlParameter() {
		if (this.truleInstanceMccPrimaryKey == null)
			return "_key=" + this.truleInstanceMcc.getId();
		return "_key=" + this.truleInstanceMccPrimaryKey;
	}

	public String popSave() {
		this.getRequest().getSession().setAttribute("__pop_object",
				this.truleInstanceMcc);
		this.getRequest().getSession().setAttribute("__pop_data_object",
				"TruleInstanceMcc");
		return "popSuccess";
	}

	public String saveAll() {
		try {
			if (truleInstanceMccPrimaryKey == null
					&& this.truleInstanceMcc.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getTruleInstanceMcc(this.truleInstanceMcc.getId()) != null) {
					addMessage("error.database.duplicatekey", "id["
							+ this.truleInstanceMcc.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleInstanceMccPrimaryKey == null
					|| truleInstanceMccPrimaryKey.equals(this.truleInstanceMcc
							.getId())) {

				this.truleInstanceMcc = service.saveAll(this.truleInstanceMcc);
				String key = truleInstanceMcc.getId();
				this.truleInstanceMccPrimaryKey = key;
				if (truleInstanceMccPrimaryKey == null) {
					addMessage("truleInstanceMcc.message.added",
							this.truleInstanceMcc.getId());
				} else {
					addMessage("truleInstanceMcc.message.saved",
							this.truleInstanceMcc.getId());
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
		return this.getSuccessAction();
	}

	public String saveMultiAll() {
		try {
			if (truleInstanceMccPrimaryKey == null
					&& this.truleInstanceMcc.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getTruleInstanceMcc(this.truleInstanceMcc.getId()) != null) {
					addMessage("error.database.duplicatekey", "id["
							+ this.truleInstanceMcc.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (truleInstanceMccPrimaryKey == null
					|| truleInstanceMccPrimaryKey.equals(this.truleInstanceMcc
							.getId())) {
				this.truleInstanceMcc = service.saveAll(this.truleInstanceMcc);

				String key = truleInstanceMcc.getId();
				this.truleInstanceMccPrimaryKey = key;
				if (truleInstanceMccPrimaryKey == null) {
					addMessage("truleInstanceMcc.message.added",
							this.truleInstanceMcc.getId());
				} else {
					addMessage("truleInstanceMcc.message.saved",
							this.truleInstanceMcc.getId());
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

		return this.getSuccessAction();
	}

	public void loadTruleInstanceMcc() {
		TruleInstanceMcc truleInstanceMcc = (TruleInstanceMcc) this
				.getRequest().getSession().getAttribute("__pop_object");
		this.truleInstanceMcc = truleInstanceMcc;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}

	public String loadTruleInstanceMccList() {
		try {

			TruleInstanceMccList truleInstanceMccList = new TruleInstanceMccList();
			TruleInstanceMccDAO truleInstanceMccDAO = (TruleInstanceMccDAO) getBean("truleInstanceMccDAO");
			TruleInstanceMcc truleInstanceMcc = new TruleInstanceMcc();
			List<TruleInstanceMcc> truleInstanceMccs = truleInstanceMccDAO
					.getTruleInstanceMccList(truleInstanceMcc);
			if (truleInstanceMcc.getId() != null
					|| !"".equals(truleInstanceMcc.getId())) {


				List<TruleInstanceMcc> TruleInstanceMccsNew = new ArrayList<TruleInstanceMcc>();
				for (TruleInstanceMcc mcc : truleInstanceMccs) {
					TruleInstanceMccsNew.add(mcc);
				}
				truleInstanceMccList.setTruleInstanceMccs(TruleInstanceMccsNew);

			} else {
				truleInstanceMccList.setTruleInstanceMccs(truleInstanceMccs);
			}
			this.setValueBinding("#{truleInstanceMccList}",
					truleInstanceMccList);

		} catch (BeGenException e) {
			// TODO: handle exception
			this.addMessage(e.getCode(), e.getMsg(), e);
		}
		return null;
	}

}
