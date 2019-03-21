CREATE TABLE usuario (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	email VARCHAR(50) NOT NULL,
	senha VARCHAR(150) NOT NULL,
	UNIQUE KEY usuario_email (email)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE permissao (
	codigo BIGINT(20) PRIMARY KEY,
	descricao VARCHAR(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE usuario_permissao (
	codigo_usuario BIGINT(20) NOT NULL,
	codigo_permissao BIGINT(20) NOT NULL,
	PRIMARY KEY (codigo_usuario, codigo_permissao),
	FOREIGN KEY (codigo_usuario) REFERENCES usuario(codigo),
	FOREIGN KEY (codigo_permissao) REFERENCES permissao(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO usuario (nome, email, senha) values ('Administrador', 'peperfeitopodologiago@gmail.com', '$2a$10$iOd18lNwGDl7o12yAd5e5uBWyqLKZyciUUQRnVHWua9Yj8zGzUMI2');
INSERT INTO usuario (nome, email, senha) values ('Rodrigo Delamayer', 'rodrigodelamayer@hotmail.com', '$2a$10$v6vOn68nXLt68yITX8tRIujej6IVPidYt2MGhNlto04Mi8K0qxeiu');
INSERT INTO usuario (nome, email, senha) values ('Keylla Moraes', 'keyllamoraesv@hotmail.com', '$2a$10$y4r8D2yk8uo2dNOOH6hbieKOPp5XIhbbxGhBTHUjuRoDcoitGsgpO');

INSERT INTO permissao (codigo, descricao) values (1, 'ROLE_CADASTRAR_USUARIO');
INSERT INTO permissao (codigo, descricao) values (2, 'ROLE_REMOVER_USUARIO');
INSERT INTO permissao (codigo, descricao) values (3, 'ROLE_PESQUISAR_USUARIO');

INSERT INTO permissao (codigo, descricao) values (4, 'ROLE_CADASTRAR_CONSULTA');
INSERT INTO permissao (codigo, descricao) values (5, 'ROLE_REMOVER_CONSULTA');
INSERT INTO permissao (codigo, descricao) values (6, 'ROLE_PESQUISAR_CONSULTA');

INSERT INTO permissao (codigo, descricao) values (7, 'ROLE_CADASTRAR_PACIENTE');
INSERT INTO permissao (codigo, descricao) values (8, 'ROLE_REMOVER_PACIENTE');
INSERT INTO permissao (codigo, descricao) values (9, 'ROLE_PESQUISAR_PACIENTE');

INSERT INTO permissao (codigo, descricao) values (10, 'ROLE_CADASTRAR_PODOLOGO');
INSERT INTO permissao (codigo, descricao) values (11, 'ROLE_REMOVER_PODOLOGO');
INSERT INTO permissao (codigo, descricao) values (12, 'ROLE_PESQUISAR_PODOLOGO');

INSERT INTO permissao (codigo, descricao) values (13, 'ROLE_CADASTRAR_TIPO_TELEFONE');
INSERT INTO permissao (codigo, descricao) values (14, 'ROLE_REMOVER_TIPO_TELEFONE');
INSERT INTO permissao (codigo, descricao) values (15, 'ROLE_PESQUISAR_TIPO_TELEFONE');

-- admin
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 1);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 2);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 3);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 10);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 11);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 12);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 13);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 14);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (1, 15);

-- rodrigo
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 10);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 11);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 12);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 13);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 14);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (2, 15);

-- keylla
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 4);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 5);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 6);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 7);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 8);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 9);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 10);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 11);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 12);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 13);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 14);
INSERT INTO usuario_permissao (codigo_usuario, codigo_permissao) values (3, 15);
