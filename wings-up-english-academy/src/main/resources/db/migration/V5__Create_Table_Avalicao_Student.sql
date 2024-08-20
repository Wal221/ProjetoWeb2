
CREATE TABLE `students_avaliacao` (
                                      `AlunoEntity_id` bigint NOT NULL,
                                      `avaliacao_id` bigint NOT NULL,
                                      KEY `FKnx86u55mxnulxxadbgb6pqlfv` (`avaliacao_id`),
                                      KEY `FK29iim3847lnsn6rh24xvndwt2` (`AlunoEntity_id`),
                                      CONSTRAINT `FK29iim3847lnsn6rh24xvndwt2` FOREIGN KEY (`AlunoEntity_id`) REFERENCES `students` (`id`),
                                      CONSTRAINT `FKnx86u55mxnulxxadbgb6pqlfv` FOREIGN KEY (`avaliacao_id`) REFERENCES `avaliacao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
