CREATE TABLE telefone_podologo (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_podologo BIGINT(20) NOT NULL,
	numero VARCHAR(20) NOT NULL,
	codigo_tipo_telefone BIGINT(20) NOT NULL,
	UNIQUE KEY telefone_podologo_numero (numero),
	FOREIGN KEY (codigo_tipo_telefone) REFERENCES tipo_telefone(codigo),
	FOREIGN KEY (codigo_podologo) REFERENCES podologo(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into telefone_podologo (codigo_podologo, numero, codigo_tipo_telefone) values (1, '(62) 9 9910-8403', 1);