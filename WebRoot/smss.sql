/*
SQLyog Ultimate v8.32 
MySQL - 5.1.68-community : Database - smss
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`smss` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `smss`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `name` int(20) NOT NULL COMMENT '账号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`password`) values (1,1,'111'),(2,2,'222'),(3,3,'333'),(4,4,'444'),(5,5,'555'),(6,6,'666'),(7,7,'777'),(8,8,'888');

/*Table structure for table `classs` */

DROP TABLE IF EXISTS `classs`;

CREATE TABLE `classs` (
  `class_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `class_name` varchar(20) NOT NULL COMMENT '课程名称',
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `classs` */

insert  into `classs`(`class_id`,`class_name`) values (1,'软件一班'),(2,'软件1班');

/*Table structure for table `courses` */

DROP TABLE IF EXISTS `courses`;

CREATE TABLE `courses` (
  `course_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '课程编号',
  `course_name` varchar(20) NOT NULL COMMENT '课程名称',
  PRIMARY KEY (`course_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `courses` */

insert  into `courses`(`course_id`,`course_name`) values (1,'计算机网络'),(2,'Android'),(3,'JSP程序设计——用JSP开发web应用'),(4,'软件设计师综合'),(5,'软件工程'),(6,'物联网应用基础');

/*Table structure for table `score` */

DROP TABLE IF EXISTS `score`;

CREATE TABLE `score` (
  `score_id` int(20) NOT NULL AUTO_INCREMENT COMMENT '成绩编号',
  `id` varchar(20) NOT NULL COMMENT '学号',
  `course_id` varchar(20) NOT NULL COMMENT '课程编号',
  `score_num` double NOT NULL COMMENT '分数',
  `class_id` int(20) NOT NULL DEFAULT '1' COMMENT '班级编号',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;

/*Data for the table `score` */

insert  into `score`(`score_id`,`id`,`course_id`,`score_num`,`class_id`) values (1,'1','1',99,1),(2,'1','2',98,1),(3,'1','3',91,1),(4,'1','4',93,1),(5,'1','5',94,1),(6,'1','6',95,1),(7,'2','1',93,1),(8,'2','2',92,1),(9,'2','3',95,1),(10,'2','4',96,1),(11,'2','5',98,1),(12,'2','6',99,1),(13,'3','1',100,1),(14,'3','2',98,1),(15,'3','3',94,1),(16,'3','4',94,1),(17,'3','5',99,1),(18,'3','6',100,1),(19,'4','1',91,1),(20,'4','2',92,1),(21,'4','3',93,1),(22,'4','4',94,1),(23,'4','5',95,1),(24,'4','6',99,1),(25,'5','1',99,1),(26,'5','2',99,1),(27,'5','3',100,1),(28,'5','4',96,1),(29,'5','5',98,1),(30,'5','6',100,1),(31,'6','1',100,1),(32,'6','2',97,1),(33,'6','3',98,1),(34,'6','4',99,1),(35,'6','5',90,1),(36,'6','6',95,1),(37,'7','1',95,1),(38,'7','2',98,1),(39,'7','3',98,1);

/*Table structure for table `students` */

DROP TABLE IF EXISTS `students`;

CREATE TABLE `students` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '学号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` int(20) NOT NULL DEFAULT '1' COMMENT '性别{1:男,2:女}',
  `age` int(20) NOT NULL DEFAULT '20' COMMENT '年龄',
  `class_id` int(20) NOT NULL DEFAULT '1' COMMENT '班级',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `students` */

insert  into `students`(`id`,`name`,`sex`,`age`,`class_id`) values (1,'高培东',1,20,1),(2,'徐啸天',1,21,1),(3,'张玉坤',1,22,1),(4,'王胜',1,23,1),(5,'谢锐',2,20,1),(6,'曾哥',2,19,2),(7,'高翼飞',1,20,1),(8,'高艳阳',2,20,1),(9,'唐爽',1,20,1),(10,'李静',2,19,1),(11,'梁芳',2,20,1),(12,'唐文凤',2,20,1),(13,'谢佳玲',1,20,1),(14,'唐爽',1,20,1),(16,'罗川',1,21,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
