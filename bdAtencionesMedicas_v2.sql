CREATE DATABASE IF NOT EXISTS `bdatenciones_medicas`;
USE `bdatenciones_medicas`;


CREATE TABLE `doctor` (
 
 `id_doc` int(11) primary key auto_increment,
  
`nomape` varchar(150) NOT NULL,
  
`dni` varchar(8) NOT NULL,
  
`telefono` varchar(11) NOT NULL,
  
`email` varchar(150) NOT NULL,
  
`especialidad` varchar(50) NOT NULL,
  
`fechap` datetime NOT NULL DEFAULT current_timestamp());

CREATE TABLE `paciente` (
`id_paciente` int(11) primary key auto_increment,
`nomape` varchar(150) NOT NULL,
`dni` varchar(8) NOT NULL,
`telefono` varchar(11) NOT NULL,
`email` varchar(150) NOT NULL,
`direccion` varchar(50) NOT NULL,
 `gerenciapa` varchar(50) NOT NULL,
 `conlaboralpa` varchar(50) NOT NULL,
`diagnostico` varchar(250) NOT NULL,
`seguropa` varchar(50) NOT NULL,
`fecha_nac` date NOT NULL,
`fechap` timestamp  NOT NULL DEFAULT current_timestamp());


CREATE TABLE `tsocial` (
  
`id_tsocial` int(11) primary key auto_increment,
  
`nomape` varchar(150) NOT NULL,
  
`dni` int(11) NOT NULL,
  
`telefono` varchar(11) NOT NULL,
  
`email` varchar(150) NOT NULL,
  
`fechap` datetime NOT NULL DEFAULT current_timestamp());

CREATE TABLE `historiacli` (
  `id_historia` int(11) primary key auto_increment,
  `id_paciente` int(11) NOT NULL,
  `id_doc` int(11) NOT NULL,
  `id_ts` int(11) NOT NULL,
  `situacion` varchar(250) NOT NULL,
  `observa` varchar(250) NOT NULL,
  `sino` tinyint(1) NOT NULL,
  `pres` varchar(250) NOT NULL,
  `estadoh` int(11) NOT NULL,
  `fechah` date NOT NULL,
  `fecharegh` datetime NOT NULL DEFAULT current_timestamp(),
FOREIGN KEY (`id_paciente`) REFERENCES paciente(`id_paciente`),
FOREIGN KEY (`id_doc`) REFERENCES doctor(`id_doc`),
FOREIGN KEY (`id_ts`) REFERENCES tsocial(`id_tsocial`)
);

CREATE TABLE `asig_atencion` (
  `id_atencion` varchar(10) primary key,
  `id_paciente` int(11) NOT NULL,
  `id_doc` int(11) NOT NULL,
  `id_ts` int(11) NOT NULL,
  `situacion` varchar(250) NOT NULL,
  `fecha_asig` timestamp NOT NULL DEFAULT current_timestamp,
FOREIGN KEY (`id_paciente`) REFERENCES paciente(`id_paciente`),
FOREIGN KEY (`id_doc`) REFERENCES doctor(`id_doc`),
FOREIGN KEY (`id_ts`) REFERENCES tsocial(`id_tsocial`) );


DELIMITER $$
CREATE PROCEDURE registrar_pacientes (nomape varchar(150), dni varchar(8), telefono varchar(11), correo_e varchar(50),
direccion varchar(50) , gerenciapa varchar(50) , cond_laboral varchar(50) ,diagnostico varchar(250) ,seguropa varchar(50) ,fecha_nacimiento date)
BEGIN
insert into paciente (nomape,dni,telefono,email,direccion,gerenciapa,conlaboralpa,diagnostico,seguropa,fecha_nac) values 
(nomape,dni,telefono,correo_e,direccion,gerenciapa,cond_laboral,diagnostico,seguropa,fecha_nacimiento);
END
$$


DELIMITER $$
CREATE PROCEDURE actualizar_pacientes(nomape varchar(150), dni varchar(8),telefono varchar(11),correo_e varchar(50),
direccion varchar(50) , gerenciapa varchar(50) , cond_laboral varchar(50) ,diagnostico varchar(250) ,seguropa varchar(50) ,fecha_nacimiento date,id_pacientes int(11))
BEGIN
update paciente set nomape=nomape,dni=dni,telefono=telefono,email=correo_e,direccion=direccion,gerenciapa=gerenciapa,conlaboralpa=cond_laboral, 
diagnostico=diagnostico,seguropa=seguropa,fecha_nac=fecha_nacimiento where id_paciente=id_pacientes;
END
$$

DELIMITER $$
CREATE PROCEDURE listar_pacientes()
BEGIN
select * from paciente order by id_paciente;
END
$$

DELIMITER $$
CREATE PROCEDURE eliminar_pacientes(idpacientes int )
BEGIN
delete from paciente where id_paciente=idpacientes;
END
$$


DELIMITER $$
CREATE PROCEDURE registrar_tsocial (nomape varchar(150), dni varchar(8), telefono varchar(11), correo_e varchar(50) )
BEGIN
insert into tsocial (nomape,dni,telefono,email) values (nomape,dni,telefono,correo_e);
END
$$


DELIMITER $$
CREATE PROCEDURE actualizar_tsocial(nomape varchar(150), dni varchar(8),telefono varchar(11),correo_e varchar(50),id_tsocial1 int(11))
BEGIN
update tsocial set nomape=nomape,dni=dni,telefono=telefono,email=correo_e where id_tsocial=id_tsocial1;
END
$$

DELIMITER $$
CREATE PROCEDURE listar_tsocial()
BEGIN
select * from tsocial order by id_tsocial;
END
$$

DELIMITER $$
CREATE PROCEDURE eliminar_tsocial(idsocial int )
BEGIN
delete from tsocial where id_tsocial=idsocial;
END
$$



DELIMITER $$
CREATE PROCEDURE registrar_doctor (nomape varchar(150), dni varchar(8), telefono varchar(11), correo_e varchar(50),especialidad varchar(50))
BEGIN
insert into doctor (nomape,dni,telefono,email,especialidad) values (nomape,dni,telefono,correo_e,especialidad);
END
$$


DELIMITER $$
CREATE PROCEDURE actualizar_doctor(nomape varchar(150), dni varchar(8),telefono varchar(11),correo_e varchar(50),especialidad varchar(50),id_doctor int(11))
BEGIN
update doctor set nomape=nomape,dni=dni,telefono=telefono,email=correo_e,especialidad=especialidad where id_doc=id_doctor;
END
$$

DELIMITER $$
CREATE PROCEDURE listar_doctor()
BEGIN
select * from doctor order by id_doc;
END
$$

DELIMITER $$
CREATE PROCEDURE eliminar_doctor(iddoctor int )
BEGIN
delete from doctor where id_doc=iddoctor;
END
$$

DELIMITER $$
CREATE PROCEDURE registrar_atenciones (idAtencion varchar(10), idPaciente int, idDoctor int, idTSocial int,situacion varchar(250) )
BEGIN
insert into asig_atencion (id_atencion,id_paciente,id_doc,id_ts,situacion) values (idAtencion,idPaciente,idDoctor,idTSocial, situacion);
END
$$


DELIMITER $$
CREATE PROCEDURE numero_atencion ()
BEGIN
select count(id_atencion) from asig_atencion;
END
$$


DELIMITER $$
CREATE PROCEDURE recuperaridPaciente(nomape varchar(50))
BEGIN
SELECT id_paciente FROM paciente WHERE nomape=nomape;
END
$$

DELIMITER $$
CREATE PROCEDURE recuperaridDoctor(nomape varchar(50))
BEGIN
SELECT id_doc FROM doctor WHERE nomape=nomape;
END
$$

DELIMITER $$
CREATE PROCEDURE recuperaridTSocial(nomape varchar(50))
BEGIN
SELECT id_tsocial FROM tsocial WHERE nomape=nomape;
END
$$