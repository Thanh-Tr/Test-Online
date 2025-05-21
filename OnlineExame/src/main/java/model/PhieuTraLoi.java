package model;

public class PhieuTraLoi {
	private String maPTL;
	private String cauTraLoi;
	private String maHS;
	private String maDT;
	public PhieuTraLoi() {
	}
	public PhieuTraLoi(String maPTL, String cauTraLoi, String maHS, String maDT) {
		this.maPTL = maPTL;
		this.cauTraLoi = cauTraLoi;
		this.maHS = maHS;
		this.maDT = maDT;
	}
	public String getMaPTL() {
		return maPTL;
	}
	public void setMaPTL(String maPTL) {
		this.maPTL = maPTL;
	}
	public String getCauTraLoi() {
		return cauTraLoi;
	}
	public void setCauTraLoi(String cauTraLoi) {
		this.cauTraLoi = cauTraLoi;
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}
	public String getMaDT() {
		return maDT;
	}
	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}
	
}
