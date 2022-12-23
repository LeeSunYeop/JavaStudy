DROP TABLE tbl_member
DROP SEQUENCE seq_board_num
DROP TABLE tbl_board
DROP TABLE tbl_menu

commit


CREATE
TABLE tbl_board(
num NUMBER,
bid VARCHAR2(15) NOT NULL,
title VARCHAR2(45) NOT NULL,
content VARCHAR2(3000) NOT NULL,
pw NUMBER NOT NULL,
writeday DATE DEFAULT SYSDATE,
readcnt NUMBER DEFAULT 0,
repRoot NUMBER,
repStep NUMBER,
repIndent NUMBER,
CONSTRAINT pk_board_num
PRIMARY KEY(num)
)

SELECT * FROM tbl_board a FULL OUTER JOIN tbl_member b ON a.num = b.mid

CREATE TABLE tbl_menu(
uri VARCHAR2(100),
fullpkg VARCHAR2(100) NOT NULL,
CONSTRAINT pk_menu_uri PRIMARY KEY(uri)
);


CREATE SEQUENCE seq_board_num
START WITH 1
INCREMENT BY 1;


INSERT INTO tbl_menu VALUES ('/board/list.do','kr.co.command.Board_ListCommand');
INSERT INTO tbl_menu VALUES ('/board/insertui.do','kr.co.command.Board_InsertUICommand');
INSERT INTO tbl_menu VALUES ('/board/insert.do','kr.co.command.Board_InsertCommand');
INSERT INTO tbl_menu VALUES ('/board/read.do','kr.co.command.Board_ReadCommand');
INSERT INTO tbl_menu VALUES ('/board/updateui.do','kr.co.command.Board_UpdateUICommand');
INSERT INTO tbl_menu VALUES ('/board/update.do','kr.co.command.Board_UpdateCommand');
INSERT INTO tbl_menu VALUES ('/board/delete.do','kr.co.command.Board_DeleteCommand');
INSERT INTO tbl_menu VALUES ('/board/reply.do','kr.co.command.Board_ReplyCommand');
INSERT INTO tbl_menu VALUES ('/board/replyui.do','kr.co.command.Board_ReplyUICommand');
INSERT INTO tbl_menu VALUES ('/board/search.do','kr.co.command.Board_SearchCommand');
INSERT INTO tbl_menu VALUES ('/member/list.do','kr.co.command.Member_ListCommand');
INSERT INTO tbl_menu VALUES ('/member/insertui.do','kr.co.command.Member_InsertUICommand');
INSERT INTO tbl_menu VALUES ('/member/insert.do','kr.co.command.Member_InsertCommand');
INSERT INTO tbl_menu VALUES ('/member/read.do','kr.co.command.Member_ReadCommand');
INSERT INTO tbl_menu VALUES ('/member/updateui.do','kr.co.command.Member_UpdateUICommand');
INSERT INTO tbl_menu VALUES ('/member/update.do','kr.co.command.Member_UpdateCommand');
INSERT INTO tbl_menu VALUES ('/member/delete.do','kr.co.command.Member_DeleteCommand');
INSERT INTO tbl_menu VALUES ('/member/loginui.do','kr.co.command.Member_LoginUICommand');
INSERT INTO tbl_menu VALUES ('/member/login.do','kr.co.command.Member_LoginCommand');
INSERT INTO tbl_menu VALUES ('/member/logout.do','kr.co.command.Member_LogoutCommand');



SELECT * FROM tbl_member





