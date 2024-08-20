
CREATE TABLE `document` (
                            `createdAt` datetime(6) DEFAULT NULL,
                            `id` bigint NOT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `data` longblob,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE document MODIFY COLUMN data LONGBLOB;

CREATE TABLE `teacher_matedidaticos` (
                                         `ProfessorEntity_id` bigint NOT NULL,
                                         `mateDidaticos_id` bigint NOT NULL,
                                         KEY `FKch0jqkxfxia242grgknfl87t4` (`mateDidaticos_id`),
                                         KEY `FK5t4x44id9cnlseird50i8siy` (`ProfessorEntity_id`),
                                         CONSTRAINT `FK5t4x44id9cnlseird50i8siy` FOREIGN KEY (`ProfessorEntity_id`) REFERENCES `teacher` (`id`),
                                         CONSTRAINT `FKch0jqkxfxia242grgknfl87t4` FOREIGN KEY (`mateDidaticos_id`) REFERENCES `document` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

