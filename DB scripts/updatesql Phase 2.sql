ALTER TABLE `product_order` CHANGE `date_ordered` `date_ordered` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, CHANGE `seller_confirmation` `seller_confirmation` INT(11) NOT NULL DEFAULT '0', CHANGE `buyer_confirmation` `buyer_confirmation` INT NOT NULL DEFAULT '0';

CREATE TABLE `prod_images` (
  `product_id` int(11) NOT NULL,
  `image_name` varchar(260) NOT NULL,
  `image_type` varchar(20) NOT NULL,
  `image` longblob NOT NULL,
  KEY `prod_images_fk` (`product_id`),
  CONSTRAINT `prod_images_fk` FOREIGN KEY (`product_id`) REFERENCES `product` (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci