create database QuanLyNhanKhau collate LATIN1_GENERAL_100_CI_AS_SC_UTF8; -- 1. Người dùng



create table nguoi_dung(id INT Identity(1,1), taikhoan VARCHAR(255) UNIQUE NOT NULL, salt VARCHAR(16) NOT NULL, hash VARCHAR(255) NOT NULL, chucvu NVARCHAR(255), CONSTRAINT PK_nguoi_dung PRIMARY KEY(id));


alter table nguoi_dung add unique(taikhoan);


insert into nguoi_dung (taikhoan, salt, hash, chucvu)
values('admin',
       'jm4IEZXgougGTiIQ',
       's1073133124123355795573666841644461229585801276197101120544848906962310626176284366812039158411326892599126765812537758163203348633214521946e',
       N'Tổ trưởng');

-- 2. Nhân khẩu

CREATE TABLE nhan_khau(idNhanKhau INT IDENTITY(1,1),
                                      hoTen NVARCHAR(255) NOT NULL,
                                                          biDanh NVARCHAR(255),
                                                                 ngaySinh DATE NOT NULL,
                                                                               noiSinh NVARCHAR(255) NOT NULL,
                                                                                                     gioiTinh NVARCHAR(255) NOT NULL,
                                                                                                                            nguyenQuan NVARCHAR(255) NOT NULL,
                                                                                                                                                     danToc NVARCHAR(255) NOT NULL,
                                                                                                                                                                          tonGiao NVARCHAR(255) NOT NULL,
                                                                                                                                                                                                quocTich NVARCHAR(255) NOT NULL,
                                                                                                                                                                                                                       ngheNghiep NVARCHAR(255),
                                                                                                                                                                                                                                  noiLamViec NVARCHAR(255),
                                                                                                                                                                                                                                             soCCCD VARCHAR(255),
                                                                                                                                                                                                                                                    ngayCap DATE, chuyenDenNgay DATE, noiThuongTruTruoc NVARCHAR(255),
                                                                                                                                                                                                                                                                                                        trangThai NVARCHAR(255),
                                                                                                                                                                                                                                                                                                                  CONSTRAINT PK_nhan_khau PRIMARY KEY(idNhanKhau)) ;

-- 3. Hộ khẩu

CREATE TABLE ho_khau
  (idHoKhau INT IDENTITY(1,1),
                idChuHo INT NOT NULL,
                            tinhThanhPho NVARCHAR(255) NOT NULL,
                                                       quanHuyen NVARCHAR(255) NOT NULL,
                                                                               phuongXa NVARCHAR(255) NOT NULL,
                                                                                                      diaChi NVARCHAR(255) NOT NULL,
                                                                                                                           ngayTao DATE NOT NULL,
                                                                                                                                        trangThai NVARCHAR(255) NOT NULL,
                                                                                                                                                                CONSTRAINT PK_ho_khau PRIMARY KEY(idHoKhau),
                                                                                                                                                                                              CONSTRAINT FK_ho_khau_nhan_khau
   FOREIGN KEY(idChuHo) REFERENCES nhan_khau(idNhanKhau) ON DELETE CASCADE) ;

-- 4. Hộ khẩu - nhân khẩu

CREATE TABLE ho_khau_nhan_khau(idHoKhau INT NOT NULL,
                                            idNhanKhau INT NOT NULL,
                                                           quanHeChuHo NVARCHAR(255) NOT NULL,
                                                                                     CONSTRAINT PK_ho_khau_nhan_khau PRIMARY KEY (idHoKhau,
                                                                                                                                  idNhanKhau), CONSTRAINT FK_ho_khau_nhan_khau_nhan_khau
                               FOREIGN KEY(idNhanKhau) REFERENCES nhan_khau(idNhanKhau)) ;

-- 5. Chuyển nhân khẩu

CREATE TABLE chuyen_nhan_khau
  (id INT IDENTITY(1,1),
          idNhanKhau INT NOT NULL,
                         ngayChuyenDi DATE NOT NULL,
                                           noiChuyenDen NVARCHAR(255) NOT NULL,
                                                                      ghiChu NVARCHAR(255),
                                                                             CONSTRAINT PK_chuyen_nhan_khau PRIMARY KEY (id), CONSTRAINT FK_chuyen_nhan_khau_nhan_khau
   FOREIGN KEY(idNhanKhau) REFERENCES nhan_khau(idNhanKhau) ON DELETE CASCADE) ;

-- 6. Chuyển hộ khẩu

CREATE TABLE chuyen_ho_khau
  (id INT IDENTITY(1,1),
          idHoKhau INT NOT NULL,
                       ngayChuyenDi DATE NOT NULL,
                                         noiChuyenDen NVARCHAR(255) NOT NULL,
                                                                    ghiChu NVARCHAR(255),
                                                                           CONSTRAINT PK_chuyen_ho_khau PRIMARY KEY(id),
                                                                                                                CONSTRAINT FK_chuyen_ho_khau_ho_khau
   FOREIGN KEY(idHoKhau) REFERENCES ho_khau(idHoKhau) ON DELETE CASCADE) ;

-- 7. Tạm tru

CREATE TABLE tam_tru
  (id INT IDENTITY(1,1),
          idNhanKhau INT NOT NULL,
                         noiThuongTru NVARCHAR(255) NOT NULL,
                                                    noiTamTru NVARCHAR(255) NOT NULL,
                                                                            tuNgay DATE NOT NULL,
                                                                                        denNgay DATE NOT NULL,
                                                                                                     lyDo NVARCHAR(255),
                                                                                                          CONSTRAINT PK_tam_tru PRIMARY KEY(id),
                                                                                                                                        CONSTRAINT FK_tam_tru_nhan_khau
   FOREIGN KEY(idNhanKhau) REFERENCES nhan_khau(idNhanKhau) ON DELETE CASCADE) ;

-- 8. Tạm vắng

CREATE TABLE tam_vang
  (id INT IDENTITY(1,1),
          idNhanKhau INT NOT NULL,
                         noiTamVang NVARCHAR(255) NOT NULL,
                                                  tuNgay DATE NOT NULL,
                                                              denNgay DATE NOT NULL,
                                                                           lyDo NVARCHAR(255),
                                                                                CONSTRAINT PK_tam_vang PRIMARY KEY(id),
                                                                                                               CONSTRAINT FK_tam_vang_nhan_khau
   FOREIGN KEY(idNhanKhau) REFERENCES nhan_khau(idNhanKhau) ON DELETE CASCADE) ;

-- 9. Dịp đặc biệt

CREATE TABLE dip_dac_biet(idDip INT IDENTITY(1,1),
                                    ten NVARCHAR(255) NOT NULL,
                                                      nam INT NOT NULL,
                                                              moTa NVARCHAR(255),
                                                                   phanQua05 NVARCHAR(255) NOT NULL,
                                                                                           phanQua614 NVARCHAR(255) NOT NULL,
                                                                                                                    phanQua1517 NVARCHAR(255) NOT NULL,
                                                                                                                                              tien05 FLOAT NOT NULL,
                                                                                                                                                           tien614 FLOAT NOT NULL,
                                                                                                                                                                         tien1517 FLOAT NOT NULL,
                                                                                                                                                                                        CONSTRAINT PK_dip_dac_biet PRIMARY KEY(idDip)) ;

-- 10. Dịp học sinh giỏi

CREATE TABLE dip_hoc_sinh_gioi(idDip INT IDENTITY(1,1),
                                         nam INT NOT NULL,
                                                 moTa NVARCHAR(255),
                                                      phanQuaDacBiet NVARCHAR(255) NOT NULL,
                                                                                   phanQuaGioi NVARCHAR(255) NOT NULL,
                                                                                                             phanQuaKha NVARCHAR(255) NOT NULL,
                                                                                                                                      tienDacBiet FLOAT NOT NULL,
                                                                                                                                                        tienGioi FLOAT NOT NULL,
                                                                                                                                                                       tienKha FLOAT NOT NULL,
                                                                                                                                                                                     CONSTRAINT PK_dip_hoc_sinh_gioi PRIMARY KEY(idDip)) ;

-- 11. Chi tiết dịp đặc biệt

CREATE TABLE chi_tiet_dip_dac_biet(idDip INT NOT NULL,
                                             idNhanKhau INT NOT NULL,
                                                            nhom INT NOT NULL,
                                                                     kiemtra BIT NOT NULL,
                                                                                 CONSTRAINT PK_chi_tiet_dip_dac_biet PRIMARY KEY(idDip, idNhanKhau),
                                                                                                                             CONSTRAINT FK_chi_tiet_dip_dac_biet_dip_dac_biet
                                   FOREIGN KEY(idDip) REFERENCES dip_dac_biet(idDip),
                                                                 CONSTRAINT FK_chi_tiet_dip_dac_biet
                                   FOREIGN KEY(idNhanKhau) REFERENCES nhan_khau(idNhanKhau)) ;

-- 12. Chi tiết dịp học sinh giỏi

CREATE TABLE chi_tiet_dip_hoc_sinh_gioi(idDip INT NOT NULL,
                                                  idNhanKhau INT NOT NULL,
                                                                 truong NVARCHAR(255) NOT NULL,
                                                                                      lop VARCHAR(255) NOT NULL,
                                                                                                       nhom INT NOT NULL,
                                                                                                                kiemtra BIT NOT NULL,
                                                                                                                            CONSTRAINT PK_chi_tiet_dip_hoc_sinh_gioi PRIMARY KEY(idDip, idNhanKhau),
                                                                                                                                                                             CONSTRAINT FK_chi_tiet_dip_hoc_sinh_gioi_dip_hoc_sinh_gioi
                                        FOREIGN KEY(idDip) REFERENCES dip_hoc_sinh_gioi(idDip),
                                                                      CONSTRAINT FK_chi_tiet_dip_hoc_sinh_gioi
                                        FOREIGN KEY(idNhanKhau) REFERENCES nhan_khau(idNhanKhau)) ;

-- 13. Khai tử

CREATE TABLE khai_tu(idNguoiMat INT NOT NULL,
                                    idNguoiKhai INT NOT NULL,
                                                    ngayKhai DATE NOT NULL,
                                                                  ngayMat DATE NOT NULL,
                                                                               liDoMat NVARCHAR(255),
                                                                                       CONSTRAINT PK_khai_tu PRIMARY KEY(idNguoiMat),
                                                                                                                     CONSTRAINT FK_khai_tu_nguoi_mat_nhan_khau
                     FOREIGN KEY(idNguoiMat) REFERENCES nhan_khau(idNhanKhau),
                                                        CONSTRAINT FK_khai_tu_nguoi_khai_nhan_khau
                     FOREIGN KEY(idNguoiKhai) REFERENCES nhan_khau(idNhanKhau)) ;