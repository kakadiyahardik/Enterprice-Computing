package model;

public class Currency {

	private String source_Currency;
	private String target_Currency;
	private double rate;
	
	public String getSource_Currency() {
		return source_Currency;
	}
	public void setSource_Currency(String source_Currency) {
		this.source_Currency = source_Currency;
	}
	public String getTarget_Currency() {
		return target_Currency;
	}
	public void setTarget_Currency(String target_Currency) {
		this.target_Currency = target_Currency;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
}
