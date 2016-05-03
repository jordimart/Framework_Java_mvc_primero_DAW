CREATE DATABASE  IF NOT EXISTS `db_admin` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `db_admin`;
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
  `dni` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `name` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `last_name` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `mobile` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `date_birth` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `age` int(11) NOT NULL DEFAULT '0',
  `email` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `user` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `password` varchar(45) COLLATE utf8_spanish_ci NOT NULL,
  `avatar` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `benefits` float NOT NULL DEFAULT '0',
  `status` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `date_cont` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `antique` int(11) NOT NULL DEFAULT '0',
  `salary` float NOT NULL DEFAULT '0',
  `activity` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`dni`),
  UNIQUE KEY `dni` (`dni`),
  UNIQUE KEY `user` (`user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('06592638X','Davi','Sanchez','667489926','22/1/1972',44,'DavidSanchez@gmail.com','David7883','DAVID9665David','src/Appweb/Modules/Users/Img/Avatares/0303.jpg',128.333,'Conected','1/1/2006',10,1414.18,85),('13298897K','Paco','Ruiz','667406926','9/9/1980',35,'PacoRuiz@gmail.com','Paco5717','PACO5413Paco','src/Appweb/Modules/Users/Img/Avatares/1494.jpg',121.333,'Conected','1/1/2006',10,1179.09,64),('19341029F','Candy','Dominguez','667409226','23/6/1994',21,'CandyDominguez@gmail.com','Candy3765','CANDY8970Candy','src/Appweb/Modules/Users/Img/Avatares/0288.jpg',125.666,'Conected','1/1/2006',10,1886.16,77),('21571751M','Noelia','Morrell','667408926','30/3/1979',37,'NoeliaMorrell@gmail.com','Noelia8345','NOELIA2748Noelia','src/Appweb/Modules/Users/Img/Avatares/1567.jpg',104.667,'Conected','1/1/2006',10,1881.22,14),('21608067G','Rosana','Navarro','668409926','2/10/1957',58,'RosanaNavarro@gmail.com','Rosana6455','ROSANA4069Rosana','src/Appweb/Modules/Users/Img/Avatares/1567.jpg',126.333,'Conected','1/1/2006',10,1518.89,79),('22614863K','Silvie','Lopez','667406926','23/1/1974',42,'SilviaLopez@gmail.com','Silvia8189','SILVIA6091Silvia','src/Appweb/Modules/Users/Img/Avatares/1567.jpg',110.333,'Conected','1/1/2006',10,1339.65,31),('23236736C','Silvia','Sanchez','667404926','14/10/1995',20,'SilviaSanchez@gmail.com','Silvia3577','SILVIA8247Silvia','src/Appweb/Modules/Users/Img/Avatares/1448.jpg',108.667,'Conected','1/1/2006',10,1015.84,26),('45729667D','Noelia','Moreno','667404926','19/2/1951',65,'NoeliaMoreno@gmail.com','Noelia4743','NOELIA8103Noelia','src/Appweb/Modules/Users/Img/Avatares/0808.jpg',130.666,'Conected','1/1/2006',10,1669.23,92),('48293556L','jorge','martine','660371229','5/5/1983',33,'jorge@gmail.com','Jordimart','Jorge150902jorge','src\\Appweb\\Modules\\Users\\Img\\Avatares\\0782.jpg',99.9999,'Conected','11/5/2006',9,1000,30),('56523205S','Salva','Martin','667406926','27/6/1968',47,'SalvaMartin@gmail.com','Salva3051','SALVA4231Salva','src/Appweb/Modules/Users/Img/Avatares/0781.jpg',121.666,'Conected','1/1/2006',10,1219.51,65),('86730115J','Salva','Gomez','667479926','30/10/1956',59,'SalvaGomez@gmail.com','Salva9281','SALVA2106Salva','src/Appweb/Modules/Users/Img/Avatares/0808.jpg',103.333,'Conected','1/1/2006',10,902.96,10);
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

-- Dump completed on 2016-05-03 16:09:14
