-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Dec 22, 2013 at 08:38 AM
-- Server version: 5.5.24-log
-- PHP Version: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `samasend`
--
DROP DATABASE `samasend`;
CREATE DATABASE `samasend` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `samasend`;

-- --------------------------------------------------------

--
-- Table structure for table `paitient`
--

CREATE TABLE IF NOT EXISTS `paitient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pName` varchar(50) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `desType` varchar(50) NOT NULL,
  `drName` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=401655 ;

--
-- Dumping data for table `paitient`
--

INSERT INTO `paitient` (`id`, `pName`, `sex`, `desType`, `drName`) VALUES
(1234, 'Almaz', 'F', 'HIV', 'Dr. Death'),
(1235, 'Belete', 'F', 'asdf', 'asdf'),
(1239, 'Test paitient', 'F', 'test disease', 'Dr. Unkown'),
(401364, 'Samson Belete', 'M', 'Flu', 'Dr. Samson Endale'),
(401365, 'Samson Endale', 'M', 'Cold', 'Dr. Samson Endale'),
(401374, 'Smuel Asmare', 'M', 'awesomeness', 'Dr. Sam As End'),
(401654, 'Yaregal Tadese', 'M', 'Hunger', 'Dr. Food');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `aboutMe` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `password`, `aboutMe`) VALUES
(1, 'samasend', '1234', 'Samson Endale'),
(2, 'yaya', '0410', 'saasxasxsxasx');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
