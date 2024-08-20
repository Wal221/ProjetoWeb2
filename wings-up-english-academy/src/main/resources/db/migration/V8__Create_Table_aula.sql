
CREATE TABLE `aula` (
                        `frequenciaAula` double NOT NULL,
                        `grade` double NOT NULL,
                        `resultadoAvaliacao` double NOT NULL,
                        `diaAula` datetime(6) NOT NULL,
                        `horaAula` datetime(6) NOT NULL,
                        `id` bigint NOT NULL AUTO_INCREMENT,
                        `presenca` datetime(6) NOT NULL,
                        `DTYPE` varchar(31) NOT NULL,
                        `enroll` varchar(255) NOT NULL,
                        `topicosAbordados` varchar(255) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


