# JavaWebProject
从servlet,jsp到struts2.hibernate,spring等相关框架一步一步学习JavaWeb
## 前言  
这里按学习进度跟新自己学习的一些JavaWeb项目。
## -----------jdbc_crud_two:JDBC+Servlet+JSP实现基本的增删改查（简易通讯录）                                                                                                   
### 博客地址：http://blog.csdn.net/qq_34337272/article/details/78551547
### 用到的知识
①JSP以及Servlet的基本知识
②原生JDBC实现数据库的增删改查
③HTML基本知识以及H5最新属性的使用
④Foundation框架的使用。
## -----------pager:两种分页方式（慕课网）
### 1，使用list集合中的sublist()实现分页 
sublist(int fromIndex,int toIndex): 返回此列表中指定的fromIndex（含）和toIndex之间的视图
### 2，使用SQL语句实现分页
利用数据库自带的分页语法，使用分页语句，获取分页数据（例如Mysql数据库使用limit关键字，oracle使用rownum关键字等）
例：学生表(t_student)中查询出前十条数据
Mysql查询语句：select * from t_student limit 0,10
PostgreSQL查询语句：select * from t_student limit 10 fooset 0
Oracle查询语句：
select * from{
select s.*,rownum rn
from (select * from t_student)s
where rownum <=10
}
where rn>=1
## -----------BookStore:JDBC+JSP+Servlet实现的网上书城
## -----------immoc_sh:struts2+hibernate实现的图书管理系统
### 博客地址：http://blog.csdn.net/qq_34337272/article/details/78552111
