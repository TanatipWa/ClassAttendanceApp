-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Apr 27, 2021 at 08:16 AM
-- Server version: 8.0.17
-- PHP Version: 7.3.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `classattendancedb`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `id` int(50) NOT NULL,
  `username` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL,
  `date` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`id`, `username`, `name`, `surname`, `date`) VALUES
(1, 'asdpoom', 'Tanatip', 'Waleeroeksab', '26-04-2021'),
(2, 'bi', 'Saowarod', 'Sommo', '26-04-2021'),
(3, 'cat', 'Chitsanupong', 'Boonserm', '26-04-2021'),
(4, 'kit', 'Kritsadeeka', 'Wongsuban', '26-04-2021'),
(5, 'm', 'Patcharapong', 'Yangyim', '26-04-2021'),
(6, 'mart', 'Tanatorn', 'Mokkhao', '26-04-2021'),
(7, 'bi', 'Saowarod', 'Sommo', '25-04-2021'),
(8, 'cat', 'Chitsanupong', 'Boonserm', '25-04-2021'),
(9, 'kit', 'Kritsadeeka', 'Wongsuban', '25-04-2021'),
(10, 'kit', 'Kritsadeeka', 'Wongsuban', '24-04-2021'),
(11, 'm', 'Patcharapong', 'Yangyim', '24-04-2021'),
(12, '2', '2', '2', '26-04-2021'),
(13, 'student', 'stu', 'dent1', '26-04-2021'),
(14, 'test', 'testname', 'testsurname', '26-04-2021'),
(18, 'asdpoom', 'Tanatip', 'Waleeroeksab', '27-04-2021');

-- --------------------------------------------------------

--
-- Table structure for table `class`
--

CREATE TABLE `class` (
  `id` int(50) NOT NULL,
  `class_code` varchar(100) NOT NULL,
  `status` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `class`
--

INSERT INTO `class` (`id`, `class_code`, `status`) VALUES
(1, 'AB', 'on');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `username` varchar(100) NOT NULL,
  `pass` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`username`, `pass`, `name`, `surname`) VALUES
('2', '2', '2', '2'),
('3', '3', '3', '3'),
('asdpoom', '1234', 'Tanatip', 'Waleeroeksab'),
('bi', '1234', 'Saowarod', 'Sommo'),
('cat', '1234', 'Chitsanupong', 'Boonserm'),
('kit', '1234', 'Kritsadeeka', 'Wongsuban'),
('m', '1234', 'Patcharapong', 'Yangyim'),
('mart', '1234', 'Tanatorn', 'Mokkhao'),
('student', 'student', 'stu', 'dent1'),
('test', '1234', 'testname', 'testsurname');

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE `teacher` (
  `username` varchar(100) NOT NULL,
  `pass` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(100) NOT NULL,
  `surname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `teacher`
--

INSERT INTO `teacher` (`username`, `pass`, `name`, `surname`) VALUES
('1', '1', '1', '1'),
('teacher', 'teacher', 'tea', 'cher1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `class`
--
ALTER TABLE `class`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `teacher`
--
ALTER TABLE `teacher`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT for table `class`
--
ALTER TABLE `class`
  MODIFY `id` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
