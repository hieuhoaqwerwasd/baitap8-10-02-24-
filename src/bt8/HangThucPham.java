package bt8;

import java.time.LocalDate;

public class HangThucPham extends HangHoa {
	
	private static final double thue = 0.05;
	private String nhaCungCap;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;
	
	public HangThucPham() {
		super("");
		this.nhaCungCap = "";
		this.ngaySanXuat = LocalDate.now();
		this.ngayHetHan = ngaySanXuat;
	}
	
	
	public HangThucPham(String maHang, String tenHang, double donGia, int soLuongTon, String nhaCungCap, LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		super(maHang, tenHang, donGia, soLuongTon);
		this.nhaCungCap = nhaCungCap;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
	}


	public String getNhaCungCap() {
		return nhaCungCap;
	}


	public void setNhaCungCap(String nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}


	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}


	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if (ngaySanXuat.isAfter(LocalDate.now()))
			throw new RuntimeException("Ngày sản xuất phải là ngày trước ngày hiện tại.");
		this.ngaySanXuat = ngaySanXuat;
	}


	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}


	public void setNgayHetHan(LocalDate ngayHetHan) {
		if (ngayHetHan.isBefore(ngaySanXuat))
			throw new RuntimeException("Ngày hết hạn phải là ngày sau ngày sản xuất.");
		this.ngayHetHan = ngayHetHan;
	}
	
	@Override
	public double getTienVAT() {
		return soLuongTon * donGia * thue;
	}
	
	@Override
	public String danhGia() {
		if (soLuongTon > 0 && ngayHetHan.isBefore(LocalDate.now()))
			return "Khó bán";
		return "Không có đánh giá";
	}
	
}
