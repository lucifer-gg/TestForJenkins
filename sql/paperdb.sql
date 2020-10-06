DROP DATABASE IF EXISTS paperdb;
CREATE DATABASE paperdb DEFAULT CHARACTER SET utf8;
USE paperdb;



##创建作者表
CREATE TABLE author(
    author_id INT AUTO_INCREMENT PRIMARY KEY,
    author_name VARCHAR(30) unique,
    author_affiliations VARCHAR(50),
    author_keywords VARCHAR(255),
    Funding_Information VARCHAR(255)
)ENGINE=InnoDB;

##创建会议表
CREATE TABLE meeting(
    meeting_id INT AUTO_INCREMENT PRIMARY KEY,
    publisher VARCHAR(5) ,
    Document_Identifier VARCHAR(30),
    UNIQUE(publisher,Document_Identifier)
)ENGINE=InnoDB;

##创建论文表
CREATE TABLE paper(
    paper_id INT AUTO_INCREMENT PRIMARY KEY,
    Document_Title VARCHAR(512) unique,
    Date_Added_To_Xplore VARCHAR(30),
    Abstract VARCHAR(10000),
    ISSN VARCHAR(100),
    ISBNs VARCHAR(100),
    DOI VARCHAR(50),
    PDF_Link VARCHAR(1024),
    IEEE_Terms VARCHAR(512),
    INSPEC_Controlled_Terms VARCHAR(512),
    INSPEC_Non_Controlled_Terms VARCHAR(512),
    Mesh_Terms VARCHAR(512),
    Article_Citation_Count INT(3),
    Reference_Count INT(3),
    Online_Date VARCHAR(12),
    Issue_Date VARCHAR(12),
    Meeting_Date VARCHAR(12),
    License VARCHAR(20)
)ENGINE = InnoDB;



##创建出版表
CREATE TABLE publish(
    publish_id INT AUTO_INCREMENT PRIMARY KEY,
    meeting_id INT,
    CONSTRAINT fk_meeting
    FOREIGN KEY(meeting_id) REFERENCES  meeting(meeting_id),
    paper_id INT,
    CONSTRAINT fk_paper
    FOREIGN KEY(paper_id) REFERENCES  paper(paper_id),
    Publication_Title VARCHAR(100),
    Publication_Year INT(4),
    Volume INT(3),
    Issue INT(3),
    Start_Page INT(5),
    End_Page INT(5),
    UNIQUE(meeting_id,paper_id)
)ENGINE = InnoDB;

##创建作者与论文关系表
CREATE TABLE produce(
    create_id INT AUTO_INCREMENT PRIMARY KEY,
    paper_id INT,
    CONSTRAINT fk_p
    FOREIGN KEY(paper_id) REFERENCES  paper(paper_id),
    author_id INT,
    CONSTRAINT fk_author
    FOREIGN KEY(author_id) REFERENCES  author(author_id),
    UNIQUE(paper_id,author_id)
)ENGINE=InnoDB;

##创建作者领域表
DROP TABLE IF EXISTS `authorDomain`;
CREATE TABLE `authorDomain` (
`authorId` int(11) NOT NULL,
`author` varchar(1000) NOT NULL,
`organ` varchar(1000) NOT NULL,
`domain` varchar(1000) NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;


##创建论文信息表
DROP TABLE IF EXISTS `paperInf`;
CREATE TABLE `paperInf` (
`paperId` int(11) NOT NULL,
`authorId` int(11) NOT NULL,
`author` varchar(255) NOT NULL,
`title` varchar(1000) NOT NULL,
`abstract` varchar(10000) NOT NULL,
`pdfLink` varchar(1000) NOT NULL,
`time` int(11) NOT NULL,
`publishTitle` varchar(1000) NOT NULL,
`redNum` int(11) NOT NULL,
`doi` varchar(255) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
INSERT INTO `paperInf` VALUES(3,1,'xiaoming','title','ab1','pdf',2020,'ptitle',20,'doi'),(2,1,'xiaoming','title','ab2','pdf',2020,'ptitle',20,'doi'),
(1,1,'xiaoming','title','ab3','pdf',2020,'ptitle',20,'doi'),
(4,1,'xiaoming','title','ab3','pdf',2020,'ptitle',20,'doi');

##创建论文热点表
DROP TABLE IF EXISTS `paperSpot`;
CREATE TABLE `paperSpot` (
`paperId` int(11) NOT NULL,
`spot` varchar(100) NULL,
`title` varchar(1000) NOT NULL,
`pdfLink` varchar(1000) NOT NULL,
`abstract` varchar(10000) NOT NULL,
`time` int(11) NOT NULL,
`authorId` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;

##创建用户信息表
DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_id_uindex` (`id`),
  UNIQUE KEY `user_username_uindex` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;
##插入一条测试数据

##创建收藏表
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `userId` int(11) NOT NULL,
  `paperId` int(11) NOT NULL,
  `title` varchar(500) NOT NULL,
  `abstract` varchar(5000) NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
INSERT INTO `collection` VALUES()

##创建作者领域表
DROP TABLE IF EXISTS `authorDomain`;
CREATE TABLE `authorDomain` (
  `authorId` int(11) NOT NULL,
  `author` varchar(50) NOT NULL,
  `organ` varchar(50) NOT NULL,
  `domain` varchar(50) NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
INSERT INTO `authorDomain` VALUES(1,'xiaoming','IEEE','one'),(1,'xiaoming','IEEE','two'),(1,'xiaoming','IEEE','three');
INSERT INTO `authorDomain` VALUES(1,'xiaoming','IEEE','one');
select * from paperSpot group by paperId,spot;


##创建作者领域热度表
DROP TABLE IF EXISTS `authorHot`;
CREATE TABLE `authorHot` (
  `authorId` int(11) NOT NULL,
  `author` varchar(255) NOT NULL,
`domain` varchar(255)NOT NULL,
`hotNum` float(5,2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;


##创建文章热度表
DROP TABLE IF EXISTS `paperHot`;
CREATE TABLE `paperHot` (
  `paperId` int(11) NOT NULL,
`hotNum` float(7,2) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;


##创建学术合作关系表
DROP TABLE IF EXISTS `collaboration`;
CREATE TABLE `collaboration` (
  `authorId1` int(11) NOT NULL,
  `authorId2` int(11) NOT NULL,
  `author1` varchar(500) NOT NULL,
 `author2` varchar(500) NOT NULL,
`organ1` varchar(500) NOT NULL,
`organ2` varchar(500) NOT NULL,
`times` int(11) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4;
COMMIT;
