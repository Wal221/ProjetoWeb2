
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
                           `salary` double NOT NULL,
                           `horarioAula` datetime(6) NOT NULL,
                           `id` bigint NOT NULL AUTO_INCREMENT,
                           `email` varchar(255) NOT NULL,
                           `especializacao` varchar(255) NOT NULL,
                           `name` varchar(255) NOT NULL,
                           `telephone` varchar(255) NOT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO `teacher` VALUES (1200,'2021-11-23 00:00:00.000000',1,'julio@email.com','Ingles Basico','Julio','1111111'),(1200,'2021-11-23 00:00:00.000000',2,'nattane@email.com','Ingles Basico','Nattane','1111111');


DROP TABLE IF EXISTS `turma`;

CREATE TABLE `turma` (
                         `id` bigint NOT NULL AUTO_INCREMENT,
                         `numVagas` int DEFAULT NULL,
                         `classSchedule` datetime(6) NOT NULL,
                         `teacherID` bigint DEFAULT NULL,
                         `teachingMaterials` varchar(255) NOT NULL,
                         `englishLevel` enum('BASICO','INTERMEDIARIO','AVANCADO') NOT NULL,
                         PRIMARY KEY (`id`),
                         UNIQUE KEY `UK_1871stuv1jn5pknsns2fmn4m6` (`teacherID`),
                         CONSTRAINT `FKbmk0d2r2ajo3bwibyelguutao` FOREIGN KEY (`teacherID`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;




INSERT INTO `turma` VALUES (null,15,'2023-10-10 00:00:00.000000',1,'slides','AVANCADO'),(null,15,'2024-08-16 10:00:00.000000',2,'Livros A, B','BASICO');


