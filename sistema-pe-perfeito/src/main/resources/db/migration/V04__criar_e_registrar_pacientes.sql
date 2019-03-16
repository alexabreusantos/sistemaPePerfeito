CREATE TABLE paciente (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
	sexo VARCHAR(50)NOT NULL,
	data_nascimento DATE,
	email VARCHAR(150),
	logradouro VARCHAR(100),
	numero VARCHAR(30),
	complemento VARCHAR(100),
	bairro VARCHAR(100),
	cep VARCHAR(30),
	cidade VARCHAR(100),
	estado VARCHAR(100),
	UNIQUE KEY paciente_email (email)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Ricardo Pereira', 'Masculino', '1985-01-10', 'ricpereira@yahoo.com.br', 'Rua do Motorista', '123', 'Apto 302', 'Aparecida', '38.400-12', 'Salvador', 'BA');
INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Lita Mariano', 'Feminino', '1995-07-09', 'lita.mariano@gmail.com', 'Av Rio Branco', '321', 'Qd 18 Lt 06', 'Jardins', '56.400-12', 'Natal', 'RN');
INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Pedro Barbosa', 'Masculino', '2000-12-01', 'pedrobar@hotmail.com', 'Av Brasil', '100', 'Qd 29 Lt 10', 'Tubalina', '77.400-12', 'Porto Alegre', 'RS');
INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Antônia Maria', 'Feminino', '1978-09-15', 'antoniamaria@hotmail.com', 'Rua do Sapo', '1120', 'Apto 201', 'Centro', '12.400-12', 'Rio de Janeiro', 'RJ');
INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Carlos Santana', 'Masculino', '1980-02-02', 'carlos.santana80@bol.com.br', 'Rua da Manga', '433', 'Casa 02', 'Centro', '31.400-12', 'Belo Horizonte', 'MG');
INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Leonardo Oliveira', 'Masculino', '1998-08-14', 'leonardo.oliveira@gmail.com', 'Rua do Músico', '566', 'Apto 150', 'Segismundo Pereira', '38.400-00', 'Uberlândia', 'MG');
INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Isabela Martins', 'Feminino', '1983-11-09', 'isamartins@gmail.com', 'Rua da Terra', '1233', 'Apto 10', 'Vigilato', '99.400-12', 'Manaus', 'AM');
INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('João Silva', 'Masculino', '1990-02-12', 'joaosilva@gmail.com', 'Rua do Abacaxi', '10', 'Casa 01', 'Brasil', '38.400-121', 'Uberlândia', 'MG');
INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Maria Rita', 'Feminino', '1985-10-23', 'maria.rita@hotmail.com.br', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-121', 'Ribeirão Preto', 'SP');
INSERT INTO paciente (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Pedro Santos', 'Masculino', '1988-09-12', 'pedrosantos88@yahoo.com.br', 'Rua da Bateria', '23', 'Qd 18 Lt 23', 'Morumbi', '54.212-12', 'Goiânia', 'GO')
