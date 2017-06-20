package cn.com.brilliance.begen.webapp.action;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

import javax.faces.component.html.HtmlDataTable;

import org.apache.myfaces.custom.fileupload.UploadedFile;

import cn.com.brilliance.begen.dao.TmchntDAO;
import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.dao.TriskcaseDAO;
import cn.com.brilliance.begen.dao.TruleInstanceGroupDAO;
import cn.com.brilliance.begen.dao.TruleInstanceGroupSegmentDAO;
import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.webapp.action.FormPage;
import cn.com.brilliance.risk.ext.interfaces.DataManageController;

/**
 * TriskcaseRecord对象Form.
 * @author Administrator.
 *
 */
public class TriskcaseRecordForm extends BasePage implements FormPage {

	private TriskcaseRecordService service = (TriskcaseRecordService)getBean("triskcaseRecordService");
	
	private TriskcaseService riskcaseService = (TriskcaseService)getBean("triskcaseService");
	
	private TmchntService mchntService = (TmchntService)getBean("tmchntService");

    private String lookupKey;        
	
    private Map queryFields;
    /**
     * triskcaseRecord对象.
     */
    private TriskcaseRecord triskcaseRecord;
    
    private Triskcase triskcase;
    
    private Tmchnt tmchnt;

    private HtmlDataTable dataTable;
    
    private List ruleList;
    /**
     * TriskcaseRecord对象主键.
     */
    private java.lang.String triskcaseRecordPrimaryKey;
    
    private java.lang.String triskcasePrimaryKey;
    
    private java.lang.String tmchntPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the TriskcaseRecord.
     * @return TriskcaseRecord.
     */
    public TriskcaseRecord getTriskcaseRecord() {
        if(triskcaseRecord == null) {
            triskcaseRecord = new TriskcaseRecord();
        }
        return triskcaseRecord;
    }

    /**
     * Sets the TriskcaseRecord.
     * @param triskcaseRecord The triskcaseRecord to set.
     */
    public void setTriskcaseRecord(TriskcaseRecord triskcaseRecord) {
        this.triskcaseRecord = triskcaseRecord;
    }

    /**
     * Returns the triskcaseRecordPrimaryKey.
     * @return TriskcaseRecordPrimaryKey.
     */
    public java.lang.String getTriskcaseRecordPrimaryKey() {
        return triskcaseRecordPrimaryKey;
    }

    /**
     * Sets the triskcaseRecordPrimaryKey.
     * @param triskcaseRecordPrimaryKey The TriskcaseRecordPrimaryKey to set.
     */
    public void setTriskcaseRecordPrimaryKey(java.lang.String triskcaseRecordPrimaryKey) {
		this.triskcaseRecordPrimaryKey = triskcaseRecordPrimaryKey;
		initTriskcaseRecord();
    }
	
	public void initTriskcaseRecord(){
        try {
            if (triskcaseRecordPrimaryKey == null || triskcaseRecordPrimaryKey.equals("")) {
            	if(getTmchntId() != null) {
            		this.setTmchnt(mchntService.getTmchnt(getTmchntId()));
            	}
                return;
            }
            this.setTriskcaseRecord(service.getTriskcaseRecord(triskcaseRecordPrimaryKey)); 
        	if(getTmchntId() != null) {
        		this.setTmchnt(mchntService.getTmchnt(getTmchntId()));
        	}
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	

	public List getRuleList() {
		Triskcase triskcase = this.triskcaseRecord.getRiskcaseIdOfTriskcase();
		List<ExtTruleInstanceGroupSegment> itemList = new ArrayList<ExtTruleInstanceGroupSegment>();
		if(triskcase.getRuleGroupId() != null) {
			TruleInstanceGroupDAO truleInstanceGroupDAO = (TruleInstanceGroupDAO)getBean("truleInstanceGroupDAO");
			TruleInstanceGroup truleInstanceGroup = new TruleInstanceGroup();
			truleInstanceGroup.setRuleGroupId(String.valueOf(triskcase.getRuleGroupId()));
			List list = truleInstanceGroupDAO.getTruleInstanceGroupList(truleInstanceGroup);
			for(int i = 0; i < list.size(); i++) {
				truleInstanceGroup = (TruleInstanceGroup)list.get(i);
				String id = truleInstanceGroup.getId();
				TruleInstanceGroupSegmentDAO truleInstanceGroupSegmentDAO = (TruleInstanceGroupSegmentDAO)getBean("truleInstanceGroupSegmentDAO");
				TruleInstanceGroupSegment truleInstanceGroupSegment = new TruleInstanceGroupSegment();
				truleInstanceGroupSegment.setRuleInstanceGroupId(id);
				List segmentList = truleInstanceGroupSegmentDAO.getTruleInstanceGroupSegmentList(truleInstanceGroupSegment);
				itemList.add(setNewSegment((TruleInstanceGroupSegment)segmentList.get(0)));
			}
		}
		return itemList;
	}

	public void setRuleList(List ruleList) {
		this.ruleList = ruleList;
	}
	
	private ExtTruleInstanceGroupSegment setNewSegment(TruleInstanceGroupSegment truleInstanceGroupSegmen) {
		ExtTruleInstanceGroupSegment extTruleInstanceGroupSegment = new ExtTruleInstanceGroupSegment();
		extTruleInstanceGroupSegment.setRuleInstanceId(truleInstanceGroupSegmen.getRuleInstanceGroupIdOfTruleInstanceGroup().getRuleInstanceId());
		extTruleInstanceGroupSegment.setBegin(truleInstanceGroupSegmen.getBegin());
		extTruleInstanceGroupSegment.setEnd(truleInstanceGroupSegmen.getEnd());
		extTruleInstanceGroupSegment.setValue(truleInstanceGroupSegmen.getValue());
		extTruleInstanceGroupSegment.setRate(getRate(truleInstanceGroupSegmen.getRuleInstanceId()));
		return extTruleInstanceGroupSegment;
	}
	
	private Float getRate(String ruleInstanceId) {
		Triskcase triskcase = this.triskcaseRecord.getRiskcaseIdOfTriskcase();
		String begin = "";
		String end = "";
		if (triskcase.getBeginDate() != null) {
			begin = getFormatDate("yyyy-MM-dd", triskcase.getBeginDate());
		}
		if (triskcase.getEndDate() != null) {
			end = getFormatDate("yyyy-MM-dd", triskcase.getEndDate());
		}
		DataManageController dataManageController = (DataManageController) getBean("dataManageController");
		String sql = "select rate from t_mchnt_rule_instance where mchnt_cd='"
				+ triskcase.getMchntCd() + "' and rule_instance='"
				+ ruleInstanceId + "' and begin_date=to_date('" + begin
				+ "','yyyy-MM-dd') and end_date=to_date('" + end
				+ "','yyyy-MM-dd')";
		List list = dataManageController.queryForList(sql);
		if (list != null && list.size() > 0) {
			Map map = (Map) list.get(0);
			BigDecimal bigDecimal = (BigDecimal) map.get("RATE");
			return bigDecimal.floatValue();
		}
		return null;
	}

	private String getTmchntId() {
		TmchntDAO tmchntDAO = (TmchntDAO)getBean("tmchntDAO");
		Tmchnt tmchnt = new Tmchnt();
		Triskcase triskcase = this.triskcaseRecord.getRiskcaseIdOfTriskcase();
		if(triskcase != null) {
			tmchnt.setMerchantno(triskcase.getMchntCd());
			List list = tmchntDAO.getTmchntList(tmchnt);
			if(list != null && list.size() > 0) {
				tmchnt = (Tmchnt)list.get(0);
			}
			return tmchnt.getId();
			}
		return null;
	}

    /**
     * 存储TriskcaseRecord对象.
     * @return String.
     */
    public String save() {
        try {
            if (triskcaseRecordPrimaryKey == null  && this.triskcaseRecord.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseRecord(this.triskcaseRecord.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseRecord.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseRecordPrimaryKey == null || triskcaseRecordPrimaryKey.equals(this.triskcaseRecord.getId())) {
            	TuserInfo tuserInfo = userBean.getTuserInfo();
            	this.triskcaseRecord.setUserId(tuserInfo.getId());
            	String createDateStr = getFormatDate("yyyy-MM-dd", new Date());
            	this.triskcaseRecord.setCreateDate(stringToDate(createDateStr));
            	this.triskcaseRecord.setIsLocked(Boolean.FALSE);
            	setPageValue();
            	this.triskcaseRecord = service.saveTriskcaseRecord(this.triskcaseRecord);
                String key = triskcaseRecord.getId();
				this.triskcaseRecordPrimaryKey = key;
                if (triskcaseRecordPrimaryKey == null) {
                    addMessage("triskcaseRecord.message.added", this.triskcaseRecord.getId());				
                }
                else {
                    addMessage("triskcaseRecord.message.saved", this.triskcaseRecord.getId());					
                }	
                this.setValueBinding("#{triskcaseForm.triskcasePrimaryKey}", this.triskcaseRecord.getRiskcaseId());
                this.setValueBinding("#{triskcaseForm.queryFields}", this.queryFields);
            }
            else {
                addMessageString("exception.save.primarykey");
                return null;
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return getSuccessAction();
    }

    public String saveAndNew() {
        try {
            String action = save();
            if (action == null) {
                return null;
            }
            TriskcaseRecord triskcaseRecord = new TriskcaseRecord();
            triskcaseRecord.setRiskcaseId(this.triskcaseRecord.getRiskcaseId());
            this.triskcaseRecord = triskcaseRecord;
            triskcaseRecordPrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除TriskcaseRecord对象.
     * @return String.
     */
    public String delete() {
        try {
        	if(this.triskcaseRecord.getSubmit()) {
            	this.addMessageString("该处理结果已被锁定,不能删除!");
            	return null;
        	}
//            String uploadUserId = triskcaseRecord.getUserId();
//            if(isCloseCase(this.triskcaseRecord.getRiskcaseId())) {
//            	this.addMessageString("不能删除已结案案例的登记要素!");
//            	return null;
//            }            
//            UserBean userBean = getUserBean();
//            TuserInfo tuserInfo = userBean.getTuserInfo();
//            String currentOrganizeId = tuserInfo.getOrganizeId();
//            Integer currentLevel = this.getOrganizeLevel(currentOrganizeId);
//            if(triskcaseRecord.getSubmit() != null) {
//                if (getOrganizeValue(uploadUserId, currentOrganizeId) == 0
//    					&& triskcaseRecord.getSubmit() && currentLevel.intValue() != 1) {
//    				this.addMessageString("您不能删除已提交的登记要素!");
//    				return null;
//    			} else if(getOrganizeValue(uploadUserId, currentOrganizeId) == -1) {
//    				this.addMessageString("您无权删除上级机构上传的登记要素!");
//    				return null;
//    			}
//            }
            service.delete(this.triskcaseRecord.getId());
			CmsUtil.deleteFile("t_riskcase_record/"+this.triskcaseRecord.getId());
            addMessage("triskcaseRecord.message.deleted", this.triskcaseRecord.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除TriskcaseRecord对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            TriskcaseRecord triskcaseRecord = service.getTriskcaseRecord(this.triskcaseRecord.getId());
            service.delete(this.triskcaseRecord.getId());
            addMessage("triskcaseRecord.message.deleted", this.triskcaseRecord.getId());	
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }
	
    public String edit(){
    	if(this.triskcaseRecord.getSubmit()) {
        	this.addMessageString("该处理结果已被锁定,请重新增加处理结果!");
        	return null;
    	}
//        String uploadUserId = triskcaseRecord.getUserId();
//        if(isCloseCase(this.triskcaseRecord.getRiskcaseId())) {
//        	this.addMessageString("不能修改已结案案例的登记要素!");
//        	return null;
//        }
//        UserBean userBean = getUserBean();
//        TuserInfo tuserInfo = userBean.getTuserInfo();
//        String currentOrganizeId = tuserInfo.getOrganizeId();
//        Integer currentLevel = this.getOrganizeLevel(currentOrganizeId);
//        if(triskcaseRecord.getSubmit() != null) {
//            if (getOrganizeValue(uploadUserId, currentOrganizeId) == 0
//					&& triskcaseRecord.getSubmit() && currentLevel.intValue() != 1) {
//				this.addMessageString("您不能编辑已提交的登记要素!");
//				return null;
//			} else if(getOrganizeValue(uploadUserId, currentOrganizeId) == -1) {
//				this.addMessageString("您无权编辑上级机构上传的登记要素!");
//				return null;
//			}
//        }
    	return getSuccessAction();
    }	

    public String getHistoryUrlParameter(){
    	if(this.triskcaseRecordPrimaryKey == null)
    		return "_key=" + this.triskcaseRecord.getId();
    	return "_key=" + this.triskcaseRecordPrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.triskcaseRecord);
		this.getRequest().getSession().setAttribute("__pop_data_object", "TriskcaseRecord");
		return "popSuccess";
    }
	
    public String saveAll(){
       try {
            if (triskcaseRecordPrimaryKey == null  && this.triskcaseRecord.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseRecord(this.triskcaseRecord.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseRecord.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseRecordPrimaryKey == null || triskcaseRecordPrimaryKey.equals(this.triskcaseRecord.getId())) {
  
                this.triskcaseRecord = service.saveAll(this.triskcaseRecord);
                String key = triskcaseRecord.getId();
				this.triskcaseRecordPrimaryKey = key;
                if (triskcaseRecordPrimaryKey == null) {
                    addMessage("triskcaseRecord.message.added", this.triskcaseRecord.getId());				
                }
                else {
                    addMessage("triskcaseRecord.message.saved", this.triskcaseRecord.getId());					
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
            if (triskcaseRecordPrimaryKey == null  && this.triskcaseRecord.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcaseRecord(this.triskcaseRecord.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcaseRecord.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcaseRecordPrimaryKey == null || triskcaseRecordPrimaryKey.equals(this.triskcaseRecord.getId())) {
                this.triskcaseRecord = service.saveAll(this.triskcaseRecord);

                String key = triskcaseRecord.getId();
				this.triskcaseRecordPrimaryKey = key;
                if (triskcaseRecordPrimaryKey == null) {
                    addMessage("triskcaseRecord.message.added", this.triskcaseRecord.getId());				
                }
                else {
                    addMessage("triskcaseRecord.message.saved", this.triskcaseRecord.getId());					
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
	

	public void loadTriskcaseRecord(){	
		TriskcaseRecord triskcaseRecord = (TriskcaseRecord)this.getRequest().getSession().getAttribute("__pop_object");
		this.triskcaseRecord = triskcaseRecord;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
	
	private int getOrganizeValue(String userId,String currentOrganizeId) {
		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO)getBean("tuserInfoDAO");
		TuserInfo tuserInfo = tuserInfoDAO.getTuserInfo(userId);
		String uploadOrganizeId = tuserInfo.getOrganizeId();
		Integer currentLevel = getOrganizeLevel(currentOrganizeId);
		Integer uploadLevel = getOrganizeLevel(uploadOrganizeId);
		if(currentLevel.compareTo(uploadLevel) == -1) {
			return 1;
		} else if(currentLevel.compareTo(uploadLevel) == 0) {
			return 0;
		} else {
			return -1;
		}
	}
	
	private Integer getOrganizeLevel(String organizeId) {
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO.getTorganizeInfo(organizeId);
		return torganizeInfo.getOrganizeLevel();
	}
	
	private String getFormatDate(String format,Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String str = sdf.format(date);
		return str;
	}	
	
	private Date stringToDate(String dateStr) throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = (Date)df.parse(dateStr);
		return date;
	}
	
	   /**
     * Returns the List.
     * Form域类型为多项列表时，进行数据类型转换，选项值之间以分号分割
     * @return List.
     */
    public List getInvestigationWay() {
           List list  = new ArrayList();
        try {
            if (this.triskcaseRecord.getInvestigationWay() == null)
                return null;
            String array[] = this.triskcaseRecord.getInvestigationWay().split(";");
            for(int i = 0; i < array.length; i++) {
                list.add(array[i]);
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return list;
    }

    /**
     * Sets the List.
     * Form域类型为多项列表时，进行数据类型转换，选项值之间以分号分割
     * @param investigationWay.
     */
    public void setInvestigationWay(List investigationWay) {
        String str = "";
        for(int i = 0; i < investigationWay.size(); i++) {
            str = str + investigationWay.get(i) + ";";
        }
        triskcaseRecord.setInvestigationWay(str);
    }
    /**
     * Returns the List.
     * Form域类型为多项列表时，进行数据类型转换，选项值之间以分号分割
     * @return List.
     */
    public List getProcessType() {
           List list  = new ArrayList();
        try {
            if (this.triskcaseRecord.getProcessType() == null)
                return null;
            String array[] = this.triskcaseRecord.getProcessType().split(";");
            for(int i = 0; i < array.length; i++) {
                list.add(array[i]);
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return list;
    }

    /**
     * Sets the List.
     * Form域类型为多项列表时，进行数据类型转换，选项值之间以分号分割
     * @param processType.
     */
    public void setProcessType(List processType) {
        String str = "";
        for(int i = 0; i < processType.size(); i++) {
            str = str + processType.get(i) + ";";
        }
        triskcaseRecord.setProcessType(str);
    }	
    
    private void setPageValue() {
    	if(this.getInvestigationWay() != null && this.getInvestigationWay().size() > 0) {
    		if(!this.getInvestigationWay().contains("3")) {
    			this.triskcaseRecord.setOtherInvestigationWay(null);
    		}
    	}
    	if(!this.triskcaseRecord.getIsPickFlow()) {
    		this.triskcaseRecord.setPickAmt(null);
    		this.triskcaseRecord.setPickCnt(null);
    		this.triskcaseRecord.setPick180Amt(null);
    		this.triskcaseRecord.setPick180Cnt(null);
    		this.triskcaseRecord.setPickStatus(null);
    		this.triskcaseRecord.setPickEmptyCnt(null);
    		this.triskcaseRecord.setPickFlawCnt(null);
    	} else{
        	if(!"1".equals(this.triskcaseRecord.getPickStatus())) {
        		this.triskcaseRecord.setPickFlawCnt(null);
        	} 
        	if(!"2".equals(this.triskcaseRecord.getPickStatus())) {
        		this.triskcaseRecord.setPickEmptyCnt(null);
        	}
    	}
    	if("0".equals(this.triskcaseRecord.getInvestigationResult())) {
    		this.triskcaseRecord.setRiskLevel(null);
    		this.triskcaseRecord.setRiskType(null);
    		this.triskcaseRecord.setProcess2Type(null);
    		this.triskcaseRecord.setProcessType(null);
    		this.triskcaseRecord.setProcessFreezeAmt(null);
    		this.triskcaseRecord.setProcessWithdrawCnt(null);
    		this.triskcaseRecord.setOtherProcessType(null);
    		this.triskcaseRecord.setOtherRiskType(null);
    	} else {
        	if(!"4".equals(this.triskcaseRecord.getRiskType())) {
        		this.triskcaseRecord.setOtherRiskType(null);
        	}
        	if(this.getProcessType() != null && this.getProcessType().size() > 0) {
        		if(!this.getProcessType().contains("11")) {
        			this.triskcaseRecord.setProcessFreezeAmt(null);
        		}
        		if(!this.getProcessType().contains("12")) {
        			this.triskcaseRecord.setProcessWithdrawCnt(null);
        		}
        		if(!this.getProcessType().contains("13")) {
        			this.triskcaseRecord.setOtherProcessType(null);
        		}
        	}
    	}
    }
    
	private boolean isCloseCase(String riskcaseId) {
		TriskcaseDAO triskcaseDAO = (TriskcaseDAO)getBean("triskcaseDAO");
		Triskcase triskcase = triskcaseDAO.getTriskcase(riskcaseId);
		if("6".equals(triskcase.getStatus())) {
			return true;
		}
		return false;
	}

	public Triskcase getTriskcase() {
		return triskcase;
	}

	public void setTriskcase(Triskcase triskcase) {
		this.triskcase = triskcase;
	}

	public java.lang.String getTriskcasePrimaryKey() {
		return triskcasePrimaryKey;
	}

	public void setTriskcasePrimaryKey(java.lang.String triskcasePrimaryKey) {
		this.triskcasePrimaryKey = triskcasePrimaryKey;
	}

	public Tmchnt getTmchnt() {
		return tmchnt;
	}

	public void setTmchnt(Tmchnt tmchnt) {
		this.tmchnt = tmchnt;
	}

	public java.lang.String getTmchntPrimaryKey() {
		return tmchntPrimaryKey;
	}

	public void setTmchntPrimaryKey(java.lang.String tmchntPrimaryKey) {
		this.tmchntPrimaryKey = tmchntPrimaryKey;
	}

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public Map getQueryFields() {
		return queryFields;
	}

	public void setQueryFields(Map queryFields) {
		this.queryFields = queryFields;
	}
	
	public String back() {
		this.setValueBinding("#{triskcaseForm.queryFields}", this.queryFields);
		this.setValueBinding("#{triskcaseForm.triskcasePrimaryKey}", this.triskcaseRecord.getRiskcaseId());
		this.setValueBinding("#{triskcaseRecordForm.triskcaseRecordPrimaryKey}", this.triskcaseRecordPrimaryKey);
		return this.getSuccessAction();
	}
}
