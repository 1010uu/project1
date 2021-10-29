CREATE TABLE phonebook_tb
(
    idx number(10) NOT NULL,
	name VARCHAR2(50) NOT NULL,
	phone_number VARCHAR2(80) NOT NULL,
	birthday VARCHAR2(80) NOT NULL,
	PRIMARY KEY (idx)
);

--필요할 때 사용하자
desc phonebook_tb;
drop table phonebook_tb;
select * from phonebook_tb;

create sequence seq_phonebook
    increment by 1
    start with 1
    minvalue 1
    nomaxvalue
    nocycle
    nocache;

--커밋과 롤백
commit;
rollback;