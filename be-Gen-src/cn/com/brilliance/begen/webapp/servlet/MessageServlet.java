package cn.com.brilliance.begen.webapp.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.com.brilliance.begen.common.Constants;
import cn.com.brilliance.begen.common.Tools;
import cn.com.brilliance.begen.common.webapp.action.ResultPage;
import cn.com.brilliance.begen.dao.SysMessageDAO;
import cn.com.brilliance.begen.model.SysMessage;
import cn.com.brilliance.begen.service.MessageManager;


public class MessageServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public MessageServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String type = request.getParameter("__type");
		MessageManager mc = (MessageManager)Tools.getBean("messageManager");
		UserBean userBean = (UserBean)request.getSession().getAttribute(Constants.SESSION_USER_INFO);
		SysMessageDAO sysMessageDAO = (SysMessageDAO) Tools.getBean("sysMessageDAO");
		String userId = String.valueOf(userBean.getTuserInfo().getId());
		if ("count".equals(type)){
			response.getWriter().write(String.valueOf(mc.getCount(MessageManager.COUNT_TYPE_ALL,userId)));
		}
		else if ("count_in".equals(type)){
			response.getWriter().write(String.valueOf(mc.getCount(MessageManager.COUNT_TYPE_IN,userId)));
		} 
		else if ("count_out".equals(type)){
			response.getWriter().write(String.valueOf(mc.getCount(MessageManager.COUNT_TYPE_OUT,userId)));
		}
		else if ("in".equals(type)){
			List<SysMessage> list = mc.list(MessageManager.TYPE_IN,userId);
			request.setAttribute("messageList", list);
			request.getRequestDispatcher("message/message_inbox.jsp").forward(request, response);
		}
		else if ("out".equals(type)){
			List<SysMessage> list = mc.list(MessageManager.TYPE_OUT,userId);
			request.setAttribute("messageList", list);
			request.getRequestDispatcher("message/message_outbox.jsp").forward(request, response);
		} 
		else if ("recycled".equals(type)){
			List<SysMessage> list = mc.list(MessageManager.TYPE_RECYCLED_IN,userId);
			list.addAll(mc.list(MessageManager.TYPE_RECYCLED_OUT,userId));
			request.setAttribute("messageList", list);
			request.getRequestDispatcher("message/message_recycled.jsp").forward(request, response);
		} 
		else if ("detail".equals(type)){
			String msgId = request.getParameter("__msg_id");
			SysMessage msg = mc.detail(msgId);
			request.setAttribute("message", msg);
			request.getRequestDispatcher("message/message_detail.jsp").forward(request, response);
		} 
		else if ("delete_in".equals(type)){
			String[] msgIds = request.getParameterValues("__msg_id");
			for(String msgId : msgIds)
				mc.delete(msgId);
			List<SysMessage> list = mc.list(MessageManager.TYPE_IN,userId);
			request.setAttribute("messageList", list);
			request.getRequestDispatcher("message/message_inbox.jsp").forward(request, response);
		} 
		else if ("delete_out".equals(type)){
			String[] msgIds = request.getParameterValues("__msg_id");
			for(String msgId : msgIds)
				mc.delete(msgId);
			List<SysMessage> list = mc.list(MessageManager.TYPE_OUT,userId);
			request.setAttribute("messageList", list);
			request.getRequestDispatcher("message/message_outbox.jsp").forward(request, response);
		}
		else if ("clear".equals(type)){
			String[] msgIds = request.getParameterValues("__msg_id");
			for(String msgId : msgIds)
				mc.clear(msgId);
			List<SysMessage> list = mc.list(MessageManager.TYPE_RECYCLED_IN,userId);
			list.addAll(mc.list(MessageManager.TYPE_RECYCLED_OUT,userId));
			request.setAttribute("messageList", list);
			request.getRequestDispatcher("message/message_recycled.jsp").forward(request, response);
		} 
		else if ("recover".equals(type)){
			String[] msgIds = request.getParameterValues("__msg_id");
			for(String msgId : msgIds)
				mc.recover(msgId);
			List<SysMessage> list = mc.list(MessageManager.TYPE_RECYCLED_IN,userId);
			list.addAll(mc.list(MessageManager.TYPE_RECYCLED_OUT,userId));
			request.setAttribute("messageList", list);
			request.getRequestDispatcher("message/message_recycled.jsp").forward(request, response);
		} 
		else if ("save".equals(type)){
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String users = request.getParameter("user");
			String roles = request.getParameter("role");
			String orgs = request.getParameter("org");
			String[] user = null;
			String[] org = null;
			String[] role = null;
			if (users != null)
				user = users.split(",");
			if (roles != null)
				role = roles.split(",");
			if (orgs != null)
				org = orgs.split(",");
			
			mc.save(title, content, userId,MessageManager.TYPE_IN, user, role, org);
			
			SysMessage sysMessage = new SysMessage();
			sysMessage.setSender(userId);
			sysMessage.setSendTime(new Date());
			sysMessage.setTitle(title);
			sysMessage.setContent(content);
			sysMessage.setType("2");
			sysMessage.setReadFlag(false);
			sysMessage.setReceiver(userId);
			sysMessageDAO.saveSysMessage(sysMessage);
			ResultPage rp = new ResultPage();
			rp.setMessageLabel("发送消息成功");
			rp.setMessageType(ResultPage.MESSAGE_TYPE_SUCCESS);
			rp.forwardResultPage(request, response);
		} 
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occure
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
