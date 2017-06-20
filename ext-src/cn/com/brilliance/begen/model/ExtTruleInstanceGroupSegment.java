package cn.com.brilliance.begen.model;

public class ExtTruleInstanceGroupSegment {
	
	private String ruleInstanceId;
	
	private Float begin;
	
	private Float end;
	
	private Float value;
	
	private Float rate;

	public Float getBegin() {
		return begin;
	}

	public void setBegin(Float begin) {
		this.begin = begin;
	}

	public Float getEnd() {
		return end;
	}

	public void setEnd(Float end) {
		this.end = end;
	}

	public Float getRate() {
		return rate;
	}

	public void setRate(Float rate) {
		this.rate = rate;
	}

	public String getRuleInstanceId() {
		return ruleInstanceId;
	}

	public void setRuleInstanceId(String ruleInstanceId) {
		this.ruleInstanceId = ruleInstanceId;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}
	
	

}
