-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         11.8.6-MariaDB - MariaDB Server
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.14.0.7165
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para veterinaria_system
CREATE DATABASE IF NOT EXISTS `veterinaria_system` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `veterinaria_system`;

-- Volcando estructura para tabla veterinaria_system.citas
CREATE TABLE IF NOT EXISTS `citas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) NOT NULL,
  `id_doctor` int(11) DEFAULT NULL,
  `fecha` varchar(50) DEFAULT NULL,
  `hora` varchar(20) DEFAULT NULL,
  `tipo_cita` varchar(100) DEFAULT NULL,
  `urgencia` varchar(20) DEFAULT 'Baja',
  `medicamento` varchar(100) DEFAULT NULL,
  `costo` double DEFAULT 0,
  `estado` varchar(30) DEFAULT 'Pendiente',
  `diagnostico` text DEFAULT NULL,
  `fecha_cita` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `idx_citas_paciente` (`id_paciente`),
  KEY `idx_citas_doctor` (`id_doctor`),
  CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id`) ON DELETE CASCADE,
  CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`id_doctor`) REFERENCES `users` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.citas: ~7 rows (aproximadamente)
INSERT INTO `citas` (`id`, `id_paciente`, `id_doctor`, `fecha`, `hora`, `tipo_cita`, `urgencia`, `medicamento`, `costo`, `estado`, `diagnostico`, `fecha_cita`) VALUES
	(1, 1, 2, '2026-05-12', '10:00 AM', 'Consulta rutinaria', 'Media', 'Antibiótico clavoxivet', 995, 'En proceso', 'Infección respiratoria', '2026-05-27 22:07:28'),
	(2, 2, 3, '2026-05-15', '11:30 AM', 'Consulta urgencias', 'Alta', 'Antiparasitarios', 2300, 'Pendiente', 'Infección urinaria', '2026-05-27 22:07:28'),
	(3, 3, 4, '2026-05-18', '09:00 AM', 'Vacunación', 'Baja', 'Ninguno', 1500, 'Completada', 'Vacunación anual', '2026-05-27 22:07:28'),
	(4, 4, 5, '2026-05-20', '03:00 PM', 'Desparasitación', 'Baja', 'Desparacitante Care Max', 685, 'Pendiente', 'Desparasitación', '2026-05-27 22:07:28'),
	(5, 1, 2, '2026-06-10', '10:30 AM', 'Consulta de seguimiento', 'Baja', 'Ninguno', 700, 'Pendiente', 'Seguimiento de infección', '2026-05-27 22:07:28'),
	(6, 2, 3, '2026-06-15', '12:00 PM', 'Consulta especializada', 'Media', 'Antibiótico', 2000, 'Pendiente', 'Revisión especialista', '2026-05-27 22:07:28'),
	(7, 6, 3, '2026-05-29', '12:00 PM', 'Consulta a domicilio', 'Media', 'Antiparasitarios', 2100, 'Pendiente', '', '2026-05-27 23:51:03');

-- Volcando estructura para tabla veterinaria_system.duenos
CREATE TABLE IF NOT EXISTS `duenos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(150) DEFAULT NULL,
  `mascota` varchar(100) DEFAULT NULL,
  `colonia` varchar(100) DEFAULT NULL,
  `direccion` text DEFAULT NULL,
  `foto` text DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `idx_dueno_correo` (`correo`),
  KEY `idx_dueno_nombre` (`nombre`,`apellidos`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.duenos: ~5 rows (aproximadamente)
INSERT INTO `duenos` (`id`, `nombre`, `apellidos`, `telefono`, `correo`, `mascota`, `colonia`, `direccion`, `foto`, `fecha_registro`) VALUES
	(1, 'Carlos', 'Ramírez', '6121112233', 'carlos.ramirez@email.com', 'Max', 'Centro', 'Calle Hidalgo #123, Col. Centro', NULL, '2026-05-27 22:07:28'),
	(2, 'Fernanda', 'López', '6125551122', 'fernanda.lopez@email.com', 'Luna', 'Roma', 'Avenida Sol #456, Col. Roma', NULL, '2026-05-27 22:07:28'),
	(3, 'Roberto', 'Sánchez', '6127778899', 'roberto.sanchez@email.com', 'Rocky', 'Del Valle', 'Boulevard Insurgentes #789', NULL, '2026-05-27 22:07:28'),
	(4, 'María', 'Fernández', '6126663344', 'maria.fernandez@email.com', 'Bella', 'Juárez', 'Calle Reforma #321', NULL, '2026-05-27 22:07:28'),
	(8, 'diego', 'navarro', '6121234567', 'diego@gmail.com', 'Hachi', 'Miramar', 'Calle 6', 'C:\\Users\\diego\\OneDrive\\Imágenes\\330397.jpg', '2026-05-27 23:48:49');

-- Volcando estructura para tabla veterinaria_system.pacientes
CREATE TABLE IF NOT EXISTS `pacientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `especie` varchar(50) DEFAULT NULL,
  `raza` varchar(50) DEFAULT NULL,
  `edad` varchar(20) DEFAULT NULL,
  `sexo` varchar(20) DEFAULT NULL,
  `diagnostico` text DEFAULT NULL,
  `historial` text DEFAULT NULL,
  `foto` text DEFAULT NULL,
  `id_dueno` int(11) DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `idx_paciente_dueno` (`id_dueno`),
  CONSTRAINT `pacientes_ibfk_1` FOREIGN KEY (`id_dueno`) REFERENCES `duenos` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.pacientes: ~5 rows (aproximadamente)
INSERT INTO `pacientes` (`id`, `nombre`, `especie`, `raza`, `edad`, `sexo`, `diagnostico`, `historial`, `foto`, `id_dueno`, `fecha_registro`) VALUES
	(1, 'Max', 'Perro', 'Labrador', '5 años', 'Macho', 'Infección respiratoria', 'Paciente con tos y fiebre', NULL, 1, '2026-05-27 22:07:28'),
	(2, 'Luna', 'Gato', 'Siamés', '3 años', 'Hembra', 'Infección urinaria', 'Presenta dificultad al orinar', NULL, 2, '2026-05-27 22:07:28'),
	(3, 'Rocky', 'Perro', 'Pastor Alemán', '4 años', 'Macho', 'Vacunación anual', 'Vacunación completa', NULL, 3, '2026-05-27 22:07:28'),
	(4, 'Bella', 'Perro', 'Poodle', '2 años', 'Hembra', 'Desparasitación', 'Desparasitación interna y externa', NULL, 4, '2026-05-27 22:07:28'),
	(6, 'Hachi', 'Perro', 'Pug', '8 años', 'Macho', 'Gordito', 'Nada raro', 'C:\\Users\\diego\\OneDrive\\Imágenes\\539fe6a2a5666b8e49b5b8e47495bfe3.jpg', 8, '2026-05-27 23:50:01');

-- Volcando estructura para tabla veterinaria_system.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `correo` varchar(150) NOT NULL,
  `password` varchar(100) NOT NULL,
  `foto` text DEFAULT NULL,
  `activo` tinyint(1) DEFAULT 1,
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`),
  KEY `idx_user_correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.users: ~5 rows (aproximadamente)
INSERT INTO `users` (`id`, `nombre`, `apellidos`, `telefono`, `correo`, `password`, `foto`, `activo`) VALUES
	(1, 'Admin', 'Sistema', '6125555555', 'admin@veterinaria.com', 'admin123', NULL, 1),
	(2, 'Carlos', 'Ramírez', '6121111111', 'carlos@veterinaria.com', '1234', NULL, 1),
	(3, 'Fernanda', 'López', '6122222222', 'fernanda@veterinaria.com', '1234', NULL, 1),
	(4, 'Luis', 'Martínez', '6123333333', 'luis@veterinaria.com', '1234', NULL, 1),
	(5, 'Ana', 'García', '6124444444', 'ana@veterinaria.com', '1234', NULL, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
