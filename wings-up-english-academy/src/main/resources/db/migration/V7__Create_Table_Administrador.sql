
CREATE TABLE `administrador` (
                                 `id` bigint NOT NULL AUTO_INCREMENT,
                                 `email` varchar(255) NOT NULL,
                                 `name` varchar(255) NOT NULL,
                                 `telephone` varchar(255) NOT NULL,
                                 PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

