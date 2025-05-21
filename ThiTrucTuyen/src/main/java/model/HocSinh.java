package model;


public class HocSinh {
	private String maHS;
	private String tenHS;
	private boolean gioiTinh;
	private String ngaySinh;
	private String lop;
	public HocSinh() {
	}
	public HocSinh(String maHS, String tenHS, boolean gioiTinh, String ngaySinh, String lop) {
		this.maHS = maHS;
		this.tenHS = tenHS;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.lop = lop;
	}
	public String getMaHS() {
		return maHS;
	}
	public void setMaHS(String maHS) {
		this.maHS = maHS;
	}
	public String getTenHS() {
		return tenHS;
	}
	public void setTenHS(String tenHS) {
		this.tenHS = tenHS;
	}
	public boolean getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getLop() {
		return lop;
	}
	public void setLop(String lop) {
		this.lop = lop;
	}
	@Override
	public String toString() {
		return "HocSinh [maHS=" + maHS + ", tenHS=" + tenHS + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh
				+ ", lop=" + lop + "]";
	}
	
}
