
CREATE TABLE `avaliacao_alunos` (
                                    `AvaliacaoEntity_id` bigint NOT NULL,
                                    `alunos_id` bigint NOT NULL,
                                    KEY `FKsf5d7mtnr62tunwaahwrbk494` (`alunos_id`),
                                    KEY `FKgqdvaagybp23q0pp0x0gg6ogk` (`AvaliacaoEntity_id`),
                                    CONSTRAINT `FKgqdvaagybp23q0pp0x0gg6ogk` FOREIGN KEY (`AvaliacaoEntity_id`) REFERENCES `avaliacao` (`id`),
                                    CONSTRAINT `FKsf5d7mtnr62tunwaahwrbk494` FOREIGN KEY (`alunos_id`) REFERENCES `students` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
