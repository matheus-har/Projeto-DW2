CREATE TABLE `companies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `registered_Name` varchar(60) NOT NULL,
  `fantasy_Name` varchar(60) NOT NULL,
  `email`varchar(100) NOT NULL,
  `telephone`varchar(11) NOT NULL,
  `user_Resp` bigint(20) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_Resp`) REFERENCES users(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `companies` (`registered_Name`, `fantasy_Name`, `email`, `telephone`, `user_Resp`, `active`) 
VALUES ('Fotos Campos LTDA','Fotos Campos','contato@gmail.com','12987001100', 2, 1);

INSERT INTO `companies` (`registered_Name`, `fantasy_Name`, `email`, `telephone`, `user_Resp`, `active`) 
VALUES ('Mercadinho Platanus LTDA','Mercadinho Platanus','mercadinhoPlatanus@gmail.com','12987008888', 1, 1);

INSERT INTO `companies` (`registered_Name`, `fantasy_Name`, `email`, `telephone`, `user_Resp`, `active`) 
VALUES ('Frutaria Souza LTDA','Frutaria Souza','souzafrutaria@hotmail.com','12999001107', 3, 1);