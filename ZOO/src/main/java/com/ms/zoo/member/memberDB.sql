create table zoo_member(
zm_id varchar2(10 char)primary key,
zm_pw varchar2(10 char)not null,
zm_name varchar2(10 char)not null,
zm_birthday date not null,
zm_addr varchar2(200 char)not null,
zm_photo varchar2(100 char)not null

);

select *from zoo_member;

delete from ZOO_MEMBER where zm_id='dlwnsgk';




--날짜 역순 ,1~5번까지 글
select*from(
select rownum as rn,zs_no,zs_writer,zs_txt,zs_date,zs_color
from(
select *
from zoo_sns
where zs_writer like '%%' or zs_txt like '%%'
order by zs_date desc
)
)
where rn>=1 and rn<=5;
--날짜역순,1~5번까지 글을 쓴 사람
select zm_id,zm_photo
from ZOO_MEMBER
where zm_id in (
select zs_writer from(
select rownum as rn,zs_writer
from(
select zs_writer
from zoo_sns
where zs_writer like '%%' or zs_txt like '%%'
order by zs_date desc
)
)
where rn>=1 and rn<=5
);
--join
select zs_no,zs_writer,zs_txt,zs_date,zs_color,zm_photo
from(
select*from(
select rownum as rn,zs_no,zs_writer,zs_txt,zs_date,zs_color
from(
select *
from zoo_sns
where zs_writer like '%'||#{search}||'%' or zs_txt like '%'||#{search}||'%'
order by zs_date desc
)
)
where rn &gt;=#{start} and rn %lt;=#{end}
),(
select zm_id,zm_photo
from ZOO_MEMBER
where zm_id in (
select zs_writer from(
select rownum as rn,zs_writer
from(
select zs_writer
from zoo_sns
where zs_writer like '%'||#{search}||'%' or zs_txt like '%'||#{search}||'%'
order by zs_date desc
)
)
where rn &gt;=#{start} and rn %lt;=#{end}
)
)
where zs_writer=zm_id
order by zs_date desc;



--------------------------------------------------------
create table zoo_sns(
zs_no number(4)primary key,
zs_writer varchar2(10 char)not null,
zs_txt varchar2(500char)not null,
zs_date date not null,
zs_color char(6 char)not null, --색깔 나중에 AI로 추천
constraint zoo_sns_writer
foreign key (zs_writer) references zoo_member (zm_id) 
on delete cascade

);
drop table zoo_sns;
create sequence zoo_sns_seq;
select*from zoo_sns;

select*from zoo_sns,zoo_member where zs_writer=zm_id order by zs_date desc;
------------------------------------
--빅데이터:1000만개
--64번의 데이터를 수정?삭제?
--애초에 데이터 수집용이기에 수정 삭제할일이 없기에 primary key는 의미X
create table zoo_weather_color(
zwc_temp number(5,2)not null,
zwc_humidity number(4,2)not null,
zwc_description varchar2(20 char)not null,
zwc_color char(6 char)not null
);
drop table zoo_weather_color;
select*from zoo_weather_color;


----------------------------
create table zoo_sns_reply(
zsr_no number(4)primary key,
zsr_zs_no number(4)not null,
zsr_writer varchar2(10 char)not null,
zsr_txt varchar2(500 char)not null,
zsr_date date not null,
constraint sns2_reply_writer
foreign key (zsr_writer) references zoo_member(zm_id)
on delete cascade,
constraint sns2_reply
foreign key(zsr_zs_no)references zoo_sns(zs_no)
on delete cascade
);
create sequence zoo_sns_reply_seq;

insert into zoo_sns_reply values(zoo_sns_reply_seq.nextval,#{zsr_zs_no},#{zsr_writer},#{zsr_txt},sysdate)

select * from zoo_sns_reply;


---------------------------------------
create table zoo_dataroom(
zd_no number(3) primary key,
zd_uploader varchar2(10 char)not null,
zd_title varchar2(300 char)not null,
zd_file varchar2(100 char) not null,

zd_category varchar2 (6 char)not null,
zd_date date not null,
constraint dataroom_uploader
foreign key (zd_uploader) references zoo_member(zm_id)
on delete cascade
);
drop table zoo_dataroom;

create sequence zoo_dataroom_seq;







select * from zoo_dataroom where zd_uploader=#{zm_id} order by zd_date desc; 
----------------------------------------------------------------------------------------
create table zoo_gallery(
zg_no number(3) primary key,
zg_uploader varchar2(10 char)not null,
zg_title varchar2 (300 char)not null,
zg_photo varchar2(100 char)not null,
zg_date date not null,
constraint gallery_uploader
foreign key (zg_uploader) references zoo_member(zm_id)
on delete cascade

);
create sequence zoo_gallery_seq;


drop table zoo_gallery;
select*from zoo_gallery;
select*from zoo_gallery order by zg_date desc;

















