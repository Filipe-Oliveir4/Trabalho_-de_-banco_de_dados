--montagem banco de dados do trabalho
--tabela que armazena os predios
create table predio(
	letra_predio varchar(1) primary key;
)

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
	solucionado bit
);

--adicionando fk
ALTER TABLE IF EXISTS public.ocorrencia
    ADD CONSTRAINT cod_autor_fkey FOREIGN KEY (cod_autor)
    REFERENCES public.Autor (cod_autor);

--colocando horario defalt na tabela ocorrencia
ALTER TABLE ocorrencia ALTER COLUMN data_ocorrencia set DEFAULT current_timestamp;

--colocando defalt no solucionado
ALTER TABLE ocorrencia ALTER COLUMN solucionado set DEFAULT binary(0);

--colocando a coluna descricao na tabela ocorrencia
ALTER TABLE ocorrencia ALTER COLUMN solucionado type boolean;
--select
select * from ocorrencia;
-- insert
insert into ocorrencia(cod_sala,cod_equipamento,solucionado) values('teste',3,'0');
insert into ocorrencia(descricao) values('teste') WHERE cod_ocorrencia = 1;