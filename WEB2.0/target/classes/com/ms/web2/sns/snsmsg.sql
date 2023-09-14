
select *from (
select rownum as rn , sns_no,sns_writer, sns_txt,sns_date,webm_photo
from(
SELECT sns_no, sns_writer, sns_txt, sns_date, webm_photo
		FROM sns,web2_member where sns_writer = webm_id
		ORDER BY sns_date DESC

)
)
where rn>=2 and rn<=4


--데이터를 .csv에 저장했는데
--주말반이 지우면?
-->
--DB:보안성높고 저장공간이 넓음


--CPU
--RAM
--HDD -1TB*n

--변수 : 데이터 RAM 임시저장

--join: HDD에 있던 데이터
--		멤버 테이블에 100개 
--		글 테이블에 100개
--		=>100*100개로 만들어서 RAM에 저장
--		나중에 데이터가 커지면 RAM이 터질것 


--1~5번 글
select*from(
select rownum as rn ,sns_no, sns_txt, sns_date
from(
select sns_no,sns_txt, sns_date
from sns
where sns_txt like '%%'
order by sns_date desc
)
)
where rn>=1 and rn<=5;
--1~5번 글 쓴 멤버의 아이디 ,프사




select webm_id,webm_photo
from web2_member 
where webm_id in(
select sns_writer
from(
select rownum as rn ,sns_no ,sns_txt,sns_date
from(
select *
from sns where sns_txt like '%%'
order by sns_date desc

)
)
where rn>=1and rn<=5
) 





select sns_no, webm_id, webm_photo, sns_txt, sns_date 

							from( 

							select * 

								from ( 

										select rownum as rn, sns_no,sns_txt,sns_date,sns_writer 

										from( 

										select *

											from sns 

											where sns_txt like '%'||?||'%' 

											order by sns_date desc 

										) 

					

								)where rn >= ? and rn<= ? 

							),

							(

							select webm_id, webm_photo 

								from web2_member 

							where webm_id in( 

										select sns_writer 

									from ( 

										select rownum as rn, sns_no,sns_txt,sns_date, sns_writer 

											from( 

												select * 

											from sns 

												where sns_txt like '%'||?||'%' 

												order by sns_date desc 

												) 

										) 

									where rn >= ? and rn<= ? 

								) ) 

					where sns_writer = webm_id 

					 order by sns_date desc






