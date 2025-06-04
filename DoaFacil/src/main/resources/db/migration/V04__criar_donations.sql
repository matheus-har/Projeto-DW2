CREATE TABLE `donations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `donor_Id` bigint(20) NOT NULL,
  `recipient_Id` bigint(20) NOT NULL,
  `date`date NOT NULL,
  `product_Id` bigint(50) NOT NULL,
  `pickup_Location` varchar(70),
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`donor_Id`) REFERENCES users(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`recipient_Id`) REFERENCES users(`id`)   ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;