CREATE TABLE `users` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(150) NOT NULL,
  `birth_date` date NOT NULL,
  `gender` varchar(30) NOT NULL,
  `telephone` varchar(11) NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `users` (`name`, `email`, `password`, `birth_date`, `gender`, `telephone`, `active`) 
VALUES ('Marcos Silva', 'marcos@hotmail.com', '1234', '1988-09-02', 'MASCULINO', '11987650000', 1);

INSERT INTO `users` (`name`, `email`, `password`, `birth_date`, `gender`, `telephone`, `active`) 
VALUES ('Maria Costa', 'maria@gmail.com', '1234', '1999-07-28', 'FEMININO', '11987650110', 1);

INSERT INTO `users` (`name`, `email`, `password`, `birth_date`, `gender`, `telephone`, `active`) 
VALUES ('Vitoria Rodrigues', 'vitoria@hotmail.com', '1234', '2002-07-06', 'FEMININO', '00007650000', 1);

INSERT INTO `users` (`name`, `email`, `password`, `birth_date`, `gender`, `telephone`, `active`) 
VALUES ('Paulo Ribeiro', 'paulo1@gmail.com', '1234', '2001-01-01', 'MASCULINO', '11987650011', 1);
