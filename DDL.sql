drop schema if exists spring;

drop user if exists 'user'@'localhost';

create schema spring;

create user 'user'@'localhost' identified by 'pass123';

grant select, insert, delete, update on spring.* to user@'localhost';

use spring;

create table usr_usuario (
  usr_id bigint unsigned not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(150) not null,
  primary key (usr_id),
  unique key uni_usuario_nome (usr_nome)
);

create table aut_autorizacao (
  aut_id bigint unsigned not null auto_increment,
  aut_nome varchar(20) not null,
  primary key (aut_id),
  unique key uni_aut_nome (aut_nome)
);

create table uau_usuario_autorizacao (
  usr_id bigint unsigned not null,
  aut_id bigint unsigned not null,
  primary key (usr_id, aut_id),
  foreign key aut_usuario_fk (usr_id) references usr_usuario (usr_id) on delete restrict on update cascade,
  foreign key aut_autorizacao_fk (aut_id) references aut_autorizacao (aut_id) on delete restrict on update cascade
);

create table ant_anotacao (
  ant_id bigint unsigned not null auto_increment,
  ant_texto varchar(256) not null,
  ant_data_hora datetime not null,
  ant_usr_id bigint unsigned not null,
  primary key (ant_id),
  foreign key ant_usr_fk (ant_usr_id) references usr_usuario(usr_id)
);

create table tra_trabalho (
  tra_id bigint primary key auto_increment,
  tra_titulo varchar(100) not null unique,
  tra_data_hora_entrega datetime not null,
  tra_descricao varchar(200),
  tra_grupo varchar(20) not null,
  tra_nota bigint,
  tra_justificativa varchar(100)
);

create table alu_aluno(
  alu_id bigint primary key auto_increment,
  alu_nome_completo varchar(100) not null,
  alu_email_institucional varchar(100) not null,
  alu_data_matricula date not null,
  alu_indice float
);

insert into alu_aluno (alu_nome_completo, alu_email_institucional, alu_data_matricula, alu_indice) values ('Charles Smith', 'csmith@email.com', curdate(), 7.2), ('Ann Doe', 'adoe@email.com', '2024-02-15', 6.3);

insert into usr_usuario (usr_nome, usr_senha)
  values ('admin', '$2a$10$i3.Z8Yv1Fwl0I5SNjdCGkOTRGQjGvHjh/gMZhdc3e7LIovAklqM6C');
insert into aut_autorizacao (aut_nome)
  values ('ROLE_ADMIN');
insert into uau_usuario_autorizacao (usr_id, aut_id) 
  values (1, 1);
insert into ant_anotacao(ant_texto, ant_data_hora, ant_usr_id)
  values('Meu novo projeto', '2023-08-01 19:10', 1);

insert into tra_trabalho (tra_titulo, tra_data_hora_entrega, tra_grupo, tra_nota, tra_justificativa)
 values ('Teste 1', current_timestamp(), 'Alpha', 6, 'Bom, mas falta conteúdo'),
 ('Teste 2', current_timestamp(), 'Beta', 3, 'Incompleto');  