LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/1T2023.csv'
INTO TABLE intuitivecare.operadoras
FIELDS TERMINATED BY ';'
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 LINES
(data,registroAns,cdContaContabil,descricao,valorSaldoInicial,valorSaldoFinal)
SET
    valorSaldoInicial = REPLACE(valorSaldoInicial, ',', '.'),
    valorSaldoFinal = REPLACE(valorSaldoFinal, ',', '.');

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/2T2023.csv'
    INTO TABLE intuitivecare.operadoras
    FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (data,registroAns,cdContaContabil,descricao,valorSaldoInicial,valorSaldoFinal)
    SET
        valorSaldoInicial = REPLACE(valorSaldoInicial, ',', '.'),
        valorSaldoFinal = REPLACE(valorSaldoFinal, ',', '.');

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/3T2023.csv'
    INTO TABLE intuitivecare.operadoras
    FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (data,registroAns,cdContaContabil,descricao,valorSaldoInicial,valorSaldoFinal)
    SET
        valorSaldoInicial = REPLACE(valorSaldoInicial, ',', '.'),
        valorSaldoFinal = REPLACE(valorSaldoFinal, ',', '.');

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/4T2023.csv'
    INTO TABLE intuitivecare.operadoras
    FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (data,registroAns,cdContaContabil,descricao,valorSaldoInicial,valorSaldoFinal)
    SET
        valorSaldoInicial = REPLACE(valorSaldoInicial, ',', '.'),
        valorSaldoFinal = REPLACE(valorSaldoFinal, ',', '.'),
        data = REPLACE(data, '/', '-');


LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/1T2024.csv'
    INTO TABLE intuitivecare.operadoras
    FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (data,registroAns,cdContaContabil,descricao,valorSaldoInicial,valorSaldoFinal)
    SET
        valorSaldoInicial = REPLACE(valorSaldoInicial, ',', '.'),
        valorSaldoFinal = REPLACE(valorSaldoFinal, ',', '.');

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/2T2024.csv'
    INTO TABLE intuitivecare.operadoras
    FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (data,registroAns,cdContaContabil,descricao,valorSaldoInicial,valorSaldoFinal)
    SET
        valorSaldoInicial = REPLACE(valorSaldoInicial, ',', '.'),
        valorSaldoFinal = REPLACE(valorSaldoFinal, ',', '.');

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/3T2024.csv'
    INTO TABLE intuitivecare.operadoras
    FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (data,registroAns,cdContaContabil,descricao,valorSaldoInicial,valorSaldoFinal)
    SET
        valorSaldoInicial = REPLACE(valorSaldoInicial, ',', '.'),
        valorSaldoFinal = REPLACE(valorSaldoFinal, ',', '.');

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/4T2024.csv'
    INTO TABLE intuitivecare.operadoras
    FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
    LINES TERMINATED BY '\n'
    IGNORE 1 LINES
    (data,registroAns,cdContaContabil,descricao,valorSaldoInicial,valorSaldoFinal)
    SET
        valorSaldoInicial = REPLACE(valorSaldoInicial, ',', '.'),
        valorSaldoFinal = REPLACE(valorSaldoFinal, ',', '.');

LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/Relatorio_cadop.csv'
    INTO TABLE intuitivecare.`cadastro ans`
    FIELDS TERMINATED BY ';'
    ENCLOSED BY '"'
    IGNORE 1 LINES;


SELECT
    ans.nomeFantasia,
    SUM(CAST(REPLACE(op.valorSaldoFinal, ',', '.') AS DECIMAL(10, 2))) AS totalDespesas
FROM
    intuitiveCare.`Cadastro ANS` ans
        JOIN
    intuitiveCare.Operadoras op ON ans.registroAns = op.registroAns
WHERE
    op.descricao = 'EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR'
  AND STR_TO_DATE(op.data, '%d/%m/%Y') >= '2023-09-30'
  AND STR_TO_DATE(op.data, '%d/%m/%Y') <= '2023-12-31'
GROUP BY
    ans.nomeFantasia
ORDER BY
    totalDespesas DESC
LIMIT 10;



SELECT
    ans.nomeFantasia,
    SUM(CAST(REPLACE(op.valorSaldoFinal, ',', '.') AS DECIMAL(10, 2))) AS totalDespesas
FROM
    intuitiveCare.`Cadastro ANS` ans
        JOIN
    intuitiveCare.Operadoras op ON ans.registroAns = op.registroAns
WHERE
    op.descricao = 'EVENTOS/ SINISTROS CONHECIDOS OU AVISADOS DE ASSISTÊNCIA A SAÚDE MEDICO HOSPITALAR'
  AND STR_TO_DATE(op.data, '%d/%m/%Y') >= '2023-01-01'
  AND STR_TO_DATE(op.data, '%d/%m/%Y') <= '2023-12-31'
GROUP BY
    ans.nomeFantasia
ORDER BY
    totalDespesas DESC
LIMIT 10
;




