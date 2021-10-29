CREATE TABLE test_tb
(
    idx number(10) NOT NULL,
	name VARCHAR2(50) NOT NULL,
	phone_number VARCHAR2(80) NOT NULL,
	birthday VARCHAR2(80) NOT NULL,
	PRIMARY KEY (idx)
);
desc test_tb;
drop table test_tb;
select * from test_tb;

create sequence seq_serial_num
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;
    
    
insert into test_tb values(seq_serial_num.nextval, '¹ÚÀ¯¹Ì', '1234567', '940210');

commit;