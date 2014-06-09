CREATE DATABASE  IF NOT EXISTS `db_websitentm` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_websitentm`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: localhost    Database: db_websitentm
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
INSERT INTO `tbl_diaphuong` VALUES (1,'Xã Bình Triều','05103999222','UBND xã, thị trấn',10,2,1),(2,'Xã Bình Minh','05103999442','UBND xã, thị trấn',10,2,1),(3,'Xã Bình Tú','05103359222','UBND xã, thị trấn',10,2,1);
/*!40000 ALTER TABLE `tbl_diaphuong` ENABLE KEYS */;
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
  `maDP` int(11) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`maNPT`),
  KEY `maDP_idx` (`maDP`),
  CONSTRAINT `maDP` FOREIGN KEY (`maDP`) REFERENCES `tbl_diaphuong` (`maDP`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_nguoiphutrach`
--

LOCK TABLES `tbl_nguoiphutrach` WRITE;
/*!40000 ALTER TABLE `tbl_nguoiphutrach` DISABLE KEYS */;
INSERT INTO `tbl_nguoiphutrach` VALUES (1,'Phạm Đình Công','1991-11-24 00:00:00','Thanh Hóa','Kỹ sư','Chủ tịch xã','0982207386','congpd.itedu@gmail.com',1,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_taikhoan`
--

LOCK TABLES `tbl_taikhoan` WRITE;
/*!40000 ALTER TABLE `tbl_taikhoan` DISABLE KEYS */;
INSERT INTO `tbl_taikhoan` VALUES (1,'admin','admin','Phạm Đình Công','congpd.itedu@gmail.com','0982207386',1),(2,'haivv','admin','Vũ Văn Hải','haivv.itedu@gmail.com','0903444222',1),(3,'duynn','duynn','Nguyễn Ngọc Duy','duynn.itedu@gmail.com','0982200444',1),(4,'thanhnv','thanhnv','Nguyễn Văn Thanh','thanhnv.itedu@gmail.com','0982200444',0),(6,'tuyenbq','tuyenbq','Bùi Quốc Tuyển','tuyenbq.itedu@gmail.com','0983332221',1);
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
  `noiDung` varchar(1000) NOT NULL,
  `maDP` int(11) DEFAULT NULL,
  PRIMARY KEY (`maTC`),
  KEY `maDP` (`maDP`),
  CONSTRAINT `tbl_tieuchi_ibfk_1` FOREIGN KEY (`maDP`) REFERENCES `tbl_diaphuong` (`maDP`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_tieuchi`
--

LOCK TABLES `tbl_tieuchi` WRITE;
/*!40000 ALTER TABLE `tbl_tieuchi` DISABLE KEYS */;
INSERT INTO `tbl_tieuchi` VALUES (1,'Tiêu chí giao thông','Có 1,2km đường quốc lộ, 3km đường dân sinh\nđạt tỉ lệ 70% tiêu chí',1),(2,'Tiêu chí trường học','Có trường THPT Tiểu La, THCS Nguyễn Hiền, \nđạt tỉ lệ 100% tiêu chí.',1),(3,'Tiêu chí Y tế','Có trạm y tế xã, có 1 bác sĩ và 2 y tá,\nđạt tỉ lệ 100% tiêu chí',1),(4,'Tiêu chí Lao động','Đạt 70% tiêu chí. Tổng số lao động của xã: 400 người,\nsố lao động có việc làm thường xuyên: 340 người. Tỉ lệ lao động của xã: nông nghiệp 70%, Công nghiệp - Dịch vụ: 20%\n, Ngư nghiệp: 10%',1);
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
  `noiDung` varchar(45) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`maVB`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_vanban`
--

LOCK TABLES `tbl_vanban` WRITE;
/*!40000 ALTER TABLE `tbl_vanban` DISABLE KEYS */;
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

-- Dump completed on 2014-06-09  9:22:23
