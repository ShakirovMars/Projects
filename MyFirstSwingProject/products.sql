CREATE TABLE products(
id int identity(1,1) not null CONSTRAINT pk_products primary key,
name  varchar(15) not null ,
proizvoditeli varchar(15) not null,
ves int not null,
category varchar(15) not null);
