drop database if exists autores;

create database autores;

use autores; 

CREATE TABLE `Autor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nombre` varchar(20) DEFAULT NULL,
  `apellidos` varchar(20) DEFAULT NULL,
  `fecha` datetime DEFAULT NULL,
  `publicacion` boolean,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;