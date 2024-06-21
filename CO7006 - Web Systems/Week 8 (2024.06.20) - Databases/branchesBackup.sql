-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 14, 2024 at 10:09 AM
-- Server version: 10.5.25-MariaDB
-- PHP Version: 8.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cjcollenette_example`
--

-- --------------------------------------------------------

--
-- Table structure for table `Branches`
--

CREATE TABLE `Branches` (
  `BranchID` int(11) NOT NULL,
  `BranchName` varchar(30) NOT NULL,
  `Location` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `Branches`
--

INSERT INTO `Branches` (`BranchID`, `BranchName`, `Location`) VALUES
(1, 'B1', 'North'),
(2, 'B2', 'South'),
(3, 'Placeholder', 'North'),
(4, 'B3', 'South');

-- --------------------------------------------------------

--
-- Table structure for table `Staff`
--

CREATE TABLE `Staff` (
  `StaffID` int(11) NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Wage` int(11) NOT NULL,
  `BranchID` int(11) NOT NULL,
  `Gender` varchar(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `Staff`
--

INSERT INTO `Staff` (`StaffID`, `Name`, `Wage`, `BranchID`, `Gender`) VALUES
(1, 'Far', 39000, 1, 'Male'),
(2, 'Yi', 18000, 2, 'Female'),
(3, 'Clare', 20000, 1, 'Female'),
(4, 'Bob', 1000, 2, 'Male'),
(5, 'Amy', 22000, 1, 'Female');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Branches`
--
ALTER TABLE `Branches`
  ADD PRIMARY KEY (`BranchID`);

--
-- Indexes for table `Staff`
--
ALTER TABLE `Staff`
  ADD PRIMARY KEY (`StaffID`),
  ADD KEY `BranchID` (`BranchID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Branches`
--
ALTER TABLE `Branches`
  MODIFY `BranchID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `Staff`
--
ALTER TABLE `Staff`
  MODIFY `StaffID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Staff`
--
ALTER TABLE `Staff`
  ADD CONSTRAINT `Staff_ibfk_1` FOREIGN KEY (`BranchID`) REFERENCES `Branches` (`BranchID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
