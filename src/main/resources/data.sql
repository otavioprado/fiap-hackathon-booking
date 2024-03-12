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

---- Gestão de quartos
--- Localidade
INSERT INTO localidade (nome, amenidades, endereco, cep, numero, complemento, bairro, cidade, estado) VALUES
    ('Fazenda da Pós Tech', '1 x Piscina Adulto, aquecida e coberta, 1 x Piscina Adulto, não aquecida em área aberta, 1 x Piscina Infantil, aquecida e coberta, 1 x Piscina Infantil, não aquecida em área aberta, 2 x Restaurantes no estilo Self Service, 1 x Restaurante a La Carte, 1 x Área Kids, com brinquedoteca, vídeo games e biblioteca, Equipe de Entretenimento Infantil (diversas idades) e adulto', 'Rua da Pós Tech', '01000-002', '567', 'Pós Tech', 'Pós Tech', 'Cidade Pós Tech', 'Estado da Pós Tech');

--- Prédio
INSERT INTO predio (nome, localidade_id) VALUES ('Casa Principal', 1);

--- Quarto
-- Standard Simples
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria, predio_id) VALUES
    ('Standard Simples', 2, 1, '1 x Sofá, 1 x Poltrona, 1 x Frigobar, 1 x TV Led 54 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 350.00, 1);

-- Standard Duplo
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria, predio_id) VALUES
    ('Standard Duplo', 4, 3, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 54 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 450.00, 1);

-- Luxo Simples
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria, predio_id) VALUES
    ('Luxo Simples', 2, 1, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 62 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 550.00, 1);

-- Luxo Duplo
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria, predio_id) VALUES
    ('Luxo Duplo', 4, 3, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 62 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 650.00, 1);

-- Premium Simples
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria, predio_id) VALUES
    ('Premium Simples', 2, 1, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 62 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 850.00, 1);

-- Premium Duplo
INSERT INTO quarto (tipo, total_pessoas, total_camas, outros_moveis, valor_diaria, predio_id) VALUES
    ('Premium Duplo', 4, 2, '1 x Sofá, 2 x Poltronas, 1 x Frigobar, 1 x TV Led 62 pols., 1 x Mesa de Escritório, 1 x Cadeira de Escritório', 950.00, 1);

INSERT INTO cliente
(nome_completo, data_nascimento, cpf, passaporte, pais_de_origem, endereco, email, telefone, sexo)
VALUES
    ('Jack Sparrow', '1690-01-01', '00000000000', 'P1R4T3S', 'Caribe', 'Navio Pérola Negra, Mar do Caribe', 'jack.sparrow@caribe.com', '0000-0000', 'MASCULINO');
