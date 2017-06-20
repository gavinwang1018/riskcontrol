package cn.com.brilliance.begen.common;

public class HistoryInfo {

	final public static char TYPE_VIEW_FORM = '1';
	
	final public static char TYPE_LIST = '2';
	
	private char type;
	
	private String link;
	
	private String title;
	
	
	public String getLink() {
		return link;
	}


	public void setLink(String link) {
		this.link = link;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}

	public char getType() {
		return type;
	}

	public void setType(char type) {
		this.type = type;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
