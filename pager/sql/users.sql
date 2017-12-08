/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.7.19-log 
*********************************************************************
*/
/*!40101 SET NAMES utf8 */;

create table `t_student` (
	`id` int (11),
	`stu_name` varchar (48),
	`gender` int (11),
	`age` int (11),
	`address` varchar (384)
); 
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('1','王小军','1','17','北京市东城区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('2','李雷雷','1','16','北京市朝阳区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('3','张静','2','16','北京市昌平区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('4','王晓萌','2','17','北京市顺义区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('5','韩梅梅','2','16','北京市朝阳区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('6','李小军','1','17','北京市海淀区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('7','成龙','1','16','北京市石景山区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('8','李海飞','2','16','北京市海淀区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('9','罗红','2','16','北京市朝阳区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('10','孙海杰','1','16','北京市石景山区');
insert into `t_student` (`id`, `stu_name`, `gender`, `age`, `address`) values('11','王海龙','1','16','北京市东城区');
