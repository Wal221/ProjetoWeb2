ALTER TABLE students_avaliacao
    ADD COLUMN status enum( 'REALIZADO',
    'NAO_REALIZADO', 'PENDENTE','CORRIGIDO', 'CANCELADO') DEFAULT 'NAO_REALIZADO';
