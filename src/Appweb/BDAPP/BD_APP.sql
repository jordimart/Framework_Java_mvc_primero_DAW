-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: db_admin
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.9-MariaDB

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `dni` varchar(100) CHARACTER SET latin1 NOT NULL,
  `name` varchar(100) CHARACTER SET latin1 NOT NULL,
  `last_name` varchar(45) CHARACTER SET latin1 NOT NULL,
  `mobile` varchar(100) CHARACTER SET latin1 NOT NULL,
  `date_birth` varchar(20) CHARACTER SET latin1 NOT NULL,
  `age` int(11) NOT NULL DEFAULT '0',
  `email` varchar(45) CHARACTER SET latin1 NOT NULL,
  `user` varchar(45) CHARACTER SET latin1 NOT NULL,
  `password` varchar(45) CHARACTER SET latin1 NOT NULL,
  `avatar` varchar(100) CHARACTER SET latin1 NOT NULL,
  `benefits` float NOT NULL DEFAULT '0',
  `status` varchar(100) CHARACTER SET latin1 NOT NULL,
  `date_cont` varchar(100) CHARACTER SET latin1 NOT NULL,
  `antique` int(11) NOT NULL DEFAULT '0',
  `salary` float NOT NULL DEFAULT '0',
  `activity` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`dni`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `user` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('26535550J','Anabel','Gomez','667409626','16/7/1973',42,'AnabelGomez@gmail.com','Anabeluser','Jorge150902','src/Appweb/Modules/Users/Img/Avatares/images.jpg',119.666,'Conected','1/1/2006',10,1914.04,59),('27639007E','Ruben','Martin','667406926','21/9/1983',32,'RubenMartin@gmail.com','Rubenuser','Jorge150902','src/Appweb/Modules/Users/Img/Avatares/images.jpg',105,'Conected','1/1/2006',10,1413.51,15),('27786167M','Dani','Castro','667429926','18/9/1966',49,'DaniCastro@gmail.com','Daniuser','Jorge150902','src/Appweb/Modules/Users/Img/Avatares/images.jpg',116,'Conected','1/1/2006',10,526.2,48),('29696324N','Juan','Mendez','667409926','22/7/1999',16,'JuanMendez@gmail.com','Juanuser','Jorge150902','src/Appweb/Modules/Users/Img/Avatares/images.jpg',117.333,'Conected','1/1/2006',10,1975.7,52),('57835289H','Leo','Torres','667404926','21/4/1965',51,'LeoTorres@gmail.com','Leouser','Jorge150902','src/Appweb/Modules/Users/Img/Avatares/images.jpg',107.333,'Conected','1/1/2006',10,1138.6,22);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-11 21:48:18
