package cn.com.brilliance.begen.exception;

public class SystemException extends BeGenException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6428420274010320757L;

	public SystemException(String msg) {
		super(msg);		
	}
	
	public SystemException(String msg,Throwable e) {
		super(msg,e);		
	}
	
	public SystemException(Throwable e) {
		super(e);		
	}
}
