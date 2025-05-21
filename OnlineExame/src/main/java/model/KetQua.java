package model;

public class KetQua {
	private String maKQ;
	private int thoiGianNopBai;
	private String maPTL;
	public KetQua() {
	}
	public KetQua(String maKQ, int thoiGianNopBai, String maPTL) {
		this.maKQ = maKQ;
		this.thoiGianNopBai = thoiGianNopBai;
		this.maPTL = maPTL;
	}
	public String getMaKQ() {
		return maKQ;
	}
	public void setMaKQ(String maKQ) {
		this.maKQ = maKQ;
	}
	public int getThoiGianNopBai() {
		return thoiGianNopBai;
	}
	public void setThoiGianNopBai(int thoiGianNopBai) {
		this.thoiGianNopBai = thoiGianNopBai;
	}
	public String getMaPTL() {
		return maPTL;
	}
	public void setMaPTL(String maPTL) {
		this.maPTL = maPTL;
	}
	
}
