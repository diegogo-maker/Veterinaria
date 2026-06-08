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
  `id_medicamento` int(11) DEFAULT NULL,
  `costo` double DEFAULT 0,
  `estado` varchar(30) DEFAULT 'Pendiente',
  `diagnostico` text DEFAULT NULL,
  `duracion_minutos` int(11) DEFAULT 30,
  `fecha_cita` timestamp NULL DEFAULT current_timestamp(),
  `notas_internas` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_citas_paciente` (`id_paciente`),
  KEY `idx_citas_doctor` (`id_doctor`),
  KEY `idx_citas_medicamento` (`id_medicamento`),
  CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id`) ON DELETE CASCADE,
  CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`id_doctor`) REFERENCES `users` (`id`) ON DELETE SET NULL,
  CONSTRAINT `citas_ibfk_3` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamentos` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.citas: ~3 rows (aproximadamente)
INSERT INTO `citas` (`id`, `id_paciente`, `id_doctor`, `fecha`, `hora`, `tipo_cita`, `urgencia`, `medicamento`, `id_medicamento`, `costo`, `estado`, `diagnostico`, `duracion_minutos`, `fecha_cita`, `notas_internas`) VALUES
	(3, 3, 5, '2026-06-03', '01:00 PM', 'Vacunación', 'Media', 'Vacuna Quíntuple', NULL, 1950, 'Pendiente', '', 30, '2026-06-04 00:50:32', NULL),
	(4, 2, 1, '2026-06-03', '03:00 PM', 'Consulta rutinaria', 'Media', 'Desparacitante Care Max', NULL, 785, 'Pendiente', '', 30, '2026-06-04 00:51:20', NULL),
	(5, 1, 3, '2026-06-04', '01:00 PM', 'Desparasitación', 'Alta', 'Analgésico Vet', NULL, 780, 'En proceso', '', 30, '2026-06-04 00:51:58', NULL);

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
  `telefono_emergencia` varchar(20) DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `idx_dueno_correo` (`correo`),
  KEY `idx_dueno_nombre` (`nombre`,`apellidos`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.duenos: ~3 rows (aproximadamente)
INSERT INTO `duenos` (`id`, `nombre`, `apellidos`, `telefono`, `correo`, `mascota`, `colonia`, `direccion`, `foto`, `telefono_emergencia`, `fecha_registro`) VALUES
	(1, 'Carlos', 'Ramirez', '6127776666', 'carlos.ramirez@email.com', 'Max', 'Centro', 'Calle Hidalgo #123, Col. Centro', NULL, '6129998888', '2026-06-03 20:17:14'),
	(2, 'Fernanda', 'Lopez', '6125551122', 'fernanda.lopez@email.com', 'Luna', 'Nueva Roma', 'Avenida Sol #456, Col. Roma', NULL, '6127776666', '2026-06-03 20:17:14'),
	(3, 'Roberto', 'Sanchez', '6127778899', 'roberto.sanchez@email.com', 'Rocky', 'Del Valle', 'Boulevard Insurgentes #789', NULL, '6125554433', '2026-06-03 20:17:14');

-- Volcando estructura para tabla veterinaria_system.historial_medico
CREATE TABLE IF NOT EXISTS `historial_medico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_paciente` int(11) DEFAULT NULL,
  `diagnostico` text DEFAULT NULL,
  `tratamiento` text DEFAULT NULL,
  `fecha` timestamp NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`id`),
  KEY `idx_historial_paciente` (`id_paciente`),
  CONSTRAINT `historial_medico_ibfk_1` FOREIGN KEY (`id_paciente`) REFERENCES `pacientes` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.historial_medico: ~0 rows (aproximadamente)

-- Volcando estructura para tabla veterinaria_system.medicamentos
CREATE TABLE IF NOT EXISTS `medicamentos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `precio` double NOT NULL DEFAULT 0,
  `stock` int(11) DEFAULT 0,
  `stock_minimo` int(11) DEFAULT 5,
  `requiere_receta` tinyint(1) DEFAULT 0,
  `categoria` varchar(50) DEFAULT 'General',
  `proveedor` varchar(150) DEFAULT NULL,
  `lote` varchar(50) DEFAULT NULL,
  `fecha_vencimiento` date DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT current_timestamp(),
  `activo` tinyint(1) DEFAULT 1,
  `laboratorio` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre` (`nombre`),
  KEY `idx_medicamento_nombre` (`nombre`),
  KEY `idx_medicamento_categoria` (`categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.medicamentos: ~5 rows (aproximadamente)
INSERT INTO `medicamentos` (`id`, `nombre`, `descripcion`, `precio`, `stock`, `stock_minimo`, `requiere_receta`, `categoria`, `proveedor`, `lote`, `fecha_vencimiento`, `fecha_registro`, `activo`, `laboratorio`) VALUES
	(1, 'Antibiótico clavoxivet', 'Antibiótico de amplio espectro para infecciones bacterianas', 295, 45, 10, 1, 'Antibióticos', 'Laboratorios Veterinarios SA', 'LOT001', NULL, '2026-06-03 20:17:14', 1, 'Clavoxivet Labs'),
	(2, 'Antiparasitarios', 'Tratamiento antiparasitario interno y externo', 320, 100, 20, 0, 'Parasiticidas', 'VetPharma', 'LOT002', NULL, '2026-06-03 20:17:14', 1, 'VetPharma'),
	(3, 'Desparacitante Care Max', 'Desparasitante de amplio espectro', 85, 200, 35, 1, 'Parasiticidas', 'CareMax Vet', 'LOT003', '2026-06-03', '2026-06-03 20:17:14', 1, 'CareMax'),
	(4, 'Vacuna Quíntuple', 'Protege contra 5 enfermedades', 450, 30, 5, 1, 'Vacunas', 'Laboratorios Veterinarios SA', 'LOT004', NULL, '2026-06-03 20:17:14', 1, 'VetLabs'),
	(5, 'Analgésico Vet', 'Alivio del dolor post-operatorio', 180, 40, 10, 1, 'Analgésicos', 'VetPharma', 'LOT005', NULL, '2026-06-03 20:17:14', 1, 'VetPharma');

-- Volcando estructura para tabla veterinaria_system.pacientes
CREATE TABLE IF NOT EXISTS `pacientes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `especie` varchar(50) DEFAULT NULL,
  `raza` varchar(50) DEFAULT NULL,
  `edad` int(11) DEFAULT NULL,
  `sexo` varchar(20) DEFAULT NULL,
  `diagnostico` text DEFAULT NULL,
  `historial` text DEFAULT NULL,
  `foto` text DEFAULT NULL,
  `id_dueno` int(11) DEFAULT NULL,
  `peso` decimal(5,2) DEFAULT NULL,
  `fecha_registro` timestamp NULL DEFAULT current_timestamp(),
  `alergias` text DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_paciente_dueno` (`id_dueno`),
  CONSTRAINT `pacientes_ibfk_1` FOREIGN KEY (`id_dueno`) REFERENCES `duenos` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.pacientes: ~3 rows (aproximadamente)
INSERT INTO `pacientes` (`id`, `nombre`, `especie`, `raza`, `edad`, `sexo`, `diagnostico`, `historial`, `foto`, `id_dueno`, `peso`, `fecha_registro`, `alergias`) VALUES
	(1, 'Max', 'Perro', 'Labrador', 5, 'Macho', 'Infeccion respiratoria', 'Paciente con tos y fiebre', NULL, 1, 26.00, '2026-06-03 20:17:14', 'Ninguna'),
	(2, 'Luna', 'Gato', 'Siames', 3, 'Hembra', 'Infeccion urinaria', 'Presenta dificultad al orinar', NULL, 2, 4.20, '2026-06-03 20:17:14', 'Ninguna'),
	(3, 'Rocky', 'Perro', 'Pastor Aleman', 4, 'Macho', 'Completamente sano', 'Vacunacion completa', NULL, 3, 30.00, '2026-06-03 20:17:14', 'Penicilina');

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
  `especialidad` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `correo` (`correo`),
  KEY `idx_user_correo` (`correo`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.users: ~5 rows (aproximadamente)
INSERT INTO `users` (`id`, `nombre`, `apellidos`, `telefono`, `correo`, `password`, `foto`, `activo`, `especialidad`) VALUES
	(1, 'Admin', 'Sistema', '6129998888', 'admin@veterinaria.com', 'admin123', NULL, 1, 'Administrador'),
	(2, 'Carlos', 'Ramirez', '6121111111', 'carlos@veterinaria.com', '1234', NULL, 1, 'Medicina General'),
	(3, 'Fernanda', 'Lopez', '6122222222', 'fernanda@veterinaria.com', '1234', NULL, 1, 'Medicina Interna'),
	(4, 'Luis', 'Martinez', '6123333333', 'luis@veterinaria.com', '1234', NULL, 1, 'Dermatología'),
	(5, 'Ana', 'Garcia', '6124444444', 'ana@veterinaria.com', '1234', NULL, 1, 'Odontología');

-- Volcando estructura para tabla veterinaria_system.ventas
CREATE TABLE IF NOT EXISTS `ventas` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cita` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `notas` text DEFAULT NULL,
  `fecha_venta` timestamp NULL DEFAULT current_timestamp(),
  `tipo_pago` varchar(50) DEFAULT 'Efectivo',
  PRIMARY KEY (`id`),
  KEY `id_cita` (`id_cita`),
  CONSTRAINT `ventas_ibfk_1` FOREIGN KEY (`id_cita`) REFERENCES `citas` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Volcando datos para la tabla veterinaria_system.ventas: ~0 rows (aproximadamente)

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
