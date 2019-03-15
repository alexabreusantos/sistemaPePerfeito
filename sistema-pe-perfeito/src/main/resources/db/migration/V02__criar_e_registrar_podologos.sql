CREATE TABLE podologo (
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
	UNIQUE KEY podologo_email (email)
)  ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO podologo (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('João Silva', 'Masculino', '1990-02-12', 'joaosilva@gmail.com', 'Rua do Abacaxi', '10', null, 'Brasil', '38.400-121', 'Uberlândia', 'MG');
INSERT INTO podologo (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Maria Rita', 'Feminino', '1985-10-23', 'maria.rita@hotmail.com.br', 'Rua do Sabiá', '110', 'Apto 101', 'Colina', '11.400-121', 'Ribeirão Preto', 'SP');
INSERT INTO podologo (nome, sexo, data_nascimento, email, logradouro, numero, complemento, bairro, cep, cidade, estado) values ('Pedro Santos', 'Masculino', '1996-03-08', 'pedrosantos96@yahoo.com', 'Rua da Bateria', '23', null, 'Morumbi', '54.212-121', 'Goiânia', 'GO');