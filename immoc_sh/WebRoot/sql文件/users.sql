/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.19-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `users` (
	`uid` int (11),
	`username` varchar (765),
	`password` varchar (765)
); 
insert into `users` (`uid`, `username`, `password`) values('1','123456','123456');
