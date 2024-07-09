--학생정보(학생번호, 이름, 연락처, 주소, 생년월일)
--tbl_student 테이블명.
create table tbl_student(
    student_no VARCHAR2(10) primary key,
    student_name VARCHAR2(100) not null,
    student_phone VARCHAR2(20),
    address VARCHAR2(100),
    birth_date date,
    creation_date date DEFAULT sysdate
);

INSERT into tbl_student (student_no, student_name, student_phone)
values ('s2015-01', '이우상', '010-1234-5678');

INSERT into tbl_student (student_no, student_name, student_phone, address)
values ('s2019-04', '이민정', '010-5559-2226', '대구');

select *
from tbl_student;

update tbl_student
set address = '일본'
where student_name = '이우상';

select *
from tbl_student;

update tbl_student
set birth_date = '19961129'
where student_no = 's2015-01';

commit;

INSERT into tbl_student (student_no, student_name, student_phone, address)
values ('s2016-04', '김정민', '010-5779-2126', '서울');

commit;

ROLLBACK;

INSERT into tbl_student (student_no, student_name, student_phone, address, birth_date)
values ('s2020-04', '박창민', '010-6679-2236', '부산', '1999/11/10');

update tbl_student
set birth_date = TO_DATE('1993-07-18', 'YYYY/MM/DD')
where student_name = '박창민';

select student_name
from tbl_student
where student_name = '이우상';


--부분수정
--update tbl_student
--set student_name = nvl(null, student_name),
--    student_phone = nvl(null, student_phone),
--    address = nvl(null, address),
--    birth_date = nvl(null, birth_date)
--where student_no = '20202020';
    

--수정기능

select * from tbl_student order by student_no;