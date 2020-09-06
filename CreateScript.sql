Create Database bank_dispatch_system;
Use bank_dispatch_system;

Create Table user(
    Cno int Primary Key,
    Cname varchar(20) Not null,
    Password varchar(20) Not null,
    Type varchar(20) Not null,
    Amount int Not null,
    Card varchar(20) Not null,
    IDno varchar(20) Not null,
    Pno varchar(20) Not null
);

Create Table admin(
    Ano int Primary Key,
    Aname varchar(20) Not null,
    Password varchar(20) Not null,
    Sex varchar(20) Not null
);

Create Table Person(
    Qno varchar(5) Primary Key,
    Cno int,
    Userid int,
    type varchar(20),
    businessType varchar(20)
);

CREATE TABLE windows (
  window1 varchar(10) NOT NULL,
  window2 varchar(10) DEFAULT NULL,
  window3 varchar(10) DEFAULT NULL,
  PRIMARY KEY (window1)
);

insert into windows(window1,window2,window3) values('个人业务','对公业务','特殊业务');

insert into admin(Ano,Aname,Password,Sex) values('1','张三','123','男');

insert into admin(Ano,Aname,Password,Sex) values('2','李四','123','男');

insert into user(Cno,Cname,Password,Type,Amount,Card,IDno,Pno) values(123456,'root','root','vip',99999,'123456789123','123456','123456');

insert into user(Cno,Cname,Password,Type,Amount,Card,IDno,Pno) values(1234567,'admin','admin','common',99,'123456789','123456','123456');

