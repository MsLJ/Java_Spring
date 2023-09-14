create table jun19_menu_ms(
m_name varchar2(100 char)primary key,
m_price number(5)not null

);
drop table jun19_menu_ms;

insert into jun19_menu_ms values('소고기',13000);
insert into jun19_menu_ms values('양고기',15000);
select * from jun19_menu_ms;