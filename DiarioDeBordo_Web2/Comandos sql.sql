drop table Telefone;
drop table Escolaridade;
drop table Profissao;
drop table MeEncontre_OutrasRedes;
drop table CAPITULO_ARQUIVO;
drop table Arquivo;
drop table CompanheirosDeViagem;
drop table Usuario;
drop table Localizacao;
drop table Capitulo;

create table Arquivo
(
	tipo varchar(30) not null,
	descricao varchar(300) not null,
	conteudo varchar(300) not null,
	primary key(conteudo)
);

create table Usuario
(
	nome varchar(30) not null,
	email varchar(30) not null,
	senha varchar(30) not null,
        fotoPerfil varchar(300),
	primary key(email)
);

create table Telefone
(
	codigoPais varchar(30),
	ddd varchar(30),
	numero varchar(30),
        id int auto_increment,
	primary key(id),

        usuario varchar(30),
	FOREIGN KEY (usuario) REFERENCES Usuario(email)
);

create table Escolaridade
(
	nomeEscola varchar(30),
	nivelFormacao varchar(30),
	tempoGastoNaFormacao int,
        id int auto_increment,
	primary key(id),

        usuario varchar(30),
	FOREIGN KEY (usuario) REFERENCES Usuario(email)
);

create table Profissao
(
	nome varchar(30),
	empresa varchar(30),
	experiencia_anos int,
        id int auto_increment,
	primary key(id),

        usuario varchar(30),
	FOREIGN KEY (usuario) REFERENCES Usuario(email)
);

create table MeEncontre_OutrasRedes
(
	facebook varchar(30),
	twitter varchar(30),
	instagram varchar(30),
        id int auto_increment,
	primary key(id),

        usuario varchar(30),
	FOREIGN KEY (usuario) REFERENCES Usuario(email)
);

create table Localizacao
(
	pais varchar(30),
	estado varchar(30),
	cidade varchar(30),
	id int not null auto_increment,
	primary key(id),

        usuario_id varchar(30) not null,
        FOREIGN KEY (usuario_id) REFERENCES Usuario(email)
);

create table Capitulo
(
  fotoCapa varchar(300),
	nome varchar(30) not null,
	descricao varchar(300) not null,
	inicio date not null,
	fim date not null,
	id int not null auto_increment,
  DIRETORIO_CAPITULO varchar(300) not null,
	primary key(id),

  usuario_id varchar(30) not null,
  FOREIGN KEY (usuario_id) REFERENCES Usuario(email),

	localizacao_id int not null,
	FOREIGN KEY (localizacao_id) REFERENCES Localizacao(id)
);

create table CAPITULO_ARQUIVO
(
    ID_CAPITULO INT,
    ID_ARQUIVO VARCHAR(300),
    FOREIGN KEY (ID_CAPITULO) REFERENCES Capitulo(id),
    FOREIGN KEY (ID_ARQUIVO) REFERENCES Arquivo(conteudo)
);

create table CompanheirosDeViagem
(
	criancas int,
	qtdAnimaisDeEstimacao int,
	qtdAmigos int,
        pessoaComQuemTenhoRelacionamentoSerio boolean,
	id int not null auto_increment,
	primary key(id),

        usuario varchar(30) not null,
        FOREIGN KEY (usuario) REFERENCES Usuario(email)
);

select * from Usuario;
select * from Arquivo;
select * from Capitulo;
select * from Localizacao;
select * from Telefone;
select * from Escolaridade;
select * from Profissao;
select * from CAPITULO_ARQUIVO;
select * from MeEncontre_OutrasRedes;
select * from CompanheirosDeViagem;
