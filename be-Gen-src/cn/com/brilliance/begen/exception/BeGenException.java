package cn.com.brilliance.begen.exception;

public class BeGenException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 505528441889097567L;
	
	protected int code;

	protected String msg;

	public BeGenException(String msg){
		super(msg);
	}
	
	public BeGenException(String msg,Throwable e){
		super(msg,e);
	}

	public BeGenException(Throwable e){
		super(e);
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
