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
INSERT INTO actor VALUES (1, '로버트 다우니 주니어', 1965, 174, 65, '수잔 다우니', 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/94/Robert_Downey_Jr_2014_Comic_Con_%28cropped%29.jpg/375px-Robert_Downey_Jr_2014_Comic_Con_%28cropped%29.jpg');
INSERT INTO actor VALUES (2, '기네스 팰트로', 1972, 175, 61, '브래드 팰척', 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/GwynethPaltrowByAndreaRaffin2011.jpg/375px-GwynethPaltrowByAndreaRaffin2011.jpg');
INSERT INTO actor VALUES (3, '테렌스 하워드', 1969, 184, 75, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1d/TerrenceHowardSept11TIFF.jpg/375px-TerrenceHowardSept11TIFF.jpg');
INSERT INTO actor VALUES (4, '이하늬', 1983, 173, 56, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Lee_Ha-nui_in_Feb_2019.png/375px-Lee_Ha-nui_in_Feb_2019.png');
INSERT INTO actor VALUES (5, '류승룡', 1970, 175, 72, NULL, 'https://upload.wikimedia.org/wikipedia/commons/c/c3/180321_%EC%98%81%ED%99%94_%277%EB%85%84%EC%9D%98_%EB%B0%A4%27_%EA%B8%B0%EC%9E%90%EA%B0%84%EB%8B%B4%ED%9A%8C_%EB%A5%98%EC%8A%B9%EB%A3%A1.jpg');
INSERT INTO actor VALUES (6, '진선규', 1999, 177, 70, '박보경', 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/cd/Jin_Seon-kyu_in_2019.png/300px-Jin_Seon-kyu_in_2019.png');
INSERT INTO actor VALUES (7, '이동휘', 1985, 179, 67, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/4/4b/160305_%EC%9D%91%EB%8B%B5%ED%95%98%EB%9D%BC_1988_%EC%BD%98%EC%84%9C%ED%8A%B8_%EC%9D%B4%EB%8F%99%ED%9C%98_%28Lee_Dong_Hwi%29_cropped.jpg/375px-160305_%EC%9D%91%EB%8B%B5%ED%95%98%EB%9D%BC_1988_%EC%BD%98%EC%84%9C%ED%8A%B8_%EC%9D%B4%EB%8F%99%ED%9C%98_%28Lee_Dong_Hwi%29_cropped.jpg');
INSERT INTO actor VALUES (8, '공명', 1994, 183, 73, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/bb/%EA%B3%B5%EB%AA%85%28Gongmyung%29%2C_%2224%ED%9A%8C_%EC%B6%98%EC%82%AC%EC%98%81%ED%99%94%EC%A0%9C%EA%B0%80%22_04.png/435px-%EA%B3%B5%EB%AA%85%28Gongmyung%29%2C_%2224%ED%9A%8C_%EC%B6%98%EC%82%AC%EC%98%81%ED%99%94%EC%A0%9C%EA%B0%80%22_04.png');
INSERT INTO actor VALUES (9, '일라이저 우드', 1981, 168, 73, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/c/c9/Elijah_Wood_%2847955397556%29_%28cropped%29.jpg/375px-Elijah_Wood_%2847955397556%29_%28cropped%29.jpg');
INSERT INTO actor VALUES (10, '숀 애스틴', 1971, 170, 67, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/6/61/Sean_Astin_1_%282%29.jpg/375px-Sean_Astin_1_%282%29.jpg');
INSERT INTO actor VALUES (11, '앤디 서키스', 1964, 171, 65, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/5/5c/Andy_Serkis_2014_WonderCon_%28cropped%29.jpg/375px-Andy_Serkis_2014_WonderCon_%28cropped%29.jpg');
INSERT INTO actor VALUES (12, '마동석', 1971, 178, 100, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Ma_Dong-seok.png/375px-Ma_Dong-seok.png');
INSERT INTO actor VALUES (14, '윤계상', 1978, 182, 77, '차혜영', 'https://w.namu.la/s/d920cf115ecee078d66d59befb0cda6ecff323218edeed7b3da3ea4512bc0409f87268e636ea1c01a33713647ab9c6d215789822e98ea9f5f160031602286eae6353d7a291ca8477500b707d750acde174658f14733547e2fe32284293a61ce5e6a24416c3ebe572c1fbce38362b3756');
INSERT INTO actor VALUES (15, '최귀화', 1978, 181, 72, NULL, 'https://w.namu.la/s/4650ead21923d06c3fbcbed15553339888a7996aa637b402c81afd84fc162cdf8da9d5b0a0c7f221aa2c1ad4ac9f12d6a621679629d144013ba2b16936c2b7d4ad3b77278f63ced019178cb511ba151e330cab8d5f9573a4aad4f91300cd2595');
INSERT INTO actor VALUES (16, '조재윤', 1974, 174, 75, '조은애', 'https://upload.wikimedia.org/wikipedia/commons/thumb/e/ea/Jo_Jae-yoon.2019.jpg/375px-Jo_Jae-yoon.2019.jpg');
INSERT INTO actor VALUES (17, '유아인', 1986, 179, 71, NULL, 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/00/Yoo_Ah-In_%EC%9C%A0%EC%95%84%EC%9D%B8_20181206.jpg/375px-Yoo_Ah-In_%EC%9C%A0%EC%95%84%EC%9D%B8_20181206.jpg');
INSERT INTO actor VALUES (18, '황정민', 1999, 180, 75, '김미혜', 'https://w.namu.la/s/326af398678bf9bc37d0a58db10177d2ec3d49058b0e865e2ad25b7601dd18933911a267ffa0e5497b309d04b0d93f767db2d9cfd203128bdd7f60698c758120b60cedf5586ab6937b56e340960aaa5bf51040feadd0cbe1f88813ddc4a2f9516aee966ec4ac5e9f50426ae022391fd3');
INSERT INTO actor VALUES (19, '유해진', 1970, 174, 65, NULL, 'https://w.namu.la/s/a4494a8f09c28bdbb8f0dd4a6f7aaceeeb187b701ad99b43cb6badd5bef49138415fb69cce36b7f9eefafbb0e88aa5f75d62ae5d7d5272aabb102658fde77f3f6c87ee52079b1325353f26375b08bec4821efbcc36c9fd3b51ed0910dce0a40ae5b4545011b9442fa5b4e69615a6539a');
INSERT INTO actor VALUES (20, '오달수', 1968, 176, 68, NULL, 'https://w.namu.la/s/a343fd9937555e61aeedb0079925d023cb86dac024307a5267573a5bc27b505cba3b5b292db2183ece9eff237c4535ea6be4433f154a9e185f184f5003893c690d8884f1383a60a30361e147670497af004f72a58410620319fde47b1adf8b71');
INSERT INTO actor VALUES (21, '정우', 1981, 180, 70, '김유미', 'https://w.namu.la/s/9828b8461d152531271e6d38ec167b7ed2ff7b94440d00e860a6fa1c62da87e008d8289c8fdba5d639a8cc8c2991898b9d7b7e920e7d57ceb2dab377e4879cc8f7c887082a8af1a42ec3020ef9050893cfe222809989b9a5122a48413346e95b3eb21adc6bdd591b6cc642d346520566');
INSERT INTO actor VALUES (22, '손호준', 1984, 176, 67, NULL, 'https://w.namu.la/s/8cdf524af20b5ea147818145ce249e75776fd9fd41be470222441464dd84dc6e0aa11568bd6aefeb63c0e92ccfaa1602d052fb5694fcdf64da017aa8767e5d23ebb60801850857d164adeb4a5e68cc7bc03806374999ad3cfb800b2acf0cddf5');
INSERT INTO actor VALUES (23, '황정음', 1985, 167, 48, NULL, 'https://w.namu.la/s/92cbb04dd3d61c65cf7134c38c182d611d7aa691635be0e36a4f5cb31cb998002423578e95a80dc596f7c96461d5fe81adcf01007ad0017633315f6b30449779a5a0a8b828a3f0219f3f2eeb637ecc035cdb446df3b16f3dbef1a58df40cecc9');
INSERT INTO actor VALUES (24, '라미란', 1975, 162, 53, '김진구', 'https://w.namu.la/s/1b2bd0498ba89878d5f8eee7bec33ec264eb36e8d1bf05d5170a09d4b4fa7d79b7ba094f0b10923bdba5308d686f4bc10ea019d1bedb6d5a892087ba0e0c71d75fda42078226bb8633eaf908195cf3847755368a655ff24fcd33934574afbbf5');
INSERT INTO actor VALUES (25, '공유', 1979, 184, 74, NULL, 'https://w.namu.la/s/5841da2bcf85033a87156830a6b5a15172a99ec821dd1465a4d1e354dc8815f0fed23c18f2ccbfee65c030adc545ad54189a193ed83cd541ae00e3e81a98407413e688ba4293aca3fe78ea29a94020e8ff1518fcb1a12127521e5d833a33e0fba2d702bfa219bd7cf16821e045c638d8');
INSERT INTO actor VALUES (26, '정유미', 1983, 163, 43, NULL, 'https://upload.wikimedia.org/wikipedia/commons/6/6b/%EC%A0%95%EC%9C%A0%EB%AF%B8_%EB%B6%80%EC%82%B0%ED%96%89_%EB%AC%B4%EB%8C%80%EC%9D%B8%EC%82%AC.jpg');
INSERT INTO actor VALUES (27, '최우식', 1990, 181, 65, NULL, 'https://w.namu.la/s/edcf16f858af82090d07295df372486330e1aed9475b12aff4902ca7bfd568c647cb8a61b72d91946b62ba1257c50f13e379f4b32ea457f8073ec4b354eac42a6e6e3fde361fa8fe6652287c5a1fb42ecd9630d6b501f77e67734c2b6cdcd82073b903b3fcf35950de9a320057b6bc9b');
INSERT INTO actor VALUES (28, '크리스 에반스', 1981, 183, 79, NULL, 'https://w.namu.la/s/f0792683288773689d5eb04a5b17ad6b94fd50bf181faa81658c02d3e946be498dbc6a52ba64161713677a0a620f7946bef9d76e4f3f4e54a299317c9c6eea525d2cfaadaf25c0cc9c552847ee06e2e3549d72bf1ada7c2cd1cd75bc3dab9dc1');
INSERT INTO actor VALUES (29, '스칼릿 조핸슨', 1984, 160, 57, NULL, 'https://w.namu.la/s/33ad0d24368aedb0fdfbbd1248cb5aa5b842402658d3ae0e03d5101a4285f0b017fda1ddad50d37aabf2e14771880ecb31978086e2003aafdd5c3f18fa69d17a0c7832540e3f4a501dbdb54782736a89781f9264be6827548da75194706e2135ceb642653cb242488687befa2fbf5d98');

-- 추가 데이터
INSERT INTO actor VALUES (0, '송강호', 1967, 180, 80, NULL, 'https://w.namu.la/s/fdb253d00e6910368ec757a32cf85168d3a6197a71a3c3962b1d39d89e9703aebbd13786e647fa8477227bc36b2ba52b94678ebdd6514076f600c9b3b0377fc90ef19f174daf805d01cd275823c8ce183525b09445832c64ab905bacce8002bcc34cc3ae91b4ade951d74ef465f0d0a8');
INSERT INTO actor VALUES (0, '이정재', 1972, 180, 70, NULL, 'https://w.namu.la/s/30cba8f0187e2b5a96de095c49051b36ebc6c3d7c16bfc345e52ca1a1d57127081f624718807edeec3ccffdefba9bb0ac6e31ad18f2f9d77aa0a1a9822e77b158903f092a7b8181e800197afcd9d906286439545c90c8b1597b07789b14eed4326a4ec8c9be27b878c50a4ca2a896d80');
INSERT INTO actor VALUES (0, '조정석', 1980, 174, 63, NULL, 'https://w.namu.la/s/86320c7a4f37a5b30b726116d4c431da8b2f546b4c810f270ab64b4ae1a4974224c5cd7748cc9ce7b24234ba7bc202db7e7a0a1edb757e599eba95b86eeac30fbe21d302734ab14d4bedabe440266b5b62cc885eb73b5c2ad77dd8a055444740');
INSERT INTO actor VALUES (0, '윤아', 1990, 168, 47, NULL, 'https://w.namu.la/s/0ff98cade810f6121e295f49215b63f0288bb1fcbbc0287f570d8d0cd4cefc6506a176619abc3d25ff63be377dc16fa0c73ea51636fd7a14ca785e94f5896b2caa32ac0ad0fdb58c193b5f840c4157352da7d568d928ef3da7f0ae7688a76a05');
INSERT INTO actor VALUES (0, '고두심', 1951, 160, 53, NULL, 'https://w.namu.la/s/f77304c9046a3aed92f23ea4e73f74c397d9c7f63f2908f1cc9aac0f990c83ad45007c66b86bc84e723cb656d42c228089c061b38d56c4bc538a80fba8d7da79da9e87db4c4239d2e14ca177a887bd5834ee7b805fbb073e7315fcda92f14413');
INSERT INTO actor VALUES (0, '김태리', 1990, 166, 51, NULL, 'https://w.namu.la/s/6c94105686fa5651aaf6849b4bdc51bf9d19e25bf846610cadc707e1183e74bf4a9bda5f49f7e0042b5ac9f8adc688b81b6d67ca17193883af8926df74245942d44134bb28ae3171a231d01353282480dc74a3d3d38c1a1a8c2d79b17058e47f44a3213159fbf22fff403c2e24cf4eb1');
INSERT INTO actor VALUES (0, '류준열', 1986, 183, 70, NULL, 'https://w.namu.la/s/52a722a6484117ed3c72511c448e67b7b5c57d84a72fdb9257eecac3d388d10fac0ec81cbd0ea61072155fe55f970f5aef539d89a96231b14918a58d58990050911a1cf64a6b9959a953e60432ac2fda0ec669e11e865ed523fbcc8025567a407874629129b148c5c7b04c07aa40a0e1');
INSERT INTO actor VALUES (0, '문소리', 1974, 164, 57, '장준환', 'https://w.namu.la/s/aaaeef183eeaea524e3a42500cb8f8ddc466b43066f26481abc3a523155da07eeb5cf527ed9a73fae29710913f80f44c81840acef361b44ac258260a1cc8f5de909f6a70cd79d846b80d9de9bb28229a8e57d0e93960a9361b7b2aea77f8aa4a99511615395aaabda7ce77028cbc112f');
INSERT INTO actor VALUES (0, '조인성', 1981, 186, 68, NULL, 'https://w.namu.la/s/3c8a0b8f9430a6c766c52825b7e514606e835b290a1d29dc73aca0cf8f6508ef9eaf609dc1b96876f6aa3ec7a65f88cbee86d9d873562e0773966f493a78a76c0382d2c009e63c5c1c320c681c22beda394fd5788902b69aaf37f697cd5b4d763720299e94a6955bfea5c737f5f81525');
INSERT INTO actor VALUES (0, '정우성', 1973, 186, 80, NULL, 'https://w.namu.la/s/836bd783fbed0a8200dd9ad536f8900c0ba064c3881282af1299be46cd876c2f9504fa16f912759ca4adf5b3eb087025b9ca0acfbab37f169575dd2c9a5d7d4eade5280b68a2d50eb7da2fe8ce74a19598a7422a43bbdd1bd8ef22b32581303f81cb1b98a8154dc7574abde623e3fad5');
INSERT INTO actor VALUES (0, '김아중', 1982, 170, 48, NULL, 'https://w.namu.la/s/18bf8824411b0f1558415cb40b314c02e871a07fa3499040d04fb99be64a727f396a0d63d77771f572e2a1da79c220db66f7735308157f5c30af0208802285fcb3f85b9ab4f8df2dec24fe886345b0e8dda2cd8968b4695900283b9cd0478f7c');
INSERT INTO actor VALUES (0, '차태현', 1976, 175, 65, '최석은', 'https://w.namu.la/s/45725a8a1c4b6f5cc14da4ba70df90ca00265bd87166a480f9dec3e8d48f1ac22e4b77aa3900c0f9c2cd57e4aadc7901e58868875255cbd17ae9548faae5bc2f8c54a60a588bbe6635d9273e69ac41ee8755ad3d8e67c690903cf7ce2170aca35fed372582e65246cb9f637f52116102');
INSERT INTO actor VALUES (0, '박보영', 1990, 158, 44, NULL, 'https://w.namu.la/s/56365777e2fc3cbbb6d9f0bcd2f4b5d3bcffa22f7eb5fa5062129f1afe2c919ed3204e4f9b4afc2d3720c9b6b8d24b26a6dbd82e69b4c6a441410ec8fe12c68546857ba84b3ac4d2fbaf3472fbe9807b457d918f3cca28c8a6266e2bd98e17a9af9db13d69d08cc82b05379e8c25dc3d');
INSERT INTO actor VALUES (0, '왕석현', 2003, 181, 57, NULL, 'https://w.namu.la/s/2d41381b159d25aaef5fec05e843812515302028053def27054fa16d85ffb3a79e42bc9609472f37c82f67078e0fc7ed6e8e304200051d0f80c0db7657db95eeca10dd96bf8f245c8f7109d34b36d4387ac0b858f2bcdd131f53ac39a3bb2f7c');
INSERT INTO actor VALUES (0, '하정우', 1978, 184, 77, NULL, 'https://w.namu.la/s/39a99d0f941dce448401ece781f323944be11aaa7dbb03480e462039a42322a3c3716e76c5ca8cd929ba449d8276bea512f8866c6b2ec3af4179fb16882b4b2eac4363d6a79e47577efb0057b97447b59465db8531b09ac41cd0220eac631c9f');
INSERT INTO actor VALUES (0, '김향기', 2000, 155, 47, NULL, 'https://w.namu.la/s/44755502db174dc4117e841cee226a19fe21807bbc177bab5dda414920816d491937a7577cc8a5e82f5988a1e3c80ad206ac49f24986033a85878d0db55f60c1e73e0cc166adb67d449673f9f877b22992bc0c8ed3fe4772808bf565e8a302cc879d4e6950448f010d87f56b364b98c5');
INSERT INTO actor VALUES (0, '주지훈', 1982, 187, 77, NULL, 'https://w.namu.la/s/544797e62178da4ade717cc1ea6d99c56fb11a6b11230a44e81e49bca2f3166f242d8a89360d6a35d53196e1cdee790d5149aaba77d3ad6eee0abf580e4277420be0abf37a18b6ad81bdf178b50d756f2331a63bf3478f95abf07831456fd717584481e90fc3f16f092768d2887dc3f1');
INSERT INTO actor VALUES (0, '엠마 스톤', 1988, 167, 57, '데이브 맥커리', 'https://upload.wikimedia.org/wikipedia/commons/thumb/3/31/Emma_Stone_at_Maniac_UK_premiere_%28cropped%29.jpg/375px-Emma_Stone_at_Maniac_UK_premiere_%28cropped%29.jpg');
INSERT INTO actor VALUES (0, '라이언 고슬링', 1980, 184, 78, NULL, 'https://w.namu.la/s/c8f5d42ca86cb98b5e8d66141d8e61b117f875304d04b8cc125bc0b93b4ea7de5f400fe8584a5f5a68c7acd40e7f990ab8f8185e2dd79dd554010f37a91be03c7a75bb8a5e4eec1a2761ebff9ae3bc0f0be2347d88714dc25a01223760c7f591c23ea92b06290d52d0cbc8b3999a1709');
INSERT INTO actor VALUES (0, '마크 스트롱', 1963, 186, 79, '리자 마셜', 'https://w.namu.la/s/121bb03870d4e9f44d16901931b84cbed2cb18de50fc63224c478c3313619a14c22fec411ec1691df08c5fb703c6017b17dc08796524391aeaa59b2901ba1508c2638ae43fb9938a78fdbf6e0342109e2565cedb87cebe4add34e26f595db38bfa40d964d6c1e8a26989c07381de6288');
INSERT INTO actor VALUES (0, '엠마 톰슨', 1959, 173, 57, '그레그 와이즈', 'https://w.namu.la/s/d49df146be374018ce01ee7f56e09c52cc3c803f1951944b1a25ac9b5b57840854ea92b1f5647173804d7789d03c4db86fa62d2d66b695e502b66d677d66492019c41c7953531418a56aa8d6111ca5160db94989169bf89c953c17301edf2a05d50089c39470b21ce6060d5b473b42a9');

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