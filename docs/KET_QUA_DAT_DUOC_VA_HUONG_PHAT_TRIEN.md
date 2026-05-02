# CHƯƠNG X: KẾT QUẢ ĐẠT ĐƯỢC VÀ HƯỚNG PHÁT TRIỂN

## 1.1. Kết quả đạt được

### 1.1.1. Các chức năng đã hoàn thiện

Hệ thống Thông tin Doanh nghiệp quản lý quán cà phê đã được xây dựng hoàn chỉnh với **10 phân hệ chức năng** chính, bao gồm:

| STT | Phân hệ | Mô tả |
|-----|---------|-------|
| 1 | **Bán hàng** | Giao diện bán hàng kéo thả, lập hóa đơn, áp dụng khuyến mãi, chọn khách hàng thành viên |
| 2 | **Hóa đơn** | Tra cứu, quản lý toàn bộ lịch sử hóa đơn, xem chi tiết từng đơn hàng |
| 3 | **Khách hàng** | Thêm/sửa/xóa thông tin khách hàng, phân loại khách hàng thành viên |
| 4 | **Nhập hàng** | Lập phiếu nhập, quản lý phiếu nhập, chọn nhà cung cấp |
| 5 | **Thực đơn & Nguyên liệu** | Quản lý món, loại món, công thức pha chế, nguyên liệu và tồn kho |
| 6 | **Khuyến mãi & Ưu đãi** | Thiết lập chương trình khuyến mãi theo % và điều kiện áp dụng; quản lý ưu đãi thành viên |
| 7 | **Nhà cung cấp** | Quản lý danh sách nhà cung cấp nguyên liệu |
| 8 | **Nhân sự** | Quản lý thông tin nhân viên, ca làm, lịch làm, điểm danh, yêu cầu nghỉ phép |
| 9 | **Phân quyền** | Thiết lập quyền truy cập chi tiết theo từng tài khoản (Quản lý / Nhân viên) |
| 10 | **Thống kê & Báo cáo** | Biểu đồ doanh thu, chi phí, lợi nhuận, lương nhân viên; xuất báo cáo Excel |

---

### 1.1.2. Thành tựu kỹ thuật nổi bật

**a) Kiến trúc phân lớp rõ ràng (3-tier Architecture)**

Hệ thống được tổ chức theo mô hình **GUI → BUS → DAO → Database**, giúp tách biệt hoàn toàn giao diện, nghiệp vụ và truy xuất dữ liệu. Toàn bộ dự án gồm:
- **23 lớp BUS** xử lý nghiệp vụ
- **24 lớp DAO** truy xuất cơ sở dữ liệu
- **61 file GUI** xây dựng giao diện

**b) Hệ thống tính lương tự động**

Lương nhân viên được hệ thống tính toán hoàn toàn tự động dựa trên dữ liệu điểm danh thực tế từ ca làm việc, sử dụng công thức:

> `Lương = (Tổng giờ làm thực tế) × (Lương cơ bản / 208 giờ chuẩn)`

Tính năng này loại bỏ hoàn toàn việc tính lương thủ công, giảm thiểu sai sót và tiết kiệm thời gian cho quản lý.

**c) Thống kê đa chiều với cơ chế Cache**

Module thống kê ứng dụng kỹ thuật **Parallel Preloading** và **Data Cache** để truy xuất dữ liệu bất đồng bộ, tối ưu hóa thời gian tải biểu đồ. Hệ thống cung cấp báo cáo theo:
- Doanh thu (Tuần / Tháng / Quý / Năm)
- Chi phí nhập hàng và lương nhân viên
- Lợi nhuận ròng
- Tỉ lệ tồn kho nguyên liệu (Biểu đồ tròn Pie Chart)

**d) Hệ thống giao diện nhất quán (Sage Green Design System)**

Toàn bộ ứng dụng sử dụng bộ màu **Sage Green** được định nghĩa tập trung trong `UIHelper.java`, đảm bảo tính thống nhất về màu sắc, font chữ và các hiệu ứng hover trên toàn bộ giao diện.

**e) Xuất báo cáo Excel**

Hệ thống hỗ trợ xuất dữ liệu thống kê (Doanh thu, Chi phí, Lợi nhuận, Bảng lương chi tiết theo từng nhân viên) ra file `.xlsx` phục vụ lưu trữ và thanh toán lương.

---

## 1.2. Đánh giá Hệ thống

### 1.2.1. Ưu điểm

- **Tự động hóa cao:** Các nghiệp vụ phức tạp như tính lương, tính lợi nhuận, kiểm tra tồn kho đều được tự động hóa hoàn toàn dựa trên dữ liệu thực tế trong cơ sở dữ liệu.
- **Kiến trúc mở rộng được:** Nhờ mô hình 3 lớp, việc thêm chức năng mới hoặc thay đổi logic nghiệp vụ không ảnh hưởng đến giao diện.
- **Phân quyền chi tiết:** Hệ thống cho phép thiết lập quyền truy cập theo từng chức năng cụ thể cho từng tài khoản, đảm bảo an toàn dữ liệu.
- **Hiệu năng tốt:** Cơ chế tải song song (CompletableFuture) và cache dữ liệu thống kê giúp hệ thống phản hồi nhanh ngay cả khi dữ liệu lớn.
- **Giao diện thân thiện:** Thiết kế nhất quán, hỗ trợ kéo thả (Drag & Drop) trong bán hàng và sắp xếp ca làm, giúp người dùng thao tác trực quan.

### 1.2.2. Hạn chế

- **Ứng dụng Desktop:** Hệ thống được xây dựng bằng Java Swing nên chỉ chạy trên máy tính cục bộ, không thể truy cập từ xa qua trình duyệt hoặc thiết bị di động.
- **Kết nối trực tiếp đến SQL Server:** Hệ thống yêu cầu kết nối mạng nội bộ đến cơ sở dữ liệu SQL Server, chưa hỗ trợ môi trường Cloud hay triển khai phân tán.
- **Chưa tích hợp thanh toán điện tử:** Chức năng thanh toán hiện chỉ ghi nhận thông tin, chưa kết nối với cổng thanh toán điện tử (Momo, VNPay, ZaloPay...).
- **Điểm danh thủ công:** Nhân viên phải tự điểm danh trên phần mềm, chưa tích hợp với thiết bị phần cứng như máy quét vân tay hay thẻ từ.
- **Báo cáo chưa đa dạng:** Các mẫu báo cáo in ấn (PDF) chưa được hỗ trợ; hiện tại chỉ xuất được định dạng Excel.

---

## 1.3. Hướng Phát triển

### 1.3.1. Nâng cấp nền tảng

- **Chuyển đổi sang Web Application:** Xây dựng lại giao diện trên nền tảng Web (Spring Boot + React/Vue.js) hoặc mobile (Android/iOS) để quản lý có thể theo dõi và điều hành từ bất kỳ đâu.
- **Triển khai Cloud:** Đưa cơ sở dữ liệu lên dịch vụ Cloud (AWS RDS, Azure SQL) để tăng tính sẵn sàng và khả năng sao lưu dữ liệu tự động.

### 1.3.2. Mở rộng chức năng

- **Tích hợp thanh toán điện tử:** Kết nối với các cổng thanh toán phổ biến như Momo, VNPay để hỗ trợ thanh toán không dùng tiền mặt ngay trong giao diện bán hàng.
- **Tích hợp thiết bị chấm công:** Kết nối với máy chấm công vân tay hoặc thẻ từ để tự động cập nhật trạng thái điểm danh vào hệ thống, loại bỏ điểm danh thủ công.
- **In hóa đơn nhiệt:** Tích hợp in hóa đơn trực tiếp ra máy in nhiệt (POS Printer) sau khi thanh toán.
- **Hệ thống thông báo (Notification):** Tự động gửi thông báo nhắc nhở qua email hoặc SMS khi nguyên liệu sắp hết, lịch làm sắp đến, hoặc chương trình khuyến mãi sắp hết hạn.

### 1.3.3. Nâng cao phân tích dữ liệu

- **Tích hợp AI dự báo:** Ứng dụng học máy (Machine Learning) để dự báo doanh thu theo mùa vụ, gợi ý số lượng nhập hàng tối ưu dựa trên lịch sử bán hàng.
- **Dashboard thời gian thực:** Xây dựng bảng điều khiển (Dashboard) cập nhật dữ liệu theo thời gian thực (Real-time) thay vì chỉ thống kê theo ngày.
- **Phong phú mẫu báo cáo:** Bổ sung xuất báo cáo định dạng PDF chuyên nghiệp phục vụ nhu cầu in ấn và trình bày với đối tác, cơ quan thuế.

### 1.3.4. Nâng cao bảo mật

- **Xác thực hai yếu tố (2FA):** Thêm lớp bảo mật OTP qua email hoặc điện thoại khi đăng nhập.
- **Ghi nhật ký hoạt động (Audit Log):** Theo dõi toàn bộ các thao tác nhạy cảm (xóa dữ liệu, thay đổi quyền truy cập) để phục vụ kiểm toán nội bộ.

---

*Nhìn chung, hệ thống đã đáp ứng tốt các yêu cầu quản lý cơ bản của một quán cà phê vừa và nhỏ. Với các hướng phát triển nêu trên, hệ thống có tiềm năng mở rộng thành một nền tảng quản lý chuỗi cửa hàng F&B chuyên nghiệp trong tương lai.*
