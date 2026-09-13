# ☕ Hệ Thống Quản Lý Quán Cà Phê (Coffee Shop Management System)

<p align="center">
  <img src="src/IMAGE/logochinh.png" alt="Logo Cà Phê Xanh" width="120" />
</p>

<p align="center">
  <b>Hệ thống phần mềm quản lý vận hành quán cà phê toàn diện</b><br>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk" alt="Java 17" />
  <img src="https://img.shields.io/badge/GUI-Java%20Swing-blue?style=flat-square" alt="Java Swing" />
  <img src="https://img.shields.io/badge/Database-MS%20SQL%20Server-red?style=flat-square&logo=microsoftsqlserver" alt="SQL Server" />
  <img src="https://img.shields.io/badge/Architecture-3--Tier%20(DTO--DAO--BUS--GUI)-green?style=flat-square" alt="3-Tier" />
  <img src="https://img.shields.io/badge/Build-Ant%20%2F%20Batch-lightgrey?style=flat-square" alt="Build" />
</p>

---

## 📖 Giới Thiệu Dự Án

Dự án **Cà Phê Xanh - Hệ Thống Quản Lý Quán Cà Phê** được nghiên cứu và phát triển nhằm giải quyết các bài toán vận hành thực tế tại các chuỗi hoặc quán cà phê quy mô vừa và nhỏ. Trọng tâm của hệ thống là:

* **Tự động hóa định mức nguyên liệu (Recipe Management):** Khi hoàn tất đơn hàng POS, hệ thống tự động tính toán và khấu trừ lượng nguyên vật liệu trong kho dựa trên công thức pha chế của từng món.
* **Tối ưu quy trình vận hành:** Kết nối mượt mà giữa các bộ phận Bán hàng $\leftrightarrow$ Quản lý kho $\leftrightarrow$ Nhân sự $\leftrightarrow$ Báo cáo tài chính.
* **Hạn chế thất thoát và sai sót:** Quản lý kho theo thời gian thực, cảnh báo nguyên liệu chạm ngưỡng tồn an toàn hoặc hết hạn sử dụng.
* **Quản trị nhân sự & tính lương:** Quản lý ca trực, lịch làm việc hàng tuần, điểm danh, xin nghỉ phép và tính lương tự động theo giờ làm thực tế.

---

## 🏛 Kiến Trúc Hệ Thống (System Architecture)

Dự án áp dụng chặt chẽ mô hình kiến trúc đa tầng (**Multi-Tier / 3-Tier Architecture**), đảm bảo tính module hóa, dễ bảo trì và mở rộng:

```
┌────────────────────────────────────────────────────────┐
│               PRESENTATION LAYER (GUI)                 │
│   Java Swing (Forms & Custom Components, UIHelper)     │
└──────────────────────────┬─────────────────────────────┘
                           │ Data / Actions
┌──────────────────────────▼─────────────────────────────┐
│             BUSINESS LOGIC LAYER (BUS)                 │
│      Kiểm tra nghiệp vụ, tính toán tiền & chiết khấu    │
└──────────────────────────┬─────────────────────────────┘
                           │ Operations
┌──────────────────────────▼─────────────────────────────┐
│              DATA ACCESS LAYER (DAO)                   │
│         Truy vấn & cập nhật CSDL qua JDBC Pool         │
└──────────────────────────┬─────────────────────────────┘
                           │ SQL Queries
┌──────────────────────────▼─────────────────────────────┐
│                 DATABASE (SQL SERVER)                  │
│       18 bảng dữ liệu quan hệ, ràng buộc toàn vẹn      │
└────────────────────────────────────────────────────────┘
```

* **DTO (Data Transfer Object):** Định nghĩa 18 đối tượng dữ liệu ánh xạ 1-1 với các bảng trong CSDL.
* **DAO (Data Access Object):** Thực thi các câu lệnh SQL (CRUD) trực tiếp xuống cơ sở dữ liệu.
* **BUS (Business Logic Layer):** Tiếp nhận dữ liệu từ GUI, áp dụng logic nghiệp vụ (tính chiết khấu, kiểm tra định lượng, đối soát kho...) trước khi chuyển tiếp cho DAO.
* **GUI (Graphical User Interface):** Giao diện Java Swing được chuẩn hóa bộ nhận diện màu sắc xanh lá (`UIHelper`), bo góc mềm mại (`PanelRound`), hiệu ứng hover tương tác cao.
* **Util Layer:** Chứa bộ quản lý kết nối CSDL có áp dụng **Connection Pool** (`JDBCUtil`), tiện ích đọc/ghi Excel (`XuLyFileExcel`), bộ icon vector (`IconGenerator`), bộ kiểm tra dữ liệu vào (`InputValidator`).

---

## ✨ Các Phân Hệ Chức Năng (Modules)

### 1. Phân hệ Điểm Bán Hàng (POS - Point of Sale)
* **Giao diện bán hàng trực quan:** Xem danh sách món ăn/thức uống kèm hình ảnh, tìm kiếm nhanh và lọc theo danh mục.
* **Quản lý giỏ hàng:** Tăng/giảm số lượng, ghi chú món, tính tổng tiền tự động.
* **Áp dụng khuyến mãi & Ưu đãi:** Tự động nhận diện hạng thành viên (Đồng, Bạc, Vàng, Kim Cương...) và gợi ý mã voucher giảm giá hợp lệ.
* **Khấu trừ kho theo công thức:** Tự động trừ tồn kho nguyên vật liệu ngay khi thanh toán hóa đơn.
* **In hóa đơn bán hàng:** Xuất và in chi tiết hóa đơn phục vụ khách hàng.

### 2. Phân hệ Quản Lý Khách Hàng & Thành Viên
* Quản lý thông tin khách hàng thân thiết (Họ tên, SĐT, Ngày sinh, Địa chỉ).
* Hệ thống tích lũy điểm thưởng theo giá trị từng đơn hàng.
* Phân cấp hạng thành viên tự động với các chính sách ưu đãi chiết khấu riêng biệt.

### 3. Phân hệ Quản Lý Kho & Nhập Hàng
* Quản lý danh mục nguyên vật liệu pha chế và hạn dùng.
* Lập phiếu nhập kho nguyên liệu từ nhà cung cấp theo thời gian thực.
* Lưu vết lịch sử nhập hàng và quản lý danh sách nhà cung cấp (NCC).
* Cảnh báo tồn kho khi nguyên liệu sắp cạn hoặc hết hạn.

### 4. Phân hệ Quản Lý Thực Đơn & Công Thức Pha Chế (Menu & Recipe)
* Thêm, xóa, sửa danh mục loại món và chi tiết món.
* Thiết lập công thức pha chế: Khai báo định lượng nguyên liệu chính xác cần dùng cho từng món.

### 5. Phân hệ Quản Lý Nhân Sự & Chấm Công
* Quản lý hồ sơ nhân viên (thông tin liên lạc, vị trí công việc, mức lương theo giờ/theo ca).
* Phân chia ca làm việc (Sáng/Chiều/Tối) và xếp lịch làm hàng tuần.
* Cơ chế **điểm danh - chấm công** và hỗ trợ **tính lương tự động** theo ca làm thực tế.
* Quản lý đơn xin nghỉ phép / đổi ca: Nhân viên gửi đơn trực tuyến, Quản lý tiếp nhận và phê duyệt trên hệ thống.

### 6. Phân hệ Khuyến Mãi & Ưu Đãi
* Thiết lập các chương trình khuyến mãi theo thời gian bắt đầu - kết thúc, giá trị đơn hàng tối thiểu.
* Quản lý các gói ưu đãi theo từng cấp độ thẻ thành viên.

### 7. Phân hệ Báo Cáo & Thống Kê (Dashboard)
* Thống kê trực quan Doanh thu, Chi phí nhập hàng và Lợi nhuận ròng.
* Trực quan hóa dữ liệu bằng các biểu đồ đường và biểu đồ cột.
* Thống kê top sản phẩm bán chạy nhất trong ngày, tháng, năm.
* Hỗ trợ **nhập/xuất dữ liệu báo cáo và bảng lương ra file Excel (.xlsx)** chuẩn định dạng qua Apache POI.

### 8. Phân hệ Phân Quyền & Bảo Mật Hệ Thống
* Cơ chế xác thực tài khoản và mã hóa/bảo vệ đăng nhập.
* Hỗ trợ tài khoản Local Admin dự phòng phục vụ quản trị khẩn cấp khi mất kết nối CSDL phân quyền.
* Ma trận phân quyền chi tiết (Bán hàng, Khách hàng, Nhập hàng, Món, Nguyên liệu, Lịch làm, Khuyến mãi, Nhà cung cấp, Nhân viên, Thống kê) gán theo chức vụ.

---

## 🛠 Công Nghệ & Thư Viện Sử Dụng

| Hạng mục | Công nghệ / Thư viện | Mô tả vai trò |
| :--- | :--- | :--- |
| **Platform** | Java SE (JDK 17) | Môi trường lập trình chính |
| **Giao diện** | Java Swing + NetBeans Form | Thiết kế giao diện desktop ứng dụng |
| **Cơ sở dữ liệu** | Microsoft SQL Server | Hệ quản trị CSDL quan hệ chính |
| **JDBC Driver** | `mssql-jdbc-12.8.1.jre11.jar` | Kết nối Java với SQL Server |
| **Xử lý Excel** | `Apache POI 5.0.0` (ooxml, full, lite) | Đọc và xuất file bảng tính Excel (`.xlsx`) |
| **Vẽ biểu đồ** | `JFreeChart 1.0.23`, `XChart 3.8.8` | Vẽ biểu đồ thống kê doanh thu và báo cáo |
| **In ấn báo cáo** | `JasperReports 6.2.0` | Thiết kế và xuất bản hóa đơn, phiếu nhập |
| **UI Component** | `JCalendar 1.4` | Bộ chọn ngày tháng lịch cho giao diện Swing |

---

## 📂 Cấu Trúc Thư Mục Dự Án

```plaintext
SGU_Enterprise_Information_Systems/
├── DB/
│   ├── db_QuanLyQuanCaPhe.sql       # Script tạo bảng và ràng buộc CSDL (18 bảng)
│   ├── data_QuanLyQuanCaPhe.sql     # Dữ liệu mẫu khởi tạo
│   └── QuanLyQuanCaPhe.bacpac       # File backup CSDL SQL Server
├── src/
│   ├── DTO/                         # 18 lớp Data Transfer Object
│   ├── DAO/                         # 24 lớp Data Access Object
│   ├── BUS/                         # 23 lớp Business Logic Layer
│   ├── GUI/                         # Giao diện người dùng (Màn hình chính, POS, Dialogs)
│   ├── Util/                        # Tiện ích: JDBC Connection Pool, UIHelper, Excel...
│   ├── Lib/                         # Toàn bộ file thư viện JAR phụ thuộc
│   ├── IMAGE/                       # Tài nguyên hình ảnh, biểu tượng và logo
│   ├── EXCEL/                       # File template Excel mẫu
│   └── Main/
│       └── Main.java                # Điểm khởi chạy ứng dụng (Entry Point)
├── build.xml                        # File cấu hình Ant Build
├── connect.txt                      # File cấu hình thông số kết nối CSDL
├── run.bat                          # Script biên dịch và chạy ứng dụng nhanh trên Windows
└── README.md                        # Tài liệu hướng dẫn dự án
```

---

## 🗄️ Cấu Trúc Cơ Sở Dữ Liệu (Database Schema)

Hệ thống bao gồm **18 bảng dữ liệu quan hệ** được thiết kế chuẩn hóa:

1. `TaiKhoan`: Tài khoản đăng nhập hệ thống.
2. `PhanQuyen`: Danh mục quyền và ma trận các chức năng được phép thao tác.
3. `NhanVien`: Thông tin hồ sơ nhân sự, chức vụ, mức lương.
4. `CaLam`: Danh mục các ca làm việc trong ngày và khung giờ.
5. `LichLam`: Lịch phân công làm việc thực tế cho từng nhân viên.
6. `YeuCauNhanSu`: Đơn xin nghỉ phép, đổi ca và trạng thái phê duyệt.
7. `KhachHang`: Thông tin khách hàng và số điểm tích lũy.
8. `UuDaiThanhVien`: Bảng định mức chiết khấu theo các thứ hạng khách hàng.
9. `KhuyenMai`: Các chương trình khuyến mãi/giảm giá theo thời gian.
10. `LoaiMon`: Danh mục phân loại đồ uống/thức ăn.
11. `Mon`: Danh mục món, đơn giá, trạng thái bán.
12. `NguyenLieu`: Danh mục nguyên vật liệu tồn kho, đơn vị tính.
13. `CongThuc`: Định lượng chi tiết từng nguyên liệu cấu thành nên một món.
14. `NhaCungCap`: Danh bạ thông tin các nhà cung ứng.
15. `PhieuNhap`: Thông tin tổng quát phiếu nhập kho.
16. `ChiTietPhieuNhap`: Chi tiết số lượng và đơn giá nhập từng nguyên liệu.
17. `HoaDon`: Thông tin hóa đơn bán hàng POS.
18. `ChiTietHoaDon`: Danh sách món và số lượng trên từng hóa đơn.

---

## ⚙️ Hướng Dẫn Cài Đặt & Chạy Ứng Dụng

### 1. Yêu cầu môi trường
* **Hệ điều hành:** Windows 10 hoặc Windows 11.
* **Java Development Kit:** JDK 17 trở lên (đã cấu hình `JAVA_HOME` trong Environment Variables).
* **Hệ quản trị CSDL:** Microsoft SQL Server (2014 trở lên) kèm công cụ SSMS (SQL Server Management Studio).

### 2. Thiết lập Cơ sở dữ liệu
1. Mở **SQL Server Management Studio (SSMS)** và đăng nhập vào SQL Server.
2. Mở file [DB/db_QuanLyQuanCaPhe.sql](DB/db_QuanLyQuanCaPhe.sql) và nhấn **Execute** để tạo Database `QuanLyQuanCaPhe` cùng cấu trúc các bảng.
3. Mở file [DB/data_QuanLyQuanCaPhe.sql](DB/data_QuanLyQuanCaPhe.sql) và nhấn **Execute** để nạp dữ liệu mẫu ban đầu.
*(Hoặc có thể chọn import trực tiếp file backup [DB/QuanLyQuanCaPhe.bacpac](DB/QuanLyQuanCaPhe.bacpac)).*

### 3. Cấu hình kết nối CSDL
Mở file [connect.txt](connect.txt) tại thư mục gốc của dự án và cập nhật thông số kết nối của máy bạn theo định dạng 4 dòng:
```text
localhost
QuanLyQuanCaPhe
sa
123
```
* **Dòng 1:** Tên Server / Hostname (mặc định: `localhost` hoặc IP SQL Server).
* **Dòng 2:** Tên Database (mặc định: `QuanLyQuanCaPhe`).
* **Dòng 3:** Tên tài khoản SQL (thường là `sa`).
* **Dòng 4:** Mật khẩu tài khoản SQL.

### 4. Khởi chạy ứng dụng

#### Cách 1: Chạy trực tiếp bằng file Script (Khuyên dùng)
Dự án đã tích hợp sẵn script tự động biên dịch và chạy bằng Java 17:
* Nhấp đúp chuột vào file [run.bat](run.bat) tại thư mục gốc.
* Script sẽ tự động gom các file `.java` trong thư mục `src/`, liên kết thư viện trong `src/Lib/`, biên dịch vào `build/classes` và mở màn hình Đăng nhập.

#### Cách 2: Chạy thông qua IDE (NetBeans / IntelliJ / VS Code)
* **NetBeans IDE:** Chọn `File -> Open Project`, trỏ đến thư mục dự án và nhấn nút **Run** (F6).
* **VS Code / IntelliJ:** Cấu hình thư mục Source là `src`, bổ sung toàn bộ các file `.jar` trong thư mục `src/Lib` vào Classpath/Libraries của dự án, sau đó chạy hàm `main()` trong file [src/Main/Main.java](src/Main/Main.java).

---

## 📈 Hướng Phát Triển Mở Rộng

- **Nâng cấp nền tảng đa thiết bị:** Chuyển đổi kiến trúc Backend sang RESTful API (Spring Boot) và phát triển giao diện Web (React/Vue.js) & App điện thoại (Flutter).
- **Cơ sở dữ liệu Cloud:** Triển khai CSDL lên nền tảng đám mây (AWS RDS hoặc Azure SQL) phục vụ quản lý chuỗi nhiều chi nhánh.
- **Tích hợp thanh toán số:** Kết nối cổng thanh toán mã VietQR động, ví điện tử MoMo, VNPay, ZaloPay.
- **Tương tác phần cứng bán hàng:** Kết nối máy in nhiệt bill POS qua cổng LAN/USB, máy quét mã vạch Barcode/QR và máy chấm công thẻ/vân tay.
- **Ứng dụng Trí tuệ nhân tạo (AI/ML):** Phân tích xu hướng tiêu dùng khách hàng, dự báo doanh thu và tự động gợi ý đơn đặt hàng nguyên liệu thông minh.

