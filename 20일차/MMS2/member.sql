SELECT * FROM tbl_member 
SELECT name, id, age FROM tbl_member

INSERT INTO tbl_member VALUES (6, '신돌석', 49)

UPDATE tbl_member SET age = 100 WHERE id = 1

부모테이블 생성

CREATE TABLE tbl_dep1(
did NUMBER,
dname VARCHAR2(36),
CONSTRAINT pk_dep1_did PRIMARY KEY(did)
)

INSERT INTO tbl_dep1 (did, dname) VALUES (1, '인사팀')
INSERT INTO tbl_dep1 (did, dname) VALUES (2, '영업팀')

COMMIT

SELECT * FROM tbl_dep1

자식 테이블 생성 & 외래 설정

CREATE TABLE tbl_emp(
eid NUMBER,
ename VARCHAR2(15),
did NUMBER
)

ALTER TABLE tbl_emp ADD CONSTRAINT fk_emp_did FOREIGN KEY(did) REFERENCES tbl_dep1(did)

INSERT INTO tbl_emp (eid, ename, did) VALUES (1, '홍길동', 10)
DELETE FROM tbl_emp
INSERT INTO tbl_emp (eid, ename, did) VALUES (2, '김유신', 1)
INSERT INTO tbl_emp (eid, ename, did) VALUES (3, '이순신', 1)
INSERT INTO tbl_emp (eid, ename, did) VALUES (4, '박민영', 2)
INSERT INTO tbl_emp (eid, ename, did) VALUES (5, '최민용', NULL)

SELECT * FROM tbl_emp

DELETE FROM tbl_dep1 WHERE did = 1 
지우려고 했는데 자식테이블에서 사용하고 있어서 지울 수 없다고 에러메시지가 뜸

UPDATE tbl_emp SET did = NULL WHERE eid = 4
DELETE FROM tbl_dep1 WHERE did = 2 
SELECT * FROM tbl_dep1
결과를 보면 영업팀이 삭제 될걸 볼수 있다.

제약조건 삭제하기
ALTER TABLE tbl_emp DROP CONSTRAINT fk_emp_did

한꺼번에 삭제하기
부모테이블의 특정 기본키 값이 삭제되면, 그 값을 참조하는 자식 테이블의 레코드도 삭제된다.
ALTER TABLE tbl_emp ADD CONSTRAINT fk_emp_did FOREIGN KEY(did) 
REFERENCES tbl_dep1(did) ON DELETE CASCADE 

DELETE FROM tbl_dep1 WHERE did = 1
SELECT * FROM tbl_dep1
SELECT * FROM tbl_emp

ALTER TABLE tbl_emp ADD CONSTRAINT fk_emp_did FOREIGN KEY(did) 
REFERENCES tbl_dep1(did) ON DELETE CASCADE SET NULL
1이라는 did 키가 삭제되면서 null 값이 대신 들어간다.

트랜잭션 학습
1. 트랜잭션 학습을 위해서 dep1 테이블의 외래키 제약조건을 삭제하세요
ALTER TABLE tbl_emp DROP CONSTRAINT fk_emp_did

2. dep1에 데이터를 입력합니다.
INSERT INTO tbl_dep1 (did, dname) VALUES (1, '인사팀')
INSERT INTO tbl_dep1 (did, dname) VALUES (2, '영업팀')

3. emp에 데이터를 추가합니다.
INSERT INTO tbl_emp (eid, ename, did) VALUES (2, '김유신', 1)
INSERT INTO tbl_emp (eid, ename, did) VALUES (3, '이순신', 2)

4. dep1과 emp 조회
SELECT * FROM tbl_dep1
SELECT * FROM tbl_emp

5. emp 테이블에 외래키 제약조건을 설정할 겁니다. 그런데 ON DELETE ~ 옵션을 안 넣습니다.
ALTER TABLE tbl_emp ADD CONSTRAINT fk_emp_did FOREIGN KEY(did) REFERENCES tb1_dep1(did)

6. dep1 테이블의 인사팀 레코드를 삭제할 겁니다. 삭제가 될까요?, 안 될까요? 참조무결성제약조건 위반으로 삭제가 안 됨.
DELETE FROM tbl_dep1 WHERE did = 1

7. emp 테이블의 레코드 중에서 did 값이 1인 레코드를 찾아서 해당 레코드를 삭제함. 그런 후에 dep1 테이블의 인사팀 레코드를 삭제함.
   이것은 여기에서 하지 않습니다. cmd창에서 합니다. 왜냐하면 이클립스의 db 작업 화면은 auto commit이기 때문이다..

8. 트랜잭션 학습이 끝났으니 dep1 테이블의 외래키 제약조건을 삭제하고