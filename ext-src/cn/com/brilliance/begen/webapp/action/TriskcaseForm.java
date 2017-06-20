package cn.com.brilliance.begen.webapp.action;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

import javax.faces.component.html.HtmlDataTable;

import cn.com.brilliance.begen.dao.TmchntDAO;
import cn.com.brilliance.begen.dao.TorganizeInfoDAO;
import cn.com.brilliance.begen.dao.TriskcaseRulegroupDAO;
import cn.com.brilliance.begen.dao.TruleGroupDAO;
import cn.com.brilliance.begen.dao.TruleInstanceGroupDAO;
import cn.com.brilliance.begen.dao.TruleInstanceGroupSegmentDAO;
import cn.com.brilliance.begen.dao.TuserInfoDAO;
import cn.com.brilliance.begen.exception.BeGenException;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.service.*;
import cn.com.brilliance.begen.webapp.action.BasePage;
import cn.com.brilliance.begen.webapp.servlet.UserBean;
import cn.com.brilliance.begen.common.CmsUtil;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.webapp.action.FormPage;
import cn.com.brilliance.risk.ext.interfaces.DataManageController;

/**
 * Triskcase对象Form.
 * @author Administrator.
 *
 */
public class TriskcaseForm extends BasePage implements FormPage {

	private TriskcaseService service = (TriskcaseService)getBean("triskcaseService");
	
	private TmchntService mchntService = (TmchntService)getBean("tmchntService");
	
	private Double relativeAmt;
	
	private Double allAmt;
	
	private Map queryFields;

    private String lookupKey;        
	
    /**
     * triskcase对象.
     */
    private Triskcase triskcase;
    
    private Tmchnt tmchnt;
    
    private HtmlDataTable dataTable;
    
    private List ruleList;
    
    /**
     * Triskcase对象主键.
     */
    private java.lang.String triskcasePrimaryKey;
    
    private java.lang.String tmchntPrimaryKey;
	
	
	public String getLookupKey() {
		return lookupKey;
	}

	public void setLookupKey(String lookupKey) {
		this.lookupKey = lookupKey;
	}	

    /**
     * Returns the Triskcase.
     * @return Triskcase.
     */
    public Triskcase getTriskcase() {
    	if(triskcase == null) {
            triskcase = new Triskcase();
            setProcessLimitTime();
        } else {
        	if(this.triskcasePrimaryKey !=  null && !"".equals(this.triskcasePrimaryKey)) {
        		if(this.relativeAmt != null) {
        			if(this.relativeAmt != null) {
        				this.triskcase.setRelativeAmt(this.relativeAmt);
        			}
        			if(this.allAmt != null) {
        				this.triskcase.setAllAmt(this.allAmt);
        			}
        		}
        		setRuleGroupDesc();
        		setMchntMccOrAcquire();
        	} else {
        		setProcessLimitTime();
        	}
        }
        return triskcase;
    }
    
    private void setRuleGroupDesc() {
    	TruleGroupDAO truleGroupDAO = (TruleGroupDAO)getBean("truleGroupDAO");
    	if(this.triskcase.getRuleGroupId() != null) {
	    	TruleGroup truleGroup = truleGroupDAO.getTruleGroup(String.valueOf(this.triskcase.getRuleGroupId()));
	    	if(truleGroup != null) {
	    		this.triskcase.setTriggerContent(truleGroup.getDescription());
	    	}
    	}
    }
    
    private void setMchntMccOrAcquire() {
    	
    }
    
    private void setProcessLimitTime() {
		Calendar rightnow = Calendar.getInstance();
		rightnow.add(Calendar.DATE, 5);
		rightnow.setTime(rightnow.getTime());
		int x = rightnow.get(Calendar.DAY_OF_WEEK);
		if(x == 1) {
			rightnow.add(Calendar.DATE, 2);
		} else if(x == 7) {
			rightnow.add(Calendar.DATE, 2);
		}
		this.triskcase.setProcessLimit(rightnow.getTime());
    }
    
    

    /**
     * Sets the Triskcase.
     * @param triskcase The triskcase to set.
     */
    public void setTriskcase(Triskcase triskcase) {
        this.triskcase = triskcase;
    }

    /**
     * Returns the triskcasePrimaryKey.
     * @return TriskcasePrimaryKey.
     */
    public java.lang.String getTriskcasePrimaryKey() {
        return triskcasePrimaryKey;
    }

    /**
     * Sets the triskcasePrimaryKey.
     * @param triskcasePrimaryKey The TriskcasePrimaryKey to set.
     */
    public void setTriskcasePrimaryKey(java.lang.String triskcasePrimaryKey) {
		this.triskcasePrimaryKey = triskcasePrimaryKey;
		initTriskcase();
    }
	
	public void initTriskcase(){
        try {
            if (triskcasePrimaryKey == null || triskcasePrimaryKey.equals("")) {
                return;
            }
            this.setTriskcase(service.getTriskcase(triskcasePrimaryKey));
            if(getTmchntId() != null) {
            	this.setTmchnt(mchntService.getTmchnt(getTmchntId()));
            }
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
	}	
	
    public String loadChildOfTriskcaseRecord() {
        try {
            TriskcaseRecordList triskcaseRecordList = new TriskcaseRecordList();
			if(triskcase.getId() != null && !"".equals(triskcase.getId()) ){
			   TriskcaseRecord triskcaseRecord = new TriskcaseRecord();
	           triskcaseRecord.setRiskcaseId(this.triskcase.getId());
	           triskcaseRecordList.setTriskcaseRecord(triskcaseRecord);
			   triskcaseRecordList.initTriskcaseRecords();
            }
			else{
			   TriskcaseRecord triskcaseRecord = new TriskcaseRecord();
	           triskcaseRecordList.setTriskcaseRecord(triskcaseRecord);
               triskcaseRecordList.setTriskcaseRecords(new ArrayList<TriskcaseRecord>());				
			}
            this.setValueBinding("#{triskcaseRecordList}",triskcaseRecordList);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }
    public String loadChildOfTriskcaseAttachment() {
        try {
            TriskcaseAttachmentList triskcaseAttachmentList = new TriskcaseAttachmentList();            
			if(triskcase.getId() != null && !"".equals(triskcase.getId()) ){
			   TriskcaseAttachment triskcaseAttachment = new TriskcaseAttachment();
	           triskcaseAttachment.setRiskcaseId(this.triskcase.getId());
	           triskcaseAttachmentList.setTriskcaseAttachment(triskcaseAttachment);
			   triskcaseAttachmentList.initTriskcaseAttachments();
            }
			else{
			   TriskcaseAttachment triskcaseAttachment = new TriskcaseAttachment();
	           triskcaseAttachmentList.setTriskcaseAttachment(triskcaseAttachment);
               triskcaseAttachmentList.setTriskcaseAttachments(new ArrayList<TriskcaseAttachment>());				
			}
            this.setValueBinding("#{triskcaseAttachmentList}",triskcaseAttachmentList);
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
        }
        return null;
    }

    /**
     * 存储Triskcase对象.
     * @return String.
     */
    public String save() {
        try {
            if (triskcasePrimaryKey == null  && this.triskcase.getId() != null) {
                //判断记录是否重复，并提示错误信息
                if (service.getTriskcase(this.triskcase.getId()) != null) {
                    addMessage("error.database.duplicatekey", "ID[" + this.triskcase.getId() + "]");
                    return null;
                }
            }

           UserBean userBean = getUserBean();
            if (triskcasePrimaryKey == null || triskcasePrimaryKey.equals(this.triskcase.getId())) {
            	if(triskcasePrimaryKey == null) {
            		Long organizeIdByUserBean = Long.valueOf(getOrganizeIdByUserBean());
            		if(organizeIdByUserBean != null) {
            			this.triskcase.setCreateInst(organizeIdByUserBean);
            		} else {
            			this.addMessageString("当前用户不属于任何机构,无法提交案例!请联系系统管理员!");
            			return null;
            		}
            		if(this.triskcase.getComments1().length() >= 255) {
            			this.addMessageString("备注1的文字过长!");
            			return null;
            		}
            		if(this.triskcase.getComments2().length() >= 255) {
            			this.addMessageString("备注2的文字过长!");
            			return null;
            		}
            		if(this.triskcase.getComments3().length() >= 255) {
            			this.addMessageString("备注3的文字过长!");
            			return null;
            		}
            		if(this.triskcase.getComments4().length() >= 255) {
            			this.addMessageString("备注4的文字过长!");
            			return null;
            		}
            		if(this.triskcase.getComments5().length() >= 255) {
            			this.addMessageString("备注5的文字过长!");
            			return null;
            		}
            		
            		if(this.triskcase.getComments6() != null && this.triskcase.getComments6().length() >= 255) {
            			this.addMessageString("分公司部门意见的文字过长!");
            			return null;
            		}
            		if(this.triskcase.getComments7() != null && this.triskcase.getComments7().length() >= 255) {
            			this.addMessageString("分公司主管意见的文字过长!");
            			return null;
            		}
            		if(this.triskcase.getComments8() != null && this.triskcase.getComments8().length() >= 255) {
            			this.addMessageString("总公司意见的文字过长!");
            			return null;
            		}
            		if(this.triskcase.getRiskContent() != null && this.triskcase.getRiskContent().length() >=255) {
            			this.addMessageString("案例描述的文字过长!");
            			return null;
            		}
            		if(this.triskcase.getMchntMcc() != null && this.triskcase.getMchntMcc().length() >=255) {
            			this.addMessageString("商户MCC的文字过长!");
            			return null;
            		}
            		setSysInfo();
            	}
            	this.triskcase = service.saveTriskcase(this.triskcase);
                String key = triskcase.getId();
				this.triskcasePrimaryKey = key;
                if (triskcasePrimaryKey == null) {
                    addMessage("triskcase.message.added", this.triskcase.getId());				
                }
                else {
                    addMessage("triskcase.message.saved", this.triskcase.getId());					
                }		
                if(this.triskcase.getRelativeTransAmt() != null) {
                	this.setValueBinding("#{triskcaseForm.triskcase.addRelativeAmt}", Double.valueOf(this.triskcase.getRelativeTransAmt().doubleValue()/100));
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
        return getSuccessAction();
    }

    public String saveAndNew() {
        try {
            String action = save();
            if (action == null) {
                return null;
            }
            Triskcase triskcase = new Triskcase();
            this.triskcase = triskcase;
            triskcasePrimaryKey = null;
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return null;
    }
    /**
     * 删除Triskcase对象.
     * @return String.
     */
    public String delete() {
        try {
        	DataManageController dataManageController = (DataManageController) getBean("dataManageController");
    		String sql = "select create_inst from t_riskcase where id='" + triskcase.getId() + "'";
    		Map map = dataManageController.queryForMap(sql);
    		BigDecimal uploadInstBig = (BigDecimal)map.get("CREATE_INST");
    		String uploadInst = String.valueOf(uploadInstBig.intValue());
            UserBean userBean = getUserBean();
            TuserInfo tuserInfo = userBean.getTuserInfo();
            String currentOrganizeId = tuserInfo.getOrganizeId();
            if(triskcase.getCreateInst() != null && !"".equals(triskcase.getCreateInst())) {
            	if(getOrganizeValue(uploadInst, currentOrganizeId) == -1) {
    				this.addMessageString("您无权删除上级录入的案例!");
    				return null;
    			}
            }
            service.delete(this.triskcase.getId());
			CmsUtil.deleteFile("t_riskcase/"+this.triskcase.getId());
            addMessage("triskcase.message.deleted", this.triskcase.getId());
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }




    /**
     * 删除Triskcase对象    (子表有数据不允许删除）.
     * @return String.
     */
    public String deleteOfNoChild() {
        try {
            Triskcase triskcase = service.getTriskcase(this.triskcase.getId());
            if (triskcase.getTriskcaseRecordGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return getFailureAction();
            }
            if (triskcase.getTriskcaseAttachmentGroup().size() > 0) {
                this.addMessageString("exception.delete.cascade");
                return getFailureAction();
            }
            service.delete(this.triskcase.getId());
            addMessage("triskcase.message.deleted", this.triskcase.getId());	
		
        } catch (BeGenException e) {
            // TODO Auto-generated catch block
            this.addMessage(e.getCode(), e.getMsg(), e);
            return getFailureAction();
        }
        return getSuccessAction();
    }
	
    public String edit(){
        if("6".equals(triskcase.getStatus())) {
        	this.addMessageString("不能修改已结案的案例!");
        	return null;
        }
		if("0".equals(getOrganizeLevel(getOrganizeIdByUserBean())) && !"0".equals(triskcase.getStatus())) {
			this.addMessageString("该案例已派发,无法修改该案例的信息!");
			return null;
		}        
        DataManageController dataManageController = (DataManageController) getBean("dataManageController");
		String sql = "select create_inst from t_riskcase where id='" + triskcase.getId() + "'";
		Map map = dataManageController.queryForMap(sql);
		BigDecimal uploadInstBig = (BigDecimal)map.get("CREATE_INST");
		String uploadInst = "0";
		if(uploadInstBig != null) {
			uploadInst = String.valueOf(uploadInstBig.intValue());
		}
        UserBean userBean = getUserBean();
        TuserInfo tuserInfo = userBean.getTuserInfo();
        String currentOrganizeId = tuserInfo.getOrganizeId();
        if(triskcase.getCreateInst() != null && !"".equals(triskcase.getCreateInst())) {
        	if(getOrganizeValue(uploadInst, currentOrganizeId) == -1) {
				this.addMessageString("您无权编辑上级机构录入的案例!");
				return null;
			}
			if("1".equals(getOrganizeLevel(getOrganizeIdByUserBean())) && (!"0".equals(triskcase.getStatus()) && !"1".equals(triskcase.getStatus()))) {
				this.addMessageString("该案例已在处理状态,无法修改该案例的信息!");
				return null;
			}
        }
    	return getSuccessAction();
    }	

    public String getHistoryUrlParameter(){
    	if(this.triskcasePrimaryKey == null)
    		return "_key=" + this.triskcase.getId();
    	return "_key=" + this.triskcasePrimaryKey;
    }
	
	    
    public String popSave(){
    	this.getRequest().getSession().setAttribute("__pop_object", this.triskcase);
		this.getRequest().getSession().setAttribute("__pop_data_object", "Triskcase");
		return "popSuccess";
    }
	
    public String saveAll() {
		try {
			if (triskcasePrimaryKey == null && this.triskcase.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getTriskcase(this.triskcase.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.triskcase.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (triskcasePrimaryKey == null
					|| triskcasePrimaryKey.equals(this.triskcase.getId())) {

				TriskcaseRecordList triskcaseRecordList = (TriskcaseRecordList) this
						.getValueBinding("#{triskcaseRecordList}");
				TriskcaseAttachmentList triskcaseAttachmentList = (TriskcaseAttachmentList) this
						.getValueBinding("#{triskcaseAttachmentList}");
				this.triskcase = service.saveAll(this.triskcase,
						triskcaseRecordList.getDeleteList(),
						triskcaseRecordList.getTriskcaseRecords(),
						triskcaseAttachmentList.getDeleteList(),
						triskcaseAttachmentList.getTriskcaseAttachments());
				String key = triskcase.getId();
				this.triskcasePrimaryKey = key;
				if (triskcasePrimaryKey == null) {
					addMessage("triskcase.message.added", this.triskcase
							.getId());
				} else {
					addMessage("triskcase.message.saved", this.triskcase
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
		return this.getSuccessAction();
	}	

    public String saveMultiAll() {
		try {
			if (triskcasePrimaryKey == null && this.triskcase.getId() != null) {
				// 判断记录是否重复，并提示错误信息
				if (service.getTriskcase(this.triskcase.getId()) != null) {
					addMessage("error.database.duplicatekey", "ID["
							+ this.triskcase.getId() + "]");
					return null;
				}
			}

			UserBean userBean = getUserBean();
			if (triskcasePrimaryKey == null
					|| triskcasePrimaryKey.equals(this.triskcase.getId())) {
				TriskcaseRecordList triskcaseRecordList = (TriskcaseRecordList) this
						.getValueBinding("#{triskcaseRecordList}");
				List<TriskcaseRecord> triskcaseRecords = triskcaseRecordList
						.getTriskcaseRecords();
				List<TriskcaseRecord> triskcaseRecordLists = new ArrayList<TriskcaseRecord>();
				for (TriskcaseRecord triskcaseRecord : triskcaseRecords) {
					if (triskcaseRecord.get_edit_flag() != TriskcaseRecord.EDIT_FLAG_EDIT) {
						triskcaseRecord
								.set_edit_flag(TriskcaseRecord.EDIT_FLAG_EDIT);
					}
					triskcaseRecordLists.add(triskcaseRecord);
				}

				TriskcaseAttachmentList triskcaseAttachmentList = (TriskcaseAttachmentList) this
						.getValueBinding("#{triskcaseAttachmentList}");
				List<TriskcaseAttachment> triskcaseAttachments = triskcaseAttachmentList
						.getTriskcaseAttachments();
				List<TriskcaseAttachment> triskcaseAttachmentLists = new ArrayList<TriskcaseAttachment>();
				for (TriskcaseAttachment triskcaseAttachment : triskcaseAttachments) {
					if (triskcaseAttachment.get_edit_flag() != TriskcaseAttachment.EDIT_FLAG_EDIT) {
						triskcaseAttachment
								.set_edit_flag(TriskcaseAttachment.EDIT_FLAG_EDIT);
					}
					triskcaseAttachmentLists.add(triskcaseAttachment);
				}

				this.triskcase = service.saveAll(this.triskcase,
						triskcaseRecordList.getDeleteList(),
						triskcaseRecordLists, triskcaseAttachmentList
								.getDeleteList(), triskcaseAttachmentLists);

				String key = triskcase.getId();
				this.triskcasePrimaryKey = key;
				if (triskcasePrimaryKey == null) {
					addMessage("triskcase.message.added", this.triskcase
							.getId());
				} else {
					addMessage("triskcase.message.saved", this.triskcase
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

		return this.getSuccessAction();
	}	
	
	private void saveTriskcaseRecord(){
    	TriskcaseRecordList triskcaseRecordList = (TriskcaseRecordList)this.getValueBinding("#{triskcaseRecordList}");
    	triskcaseRecordList.saveAllOfTriskcase(triskcase.getId());
    }	
	private void saveTriskcaseAttachment(){
    	TriskcaseAttachmentList triskcaseAttachmentList = (TriskcaseAttachmentList)this.getValueBinding("#{triskcaseAttachmentList}");
    	triskcaseAttachmentList.saveAllOfTriskcase(triskcase.getId());
    }	

	public void loadTriskcase(){	
		Triskcase triskcase = (Triskcase)this.getRequest().getSession().getAttribute("__pop_object");
		this.triskcase = triskcase;
		this.getRequest().getSession().removeAttribute("__pop_object");
	}
	
	private void setSysInfo() {
		String caseno = getOrganizeBm() + getFormatDate("yyyyMMdd",new Date()) + this.triskcase.getCasefrom() + getSequence();
		if(this.triskcase.getRelativeTransAmt() != null && !"".equals(this.triskcase.getRelativeTransAmt())) {
			this.triskcase.setAddRelativeAmt(this.triskcase.getRelativeTransAmt());
			this.triskcase.setRelativeTransAmt(this.triskcase.getRelativeTransAmt()*100);
		}
		if(this.triskcase.getAllTransAmt() != null && !"".equals(this.triskcase.getAllTransAmt())) {
			this.triskcase.setAllTransAmt(this.triskcase.getAllTransAmt()*100);
		}
		this.triskcase.setCaseno(caseno);
		this.triskcase.setUrgentCnt(0);
		this.triskcase.setBackCnt(0);
		String createDateStr = getFormatDate("yyyy-MM-dd", new Date());
		try {
			if("0".equals(this.triskcase.getStatus())) {
				this.triskcase.setProcessLimit(null);
			} 
			this.triskcase.setCreatedate(stringToDate(createDateStr));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			this.triskcase.setCreatedate(new Date());
		}
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
	
	private String getSequence() {
		DataManageController dataManageController = (DataManageController)getBean("dataManageController");
		Map map = dataManageController.queryForMap("select riskcase_seq.nextval from dual");
		BigDecimal value = (BigDecimal)map.get("nextval");
		Format format = new DecimalFormat("0000");
		String sequence = "0001";
		if(value != null) {
			sequence = format.format(value.intValue());
		}
		return sequence;
	}
	
	private String getOrganizeIdByUserBean() {
		UserBean userBean = getUserBean();
		TuserInfo tuserInfo = userBean.getTuserInfo();
		return tuserInfo.getOrganizeId();
	}
	
	private TorganizeInfo getTorganizeInfoBean(String id) {
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO)getBean("torganizeInfoDAO");
		TorganizeInfo torganizeInfo = torganizeInfoDAO.getTorganizeInfo(id);
		return torganizeInfo;
	}
	
	private String getOrganizeBm() {
		TorganizeInfo torganizeInfo = getTorganizeInfoBean(this.triskcase.getBelongToInst());
		String bm = torganizeInfo.getOrganizeBm();
		if(bm.length() > 6) {
			bm = bm.substring(0,6);
		}
		return bm;
	}
	
	private int getOrganizeValue(String uploadInst,String currentOrganizeId) {
		Integer currentLevel = getOrganizeLevel(currentOrganizeId);
		Integer uploadLevel = getOrganizeLevel(uploadInst);
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

	public HtmlDataTable getDataTable() {
		return dataTable;
	}

	public void setDataTable(HtmlDataTable dataTable) {
		this.dataTable = dataTable;
	}

	public List getRuleList() {
		List<ExtTruleInstanceGroupSegment> itemList = new ArrayList<ExtTruleInstanceGroupSegment>();
		if(this.triskcase.getRuleGroupId() != null) {
			TruleInstanceGroupDAO truleInstanceGroupDAO = (TruleInstanceGroupDAO)getBean("truleInstanceGroupDAO");
			TruleInstanceGroup truleInstanceGroup = new TruleInstanceGroup();
			truleInstanceGroup.setRuleGroupId(String.valueOf(this.triskcase.getRuleGroupId()));
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
		String begin = "";
		String end = "";
		if (this.triskcase.getBeginDate() != null) {
			begin = getFormatDate("yyyy-MM-dd", this.triskcase.getBeginDate());
		}
		if (this.triskcase.getEndDate() != null) {
			end = getFormatDate("yyyy-MM-dd", this.triskcase.getEndDate());
		}
		DataManageController dataManageController = (DataManageController) getBean("dataManageController");
		String sql = "select rate from t_mchnt_rule_instance where mchnt_cd='"
				+ this.triskcase.getMchntCd() + "' and rule_instance='"
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
		tmchnt.setMerchantno(triskcase.getMchntCd());
		List list = tmchntDAO.getTmchntList(tmchnt);
		if(list != null && list.size() > 0) {
			tmchnt = (Tmchnt)list.get(0);
		}
		return tmchnt.getId();
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

	public Map getQueryFields() {
		return queryFields;
	}

	public void setQueryFields(Map queryFields) {
		this.queryFields = queryFields;
	}
	
	public String back() {
		this.setValueBinding("#{triskcaseList.queryFields}", this.queryFields);
		this.setValueBinding("#{triskcaseList.saveQueryFiellds}", this.queryFields);
		return this.getSuccessAction();
	}

	public Double getAllAmt() {
		return allAmt;
	}

	public void setAllAmt(Double allAmt) {
		this.allAmt = allAmt;
	}

	public Double getRelativeAmt() {
		return relativeAmt;
	}

	public void setRelativeAmt(Double relativeAmt) {
		this.relativeAmt = relativeAmt;
	}
	
}
