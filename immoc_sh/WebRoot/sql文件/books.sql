/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.19-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `books` (
	`sid` varchar (24),
	`sname` varchar (765),
	`loandate` date ,
	`total` varchar (765)
); 
insert into `books` (`sid`, `sname`, `loandate`, `total`) values('B0000001','小鬼当家','2017-11-15','7');
insert into `books` (`sid`, `sname`, `loandate`, `total`) values('B0000002','小鬼当家','2017-11-03','11');
insert into `books` (`sid`, `sname`, `loandate`, `total`) values('B0000003','小鬼当家','2017-11-03','11');
insert into `books` (`sid`, `sname`, `loandate`, `total`) values('B0000004','小鬼当家','2017-11-03','32');
insert into `books` (`sid`, `sname`, `loandate`, `total`) values('B0000005','小鬼当家','2017-11-03','32');
