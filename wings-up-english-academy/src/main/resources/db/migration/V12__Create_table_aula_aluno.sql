
CREATE TABLE `students_aulas` (
                                  `AlunoEntity_id` bigint NOT NULL,
                                  `aulas_id` bigint NOT NULL,
                                  UNIQUE KEY `UK_2ivcgsirjdw66ikapqv4sq440` (`aulas_id`),
                                  KEY `FKd7v3c7egkbrtm9uox2jawupn` (`AlunoEntity_id`),
                                  CONSTRAINT `FK49sq94vm96y7y75xu3cuwq7h4` FOREIGN KEY (`aulas_id`) REFERENCES `aula` (`id`),
                                  CONSTRAINT `FKd7v3c7egkbrtm9uox2jawupn` FOREIGN KEY (`AlunoEntity_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

