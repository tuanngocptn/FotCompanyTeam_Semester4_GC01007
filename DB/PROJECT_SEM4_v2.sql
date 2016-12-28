CREATE DATABASE PROJECT_SEM4
GO

USE PROJECT_SEM4
GO

CREATE TABLE tblCareer
(
	_codeCareer VARCHAR(20) NOT NULL PRIMARY KEY,
	_nameCareer NVARCHAR(20) NOT NULL UNIQUE
)

CREATE TABLE tblWorker
(
	_codeWorker VARCHAR(20) NOT NULL PRIMARY KEY,
	_codeCareer VARCHAR(20) FOREIGN KEY REFERENCES tblCareer(_codeCareer),
	_user VARCHAR(20) NOT NULL UNIQUE,
	_pass VARCHAR(20) NOT NULL,
	_name NVARCHAR(40) NOT NULL,
	_avatar VARCHAR(40) NOT NULL,
	_dateOfBirth DATE NOT NULL,
	_phone BIGINT NOT NULL,
	_email VARCHAR(40) NOT NULL,
	_address NVARCHAR(255) NOT NULL
)

CREATE TABLE tblOrder	
(
	_codeOrder INT IDENTITY PRIMARY KEY,
	_nameCustomer NVARCHAR(20) NOT NULL,
	_emailCustomer VARCHAR(40) NOT NULL,
	_phoneCustomer BIGINT NOT NULL,
	_location NVARCHAR(255) NOT NULL,
	_codeCareer VARCHAR(20) FOREIGN KEY REFERENCES tblCareer(_codeCareer),
	_quantityWoker INT DEFAULT 0,
	_startDate DATE NOT NULL,
	_endDate  DATE NOT NULL,
	_status VARCHAR(10) NOT NULL,
	_lstWorkers VARCHAR(50)
)

CREATE TABLE tblComment
(
	_codeComment INT IDENTITY PRIMARY KEY,
	_areaComment VARCHAR(20) NOT NULL,
	_user VARCHAR(20) NOT NULL,
	_dateTime DATETIME DEFAULT GETDATE(),
	_content VARCHAR(255) NOT NULL,
	_status VARCHAR(10) NOT NULL
)

INSERT INTO tblCareer VALUES	('adm',N'admin')
								,('xd',N'Xây Dựng')
								,('bm',N'Bốc Mộ')
								,('hbp',N'Hút Bể Phốt')
								,('kcbt',N'Khoan Cắt Bê Tông')

INSERT INTO tblWorker(_codeWorker,_codeCareer,_user,_pass,_name,_avatar
						,_dateOfBirth,_phone,_email,_address) VALUES	('adm1','adm','admin','admin',N'Ass Văn Min','images/avatars/Admin.jpg','2016-12-25',84912345678,'admin@gmail.com','HN'),
																		('xd01','xd','workerxd01','workerxd01',N'Phạm Tuấn Ngọc','images/avatars/ngoc.jpg','1993-05-19',84977576770,'ngocptgc01007@fpt.edu.vn','MC'),
																		('xd02','xd','workerxd02','workerxd02',N'Nguyễn Hoàng Hải','images/avatars/hoanghai.jpg','1996-03-20',84932345095,'hainhgc00929@fpt.edu.vn','HN'),
																		('xd03','xd','workerxd03','workerxd03',N'Phùng Tiến Toàn','images/avatars/phungtoan.jpg','1996-02-13',841669515225,'toanptgc01011@fpt.edu.vn','HN'),
																		('xd04','xd','workerxd04','workerxd04',N'Đỗ Huy Phong','images/avatars/huyphong.jpg','1995-01-25',84982336668,'phongdhgc00909@fpt.edu.vn','HN'),
																		('xd05','xd','workerxd05','workerxd05',N'Vũ Tuấn Anh','images/avatars/vutuananh.jpg','1993-03-17',84954789632,'anhvtgc00237@fpt.edu.vn','HN'),								
																		('bm01','bm','workerbm01','workerbm01',N'Từ Tú Bằng','images/avatars/bang.jpg','1996-07-29',84945782159,'bangttgc00932@fpt.edu.vn','YB'),
																		('bm02','bm','workerbm02','workerbm02',N'Lê Tuấn Anh','images/avatars/letuananh.jpg','1996-05-24',84998511248,'anhltgc00950@fpt.edu.vn','HN'),
																		('bm03','bm','workerbm03','workerbm03',N'Nguyễn Hồng Phúc','images/avatars/phuc.jpg','1996-11-20',84925842586,'phucnhgc00948@fpt.edu.vn','HN'),
																		('bm04','bm','workerbm04','workerbm04',N'Nguyễn Dương Quân','images/avatars/quan.jpg','1996-10-03',84951487523,'quanndgc00977@fpt.edu.vn','HN'),
																		('bm05','bm','workerbm05','workerbm05',N'Bùi Duy Linh','images/avatars/thaylinh.jpg','1981-11-13',84926626688,'linhbd@fpt.edu.vn','HN'),
																		('hbp01','hbp','workerhbp01','workerhbp01',N'Trần Hoàng Linh','images/avatars/linhtran.jpg','1996-11-29',84935216548,'linhthgc00913@fpt.edu.vn','HN'),
																		('hbp02','hbp','workerhbp02','workerhbp02',N'Đỗ Việt Anh','images/avatars/vietanh.jpg','1993-12-10',84985156645,'anhdvgc00967@fpt.edu.vn','NB'),
																		('hbp03','hbp','workerhbp03','workerhbp03',N'Nguyễn Minh Công','images/avatars/cong.jpg','1996-01-14',84924547575,'congnmd00002@fpt.edu.vn','HN'),
																		('hbp04','hbp','workerhbp04','workerhbp04',N'Nguyễn Hoàng Long','images/avatars/default-avatar.png','1990-09-11',84964461990,'longnhgc00940@fpt.edu.vn','HN'),
																		('hbp05','hbp','workerhbp05','workerhbp05',N'Nguyễn Thế Toàn','images/avatars/thetoan.jpg','1995-08-21',84987418440,'toanntgc01079@fpt.edu.vn','HN'),
																		('kcbt01','kcbt','workerkcbt01','workerkcbt01',N'Dương Tuấn Phong','images/avatars/tuanphong.jpg','1996-11-27',84966268668,'phongdtgc00918@fpt.edu.vn','HN'),
																		('kcbt02','kcbt','workerkcbt02','workerkcbt02',N'Bùi Nguyên Cường','images/avatars/default-avatar.png','1996-12-20',84941595991,'cuongbngc00858@fpt.edu.vn','HN'),
																		('kcbt03','kcbt','workerkcbt03','workerkcbt03',N'Dương Hải Hòa','images/avatars/hoa.jpg','1996-02-21',84990096009,'hoadhgc00964@fpt.edu.vn','HN'),
																		('kcbt04','kcbt','workerkcbt04','workerkcbt04',N'Lê Đại Thành','images/avatars/thanh.jpg','1996-09-30',84931234567,'thanhldgc00959@fpt.edu.vn','HN'),
																		('kcbt05','kcbt','workerkcbt05','workerkcbt05',N'Trịnh Bách','images/avatars/default-avatar.png','1995-01-19',84985152225,'bachtgc01084@fpt.edu.vn','HN')


INSERT INTO tblOrder VALUES		(N'Ngô Thị Hương Giang','giangnth5@fe.edu.vn',84982336969,N'Văn Quán Hà Đông','xd',1,'2016-08-10','2016-08-11','wait',''),
								(N'Vũ Như Quỳnh','quynhvn2@fe.edu.vn',84969681990,N'Khu Đô Thị Mỹ Đình 1','xd',2,'2016-08-11','2016-08-12','wait',''),
								(N'Trấn Thành','thanhht@gmai.com',84932345287,N'Trần Duy Hưng','xd',3,'2016-08-12','2016-08-13','wait',''),
								(N'Hari Won','hariyeutiendat@gmai.com',84992125225,N'Seoul','xd',4,'2016-08-13','2016-08-14','wait',''),
								(N'Nguyễn Cao Kỳ Duyên','duyennck@gmai.com',841622486668,N'Cầu Giấy','xd',5,'2016-08-14','2016-08-15','wait','')


INSERT INTO tblComment(_areaComment,_user,_content,_status) VALUES	('xd01','workerxd01','abc...xyz','show')
																	,('xd01','workerxd02','abc...xyz','show')
																	,('xd01','workerxd03','abc...xyz','show')
																	,('xd01','workerxd04','abc...xyz','show')
																	,('xd01','workerxd06','abc...xyz','show')
																	,('xd01','workerxd08','abc...xyz','show')
																	,('xd01','workerxd01','abc...xyz','hide')




DELETE FROM tblOrder WHERE _codeOrder = 7

DELETE FROM tblCareer WHERE _codeCareer = 'adm, adm'

UPDATE tblCareer SET _nameCareer = 'aaaa' WHERE _codeCareer = 'adma'

UPDATE tblOrder SET _lstWorkers = 'xd01#xd02' WHERE _codeOrder = 2;

SELECT * FROM tblCareer
SELECT * FROM tblWorker
SELECT * FROM tblOrder
SELECT * FROM tblComment



DROP TABLE tblCareer
DROP TABLE tblWorker
DROP TABLE tblOrder
DROP TABLE tblComment