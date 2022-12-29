CREATE TABLE tbl_board(
bno NUMBER,
title VARCHAR2(45) NOT NULL,
content VARCHAR2(3000) NOT NULL,
pw VARCHAR2(60) NOT NULL,
id VARCHAR2(6),
readcnt NUMBER DEFAULT 0,
regdate DATE DEFAULT SYSDATE,
updatedate DATE DEFAULT SYSDATE,
CONSTRAINT pk_board_bno PRIMARY KEY(bno),
CONSTRAINT fk_board_id FOREIGN KEY(id) REFERENCES tbl_member(id)
ON DELETE CASCADE
)

ALTER TABLE tbl_board ADD pw VARCHAR2(60) NOT NULL

SELECT MAX(bno) FROM tbl_board

bno를 자동으로 입력...
sequence, MAX(bno)+1
SELECT NVL2(MAX(bno), MAX(bno)+1, 1) FROM tbl_board
max bno가 null이냐 null이 아니면 +1 을 한다

select * from tbl_board



CREATE TABLE tbl_member(
id VARCHAR2(6),
name VARCHAR2(15) NOT NULL,
birth DATE NOT NULL,
address VARCHAR2(300) NOT NULL,
pw VARCHAR2(300) NOT NULL,
email VARCHAR2(300),
grade CHAR(1) DEFAULT 'A',
CONSTRAINT pk_member_id PRIMARY KEY(id)
)

ALTER TABLE tbl_member ADD regdate DATE DEFAULT SYSDATE
ALTER TABLE tbl_member ADD updatedate DATE DEFAULT SYSDATE




select * from tbl_member