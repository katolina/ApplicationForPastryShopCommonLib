/*
SQLyog Community v13.1.5  (32 bit)
MySQL - 10.4.11-MariaDB : Database - appdatabase
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`appdatabase` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;

USE `appdatabase`;

/*Table structure for table `guest` */

DROP TABLE IF EXISTS `guest`;

CREATE TABLE `guest` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(225) DEFAULT NULL,
  `lastName` varchar(225) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  `telephone` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

/*Data for the table `guest` */

insert  into `guest`(`id`,`firstName`,`lastName`,`email`,`telephone`) values 
(6,'Katica','Milicevic','katica@gmail.com','0641144555'),
(7,'Neki','Neki','neki@gmail.com','0643311555'),
(10,'Bojana','Milicevic','bojana@gmail.com','0641122555'),
(18,'Milos','Milic','milic@gmail.com','0641122555');

/*Table structure for table `invoice` */

DROP TABLE IF EXISTS `invoice`;

CREATE TABLE `invoice` (
  `invoice_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `amount` double DEFAULT NULL,
  PRIMARY KEY (`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4;

/*Data for the table `invoice` */

insert  into `invoice`(`invoice_id`,`amount`) values 
(11,199.2),
(12,199.2),
(13,597.5999999999999),
(14,199.2),
(15,199.2),
(16,396),
(17,840),
(18,172.8),
(19,172.8),
(20,2520),
(21,324),
(22,324),
(23,324),
(33,348),
(51,348),
(52,348),
(53,348);

/*Table structure for table `invoice_item` */

DROP TABLE IF EXISTS `invoice_item`;

CREATE TABLE `invoice_item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `invoice_id` int(10) unsigned NOT NULL,
  `item_number` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `amount` double DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`invoice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4;

/*Data for the table `invoice_item` */

insert  into `invoice_item`(`id`,`invoice_id`,`item_number`,`price`,`quantity`,`amount`,`product_id`) values 
(4,11,1,199.2,1,199.2,18),
(5,12,1,199.2,1,199.2,18),
(6,13,1,199.2,3,597.5999999999999,19),
(7,14,1,199.2,1,199.2,18),
(8,15,1,199.2,1,199.2,18),
(9,16,2,132,3,396,18),
(10,17,1,210,4,840,21),
(11,18,1,172.8,1,172.8,23),
(12,19,1,172.8,1,172.8,23),
(13,20,1,210,12,2520,24),
(14,21,1,162,2,324,26),
(15,22,1,162,2,324,26),
(16,23,1,162,2,324,26),
(23,33,1,174,2,348,35),
(40,52,1,174,2,348,35),
(41,53,1,174,2,348,35),
(42,53,1,174,2,348,35),
(115,53,1,174,2,348,35);

/*Table structure for table `manufacturer` */

DROP TABLE IF EXISTS `manufacturer`;

CREATE TABLE `manufacturer` (
  `manufacturer_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`manufacturer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

/*Data for the table `manufacturer` */

insert  into `manufacturer`(`manufacturer_id`,`name`) values 
(4,'As'),
(5,'Trijumf'),
(6,'Milicevic'),
(7,'Nadalina'),
(8,'Kolacici');

/*Table structure for table `order_item` */

DROP TABLE IF EXISTS `order_item`;

CREATE TABLE `order_item` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `order_id` int(10) unsigned NOT NULL,
  `numberOrder` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `product_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4;

/*Data for the table `order_item` */

insert  into `order_item`(`id`,`order_id`,`numberOrder`,`quantity`,`product_id`) values 
(29,23,1,1,38),
(30,24,1,12,26),
(31,25,1,3,29),
(32,26,1,2,32),
(33,26,2,2,29),
(34,27,1,14,32),
(35,28,1,3,32),
(36,29,1,3,32),
(40,35,1,2,47),
(43,42,1,2,48);

/*Table structure for table `order_order` */

DROP TABLE IF EXISTS `order_order`;

CREATE TABLE `order_order` (
  `order_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `date_order` date DEFAULT NULL,
  `guest_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4;

/*Data for the table `order_order` */

insert  into `order_order`(`order_id`,`date_order`,`guest_id`) values 
(23,'2020-02-10',6),
(24,'2020-02-11',6),
(25,'2020-02-15',6),
(26,'2020-02-11',6),
(27,'2020-02-10',6),
(28,'2020-02-10',6),
(29,'2020-02-20',6),
(35,'2020-02-10',6),
(36,'2020-02-10',6),
(39,'2020-02-10',6),
(42,'2020-02-02',6);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `quantity` bigint(20) DEFAULT NULL,
  `measurement_unit` varchar(255) DEFAULT NULL,
  `priceWithVat` double DEFAULT NULL,
  `priceWithoutVat` double DEFAULT NULL,
  `manufacturer_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8mb4;

/*Data for the table `product` */

insert  into `product`(`product_id`,`name`,`quantity`,`measurement_unit`,`priceWithVat`,`priceWithoutVat`,`manufacturer_id`) values 
(47,'Proizvod 18',6,'KG',174,145,4),
(48,'Proizvod 15',14,'KG',176.4,147,4),
(49,'Proizvod 15',4,'KG',666,555,4),
(50,'Proizvod7',4,'KG',93.6,78,4);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(225) DEFAULT NULL,
  `lastName` varchar(225) DEFAULT NULL,
  `username` varchar(225) DEFAULT NULL,
  `password` varchar(225) DEFAULT NULL,
  `email` varchar(225) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

/*Data for the table `user` */

insert  into `user`(`id`,`firstName`,`lastName`,`username`,`password`,`email`) values 
(1,'Katica','Milicevic','kata','kata123','kata@gmail.com'),
(2,'Bojana','Milicevic','bojana','bojana123','bojana@gmail.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
