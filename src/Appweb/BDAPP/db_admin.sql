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
INSERT INTO `admin` VALUES ('14058916M','Sara','Romero','667409926','25/9/1977',38,'SaraRomero@gmail.com','Sara2327','SARA6411Sara','src/Appweb/Modules/Users/Img/Avatares/0781.jpg',114.333,'Conected','1/1/2006',10,614.02,43),('14565888B','Rosana','Navarro','667459926','17/3/1962',54,'RosanaNavarro@gmail.com','Rosana8566','ROSANA4903Rosana','src/Appweb/Modules/Users/Img/Avatares/0415.jpg',107,'Conected','1/1/2006',10,1462.8,21),('23177250N','Ruben','Ramirez','667489926','20/3/1999',17,'RubenRamirez@gmail.com','Ruben3498','RUBEN1941Ruben','src/Appweb/Modules/Users/Img/Avatares/0770.jpg',124.666,'Conected','1/1/2006',10,1611.94,74),('26362736K','Salva','Torres','667409526','28/2/1980',36,'SalvaTorres@gmail.com','Salva1646','SALVA4995Salva','src/Appweb/Modules/Users/Img/Avatares/0303.jpg',124,'Conected','1/1/2006',10,1243.15,72),('31907509T','Elena','Dominguez','667400926','9/8/1964',51,'ElenaDominguez@gmail.com','Elena4032','ELENA4072Elena','src/Appweb/Modules/Users/Img/Avatares/0770.jpg',103.333,'Conected','1/1/2006',10,1840.03,10),('32680895B','Antonio','Hernandez','667429926','22/8/1988',27,'AntonioHernandez@gmail.com','Antonio9941','ANTONIO5054Antonio','src/Appweb/Modules/Users/Img/Avatares/1558.jpg',105,'Conected','1/1/2006',10,1122.84,15),('38658729F','Andres','Vazquez','667459926','28/10/1971',44,'AndresVazquez@gmail.com','Andres6070','ANDRES4305Andres','src/Appweb/Modules/Users/Img/Avatares/1558.jpg',129.333,'Conected','1/1/2006',10,743.98,88),('45444586J','Dani','Suarez','667409226','12/10/1994',21,'DaniSuarez@gmail.com','Dani8397','DANI3264Dani','src/Appweb/Modules/Users/Img/Avatares/1331.jpg',106.333,'Conected','1/1/2006',10,1215.92,19),('48012215Z','Elsa','Moreno','667809926','18/2/1979',37,'ElsaMoreno@gmail.com','Elsa6440','ELSA1475Elsa','src/Appweb/Modules/Users/Img/Avatares/0815.jpg',105.333,'Conected','1/1/2006',10,736.81,16),('48293556L','jorge','martinez','660371229','6/4/1983',33,'jorge@gmail.com','Litri211','Litri150902litri','src\\Appweb\\Modules\\Users\\Img\\Avatares\\0303.jpg',120,'Conected','5/4/2006',10,1000,60),('52969656N','Aron','Mendez','669409926','3/6/1965',50,'AronMendez@gmail.com','Aron3633','ARON2837Aron','src/Appweb/Modules/Users/Img/Avatares/0808.jpg',123.666,'Conected','1/1/2006',10,739.94,71),('77644615L','Anabel','Ramirez','667459926','30/4/1976',40,'AnabelRamirez@gmail.com','Anabel9903','ANABEL6124Anabel','src/Appweb/Modules/Users/Img/Avatares/1455.jpg',109,'Conected','1/1/2006',10,1007,27),('79679802M','Penelope','Dominguez','667459926','24/9/1980',35,'PenelopeDominguez@gmail.com','Penelope3724','PENELOPE6250Penelope','src/Appweb/Modules/Users/Img/Avatares/1570.jpg',112,'Conected','1/1/2006',10,1218.15,36),('81244496D','Raquel','Moreno','667449926','18/10/1973',42,'RaquelMoreno@gmail.com','Raquel6988','RAQUEL1926Raquel','src/Appweb/Modules/Users/Img/Avatares/0781.jpg',113.333,'Conected','1/1/2006',10,902.88,40);
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

-- Dump completed on 2016-04-29 18:54:30
