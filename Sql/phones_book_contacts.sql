-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: phones_book
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `contacts`
--

DROP TABLE IF EXISTS `contacts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `contacts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `email_address` varchar(255) DEFAULT NULL,
  `phone_number` varchar(45) DEFAULT NULL,
  `mobile_number` varchar(45) DEFAULT NULL,
  `is_favorite` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `compromises`;

CREATE TABLE `compromises` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  `desc` varchar(255) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `compromise_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


INSERT INTO `compromise_type` VALUES (1,'REUNIAO'),(2, 'MEDICO'), (3, 'EXERCICIO'), (4, 'TAREFA'), (5, 'OUTROS');

--
-- Dumping data for table `contacts`
--

LOCK TABLES `contacts` WRITE;
/*!40000 ALTER TABLE `contacts` DISABLE KEYS */;
INSERT INTO `contacts` VALUES (1,'Hermione Granger','granger@witch.com', '0021-44-1865','0021-44-7400-111-222', 1),
(2,'Felipe Lima','lipe@email.com', NULL,'+5582-98444-9612',0),
(3,'Tina Goldstein','tinagoldstein@witch.com', NULL,'0021 1 212 7',1),
(4,'Leta Lestrange','lestrange@witch.com','011-44-01224','011-44-01225',0),
(5, 'Newt Scamander', 'newt@wizard.com','011-44-20-33333333', NULL,  0);
/*!40000 ALTER TABLE `contacts` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-09-14 22:45:48

--
-- Dumping data for table `compromises`
--
INSERT INTO `compromises` VALUES (1,'prova','terei prova de Állgebra', 'tarefa', '20/12/2018', '12:48:44');
