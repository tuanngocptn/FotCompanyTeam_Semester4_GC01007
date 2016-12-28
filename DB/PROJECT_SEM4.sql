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
	_avatar VARCHAR(40) DEFAULT 'images/avatars/default-avatar.png',
	_dateOfBirth DATE DEFAULT '2000-01-01',
	_phone BIGINT DEFAULT 840000000000,
	_email VARCHAR(40) DEFAULT 'please update email',
	_address NVARCHAR(255) DEFAULT 'please update address'
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

INSERT INTO tblWorker(_codeWorker,_codeCareer,_user,_pass,_name) VALUES	('adm1','adm','admin','admin',N'Ass Văn Min'),
																		('xd01','xd','workerxd01','workerxd01',N'Guấc Cơ Xây Dựng 01'),
																		('xd02','xd','workerxd02','workerxd02',N'Guấc Cơ Xây Dựng 02'),
																		('xd03','xd','workerxd03','workerxd03',N'Guấc Cơ Xây Dựng 03'),
																		('xd04','xd','workerxd04','workerxd04',N'Guấc Cơ Xây Dựng 04'),
																		('xd05','xd','workerxd05','workerxd05',N'Guấc Cơ Xây Dựng 05'),								
																		('bm01','bm','workerbm01','workerbm01',N'Guấc Cơ Bốc Mộ 01'),
																		('bm02','bm','workerbm02','workerbm02',N'Guấc Cơ Bốc Mộ 02'),
																		('bm03','bm','workerbm03','workerbm03',N'Guấc Cơ Bốc Mộ 03'),
																		('bm04','bm','workerbm04','workerbm04',N'Guấc Cơ Bốc Mộ 04'),
																		('bm05','bm','workerbm05','workerbm05',N'Guấc Cơ Bốc Mộ 05'),
																		('hbp01','hbp','workerhbp01','workerhbp01',N'Guấc Cơ Hút Phốt 01'),
																		('hbp02','hbp','workerhbp02','workerhbp02',N'Guấc Cơ Hút Phốt 02'),
																		('hbp03','hbp','workerhbp03','workerhbp03',N'Guấc Cơ Hút Phốt 03'),
																		('hbp04','hbp','workerhbp04','workerhbp04',N'Guấc Cơ Hút Phốt 04'),
																		('hbp05','hbp','workerhbp05','workerhbp05',N'Guấc Cơ Hút Phốt 05'),
																		('kcbt01','kcbt','workerkcbt01','workerkcbt01',N'Guấc Cơ Khoan Cắt Bê Tông 01'),
																		('kcbt02','kcbt','workerkcbt02','workerkcbt02',N'Guấc Cơ Khoan Cắt Bê Tông 02'),
																		('kcbt03','kcbt','workerkcbt03','workerkcbt03',N'Guấc Cơ Khoan Cắt Bê Tông 03'),
																		('kcbt04','kcbt','workerkcbt04','workerkcbt04',N'Guấc Cơ Khoan Cắt Bê Tông 04'),
																		('kcbt05','kcbt','workerkcbt05','workerkcbt05',N'Guấc Cơ Khoan Cắt Bê Tông 05')


INSERT INTO tblOrder VALUES		(N'Cút Tô Mờ 01','cutomo01@gmai.com',8400000000000,N'Văn Quán Hà Đông 01','xd',1,'2016-08-10','2016-08-11','wait',''),
								(N'Cút Tô Mờ 02','cutomo02@gmai.com',8400000000000,N'Văn Quán Hà Đông 02','xd',2,'2016-08-11','2016-08-12','wait',''),
								(N'Cút Tô Mờ 03','cutomo03@gmai.com',8400000000000,N'Văn Quán Hà Đông 03','xd',3,'2016-08-12','2016-08-13','wait',''),
								(N'Cút Tô Mờ 04','cutomo04@gmai.com',8400000000000,N'Văn Quán Hà Đông 04','xd',4,'2016-08-13','2016-08-14','wait',''),
								(N'Cút Tô Mờ 05','cutomo05@gmai.com',8400000000000,N'Văn Quán Hà Đông 05','xd',5,'2016-08-14','2016-08-15','wait','')


INSERT INTO tblComment(_areaComment,_user,_content,_status) VALUES	('xd01','workerxd01','abc...xyz','show')
																	,('xd01','workerxd02','abc...xyz','show')
																	,('xd01','workerxd03','abc...xyz','show')
																	,('xd01','workerxd04','abc...xyz','show')
																	,('xd01','workerxd06','abc...xyz','show')
																	,('xd01','workerxd08','abc...xyz','show')
																	,('xd01','workerxd01','abc...xyz','hide')






SELECT * FROM tblCareer
SELECT * FROM tblWorker
SELECT * FROM tblOrder
SELECT * FROM tblComment


--DELETE FROM tblOrder WHERE _codeOrder = 7

--DELETE FROM tblCareer WHERE _codeCareer = 'adm, adm'

--UPDATE tblCareer SET _nameCareer = 'aaaa' WHERE _codeCareer = 'adma'

--UPDATE tblOrder SET _lstWorkers = 'xd01#xd02' WHERE _codeOrder = 2;


--DROP TABLE tblWorker
--DROP TABLE tblOrder
--DROP TABLE tblComment
--DROP TABLE tblCareer