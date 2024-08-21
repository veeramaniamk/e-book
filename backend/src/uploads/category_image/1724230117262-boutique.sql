-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 20, 2024 at 11:49 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `boutique`
--

-- --------------------------------------------------------

--
-- Table structure for table `dress_category`
--

CREATE TABLE `dress_category` (
  `id` int(11) NOT NULL,
  `category_name` text DEFAULT NULL,
  `category_for` text DEFAULT NULL,
  `created_on` datetime DEFAULT current_timestamp(),
  `updated_on` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `material_category`
--

CREATE TABLE `material_category` (
  `id` int(11) NOT NULL,
  `cloth_name` text DEFAULT NULL,
  `category_for` text DEFAULT NULL,
  `created_on` datetime DEFAULT current_timestamp(),
  `updated_on` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `material_category`
--

INSERT INTO `material_category` (`id`, `cloth_name`, `category_for`, `created_on`, `updated_on`) VALUES
(1, 'cottone', 'male', '2024-08-20 13:19:41', '2024-08-20 13:26:38.988');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL,
  `designer_id` int(11) DEFAULT NULL,
  `product_name` text DEFAULT NULL,
  `product_description` text DEFAULT NULL,
  `material_category_name` text DEFAULT NULL,
  `dress_category_name` text DEFAULT NULL,
  `product_for` text DEFAULT NULL,
  `product_price` double DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `created_on` datetime DEFAULT current_timestamp(),
  `update_on` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `product_images`
--

CREATE TABLE `product_images` (
  `image_id` int(11) NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  `product_image` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `id` int(11) NOT NULL,
  `name` text DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `email` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `gender` text DEFAULT NULL,
  `speciality` text DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `profile_photo` text DEFAULT NULL,
  `activty_status` text DEFAULT NULL,
  `designer_role` text DEFAULT NULL,
  `experience` int(11) DEFAULT NULL,
  `salary` double DEFAULT NULL,
  `created_on` datetime DEFAULT current_timestamp(),
  `update_on` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`id`, `name`, `phone`, `email`, `password`, `gender`, `speciality`, `user_type`, `profile_photo`, `activty_status`, `designer_role`, `experience`, `salary`, `created_on`, `update_on`) VALUES
(1, 'veera', 123456, 'veeramani@gmail.com', '$2a$10$ATfVqAPoVxbsBnXmYmCeaOvCuwpgqHY2P0ZoEB9O.9hKIiv2le5VG', 'male', NULL, 100, '1724136452005-maintenance.png', NULL, NULL, NULL, NULL, '2024-08-20 11:54:23', '2024-08-20 12:13:57.341'),
(2, 'karthik', 1234567890, 'karthik@gmail.com', '$2a$10$Zb56OhM8LC3t0vQA1ydWY.jR3OxewNDFGEeu2U2u7AfWFppTNlILa', 'female', ' ', 110, NULL, 'ACTIVE', ' ', 2, 200.3, '2024-08-20 14:16:18', '2024-08-20 14:22:58.134');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dress_category`
--
ALTER TABLE `dress_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `material_category`
--
ALTER TABLE `material_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `product_images`
--
ALTER TABLE `product_images`
  ADD PRIMARY KEY (`image_id`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dress_category`
--
ALTER TABLE `dress_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `material_category`
--
ALTER TABLE `material_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `product_images`
--
ALTER TABLE `product_images`
  MODIFY `image_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `signup`
--
ALTER TABLE `signup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
