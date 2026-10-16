# Hệ thống quản lý hồ sơ bệnh án

Ứng dụng desktop hỗ trợ quản lý thông tin bệnh nhân, hồ sơ bệnh án, lịch khám, quá trình khám chữa bệnh và thanh toán. Giao diện được xây dựng bằng Java Swing; dữ liệu được lưu trong Microsoft SQL Server.

> Đây là sản phẩm phục vụ học tập và minh họa quy trình. Không dùng dữ liệu bệnh nhân thật hoặc triển khai như một hệ thống y tế thực tế khi chưa được đánh giá, gia cố bảo mật và kiểm thử đầy đủ.

## Những nội dung đã thực hiện

- **Đăng nhập và phân quyền:** hỗ trợ các vai trò quản trị, bác sĩ, tiếp nhận và chăm sóc. Các chức năng thêm, sửa, xóa được giới hạn theo vai trò; một số màn hình chỉ cho phép xem.
- **Tổng quan:** hiển thị số lượng bệnh nhân, hồ sơ, lượt khám, lịch hẹn chờ, xét nghiệm chờ, thanh toán chờ và danh sách hồ sơ gần đây.
- **Quản lý dữ liệu:** các màn hình tra cứu, lọc và thao tác dữ liệu cho bệnh nhân, khoa, bác sĩ, phiếu đăng ký, phí năm, hồ sơ bệnh án, lịch hẹn, phiếu khám, xét nghiệm, toa thuốc, chi tiết toa thuốc và thanh toán.
- **Đăng ký bệnh nhân lần đầu:** tạo phiếu đăng ký, thu phí năm và lập hồ sơ bệnh án trong cùng một giao dịch; nếu một bước lỗi, các thay đổi được hoàn tác.
- **Quy trình khám và xuất viện:** hỗ trợ nhập phiếu khám, xét nghiệm, toa thuốc; ghi nhận thanh toán và chuyển phiếu khám sang trạng thái đã lưu trong cùng một giao dịch.
- **Khám định kỳ theo quý:** quy trình thanh toán kiểm tra phí năm hiện tại, áp dụng mức miễn phí và ngăn sử dụng suất miễn phí nhiều lần trong cùng quý.
- **Tra cứu và báo cáo:** có báo cáo tổng hợp hồ sơ, lịch sử khám, phí năm, toa thuốc và thanh toán viện phí; hỗ trợ xuất CSV và yêu cầu xác nhận trước khi xuất dữ liệu sức khỏe.
- **Cơ sở dữ liệu:** có script tạo bảng, ràng buộc khóa và dữ liệu mẫu, hai view thống kê/tổng hợp cùng script kiểm tra dữ liệu.
- **Tài liệu phân tích:** các sơ đồ Draw.io của bài tập nằm ở thư mục `LAB6` bên ngoài thư mục ứng dụng: sơ đồ xác định lớp, class diagram, use case tổng quát/chi tiết, activity diagram và sequence diagram.

## Công nghệ

- Java 17 trở lên
- Apache Maven
- Microsoft SQL Server
- Java Swing
- Microsoft JDBC Driver for SQL Server

## Cấu trúc thư mục

```text
QuanLyHoSoBenhAn_Java_SQLServer/
├── CHAY_WINDOWS.bat
├── README_HUONG_DAN.md
├── config.properties
├── pom.xml
├── database/
│   ├── 01_Tao_CSDL.sql
│   ├── 02_Du_Lieu_Mau.sql
│   └── 03_Kiem_Tra_CSDL.sql
├── src/main/java/vn/edu/benhan/
└── tests/
    └── MetadataSmokeTest.java
```

## Cài đặt và chạy trên Windows

### 1. Chuẩn bị môi trường

Cài Java JDK 17+ và Maven, đồng thời đảm bảo lệnh `java -version` và `mvn -version` chạy được trong terminal. Cài đặt và khởi động SQL Server; bật TCP/IP và cấu hình cổng TCP (mặc định trong dự án là `1433`).

### 2. Tạo cơ sở dữ liệu

Mở SQL Server Management Studio (SSMS), kết nối đến SQL Server rồi chạy lần lượt:

1. `database/01_Tao_CSDL.sql` — tạo cơ sở dữ liệu `QuanLyHoSoBenhAn`, các bảng, khóa/ràng buộc và view.
2. `database/02_Du_Lieu_Mau.sql` — thêm dữ liệu mẫu để thử nghiệm.
3. `database/03_Kiem_Tra_CSDL.sql` — xem bảng và kiểm tra dữ liệu/view.

Script dữ liệu mẫu không tạo phiếu đăng ký/hồ sơ mẫu hoàn chỉnh. Để tạo hồ sơ, thêm bệnh nhân trong ứng dụng rồi dùng mục **Đăng ký + lập hồ sơ**.

### 3. Cấu hình kết nối

Mở `config.properties`, cập nhật các giá trị phù hợp với máy của bạn:

```properties
server=localhost
port=1433
database=QuanLyHoSoBenhAn
user=sa
password=MAT_KHAU_SQL_SERVER
encrypt=true
trustServerCertificate=true
loginTimeout=6
```

Thay `MAT_KHAU_SQL_SERVER` bằng mật khẩu SQL Server của bạn. Không chia sẻ hoặc commit mật khẩu thật. Cấu hình `trustServerCertificate=true` chỉ phù hợp cho môi trường local/lab; môi trường triển khai cần cấu hình chứng chỉ tin cậy phù hợp.

### 4. Khởi chạy

Từ thư mục `QuanLyHoSoBenhAn_Java_SQLServer`, chạy một trong hai cách:

```bat
CHAY_WINDOWS.bat
```

hoặc:

```bat
mvn compile exec:java
```

Ứng dụng sẽ mở hộp thoại đăng nhập sau khi kết nối SQL Server thành công. Nếu kết nối lỗi, kiểm tra dịch vụ SQL Server, TCP/cổng, thông tin trong `config.properties` và việc đã chạy script tạo cơ sở dữ liệu.

## Tài khoản demo

Khi bảng `TaiKhoan` chưa có tài khoản, ứng dụng tự khởi tạo các tài khoản demo sau:

| Vai trò | Tên đăng nhập | Mật khẩu |
|---|---|---|
| Quản trị | `admin` | `admin123` |
| Bác sĩ | `bacsi` | `bs123456` |
| Tiếp nhận | `tiepnhan` | `tn123456` |
| Chăm sóc | `chamsoc` | `cs123456` |

Mật khẩu được lưu dưới dạng PBKDF2-HMAC-SHA256 có salt. Đây vẫn là thông tin đăng nhập demo đã biết công khai: hãy đổi/xóa tài khoản demo trước khi dùng trong bất kỳ môi trường nào có dữ liệu nhạy cảm.

## Quy trình sử dụng gợi ý

1. Đăng nhập bằng tài khoản phù hợp với vai trò.
2. Tạo thông tin bệnh nhân ở mục **Bệnh nhân**.
3. Chọn **Đăng ký + lập hồ sơ**, chọn bệnh nhân và nhập phí năm để tạo phiếu đăng ký, ghi nhận phí và cấp hồ sơ.
4. Quản lý lịch hẹn, khoa và bác sĩ; nhập phiếu khám cho bệnh nhân.
5. Bác sĩ cập nhật xét nghiệm/toa thuốc và chuyển phiếu khám sang trạng thái **Chờ thanh toán** khi hoàn tất.
6. Chọn **Xuất viện + thanh toán** để thu viện phí hoặc xử lý khám định kỳ quý miễn phí, sau đó lưu đợt khám vào hồ sơ.
7. Dùng **Báo cáo - tra cứu** để xem báo cáo hoặc xuất CSV khi được phép.

## Kiểm tra nhanh

Dự án có smoke test kiểm tra metadata của 12 màn hình dữ liệu, không cần kết nối SQL Server. Từ thư mục dự án, chạy:

```bat
mvn test-compile
java -cp "target/classes;target/test-classes" MetadataSmokeTest
```

Kết quả mong đợi:

```text
PASS: 12 entity screens; all static keys and field names unique.
```

## Lưu ý

- Ứng dụng cần kết nối SQL Server để đăng nhập và sử dụng dữ liệu.
- Việc xóa dữ liệu có thể bị từ chối khi bản ghi đang được tham chiếu bởi khóa ngoại.
- Các thông tin trong cơ sở dữ liệu mẫu là dữ liệu giả phục vụ trình diễn.
- Báo cáo CSV có thể chứa thông tin sức khỏe; chỉ xuất trên thiết bị được phép và bảo vệ tệp sau khi xuất.