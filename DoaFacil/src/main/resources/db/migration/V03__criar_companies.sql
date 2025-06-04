CREATE TABLE `companies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `registered_Name` varchar(60) NOT NULL,
  `fantasy_Name` varchar(60) NOT NULL,
  `email`varchar(100) NOT NULL,
  `telephone`varchar(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;