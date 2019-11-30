/*
SQLyog Professional v12.09 (64 bit)
MySQL - 8.0.12 : Database - xunwu
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`xunwu` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;

USE `xunwu`;

/*Table structure for table `contain` */

DROP TABLE IF EXISTS `contain`;

CREATE TABLE `contain` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `equi_id` int(11) NOT NULL,
  `addtime` bigint(20) DEFAULT NULL,
  `md5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_id`,`equi_id`),
  KEY `equi_id` (`equi_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `contain_ibfk_5` FOREIGN KEY (`equi_id`) REFERENCES `equipment` (`id`),
  CONSTRAINT `contain_ibfk_7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `contain` */

insert  into `contain`(`id`,`user_id`,`equi_id`,`addtime`,`md5`) values (30,11,6,1575049016,'622dbb7b696e515453e883cd82810784');

/*Table structure for table `equipment` */

DROP TABLE IF EXISTS `equipment`;

CREATE TABLE `equipment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equi_wifiname` varchar(255) NOT NULL,
  `equi_wifipassword` varchar(255) NOT NULL,
  `equi_uuid` bigint(20) NOT NULL,
  `addtime` bigint(20) DEFAULT NULL,
  `equi_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`equi_wifiname`,`equi_wifipassword`,`equi_uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `equipment` */

insert  into `equipment`(`id`,`equi_wifiname`,`equi_wifipassword`,`equi_uuid`,`addtime`,`equi_name`) values (6,'1234','1234',1,NULL,'1'),(7,'123','123',2,NULL,'2'),(8,'123','123',3,NULL,'3'),(9,'1234','1234',4,1575046790,'4');

/*Table structure for table `memo` */

DROP TABLE IF EXISTS `memo`;

CREATE TABLE `memo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `equi_id` int(11) NOT NULL,
  `last_location` varchar(255) DEFAULT NULL,
  `addtime` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`,`equi_id`),
  KEY `equi_idfk` (`equi_id`),
  CONSTRAINT `equi_idfk` FOREIGN KEY (`equi_id`) REFERENCES `equipment` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `memo` */

insert  into `memo`(`id`,`equi_id`,`last_location`,`addtime`) values (37,6,'3',1575047184831),(41,6,'a',1575048607641);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(255) NOT NULL,
  `addtime` bigint(20) DEFAULT NULL,
  `md5` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`openid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`id`,`openid`,`addtime`,`md5`) values (11,'o1Jnc4kd04k-W8nhbsIvzzSHYWgc',1575046790,'622dbb7b696e515453e883cd82810784');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
