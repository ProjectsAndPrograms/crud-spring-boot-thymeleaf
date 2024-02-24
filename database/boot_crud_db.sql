-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 24, 2024 at 03:34 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `boot_crud_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `dob`, `email`, `name`, `password`, `image`) VALUES
(20, '2024-02-23', 'raj@gmail.com', 'Raj kumar', '$2a$10$NI5IFvnLxpXlkjSplgsB2e2bOjHkEHtCZ7kfVzdRDPTVpJk9WH.Iu', 'cfb47473-369c-4be9-b3d0-a2bdbcdcfe38.jpg'),
(21, '2024-01-31', 'mysql@gmail.com', 'SpaceX', '$2a$10$9Oal.rc7J/0qewwsPbFOIuNgjTNGMRE2Zh1nxmY0CRTsiEK1IFRFO', 'adefefb9-b7c6-43d6-a661-c4a1ae42cc53.png'),
(23, '2024-02-08', 'spring@gmail.com', 'Spring boot', '$2a$10$igczF1xeKIQOjcazdcCnVuwNZGDWDMQHVm4JApjzl8ol.vpAw6uTu', NULL),
(24, '2024-02-09', 'sita@gmail.com', 'Shubham', '$2a$10$nYdbWgawK/ZSnHcuAuNSP.v2QYgT.shib4t5hXeMmu2nR6WFrxnzW', 'e660c999-5f1c-4ab4-af70-47a9cfc1b915.png'),
(27, '2024-02-03', 'html@gmail.com', 'HTML', '$2a$10$py78Gqcz7fGB2v07R4l0n.F1jfF/AQZayoHDPmNxDgjv6xL7St7Y2', 'df7e399a-a4de-405e-81f2-a2b0c391537a.png'),
(28, '2024-02-24', 'suraj2002@gmail.com', 'shubham kumar', '$2a$10$ONnkBi4Gp6Lk49SAvERv.OE0Z/AkXB1JWNGNsfOHGan8PRQRZwJUW', 'd0ca50b9-fb9b-4ce0-b151-ffc44a311095.png'),
(29, '2024-02-12', 'thanks@gmail.com', 'in28minutes', '$2a$10$fSgbh9Tquguss0K3Y64tgeoYAFkjYHa7HcmUyWL61FN8bmMkuGzIu', NULL),
(30, '2024-02-24', 'tushar@gmail.com', 'Tushar srivastav', '$2a$10$QzONt8rXhHouBlPuZI22yOW1G4UPJLFWgbkmdNgh.iU6N95QrrAOO', '84f24fbb-d53e-4b8b-9021-46b70a9921ce.jpg'),
(31, '2024-02-01', 'sita1@gmail.com', 'shubham kumar', '$2a$10$IkRbrxwggW0wEuIB2IkKcO0UOZ2V14y44pSgiNkBYVdRhPabFjNoG', 'e7e22016-eb79-434d-94d1-5f518e4203f5.ico'),
(32, '2024-02-24', 'windows@gmail.com', 'linux', '$2a$10$rqrT4vl0nbbP4EBGC8jhkeykWT/PfR.LeBFeqtf44l.WZwLo0Uv52', '584bd0de-0cb6-4171-8984-4b1fb122ff9c.png'),
(34, '2024-02-01', 'thymeleaf@gmail.com', 'java', '$2a$10$rHB5XlVkszcwZspBcFdJ5uW8zcdNUlu.gmKUUOweCiUI7kH3jGzR6', '8e4e79e7-a7aa-4938-aabe-50b69657cc78.png'),
(39, '2024-02-07', '123123admin@gmail.com', 'spaceX', '$2a$10$sBhzEmyiYZhGE7.Ii.F9YedEFZ5kNQfbuoa4RyJ1D2Qzm6FfQHrn2', '142dd4d3-e990-4e04-804a-a6d043169d7d.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK6dotkott2kjsp8vw4d0m25fb7` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
