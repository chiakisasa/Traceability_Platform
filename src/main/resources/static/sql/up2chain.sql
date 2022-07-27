/*
SQLyog Enterprise - MySQL GUI v6.14
MySQL - 5.5.62 : Database - coinchain
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `coinchain`;

USE `coinchain`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `up2chain` */

DROP TABLE IF EXISTS `up2chain`;

CREATE TABLE `up2chain` (
  `private_key` varchar(255) CHARACTER SET utf8 NOT NULL,
  `abstr` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `sign` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `proofid` int(11) DEFAULT NULL,
  `time` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `itemname` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`private_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

/*Data for the table `up2chain` */

insert  into `up2chain`(`private_key`,`abstr`,`sign`,`proofid`,`time`,`itemname`) values ('1','测试','大大',546,'2022-07-11','急急急'),('2','测试2','大我',2,'2022-07-04','red'),('3','测试3','大你',5,'2022-07-09','yellow'),('4','测试4','大招',4,'2022-07-06','wonder');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
