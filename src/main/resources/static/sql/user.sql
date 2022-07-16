CREATE TABLE `user` (
                        `id` int NOT NULL AUTO_INCREMENT,
                        `sex` int DEFAULT NULL,
                        `email` varchar(255) DEFAULT NULL,
                        `password` varchar(255) DEFAULT NULL,
                        `phone_num` varchar(255) DEFAULT NULL,
                        `private_key` varchar(255) DEFAULT NULL,
                        `company_id` int DEFAULT NULL,
                        `public_key` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

