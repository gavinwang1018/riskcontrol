package cn.com.brilliance.begen.exception;

public class ReportException extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4669257380926658789L;

	public ReportException(String msg){
		super(msg);
	}
	
	public ReportException(String msg,Throwable e){
		super(msg,e);
	}

	public ReportException(Throwable e){
		super(e);
	}


}
