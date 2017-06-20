package cn.com.brilliance.begen.common;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.dao.*;
import cn.com.brilliance.begen.model.*;
import cn.com.brilliance.begen.webapp.listener.ContextLoaderListener;
 
public class ReportTools {

	public static final java.lang.String getSelectItemValue(java.lang.String fieldid, Object item) {
		String itemname = null;
        String itemcode = "";
        if(item instanceof String) {
            itemcode = (String)item;
        }
		SysFieldDAO sysFieldDAO = (SysFieldDAO) ContextLoaderListener
				.getApplicationContext().getBean("sysFieldDAO");
		SysField sysField = sysFieldDAO.getSysField(fieldid);
		String selectItem = sysField.getSelectItem();
		if (selectItem == null)
			return itemcode;
		if (itemcode == null)
			return itemcode;
		itemcode = itemcode.trim();
		int pos = selectItem.indexOf(itemcode);
		if (pos < 0)
			return itemcode;
		pos = selectItem.indexOf(",", pos);
		selectItem = selectItem.substring(pos + 1);
		int posfix = selectItem.indexOf('\r');
		if (posfix <= 0)
			return selectItem;
		itemname = selectItem.substring(0, posfix);
		return itemname;
	}
	
//  start:  Generated for sys_message From Template: ReportTools.java.vm


	public static final String getSysMessageItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		SysMessageDAO sysMessageDAO = (SysMessageDAO) Tools.getBean("sysMessageDAO");
		List list = sysMessageDAO.getSysMessageList(new SysMessage());
		for(int i=0;i<list.size();i++) {
			SysMessage sysMessage = (SysMessage)list.get(i);
			itemMap.put(String.valueOf(sysMessage.getId()),String.valueOf(sysMessage.getId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getSysMessageCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;








	itemMap= new HashMap<String, String>();
		itemMap.put("3", "�ռ�����վ");
		itemMap.put("2", "������");
		itemMap.put("4", "��������վ");
		itemMap.put("1", "�ռ���");
				itemsMap.put("syst02000026ums_risk", itemMap);
		    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for sys_message From Template: ReportTools.java.vm
//  start:  Generated for sys_workflow_ins_proc From Template: ReportTools.java.vm


	public static final String getSysWorkflowInsProcItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		SysWorkflowInsProcDAO sysWorkflowInsProcDAO = (SysWorkflowInsProcDAO) Tools.getBean("sysWorkflowInsProcDAO");
		List list = sysWorkflowInsProcDAO.getSysWorkflowInsProcList(new SysWorkflowInsProc());
		for(int i=0;i<list.size();i++) {
			SysWorkflowInsProc sysWorkflowInsProc = (SysWorkflowInsProc)list.get(i);
			itemMap.put(String.valueOf(sysWorkflowInsProc.getId()),String.valueOf(sysWorkflowInsProc.getId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getSysWorkflowInsProcCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;



	itemMap= new HashMap<String, String>();
		itemMap.put("2", "����(ͨ��)");
		itemMap.put("0", "�");
		itemMap.put("1", "����(�ܾ�)");
				itemsMap.put("syst02000003ums_risk", itemMap);
	


	    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for sys_workflow_ins_proc From Template: ReportTools.java.vm
//  start:  Generated for sys_workflow_ins_task From Template: ReportTools.java.vm


	public static final String getSysWorkflowInsTaskItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		SysWorkflowInsTaskDAO sysWorkflowInsTaskDAO = (SysWorkflowInsTaskDAO) Tools.getBean("sysWorkflowInsTaskDAO");
		List list = sysWorkflowInsTaskDAO.getSysWorkflowInsTaskList(new SysWorkflowInsTask());
		for(int i=0;i<list.size();i++) {
			SysWorkflowInsTask sysWorkflowInsTask = (SysWorkflowInsTask)list.get(i);
			itemMap.put(String.valueOf(sysWorkflowInsTask.getId()),String.valueOf(sysWorkflowInsTask.getId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getSysWorkflowInsTaskCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;






	itemMap= new HashMap<String, String>();
		itemMap.put("2", "����");
		itemMap.put("0", "�");
		itemMap.put("1", "���");
				itemsMap.put("syst02000012ums_risk", itemMap);
	





	    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for sys_workflow_ins_task From Template: ReportTools.java.vm
//  start:  Generated for sys_transmit From Template: ReportTools.java.vm


	public static final String getSysTransmitItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		SysTransmitDAO sysTransmitDAO = (SysTransmitDAO) Tools.getBean("sysTransmitDAO");
		List list = sysTransmitDAO.getSysTransmitList(new SysTransmit());
		for(int i=0;i<list.size();i++) {
			SysTransmit sysTransmit = (SysTransmit)list.get(i);
			itemMap.put(String.valueOf(sysTransmit.getId()),String.valueOf(sysTransmit.getId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getSysTransmitCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;









	    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for sys_transmit From Template: ReportTools.java.vm
//  start:  Generated for sys_transmit_detail From Template: ReportTools.java.vm


	public static final String getSysTransmitDetailItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		SysTransmitDetailDAO sysTransmitDetailDAO = (SysTransmitDetailDAO) Tools.getBean("sysTransmitDetailDAO");
		List list = sysTransmitDetailDAO.getSysTransmitDetailList(new SysTransmitDetail());
		for(int i=0;i<list.size();i++) {
			SysTransmitDetail sysTransmitDetail = (SysTransmitDetail)list.get(i);
			itemMap.put(String.valueOf(sysTransmitDetail.getId()),String.valueOf(sysTransmitDetail.getId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getSysTransmitDetailCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;






	    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for sys_transmit_detail From Template: ReportTools.java.vm
//  start:  Generated for sys_loginfo From Template: ReportTools.java.vm


	public static final String getSysLoginfoItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		SysLoginfoDAO sysLoginfoDAO = (SysLoginfoDAO) Tools.getBean("sysLoginfoDAO");
		List list = sysLoginfoDAO.getSysLoginfoList(new SysLoginfo());
		for(int i=0;i<list.size();i++) {
			SysLoginfo sysLoginfo = (SysLoginfo)list.get(i);
			itemMap.put(String.valueOf(sysLoginfo.getId()),String.valueOf(sysLoginfo.getId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getSysLoginfoCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;



	itemMap= new HashMap<String, String>();
		itemMap.put("3", "������");
		itemMap.put("5", "�����޸�");
		itemMap.put("7", "���ݲ�ѯ");
		itemMap.put("2", "�˵�����");
		itemMap.put("4", "��������");
		itemMap.put("6", "����ɾ��");
		itemMap.put("1", "��½/�˳�");
				itemsMap.put("syst02000044ums_risk", itemMap);
	



	    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for sys_loginfo From Template: ReportTools.java.vm
//  start:  Generated for sys_daily_ins From Template: ReportTools.java.vm


	public static final String getSysDailyInsItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		SysDailyInsDAO sysDailyInsDAO = (SysDailyInsDAO) Tools.getBean("sysDailyInsDAO");
		List list = sysDailyInsDAO.getSysDailyInsList(new SysDailyIns());
		for(int i=0;i<list.size();i++) {
			SysDailyIns sysDailyIns = (SysDailyIns)list.get(i);
			itemMap.put(String.valueOf(sysDailyIns.getId()),String.valueOf(sysDailyIns.getId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getSysDailyInsCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;








	itemMap= new HashMap<String, String>();
		itemMap.put("3", "ָ������");
		itemMap.put("2", "ָ����ɫ");
		itemMap.put("0", "����");
		itemMap.put("1", "������");
				itemsMap.put("syst02000076ums_risk", itemMap);
	
	    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for sys_daily_ins From Template: ReportTools.java.vm
//  start:  Generated for epc_ins_task From Template: ReportTools.java.vm


	public static final String getEpcInsTaskItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		EpcInsTaskDAO epcInsTaskDAO = (EpcInsTaskDAO) Tools.getBean("epcInsTaskDAO");
		List list = epcInsTaskDAO.getEpcInsTaskList(new EpcInsTask());
		for(int i=0;i<list.size();i++) {
			EpcInsTask epcInsTask = (EpcInsTask)list.get(i);
		    itemMap.put(String.valueOf(epcInsTask.getId()),String.valueOf(epcInsTask.getProcessInsId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getEpcInsTaskCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;










	itemMap= new HashMap<String, String>();
		itemMap.put("3", "����");
		itemMap.put("2", "����");
		itemMap.put("1", "�");
				itemsMap.put("syst02000087ums_risk", itemMap);
	


	    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for epc_ins_task From Template: ReportTools.java.vm
//  start:  Generated for epc_ins_proc From Template: ReportTools.java.vm


	public static final String getEpcInsProcItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		EpcInsProcDAO epcInsProcDAO = (EpcInsProcDAO) Tools.getBean("epcInsProcDAO");
		List list = epcInsProcDAO.getEpcInsProcList(new EpcInsProc());
		for(int i=0;i<list.size();i++) {
			EpcInsProc epcInsProc = (EpcInsProc)list.get(i);
		    itemMap.put(String.valueOf(epcInsProc.getId()),String.valueOf(epcInsProc.getProcessDefId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getEpcInsProcCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;



	itemMap= new HashMap<String, String>();
		itemMap.put("3", "����");
		itemMap.put("2", "����");
		itemMap.put("1", "�");
				itemsMap.put("syst02000093ums_risk", itemMap);
	



	    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for epc_ins_proc From Template: ReportTools.java.vm
//  start:  Generated for t_user_info From Template: ReportTools.java.vm


	public static final String getTuserInfoItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		TuserInfoDAO tuserInfoDAO = (TuserInfoDAO) Tools.getBean("tuserInfoDAO");
		List list = tuserInfoDAO.getTuserInfoList(new TuserInfo());
		for(int i=0;i<list.size();i++) {
			TuserInfo tuserInfo = (TuserInfo)list.get(i);
			itemMap.put(String.valueOf(tuserInfo.getId()),String.valueOf(tuserInfo.getId()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getTuserInfoCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;







	    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
	

//  end:  Generated for t_user_info From Template: ReportTools.java.vm
//  start:  Generated for t_organize_info From Template: ReportTools.java.vm


	public static final String getTorganizeInfoItems(String fieldId, String key) {
		Map<String, String> itemMap = new HashMap<String, String>();
		TorganizeInfoDAO torganizeInfoDAO = (TorganizeInfoDAO) Tools.getBean("torganizeInfoDAO");
		List list = torganizeInfoDAO.getTorganizeInfoList(new TorganizeInfo());
		for(int i=0;i<list.size();i++) {
			TorganizeInfo torganizeInfo = (TorganizeInfo)list.get(i);
		    itemMap.put(String.valueOf(torganizeInfo.getId()),String.valueOf(torganizeInfo.getName()));
		}
		Object value = itemMap.get(key);
		if(value == null){
			return "";
		}else{
			return (String)value;
		}
	}

	public static final String getTorganizeInfoCommonItems(String fieldId, String key) {
		Map<String, Map> itemsMap = new HashMap<String, Map>();
        Map<String, String> itemMap = null;










	itemMap= new HashMap<String, String>();
		itemMap.put("0", "����Ҫ");
		itemMap.put("1", "��Ҫ");
				itemsMap.put("2c908349173e897b01173e8e0e4e0005", itemMap);
		    Map map = (Map)itemsMap.get(fieldId);
		if(map == null){
			return "";
		}else{
			if((String)map.get(key) != null){
				return (String)map.get(key);
			}
			else{
				return "";
			}
		}
	}
}

//  end:  Generated for t_organize_info From Template: ReportTools.java.vm