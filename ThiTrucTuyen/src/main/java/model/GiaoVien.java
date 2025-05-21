package model;

public class GiaoVien {
	private String maGV;
	private String tenGV;
	private boolean gioiTinh;
	private String ngaySinh;
	private String sdt;
	private String email;
	public GiaoVien() {
	}
	public GiaoVien(String maGV, String tenGV, boolean gioiTinh, String ngaySinh, String sdt, String email) {
		this.maGV = maGV;
		this.tenGV = tenGV;
		this.gioiTinh = gioiTinh;
		this.ngaySinh = ngaySinh;
		this.sdt = sdt;
		this.email = email;
	}
	public String getMaGV() {
		return maGV;
	}
	public void setMaGV(String maGV) {
		this.maGV = maGV;
	}
	public String getTenGV() {
		return tenGV;
	}
	public void setTenGV(String tenGV) {
		this.tenGV = tenGV;
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
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "GiaoVien [maGV=" + maGV + ", tenGV=" + tenGV + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh
				+ ", sdt=" + sdt + ", email=" + email + "]";
	}
	
}
