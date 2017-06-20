package cn.com.brilliance.begen.exception;

public class UserException extends BeGenException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -584389621510567679L;

	public UserException(String msg){
		super(msg);
	}
	
	public UserException(String msg,Throwable e){
		super(msg,e);
	}

	public UserException(Throwable e){
		super(e);
	}


}
