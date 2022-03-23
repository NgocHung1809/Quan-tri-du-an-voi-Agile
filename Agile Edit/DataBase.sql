CREATE DATABASE DUANANHOM5
go
use DUANANHOM5


CREATE TABLE SanPham
(
    IdSanPham INT IDENTITY(1,1) PRIMARY KEY,
    MaSanPHam NVARCHAR(100) UNIQUE DEFAULT NULL,
    TenSP NVARCHAR(100) DEFAULT NULL,
    Hang NVARCHAR(100) DEFAULT NULL,
    SoLuongSanPhamTon INT DEFAULT NULL,
    GiaNhapSP DECIMAL(20,0) DEFAULT NULL,
    GiaBanSP DECIMAL(20,0) DEFAULT NULL,
    MauSac NVARCHAR(50) DEFAULT null
)

select * from Users

CREATE TABLE NhanVien
(
    IdNhanVien int PRIMARY KEY IDENTITY(1,1),
    MaNhanVien NVARCHAR(100) UNIQUE DEFAULT NULL,
    TenNV NVARCHAR(100) DEFAULT NULL,
    SDT NVARCHAR(100) DEFAULT NULL,
    NgaySinh NVARCHAR(100) DEFAULT NULL,
    GioiTinh NVARCHAR(100) DEFAULT NULL,
    DiaChi NVARCHAR(100) DEFAULT NULL
)

CREATE TABLE KhachHang
(
    IdKhachHang INT PRIMARY KEY IDENTITY(1,1),
    MaKH NVARCHAR(100) UNIQUE DEFAULT NULL,
    TenKH NVARCHAR(100) DEFAULT null,
    SDT NVARCHAR(100) DEFAULT NULL,
    NgaySinh NVARCHAR(100) DEFAULT NULL,
    GioiTinh NVARCHAR(100) DEFAULT NULL,
    DiaChi NVARCHAR(100) DEFAULT NULL
)

CREATE TABLE HoaDon
(
    IdHoaDon INT PRIMARY KEY IDENTITY(1,1),
    MaHoaDon NVARCHAR(100) UNIQUE DEFAULT NULL,
    IdNhanVien INT NOT NULL,
    IdKhachHang INT NOT NULL,
    NgayTao NVARCHAR(100) DEFAULT NULL,
    TrangThai NVARCHAR(100) DEFAULT NULL
)

CREATE TABLE HoaDonChiTiet(
    IdHoaDon INT NOT NULL,
    IdSanPham INT NOT null,
    SoLuongDatHang INT DEFAULT NULL,
    Gia1SanPham DECIMAL(20,0) DEFAULT NULL,
    PRIMARY KEY(IdHoaDon,IdSanPham),
    CONSTRAINT FK1 FOREIGN KEY(IdHoaDon)REFERENCES HoaDon(IdHoaDon),
    CONSTRAINT FK2 FOREIGN KEY(IdSanPham) REFERENCES SanPham(IdSanPham)
)

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDonKhachHang
FOREIGN KEY(IdKhachHang) REFERENCES KhachHang(IdKhachHang);

ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDonNhanVien
FOREIGN KEY(IdNhanVien) REFERENCES nhanvien(IdNhanVien);

INSERT INTO SanPham VALUES('SP1',N'Air Jordan 3','Nike',50,5000000,6500000,'Fire Red'),
                          ('SP2',N'Nike Zoom Pegasus','Nike',10,15000000,2500000,'White'),
                          ('SP3',N'Vans Old Skool 36 DX Anaheim Factory','Vans',100,6000000,7500000,'Black'),
                          ('SP4',N'Vans Slip-On Checkerboard','Vans',23,2000000,400000,'Black & White'),
                          ('SP5',N'Adidas EQT Boost','Adidas ',55,6000000,8500000,'White'),
                          ('SP6',N'Adidas NMD (Nomad)','Adidas',73,5000000,6500000,'White'),  
                          ('SP7',N'Converse Classic','Converse ',20,1000000,2500000,'Kem'),
                          ('SP8',N'Converse 1970s Mason','Converse',50,3000000,4500000,'Xám')
SELECT * FROM  SanPham   


INSERT INTO NhanVien VALUES('NV1',N'Tô Ngọc Hùng','0987878987','01-01-1997','Nam',N'Hà Nội'),
                           ('NV2',N'Lê Thị Thanh Tâm','0987878986','01-01-2001',N'NỮ',N'Hà Nội'),
                           ('NV3',N'Nguyễn Khánh Hóa','0987878985','01-01-1998','Nam',N'Hà Nội'),
                           ('NV4',N'Trần Văn Tiến','0987878986','06-03-1998','Nam',N'Hà Nội'),
                           ('NV5',N'Hà Đắc Trung','0987878983','01-01-2000','Nam',N'Hà Nội')
SELECT * FROM NhanVien

INSERT INTO KhachHang VALUES ('KH1',N'Nguyễn Văn A','0987873456','02-03-1995','Nam',N'Hà Nội'),
                           ('NV2',N'Trần Thị B','0987878986','01-01-1999',N'NỮ',N'Hải Dương'),
                           ('NV3',N'Lê Văn C','0987878985','03-09-1998','Nam',N'Hải Phòng'),
                           ('NV4',N'Chu Văn E','0987232133','02-09-1998','Nam',N'Lạng Sơn'),
                           ('NV5',N'Nguyễn Văn D','0987456432','01-06-2000','Nam',N'Hà Nội')
SELECT * FROM KhachHang      

INSERT INTO HoaDon VALUES('HD1',1,1,'10-10-2021',N'Đã Thanh Toán'),
                        ('HD2',1,2,'10-03-2022',N'Đã Thanh Toán'),
                        ('HD3',2,3,'17-03-2022',N'Chưa Thanh Toán'),
                        ('HD4',3,4,'11-09-2020',N'Đã Thanh Toán'),
                        ('HD5',4,4,'13-07-2019',N'Đã Thanh Toán'),
                        ('HD6',5,5,'11-12-2021',N'Đã Hủy')
SELECT * FROM HoaDon  

INSERT INTO HoaDonChiTiet VALUES(3,1,3,6500000),
                                (4,3,5,7500000),
                                (5,4,10,4000000),
                                (6,5,2,8500000),
                                (7,2,5,25000000)
SELECT * FROM HoaDonChiTiet                                
 
CREATE TABLE Users
(
	TaiKhoan NVARCHAR(50) PRIMARY KEY,
	MatKhau NVARCHAR(50)
)
GO
SELECT * FROM Users
GO