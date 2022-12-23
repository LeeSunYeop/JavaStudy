SELECT * FROM tbl_test121

CREATE TABLE tbl_memberlogin(
mid NUMBER,
password VARCHAR(50) NOT NULL,
name VARCHAR(50) NOT NULL,
age NUMBER(3),
CONSTRAINT pk_member_mid PRIMARY KEY(mid)
)