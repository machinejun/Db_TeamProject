CREATE DATABASE movieInfo;
USE movieInfo;

DROP DATABASE movieInfo;


CREATE TABLE movie (
	title VARCHAR(30) NOT NULL PRIMARY KEY,
    releaseDate DATE NOT NULL,
    starScore FLOAT,
    genre VARCHAR(10),
    image TEXT
);

DROP TABLE score;
DROP TABLE movie;
DROP TABLE actor;
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
    image TEXT
);

SELECT * FROM movie;
DELETE FROM movie;

UPDATE movie SET image = 'https://search.pstatic.net/common?type=o&size=174x242&quality=85&direct=true&src=https%3A%2F%2Fs.pstatic.net%2Fmovie.phinf%2F20200612_248%2F1591937633750Vvyr6_JPEG%2Fmovie_image.jpg%3Ftype%3Dw640_2' WHERE title = '부산행';

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
INSERT INTO movie VALUES ('82년생 김지영', '2019-10-23', 9.13, '드라마', "https://movie-phinf.pstatic.net/20191024_215/1571900079078PNazL_JPEG/movie_image.jpg?type=m203_290_2");
INSERT INTO movie VALUES ('관상', '2013-09-11', 8.02, '드라마', "https://movie-phinf.pstatic.net/20130819_110/1376895907326wlXma_JPEG/movie_image.jpg?type=m203_290_2");
INSERT INTO movie VALUES ('엑시트', '2019-07-31', 8.99, '액션', "https://movie-phinf.pstatic.net/20190724_161/1563931152464tk11A_JPEG/movie_image.jpg?type=m203_290_2");
INSERT INTO movie VALUES ('리틀 포레스트', '2018-02-28', 9.01, '드라마', "https://movie-phinf.pstatic.net/20180130_167/1517289346533DfzLE_JPEG/movie_image.jpg?type=m203_290_2");
INSERT INTO movie VALUES ('더 킹', '2017.01.18', 8.39, '범죄', "https://movie-phinf.pstatic.net/20170118_172/1484704779507T3ahF_JPEG/movie_image.jpg?type=m203_290_2");
INSERT INTO movie VALUES ('미녀는 괴로워', '2006-12-14', 8.79, '코미디', "https://movie-phinf.pstatic.net/20111222_283/1324561166934KJyL7_JPEG/movie_image.jpg?type=m203_290_2");
INSERT INTO movie VALUES ('과속스캔들', '2008-12-03', 9.20, '코미디', "https://movie-phinf.pstatic.net/20111223_14/1324584883775HhKfa_JPEG/movie_image.jpg?type=m203_290_2");
INSERT INTO movie VALUES ('신과함께-죄와 벌', '2017-12-20', 8.73, '판타지', "https://movie-phinf.pstatic.net/20201230_252/1609304926719vwxpF_JPEG/movie_image.jpg?type=m203_290_2");
INSERT INTO movie VALUES ('라라랜드', '2016-12-07', 8.91, '드라마', "https://movie-phinf.pstatic.net/20201229_146/1609226288425JgdsP_JPEG/movie_image.jpg?type=m203_290_2");
INSERT INTO movie VALUES ('크루엘라', '2021.05.26', 9.23, '드라마', "https://movie-phinf.pstatic.net/20210512_139/1620799657168vGIqq_JPEG/movie_image.jpg?type=m203_290_2");

SELECT * FROM actor;
INSERT INTO actor VALUES (1, '로버트 다우니 주니어', 1965, 174, 65, '수잔 다우니', 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F37%2F201504171519202401.jpg');
INSERT INTO actor VALUES (2, '기네스 팰트로', 1972, 175, 61, '브래드 팰척', 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F99%2F201701061722081411.jpg');
INSERT INTO actor VALUES (3, '테렌스 하워드', 1969, 184, 75, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F161%2F201711151547551881.jpg');
INSERT INTO actor VALUES (4, '이하늬', 1983, 173, 56, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202106%2F20210617145942474.jpg');
INSERT INTO actor VALUES (5, '류승룡', 1970, 175, 72, NULL, 'https://upload.wikimedia.org/wikipedia/commons/c/c3/180321_%EC%98%81%ED%99%94_%277%EB%85%84%EC%9D%98_%EB%B0%A4%27_%EA%B8%B0%EC%9E%90%EA%B0%84%EB%8B%B4%ED%9A%8C_%EB%A5%98%EC%8A%B9%EB%A3%A1.jpg');
INSERT INTO actor VALUES (6, '진선규', 1999, 177, 70, '박보경', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Jin_Seon-kyu_in_2019.png/300px-Jin_Seon-kyu_in_2019.png');
INSERT INTO actor VALUES (7, '이동휘', 1985, 179, 67, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/160305_%EC%9D%91%EB%8B%B5%ED%95%98%EB%9D%BC_1988_%EC%BD%98%EC%84%9C%ED%8A%B8_%EC%9D%B4%EB%8F%99%ED%9C%98_%28Lee_Dong_Hwi%29_cropped.jpg/375px-160305_%EC%9D%91%EB%8B%B5%ED%95%98%EB%9D%BC_1988_%EC%BD%98%EC%84%9C%ED%8A%B8_%EC%9D%B4%EB%8F%99%ED%9C%98_%28Lee_Dong_Hwi%29_cropped.jpg');
INSERT INTO actor VALUES (8, '공명', 1994, 183, 73, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202011%2F20201102135115429.jpg');
INSERT INTO actor VALUES (9, '일라이저 우드', 1981, 168, 73, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Elijah_Wood_%2847955397556%29_%28cropped%29.jpg/375px-Elijah_Wood_%2847955397556%29_%28cropped%29.jpg');
INSERT INTO actor VALUES (10, '숀 애스틴', 1971, 170, 67, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Sean_Astin_1_%282%29.jpg/375px-Sean_Astin_1_%282%29.jpg');
INSERT INTO actor VALUES (11, '앤디 서키스', 1964, 171, 65, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Andy_Serkis_2014_WonderCon_%28cropped%29.jpg/375px-Andy_Serkis_2014_WonderCon_%28cropped%29.jpg');
INSERT INTO actor VALUES (12, '마동석', 1971, 178, 100, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Ma_Dong-seok.png/375px-Ma_Dong-seok.png');
INSERT INTO actor VALUES (14, '윤계상', 1978, 182, 77, '차혜영', 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202104%2F20210406105300661.jpg');
INSERT INTO actor VALUES (15, '최귀화', 1978, 181, 72, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201907%2F20190704112907168.jpg');
INSERT INTO actor VALUES (16, '조재윤', 1974, 174, 75, '조은애', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Jo_Jae-yoon.2019.jpg/375px-Jo_Jae-yoon.2019.jpg');
INSERT INTO actor VALUES (17, '유아인', 1986, 179, 71, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Yoo_Ah-In_%EC%9C%A0%EC%95%84%EC%9D%B8_20181206.jpg/375px-Yoo_Ah-In_%EC%9C%A0%EC%95%84%EC%9D%B8_20181206.jpg');
INSERT INTO actor VALUES (18, '황정민', 1999, 180, 75, '김미혜', 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202003%2F20200316134444946.jpg');
INSERT INTO actor VALUES (19, '유해진', 1970, 174, 65, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202103%2F2021032416372949.jpg');
INSERT INTO actor VALUES (20, '오달수', 1968, 176, 68, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202112%2F20211222155527494.jpg');
INSERT INTO actor VALUES (21, '정우', 1981, 180, 70, '김유미', 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202012%2F2020120414552586.jpg');
INSERT INTO actor VALUES (22, '손호준', 1984, 176, 67, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F29%2F202107011814212871.png');
INSERT INTO actor VALUES (23, '황정음', 1985, 167, 48, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201705%2F20170515135905272-3840444.jpg');
INSERT INTO actor VALUES (24, '라미란', 1975, 162, 53, '김진구', 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202112%2F20211222155507949.jpg');
INSERT INTO actor VALUES (25, '공유', 1979, 184, 74, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202107%2F20210722120819584.jpg');
INSERT INTO actor VALUES (26, '정유미', 1983, 163, 43, NULL, 'https://upload.wikimedia.org/wikipedia/commons/6/6b/%EC%A0%95%EC%9C%A0%EB%AF%B8_%EB%B6%80%EC%82%B0%ED%96%89_%EB%AC%B4%EB%8C%80%EC%9D%B8%EC%82%AC.jpg');
INSERT INTO actor VALUES (27, '최우식', 1990, 181, 65, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201911%2F20191111162806970-8759926.jpg');
INSERT INTO actor VALUES (28, '크리스 에반스', 1981, 183, 79, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F110%2F201806211509351671.jpg');
INSERT INTO actor VALUES (29, '스칼릿 조핸슨', 1984, 160, 57, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F197%2F202107081427584991.png');

-- 추가 데이터
INSERT INTO actor VALUES (30, '송강호', 1967, 180, 80, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202102%2F20210222160936234.jpg');
INSERT INTO actor VALUES (31, '이정재', 1972, 180, 70, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F42%2F201812191840306281.jpg');
INSERT INTO actor VALUES (32, '조정석', 1980, 174, 63, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202108%2F202108201044543.jpg');
INSERT INTO actor VALUES (33, '윤아', 1990, 168, 47, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202108%2F20210831170143146.jpg');
INSERT INTO actor VALUES (34, '고두심', 1951, 160, 53, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F0%2F201404041105394501.jpg');
INSERT INTO actor VALUES (35, '김태리', 1990, 166, 51, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202203%2F20220307140537732.jpg');
INSERT INTO actor VALUES (36, '류준열', 1986, 183, 70, NULL, 'https://search.pstatic.net/common?type=f&size=240x300&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202111%2F20211124133103392.jpg');
INSERT INTO actor VALUES (37, '문소리', 1974, 164, 57, '장준환', 'https://search.pstatic.net/common?type=f&size=240x300&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202112%2F20211223150056955.jpg');
INSERT INTO actor VALUES (38, '조인성', 1981, 186, 68, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F181%2F201710261740338821.jpg');
INSERT INTO actor VALUES (39, '정우성', 1973, 186, 80, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201812%2F20181220111450105.jpg');
INSERT INTO actor VALUES (40, '김아중', 1982, 170, 48, NULL, 'https://search.pstatic.net/common?type=f&size=240x300&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202112%2F20211202160752166.jpg');
INSERT INTO actor VALUES (41, '차태현', 1976, 175, 65, '최석은', 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201608%2F20160810155746864.jpg');
INSERT INTO actor VALUES (42, '박보영', 1990, 158, 44, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F15%2F202005111648169131.jpg');
INSERT INTO actor VALUES (43, '왕석현', 2003, 181, 57, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201809%2F20180905152130243.jpg');
INSERT INTO actor VALUES (44, '하정우', 1978, 184, 77, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201703%2F20170309160737361.jpg');
INSERT INTO actor VALUES (45, '김향기', 2000, 155, 47, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2F138%2F202112091118283621.jpg');
INSERT INTO actor VALUES (46, '주지훈', 1982, 187, 77, NULL, 'https://search.pstatic.net/common?type=b&size=216&expire=1&refresh=true&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F201502%2F20150204115955124-6648994.jpg');
INSERT INTO actor VALUES (47, '엠마 스톤', 1988, 167, 57, '데이브 맥커리', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Emma_Stone_at_Maniac_UK_premiere_%28cropped%29.jpg/375px-Emma_Stone_at_Maniac_UK_premiere_%28cropped%29.jpg');
INSERT INTO actor VALUES (48, '라이언 고슬링', 1980, 184, 78, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Ryan_Gosling_in_2018.jpg/250px-Ryan_Gosling_in_2018.jpg');
INSERT INTO actor VALUES (49, '마크 스트롱', 1963, 186, 79, '리자 마셜', 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/b5/Mark_Strong_%28Berlin_Film_Festival_2011%29.jpg/250px-Mark_Strong_%28Berlin_Film_Festival_2011%29.jpg');
INSERT INTO actor VALUES (50, '엠마 톰슨', 1959, 173, 57, '그레그 와이즈', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a0/Emma_Thompson_2022.jpg/250px-Emma_Thompson_2022.jpg');

update actor set image = 'https://search.pstatic.net/common?type=f&size=240x300&quality=100&direct=true&src=http%3A%2F%2Fsstatic.naver.net%2Fpeople%2Fportrait%2F202112%2F20211223150056955.jpg' where id = 37;

SELECT * FROM score;
DESC score;
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

SELECT * FROM role;
INSERT INTO role VALUES ('아이언맨', '로버트 다우니 주니어', '주연', '토니 스타크');
INSERT INTO role VALUES ('아이언맨', '기네스 팰트로', '주연', '페퍼 포츠');
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
INSERT INTO role VALUES ('어벤져스', '기네스 팰트로', '조연', '페퍼 포츠');
INSERT INTO role VALUES ('어벤져스', '톰 히들스턴', '주연', '로키');

INSERT INTO role VALUES ('82년생 김지영', '공유', '주연', '대현');
INSERT INTO role VALUES ('82년생 김지영', '정유미', '주연', '지영');

INSERT INTO role VALUES ('관상', '송강호', '주연', '내경');
INSERT INTO role VALUES ('관상', '이정재', '주연', '수양대군');
INSERT INTO role VALUES ('관상', '조정석', '주연', '팽헌');

INSERT INTO role VALUES ('엑시트', '윤아', '주연', '의주');
INSERT INTO role VALUES ('엑시트', '조정석', '주연', '용남');
INSERT INTO role VALUES ('엑시트', '고두심', '조연', '현옥');

INSERT INTO role VALUES ('리틀 포레스트', '김태리', '주연', '혜원');
INSERT INTO role VALUES ('리틀 포레스트', '류준열', '주연', '재하');
INSERT INTO role VALUES ('리틀 포레스트', '문소리', '조연', '혜원 엄마');

INSERT INTO role VALUES ('더 킹', '조인성', '주연', '박태수');
INSERT INTO role VALUES ('더 킹', '류준열', '주연', '최두일');
INSERT INTO role VALUES ('더 킹', '정우성', '주연', '한강식');

INSERT INTO role VALUES ('미녀는 괴로워', '주진모', '주연', '한상준');
INSERT INTO role VALUES ('미녀는 괴로워', '김아중', '주연', '강한나');
INSERT INTO role VALUES ('미녀는 괴로워', '성동일', '조연', '최사장');

INSERT INTO role VALUES ('과속스캔들', '박보영', '주연', '황정남');
INSERT INTO role VALUES ('과속스캔들', '차태현', '주연', '남현수');
INSERT INTO role VALUES ('과속스캔들', '왕석현', '주연', '황기동');

INSERT INTO role VALUES ('신과함께-죄와 벌', '하정우', '주연', '강림');
INSERT INTO role VALUES ('신과함께-죄와 벌', '차태현', '주연', '자홍');
INSERT INTO role VALUES ('신과함께-죄와 벌', '김향기', '주연', '덕춘');
INSERT INTO role VALUES ('신과함께-죄와 벌', '주지훈', '주연', '해원맥');

INSERT INTO role VALUES ('라라랜드', '라이언 고슬링', '주연', '세바스찬');
INSERT INTO role VALUES ('라라랜드', '엠마 스톤', '주연', '미아');

INSERT INTO role VALUES ('크루엘라', '엠마 스톤', '주연', '크루엘라');
INSERT INTO role VALUES ('크루엘라', '엠마 톰슨', '조연', '바로네스');
INSERT INTO role VALUES ('크루엘라', '마크 스트롱', '조연', '보리스');

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

UPDATE movie SET sales = '8.5' WHERE title = '아이언맨';

SELECT *
FROM actor a
INNER JOIN role r
ON a.actorName = r.actorName
WHERE a.actorName ='마동석';