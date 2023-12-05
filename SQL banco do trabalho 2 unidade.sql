--Criação banco de dados
CREATE DATABASE "TrabalhoBancoDeDados"
    WITH
    OWNER = postgres
    ENCODING = 'UTF8'
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;

--montagem banco de dados do trabalho
--tabela que armazena os predios
create table predio(
	letra_predio varchar(1) primary key
);

--tabela que vai armazenar as salas
create table sala(
	cod_sala varchar(10) primary key,
	nome_sala varchar(20),
	letra_predio varchar(1),
	FOREIGN KEY(letra_predio)REFERENCES predio(letra_predio)
);

--tabela que vai armazenar os equipamentos
create table equipamento(
	cod_equipamento int generated always as identity primary key,
	tipo_equipamento varchar(20),
	marca varchar(30),
	cod_sala varchar(10),
	FOREIGN KEY(cod_sala)REFERENCES sala(cod_sala)
);

--tabela ocorrencia
create table ocorrencia(
	cod_ocorrencia int generated always as identity primary key,
	cod_sala varchar(10),
	cod_equipamento int,
	data_ocorrencia Timestamp,
	solucionado bit,
	FOREIGN KEY(cod_sala)REFERENCES sala(cod_sala),
	FOREIGN KEY(cod_equipamento)REFERENCES equipamento(cod_equipamento)
);
--adicionando coluna descrição
ALTER TABLE ocorrencia add COLUMN descricao varchar(300);
--colocando horario defalt na tabela ocorrencia
ALTER TABLE ocorrencia ALTER COLUMN data_ocorrencia set DEFAULT current_timestamp;
--colocando defalt no solucionado
ALTER TABLE ocorrencia ALTER COLUMN solucionado set DEFAULT '0';

--Populando tabelas

--Tabela predio
insert into predio values
('a'),
('b'),
('c'),
('d'),
('e');

insert into sala (cod_sala, nome_sala, letra_predio) values
('b401', 'lamiI', 'b'),
('b402', 'lamiII', 'b'),
('b403', 'lamiIII', 'b'),
('b404', 'lamiIV', 'b'),
('b405', 'lamiV', 'b'),
('b406', 'lamiVI', 'b'),
('b407', 'lamiVII','b'),
('b408', 'lamiVIII', 'b'),
('b409', 'lamiIV', 'b'),
('b410', 'lamiX', 'b');

insert into equipamento(tipo_equipamento, marca, cod_sala) values
('Ar-condicionado','Carrier','b401'),
('Computador', 'Dell','b401'),
('Ar-condicionado','Carrier','b402'),
('Computador', 'Dell','b405');


--selects
select * from equipamento;
select * from sala;
select * from predio;
select * from ocorrencia;

select * from sala where cod_sala ='b408';
select * from ocorrencia where cod_ocorrencia ='1';

--update
update ocorrencia set solucionado = '1' where cod_ocorrencia=?