ALTER TABLE students_avaliacao
    ADD COLUMN status enum( 'REALIZADO',
    'NAO_REALIZADO') DEFAULT 'NAO_REALIZADO';


