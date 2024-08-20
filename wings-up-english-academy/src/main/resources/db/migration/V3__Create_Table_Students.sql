
CREATE TABLE `students` (
                            `grade` double NOT NULL,
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `turma_id` bigint DEFAULT NULL,
                            `email` varchar(255) NOT NULL,
                            `enroll` varchar(255) NOT NULL,
                            `name` varchar(255) NOT NULL,
                            `telephone` varchar(255) NOT NULL,
                            PRIMARY KEY (`id`),
                            KEY `FKpsuxvjgr25adjds1mhgqlx9tj` (`turma_id`),
                            CONSTRAINT `FKpsuxvjgr25adjds1mhgqlx9tj` FOREIGN KEY (`turma_id`) REFERENCES `turma` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




INSERT INTO `students` VALUES (8.8,1,NULL,'walmi@gmail.com','2022101','walmir','12345678'),(8.9,2,NULL,'Valdir@gmail.com','2022101','Valdir','12345678');

