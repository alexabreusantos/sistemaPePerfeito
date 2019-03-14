CREATE TABLE tipo_telefone (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	UNIQUE KEY tipo_telefone_nome (nome)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO tipo_telefone (nome) values ('Celular');
INSERT INTO tipo_telefone (nome) values ('Comercial');
INSERT INTO tipo_telefone (nome) values ('Recado');
INSERT INTO tipo_telefone (nome) values ('Residencial');
INSERT INTO tipo_telefone (nome) values ('Whatsapp');