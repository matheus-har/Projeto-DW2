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

INSERT INTO `products` (`name`, `amount`, `validity`, `type`, `conservation`, `size`, `active`) 
VALUES ('Leite Integral', 100, '2025-12-31',  'COMIDA','NOVO', 1.0, 1);

INSERT INTO `products` (`name`, `amount`, `validity`, `type`, `conservation`, `size`, `active`) 
VALUES ('Refrigerante', 10, '2026-06-30',  'COMIDA','NOVO', 2.0, 1);

INSERT INTO `products` (`name`, `amount`, `validity`, `type`, `conservation`, `size`, `active`) 
VALUES ('Boneca', 100, '2025-12-31', 'BRINQUEDO','NOVO', 0.5, 1);