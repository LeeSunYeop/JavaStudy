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

select * from tbl_member