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
			WritableSheet sheet = workbook.createSheet("���հ����б�", 0);

			// һЩ��ʱ����������д��excel��
			Label l = null;
			jxl.write.Number n = null;
			jxl.write.DateTime d = null;

			// Ԥ�����һЩ����͸�ʽ��ͬһ��Excel����ò�Ҫ��̫���ʽ
			WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false);
			WritableCellFormat titleFormat = new WritableCellFormat(titleFont);

			WritableFont detFont = new WritableFont(WritableFont.ARIAL, 10, WritableFont.NO_BOLD, false);
			WritableCellFormat detFormat = new WritableCellFormat(detFont);

			NumberFormat pf = new NumberFormat("0.00"); // ����price�ĸ�ʽ
			WritableCellFormat priceFormat = new WritableCellFormat(detFont, pf);

			NumberFormat nf = new NumberFormat("0"); // ����Number�ĸ�ʽ
			WritableCellFormat numberFormat = new WritableCellFormat(detFont,
					nf);

			DateFormat df = new DateFormat("yyyy-MM-dd");// �������ڵ�
			WritableCellFormat dateFormat = new WritableCellFormat(detFont, df);

			int _column = 0;
			l = new Label(_column++, 0, "����", titleFormat);
			// �����еĿ��
			int column = 0;
			l = new Label(column++, 0, "���հ������", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "������Դ", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "�̻����", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "�̻���", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "�̻���ҵ���", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "����MCC", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "��������", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "�������", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "���հ�����������", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "��ؽ��׵Ŀ�ʼʱ��", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "��ؽ��׵Ľ���ʱ��", titleFormat);			
			sheet.addCell(l);
			l = new Label(column++, 0, "�漰���׽��", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "�漰���ױ���", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "���յȼ�", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "����������", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "�Ƿ�߰�", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "�߰����", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "����ʱ��", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "����״̬", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "�˻ش���", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "�����������", titleFormat);
			sheet.addCell(l);
			l = new Label(column++, 0, "��������", titleFormat);
			sheet.addCell(l);

			for (int i = 0; i < list.size(); i++) {
				Triskcase triskcase = (Triskcase) list.get(i);
				column = 0;
				l = new Label(column++, i + 1, triskcase.getCaseno(), detFormat);
				sheet.addCell(l);
				String casefrom = "";
				if ("1".equals(triskcase.getCasefrom())) {
					casefrom = "���̼����ܹ�˾";
				}
				if ("2".equals(triskcase.getCasefrom())) {
					casefrom = "���̷�֧����";
				}
				if ("3".equals(triskcase.getCasefrom())) {
					casefrom = "��������";
				}
				if ("4".equals(triskcase.getCasefrom())) {
					casefrom = "��������";
				}
				if ("5".equals(triskcase.getCasefrom())) {
					casefrom = "����ý��";
				}
				if ("6".equals(triskcase.getCasefrom())) {
					casefrom = "��������";
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
					warnLevel = "��ʾ";
				}
				if ("1".equals(triskcase.getWarnLevel())) {
					warnLevel = "��ע";
				}
				if ("2".equals(triskcase.getWarnLevel())) {
					warnLevel = "Ԥ��";
				}
				if ("3".equals(triskcase.getWarnLevel())) {
					warnLevel = "����";
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
					l = new Label(column++, i + 1, "��", detFormat);
				} else {
					l = new Label(column++, i + 1, "��", detFormat);
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
					status = "������";
				}
				if ("1".equals(triskcase.getStatus())) {
					status = "������";
				}
				if ("2".equals(triskcase.getStatus())) {
					status = "������";
				}
				if ("3".equals(triskcase.getStatus())) {
					status = "�Ѵ���";
				}
				if ("4".equals(triskcase.getStatus())) {
					status = "�Ѹ���";
				}
				if ("5".equals(triskcase.getStatus())) {
					status = "������";
				}
				if ("6".equals(triskcase.getStatus())) {
					status = "�᰸";
				}
				l = new Label(column++, i + 1, status, detFormat);
				sheet.addCell(l);
				n = new jxl.write.Number(column++, i + 1, triskcase
						.getBackCnt(), numberFormat);
				sheet.addCell(n);
				String action = "";
				if ("0".equals(triskcase.getAction())) {
					action = "�����̻�";
				}
				if ("1".equals(triskcase.getAction())) {
					action = "�����̻�";
				}
				l = new Label(column++, i + 1, action, detFormat);
				sheet.addCell(l);
				String way = "";
				if ("0".equals(triskcase.getWay())) {
					action = "����";
				}
				if ("1".equals(triskcase.getWay())) {
					action = "��ֹЭ��";
				}
				if ("2".equals(triskcase.getWay())) {
					action = "���յ���";
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
