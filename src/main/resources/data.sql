INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Café da Manhã', 65.00, 'SERVICO');
INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Almoço', 65.00, 'SERVICO');
INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Jantar', 85.00, 'SERVICO');
INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Massagem Completa', 250.00, 'SERVICO');
INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Manicure', 85.00, 'SERVICO');

INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Refrigerantes', 9.00, 'ITEM');
INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Sucos', 13.00, 'ITEM');
INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Cervejas Nacionais', 15.00, 'ITEM');
INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Cervejas Importadas', 25.00, 'ITEM');
INSERT INTO servico_opcional (nome, valor, tipo) VALUES ('Caipirinhas', 35.00, 'ITEM');

-- Standard Simples
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria) VALUES
    ('Standard Simples', 2, 1, '1 x Sofá, 1 x Poltrona, 1 x Frigobar, 1 x TV Led 54 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 350.00);

-- Standard Duplo
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria) VALUES
    ('Standard Duplo', 4, 3, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 54 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 450.00);

-- Luxo Simples
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria) VALUES
    ('Luxo Simples', 2, 1, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 62 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 550.00);

-- Luxo Duplo
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria) VALUES
    ('Luxo Duplo', 4, 3, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 62 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 650.00);

-- Premium Simples
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria) VALUES
    ('Premium Simples', 2, 1, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 62 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 850.00);

-- Premium Duplo
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria) VALUES
    ('Premium Duplo', 4, 2, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 62 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 950.00);

