drop database if exists seguros3;

create database seguros3;

use seguros3; 

CREATE TABLE IF NOT EXISTS `coberturas` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`oftalmologia` char(1) NOT NULL,
`dental` char(1) NOT NULL,
`fecundacionInVitro` char(1) NOT NULL,
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `enfermedades` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`corazon` char(1) NOT NULL,
`estomacal` char(1) NOT NULL,
`rinones` char(1) NOT NULL,
`alergia` char(1) NOT NULL,
`nombreAlergia` varchar(255),
PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `nif` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`nif` varchar(10) NOT NULL,
 PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `seguro` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_nif` int(11) NOT NULL ,
  `id_coberturas` int(11) NOT NULL,
  `id_enfermedades` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `ape1` varchar(255) DEFAULT NULL,
  `ape2` varchar(255) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `sexo` int(11) DEFAULT NULL,
  `embarazada` boolean DEFAULT NULL,
  `casado` char(1) DEFAULT NULL,
  `numHijos` int(11) DEFAULT NULL,
  `fechaCreacion` datetime DEFAULT NULL, 
  PRIMARY KEY (`id`),
  CONSTRAINT `FKCOB` FOREIGN KEY (`id_coberturas`) REFERENCES `coberturas` (`id`),
  CONSTRAINT `FKENF` FOREIGN KEY (`id_enfermedades`) REFERENCES `enfermedades` (`id`),
  CONSTRAINT `FKNIF` FOREIGN KEY (`id_nif`) REFERENCES `nif` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `asistenciaMedica` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_seguro` int(11),
  `breveDescripcion` varchar(255) DEFAULT NULL,
  `lugar` varchar(255) DEFAULT NULL,
  `explicacion` longtext DEFAULT NULL,
  `tipoAsistencia` varchar(255) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `importe` decimal(19,2) DEFAULT NULL,  
  PRIMARY KEY (`id`),
  CONSTRAINT `FKSEG` FOREIGN KEY (`id_seguro`) REFERENCES `seguro` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Ejecutar estos insert antes que PruebaCorrecto.java*/
insert into coberturas(oftalmologia,dental,fecundacionInVitro) values ('F','T','T');
insert into enfermedades(corazon,estomacal,rinones,alergia,nombreAlergia) values ('Y','N','Y','N',null);
insert into nif(nif) values('9784563J');
insert into seguro(id_nif,id_coberturas,id_enfermedades,nombre,ape1,ape2,edad,sexo,embarazada,casado,numHijos,fechaCreacion) values(1,1,1,'maria','garcia','lozano',39,0,true,false,5,'2015-10-30');
insert into asistenciaMedica(id_seguro,breveDescripcion,lugar,explicacion,tipoAsistencia,fecha,hora,importe) values(1,'descripcion a','Pozuelo','explicacion a','DOMICILIARIA','2015-11-23','12:47:00',15000);
insert into asistenciaMedica(id_seguro,breveDescripcion,lugar,explicacion,tipoAsistencia,fecha,hora,importe) values(1,'descripcion a','Alcobendas','explicacion b','HOSPITALARIA','2015-12-1','14:23:00',25000);

