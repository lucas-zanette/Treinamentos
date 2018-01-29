create database aula;

-- criar uma tabela.
-- unsigned usa todos positivos até 4bilhoes de registros

create table pessoa (codigo int(4) unsigned not null auto_increment,
					nome varchar(200),
                    endereco varchar(200),
                    email varchar(200),
                    
                    primary key (codigo)
                    );
                    
drop table pesquisa_sorvete;

drop database Censo;

-- inserir novo registro
insert into pessoa(nome, endereco, email) values('alekeek', 'Rua F', 'fatima@fat.com.br');

delete from pessoa where codigo = 5;

select * from pessoa;

select count(*), endereco from pessoa group by endereco;


create table pesquisa_sorvete (codigo int(4) unsigned not null auto_increment,
					sabor varchar(200),
                    marca varchar(200),
                    
                    primary key (codigo)
                    );
                    
commit;                   
                    
select * from pesquisa_sorvete;
-- delete from pesquisa_sorvete where codigo > 0;

-- select para ver o ultimo codigo inserido
-- select last_insert_id();

create table Pessoas;
drop table Eletro;

create table Pessoas (codigo int(4) unsigned not null auto_increment,
					nome varchar(200),
                    endereco varchar(200),
                    email varchar(200),
                    
                    primary key (codigo)
                    );

create table Eletro (codigo int(4) unsigned not null auto_increment,
					nome varchar(200),
                    qtd varchar(200),                    
                    codigopessoa int(4) unsigned not null,
                    
                    primary key (codigo)
                    );
                    
alter table Eletro add constraint cEletro foreign key (codigopessoa) references Pessoas(codigo);
                    
create table Pet (codigo int(4) unsigned not null auto_increment,
					nome varchar(200),
                    especie varchar(200),
                    raca varchar(200),
                    codigopessoa int(4) unsigned not null,
                    
                    primary key (codigo)
                    );

alter table Pet add constraint cPet foreign key (codigopessoa) references Pessoas(codigo);


select * from Pet;

commit;