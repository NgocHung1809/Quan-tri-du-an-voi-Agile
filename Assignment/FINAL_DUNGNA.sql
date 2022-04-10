use FINAL_ASSIGNMENT_JAVA3_DUNGNA29
GO
ALTER DATABASE FINAL_ASSIGNMENT_JAVA3_DUNGNA29 SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
GO
DROP DATABASE FINAL_ASSIGNMENT_JAVA3_DUNGNA29;
GO

CREATE DATABASE FINAL_ASSIGNMENT_JAVA3_DUNGNA29_V2;
GO
USE FINAL_ASSIGNMENT_JAVA3_DUNGNA29_V2;
GO

CREATE TABLE DongSanPham(
	Id INT PRIMARY KEY IDENTITY,
	Ma NVARCHAR(100)  DEFAULT NULL,
	Ten NVARCHAR(100) DEFAULT NULL,
	Web NVARCHAR(200) DEFAULT NULL
);

CREATE TABLE NhanVien(
	Id INT PRIMARY KEY IDENTITY,
	Ma NVARCHAR(100)  DEFAULT NULL,
	TenHo NVARCHAR(100) DEFAULT NULL,
	TenDem NVARCHAR(100) DEFAULT NULL,
	Ten NVARCHAR(100) DEFAULT NULL,
	GioiTinh NVARCHAR(100) DEFAULT NULL,
	NgaySinh Date DEFAULT NULL,
	IdCV INT NOT NULL,
	IdNguoiBaoCao INT NULL
);
ALTER TABLE NhanVien DROP COLUMN IdCV
ALTER TABLE NhanVien ADD  IdCV INT NULL

CREATE TABLE ChucVu(
	Id  INT PRIMARY KEY IDENTITY,
	Ma NVARCHAR(100) DEFAULT NULL,
	Ten NVARCHAR(100) DEFAULT NULL
);
CREATE TABLE SanPham(
	Id INT PRIMARY KEY IDENTITY,
	Ma NVARCHAR(100) DEFAULT NULL,
	Ten  NVARCHAR(100) DEFAULT NULL,
	NamBaoHanh NUMERIC(4),
	TrongLuongSP FLOAT DEFAULT NULL,
	MoTaSP NVARCHAR(100) DEFAULT NULL,
	SLSanPhamTon INT DEFAULT NULL,
	GiaNhapSP DECIMAL(20,0) DEFAULT NULL,
	GiaBanSP DECIMAL(20,0) DEFAULT NULL,
	IdDSP INT NOT NULL
);



CREATE TABLE HoaDon(
	Id INT PRIMARY KEY IDENTITY,
	Ma NVARCHAR(100) DEFAULT NULL,
	NgayTaoHoaDon DATE DEFAULT NULL,
	TinhTrangHoaDon  INT DEFAULT NULL,
	IdNV INT NOT NULL
);

ALTER TABLE HoaDon DROP COLUMN IdKH
SELECT * FROM HoaDon

CREATE TABLE HoaDonChiTiet(
	IdHoaDon INT NOT NULL,
	IdSanPham INT NOT NULL ,
	SoLuong INT DEFAULT NULL,
	DonGia DECIMAL(20,0) DEFAULT NULL,
	STT INT DEFAULT NULL,
	PRIMARY KEY(IdHoaDon,IdSanPham),
	CONSTRAINT FK1 FOREIGN KEY(IdHoaDon)REFERENCES hoadon(Id),
	CONSTRAINT FK2 FOREIGN KEY(IdSanPham) REFERENCES sanpham(Id)
);

ALTER TABLE NhanVien
ADD CONSTRAINT FK_NhanVienChucDanh
FOREIGN KEY(IdCV) REFERENCES chucvu(Id);

ALTER TABLE NhanVien
 ADD CONSTRAINT FK_GuiBaoCaoNhanVien
FOREIGN KEY(IdNguoiBaoCao) REFERENCES nhanvien(Id);

DELETE  FROM NhanVien

ALTER TABLE NhanVien DROP CONSTRAINT FK_GuiBaoCaoNhanVien
ALTER TABLE NhanVien DROP CONSTRAINT FK_NhanVienChucDanh


ALTER TABLE HoaDon
ADD CONSTRAINT FK_HoaDonNhanVien
FOREIGN KEY(IdNV) REFERENCES nhanvien(Id);

ALTER TABLE sanpham
ADD CONSTRAINT FK_SanPhamDongSanPham
FOREIGN KEY(IdDSP) REFERENCES dongsanpham(Id);

select * from SanPham
select * from DongSanPham

CREATE PROC SP_ChucVu(
    @id int , 
	@ma NVARCHAR(50),
	@ten NVARCHAR(50),
	@style NVARCHAR(10)
)
AS
BEGIN
 IF (@style = 'SELECT')
    BEGIN
        SELECT *
        FROM ChucVu
    END

    IF (@style = 'INSERT')
    BEGIN
        INSERT INTO ChucVu
        VALUES( @ma, @ten)
    END

    IF (@style = 'DELETE')
    BEGIN
        DELETE ChucVu WHERE @ma = Ma
    END
     ELSE IF (@style = 'UPDATE')
    BEGIN
        UPDATE ChucVu SET 
       Ten = @ten
       WHERE Ma = @ma
    END
END

SELECT * FROM HoaDon
GO
ALTER PROC SP_SanPham(
    @id int ,
	@ma NVARCHAR(50),
	@ten NVARCHAR(50),
	@namBH int , 
	@trongLuongSP FLOAT,
	@mota NVARCHAR(50),
    @soLuongSPTon int,
	@GiaNhap int, 
	@GiaBan int,
	@idDSP int,
	@style NVARCHAR(10)
)
AS
BEGIN
 IF (@style = 'SELECT')
    BEGIN
        SELECT *
        FROM SanPham
    END

    IF (@style = 'INSERT')
    BEGIN
        INSERT INTO SanPham
        VALUES( @ma, @ten,@namBH  , @trongLuongSP ,@MoTa,@soLuongSPTon, @GiaNhap , @GiaBan ,@idDSP)
    END

    IF (@style = 'DELETE')
    BEGIN
        DELETE SanPham WHERE @ma = Ma
    END
     ELSE IF (@style = 'UPDATE')
    BEGIN
        UPDATE SanPham SET 
       Ten = @ten
       WHERE Ma = @ma
    END
END

GO
select * from SanPham

CREATE PROC SP_DongSP(
    @id int , @ma NVARCHAR(50),@ten NVARCHAR(50),@web nvarchar(50) ,@style NVARCHAR(10))
AS
BEGIN
 IF (@style = 'SELECT')
    BEGIN
        SELECT *
        FROM DongSanPham
    END

    IF (@style = 'INSERT')
    BEGIN
        INSERT INTO DongSanPham
        VALUES( @ma, @ten,@web )
    END

    IF (@style = 'DELETE')
    BEGIN
        DELETE DongSanPham WHERE @ma = Ma
    END
     ELSE IF (@style = 'UPDATE')
    BEGIN
        UPDATE DongSanPham SET 
       Ten = @ten,
	   Web = @web
       WHERE Ma = @ma
    END
END

GO
alter PROC SP_HoaDon(
    @id int ,
	@ma NVARCHAR(50),
	@ngayTao date,
	@TinhTrang int , 
	@idNV int,
	@style NVARCHAR(10)
)
AS
BEGIN
 IF (@style = 'SELECT')
    BEGIN
        SELECT *
        FROM HoaDon
    END

    IF (@style = 'INSERT')
    BEGIN
        INSERT INTO HoaDon
        VALUES( @ma, @ngayTao,@TinhTrang , @idNV )
    END

    IF (@style = 'DELETE')
    BEGIN
        DELETE HoaDon WHERE @ma = Ma
    END
     ELSE IF (@style = 'UPDATE')
    BEGIN
        UPDATE HoaDon SET 
        HoaDon.NgayTaoHoaDon = @ngayTao,
		TinhTrangHoaDon = @TinhTrang,
		 HoaDon.IdNV = @idNV
       WHERE Ma = @ma
    END
END

GO
UPDATE NhanVien SET Ten = N'ABC' WHERE id =23
EXEC SP_NhanVien 1,N'NV01',N'Tô',N'Ngọc',N'Hùng',N'Nam','2000-09-18',null,null,N'INSERT' 
EXEC SP_NhanVien 6,N'NV01',N'Tô',N'Ngọc',N'Hùng',N'Nam','2000-09-18',26,12,N'INSERT' 

select * from NhanVien
select * from ChucVu
delete from NhanVien
DROP PROC SP_NhanVien GO
ALTER PROC SP_NhanVien(
    @id int ,
	@ma NVARCHAR(50),
	@tenho nvarchar(50),
	@tendem nvarchar(50),
	@ten nvarchar(50),
	@GioiTinh nvarchar(50),
	@NgaySinh date,
	@IdCV int,
	@idNguoiBaoCao int,
	@style NVARCHAR(10)
)
AS
BEGIN
 IF (@style = 'SELECT')
    BEGIN
        SELECT *
        FROM NhanVien
    END

    IF (@style = 'INSERT')
    BEGIN
        INSERT INTO NhanVien (ma,tenho,tendem,ten ,GioiTinh ,NgaySinh,IdCV,idNguoiBaoCao)
        VALUES(@ma,@tenho,@tendem,@ten ,@GioiTinh ,@NgaySinh,@IdCV,@idNguoiBaoCao)
    END

    IF (@style = 'DELETE')
    BEGIN
        DELETE NhanVien WHERE @ma = Ma
    END
	IF	(@style = 'UPDATE')
	BEGIN
		UPDATE NhanVien SET tenho = @tenho,tendem = @tendem,ten = @ten,GioiTinh = @GioiTinh ,NgaySinh = @NgaySinh,IdCV = @IdCV,idNguoiBaoCao = @idNguoiBaoCao
		WHERE ma = @ma
	END
END
select * from HoaDon
select * from SanPham
ALTER PROC SP_HOADONCT
(
	@IdHoaDon INT,
	@IdSanPham INT,
	@SoLuong INT,
	@DonGia DECIMAL(20,0),
	@STT INT,
	@style NVARCHAR(10)
)
AS
BEGIN
	IF (@style = 'SELECT')
    BEGIN
        SELECT *
        FROM HoaDonChiTiet
    END

    IF (@style = 'INSERT')
    BEGIN
        INSERT INTO HoaDonChiTiet (IdHoaDon,IdSanPham,SoLuong,DonGia,STT)
        VALUES(@IdHoaDon,@IdSanPham,@SoLuong,@DonGia,@STT)
    END

    IF (@style = 'DELETE')
    BEGIN
        DELETE HoaDonChiTiet WHERE @IdHoaDon = IdHoaDon AND @IdSanPham = IdSanPham
    END
	IF	(@style = 'UPDATE')
	BEGIN
		UPDATE HoaDonChiTiet SET SoLuong = @SoLuong, DonGia = @DonGia
		WHERE @IdHoaDon = IdHoaDon AND @IdSanPham = IdSanPham
	END
END

delete HoaDonChiTiet
DELETE HoaDon WHERE ma = 'HD1'
select * from HoaDon
select * from SanPham
select * from HoaDonChiTiet
