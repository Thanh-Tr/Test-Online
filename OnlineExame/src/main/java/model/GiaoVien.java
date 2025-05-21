package model;

import java.sql.Date;

public class GiaoVien {
	private String maGV;
	private String tenGV;
	private boolean gioiTinh;
	private Date ngaySinh;
	private String sdt;
	private String email;
	public GiaoVien() {}
	public GiaoVien(String maGV, String tenGV, boolean gioiTinh, Date ngaySinh, String sdt, String email) {
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
	public boolean isGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
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
	
	
	
	
}
