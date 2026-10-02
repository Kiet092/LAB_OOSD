# Hệ thống E-Shopping - Thiết kế UML

## 1. Giới thiệu
Dự án này là tập hợp các sơ đồ UML mô tả hệ thống đặt hàng và thanh toán trực tuyến cho một cửa hàng điện tử (e-shopping). Nội dung chính tập trung vào quy trình từ khi khách hàng xem sản phẩm, thêm vào giỏ hàng, đặt hàng, thanh toán, đến khi nhận email xác nhận và theo dõi trạng thái đơn hàng.

Hệ thống được mô hình hóa bằng các sơ đồ:
- Use Case Diagram
- Class Diagram
- Sequence Diagram
- State Diagram
- ERD (Entity Relationship Diagram)

---

## 2. Mục tiêu hệ thống
Hệ thống hỗ trợ các chức năng chính sau:
- Khách hàng xem danh sách sản phẩm
- Thêm sản phẩm vào giỏ hàng
- Đặt hàng và thanh toán
- Gửi email xác nhận đơn hàng
- Theo dõi trạng thái đơn hàng
- Lưu trữ thông tin khách hàng, đơn hàng, chi tiết đơn hàng và giao dịch thanh toán

---

## 3. Use Case Diagram
File: `usecase.drawio`

Sơ đồ use case mô tả các actor và chức năng của hệ thống:
- Actor: Khách hàng
- Actor: Cổng Thanh Toán
- Actor: Email Service

Các chức năng chính:
- Xem danh sách sản phẩm
- Thêm vào giỏ hàng
- Đặt hàng và thanh toán
- Theo dõi đơn hàng
- Thanh toán trực tuyến
- Gửi email xác nhận

Quy trình nghiệp vụ: khi khách hàng đặt hàng, hệ thống sẽ tương tác với cổng thanh toán để xử lý giao dịch và gửi email xác nhận cho khách hàng.

---

## 4. Class Diagram
File: `Class.drawio`

Sơ đồ lớp thiết kế mô tả các đối tượng quan trọng trong hệ thống:

- `CheckoutForm`
  - Chứa các trường nhập địa chỉ và phương thức thanh toán
  - Phương thức: `btnPay_Click()`

- `OrderController`
  - Quản lý việc tạo đơn hàng
  - Phương thức: `CreateOrder(cart: Cart): bool`

- `PaymentAdapter`
  - Tương tác với cổng thanh toán bên ngoài
  - Phương thức: `Pay(amount: decimal): bool`

- `EmailAdapter`
  - Gửi email xác nhận cho khách hàng
  - Phương thức: `SendEmail(to: string, subject: string, body: string)`

- `OrderRepository`
  - Lưu thông tin đơn hàng vào cơ sở dữ liệu
  - Phương thức: `InsertOrder(order: Order): bool`

- `Order`
  - Đại diện cho đơn hàng
  - Thuộc tính: `OrderId`, `CustomerId`, `TotalAmount`, `Status`

Mối quan hệ chính:
- `CheckoutForm` giao tiếp với `OrderController`
- `OrderController` gọi `PaymentAdapter`, `EmailAdapter`, `OrderRepository`
- `OrderRepository` làm việc với `Order`

---

## 5. Sequence Diagram
File: `Sequence.drawio`

Sơ đồ tuần tự mô tả chuỗi tương tác giữa các thành phần khi khách hàng thanh toán:
1. Khách hàng nhập thông tin và nhấn thanh toán trên `CheckoutForm`
2. `CheckoutForm` gọi `OrderController`
3. `OrderController` gửi yêu cầu thanh toán cho `PaymentAdapter`
4. `PaymentAdapter` kết nối với cổng thanh toán bên ngoài
5. Cổng thanh toán trả kết quả về cho hệ thống
6. `OrderController` lưu đơn hàng vào cơ sở dữ liệu
7. Hệ thống gọi `EmailAdapter` để gửi email xác nhận cho khách hàng
8. Khách hàng nhận thông báo kết quả giao dịch

---

## 6. ER Diagram
File: `ERD.drawio`

Sơ đồ cơ sở dữ liệu quan hệ mô tả các thực thể và quan hệ:

- `KHACH_HANG`
  - `MaKH` (PK)
  - `HoTen`
  - `Email`
  - `SoDienThoai`
  - `DiaChi`

- `DON_HANG`
  - `MaDH` (PK)
  - `MaKH` (FK)
  - `NgayDat`
  - `TongTien`
  - `TrangThai`

- `CHI_TIET_DON_HANG`
  - `MaDH` (PK, FK)
  - `MaSP` (PK, FK)
  - `SoLuong`
  - `DonGia`

- `SAN_PHAM`
  - `MaSP` (PK)
  - `TenSP`
  - `GiaBan`
  - `SoLuongTon`
  - `MaSP_External`

- `GIAO_DICH_THANH_TOAN`
  - `MaGD` (PK)
  - `MaDH` (FK, UK)
  - `PhuongThuc`
  - `MaGiaoDichNgoai`
  - `TrangThaiGD`
  - `NgayGD`

Quan hệ chính:
- Một khách hàng có nhiều đơn hàng
- Một đơn hàng có nhiều chi tiết đơn hàng
- Một sản phẩm có thể nằm trong nhiều chi tiết đơn hàng
- Một đơn hàng tương ứng với một giao dịch thanh toán

---

## 7. State Diagram
File: `State.drawio`

Sơ đồ trạng thái mô tả vòng đời của một đơn hàng:

`ChoThanhToan -> DaThanhToan -> DangXuLy -> DangGiao -> HoanThanh`

Ngoài ra, hệ thống cũng hỗ trợ trạng thái hủy khi đơn hàng bị hủy ở các giai đoạn trước đó:
- `Huy`

Điều này thể hiện rằng đơn hàng có thể bị hủy nếu khách hàng hoặc hệ thống không tiếp tục xử lý thanh toán hoặc giao hàng.

---

## 8. Kết luận
Dự án này mô hình hóa một hệ thống đặt hàng trực tuyến hoàn chỉnh với các thành phần rõ ràng về giao diện, xử lý nghiệp vụ, thanh toán, email xác nhận và lưu trữ dữ liệu. Những sơ đồ UML trong repo giúp mô tả chi tiết luồng hoạt động và cấu trúc hệ thống từ góc nhìn người dùng, lập trình viên và quản trị dữ liệu.

---

## 9. Cấu trúc thư mục
```text
LyThuyetTuan5/
├── Class.drawio
├── ERD.drawio
├── Sequence.drawio
├── State.drawio
├── usecase.drawio
├── README.md
```

Để xem các sơ đồ, bạn có thể mở các file `.drawio` bằng ứng dụng Draw.io / diagrams.net hoặc VS Code có hỗ trợ xem sơ đồ UML.
