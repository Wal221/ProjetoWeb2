ALTER TABLE `aula`
    ADD COLUMN `teacher_id` bigint;

ALTER TABLE `aula`
    ADD CONSTRAINT `fk_teacher`
        FOREIGN KEY (`teacher_id`) REFERENCES `teacher`(`id`)
            ON DELETE SET NULL
            ON UPDATE CASCADE;
