/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.19-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `students` (
	`sid` varchar (24),
	`sname` varchar (765),
	`gender` varchar (765),
	`birthday` date ,
	`address` varchar (765)
); 
insert into `students` (`sid`, `sname`, `gender`, `birthday`, `address`) values('S0000001','孙悟空','1233252524','2017-11-03','B0000001');
insert into `students` (`sid`, `sname`, `gender`, `birthday`, `address`) values('S0000002','孙悟天','','2017-11-03','B0000002');
insert into `students` (`sid`, `sname`, `gender`, `birthday`, `address`) values('S0000003','小鬼当家','','2017-11-16','B0000002');
