-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 18, 2024 at 08:27 AM
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
-- Database: `e_book`
--

-- --------------------------------------------------------

--
-- Table structure for table `books_category`
--

CREATE TABLE `books_category` (
  `id` int(11) NOT NULL,
  `category_name` text DEFAULT NULL,
  `category_image` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `books_category`
--

INSERT INTO `books_category` (`id`, `category_name`, `category_image`) VALUES
(1, 'javaw', '1723801695068-speedometer.jpeg');

-- --------------------------------------------------------

--
-- Table structure for table `e_books`
--

CREATE TABLE `e_books` (
  `id` int(11) NOT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `publisher_name` text DEFAULT NULL,
  `book_titile` text DEFAULT NULL,
  `book_description` text DEFAULT NULL,
  `book_cover_image` text DEFAULT NULL,
  `book_pdf` text DEFAULT NULL,
  `demo_file` text DEFAULT NULL,
  `category_name` text DEFAULT NULL,
  `auther_name` text DEFAULT NULL,
  `year_of_the_book` text DEFAULT NULL,
  `price` text DEFAULT NULL,
  `book_submit_date` text DEFAULT NULL,
  `book_approval` text DEFAULT NULL,
  `book_approval_date` text DEFAULT NULL,
  `cancelled_msg` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `e_books`
--

INSERT INTO `e_books` (`id`, `publisher_id`, `publisher_name`, `book_titile`, `book_description`, `book_cover_image`, `book_pdf`, `demo_file`, `category_name`, `auther_name`, `year_of_the_book`, `price`, `book_submit_date`, `book_approval`, `book_approval_date`, `cancelled_msg`) VALUES
(1, 2, 'veeramani', 'First Book', 'Learn Java and Programing Languages', '1723801023843-speedometer.jpeg', '1723801023846-Anbumani.pdf', '1723801023848-epfo_card.pdf', 'programing', 'veera', '1995', '255', '2024-08-16 15:07:03.850', 'APPROVED', '17-7-2024', 'content 18+'),
(2, 2, 'veeramani', 'First Book', 'Learn Java and Programing Languages', '1723801107237-speedometer.jpeg', '1723801107238-Anbumani.pdf', '1723801107238-epfo_card.pdf', 'programing', 'veera', '1995', '255', '2024-08-16 15:08:27.241', 'APPROVED', '17-7-2024', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `finished_list`
--

CREATE TABLE `finished_list` (
  `finished_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `finished_list`
--

INSERT INTO `finished_list` (`finished_id`, `user_id`, `book_id`) VALUES
(1, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `purchased_books`
--

CREATE TABLE `purchased_books` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `transaction_id` text DEFAULT NULL,
  `date` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `purchased_books`
--

INSERT INTO `purchased_books` (`id`, `user_id`, `publisher_id`, `book_id`, `price`, `transaction_id`, `date`) VALUES
(1, 1, 2, 1, 250, 'df32fds', '2024-08-17 13:52:01'),
(2, 3, 2, 2, 250, 'df32fds', '2024-08-17 16:16:48');

-- --------------------------------------------------------

--
-- Table structure for table `review`
--

CREATE TABLE `review` (
  `id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `publisher_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL,
  `review_text` text DEFAULT NULL,
  `date` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `review`
--

INSERT INTO `review` (`id`, `user_id`, `publisher_id`, `book_id`, `review_text`, `date`) VALUES
(6, 3, 1, 2, 'good', '16-7-2024'),
(7, 3, 1, 2, 'good', '17-7-2024'),
(8, 3, 1, 2, 'BAD', '17-7-2024'),
(9, 3, 1, 2, 'WAST', '17-7-2024'),
(10, 3, 1, 2, 'SUPER', '17-7-2024');

-- --------------------------------------------------------

--
-- Table structure for table `saved_list`
--

CREATE TABLE `saved_list` (
  `savedlist_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `book_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `saved_list`
--

INSERT INTO `saved_list` (`savedlist_id`, `user_id`, `book_id`) VALUES
(3, 1, 1),
(4, 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `id` int(11) NOT NULL,
  `name` text DEFAULT NULL,
  `phone` bigint(20) DEFAULT NULL,
  `gender` text DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  `email` text DEFAULT NULL,
  `password` text DEFAULT NULL,
  `profile_photo` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`id`, `name`, `phone`, `gender`, `user_type`, `email`, `password`, `profile_photo`) VALUES
(1, 'veera', 123, 'male', 100, 'veera@gmail.com', 'veeramani', '1723800113083-speedometer.jpeg'),
(2, 'veera', 1234567890, 'male', 110, 'veeramani@gmail.com', '123456', NULL),
(3, 'veera', 1234567890, 'male', 100, 'vasanth@gmail.com', '123456', NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `books_category`
--
ALTER TABLE `books_category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `e_books`
--
ALTER TABLE `e_books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `finished_list`
--
ALTER TABLE `finished_list`
  ADD PRIMARY KEY (`finished_id`);

--
-- Indexes for table `purchased_books`
--
ALTER TABLE `purchased_books`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `review`
--
ALTER TABLE `review`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `saved_list`
--
ALTER TABLE `saved_list`
  ADD PRIMARY KEY (`savedlist_id`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `books_category`
--
ALTER TABLE `books_category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `e_books`
--
ALTER TABLE `e_books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `finished_list`
--
ALTER TABLE `finished_list`
  MODIFY `finished_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `purchased_books`
--
ALTER TABLE `purchased_books`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `review`
--
ALTER TABLE `review`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `saved_list`
--
ALTER TABLE `saved_list`
  MODIFY `savedlist_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `signup`
--
ALTER TABLE `signup`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
