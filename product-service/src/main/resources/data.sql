create table product(
product_id int primary key auto_increment,
product_name varchar(100) not null,
description varchar(255) not null,
price decimal(10,2) not null
);

insert into product(product_name, description, price) values('iPhone15', 'The latest iPhone from Apple', 80000);
insert into product(product_name, description, price) values('SamsungS23', 'The latest Samsung Galaxy', 70000);
insert into product(product_name, description, price) values('OnePlus12', 'The latest OnePlus phone', 60000);
insert into product(product_name, description, price) values('Xiaomi11', 'The latest Xiaomi phone', 50000);