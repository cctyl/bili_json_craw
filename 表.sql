 create database bili_client_json;
 use bili_client_json;
 
CREATE TABLE `videos` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `aid` int(11) DEFAULT NULL,
  `typeid` varchar(20) DEFAULT NULL,
  `typename` varchar(20) DEFAULT NULL,
  `title` varchar(100) DEFAULT NULL,
  `subtitle` varchar(100) DEFAULT NULL,
  `play` varchar(20) DEFAULT NULL,
  `review` varchar(20) DEFAULT NULL,
  `video_review` varchar(20) DEFAULT NULL,
  `favorites` varchar(20) DEFAULT NULL,
  `credit` varchar(20) DEFAULT NULL,
  `pic` varchar(200) DEFAULT NULL,
  `duration` varchar(20) DEFAULT NULL,
  `description` varchar(2000) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `coins` varchar(20) DEFAULT NULL,
  `mid` varchar(20) DEFAULT NULL,
  `author` varchar(20) DEFAULT NULL,
  `link` varchar(50) DEFAULT NULL,
  `create_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=MyISAM AUTO_INCREMENT=510 DEFAULT CHARSET=utf8

