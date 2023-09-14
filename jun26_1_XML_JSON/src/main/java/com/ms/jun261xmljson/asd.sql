create table jun26_biskit(
b_name varchar2(50 char) primary key,
b_price number(5)not null
);
insert into jun26_biskit values('감자',5000);
insert into jun26_biskit values('감',5000);
insert into jun26_biskit values('자',5000);
insert into jun26_biskit values('감자자',5000);
insert into jun26_biskit values('감자자자',5000);
insert into jun26_biskit values('감자자자자',5000);
insert into jun26_biskit values('감자자자자자',5000);
insert into jun26_biskit values('감자자자자자자자',5000);
insert into jun26_biskit values('감자자자자자자자자자',5000);

create table jun27_menu(
m_name varchar2(100 char)primary key,
m_price number(6)not null



);
insert into jun27_menu values('김치볶',10000);
insert into jun27_menu values('김치',10000);
insert into jun27_menu values('김치볶음',10000);
insert into jun27_menu values('김치볶밥',10000);
insert into jun27_menu values('김치볶기',10000);
insert into jun27_menu values('김볶기',10000);
insert into jun27_menu values('치볶기',10000);
insert into jun27_menu values('김치기',10000);
insert into jun27_menu values('치기',10000);
insert into jun27_menu values('감자치기',10000);
insert into jun27_menu values('기',100);
select * from jun27_menu;


select*from(
select rownum as rn m_name,m_price from(
select m_name,m_price from jun27_menu
where m_price=m_price
)
) 
where rn>=1 and rn<=2

SELECT * FROM (
SELECT ROWNUM AS rn, m_name, m_price FROM (
SELECT m_name, m_price FROM jun27_menu
WHERE m_price = m_price
)
)
WHERE rn <= #{page}



