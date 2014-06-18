CREATE DATABASE  IF NOT EXISTS `db_websitentm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_websitentm`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: db_websitentm
-- ------------------------------------------------------
-- Server version	5.6.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_diaphuong`
--

DROP TABLE IF EXISTS `tbl_diaphuong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_diaphuong` (
  `maDP` int(11) NOT NULL AUTO_INCREMENT,
  `tenDP` varchar(45) NOT NULL,
  `SDT` varchar(45) NOT NULL,
  `noiNhan` varchar(45) DEFAULT NULL,
  `dienTich` float DEFAULT NULL,
  `soDan` float DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL,
  PRIMARY KEY (`maDP`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_diaphuong`
--

LOCK TABLES `tbl_diaphuong` WRITE;
/*!40000 ALTER TABLE `tbl_diaphuong` DISABLE KEYS */;
INSERT INTO `tbl_diaphuong` VALUES (1,'Xã Bình Triều1','051039992','UBND xã, thị trấn',10.1,2,1),(2,'Xã Bình Minh','05103999442','UBND xã, thị trấn',10,2,1),(3,'Xã Bình Tú','05103359222','UBND xã, thị trấn',10,2,1);
/*!40000 ALTER TABLE `tbl_diaphuong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_dptc`
--

DROP TABLE IF EXISTS `tbl_dptc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_dptc` (
  `maDPTC` int(11) NOT NULL AUTO_INCREMENT,
  `maTC` int(11) DEFAULT NULL,
  `maDP` int(11) DEFAULT NULL,
  `noiDung` varchar(1000) NOT NULL,
  PRIMARY KEY (`maDPTC`),
  KEY `maDP` (`maDP`),
  KEY `maTC` (`maTC`),
  CONSTRAINT `tbl_dptc_ibfk_1` FOREIGN KEY (`maDP`) REFERENCES `tbl_diaphuong` (`maDP`),
  CONSTRAINT `tbl_dptc_ibfk_2` FOREIGN KEY (`maTC`) REFERENCES `tbl_tieuchi` (`maTC`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_dptc`
--

LOCK TABLES `tbl_dptc` WRITE;
/*!40000 ALTER TABLE `tbl_dptc` DISABLE KEYS */;
INSERT INTO `tbl_dptc` VALUES (3,24,1,'12113'),(4,23,1,'Có bưu điện'),(5,19,1,'Tốt'),(6,24,2,'Tốt'),(7,24,3,'Tốt'),(8,21,1,'Có 2 trường Cấp 1 và 1 trường cấp 2'),(9,25,1,'Nông nghiệp là chính'),(10,26,3,'Có nhiều '),(11,23,3,'Có 1 bưu điện'),(12,28,1,'Có nhiều'),(13,19,3,'Tốt');
/*!40000 ALTER TABLE `tbl_dptc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_nguoiphutrach`
--

DROP TABLE IF EXISTS `tbl_nguoiphutrach`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_nguoiphutrach` (
  `maNPT` int(11) NOT NULL AUTO_INCREMENT,
  `hoTen` varchar(45) NOT NULL,
  `namSinh` datetime DEFAULT NULL,
  `queQuan` varchar(45) NOT NULL,
  `hocVi` varchar(45) NOT NULL,
  `chucVu` varchar(45) NOT NULL,
  `SDT` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `maDP` int(11) DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`maNPT`),
  KEY `maDP_idx` (`maDP`),
  CONSTRAINT `maDP` FOREIGN KEY (`maDP`) REFERENCES `tbl_diaphuong` (`maDP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_nguoiphutrach`
--

LOCK TABLES `tbl_nguoiphutrach` WRITE;
/*!40000 ALTER TABLE `tbl_nguoiphutrach` DISABLE KEYS */;
INSERT INTO `tbl_nguoiphutrach` VALUES (1,'Phạm Đình Công','1991-11-24 00:00:00','Thanh Hóa','Kỹ sư','Chủ tịch xã','0982207386','congpd.itedu@gmail.com',3,1),(2,'Nguyễn Ngọc Duy','1991-02-04 00:00:00','Quảng Nam','Kỹ sư','Chủ tịch xã','0982207386','duynn.itedu@gmail.com',2,1),(3,'Bùi Quốc Tuyển','1991-06-03 00:00:00','Quảng Trị','Kỹ sư','Chủ tịch xã','0982207386','tuyenbq.itedu@gmail.com',3,1),(4,'Lê Thanh Tùng','1989-06-03 00:00:00','Quảng Trị','Kỹ sư','Phó hủ tịch xã','0982207386','tuyenbq.itedu@gmail.com',1,1),(5,'NguyenP','1992-06-04 00:00:00','Quảng Trị','Kỹ sư','Chủ Tịch ','01659050720','nguyen1992002@gmail.com',NULL,1);
/*!40000 ALTER TABLE `tbl_nguoiphutrach` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_taikhoan`
--

DROP TABLE IF EXISTS `tbl_taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_taikhoan` (
  `maTK` int(11) NOT NULL AUTO_INCREMENT,
  `tenTK` varchar(45) NOT NULL,
  `matkhau` varchar(45) NOT NULL,
  `hoTen` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `SDT` varchar(45) DEFAULT NULL,
  `trangThaiHD` tinyint(1) NOT NULL,
  PRIMARY KEY (`maTK`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_taikhoan`
--

LOCK TABLES `tbl_taikhoan` WRITE;
/*!40000 ALTER TABLE `tbl_taikhoan` DISABLE KEYS */;
INSERT INTO `tbl_taikhoan` VALUES (1,'admin','admin','Phạm Đình Công','congpd.itedu@gmail.com','0982207386',1),(2,'haivv','admin','Vũ Văn Hải','haivv.itedu@gmail.com','0087234324',1),(3,'duynn','duynn','Nguyễn Ngọc Duy','duynn.itedu@gmail.com','0982200444',1),(4,'thanhnv','thanhnv','Nguyễn Văn Thanh','thanhnv.itedu@gmail.com','0982200444',0),(6,'tuyenbq','tuyenbq','Bùi Quốc Tuyển','tuyenbq.itedu@gmail.com','0983332221',1),(7,'tunglt','123456','Lê Thanh Tùng','tunglt@gmail.com','0988444222',1),(9,'anhlt','123456','Ngô Thị Anh','anhtl@gmail.com','0922334455',1),(12,'thanhnt','admin','admin','thanhnv@gmail.com','0987774442',1),(18,'alonxo','123456','Lê Thanh Tùng','tunglt@gmail.com','01884443324',1);
/*!40000 ALTER TABLE `tbl_taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tieuchi`
--

DROP TABLE IF EXISTS `tbl_tieuchi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tieuchi` (
  `maTC` int(11) NOT NULL AUTO_INCREMENT,
  `tenTC` varchar(50) NOT NULL,
  PRIMARY KEY (`maTC`),
  UNIQUE KEY `tenTC_UNIQUE` (`tenTC`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tieuchi`
--

LOCK TABLES `tbl_tieuchi` WRITE;
/*!40000 ALTER TABLE `tbl_tieuchi` DISABLE KEYS */;
INSERT INTO `tbl_tieuchi` VALUES (24,'An ninh xã hội'),(23,'Bưu điện'),(29,'Chợ nông thôn'),(19,'Giao thông'),(25,'Hình thức sản xuất'),(26,'Hộ nghèo'),(20,'Lao động'),(28,'Nhà ở dân cư'),(27,'Thu nhập'),(21,'Trường học'),(30,'Văn hóa'),(22,'Y tế');
/*!40000 ALTER TABLE `tbl_tieuchi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_tulieu`
--

DROP TABLE IF EXISTS `tbl_tulieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_tulieu` (
  `maTL` int(11) NOT NULL AUTO_INCREMENT,
  `website` varchar(45) DEFAULT NULL,
  `baiBao` varchar(45) DEFAULT NULL,
  `hinhAnh` varchar(45) DEFAULT NULL,
  `video` varchar(45) DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`maTL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tulieu`
--

LOCK TABLES `tbl_tulieu` WRITE;
/*!40000 ALTER TABLE `tbl_tulieu` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_tulieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_vanban`
--

DROP TABLE IF EXISTS `tbl_vanban`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_vanban` (
  `maVB` int(11) NOT NULL AUTO_INCREMENT,
  `tenVB` varchar(45) NOT NULL,
  `loaiVB` varchar(45) NOT NULL,
  `noiBanHanh` varchar(45) NOT NULL,
  `ngayBanHanh` datetime DEFAULT NULL,
  `noiNhan` varchar(45) NOT NULL,
  `noiDung` varchar(2000) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`maVB`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_vanban`
--

LOCK TABLES `tbl_vanban` WRITE;
/*!40000 ALTER TABLE `tbl_vanban` DISABLE KEYS */;
INSERT INTO `tbl_vanban` VALUES (1,'08-UBND/HD','Hướng dẫn','UBND tỉnh Quảng Nam','2012-08-20 00:00:00','UBND xã, thị trấn','Hướng dẫn về việc thu gom rác thải.',1),(2,'Số 09-UBND/HD','Hướng dẫn','UBND tỉnh Quảng Nam','2012-08-20 00:00:00','UBND xã, thị trấn','Hướng dẫn về việc bảo vệ môi trường.',1),(10,'Báo cáo doanh thu','Báo cáo','USBN xã','2014-02-02 00:00:00','UBND xã, thị trấn','Đây là nội dung',1),(11,'Báo cáo doanh thu tháng 7','Báo cáo','USBN xã','2014-02-06 00:00:00','UBND','Đây là nội dung nữa',1);
/*!40000 ALTER TABLE `tbl_vanban` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-06-18  7:29:47
