CREATE TABLE `products` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `amount` int NOT NULL,
  `validity`date NOT NULL,
  `type` varchar(30) NOT NULL,
  `conservation` varchar(30) NOT NULL, 
  `size`DOUBLE NOT NULL,
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;