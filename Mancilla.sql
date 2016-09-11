/*
SQLyog Community Edition- MySQL GUI v7.02 
MySQL - 5.0.45-community-nt-log : Database - ixtapapalacegym
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`ixtapapalacegym` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ixtapapalacegym`;

/*Table structure for table `c_datoscontacto` */

DROP TABLE IF EXISTS `c_datoscontacto`;

CREATE TABLE `c_datoscontacto` (
  `IDCliente` int(11) NOT NULL,
  `Telefono` varchar(15) default NULL,
  `email` varchar(100) default NULL,
  `ContactoEmergencia` varchar(100) default NULL,
  `NumEmergencia` varchar(100) default NULL,
  KEY `FK_c_datoscontacto` (`IDCliente`),
  CONSTRAINT `FK_c_datoscontacto` FOREIGN KEY (`IDCliente`) REFERENCES `c_datosgenerales` (`IDCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `c_datoscontacto` */

/*Table structure for table `c_datosgenerales` */

DROP TABLE IF EXISTS `c_datosgenerales`;

CREATE TABLE `c_datosgenerales` (
  `IDCliente` int(11) NOT NULL auto_increment,
  `Nombre` varchar(100) default NULL,
  `Apellidos` varchar(100) default NULL,
  `genero` varchar(20) default NULL,
  `FechaInscripcion` date default NULL,
  `foto` blob,
  PRIMARY KEY  (`IDCliente`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `c_datosgenerales` */

/*Table structure for table `c_datosmedicos` */

DROP TABLE IF EXISTS `c_datosmedicos`;

CREATE TABLE `c_datosmedicos` (
  `IDCliente` int(11) NOT NULL,
  `servcio` varchar(100) NOT NULL,
  `FolioMedico` varchar(100) NOT NULL,
  `peso` decimal(10,2) NOT NULL,
  `estatura` decimal(10,2) NOT NULL,
  `tiposangre` varchar(10) NOT NULL,
  `enfermedades` varchar(200) NOT NULL,
  KEY `FK_c_datosmedicos` (`IDCliente`),
  CONSTRAINT `FK_c_datosmedicos` FOREIGN KEY (`IDCliente`) REFERENCES `c_datosgenerales` (`IDCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `c_datosmedicos` */

/*Table structure for table `detallegastos` */

DROP TABLE IF EXISTS `detallegastos`;

CREATE TABLE `detallegastos` (
  `IDGasto` int(11) NOT NULL,
  `Descripcion` varchar(255) default NULL,
  `Precio` decimal(10,2) default NULL,
  `Cantidad` smallint(5) default NULL,
  `Total` decimal(10,2) default NULL,
  KEY `FK_detallegastos` (`IDGasto`),
  CONSTRAINT `FK_detallegastos` FOREIGN KEY (`IDGasto`) REFERENCES `gastos` (`IDGasto`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detallegastos` */

/*Table structure for table `detalleventas` */

DROP TABLE IF EXISTS `detalleventas`;

CREATE TABLE `detalleventas` (
  `Folio` int(11) NOT NULL,
  `IdProducto` int(11) default NULL,
  `Producto` varchar(255) default NULL,
  `Precio` decimal(10,2) default NULL,
  `Cantidad` smallint(5) default NULL,
  `Total` decimal(10,2) default NULL,
  KEY `FK_detalleventas` (`Folio`),
  CONSTRAINT `FK_detalleventas` FOREIGN KEY (`Folio`) REFERENCES `ventas` (`Folio`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `detalleventas` */

/*Table structure for table `empleados` */

DROP TABLE IF EXISTS `empleados`;

CREATE TABLE `empleados` (
  `IDEmpleado` int(11) NOT NULL auto_increment,
  `Nombre` varchar(200) default NULL,
  `Apellidos` varchar(200) default NULL,
  `Direccion` varchar(200) default NULL,
  `Ciudad` varchar(200) default NULL,
  `FechaNacimiento` date default NULL,
  `Telefono` varchar(15) default NULL,
  `FechaContratacion` datetime default NULL,
  `IDPuesto` int(11) default NULL,
  `Cobro` decimal(8,2) default NULL,
  PRIMARY KEY  (`IDEmpleado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `empleados` */

/*Table structure for table `gastos` */

DROP TABLE IF EXISTS `gastos`;

CREATE TABLE `gastos` (
  `IDGasto` int(11) NOT NULL auto_increment,
  `IDEmpleado` int(11) default NULL COMMENT 'Empleado que realiza el gasto',
  `Fecha` date default NULL,
  `Total` decimal(10,2) default NULL,
  PRIMARY KEY  (`IDGasto`),
  KEY `FK_gastos` (`IDEmpleado`),
  CONSTRAINT `FK_gastos` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleados` (`IDEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gastos` */

/*Table structure for table `mensualidades` */

DROP TABLE IF EXISTS `mensualidades`;

CREATE TABLE `mensualidades` (
  `IDPago` int(11) NOT NULL auto_increment,
  `IDCliente` int(11) default NULL,
  `NumMes` smallint(10) default NULL COMMENT 'El mes en numero',
  `Mes` varchar(255) default NULL COMMENT 'Mes en Texto',
  `FechaPago` datetime default NULL,
  `FechaVencimiento` date default NULL,
  `IDPrecio` int(11) default NULL COMMENT 'Referente a la tabla Precios_Mensuales',
  `DescripcionPrecio` varchar(255) default NULL COMMENT 'Descripcion del precio',
  `Status` varchar(100) default NULL COMMENT 'Pagado/noPagado/Cancelado',
  `Total` decimal(10,2) default NULL,
  PRIMARY KEY  (`IDPago`),
  KEY `FK_mensualidades` (`IDCliente`),
  CONSTRAINT `FK_mensualidades` FOREIGN KEY (`IDCliente`) REFERENCES `c_datosgenerales` (`IDCliente`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mensualidades` */

/*Table structure for table `precios_mensuales` */

DROP TABLE IF EXISTS `precios_mensuales`;

CREATE TABLE `precios_mensuales` (
  `IDPrecio` int(11) NOT NULL auto_increment,
  `Descripcion` varchar(100) NOT NULL,
  `Tipo` varchar(100) NOT NULL,
  `Precio` decimal(10,2) default NULL,
  PRIMARY KEY  (`IDPrecio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `precios_mensuales` */

/*Table structure for table `prestamos` */

DROP TABLE IF EXISTS `prestamos`;

CREATE TABLE `prestamos` (
  `IDPrestamo` int(11) NOT NULL auto_increment,
  `IDEmpleado` int(11) default NULL,
  `Monto` decimal(10,2) default NULL,
  `FechaParaPagar` datetime default NULL COMMENT 'Fecha limite para pagar',
  `Status` varchar(50) default NULL COMMENT 'Pagado/No Pagado',
  PRIMARY KEY  (`IDPrestamo`),
  KEY `FK_prestamos` (`IDEmpleado`),
  CONSTRAINT `FK_prestamos` FOREIGN KEY (`IDEmpleado`) REFERENCES `empleados` (`IDEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `prestamos` */

/*Table structure for table `productos` */

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `IDProducto` int(3) NOT NULL,
  `NombreProducto` varchar(20) default NULL,
  `Stock` int(3) default NULL,
  `Tamanio` varchar(15) default NULL,
  `Precio` float(6,2) default NULL,
  PRIMARY KEY  (`IDProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `productos` */

insert  into `productos`(`IDProducto`,`NombreProducto`,`Stock`,`Tamanio`,`Precio`) values (1,'Agua G',5,'1 Lt.',20.00),(2,'Agua C.',8,'600 ml.',10.00),(3,'Gatorade G',15,' 1 Lt.',30.00),(4,'Gatorade C.',2,'600 mi.',20.00);

/*Table structure for table `puestos` */

DROP TABLE IF EXISTS `puestos`;

CREATE TABLE `puestos` (
  `IDPuesto` int(11) NOT NULL auto_increment,
  `Descripcion` varchar(100) NOT NULL,
  `SalarioDia` decimal(10,2) NOT NULL,
  `SalarioHora` decimal(10,2) NOT NULL,
  PRIMARY KEY  (`IDPuesto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `puestos` */

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `IDUser` int(3) NOT NULL auto_increment,
  `Nombre` varchar(100) NOT NULL,
  `Apellidos` varchar(100) NOT NULL,
  `UserName` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `TipoUsuario` varchar(100) NOT NULL,
  PRIMARY KEY  (`IDUser`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `usuarios` */

insert  into `usuarios`(`IDUser`,`Nombre`,`Apellidos`,`UserName`,`Password`,`TipoUsuario`) values (1,'Marco Antonio','Mancilla Baños','MarcoMancilla','1234','Administrador'),(2,'Luis Felix','Mancilla B.','Luis1','1234','Secretaria'),(3,'Erendira','Baños Ponce','Erendira','1122','Administrador');

/*Table structure for table `ventas` */

DROP TABLE IF EXISTS `ventas`;

CREATE TABLE `ventas` (
  `Folio` int(11) NOT NULL auto_increment,
  `IDCliente` int(11) default NULL COMMENT 'Id del cliente',
  `Autorizador` varchar(255) default NULL COMMENT 'Nombre de quien autoriza el pago',
  `FechaVta` date default NULL COMMENT 'Fechan en que se realizó la venta',
  `Total` decimal(10,2) default NULL COMMENT 'Total de la venta',
  PRIMARY KEY  (`Folio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `ventas` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
