# Lab 4 - Hệ thống E-SHOPPING

## 1. Mục tiêu của Lab 4
Lab 4 tập trung vào việc xây dựng cơ sở dữ liệu và giao diện quản trị cho hệ thống thương mại điện tử e-shopping. Trong quá trình làm lab, nhóm đã thiết kế các bảng nghiệp vụ chính, xác định quan hệ giữa các đối tượng và triển khai một giao diện dashboard quản lý theo hướng admin.

## 2. Những gì đã thực hiện

### 2.1 Thiết kế và tạo cơ sở dữ liệu
Trong file `SQLQuery1.sql`, nhóm đã tạo database `ESHOPPING` với các bảng chính sau:
- `NHOMSANPHAM`
- `NHASANXUAT`
- `SANPHAM`
- `KHACHHANG`
- `GIOHANG` và `CT_GIOHANG`
- `HINHTHUCGIAOHANG`
- `KHUVUCGIAOHANG`
- `CHIPHIGIAOHANG`
- `DONDATHANG`
- `CT_DONDATHANG`
- `THETINDUNG`
- `THANHTOAN`
- `PHITHANHTOAN`
- `EMAILXACNHAN`

Các bảng này được thiết kế với:
- khóa chính (`PRIMARY KEY`)
- khóa ngoại (`FOREIGN KEY`)
- ràng buộc dữ liệu (`CHECK`)
- tính duy nhất (`UNIQUE`)

### 2.2 Mô hình nghiệp vụ của hệ thống
Hệ thống e-shopping bao gồm các chức năng chính sau:
- Quản lý nhóm sản phẩm
- Quản lý nhà sản xuất
- Quản lý sản phẩm và tình trạng hàng hóa
- Quản lý khách hàng và tài khoản người dùng
- Quản lý giỏ hàng và chi tiết giỏ hàng
- Quản lý hình thức giao hàng và chi phí giao hàng
- Tạo và quản lý đơn đặt hàng
- Xử lý thanh toán bằng thẻ tín dụng
- Gửi email xác nhận đơn hàng

### 2.3 Thiết kế giao diện quản trị
Nhóm đã xây dựng một giao diện chính theo dạng Admin Dashboard bằng Java Swing, file chính:
- `src/EcommerceDashboard.java`

Giao diện gồm các phần chính:
- Sidebar điều hướng
- Thẻ thống kê KPI (đơn hàng, doanh thu, khách hàng, sản phẩm)
- Biểu đồ doanh thu theo tháng
- Danh mục bán chạy
- Bảng đơn hàng gần đây
- Danh sách sản phẩm nổi bật

### 2.4 Các chức năng hiển thị trên dashboard
- Hiển thị tổng quan hệ thống
- Hiển thị số lượng đơn hàng trong tháng
- Hiển thị doanh thu và xu hướng tăng trưởng
- Hiển thị số lượng khách hàng mới
- Hiển thị số lượng sản phẩm trong kho
- Hiển thị danh mục sản phẩm bán chạy
- Hiển thị đơn hàng gần đây và trạng thái giao dịch

## 3. Cấu trúc project
```text
LAB4/
├── README.MD
├── SQLQuery1.sql
├── src/
│   └── EcommerceDashboard.java
├── out/
│   └── file .class đã biên dịch
├── class.drawio
├── erd.drawio
├── sequence.drawio
├── state.drawio
├── usecase.drawio
└── ...
```

## 4. Công nghệ sử dụng
- Java Swing
- SQL Server
- Database schema design theo mô hình e-commerce
- Giao diện desktop quản trị

## 5. Cách chạy
### Chạy giao diện Java
```bash
cd LAB4
javac -d out src\EcommerceDashboard.java
java -cp out EcommerceDashboard
```

### Tạo database SQL Server
- Mở SQL Server Management Studio
- Chạy file `SQLQuery1.sql`
- Kiểm tra database `ESHOPPING` đã được tạo

## 6. Kết luận
Lab 4 đã hoàn thành việc:
- thiết kế cơ sở dữ liệu cho hệ thống e-shopping,
- xác định các quan hệ nghiệp vụ, 
- xây dựng giao diện quản trị chính theo dạng dashboard, 
- và cung cấp một nền tảng để tiếp tục phát triển các chức năng quản lý bán hàng trong tương lai.

## 7. Người thực hiện
- Sinh viên thực hiện Lab 4
- Chuyên ngành: OOSD
- Đề tài: E-SHOPPING
