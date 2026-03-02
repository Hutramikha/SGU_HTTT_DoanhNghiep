--create database QuanLyQuanCaPhe
use QuanLyQuanCaPhe
go

/*
DROP TABLE IF EXISTS [ChiTietPhieuNhap];
DROP TABLE IF EXISTS [ChiTietHoaDon];
DROP TABLE IF EXISTS [CaLam];
DROP TABLE IF EXISTS [LichLam];
DROP TABLE IF EXISTS [PhanQuyen];
DROP TABLE IF EXISTS [TaiKhoan];
DROP TABLE IF EXISTS [PhieuNhap];
DROP TABLE IF EXISTS [HoaDon];
DROP TABLE IF EXISTS [KhachHang];
DROP TABLE IF EXISTS [KhuyenMai];
DROP TABLE IF EXISTS [UuDaiThanhVien];
DROP TABLE IF EXISTS [Mon];
DROP TABLE IF EXISTS [LoaiMon];
DROP TABLE IF EXISTS [NguyenLieu];
DROP TABLE IF EXISTS [CongThuc];
DROP TABLE IF EXISTS [NhaCungCap];
DROP TABLE IF EXISTS [NhanVien]
*/

CREATE TABLE [CaLam] (
	[MaCaLam] nvarchar(255),
	[TenCaLam] nvarchar(255),
	[ThoiGianVaoCaLam] time ,
	[ThoiGianRaCalam] time ,
	[TrangThaiCaLam] bit,
	PRIMARY KEY ([MaCaLam])
);

CREATE TABLE [NhanVien] (
	[MaNhanVien] nvarchar(255) ,
	[TenNhanVien] nvarchar(255) ,
	[GioiTinhNhanVien] nvarchar(255) ,
	[SoDienThoaiNhanVien] nvarchar(255) ,
	[NgaySinhNhanVien] date ,
	[ChucVuNhanVien] nvarchar(255) ,
	[DiaChi] nvarchar(255) ,
	[LuongNhanVien] int,
	[TrangThaiNhanVien] bit,
	PRIMARY KEY ([MaNhanVien])
);

CREATE TABLE [LichLam] (
	[MaCaLam] nvarchar(255) ,
	[MaNhanVien] nvarchar(255),
	[NgayLam] date,
	PRIMARY KEY ([MaCaLam], [MaNhanVien], [NgayLam]), 
	FOREIGN KEY ([MaCaLam]) REFERENCES [CaLam]([MaCaLam]),
	FOREIGN KEY ([MaNhanVien]) REFERENCES [NhanVien]([MaNhanVien])
);

CREATE TABLE [PhanQuyen] (
	[MaPhanQuyen] nvarchar(255),
	[TenQuyen] nvarchar(255),
	[QuyenKhachHang] bit,
	[QuyenBanHang] bit,
	[QuyenNhapHang] bit,
	[QuyenMon] bit,
	[QuyenNguyenLieu] bit,
	[QuyenLichLam] bit,
	[QuyenKhuyenMaiUuDai] bit,
	[QuyenNhaCungCap] bit,
	[QuyenNhanVien] bit,
	[QuyenThongKe] bit,
	[TrangThaiPhanQuyen] bit,
	PRIMARY KEY ([MaPhanQuyen])
);

CREATE TABLE [TaiKhoan] (
	[MaTaiKhoan] nvarchar(255) ,
	[TenDangNhap] nvarchar(255) ,
	[MatKhau] nvarchar(255) ,
	[MaPhanQuyen] nvarchar(255) ,
	[MaNhanVien] nvarchar(255) ,
	[NgayCap] date,
	[NgayNghiViec] date,
	[TrangThaiTaiKhoan] bit,
	PRIMARY KEY ([MaTaiKhoan]),
	FOREIGN KEY ([MaNhanVien]) REFERENCES [NhanVien]([MaNhanVien]),
	FOREIGN KEY ([MaPhanQuyen]) REFERENCES [PhanQuyen]([MaPhanQuyen])
);

CREATE TABLE [KhuyenMai] (
	[MaKhuyenMai] nvarchar(255),
	[TenKhuyenMai] nvarchar(255),
	[NgayBatDauKhuyenMai] date ,
	[NgayKetThucKhuyenMai] date ,
	[PhanTramKhuyenMai] float(53),
	[DieuKienKhuyenMai] int,
	PRIMARY KEY ([MaKhuyenMai])
);

CREATE TABLE [UuDaiThanhVien] (
	[MaUuDai] nvarchar(255),
	[TenUuDai] nvarchar(255),
	[NgayBatDauUuDai] date ,
	[NgayKetThucUuDai] date ,
	[PhanTramUuDai] float(53) ,
	[DieuKienUuDai] int,
	PRIMARY KEY ([MaUuDai]),
);

CREATE TABLE [KhachHang] (
	[MaKhachHang] nvarchar(255) ,
	[TenKhachHang] nvarchar(255) ,
	[NgaySinhKhachHang] date ,
	[GioiTinhKhachHang] nvarchar(255),
	[SoDienThoaiKhachHang] nvarchar(255) ,
	[ChiTieuKhachHang] int,
	--[MaUuDai] nvarchar(255),
	PRIMARY KEY ([MaKhachHang]),
	--FOREIGN KEY ([MaUuDai]) REFERENCES [UuDaiThanhVien]([MaUuDai]),
);

CREATE TABLE [HoaDon] (
	[MaHoaDon] nvarchar(255) ,
	[NgayLapHoaDon] date ,
	[TongTienHoaDon] int,
	[MaNhanVien] nvarchar(255) ,
	[MaKhachHang] nvarchar(255) ,
	[MaUuDai] nvarchar(255),
	[MaKhuyenMai] nvarchar(255) ,
	PRIMARY KEY ([MaHoaDon]),
	FOREIGN KEY ([MaNhanVien]) REFERENCES [NhanVien]([MaNhanVien]),
	FOREIGN KEY ([MaKhachHang]) REFERENCES [KhachHang]([MaKhachHang]),
	FOREIGN KEY ([MaUuDai]) REFERENCES [UuDaiThanhVien]([MaUuDai]),
	FOREIGN KEY ([MaKhuyenMai]) REFERENCES [KhuyenMai]([MaKhuyenMai])
);

CREATE TABLE [LoaiMon] (
	[MaLoaiMon] nvarchar(255) ,
	[TenLoaiMon] nvarchar(255) ,
	[TrangThaiLoaiMon] bit,
	PRIMARY KEY ([MaLoaiMon])
);

CREATE TABLE [NguyenLieu] (
	[MaNguyenLieu] nvarchar(255) ,
	[TenNguyenLieu] nvarchar(255) ,
	[KhoiLuongNguyenLieu] float,
	[DonGiaNguyenLieu] int,
	[TrangThaiNguyenLieu] bit,
	PRIMARY KEY ([MaNguyenLieu])
);

CREATE TABLE [Mon] (
	[MaMon] nvarchar(255) ,
	[MaLoaiMon] nvarchar(255),
	[TenMon] nvarchar(255),
	[HinhAnh] nvarchar(255),
	[DonGiaMon] int,
	[TrangThaiMon] bit,
	PRIMARY KEY ([MaMon]),
	FOREIGN KEY ([MaLoaiMon]) REFERENCES [LoaiMon]([MaLoaiMon])
);

CREATE TABLE [CongThuc] (
	[MaMon] nvarchar(255),
	[MaNguyenLieu] nvarchar(255),
	[KhoiLuong] float,
	FOREIGN KEY ([MaNguyenLieu]) REFERENCES [NguyenLieu]([MaNguyenLieu]),
	FOREIGN KEY ([MaMon]) REFERENCES [Mon]([MaMon])
);


CREATE TABLE [ChiTietHoaDon] (
	[MaHoaDon] nvarchar(255),
	[MaMon] nvarchar(255),
	[DonGia] int,
	[ThanhTien] int,
	[SoLuong] int,

	PRIMARY KEY ([MaHoaDon], [MaMon]),
	FOREIGN KEY ([MaHoaDon]) REFERENCES [HoaDon]([MaHoaDon]),
	FOREIGN KEY ([MaMon]) REFERENCES [Mon]([MaMon])
);

CREATE TABLE [NhaCungCap] (
	[MaNhaCungCap] nvarchar(255),
	[TenNhaCungCap] nvarchar(255),
	[DiaChiNhaCungCap] nvarchar(255),
	[SoDienThoaiNhaCungCap] nvarchar(255),
	PRIMARY KEY ([MaNhaCungCap])
);

CREATE TABLE [PhieuNhap] (
	[MaPhieuNhap] nvarchar(255) ,
	[NgayLapPhieuNhap] date ,
	[TongTienPhieuNhap] int,
	[MaNhanVien] nvarchar(255) ,
	[MaNhaCungCap] nvarchar(255) ,
	PRIMARY KEY ([MaPhieuNhap]),
	FOREIGN KEY ([MaNhanVien]) REFERENCES [NhanVien]([MaNhanVien]),
	FOREIGN KEY ([MaNhaCungCap]) REFERENCES [NhaCungCap]([MaNhaCungCap])
);

CREATE TABLE [ChiTietPhieuNhap] (
	[MaPhieuNhap] nvarchar(255),
	[MaNguyenLieu] nvarchar(255),
	[DonGia] int,
	[ThanhTien] int,
	[KhoiLuong] float,

	PRIMARY KEY ([MaPhieuNhap], [MaNguyenLieu]),
	FOREIGN KEY ([MaPhieuNhap]) REFERENCES [PhieuNhap]([MaPhieuNhap]),
	FOREIGN KEY ([MaNguyenLieu]) REFERENCES NguyenLieu([MaNguyenLieu])
);