drop database if exists colecciones;

create database colecciones;

use colecciones; 
    
create table Municipio (
        Id integer not null AUTO_INCREMENT,
        nombre varchar(255),
        codProvincia integer,
        codMunicipio varchar(255),
        primary key (Id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
    
create table Direccion (
        Id integer not null AUTO_INCREMENT,
        municipio_id integer NOT NULL,
        calle varchar(255),
        numero integer,       
        provincia varchar(255),
        primary key (Id),
        CONSTRAINT `FKMUN` FOREIGN KEY (`municipio_id`) REFERENCES `Municipio` (`Id`)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
    
create table Nombre (
        Id integer not null AUTO_INCREMENT,
        nombre varchar(255),
        ape1 varchar(255),
        ape2 varchar(255),
        primary key (Id)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
    
 create table Profesor (
        Id integer not null AUTO_INCREMENT,
        direccion_id integer NOT NULL,
        nombre_id integer NOT NULL,        
        primary key (Id),
        CONSTRAINT `FKDIR` FOREIGN KEY (`direccion_id`) REFERENCES `Direccion` (`Id`),
        CONSTRAINT `FKNOM` FOREIGN KEY (`nombre_id`) REFERENCES `Nombre` (`Id`)
    )ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;    
  
CREATE TABLE `correo` (
    Id integer not null AUTO_INCREMENT,
    `profesor_id` integer not null,   
    `direccion` VARCHAR(50) DEFAULT NULL,
    `proveedor` VARCHAR(50) DEFAULT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT `FKPROF` FOREIGN KEY (`profesor_id`) REFERENCES `profesor` (`Id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

insert into Nombre(nombre,ape1,ape2) values('juan','garcia','lopez');
insert into Nombre(nombre,ape1,ape2) values('ramon','fernandez','lopez');
insert into Nombre(nombre,ape1,ape2) values('maria','rodriguez','casado');
insert into Nombre(nombre,ape1,ape2) values('pepe','garcia','moreno');
insert into Municipio(nombre,codProvincia,codMunicipio) values('Alcobendas',1,1);
insert into Municipio(nombre,codProvincia,codMunicipio) values('Colmenar',1,2);
insert into Municipio(nombre,codProvincia,codMunicipio) values('Pozuelo',2,1);
insert into Municipio(nombre,codProvincia,codMunicipio) values('Las Rozas',2,2);
insert into Direccion(municipio_id,calle,numero,provincia) values(1,'calle 1',2,'Madrid');
insert into Direccion(municipio_id,calle,numero,provincia) values(2,'calle 2',3,'Madrid');
insert into Direccion(municipio_id,calle,numero,provincia) values(3,'calle 3',4,'Madrid');
insert into Direccion(municipio_id,calle,numero,provincia) values(4,'calle 4',5,'Madrid');
insert into Profesor(direccion_id,nombre_id) values(1,1);
insert into Profesor(direccion_id,nombre_id) values(2,2);
insert into Profesor(direccion_id,nombre_id) values(3,3);
insert into Profesor(direccion_id,nombre_id) values(4,4);
insert into Correo(profesor_id,direccion,proveedor) values(1,'mail@gmail.com','gmail');
insert into Correo(profesor_id,direccion,proveedor) values(1,'mail@yahoo.com','yahoo');
insert into Correo(profesor_id,direccion,proveedor) values(2,'mail2@yahoo.com','yahoo');
insert into Correo(profesor_id,direccion,proveedor) values(3,'mail3@gmail.com','gmail');
insert into Correo(profesor_id,direccion,proveedor) values(3,'mail3@yahoo.com','yahoo');


