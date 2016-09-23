-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 23-09-2016 a las 13:22:12
-- Versión del servidor: 10.1.10-MariaDB
-- Versión de PHP: 5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestionbiblio`
--

DELIMITER $$
--
-- Procedimientos
--
CREATE DEFINER=`neli`@`localhost` PROCEDURE `insertEjemplar` (IN `editorial` VARCHAR(100), IN `numPags` INT, IN `idUsuario` INT, OUT `idEjemplar` INT)  NO SQL
BEGIN
INSERT INTO ejemplar(`editorial`, `numPags`, `idUsuario`) VALUES (LOWER(editorial), numPags, idUsuario);
SET idEjemplar = LAST_INSERT_ID();
END$$

CREATE DEFINER=`neli`@`localhost` PROCEDURE `insertLibro` (IN `titulo` VARCHAR(150), IN `autor` VARCHAR(200), IN `isbn` VARCHAR(13), IN `idEjemplar` INT, OUT `idLibro` INT)  NO SQL
BEGIN
INSERT INTO libro(`titulo`, `autor`, `isbn`, `idEjemplar`) VALUES (LOWER(titulo), LOWER(autor), LOWER(isbn), idEjemplar);
SET idLibro = LAST_INSERT_ID();
END$$

CREATE DEFINER=`neli`@`localhost` PROCEDURE `insertUsuario` (IN `nombre` VARCHAR(50), IN `apellidos` VARCHAR(150), IN `fechaNaci` DATE, IN `email` VARCHAR(150), IN `contrasena` VARCHAR(30), OUT `idUsuario` INT)  NO SQL
BEGIN
INSERT INTO usuario(`nombre`, `apellidos`, `fechaNaci`, `email`, `contrasena`) VALUES (LOWER(nombre), LOWER(apellidos), fechaNaci, LOWER(email), LOWER(contrasena));
SET idUsuario = LAST_INSERT_ID();
END$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplar`
--

CREATE TABLE `ejemplar` (
  `idEjemplar` int(11) NOT NULL,
  `editorial` varchar(100) NOT NULL,
  `numPags` int(11) NOT NULL,
  `idUsuario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `libro`
--

CREATE TABLE `libro` (
  `idLibro` int(11) NOT NULL,
  `titulo` varchar(150) NOT NULL,
  `autor` varchar(200) NOT NULL,
  `isbn` varchar(13) NOT NULL,
  `idEjemplar` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `apellidos` varchar(150) NOT NULL,
  `fechaNaci` date NOT NULL,
  `email` varchar(150) NOT NULL,
  `contrasena` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD PRIMARY KEY (`idEjemplar`),
  ADD KEY `idUsuario` (`idUsuario`);

--
-- Indices de la tabla `libro`
--
ALTER TABLE `libro`
  ADD PRIMARY KEY (`idLibro`),
  ADD KEY `idEjemplar` (`idEjemplar`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `ejemplar`
--
ALTER TABLE `ejemplar`
  ADD CONSTRAINT `fk_usuario_ejemplar` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`);

--
-- Filtros para la tabla `libro`
--
ALTER TABLE `libro`
  ADD CONSTRAINT `fk_libro_ejemplar` FOREIGN KEY (`idEjemplar`) REFERENCES `ejemplar` (`idEjemplar`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
