CREATE DATABASE laurear;
USE laurear;

-- Tabela Endereco
CREATE TABLE Endereco (
    idEndereco CHAR(36) PRIMARY KEY,
    logradouro VARCHAR(255),
    numero INT,
    complemento VARCHAR(255),
    cidade VARCHAR(255),
    estado VARCHAR(2),
    pais VARCHAR(50),
    cep VARCHAR(20)
);

-- Tabela Aluno
CREATE TABLE Aluno (
    idAluno CHAR(36) PRIMARY KEY,
    matricula INT NOT NULL,
    nome VARCHAR(255),
    sobrenome VARCHAR(255),
    telefone VARCHAR(20),
    email VARCHAR(255),
    senha VARCHAR(255),
    pontos INT,
    dataNascimento DATETIME,
    idEndereco CHAR(36),
    FOREIGN KEY (idEndereco) REFERENCES Endereco(idEndereco)
);

-- Tabela Faculdade
CREATE TABLE Faculdade (
    idFaculdade CHAR(36) PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(20),
    email VARCHAR(255),
    senha VARCHAR(255),
    idEndereco CHAR(36),
    FOREIGN KEY (idEndereco) REFERENCES Endereco(idEndereco)
);

-- Tabela Cupons
CREATE TABLE Cupons (
    idCupom CHAR(36) PRIMARY KEY,
    nome VARCHAR(255),
    tipo VARCHAR(50),
    validade DATE,
    status ENUM('Disponivel', 'Indisponivel'),
    valor INT,
    idAluno CHAR(36),
    idFaculdade CHAR(36),
    FOREIGN KEY (idAluno) REFERENCES Aluno(idAluno),
    FOREIGN KEY (idFaculdade) REFERENCES Faculdade(idFaculdade)
);

-- Tabela Avaliacao
CREATE TABLE Avaliacao (
    idAvaliacao CHAR(36) PRIMARY KEY,
    descricao TEXT,
    feedback VARCHAR(255),
    data DATETIME,
    idAluno CHAR(36),
    FOREIGN KEY (idAluno) REFERENCES Aluno(idAluno)
);

-- Tabela para Enum de Status de Cupom (opcional, depende da implementação)
CREATE TABLE Status (
    idStatus INT PRIMARY KEY AUTO_INCREMENT,
    nome ENUM('Disponivel', 'Indisponivel') NOT NULL
);

