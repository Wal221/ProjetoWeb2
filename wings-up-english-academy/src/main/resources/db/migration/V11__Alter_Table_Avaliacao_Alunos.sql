ALTER TABLE avaliacao_alunos
    ADD COLUMN status enum( 'REALIZADO',
    'NAO_REALIZADO') DEFAULT 'NAO_REALIZADO';

ALTER TABLE avaliacao_alunos
    MODIFY alunos_id BIGINT NULL;
