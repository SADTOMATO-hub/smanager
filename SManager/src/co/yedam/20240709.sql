--�л�����(�л���ȣ, �̸�, ����ó, �ּ�, �������)
--tbl_student ���̺��.
create table tbl_student(
    student_no VARCHAR2(10) primary key,
    student_name VARCHAR2(100) not null,
    student_phone VARCHAR2(20),
    address VARCHAR2(100),
    birth_date date,
    creation_date date DEFAULT sysdate
);

INSERT into tbl_student (student_no, student_name, student_phone)
values ('s2015-01', '�̿��', '010-1234-5678');

INSERT into tbl_student (student_no, student_name, student_phone, address)
values ('s2019-04', '�̹���', '010-5559-2226', '�뱸');

select *
from tbl_student;

update tbl_student
set address = '�Ϻ�'
where student_name = '�̿��';

select *
from tbl_student;

update tbl_student
set birth_date = '19961129'
where student_no = 's2015-01';

commit;

INSERT into tbl_student (student_no, student_name, student_phone, address)
values ('s2016-04', '������', '010-5779-2126', '����');

commit;

ROLLBACK;

INSERT into tbl_student (student_no, student_name, student_phone, address, birth_date)
values ('s2020-04', '��â��', '010-6679-2236', '�λ�', '1999/11/10');

update tbl_student
set birth_date = TO_DATE('1993-07-18', 'YYYY/MM/DD')
where student_name = '��â��';

select student_name
from tbl_student
where student_name = '�̿��';


--�κм���
--update tbl_student
--set student_name = nvl(null, student_name),
--    student_phone = nvl(null, student_phone),
--    address = nvl(null, address),
--    birth_date = nvl(null, birth_date)
--where student_no = '20202020';
    

--�������

select * from tbl_student order by student_no;