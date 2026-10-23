# LAB 07 - Quản lý nhân sự

Ứng dụng desktop quản lý nhân sự viết bằng Java Swing, hỗ trợ lưu dữ liệu vào tệp hoặc SQL Server. Bài thực hành minh họa quy trình nhân sự từ tuyển dụng, thử việc, hợp đồng đến chấm công, tính lương và thưởng/phạt.

## Chức năng chính

- Đăng nhập và phân quyền theo vai trò: nhân sự, trưởng phòng, chấm công, kế toán, giám đốc và nhân viên.
- Quản lý phòng ban, nhân viên, tuyển dụng, đánh giá thử việc, hợp đồng và hồ sơ bảo hiểm.
- Quản lý quyết định lương/chức vụ, phân công ca, chấm công và phiếu phụ trội.
- Lập, duyệt quyết định thưởng/phạt; lập phiếu thu/chi và tính bảng lương.
- Chạy độc lập với dữ liệu mẫu bằng chế độ lưu tệp; có thể cấu hình SQL Server để lưu dữ liệu qua JDBC.

## Yêu cầu

- Windows
- JDK 17 trở lên (`java` và `javac` có trong `PATH`)
- Không cần SQL Server để chạy chế độ demo/lưu tệp.
- Để dùng SQL Server: cần cài SQL Server, bật kết nối TCP/IP và chuẩn bị Microsoft JDBC Driver tương thích với JDK. Đặt tệp JDBC `.jar` trong thư mục `lib`.

## Chạy chế độ demo (lưu tệp)

1. Mở thư mục `QuanLyNhanSu_SQLServer_Full\QuanLyNhanSu_SQLServer`.
2. Chạy `chay_khong_SQL_windows.bat`.
3. Ở màn hình đăng nhập, chọn tài khoản mẫu bất kỳ; mật khẩu mẫu là `123456`.

Dữ liệu chế độ này được lưu tại `%USERPROFILE%\.quanlynhansu\nhansu.dat`. Đây là thông tin đăng nhập và dữ liệu mẫu phục vụ học tập, không dùng cho môi trường thực tế.

## Chạy với SQL Server

1. Mở SQL Server và tạo/cấu hình kết nối phù hợp trên máy.
2. Trong SQL Server Management Studio, chạy `sql\01_tao_bang.sql` để tạo cơ sở dữ liệu `QuanLyNhanSuDB` và các bảng. Tệp này có thể chạy lại và không chủ động xóa dữ liệu hiện có.
3. Thêm Microsoft JDBC Driver vào `lib`.
4. Kiểm tra và cập nhật URL, chế độ xác thực trong `ketnoi.properties`. Mặc định cấu hình dùng Windows Authentication trên `localhost:1433`.
5. Chạy `chay_kiem_tra_SQL_windows.bat` để kiểm tra kết nối.
6. Chạy `chay_SQLServer_windows.bat` để biên dịch và khởi động ứng dụng.

Không đưa mật khẩu hoặc thông tin xác thực cá nhân lên Git. Nếu dùng SQL Authentication, cập nhật cấu hình JDBC theo môi trường của bạn và giữ thông tin bí mật ở máy cục bộ.

## Kiểm thử

- Chạy `kiem_thu_windows.bat` trong thư mục ứng dụng để biên dịch và chạy bộ kiểm thử nghiệp vụ ở chế độ lưu tệp.
- Chạy `chay_kiem_tra_SQL_windows.bat` để kiểm tra kết nối SQL Server (cần cấu hình SQL Server và JDBC Driver).

## Cấu trúc thư mục

```text
QuanLyNhanSu_SQLServer_Full/
└── QuanLyNhanSu_SQLServer/
    ├── src/       Mã nguồn Java
    ├── sql/       Script tạo và kiểm tra cơ sở dữ liệu
    ├── lib/       JDBC Driver và thư viện cần thiết
    ├── anh/       Sơ đồ UML dạng Draw.io
    ├── out/       Thư mục chứa các lớp Java sau khi biên dịch
    └── *.bat      Script chạy và kiểm thử trên Windows
```

Các sơ đồ UML trong `anh/` gồm sơ đồ lớp, use case tổng quát/chi tiết, activity tuyển dụng thử việc và sequence khen thưởng.
