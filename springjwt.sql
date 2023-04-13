-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Apr 13, 2023 at 03:18 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `springjwt`
--

-- --------------------------------------------------------

--
-- Table structure for table `grade`
--

CREATE TABLE `grade` (
  `grade_id` int(11) NOT NULL,
  `exam_grade` int(11) DEFAULT NULL,
  `exam_name` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `grade`
--

INSERT INTO `grade` (`grade_id`, `exam_grade`, `exam_name`, `id`) VALUES
(1, 35, 'MATH_EXAM', 6),
(2, 68, 'LITERATURE_EXAM', 6),
(3, 53, 'SCIENCE_EXAM', 6),
(4, 88, 'HISTORY_EXAM', 6),
(5, 25, 'MATH_EXAM', 7),
(6, 48, 'LITERATURE_EXAM', 7),
(7, 25, 'SCIENCE_EXAM', 7),
(8, 75, 'HISTORY_EXAM', 7),
(9, 65, 'MATH_EXAM', 8),
(10, 56, 'LITERATURE_EXAM', 8),
(11, 70, 'SCIENCE_EXAM', 8),
(12, 65, 'HISTORY_EXAM', 8),
(13, 80, 'MATH_EXAM', 9),
(14, 50, 'LITERATURE_EXAM', 9),
(15, 40, 'SCIENCE_EXAM', 9),
(16, 30, 'HISTORY_EXAM', 9),
(17, 95, 'MATH_EXAM', 10),
(18, 75, 'LITERATURE_EXAM', 10),
(19, 80, 'SCIENCE_EXAM', 10),
(20, 75, 'HISTORY_EXAM', 10),
(21, 93, 'MATH_EXAM', 11),
(22, 80, 'LITERATURE_EXAM', 11),
(23, 95, 'SCIENCE_EXAM', 11),
(24, 93, 'HISTORY_EXAM', 11);

-- --------------------------------------------------------

--
-- Table structure for table `join_user_grade`
--

CREATE TABLE `join_user_grade` (
  `grade_id` int(11) NOT NULL,
  `exam_grade` int(11) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `id` int(11) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `exam_name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
(1, 'ROLE_manager'),
(2, 'ROLE_teacher'),
(3, 'ROLE_student'),
(4, 'ROLE_parent');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `token_expired` bit(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `email`, `enabled`, `first_name`, `last_name`, `password`, `token_expired`) VALUES
(1, 'semih@mail.com', b'1', 'Semih', 'Tekin', '$2a$10$ds6SzFDOfcusMU6Sz89VRON3251B8FkfZGpG1Vt4D0h1m02IM.qAy', b'1'),
(2, 'math@mail.com', b'1', 'Math', 'Teacher', '$2a$10$VpzWc/Bw0UvePFXIqCsBtO7/RSU5rlOUAoPvZomtBXFovwto7PGHa', b'1'),
(3, 'literature@mail.com', b'1', 'Literature', 'Teacher', '$2a$10$seUjrWyq80v6jFQfeFxFKuKvEoxSPdiZG7asid7yHbIOEDLRYaCou', b'1'),
(4, 'science@mail.com', b'1', 'Science', 'Teacher', '$2a$10$T2HgxmqkgWTE3qsyIqbs8uPDYlM9b9lSpG0fmfz1bioUbpvB4PEZi', b'1'),
(5, 'history@mail.com', b'1', 'History', 'Teacher', '$2a$10$LfQ1xTvupvlp4lAX6HlpmedIpKmf0HHrmldujPZoiTTViiPBSlZzq', b'1'),
(6, 'sinan@mail.com', b'1', 'Sinan', 'Tekin', '$2a$10$ssLw.nCKC4F/p1e96Ob20ekC0gasHo./zRPNGA.UxlTQgkgLv3l6q', b'1'),
(7, 'furkan@mail.com', b'1', 'Furkan', 'Tanriverdi', '$2a$10$rIS7DX29xQfXWKaOofA56.v1ectDQVYvJD3QuD2OUuzh85olfzu7O', b'1'),
(8, 'ferhat@mail.com', b'1', 'Ferhat', 'Orman', '$2a$10$FxRXYCf9SfmdqtpOD6cR3uHWM9CM8A0hLQftavN6v1KIWanXlLPs.', b'1'),
(9, 'canturk@mail.com', b'1', 'Canturk', 'Sadak', '$2a$10$eyEELOcbXqNVw/CeR5s6c.DjpvyjXkzfGiA1RcHYW1DbPeYF04hCO', b'1'),
(10, 'muhammet@mail.com', b'1', 'Muhammet Furkan', 'Ekici', '$2a$10$DY0OqLL1vX36jZVUHkQ/4exHtDJF6fstdzD.pef1WfpdLV2uVh6J2', b'1'),
(11, 'mustafa@mail.com', b'1', 'Mustafa', 'Katlan', '$2a$10$5NTKVIg92gq0j0g/0SPf4uukFNyfE9t64yhL5M8wi0qGt/BaGFrDO', b'1'),
(12, 'ayse@mail.com', b'1', 'Ayse', 'Tekin', '$2a$10$hOO0cDnB3fV8tb/ZxqLZb.xWBQUN3sZIx9dsGgZhz24lHgnUFuFJq', b'1'),
(13, 'gulkiz@mail.com', b'1', 'Gulkiz', 'Tanriverdi', '$2a$10$tB0Crsi.96TTON7guJEAEuQ9VVGMDlRLR.z/hIw.yQYeattlgW9NO', b'1'),
(14, 'seher@mail.com', b'1', 'Seher', 'Orman', '$2a$10$3OvXEaXOn/4J0Pe4W16mZe7XWG3Qg9EKyK41d0YT2wlRSFhaqcKmW', b'1'),
(15, 'yilmaz@mail.com', b'1', 'Yilmaz', 'Sadak', '$2a$10$OFoTXqiBgBeC682Y3kowLOqSbYM/pHyZhTioVHvcS6nGCgTtZoo1a', b'1'),
(16, 'ahmet@mail.com', b'1', 'Ahmet', 'Ekici', '$2a$10$yknm1blAVmUltWZhcNSthO.5dPOCw4.aoJsPKPpAb/pVxYQ8EgrMO', b'1'),
(17, 'mehmet@mail.com', b'1', 'Mehmet', 'Katlan', '$2a$10$QbJKNNBKakSADG10zKxaEOtjTvlVsGY7yVKmS35JVA.QwY7PwCrwS', b'1');

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users_roles`
--

INSERT INTO `users_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(3, 2),
(4, 2),
(5, 2),
(6, 3),
(7, 3),
(8, 3),
(9, 3),
(10, 3),
(11, 3),
(12, 4),
(13, 4),
(14, 4),
(15, 4),
(16, 4),
(17, 4);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `grade`
--
ALTER TABLE `grade`
  ADD PRIMARY KEY (`grade_id`);

--
-- Indexes for table `join_user_grade`
--
ALTER TABLE `join_user_grade`
  ADD PRIMARY KEY (`grade_id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FKt4v0rrweyk393bdgt107vdx0x` (`role_id`),
  ADD KEY `FKgd3iendaoyh04b95ykqise6qh` (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `grade`
--
ALTER TABLE `grade`
  MODIFY `grade_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FKgd3iendaoyh04b95ykqise6qh` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKt4v0rrweyk393bdgt107vdx0x` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
