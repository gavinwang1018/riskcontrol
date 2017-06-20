package cn.com.brilliance.begen.webapp.action;

public class Adjustment {
	private boolean adjust;
	
	private boolean turnback;
	
	private boolean askfund;
	
	private boolean returnback;
	
	private boolean reaskfund;
	
	private boolean others;
	
	private boolean certain1;
	
	private boolean certain2;

	public boolean isAdjust() {
		return adjust;
	}

	public void setAdjust(boolean adjust) {
		this.adjust = adjust;
	}

	public boolean isAskfund() {
		return askfund;
	}

	public void setAskfund(boolean askfund) {
		this.askfund = askfund;
	}

	public boolean isCertain1() {
		return certain1;
	}

	public void setCertain1(boolean certain1) {
		this.certain1 = certain1;
	}

	public boolean isCertain2() {
		return certain2;
	}

	public void setCertain2(boolean certain2) {
		this.certain2 = certain2;
	}

	public boolean isOthers() {
		return others;
	}

	public void setOthers(boolean others) {
		this.others = others;
	}

	public boolean isReaskfund() {
		return reaskfund;
	}

	public void setReaskfund(boolean reaskfund) {
		this.reaskfund = reaskfund;
	}

	public boolean isReturnback() {
		return returnback;
	}

	public void setReturnback(boolean returnback) {
		this.returnback = returnback;
	}

	public boolean isTurnback() {
		return turnback;
	}

	public void setTurnback(boolean turnback) {
		this.turnback = turnback;
	}
	
}
