-- ======================================
-- 관리자 계정
-- ======================================
-- student 계정 생성 및 권한 부여
create user student
identified by student
default tablespace users;

grant connect, resource to student;

-- ======================================
-- STUDENT 계정
-- ======================================
create table member(
    member_id varchar2(20),
    password varchar2(20) not null,
    member_name varchar2(100) not null,
    gender char(1),
    age number,
    email varchar2(200),
    phone char(11) not null,
    address varchar2(1000),
    hobby varchar2(100), -- 농구, 음악감상, 영화
    enroll_date date default sysdate,
    constraint pk_member_id primary key(member_id),
    constraint ck_member_gender check(gender in ('M', 'F'))
);

insert into member
values(
    'honggd', '1234', '홍길동', 'M', 33, 'honggd@naver.com', '01012345678',
    '서울 강남구 테헤란로', '등산, 그림, 요리', default
);

insert into member
values(
    'simpson', '0406', '심슨', 'M', 30, '450054@naver.com', '01045554555',
    '서울 강동구 성내동', '코딩, 게임, 헬스', default
);

insert into member
values(
    'honghong', '0811', '홍홍', 'M', 26, 'hong@naver.com', '01032413241',
    '서울 강동구 성내2동', '코딩, 공부, 헬스', default
);

insert into member
values(
    'jungnyun', '1102', '정년', 'F', 23, '9955@naver.com', '01099889988',
    '서울 강동구 성내3동', '코딩, 헬스, 영화', default
);

insert into member
values(
    'black', '0815', '깜', 'F', null, 'null', '01099889988',
    'null', 'null', default
);

select * from member;


