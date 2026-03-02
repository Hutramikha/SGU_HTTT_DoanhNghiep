use QuanLyQuanCaPhe

INSERT INTO KhuyenMai (MaKhuyenMai, TenKhuyenMai, NgayBatDauKhuyenMai, NgayKetThucKhuyenMai, PhanTramKhuyenMai, DieuKienKhuyenMai)
VALUES 
('KM001', N'Khuyến mãi 20 tháng 11','2024-10-10', '2024-10-20', 10.5, 500000),
('KM002', N'Khuyến mãi khai trương', '2024-11-05', '2024-11-15', 15.0, 800000),
('KM003', N'Khuyến mãi cuối năm','2024-12-01', '2024-12-10', 20.0, 1000000),
('KM004', N'Khuyến mãi tháng 10','2024-11-05', '2024-11-15', 15.0, 800000),
('KM005', N'Khuyến mãi tháng 3','2024-12-01', '2024-12-10', 20.0, 1000000);

INSERT INTO UuDaiThanhVien (MaUuDai, TenUuDai, NgayBatDauUuDai, NgayKetThucUuDai, PhanTramUuDai, DieuKienUuDai)
VALUES
('UD001', N'Ưu đãi thành viên chi tiêu trên 10tr','2024-10-01', '2024-10-31', 5.0, 200000),
('UD002', N'Ưu đãi thành viên chi tiêu trên 500K','2024-11-01', '2024-11-30', 8.0, 300000),
('UD003', N'Ưu đãi thành viên chi tiêu trên 100K','2024-12-01', '2024-12-31', 10.0, 400000),
('UD004', N'Ưu đãi thành viên chi tiêu trên 10tr', '2024-11-01', '2024-11-30', 8.0, 300000),
('UD005', N'Ưu đãi thành viên chi tiêu trên 20tr','2024-12-01', '2024-12-31', 10.0, 400000);

------ INSERT
-- Inserting sample records into the CaLam table
INSERT INTO [CaLam] ([MaCaLam], [TenCaLam], [ThoiGianVaoCaLam], [ThoiGianRaCalam], [TrangThaiCaLam]) 
VALUES 
('CL001', 'Ca A', '06:00:00', '14:00:00', 1),
('CL002', 'Ca B',  '14:00:00', '22:00:00', 1),
('CL003', 'Ca C',  '12:00:00', '22:00:00', 0);

-- Inserting sample records into the NhanVien table
INSERT INTO [NhanVien] ([MaNhanVien], [TenNhanVien], [NgaySinhNhanVien], [SoDienThoaiNhanVien], [LuongNhanVien], [ChucVuNhanVien], [GioiTinhNhanVien], [TrangThaiNhanVien], [DiaChi]) 
VALUES 
('NV001', N'Nguyễn Văn A', '1990-01-01', '123456789', 5000000, N'Nhân Viên', 'Nam', 1, '1234 An Dương Vương'),
('NV002', N'Trần Thị B', '1995-05-10', '987654321', 6000000, N'Quản Lý', N'Nữ', 1, '1234 An Dương Vương'),
('NV003', N'Lê Văn C', '1988-12-15', '456123789', 7000000, N'Quản Lý', 'Nam', 0, '1234 An Dương Vương'),
('NV004', N'Phạm Anh D', '1992-08-20', '789456123', 5500000, N'Nhân Viên', 'Nam', 1, '1234 An Dương Vương'),
('NV005', N'Hoàng Thi E', '1998-04-25', '321654987', 5200000, N'Nhân Viên', N'Nữ', 0, '1234 An Dương Vương');

/*
-- Inserting sample records into the LichLam table
INSERT INTO [LichLam] ([MaCaLam], [MaNhanVien], [NgayLam]) 
VALUES 
('CL001', 'NV001', '2024-09-28'),
('CL001', 'NV002', '2024-09-28'),
('CL001', 'NV003', '2024-09-28'),
('CL002', 'NV004', '2024-09-28'),
('CL002', 'NV005', '2024-09-28');
*/

-- Inserting sample records into the PhanQuyen table
INSERT INTO [PhanQuyen] ([MaPhanQuyen], [TenQuyen],[QuyenKhachHang], [QuyenBanHang], [QuyenNhapHang], [QuyenMon], [QuyenNguyenLieu], [QuyenLichLam], [QuyenKhuyenMaiUuDai], [QuyenNhaCungCap], [QuyenNhanVien], [QuyenThongKe], [TrangThaiPhanQuyen]) 
VALUES 
('PQ001', N'Quản Lý', 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1),
('PQ002', N'Nhân Viên', 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1),
('PQ003', N'Quản Lý Chi Nhánh', 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 1);

-- delete from [PhanQuyen]

-- Inserting sample records into the TaiKhoan table
INSERT INTO [TaiKhoan] ([MaTaiKhoan], [TenDangNhap], [MatKhau], [MaPhanQuyen], [MaNhanVien], [NgayCap], [NgayNghiViec],[TrangThaiTaiKhoan]) 
VALUES 
('TK001', 'user1', 'password1', 'PQ001', 'NV001', '2024-01-20', null, 1),
('TK002', 'user2', 'password2', 'PQ002', 'NV002', '2024-01-20', null, 1),
('TK003', 'user3', 'password3', 'PQ003', 'NV003', '2024-01-20', '2024-05-20', 0),
('TK004', 'user4', 'password4', 'PQ001', 'NV004', '2024-01-20', null, 1),
('TK005', 'user5', 'password5', 'PQ002', 'NV005', '2024-01-20', null, 1);

-- Inserting sample records into the KhachHang table
INSERT INTO [KhachHang] ([MaKhachHang], [TenKhachHang], [NgaySinhKhachHang], [GioiTinhKhachHang], [SoDienThoaiKhachHang], [ChiTieuKhachHang]) 
VALUES 
('KH001', N'Nguyễn Văn A', '1990-02-15', 'Nam', '123456789', 500000),
('KH002', N'Trần Bảo Long', '1995-06-20', 'Nam', '987654321', 600000),
('KH003', N'Lê Thị Thu', '1988-03-10', N'Nữ', '456123789', 700000),
('KH004', N'Phạm Huy Hoàng', '1992-09-25', 'Nam', '789456123', 550000),
('KH005', N'Nguyễn Thị Hương', '1998-05-30', N'Nữ', '321654987', 520000);


-- Dữ liệu mẫu cho bảng LoaiMon
INSERT INTO LoaiMon (MaLoaiMon, TenLoaiMon, TrangThaiLoaiMon) VALUES
('LM001', N'Cà Phê', 1),
('LM002', N'Trà', 1),
('LM003', N'Sinh Tố', 1),
('LM004', N'Nước Ép', 1),
('LM005', N'Cacao', 1);

INSERT INTO Mon (MaMon, MaLoaiMon, TenMon, HinhAnh, DonGiaMon, TrangThaiMon) 
VALUES
('M001', 'LM001', N'Cà Phê Đen', 'caPheDen.jpg', 20000, 1),
('M002', 'LM001', N'Cappuccino', 'cappuccino.jpg', 30000, 1),
('M003', 'LM002', N'Trà Xanh', 'traXanh.jpg', 25000, 1),
('M004', 'LM003', N'Sinh Tố Dâu', 'sinhToDau.jpg', 35000, 1),
('M005', 'LM001', N'Cà Phê Muối', 'caPheMuoi.jpg', 28000, 1),
('M006', 'LM001', N'Latte', 'latte.jpg', 20000, 1),
('M007', 'LM001', N'Cà Phê Trứng', 'caPheTrung.jpg', 30000, 1),
('M008', 'LM004', N'Cam Ép Hạt Chia', 'epCamHatChia.jpg', 25000, 1),
('M009', 'LM003', N'Sinh Tố Bơ', 'sinhToBo.jpg', 35000, 1),
('M010', 'LM004', N'Ép Ổi', 'epOi.jpg', 28000, 1),
('M011', 'LM002', N'Trà Dâu Tằm', 'traDauTam.jpg', 25000, 1),
('M012', 'LM002', N'Trà Dâu Tây', 'traDauTay.jpg', 25000, 1),
('M013', 'LM002', N'Trà Ổi', 'traOi.jpg', 25000, 1),
('M014', 'LM002', N'Trà Việt Quất', 'traVietQuat.jpg', 25000, 1);

-- Nguyên liệu cho bảng NguyenLieu
INSERT INTO NguyenLieu (MaNguyenLieu, TenNguyenLieu, KhoiLuongNguyenLieu, DonGiaNguyenLieu, TrangThaiNguyenLieu) VALUES
('NL001', N'Cà Phê', 10, 2000000, 1),  -- Cà Phê
('NL002', N'Nước Đường', 5, 100000, 1),  -- Nước Đường
('NL003', N'Muối Ăn', 1, 10000, 1),  -- Muối Ăn
('NL004', N'Sữa Tươi', 5, 250000, 1),  -- Sữa Tươi
('NL005', N'Trà Xanh', 5, 800000, 1),  -- Trà Xanh
('NL006', N'Dâu Tây', 2, 400000, 1),  -- Dâu Tây
('NL007', N'Sữa Đặc', 2, 100000, 1),  -- Sữa Đặc
('NL008', N'Trứng', 1, 80000, 1),  -- Trứng
('NL009', N'Cam', 1, 20000, 1),  -- Cam
('NL010', N'Hạt Chia', 0.8, 100000, 1),  -- Hạt Chia
('NL011', N'Bơ', 0.5, 100000, 1),  -- Bơ
('NL012', N'Ổi', 1, 25000, 1),  -- Ổi
('NL013', N'Dâu Tằm', 0.5, 50000, 1),  -- Dâu Tằm
('NL014', N'Việt Quất', 0.5, 200000, 1);  -- Việt Quất

-- Dữ liệu cho bảng CongThuc
INSERT INTO [CongThuc] (MaMon, MaNguyenLieu, KhoiLuong)
VALUES 
('M001', 'NL001', 0.6),  -- Cà Phê Đen - Cà Phê
('M001', 'NL002', 0.02), -- Cà Phê Đen - Đường
('M001', 'NL003', 0.01), -- Cà Phê Đen - Muối
('M002', 'NL001', 0.5),  -- Cappuccino - Cà Phê
('M002', 'NL002', 0.05), -- Cappuccino - Đường
('M002', 'NL004', 0.2),  -- Cappuccino - Sữa Tươi
('M002', 'NL007', 0.1),  -- Cappuccino - Sữa Đặc
('M003', 'NL005', 0.5),  -- Trà Xanh - Trà Xanh
('M003', 'NL002', 0.05), -- Trà Xanh - Đường
('M004', 'NL006', 0.3),  -- Sinh Tố Dâu - Dâu Tây
('M004', 'NL007', 0.1),  -- Sinh Tố Dâu - Sữa Đặc
('M004', 'NL002', 0.05), -- Sinh Tố Dâu - Đường
('M005', 'NL001', 0.5),  -- Cà Phê Muối - Cà Phê
('M005', 'NL002', 0.02), -- Cà Phê Muối - Đường
('M005', 'NL003', 0.02), -- Cà Phê Muối - Muối
('M006', 'NL001', 0.5),  -- Latte - Cà Phê
('M006', 'NL004', 0.3),  -- Latte - Sữa Tươi
('M006', 'NL007', 0.1),  -- Latte - Sữa Đặc
('M007', 'NL001', 0.5),  -- Cà Phê Trứng - Cà Phê
('M007', 'NL008', 0.2),  -- Cà Phê Trứng - Trứng
('M007', 'NL002', 0.03), -- Cà Phê Trứng - Đường
('M008', 'NL009', 0.5),  -- Cam Ép Hạt Chia - Cam
('M008', 'NL010', 0.3),  -- Cam Ép Hạt Chia - Hạt Chia
('M009', 'NL011', 0.3),  -- Sinh Tố Bơ - Bơ
('M009', 'NL006', 0.3),  -- Sinh Tố Bơ - Dâu Tây
('M009', 'NL007', 0.1),  -- Sinh Tố Bơ - Sữa Đặc
('M010', 'NL012', 0.5),  -- Ép Ổi - Ổi
('M010', 'NL009', 0.2),  -- Ép Ổi - Cam
('M010', 'NL007', 0.1),  -- Ép Ổi - Sữa Đặc
('M011', 'NL013', 0.4),  -- Trà Dâu Tằm - Dâu Tằm
('M011', 'NL002', 0.05), -- Trà Dâu Tằm - Đường
('M012', 'NL006', 0.3),  -- Trà Dâu Tây - Dâu Tây
('M012', 'NL002', 0.05), -- Trà Dâu Tây - Đường
('M013', 'NL012', 0.5),  -- Trà Ổi - Ổi
('M013', 'NL002', 0.05), -- Trà Ổi - Đường
('M014', 'NL014', 0.3),  -- Trà Việt Quất - Việt Quất
('M014', 'NL002', 0.05); -- Trà Việt Quất - Đường

-- Dữ liệu mẫu cho bảng HoaDon
INSERT INTO HoaDon (MaHoaDon, NgayLapHoaDon, TongTienHoaDon, MaNhanVien, MaKhachHang, MaUuDai, MaKhuyenMai) VALUES
('HD001', '2024-10-01', 75000, 'NV001', 'KH001', 'UD001', 'KM001'),
('HD002', '2024-10-02', 105000, 'NV002', 'KH002', 'UD002', 'KM002'),
('HD003', '2024-10-03', 55000, 'NV003', 'KH003', 'UD003', 'KM003'),
('HD004', '2024-10-04', 85000, 'NV004', 'KH004', 'UD004', 'KM003'),
('HD005', '2024-10-05', 95000, 'NV005', 'KH005', 'UD005', 'KM003');

-- Dữ liệu mẫu cho bảng ChiTietHoaDon
INSERT INTO ChiTietHoaDon (MaHoaDon, MaMon, DonGia, ThanhTien, SoLuong) VALUES
('HD001', 'M001', 20000, 20000, 1),
('HD001', 'M003', 25000, 25000, 1),
('HD002', 'M002', 30000, 60000, 2),
('HD002', 'M004', 35000, 35000, 1),
('HD003', 'M001', 20000, 20000, 1);

-- Bảng NhaCungCap
INSERT INTO [NhaCungCap] ([MaNhaCungCap], [TenNhaCungCap], [DiaChiNhaCungCap], [SoDienThoaiNhaCungCap])
VALUES 
    ('NCC001', N'Công ty TNHH ABC', N'123 Đường ABC, TP. Hồ Chí Minh', '0123456789'),
    ('NCC002', N'Công ty XYZ', N'456 Đường XYZ, TP. Hà Nội', '0987654321'),
    ('NCC003', N'Cửa hàng MNP', N'789 Đường MNP, TP. Đà Nẵng', '0369852147'),
    ('NCC004', N'Chợ Lớn', N'1012 Đường KLM, TP. Cần Thơ', '0765432198'),
    ('NCC005', N'Siêu thị UVW', N'1518 Đường UVW, TP. Hải Phòng', '0932145786');

-- Bảng PhieuNhap
INSERT INTO [PhieuNhap] ([MaPhieuNhap], [NgayLapPhieuNhap], [TongTienPhieuNhap], [MaNhanVien], [MaNhaCungCap])
VALUES 
    ('PN001', '2024-10-01', 150000, 'NV001', 'NCC001'),
    ('PN002', '2024-10-02', 120000, 'NV002', 'NCC002'),
    ('PN003', '2024-10-03', 180000, 'NV003', 'NCC003'),
    ('PN004', '2024-10-04', 90000, 'NV004', 'NCC004'),
    ('PN005', '2024-10-05', 135000, 'NV005', 'NCC005');

-- Bảng ChiTietPhieuNhap
INSERT INTO [ChiTietPhieuNhap] ([MaPhieuNhap], [MaNguyenLieu], [DonGia], [ThanhTien], [KhoiLuong])
VALUES 
    ('PN001', 'NL001', 5000, 10000, 2),
    ('PN002', 'NL002', 4500, 9000, 2),
    ('PN003', 'NL003', 4000, 16000, 4),
    ('PN004', 'NL004', 2000, 4000, 2),
    ('PN005', 'NL005', 3500, 10500, 3);

-----select
SELECT * FROM [CaLam];

SELECT * FROM [NhanVien];

SELECT * FROM [LichLam];

SELECT * FROM [PhanQuyen];

SELECT * FROM [TaiKhoan];

SELECT * FROM [KhachHang];

SELECT * FROM [KhuyenMai];

SELECT * FROM [UuDaiThanhVien];

SELECT * FROM [HoaDon];

SELECT * FROM [LoaiMon];

SELECT * FROM [NguyenLieu];

SELECT * FROM [CongThuc];

SELECT * FROM [Mon];

SELECT * FROM [ChiTietHoaDon];

SELECT * FROM [NhaCungCap];

SELECT * FROM [PhieuNhap];

SELECT * FROM [ChiTietPhieuNhap];

select * from TaiKhoan
