create database escola;

use escola;

CREATE TABLE disciplinas(
    id int PRIMARY KEY auto_increment,
    nome VARCHAR(40) not null
);

INSERT INTO disciplinas(nome)
values ('geografia'), ('artes'), ('historia'), ('matematica'), ('portugues'), ('quimica');

select * from disciplinas;

CREATE TABLE alunos(
    id int PRIMARY KEY auto_increment,
    nome VARCHAR(40) not null
);

select * from alunos;

INSERT INTO alunos(nome)
values ('Renata'), ('Carlos'), ('Henrique'), ('Brenda'), ('Leonardo'), ('Rafael'),('Micael'),('Tobias'),
('Tomas'),('Josias'),('Renan'),('Leandro');

CREATE TABLE alunos_disciplinas(
    id_aluno int not null,
    id_disciplina int not null,
        CONSTRAINT pertence_a_alunos
        FOREIGN KEY (id_aluno)
            REFERENCES alunos(id)
            ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT pertence_a_disciplinas
        FOREIGN KEY (id_disciplina)
            REFERENCES disciplinas(id)
            ON UPDATE CASCADE ON DELETE CASCADE
);

INSERT INTO alunos_disciplinas
values (1,1), (2,2), (3,1), (4,1), (4,4), (4,2);

select * from alunos_disciplinas;

CREATE TABLE tarefas(
	id INT auto_increment PRIMARY KEY,
	resposta VARCHAR(40) NOT NULL,
    data_tarefa DATE NOT NULL,
    id_aluno int not null,
    id_disciplina int not null,
	CONSTRAINT pertence_a_alunos
        FOREIGN KEY (id_aluno)
            REFERENCES alunos(id)
            ON UPDATE CASCADE ON DELETE CASCADE,
    CONSTRAINT pertence_a_disciplinas
        FOREIGN KEY (id_disciplina)
            REFERENCES disciplinas(id)
            ON UPDATE CASCADE ON DELETE CASCADE
);

insert into tarefas(resposta,data_tarefa,id_aluno,id_disciplina)
values('resp1','2020-02-02',1,1),('resp2','2020-04-02',2,2),
('resp3','2021-01-11',3,1),('resp4','2021-11-11',4,1),('resp5','2021-11-12',4,4),
('resp6','2021-05-11',4,2),('resp7','2021-05-11',4,1),('resp8','2021-05-11',4,3),
('resp9','2021-05-11',9,4),('resp10','2021-05-11',2,2),('resp11','2021-05-11',6,2),
('resp12','2021-05-11',7,2),('resp13','2021-05-11',5,2),('resp14','2021-05-11',5,2),
('resp15','2021-05-11',11,2),('resp16','2021-05-11',1,2),('resp17','2021-05-11',4,2),
('resp18','2021-05-11',5,2),('resp19','2021-05-11',7,2),('resp20','2021-05-11',11,2),
('resp21','2021-05-11',3,2),('resp22','2021-05-11',5,2),('resp23','2021-05-11',11,2),
('resp24','2021-05-11',2,2),('resp25','2021-05-11',2,2),('resp26','2021-05-11',5,2),
('resp27','2021-05-11',5,2),('resp28','2021-05-11',5,2),('resp29','2021-05-11',6,2),
('resp30','2021-05-11',5,2),('resp31','2021-05-11',4,2),('resp2','2021-05-11',11,2),
('resp33','2021-05-11',11,2),('resp34','2021-05-11',6,6),('resp35','2021-05-11',12,6),
('resp36','2021-05-11',2,6),('resp37','2021-05-11',6,5),('resp38','2021-05-11',11,2),
('resp39','2021-05-11',2,5),('resp40','2021-05-11',10,4),('resp41','2021-05-11',10,5),
('resp42','2021-05-11',5,1),('resp43','2021-05-11',11,3),('resp44','2021-05-11',9,2),
('resp45','2021-05-11',11,2),('resp46','2021-05-11',6,1),('resp47','2021-05-11',8,2),
('resp48','2021-05-11',1,3),('resp49','2021-05-11',12,2),('resp50','2021-05-11',8,2),
('resp51','2021-05-11',10,3),('resp52','2021-05-11',10,2),('resp53','2021-05-11',7,2),
('resp54','2021-05-11',3,3),('resp55','2021-05-11',10,2),('resp56','2021-05-11',8,2),
('resp57','2021-05-11',1,3),('resp58','2021-05-11',10,2),('resp59','2021-05-11',8,2),
('resp60','2021-05-11',12,3),('resp61','2021-05-11',12,2),('resp62','2021-05-11',5,2),
('resp63','2021-05-11',10,3),('resp64','2021-05-11',12,2),('resp65','2021-05-11',5,2),
('resp66','2021-05-11',1,3),('resp67','2021-05-11',10,2),('resp68','2021-05-11',8,2),
('resp69','2021-05-11',12,3),('resp70','2021-05-11',12,2),('resp71','2021-05-11',5,2),
('resp72','2021-05-11',10,3),('resp73','2021-05-11',12,2),('resp74','2021-05-11',5,2),
('resp73','2021-05-11',10,3),('resp74','2021-05-11',12,2),('resp75','2021-05-11',5,2),
('resp76','2021-05-11',4,2),('resp77','2021-05-11',4,2),('resp78','2021-05-11',4,2);

select * from tarefas;

-- A)Todos os alunos postam tarefas das disciplinas em que estão cursando. A coordenação do
-- curso quer dar um presente para os 10 alunos que mais postam tarefas nas suas disciplinas. 
-- Liste esses alunos mostrando quantas tarefas eles postaram.

SELECT alunos.nome as nome_aluno, count(tarefas.id_aluno) as quantidade_tarefas
	FROM alunos INNER JOIN tarefas ON alunos.id = tarefas.id_aluno
    GROUP BY alunos.id ORDER BY quantidade_tarefas DESC
    LIMIT 10;
    
    select * from tarefas;
    
-- B)Aproveite também e liste as disciplinas que tem mais que 50 tarefas postadas pelos alunos 
-- no semestre 2021-1. 
SELECT 		disciplinas.nome as nome_disciplina, count(tarefas.id) as quantidade_tarefas
FROM 		disciplinas
			INNER JOIN  tarefas
				ON disciplinas.id= tarefas.id_disciplina
WHERE 		tarefas.data_tarefa >= '2021-01-01'
GROUP BY	disciplinas.nome
HAVING		count(tarefas.id) > 50
ORDER BY 	quantidade_tarefas DESC