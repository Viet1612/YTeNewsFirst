-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: ytenews
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_category`
--

DROP TABLE IF EXISTS `tbl_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(255) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_category`
--

LOCK TABLES `tbl_category` WRITE;
/*!40000 ALTER TABLE `tbl_category` DISABLE KEYS */;
INSERT INTO `tbl_category` VALUES (1,'Love'),(2,'animal'),(3,'country'),(4,'world');
/*!40000 ALTER TABLE `tbl_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_comment`
--

DROP TABLE IF EXISTS `tbl_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `news_id` bigint(20) NOT NULL,
  `comment_content` varchar(500) COLLATE utf8_bin NOT NULL,
  ` time` datetime NOT NULL,
  PRIMARY KEY (`comment_id`),
  KEY `fk_user_id_idx` (`user_id`),
  KEY `fk_news_id_idx` (`news_id`),
  CONSTRAINT `fk_news_id` FOREIGN KEY (`news_id`) REFERENCES `tbl_news` (`news_id`),
  CONSTRAINT `fk_user_id` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_comment`
--

LOCK TABLES `tbl_comment` WRITE;
/*!40000 ALTER TABLE `tbl_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_contact`
--

DROP TABLE IF EXISTS `tbl_contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_contact` (
  `contact_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `tel` varchar(255) COLLATE utf8_bin NOT NULL,
  `message` mediumtext COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_contact`
--

LOCK TABLES `tbl_contact` WRITE;
/*!40000 ALTER TABLE `tbl_contact` DISABLE KEYS */;
/*!40000 ALTER TABLE `tbl_contact` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_news`
--

DROP TABLE IF EXISTS `tbl_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_news` (
  `news_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category_id` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `news_name` varchar(500) COLLATE utf8_bin NOT NULL,
  `description` varchar(500) COLLATE utf8_bin NOT NULL,
  `content` longtext COLLATE utf8_bin NOT NULL,
  `image` varchar(255) COLLATE utf8_bin NOT NULL,
  `date` date NOT NULL,
  `view` bigint(20) NOT NULL,
  `approve` int(1) NOT NULL,
  PRIMARY KEY (`news_id`),
  KEY `fk_catelogy_idx` (`category_id`),
  KEY `fk_user_idx` (`user_id`),
  CONSTRAINT `fk_catelogy` FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`category_id`),
  CONSTRAINT `fk_user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_news`
--

LOCK TABLES `tbl_news` WRITE;
/*!40000 ALTER TABLE `tbl_news` DISABLE KEYS */;
INSERT INTO `tbl_news` VALUES (17,1,2,'fasfgg','àdggadg','agagfgdg','1.jpg','1974-09-20',1,0),(19,1,3,'fasfgg','àdggadg','agagfgdg','logan.jpg','1975-09-20',1,1),(20,1,2,'fasfgg','àdggadg','agagfgdg','1.jpg','1976-09-20',1,1),(21,2,3,'fasfgg','àdggadg','agagfgdg','logan.jpg','1977-09-20',1,0),(22,NULL,2,'fasfgg','àdggadg','agagfgdg','1.jpg','1976-09-20',1,1),(24,NULL,2,'dfaffffffffffffffffffffffffffffff','ffffffffffffffffffffff','fffffffffffffffffffffffffffffffff','1572603365016.png','2019-11-01',0,0),(25,NULL,2,'dfaffffffffffffffffffffffffffffff','ffffffffffffffffffffff','fffffffffffffffffffffffffffffffff','1572603365119.png','2019-11-01',0,0),(26,NULL,2,'fafafafdsf','fafsdfafd','àdafasf','1572619031977.png','2019-11-01',0,0),(27,NULL,2,'fafafafdsf','fafsdfafd','àdafasf','1572619032106.png','2019-11-01',0,0),(28,NULL,2,'vietttttttttttttttttttttttttttttttttt','vietttttttttttttttttttttttttttttttttt','vietttttttttttttttttttttttttttttttttt','1572619213977.png','2019-11-01',0,0),(29,NULL,2,'vietttttttttttttttttttttttttttttttttt','vietttttttttttttttttttttttttttttttttt','vietttttttttttttttttttttttttttttttttt','1572619214086.png','2019-11-01',0,0),(30,NULL,2,'viet1111111111111111','viet1111111111111111','viet1111111111111111','1572619302722.png','2019-11-01',0,0),(31,NULL,2,'viet1111111111111111','viet1111111111111111','viet1111111111111111','1572619302828.png','2019-11-01',0,0),(32,NULL,2,'1233333333333333333333','1233333333333333333333','1233333333333333333333','1572619370004.png','2019-11-01',0,0),(33,NULL,2,'1233333333333333333333','1233333333333333333333','1233333333333333333333','1572619370073.png','2019-11-01',0,0),(34,NULL,2,'adjadahdah','dâudad','dâda','1572926161239.png','2019-11-05',0,0),(35,NULL,2,'adjadahdah','dâudad','dâda','1572926161604.png','2019-11-05',0,0),(36,NULL,2,'dsdsd','sdsdsd','dâda','1572926256202.png','2019-11-05',0,0),(37,NULL,2,'dsdsd','sdsdsd','dâda','1572926256225.png','2019-11-05',0,0),(38,NULL,2,'á','s','s','1572975510805.png','2019-11-06',0,0),(39,NULL,2,'a','a','a','1572975615169.png','2019-11-06',0,0),(40,NULL,2,'aaaaaaaa','aaaaaaa','aaa','1572976066064.png','2019-11-06',0,0),(41,NULL,2,'Viet1111111111111','viet','aaaaaafafd','1572976165677.png','2019-11-06',0,0),(42,NULL,2,'c','s','s','1572977622108.png','2019-11-06',0,0),(43,NULL,2,'aafafewrf','aaá','aàd','1572977805442.png','2019-11-06',0,0),(44,NULL,2,'a','a','a','1572977901780.png','2019-11-06',0,0),(45,NULL,2,'a','a','a','1572978072852.png','2019-11-06',0,0),(46,NULL,3,'juy','fjg','fjh','1573036654129.png','2019-11-06',0,0),(47,NULL,3,'bnv nv','vvvnv ','vnvn','1573149205985.png','2019-11-08',0,0);
/*!40000 ALTER TABLE `tbl_news` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_user`
--

DROP TABLE IF EXISTS `tbl_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `full_name` varchar(255) COLLATE utf8_bin NOT NULL,
  `email` varchar(255) COLLATE utf8_bin NOT NULL,
  `tel` varchar(255) COLLATE utf8_bin NOT NULL,
  `pass` varchar(255) COLLATE utf8_bin NOT NULL,
  `salt` varchar(255) COLLATE utf8_bin NOT NULL,
  `rule` int(1) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `login_name_UNIQUE` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_user`
--

LOCK TABLES `tbl_user` WRITE;
/*!40000 ALTER TABLE `tbl_user` DISABLE KEYS */;
INSERT INTO `tbl_user` VALUES (1,'vietdz','Viettran','sdafaf','123456','71dd07494c5ee54992a27746d547e25dee01bd97','123456',0),(2,'viet1','VietTran','sdafaf','123456','71dd07494c5ee54992a27746d547e25dee01bd97','123456',2),(3,'viet2','Viettrandz','sdafaf','123456','71dd07494c5ee54992a27746d547e25dee01bd97','123456',2),(4,'viet3','Viettran','sdafaf','123456','71dd07494c5ee54992a27746d547e25dee01bd97','123456',1);
/*!40000 ALTER TABLE `tbl_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ytenews'
--

--
-- Dumping routines for database 'ytenews'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-11-08 12:13:16
