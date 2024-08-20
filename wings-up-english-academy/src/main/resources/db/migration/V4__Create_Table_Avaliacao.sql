
CREATE TABLE `avaliacao` (
                             `valorAvalicao` double DEFAULT NULL,
                             `dataAvalicao` datetime(6) DEFAULT NULL,
                             `id` bigint NOT NULL AUTO_INCREMENT,
                             `professor_id` bigint DEFAULT NULL,
                             `tipoAvalicao` enum('PROVA','TRABALHO','APRESENTACAO') DEFAULT NULL,
                             PRIMARY KEY (`id`),
                             KEY `FKovjkocfr86w9fc8exussl0ond` (`professor_id`),
                             CONSTRAINT `FKovjkocfr86w9fc8exussl0ond` FOREIGN KEY (`professor_id`) REFERENCES `teacher` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

