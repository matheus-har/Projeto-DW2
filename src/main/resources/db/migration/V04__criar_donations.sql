CREATE TABLE `donations` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `donor_Id` bigint(20) NOT NULL,
  `recipient_Id` bigint(20) NOT NULL,
  `date`date NOT NULL,
  `product_Id` bigint(20) NOT NULL,
  `pickup_Location` varchar(70),
  `active` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`donor_Id`) REFERENCES users(`id`) ON DELETE CASCADE,
  FOREIGN KEY (`recipient_Id`) REFERENCES users(`id`)   ON DELETE CASCADE,
  FOREIGN KEY (`product_Id`) REFERENCES products(`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `donations` (`donor_Id`, `recipient_Id`, `date`, `product_Id`, `pickup_Location`, `active`) 
VALUES (1, 2, '2025-06-04', 1,'Monsenhor José Vita, 1200 - Campos do Jordão, SP', 1);

INSERT INTO `donations` (`donor_Id`, `recipient_Id`, `date`, `product_Id`, `pickup_Location`, `active`) 
VALUES (3, 2, '2025-06-04', 2,'Monsenhor José Vita, 1200 - Campos do Jordão, SP', 1);

INSERT INTO `donations` (`donor_Id`, `recipient_Id`, `date`, `product_Id`, `pickup_Location`, `active`) 
VALUES (2, 4, '2025-06-04', 3,'Januário Miraglia, 800 - Campos do Jordão, SP', 1);