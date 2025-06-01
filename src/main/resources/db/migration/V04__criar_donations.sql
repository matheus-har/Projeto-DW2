CREATE TABLE `donations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `donorId` bigint(20) NOT NULL,
  `recipientId` bigint(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `dateD`date NOT NULL,
  `product` varchar(50) NOT NULL,
  `pickupLocation` varchar(70),
  PRIMARY KEY (`id`),
  FOREIGN KEY (donorId) REFERENCES users(id),
  FOREIGN KEY (donorId) REFERENCES users(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;