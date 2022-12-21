CREATE TABLE tbl_member(
id NUMBER,
password VARCHAR(50) NOT NULL,
passwordcheck VARCHAR(50) NOT NULL,
name VARCHAR(50) NOT NULL,
age NUMBER(3),
CONSTRAINT pk_member_id PRIMARY KEY(id)
)