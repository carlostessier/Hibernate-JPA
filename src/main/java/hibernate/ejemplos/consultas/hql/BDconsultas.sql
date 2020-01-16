

drop database if exists consultas;

create database consultas;

use consultas; 

create table CicloFormativo(
        IdCiclo integer not null AUTO_INCREMENT,
        nombreCiclo varchar(255),
        horas integer,
        primary key (IdCiclo)
    )ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
    
create table Profesor (
        Id integer not null AUTO_INCREMENT,
        nombre varchar(255),
        ape1 varchar(255),
        ape2 varchar(255),
        primary key (Id)
    )ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

    
    insert into profesor(nombre,ape1,ape2) values('juan','garcia','lopez');
    insert into profesor(nombre,ape1,ape2) values('ramon','fernandez','lopez');
    insert into profesor(nombre,ape1,ape2) values('maria','rodriguez','casado');
    insert into profesor(nombre,ape1,ape2) values('pepe','garcia','moreno');
    
    insert into CicloFormativo(nombreCiclo,horas) values('daw',150);
    insert into CicloFormativo(nombreCiclo,horas) values('dam',170);
    insert into CicloFormativo(nombreCiclo,horas) values('asir',220);
    