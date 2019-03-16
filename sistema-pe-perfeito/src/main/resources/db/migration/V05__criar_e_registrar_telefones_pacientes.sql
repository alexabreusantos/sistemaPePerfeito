CREATE TABLE telefone_paciente (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	codigo_paciente BIGINT(20) NOT NULL,
	numero VARCHAR(20) NOT NULL,
	codigo_tipo_telefone BIGINT(20) NOT NULL,
	UNIQUE KEY telefone_paciente_numero (numero),	
	FOREIGN KEY (codigo_paciente) REFERENCES paciente(codigo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into telefone_paciente (codigo_paciente, numero, codigo_tipo_telefone) values (1, '(62) 9 9910-8403', 1);
insert into telefone_paciente (codigo_paciente, numero, codigo_tipo_telefone) values (2, '(62) 9 9911-8400', 2);
insert into telefone_paciente (codigo_paciente, numero, codigo_tipo_telefone) values (3, '(62) 3334-1550', 3);
insert into telefone_paciente (codigo_paciente, numero, codigo_tipo_telefone) values (4, '(62) 9 8921-0012', 4);
insert into telefone_paciente (codigo_paciente, numero, codigo_tipo_telefone) values (5, '(62) 9 9986-4523', 5);
insert into telefone_paciente (codigo_paciente, numero, codigo_tipo_telefone) values (2, '(62) 3425-1789', 3);
insert into telefone_paciente (codigo_paciente, numero, codigo_tipo_telefone) values (4, '(62) 3212-1206', 3);
insert into telefone_paciente (codigo_paciente, numero, codigo_tipo_telefone) values (4, '(62) 9 8723-0213', 5);