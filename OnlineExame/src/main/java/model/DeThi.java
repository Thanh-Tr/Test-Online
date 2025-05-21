package model;

public class DeThi {
	private String maDT;
	private String tenDT;
	private int thoiGianLamBai;
	private String maGV;
	public DeThi() {}
	public DeThi(String maDT, String tenDT, int thoiGianLamBai, String maGV) {
		this.maDT = maDT;
		this.tenDT = tenDT;
		this.thoiGianLamBai = thoiGianLamBai;
		this.maGV = maGV;
	}
	public String getMaDT() {
		return maDT;
	}
	public void setMaDT(String maDT) {
		this.maDT = maDT;
	}
	public String getTenDT() {
		return tenDT;
	}
	public void setTenDT(String tenDT) {
		this.tenDT = tenDT;
	}
	public int getThoiGianLamBai() {
		return thoiGianLamBai;
	}
	public void setThoiGianLamBai(int thoiGianLamBai) {
		this.thoiGianLamBai = thoiGianLamBai;
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	
	
}
