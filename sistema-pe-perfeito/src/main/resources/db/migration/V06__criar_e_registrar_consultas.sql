CREATE TABLE consulta (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	data_hora DATETIME,
	hora VARCHAR(5),
	codigo_paciente BIGINT(20) NOT NULL,
	codigo_podologo BIGINT(20) NOT NULL,
	valor DECIMAL(10,2),
	situacao VARCHAR(50),
	observacao VARCHAR(700),
	UNIQUE KEY consulta_data_hora (data_hora),
	FOREIGN KEY (codigo_paciente) REFERENCES paciente(codigo),
	FOREIGN KEY (codigo_podologo) REFERENCES podologo(codigo)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO consulta (data_hora, codigo_paciente, codigo_podologo, valor, situacao, observacao) values ('2019-04-01 12:00' , 2, 1, 120.00, 'Agendada', 'Confirmar consulta um dia antes.');
INSERT INTO consulta (data_hora, codigo_paciente, codigo_podologo, valor, situacao, observacao) values ('2019-04-01 13:00' , 3, 1, 220.00, 'Confirmada', 'Verificar ficha do paciente.');