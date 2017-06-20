package cn.com.brilliance.risk.ext.common;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.model.Triskcase;
import cn.com.brilliance.begen.webapp.action.ExtSelectItemUtil;
import cn.com.brilliance.begen.webapp.action.SelectItemUtil;
import cn.com.brilliance.risk.ext.interfaces.DataManageController;

import jxl.Workbook;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelOfRiskcaseUtil {

	public static ExtSelectItemUtil extSelectItemUtil = new ExtSelectItemUtil();

	public static SelectItemUtil selectItemUtil = new SelectItemUtil();

	public String createExcel(List list, OutputStream os) {
		DataManageController dataManageController = (DataManageController) Tools
				.getBean("dataManageController");
		// File tempFile = new File("c:/test.xls");
		try {
			WritableWorkbook workbook = Workbook.createWorkbook(os);
			WritableSheet sheet = workbook.createSheet("风险案例列表", 0);

			// 一些临时变量，用于写到excel中
			Label l = null;
			jxl.write.Number n = null;
			jxl.write.DateTime d = null;

			// 预定义的一些字体和格式，同一个Excel中最好不要有太多格式
			WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false);
			WritableCellFormat titleFormat = new WritableCellFormat(titleFont);

			WritableFont detFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false);
			WritableCellFormat detFormat = new WritableCellFormat(detFont);

			NumberFormat pf = new NumberFormat("0.00"); // 用于price的格式
			WritableCellFormat priceFormat = new WritableCellFormat(detFont, pf);

			NumberFormat nf = new NumberFormat("0"); // 用于Number的格式
			WritableCellFormat numberFormat = new WritableCellFormat(detFont,
					nf);

			DateFormat df = new DateFormat("yyyy-MM-dd");// 用于日期的
			WritableCellFormat dateFormat = new WritableCellFormat(detFont, df);

			int _column = 0;
			l = new Label(_column++, 0, "测试", titleFormat);
			// 设置列的宽度
			int column = 0;
			l = new Label(column++, 0, "风险案例编号", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "案例来源", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "商户编号", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "商户名", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "商户行业类别", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "交易MCC", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "所属机构", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "处理机构", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "风险案例生成日期", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "相关交易的开始时间", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "相关交易的结束时间", titleFormat);			
			sheet.addCell(l);
			l = new Label(column++, 0, "涉及交易金额", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "涉及交易笔数", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "风险等级", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "触发规则数", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "是否催办", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "催办次数", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "处理时限", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "案例状态", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "退回次数", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "案例调查结论", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "案例处理", titleFormat);
			sheet.addCell(l);

			for (int i = 0; i < list.size(); i++) {
				Triskcase triskcase = (Triskcase) list.get(i);
				column = 0;
				l = new Label(column++, i + 1, triskcase.getCaseno(), detFormat);
				sheet.addCell(l);
				String casefrom = "";
				if ("1".equals(triskcase.getCasefrom())) {
					casefrom = "银商集团总公司";
				}
				if ("2".equals(triskcase.getCasefrom())) {
					casefrom = "银商分支机构";
				}
				if ("3".equals(triskcase.getCasefrom())) {
					casefrom = "银联集团";
				}
				if ("4".equals(triskcase.getCasefrom())) {
					casefrom = "其它机构";
				}
				if ("5".equals(triskcase.getCasefrom())) {
					casefrom = "报刊媒体";
				}
				if ("6".equals(triskcase.getCasefrom())) {
					casefrom = "其它渠道";
				}
				l = new Label(column++, i + 1, casefrom, detFormat);
				sheet.addCell(l);
				l = new Label(column++, i + 1, triskcase.getMchntCd(),
						detFormat);
				sheet.addCell(l);
				l = new Label(column++, i + 1, triskcase.getMchntName(),
						detFormat);
				sheet.addCell(l);
				String mchntType = "";
				List mchntTypeList = dataManageController.queryForList("select bigmcc_name from t_mcc where id='" + triskcase.getTransMcc() + "'");
				if(mchntTypeList != null && mchntTypeList.size() > 0) {
					Map map = (Map) mchntTypeList.get(0);
					mchntType = (String)map.get("bigmcc_name");
				}
				l = new Label(column++, i + 1, mchntType, detFormat);
				sheet.addCell(l);				
				String transMcc = "";
				List transMccList = dataManageController
						.queryForList("select mcc_name from t_mcc where id='"
								+ triskcase.getTransMcc() + "'");
				if (transMccList != null && transMccList.size() > 0) {
					Map transMccMap = (Map) transMccList.get(0);
					transMcc = (String) transMccMap.get("mcc_name");
				}
				l = new Label(column++, i + 1, triskcase.getTransMcc() + "("
						+ transMcc + ")", detFormat);
				sheet.addCell(l);
				String belongToInst = "";
				List belongToInstList = dataManageController
						.queryForList("select name from t_organize_info where id='"
								+ triskcase.getBelongToInst() + "'");
				if (belongToInstList != null && belongToInstList.size() > 0) {
					Map belongToInstMap = (Map) belongToInstList.get(0);
					belongToInst = (String) belongToInstMap
							.get("name");
				}
				l = new Label(column++, i + 1, belongToInst, detFormat);
				sheet.addCell(l);
				String submit2Inst = "";
				if(!"0".equals(triskcase.getStatus()) && !"1".equals(triskcase.getStatus())) {
					List submit2InstList = dataManageController
							.queryForList("select name from t_organize_info where id='"
									+ triskcase.getSubmit2Inst() + "'");
					if (submit2InstList != null && submit2InstList.size() > 0) {
						Map submit2InstMap = (Map) submit2InstList.get(0);
						submit2Inst = (String) submit2InstMap.get("name");
					}
				}
				l = new Label(column++, i + 1, submit2Inst, detFormat);
				sheet.addCell(l);
				d = new DateTime(column++, i + 1, triskcase.getCreatedate(),
						dateFormat);
				sheet.addCell(d);
				d = new DateTime(column++, i + 1, triskcase.getBeginDate(),
						dateFormat);
				sheet.addCell(d);		
				d = new DateTime(column++, i + 1, triskcase.getEndDate(),
						dateFormat);
				sheet.addCell(d);					
				if (triskcase.getRelativeTransAmt() != null
						&& !"".equals(triskcase.getRelativeTransAmt())) {
					n = new jxl.write.Number(column++, i + 1, triskcase
							.getRelativeTransAmt(), priceFormat);
				} else {
					n = new jxl.write.Number(column++, i + 1, 0.00, priceFormat);
				}
				sheet.addCell(n);
				Long relativeTransNum = Long.valueOf("0");
				if(triskcase.getRelativeTransNum() != null) {
					relativeTransNum = triskcase.getRelativeTransNum();
				}
				n = new jxl.write.Number(column++, i + 1, relativeTransNum, numberFormat);
				sheet.addCell(n);
				String warnLevel = "";
				if ("0".equals(triskcase.getWarnLevel())) {
					warnLevel = "提示";
				}
				if ("1".equals(triskcase.getWarnLevel())) {
					warnLevel = "关注";
				}
				if ("2".equals(triskcase.getWarnLevel())) {
					warnLevel = "预警";
				}
				if ("3".equals(triskcase.getWarnLevel())) {
					warnLevel = "警告";
				}
				l = new Label(column++, i + 1, warnLevel, detFormat);
				sheet.addCell(l);
				Integer triggerRuleNum = 0;
				if(triskcase.getTriggerRuleNum() != null) {
					triggerRuleNum = triskcase.getTriggerRuleNum();
				} 
				n = new jxl.write.Number(column++, i + 1, triggerRuleNum, numberFormat);
				sheet.addCell(n);
				if (triskcase.getBeenUrgent() != null
						&& triskcase.getBeenUrgent()) {
					l = new Label(column++, i + 1, "是", detFormat);
				} else {
					l = new Label(column++, i + 1, "否", detFormat);
				}
				sheet.addCell(l);
				n = new jxl.write.Number(column++, i + 1, triskcase
						.getUrgentCnt(), numberFormat);
				sheet.addCell(n);
				d = new DateTime(column++, i + 1, triskcase.getProcessLimit(),
						dateFormat);
				sheet.addCell(d);
				String status = "";
				if ("0".equals(triskcase.getStatus())) {
					status = "不处理";
				}
				if ("1".equals(triskcase.getStatus())) {
					status = "待处理";
				}
				if ("2".equals(triskcase.getStatus())) {
					status = "处理中";
				}
				if ("3".equals(triskcase.getStatus())) {
					status = "已处理";
				}
				if ("4".equals(triskcase.getStatus())) {
					status = "已复核";
				}
				if ("5".equals(triskcase.getStatus())) {
					status = "已审批";
				}
				if ("6".equals(triskcase.getStatus())) {
					status = "结案";
				}
				l = new Label(column++, i + 1, status, detFormat);
				sheet.addCell(l);
				n = new jxl.write.Number(column++, i + 1, triskcase
						.getBackCnt(), numberFormat);
				sheet.addCell(n);
				String action = "";
				if ("0".equals(triskcase.getAction())) {
					action = "正常商户";
				}
				if ("1".equals(triskcase.getAction())) {
					action = "风险商户";
				}
				l = new Label(column++, i + 1, action, detFormat);
				sheet.addCell(l);
				String way = "";
				if ("0".equals(triskcase.getWay())) {
					action = "警告";
				}
				if ("1".equals(triskcase.getWay())) {
					action = "终止协议";
				}
				if ("2".equals(triskcase.getWay())) {
					action = "交收单方";
				}
				l = new Label(column++, i + 1, way, detFormat);
				sheet.addCell(l);
			}

			column = 0;
			sheet.setColumnView(column++, 20);
			sheet.setColumnView(column++, 15);
			sheet.setColumnView(column++, 20);
			sheet.setColumnView(column++, 30);
			sheet.setColumnView(column++, 15);
			sheet.setColumnView(column++, 20);
			sheet.setColumnView(column++, 15);
			sheet.setColumnView(column++, 15);
			sheet.setColumnView(column++, 18);
			sheet.setColumnView(column++, 18);
			sheet.setColumnView(column++, 18);
			sheet.setColumnView(column++, 15);
			sheet.setColumnView(column++, 15);
			sheet.setColumnView(column++, 10);
			sheet.setColumnView(column++, 10);
			sheet.setColumnView(column++, 10);
			sheet.setColumnView(column++, 10);
			sheet.setColumnView(column++, 10);
			sheet.setColumnView(column++, 10);
			sheet.setColumnView(column++, 10);
			sheet.setColumnView(column++, 10);
			sheet.setColumnView(column++, 10);
			workbook.write();
			workbook.close();
			os.close();
			return "success";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RowsExceededException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WriteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "failure";
	}

}
