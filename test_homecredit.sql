/*
SQLyog Community v12.5.0 (64 bit)
MySQL - 5.7.26-log : Database - test_homecredit
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test_homecredit` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test_homecredit`;

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(8);

/*Table structure for table `modules` */

DROP TABLE IF EXISTS `modules`;

CREATE TABLE `modules` (
  `module_id` int(11) NOT NULL,
  `module_name` varchar(255) DEFAULT NULL,
  `module_order` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `modules` */

insert  into `modules`(`module_id`,`module_name`,`module_order`) values 
(1001,'PROMOCARD','1'),
(1002,'CATEGORYCARD','2'),
(1003,'FLASHCART','3'),
(1004,'HISTORYCARD','4'),
(1005,'NEWSCARD','5');

/*Table structure for table `role_modules` */

DROP TABLE IF EXISTS `role_modules`;

CREATE TABLE `role_modules` (
  `rm_id` int(11) NOT NULL,
  `module_id` int(11) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rm_id`),
  KEY `FKlfibvmp5sf3u6v4k44e9k526n` (`module_id`),
  KEY `FK61gl6d9pqrosg4vvlh7dpf698` (`role_id`),
  CONSTRAINT `FK61gl6d9pqrosg4vvlh7dpf698` FOREIGN KEY (`role_id`) REFERENCES `userrole` (`role_id`),
  CONSTRAINT `FKlfibvmp5sf3u6v4k44e9k526n` FOREIGN KEY (`module_id`) REFERENCES `modules` (`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `role_modules` */

insert  into `role_modules`(`rm_id`,`module_id`,`role_id`) values 
(1,1001,'R1'),
(2,1002,'R1'),
(3,1003,'R1'),
(4,1004,'R1'),
(5,1005,'R1'),
(6,1001,'R2'),
(7,1005,'R2'),
(8,1003,'R2'),
(9,1002,'R2'),
(10,1005,'R2'),
(11,1001,'R3'),
(12,1003,'R3'),
(13,1002,'R3'),
(14,1005,'R3'),
(15,1004,'R3');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `id` int(11) NOT NULL,
  `country` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `role_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4v0b04tycpkaexv9n3w68auhq` (`role_id`),
  CONSTRAINT `FK4v0b04tycpkaexv9n3w68auhq` FOREIGN KEY (`role_id`) REFERENCES `userrole` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`id`,`country`,`name`,`role_id`) values 
(1,'Ind','Tomy','R1'),
(2,NULL,NULL,'R2'),
(3,NULL,NULL,'R2'),
(4,'england','Leman','R1'),
(5,'sukoi','whwh','R3'),
(6,'Indonesia','whwh','R1'),
(7,'Indonesia','nana','R2'),
(8,'Indonesia','Lela','R3');

/*Table structure for table `userrole` */

DROP TABLE IF EXISTS `userrole`;

CREATE TABLE `userrole` (
  `role_id` varchar(255) NOT NULL,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `userrole` */

insert  into `userrole`(`role_id`,`role_name`) values 
('R1','UserA'),
('R2','UserB'),
('R3','UserC');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
