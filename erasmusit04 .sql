-- phpMyAdmin SQL Dump
-- version 3.4.11.1deb2+deb7u8
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 30-05-2018 a las 23:41:21
-- Versión del servidor: 5.5.58
-- Versión de PHP: 5.4.45-0+deb7u11

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `erasmusit04`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `authorities`
--

CREATE TABLE IF NOT EXISTS `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `authorities`
--

INSERT INTO `authorities` (`username`, `authority`) VALUES
('argiris', 'ROLE_USER'),
('kostas', 'ROLE_ADMIN'),
('root', 'ROLE_ADMIN'),
('root', 'ROLE_USER'),
('user2', 'ROLE_USER'),
('user7', 'ROLE_ADMIN');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `customer`
--

CREATE TABLE IF NOT EXISTS `customer` (
  `ID_CUSTOMER` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `surname` varchar(10) DEFAULT NULL,
  `fiscal_id` varchar(11) DEFAULT NULL,
  `date_patent` varchar(11) DEFAULT NULL,
  `history_events` varchar(100) DEFAULT NULL,
  `id_employee` int(11) DEFAULT NULL,
  `id_vehicle` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID_CUSTOMER`),
  KEY `id_vehicle` (`id_vehicle`),
  KEY `id_employee` (`id_employee`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `customer`
--

INSERT INTO `customer` (`ID_CUSTOMER`, `name`, `surname`, `fiscal_id`, `date_patent`, `history_events`, `id_employee`, `id_vehicle`) VALUES
(11, 'YUSU', 'FERNANDEZ', '123456', '12/05/2018', 'NOTHING', 1, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `departament`
--

CREATE TABLE IF NOT EXISTS `departament` (
  `ID_DEPARTAMENT` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(10) DEFAULT NULL,
  `adress` varchar(50) DEFAULT NULL,
  `manager` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID_DEPARTAMENT`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=13 ;

--
-- Volcado de datos para la tabla `departament`
--

INSERT INTO `departament` (`ID_DEPARTAMENT`, `phone`, `adress`, `manager`) VALUES
(10, '666666666', 'KIPSELI', 'ANTONIO'),
(11, '999999999', 'NOWHERE', 'bill gates'),
(12, '122121212', 'NONAME', 'STEVE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `employee`
--

CREATE TABLE IF NOT EXISTS `employee` (
  `ID_EMPLOYEE` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `surname` varchar(50) DEFAULT NULL,
  `adress` varchar(50) DEFAULT NULL,
  `birthday` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_EMPLOYEE`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `employee`
--

INSERT INTO `employee` (`ID_EMPLOYEE`, `name`, `surname`, `adress`, `birthday`) VALUES
(1, 'JAIRO', 'CID', 'KIPSELI', '19/01/1992'),
(2, 'ALVARO', 'FERNANDEZ', 'KIPSELI', '19/01/1992'),
(4, 'JULIO', 'FERNANDEZ', 'KIPSELI', '19/01/1992');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `emplo_depart`
--

CREATE TABLE IF NOT EXISTS `emplo_depart` (
  `departament_id` int(11) NOT NULL DEFAULT '0',
  `employee_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`departament_id`,`employee_id`),
  KEY `FK_EMPLOYEE` (`employee_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `emplo_depart`
--

INSERT INTO `emplo_depart` (`departament_id`, `employee_id`) VALUES
(10, 1),
(11, 1),
(12, 1),
(10, 2),
(12, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`username`, `password`, `enabled`) VALUES
('', '$2a$10$A3x3fJOBU2CjqJcy0mkbeOL/fwaFNj2ezsqp0ZGWB5mcNtMs1FBCS', 1),
('argiris', '$2y$10$W5BhK2Tjo2Mzo5xQzE9hR.6pA.ORHywNnWKwGm0qZlqm4tx3OPPNm', 1),
('kostas', '$2a$10$ImxST8VOhohmUgvlm4KfQOrMEbPAG6ovzkC1XIahljUfI5NEfn3Wm', 1),
('root', '$2a$04$G/kGgvNAyExJRnquvw7ZleZtCbofJjz0AAhUXEr4g1bLEAJwsf77q', 1),
('test', '$2a$10$xPLiOB03q15d9qsfug9ib.OYt3S0BjVKKkEa0V8/KzLAVtfk/cgT.', 1),
('user1', 'user1', 1),
('user2', '$2a$10$4pCGZ6DjMwaKs8yLOahFa.SHQ6ryiEKeEWrjqVXFKiHCFYH/HPrju', 1),
('user3', '$2a$10$uBxmSDwoh3euUWeuSRACdOSSDCyd6hbOQ947fbIKJ6oBLA/lRcS.e', 1),
('user4', '$2a$10$SkoKHRq4KSep6LICSz7JVus7YVzJ9jLCedTv8up3IExLl00ZDV9Ru', 1),
('user5', '$2a$10$34u7gWvpTq7I6T/5iaNTru6vfG7m9XdLsTsIu30DzJgRLMj9ERF8y', 1),
('user6', '$2a$10$rTkwy7JNwPCClHd..yZbTOpVp4kbRSCZd6TtyS8hF60IHgCIRTdHm', 1),
('user7', 'user7', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehicle`
--

CREATE TABLE IF NOT EXISTS `vehicle` (
  `ID_VEHICLE` int(11) NOT NULL AUTO_INCREMENT,
  `year` varchar(5) DEFAULT NULL,
  `cubic` varchar(20) DEFAULT NULL,
  `type` varchar(20) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `attribute` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`ID_VEHICLE`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `vehicle`
--

INSERT INTO `vehicle` (`ID_VEHICLE`, `year`, `cubic`, `type`, `color`, `attribute`) VALUES
(7, '1992', '105', 'AUTOMATIC', 'RED', 'NOTHING');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `authorities`
--
ALTER TABLE `authorities`
  ADD CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `user` (`username`);

--
-- Filtros para la tabla `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `CUSTOMER_ibfk_2` FOREIGN KEY (`id_vehicle`) REFERENCES `vehicle` (`ID_VEHICLE`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `CUSTOMER_ibfk_3` FOREIGN KEY (`id_employee`) REFERENCES `employee` (`ID_EMPLOYEE`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `emplo_depart`
--
ALTER TABLE `emplo_depart`
  ADD CONSTRAINT `FK_DEPARTAMENT_05` FOREIGN KEY (`departament_id`) REFERENCES `departament` (`ID_DEPARTAMENT`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `FK_EMPLOYEE` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`ID_EMPLOYEE`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
