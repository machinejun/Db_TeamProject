CREATE DATABASE movieInfo;
USE movieInfo;

DROP DATABASE movieInfo;


CREATE TABLE movie (
	title VARCHAR(30) NOT NULL PRIMARY KEY,
    releaseDate DATE NOT NULL,
    starScore FLOAT,
    genre VARCHAR(10),
    image text
);

DROP TABLE score;
DROP TABLE movie;
DROP TABLE releaseYear;
DROP TABLE role;


CREATE TABLE score(
	title VARCHAR(30) NOT NULL PRIMARY KEY,
    audience INT,
    sales DECIMAL(65),
    FOREIGN KEY(title) REFERENCES movie(title)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);

CREATE TABLE role(
	title VARCHAR(30) NOT NULL,
    actorName VARCHAR(20) NOT NULL,
    category CHAR(2),
    roleName VARCHAR(20)
);

ALTER TABLE role ADD PRIMARY KEY (title, actorName);

ALTER TABLE role
	ADD CONSTRAINT
     FOREIGN KEY(title) REFERENCES movie(title)
	ON UPDATE CASCADE
    ON DELETE CASCADE;
  
 /* 
ALTER TABLE role
	ADD CONSTRAINT
	FOREIGN KEY(actorName) REFERENCES actor(actorName)
	ON UPDATE CASCADE
    ON DELETE CASCADE;
*/

CREATE TABLE actor(
	id INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
	actorName VARCHAR(20) NOT NULL,
    birthYear INT NOT NULL,
    height INT NOT NULL,
    weight INT NOT NULL,
    partner VARCHAR(20),
    image text
);

SELECT * FROM movie;
delete from movie;

update movie set image = 'https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20200612_248%2F1591937633750Vvyr6_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2' where title = '부산행';

INSERT INTO movie VALUES ('반지의 제왕', '2001-12-31', 9.84, '판타지', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20210308_290%2F16151786976685f4Mv_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
INSERT INTO movie VALUES ('아이언맨', '2008-04-30', 8.4, '액션', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20111222_37%2F1324501632182vbSoY_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
INSERT INTO movie VALUES ('극한직업', '2019-01-23', 9.2, '코미디', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20190116_206%2F1547615429111dINWj_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
INSERT INTO movie VALUES ('범죄도시', '2017-10-03', 9.28, '액션', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20220420_22%2F16504370785559wHfw_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
INSERT INTO movie VALUES ('토르: 라그나로크', '2017-10-25', 9.03, '액션', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20170928_85%2F1506564710105ua5fS_PNG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
INSERT INTO movie VALUES ('베테랑', '2015-08-05', 9.24, '액션', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20150622_131%2F14349365467550iQnC_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
INSERT INTO movie VALUES ('바람', '2009-11-26', 9.28, '드라마', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20111223_242%2F1324597990008Nj67F_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
INSERT INTO movie VALUES ('히말라야', '2015-12-16', 8.67, '드라마', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20151119_280%2F1447895561914GiahL_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");
INSERT INTO movie VALUES ('부산행', '2016-07-20', 8.6, '액션', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20200612_248%2F1591937633750Vvyr6_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2\n");
INSERT INTO movie VALUES ('어벤져스', '2012-04-26', 8.8, '액션', "https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20120426_172%2F1335428116411i030K_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2");

-- 추가 데이터
INSERT INTO movie VALUES ('82년생 김지영', '2019-10-23', 9.13, '드라마', "82년생 김지영.jpg");
INSERT INTO movie VALUES ('관상', '2013-09-11', 8.02, '드라마', "관상.jpg");
INSERT INTO movie VALUES ('엑시트', '2019-07-31', 8.99, '액션', "엑시트.jpg");
INSERT INTO movie VALUES ('리틀 포레스트', '2018-02-28', 9.01, '드라마', "리틀 포레스트.jpg");
INSERT INTO movie VALUES ('더 킹', '2017.01.18', 8.39, '범죄', "더 킹.jpg");
INSERT INTO movie VALUES ('미녀는 괴로워', '2006-12-14', 8.79, '코미디', "미녀는 괴로워.jpg");
INSERT INTO movie VALUES ('과속스캔들', '2008-12-03', 9.20, '코미디', "과속스캔들.jpg");
INSERT INTO movie VALUES ('신과함께-죄와 벌', '2017-12-20', 8.73, '판타지', "신과함께-죄와 벌.jpg");
INSERT INTO movie VALUES ('라라랜드', '2016-12-07', 8.91, '드라마', "라라랜드.jpg");
INSERT INTO movie VALUES ('크루엘라', '2021.05.26', 9.23, '드라마', "크루엘라.jpg");

SELECT * FROM actor;
INSERT INTO actor VALUES (1, '로버트 다우니 주니어', 1965, 174, 65, '수잔 다우니', '로버트 다우니 주니어.jpg');
INSERT INTO actor VALUES (2, '기네스 팰트로', 1972, 175, 61, NULL, '기네스 팰트로.jpg');
INSERT INTO actor VALUES (3, '테렌스 하워드', 1969, 184, 75, NULL, '테렌스 하워드.jpg');
INSERT INTO actor VALUES (4, '이하늬', 1983, 173, 56, NULL, '이하늬.jpg');
INSERT INTO actor VALUES (5, '류승룡', 1970, 175, 72, NULL, '류승룡.jpg');
INSERT INTO actor VALUES (6, '진선규', 1999, 177, 70, '박보경', '진선규.jpg');
INSERT INTO actor VALUES (7, '이동휘', 1985, 179, 67, NULL, '이동휘.jpg');
INSERT INTO actor VALUES (8, '공명', 1994, 183, 73, NULL, '공명.jpg');
INSERT INTO actor VALUES (9, '일라이저 우드', 1981, 168, 73, NULL, '일라이저 우드.jpg');
INSERT INTO actor VALUES (10, '숀 애스틴', 1971, 170, 67, NULL, '숀 애스틴.jpg');
INSERT INTO actor VALUES (11, '앤디 서키스', 1964, 171, 65, NULL, '앤디 서키스.jpg');
INSERT INTO actor VALUES (12, '마동석', 1971, 178, 100, NULL, '마동석.jpg');
INSERT INTO actor VALUES (14, '윤계상', 1978, 182, 77, '차혜영', '윤계상.jpg');
INSERT INTO actor VALUES (15, '최귀화', 1978, 181, 72, NULL, '최귀화.jpg');
INSERT INTO actor VALUES (16, '조재윤', 1974, 174, 75, '조은애', '조재윤.jpg');
INSERT INTO actor VALUES (17, '유아인', 1986, 179, 71, NULL, '유아인.jpg');
INSERT INTO actor VALUES (18, '황정민', 1999, 180, 75, '김미혜', '황정민.jpg');
INSERT INTO actor VALUES (19, '유해진', 1970, 174, 65, NULL, '유해진.jpg');
INSERT INTO actor VALUES (20, '오달수', 1968, 176, 68, NULL, '오달수.jpg');
INSERT INTO actor VALUES (21, '정우', 1981, 180, 70, '김유미', '정우.jpg');
INSERT INTO actor VALUES (22, '손호준', 1984, 176, 67, NULL, '손호준.jpg');
INSERT INTO actor VALUES (23, '황정음', 1985, 167, 48, NULL, '황정음.jpg');
INSERT INTO actor VALUES (24, '라미란', 1975, 162, 53, '김진구', '라미란.jpg');
INSERT INTO actor VALUES (25, '공유', 1979, 184, 74, NULL, '공유.jpg');
INSERT INTO actor VALUES (26, '정유미', 1983, 163, 43, NULL, '정유미.jpg');
INSERT INTO actor VALUES (27, '최우식', 1990, 181, 65, NULL, '최우식.jpg');
INSERT INTO actor VALUES (28, '크리스 에반스', 1981, 183, 79, NULL, '크리스 에반스.jpg');
INSERT INTO actor VALUES (29, '스칼릿 조핸슨', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');

-- 추가 데이터 (수정 필요!)
INSERT INTO actor VALUES (29, '송강호', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '이정재', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '조정석', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '윤아', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '고두심', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '김태리', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '류준열', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '문소리', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '조인성', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '정우성', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '김아중', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '차태현', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '박보영', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '왕석현', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '하정우', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '김향기', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '엠마 스톤', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '라이언 고슬링', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '마크 스트롱', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');
INSERT INTO actor VALUES (29, '엠마 톰슨', 1984, 160, 57, NULL, '스칼릿 조핸슨.jpg');

SELECT * FROM score;
desc score;
INSERT INTO score VALUES ('아이언맨', 430, 430*10000);
INSERT INTO score VALUES ('반지의 제왕', 700, 700*10000);
INSERT INTO score VALUES ('극한직업', 1620, 1620*10000);
INSERT INTO score VALUES ('범죄도시', 688, 688*10000);
INSERT INTO score VALUES ('토르: 라그나로크', 688, 688*10000);
INSERT INTO score VALUES ('베테랑', 1340, 1340*10000);
INSERT INTO score VALUES ('바람', 10, 10*10000);
INSERT INTO score VALUES ('히말라야', 775, 775*10000);
INSERT INTO score VALUES ('부산행', 1150, 1150*10000);
INSERT INTO score VALUES ('어벤져스', 708, 708*10000);

-- 추가 데이터
INSERT INTO score VALUES ('82년생 김지영', 367, 367*10000);
INSERT INTO score VALUES ('관상', 913, 913*10000);
INSERT INTO score VALUES ('엑시트', 942 , 942*10000);
INSERT INTO score VALUES ('리틀 포레스트', 150, 150*10000);
INSERT INTO score VALUES ('더 킹', 531, 531*10000);
INSERT INTO score VALUES ('미녀는 괴로워', 608, 608*10000);
INSERT INTO score VALUES ('과속스캔들', 822, 822*10000);
INSERT INTO score VALUES ('신과함께-죄와 벌', 1441, 1441*10000);
INSERT INTO score VALUES ('라라랜드', 375, 375*10000);
INSERT INTO score VALUES ('크루엘라', 198, 198*10000);

-- 데이터 추가 필요!
SELECT * FROM role;
INSERT INTO role VALUES ('아이언맨', '로버트 다우니 주니어', '주연', '토니 스타크');
INSERT INTO role VALUES ('아이언맨', '기네스 팰트로우', '주연', '페퍼 포츠');
INSERT INTO role VALUES ('아이언맨', '테렌스 하워드', '조연', '제임스 로드');

INSERT INTO role VALUES ('극한직업', '이하늬', '주연', '장형사');
INSERT INTO role VALUES ('극한직업', '류승룡', '주연', '고반장');
INSERT INTO role VALUES ('극한직업', '진선규', '주연', '마형사');
INSERT INTO role VALUES ('극한직업', '이동휘', '주연', '영호');
INSERT INTO role VALUES ('극한직업', '공명', '주연', '재훈');

INSERT INTO role VALUES ('반지의 제왕', '일라이저 우드', '주연', '프로도');
INSERT INTO role VALUES ('반지의 제왕', '숀 애스틴', '주연', '샘');
INSERT INTO role VALUES ('반지의 제왕', '앤디 서키스', '주연', '골룸');

INSERT INTO role VALUES ('범죄도시', '마동석', '주연', '마석도');
INSERT INTO role VALUES ('범죄도시', '윤계상', '주연', '장첸');
INSERT INTO role VALUES ('범죄도시', '최귀화', '조연', '전반장');
INSERT INTO role VALUES ('범죄도시', '조재윤', '조연', '황사장');

INSERT INTO role VALUES ('토르: 라그나로크', '크리스 헴스워스', '주연', '토르');
INSERT INTO role VALUES ('토르: 라그나로크', '마크 러팔로', '주연','헐크');
INSERT INTO role VALUES ('토르: 라그나로크', '톰 히들스턴', '주연', '로키');

INSERT INTO role VALUES ('베테랑', '유아인', '주연', '조태오');
INSERT INTO role VALUES ('베테랑', '황정민', '주연', '서도철');
INSERT INTO role VALUES ('베테랑', '유해진', '주연', '최상무');
INSERT INTO role VALUES ('베테랑', '오달수', '조연', '오팀장');
INSERT INTO role VALUES ('베테랑', '이동휘', '조연', '윤홍렬');

INSERT INTO role VALUES ('바람', '정우', '주연', '짱구');
INSERT INTO role VALUES ('바람', '황정음', '주연', '주희');
INSERT INTO role VALUES ('바람', '손호준', '주연', '김영주');

INSERT INTO role VALUES ('히말라야', '정우', '주연', '박무택');
INSERT INTO role VALUES ('히말라야', '황정민', '주연', '엄홍길');
INSERT INTO role VALUES ('히말라야', '라미란', '조연', '조명애');
INSERT INTO role VALUES ('히말라야', '정유미', '조연', '최수영');

INSERT INTO role VALUES ('부산행', '마동석', '주연', '상화');
INSERT INTO role VALUES ('부산행', '공유', '주연', '석우');
INSERT INTO role VALUES ('부산행', '정유미', '주연', '성경');
INSERT INTO role VALUES ('부산행', '최우식', '주연', '영국');

INSERT INTO role VALUES ('어벤져스', '로버트 다우니 주니어', '주연', '토니 스타크');
INSERT INTO role VALUES ('어벤져스', '크리스 헴스워스', '주연', '토르');
INSERT INTO role VALUES ('어벤져스', '마크 러팔로', '주연', '헐크');
INSERT INTO role VALUES ('어벤져스', '크리스 에반스', '주연', '캡틴 아메리카');
INSERT INTO role VALUES ('어벤져스', '스칼릿 조핸슨', '주연', '나타샤 로마노프');
INSERT INTO role VALUES ('어벤져스', '기네스 팰트로우', '조연', '페퍼 포츠');
INSERT INTO role VALUES ('어벤져스', '톰 히들스턴', '주연', '로키');

UPDATE actor SET actorName = '현빈' WHERE actorName = '마동석';

UPDATE movie SET title = '반지의 제왕' WHERE title = '반지의 제왕2';

DELETE FROM actor WHERE actorName = '황정민';

UPDATE role SET actorName = NULL WHERE actorName = '황정민';

SELECT *
FROM actor a
INNER JOIN role r
ON a.actorName = r.actorName;

SELECT *
FROM actor a
LEFT OUTER JOIN role r
ON a.actorName = r.actorName;

SELECT *
FROM score s
LEFT JOIN movie m
ON s.title = m.title
INNER JOIN role r
ON m.title = r.title;

/*
배우이름 검색
- 출연 영화 목록, 배우정보 출력

영화 목록 출력
- 최신영화 기준

영화명 검색 
*/

-- 배우 이름 검색 -> 출연 영화명 + 배우 정보 출력
SELECT a.*, r.title
FROM actor a
INNER JOIN role r
ON a.actorName = r.actorName
WHERE a.actorName = '황정민';

-- 배우 이름 검색 -> 출연 영화명 + 배우 정보 출력
SELECT *
FROM actor a LEFT JOIN role r
ON a.actorName = r.actorName
UNION DISTINCT
SELECT *
FROM actor a RIGHT JOIN role r
ON a.actorName = r.actorName;


-- 영화 최신순 출력
SELECT *
FROM movie
ORDER BY releaseDate DESC;

-- 영화명 검색 -> 영화 정보 출력(영화 정보 + 배역 정보)
SELECT *, r.roleName
FROM movie m
INNER JOIN role r
ON m.title = r.title
INNER JOIN score s
ON m.title = s.title
WHERE m.title = '아이언맨';

SELECT *
FROM actor a
INNER JOIN role r
ON a.actorName = r.actorName
WHERE a.actorName = '마동석';

SELECT *
FROM movie;

SELECT *
FROM actor
WHERE actorName = '황정민';

INSERT INTO movie VALUES ('어벤져스', '2012-04-26', 8.8, '액션', "어벤져스.jpg");

UPDATE movie SET sales = '8.5' WHERE title = '아이언맨';

SELECT *
FROM actor a
INNER JOIN role r
ON a.actorName = r.actorName
WHERE a.actorName ='마동석';