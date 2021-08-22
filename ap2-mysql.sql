create schema imobiliaria;
use imobiliaria;
SET SQL_SAFE_UPDATES=0;

create table imoveis(
id int auto_increment primary key,
id_tipo_imovel_fk int not null,
endereco varchar(150) not null,
preco decimal(15,5) not null,
descricao varchar(300),
id_imovel_cliente_fk int,
constraint imovel_cliente
	foreign key (id_imovel_cliente_fk)
		references id(cliente)
);

insert into imoveis (id_tipo_imovel_fk, endereco, preco, descricao, id_imovel_cliente_fk) values 
('2', 'Ulbra', '555', 'Universidade do RS', 1),
('1', 'Casa Azul', '1355.20', 'Casa confortável',2),
('2', 'Casa Vermelha', '9686.20', 'Casa de 5 andares',3),
('2', 'Casa Vermelha', '32323232', 'Casa de 5 andares',4),
('2', 'Casa roja', '10', 'Casa de 5 andares',5);

select * from imoveis;

create table publicacao(
id int primary key auto_increment,
descricao varchar(250),
data_publicacao date,
id_publicacao_imovel_fk int,
constraint publicação_imovel
	foreign key (id_publicacao_imovel_fk)
		references id(imovel)
);

insert into publicacao (id, descricao, id_publicacao_imovel_fk) values 
('1', 'Lindas fotos tiradas desse belo apartamento', '1'),
('2', 'Foto boa', '1');

select * from publicacao;

create table cliente(
id int auto_increment primary key,
nome varchar(50) not null,
cpf decimal(11) not null,
endereco varchar(60) not null
);

update cliente set endereco='Rua xxx' where id=1;
insert into cliente (nome, cpf, endereco) values 
('Rafael Silva', '555555555659', 'rua'),
('Renan Pinho', '256666666666', 'rua 2'),
('Carlos Borba', '99855565632', 'rua 3'),
('Kenedy Borba', '66666776644', 'rua 4');

select * from cliente;

create table gestor(
 id int auto_increment primary key,
 nome varchar(20) not null,
 cpf bigint,
 rg bigint,
 data_nascimento date
);

insert into gestor (nome, cpf)
values ('Rafael DSIL', '23675325896'),
('Kenedy Borba', '03194326785');

select * from gestor;

create table contrato_aluguel (
id int not null primary key auto_increment,
inquilino_fk varchar(75) not null,
valor_mensal decimal(8,2),
data_expiracao_contrato date,
data_pagamento_definido date,
id_imovel_fk int,
id_cliente_fk int,
id_gestor_contrato_fk int,
 constraint imovel_contrato
		foreign key (id_imovel_fk)
			references id(imovel_fk),
constraint dados_cliente
	foreign key (id_cliente_fk)
		references id(cliente),
constraint gestor_contrato
	foreign key (id_gestor_contrato_fk)
		references id(gestor)
);

insert into contrato_aluguel (inquilino_fk,valor_mensal, id_imovel_fk, id_cliente_fk, id_gestor_contrato_fk) 
values ('3','293.96','1','2','1'),('4','2993.96','1','2','1'),('1','253.96','1','2','1'),('2','568,33','1','2','1');

select * from contrato_aluguel;

create table boleto_aluguel (
id int not null primary key auto_increment,
inquilino_fk varchar(75) not null,
valor_contrato_fk decimal(8,2),
data_vencimento date,
pagamento varchar(50) NOT NULL,
id_contrato_fk int,
constraint dados_contrato_boleto
	foreign key (id_contrato_fk)
		references id(contrato_aluguel),
constraint dados_contrato_cliente
	foreign key (inquilino_fk)
		references id(cliente)
);

insert into boleto_aluguel (inquilino_fk, valor_contrato_fk, pagamento, id_contrato_fk) 
values ('1','1','pago','1'),('1',1,'não pago','1');

select * from boleto_aluguel;

-- ------------------------------------------------------------------------------------------------------
-- VIEW

CREATE VIEW os_tres_maiores_valores AS
SELECT id AS Código, 
       valor_mensal
FROM contrato_aluguel
ORDER BY valor_mensal DESC
LIMIT 3;
select * from os_cinco_maiores_valores;

CREATE VIEW soma_contrato AS
SELECT id AS Código,
	   SUM(valor_mensal) AS soma_contratos
FROM contrato_aluguel;
SELECT * FROM soma_contrato;

CREATE VIEW imoveis_de_clientes AS
SELECT i.id AS codigo,
       c.nome AS nome_cliente
FROM imoveis i INNER JOIN cliente c ON c.id = i.id_imovel_cliente_fk;
    
SELECT * from imoveis_de_clientes;

-- ------------------------------------------------------------------------------------------------------
-- STORES PEOCEDURES

-- atualizar o cadastro do cliente
DELIMITER $$
CREATE PROCEDURE atualizar_comprador(nome VARCHAR(50), cpf BIGINT, endereco VARCHAR(150), id INT)
BEGIN
UPDATE cliente SET nome = nome, cpf = cpf, endereco = endereco WHERE cliente.id = id ;
END; $$
DELIMITER ;
CALL atualizar_comprador('Carlos', '0', 'rua teste', '2');
SELECT * FROM cliente;

-- mostra a quantidade de imoveis selecionados
DELIMITER $$
CREATE PROCEDURE selecionar_imoveis(IN quantidade INT)
BEGIN
SELECT * FROM imoveis
LIMIT quantidade;
END $$
DELIMITER ;
CALL selecionar_imoveis(7);

-- mostra quantos imoveis tem na tabela
DELIMITER $$
CREATE PROCEDURE verificar_quantidade_imoveis(OUT quantidade INT)
BEGIN
SELECT COUNT(*) INTO quantidade FROM imoveis;
END $$
DELIMITER ;
CALL verificar_quantidade_imoveis(@total);
SELECT @total;

-- retorna os clientes com nome rafael ou kenedy ou todos
DELIMITER $$
CREATE PROCEDURE lista_clientes(IN opcao INTEGER)
BEGIN
    if opcao = 0 then
        select * from cliente where nome like 'rafael%';
    else if opcao = 1 THEN
          select * from cliente where nome like 'kenedy%';
        else
          select * from cliente;
        end if;
    end if;
  end $$
DELIMITER ;
CALL lista_clientes(6);