create table master_theme
(
    THEME_ID int not null comment '테마 ID',
    THEME_SN int not null comment '테마 내 색 순번',
    COLOR_HEX char(7) not null comment '색 코드',
    STATUS char default '1' null comment '사용여부(0: 미사용, 1: 사용)',
    CREATE_DATE datetime default current_timestamp() null,
    UPDATE_DATE datetime null,
    primary key (THEME_ID, THEME_SN)
)
    comment '마스터 테마 정보';

create table page_info
(
    PAGE_ID int auto_increment comment '페이지 번호'
        primary key,
    USER_ID varchar(100) not null comment '유저 ID
',
    PAGE_URL varchar(300) not null comment '페이지 URL',
    STATUS char default '1' null comment '사용상태(0: 미사용, 1: 사용)',
    CREATE_DATE datetime default current_timestamp() null,
    UPDATE_DATE datetime null
);

create index page_info_USER_ID_index
	on page_info (USER_ID);

create table theme_info
(
    THEME_ID int not null comment '테마 ID',
    THEME_SN int not null comment '테마 내 색 순번',
    COLOR_HEX char(7) not null comment '색 코드',
    STATUS char default '1' null comment '사용여부(0: 미사용, 1: 사용)',
    CREATE_DATE datetime default current_timestamp() null,
    UPDATE_DATE datetime null,
    primary key (THEME_ID, THEME_SN),
    constraint check_theme_sn
        check (0 < `THEME_SN` < 6)
)
    comment '테마 정보';

create table user
(
    USER_ID varchar(100) not null comment '유저 ID'
        primary key,
    PW varchar(200) not null comment '비밀번호',
    USER_INFO varchar(100) null comment '기타 유저 정보(이메일, 주소 등 개인 정보 + 선택 정보 등)',
    CREATE_DATE datetime default current_timestamp() null comment '가입일(생성일)',
    UPDATE_DATE datetime null,
    STATUS char default '0' null comment '회원상태( 0: 정상회원. 1: 휴면회원, 2: 탈퇴회원)'
);

create index user_USER_ID_PW_index
	on user (USER_ID, PW);

create table user_highlight
(
    HIGHLIGHT_ID int auto_increment comment '하이라이트 ID
'
        primary key,
    USER_ID varchar(100) not null comment '유저 ID
',
    PAGE_ID int not null comment '페이지 ID
',
    THEME_SN int not null comment '테마 색 순번',
    TEXT text null comment '최대 크기 6,000 자(한글 기준)',
    STATUS char default '1' null comment '상태(0: 미사용, 1: 사용)',
    CREATE_DATE datetime default current_timestamp() null,
    UPDATE_DATE datetime null
)
    comment '유저 하이라이트 ';

create index user_highlight_USER_ID_index
	on user_highlight (USER_ID);

create table user_theme
(
    USER_ID varchar(100) not null,
    THEME_ID int auto_increment
        primary key,
    STATUS char default '1' null comment '사용여부(0:미사용, 1:사용, 2:삭제)',
    CREATE_DATE datetime default current_timestamp() null,
    UPDATE_DATE datetime null
);

create index user_theme_USER_ID_index
	on user_theme (USER_ID);

