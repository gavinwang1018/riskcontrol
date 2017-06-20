package cn.com.brilliance.begen.common.webapp.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.ListOrderedMap;

public class ResultPage {
	public static final String REQUEST_ATTRIBUTE_NAME = "__msg_handle";

	public static final int MESSAGE_TYPE_SUCCESS = 0;

	public static final int MESSAGE_TYPE_DATAMANAGE_ERROR = 1;

	public static final int MESSAGE_TYPE_WORKFLOW_ERROR = 2;

	public static final int MESSAGE_TYPE_REGISTER_ERROR = 3;

	public static final int MESSAGE_TYPE_BIZSCRIPT_ERROR = 4;

	public static final int MESSAGE_TYPE_EMAIL_ERROR = 5;

	public static final int MESSAGE_TYPE_REPORT_ERROR = 6;

	public static final int MESSAGE_TYPE_LOGIN_ERROR = 7;

	public static final int MESSAGE_TYPE_OTHER_ERROR = 9999;
	
	public static final int MESSAGE_TYPE_IMPORT_REPORT = 8888;

	private int messageType = MESSAGE_TYPE_SUCCESS;

	private String messageLabel;

	private String messageContent;

	private ListOrderedMap links = new ListOrderedMap();

	public String getMessageTypeLabel() {
		switch (this.messageType) {
		case MESSAGE_TYPE_SUCCESS:
			return "�ɹ�";
		case MESSAGE_TYPE_OTHER_ERROR:
			return "��������";
		case MESSAGE_TYPE_DATAMANAGE_ERROR:
			return "���ݴ���";
		case MESSAGE_TYPE_WORKFLOW_ERROR:
			return "����������";
		case MESSAGE_TYPE_REGISTER_ERROR:
			return "ע�����";
		case MESSAGE_TYPE_BIZSCRIPT_ERROR:
			return "��ҵ�ű�����";
		case MESSAGE_TYPE_EMAIL_ERROR:
			return "Email����";
		case MESSAGE_TYPE_REPORT_ERROR:
			return "�������";
		case MESSAGE_TYPE_LOGIN_ERROR:
			return "��¼����";
		case MESSAGE_TYPE_IMPORT_REPORT:
			return "��������ϸ��Ϣ";
		default:
			return "δ֪����";
		}
	}

	public ListOrderedMap getLinks() {
		return links;
	}

	public List getLinkList() {
		List al = new ArrayList();
		for (int i = 0 ; i < links.size(); i++){
			HashMap hm = new HashMap();
			hm.put("title",links.get(i));
			hm.put("url",links.getValue(i));
			al.add(hm);
		}
		return al;
	}
	public void addLink(String label, String link) {
		links.put(links.size(), label, link);
	}

	public String getMessageContent() {
		return messageContent;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public String getMessageLabel() {
		return messageLabel;
	}

	public void setMessageLabel(String messageLabel) {
		this.messageLabel = messageLabel;
	}

	public int getMessageType() {
		return messageType;
	}

	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}

	public void setRequestAttribute(HttpServletRequest request) {
		request.setAttribute(REQUEST_ATTRIBUTE_NAME, this);
	}

	public void forwardResultPage(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			this.setRequestAttribute(request);
			request.getRequestDispatcher("/common/result.jsp").forward(request,
					response);
		} catch (ServletException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����� catch ��
			e.printStackTrace();
		}
	}

}
