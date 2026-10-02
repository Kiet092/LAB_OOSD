# Hệ thống E-SHOPPING Admin Dashboard

## Cài đặt
1. Cài đặt Node.js LTS.
2. Cài đặt SQL Server và tạo database `ESHOPPING` từ file `SQLQuery1.sql`.
3. Sửa thông tin kết nối trong file `.env`.
4. Chạy:

```bash
npm install
npm start
```

## Truy cập
Mở trình duyệt tại: http://localhost:3000

## Chức năng
- Hiển thị KPI tổng quan
- Lấy dữ liệu từ bảng `DONDATHANG`, `KHACHHANG`, `SANPHAM`
- Hiển thị đơn hàng gần đây và danh mục sản phẩm
