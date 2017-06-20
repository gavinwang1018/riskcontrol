package cn.com.brilliance.begen.exception;

public class LoginException extends UserException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1821050069277938124L;

	public LoginException(String msg){
		super(msg);
	}
	
	public LoginException(String msg,Throwable e){
		super(msg,e);
	}

	public LoginException(Throwable e){
		super(e);
	}

}
