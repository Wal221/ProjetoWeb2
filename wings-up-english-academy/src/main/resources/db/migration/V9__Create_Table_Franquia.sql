
CREATE TABLE `franquia` (
                            `id` bigint NOT NULL AUTO_INCREMENT,
                            `numAlunos` bigint NOT NULL,
                            `Endereco` varchar(255) NOT NULL,
                            `desepenhoGeral` varchar(255) NOT NULL,
                            `nomeCidade` varchar(255) NOT NULL,
                            `telefone` varchar(255) NOT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

