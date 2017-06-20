package cn.com.brilliance.begen.exception;

public class EpcException extends SystemException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4669257380926658787L;

	public EpcException(String msg){
		super(msg);
	}
	
	public EpcException(String msg,Throwable e){
		super(msg,e);
	}

	public EpcException(Throwable e){
		super(e);
	}


}
