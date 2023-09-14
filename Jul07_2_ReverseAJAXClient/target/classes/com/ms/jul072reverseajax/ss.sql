create table jul07_coffee(
c_name varchar2(10 char)primary key,
c_price number(5) not null

);
insert into jul07_coffee values('아아',1000);
insert into jul07_coffee values('뜨아',1000);
insert into jul07_coffee values('미아',1000);
insert into jul07_coffee values('라떼',1000);
insert into jul07_coffee values('뜨라떼',1000);
insert into jul07_coffee values('차라떼',1000);

select *from jul07_coffee;

coffee.get->json:spring

Node.js+OracleDB 설정이 너무 복잡

Node.js+MongoDB는 설정하기 좋았는데