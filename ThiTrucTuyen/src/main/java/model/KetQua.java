package model;

public class KetQua {
	private String maKQ;
	private String maHS;
	private String maDT;
	private int soCauDung;
	private int tongSoCau;
	public KetQua() {
	}
	public KetQua(String maKQ, String maHS, String maDT, int soCauDung, int tongSoCau) {
		this.maKQ = maKQ;
		this.maHS = maHS;
		this.maDT = maDT;
		this.soCauDung = soCauDung;
		this.tongSoCau = tongSoCau;
	}
	public String getMaKQ() {
		return maKQ;
	}
	public void setMaKQ(String maKQ) {
		this.maKQ = maKQ;
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
	public int getSoCauDung() {
		return soCauDung;
	}
	public void setSoCauDung(int soCauDung) {
		this.soCauDung = soCauDung;
	}
	public int getTongSoCau() {
		return tongSoCau;
	}
	public void setTongSoCau(int tongSoCau) {
		this.tongSoCau = tongSoCau;
	}
	@Override
	public String toString() {
		return "KetQua [maKQ=" + maKQ + ", maHS=" + maHS + ", maDT=" + maDT + ", soCauDung=" + soCauDung
				+ ", tongSoCau=" + tongSoCau + "]";
	}
	
}
