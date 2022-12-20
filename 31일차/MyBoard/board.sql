SELECT COUNT(num) FROM tbl_board WHERE title LIKE '%kim%'

SELECT * FROM
(SELECT rownum rnum, num, author, title, TO_CHAR(writeday, 'yyyy-mm-dd') writeday, readcnt, repIndent FROM
(SELECT * FROM tbl_board WHERE title LIKE '%kim%' ORDER BY repRoot DESC, repStep ASC))
WHERE rnum BETWEEN 1 AND 10

SELECT * FROM tbl_board ORDER BY repRoot DESC, repStep ASC

SELECT * FROM
(SELECT rownum rnum, num, author, title, To_CHAR(writeday, 'yyyy-mm-dd') writeday, readcnt, repIndent
FROM 
(SELECT * FROM tbl_board ORDER BY repRoot DESC, repStep ASC))
WHERE 
rnum BETWEEN 21 AND 30


ALTER TABLE tbl_board DROP CONSTRAINT pk_board_num
DROP TABLE tbl_board

delete from tbl_board
commit


CREATE SEQUENCE seq_board_num
START WITH 100
INCREMENT BY 1;

CREATE TABLE tbl_board(
num NUMBER,
author VARCHAR2(15) NOT NULL,
title VARCHAR2(45) NOT NULL,
content VARCHAR2(3000) NOT NULL,
pw NUMBER NOT NULL,
writeday DATE DEFAULT SYSDATE,
readcnt NUMBER DEFAULT 0,

repRoot NUMBER,
repStop NUMBER,
repIndent NUMBER,
repStep NUMBER,
CONSTRAINT pk_board_num PRIMARY KEY(num)
)
