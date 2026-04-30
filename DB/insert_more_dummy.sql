use QuanLyQuanCaPhe;
GO

-- 5 NhanVien
INSERT INTO [NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinhNhanVien], [SoDienThoaiNhanVien], [LuongNhanVien], [ChucVuNhanVien], [GioiTinhNhanVien], [TrangThaiNhanVien], [DiaChi]) 
VALUES 
('NV006', N'Đỗ Trọng Hiếu', '1996-03-12', '0912345601', 5000000, N'Nhân Viên', 'Nam', 1, N'567 Lê Lợi'),
('NV007', N'Vũ Mai Phương', '1997-07-22', '0912345602', 5500000, N'Nhân Viên', N'Nữ', 1, N'89 Nguyễn Huệ'),
('NV008', N'Lý Thành Đạt', '1994-11-05', '0912345603', 6500000, N'Quản Lý', 'Nam', 1, N'102 Pasteur'),
('NV009', N'Đinh Hà Thu', '1999-01-18', '0912345604', 5000000, N'Nhân Viên', N'Nữ', 1, N'45 Hai Bà Trưng'),
('NV010', N'Bùi Quang Tùng', '1993-09-30', '0912345605', 7000000, N'Quản Lý', 'Nam', 1, N'321 Trần Hưng Đạo');

-- 10 Mon (Sản phẩm)
INSERT INTO Mon (MaMon, MaLoaiMon, TenMon, HinhAnh, DonGiaMon, TrangThaiMon) 
VALUES
('M015', 'LM001', N'Americano', 'americano.jpg', 25000, 1),
('M016', 'LM001', N'Cold Brew', 'coldbrew.jpg', 35000, 1),
('M017', 'LM001', N'Macchiato', 'macchiato.jpg', 35000, 1),
('M018', 'LM001', N'Mocha', 'mocha.jpg', 38000, 1),
('M019', 'LM002', N'Trà Đào Cam Sả', 'tradaocamsa.jpg', 30000, 1),
('M020', 'LM002', N'Trà Vải', 'travai.jpg', 30000, 1),
('M021', 'LM002', N'Trà Lài', 'tralai.jpg', 25000, 1),
('M022', 'LM003', N'Sinh Tố Xoài', 'sinhtoxoai.jpg', 35000, 1),
('M023', 'LM003', N'Sinh Tố Mãng Cầu', 'sinhtomangcau.jpg', 40000, 1),
('M024', 'LM004', N'Nước Ép Dưa Hấu', 'epduahau.jpg', 30000, 1);

-- Thêm PhieuNhap
INSERT INTO [PhieuNhap] ([MaPhieuNhap], [NgayLapPhieuNhap], [TongTienPhieuNhap], [MaNhanVien], [MaNhaCungCap])
VALUES 
('PN006', '2024-10-10', 500000, 'NV006', 'NCC001'),
('PN007', '2024-10-12', 300000, 'NV007', 'NCC002');

-- Thêm ChiTietPhieuNhap
INSERT INTO [ChiTietPhieuNhap] ([MaPhieuNhap], [MaNguyenLieu], [DonGia], [ThanhTien], [KhoiLuong])
VALUES 
('PN006', 'NL001', 50000, 500000, 10),
('PN007', 'NL004', 30000, 300000, 10);

-- Thêm HoaDon
INSERT INTO HoaDon (MaHoaDon, NgayLapHoaDon, TongTienHoaDon, MaNhanVien, MaKhachHang, MaUuDai, MaKhuyenMai) VALUES
('HD006', '2024-10-15', 60000, 'NV006', 'KH001', NULL, NULL),
('HD007', '2024-10-16', 70000, 'NV007', 'KH002', NULL, NULL),
('HD008', '2024-10-17', 65000, 'NV008', 'KH003', NULL, NULL),
('HD009', '2024-10-18', 40000, 'NV009', 'KH004', NULL, NULL),
('HD010', '2024-10-19', 30000, 'NV010', 'KH005', NULL, NULL);

-- Thêm ChiTietHoaDon
INSERT INTO ChiTietHoaDon (MaHoaDon, MaMon, DonGia, ThanhTien, SoLuong) VALUES
('HD006', 'M015', 25000, 25000, 1),
('HD006', 'M016', 35000, 35000, 1),
('HD007', 'M017', 35000, 70000, 2),
('HD008', 'M019', 30000, 30000, 1),
('HD008', 'M022', 35000, 35000, 1),
('HD009', 'M023', 40000, 40000, 1),
('HD010', 'M024', 30000, 30000, 1);
