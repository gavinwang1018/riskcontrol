package cn.com.brilliance.begen.common;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class BeGenHistory {

	final static String SESSION_HISTORY = "_history";
	
	private List<HistoryInfo> historyList= new ArrayList<HistoryInfo>();; 
	
	public static BeGenHistory getInstance(HttpServletRequest request){
		BeGenHistory his = (BeGenHistory)request.getSession().getAttribute(SESSION_HISTORY);
		if (his == null){
			his = new BeGenHistory();
			request.getSession().setAttribute(SESSION_HISTORY,his);
		}
		return his;
	}
	
	public void addHistory(char type,String title,String link){
		try {
			for (int i = 0 ; i <  historyList.size(); i ++){
				HistoryInfo historyInfo = historyList.get(i);
				if(title.equals(historyInfo.getTitle())){
					historyList.remove(i);
					historyList.add(historyInfo);
					return;
				}
			}
			HistoryInfo hi = new HistoryInfo();
			hi.setType(type);
			hi.setLink(link);
			hi.setTitle(title);
			historyList.add(hi);
			if(historyList.size() > 10){
				historyList.remove(0);
			}
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeHistory(String title){
		for (int i = 0 ; i <  historyList.size(); i ++){
			HistoryInfo historyInfo = historyList.get(i);
			if(title.equals(historyInfo.getTitle())){				
				historyList.remove(i);				
				return;
			}
		}
	}

	public List<HistoryInfo> getHistoryList() {
		return historyList;
	}

	public String getLastLink(){
		if(historyList.size() > 0)
			return historyList.get(historyList.size() -1).getLink();
		return null;
	}
	
	public String getLastTitle(){
		if(historyList.size() > 0)
			return historyList.get(historyList.size() -1).getTitle();
		return null;
	}
	
	
}
