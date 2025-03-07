-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th2 28, 2025 lúc 11:37 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `ptth_qldethi`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_exam`
--

CREATE TABLE `ptth_exam` (
  `ExamID` int(11) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `Description` text NOT NULL,
  `CreatedBy` int(11) NOT NULL,
  `CreatedAt` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_exam_question`
--

CREATE TABLE `ptth_exam_question` (
  `ExamID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_questions`
--

CREATE TABLE `ptth_questions` (
  `QuestionID` int(11) NOT NULL,
  `Content` text NOT NULL,
  `OptionA` varchar(255) NOT NULL,
  `OptionB` varchar(255) NOT NULL,
  `OptionC` varchar(255) NOT NULL,
  `OptionD` varchar(255) NOT NULL,
  `CorrectOption` enum('''A'', ''B'', ''C'', ''D''','','','') NOT NULL,
  `Difficulty` enum('''Easy'', ''Medium'', ''Hard''','','','') NOT NULL,
  `Category` varchar(100) NOT NULL,
  `CreatedBy` int(11) NOT NULL,
  `CreatedAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_submissions`
--

CREATE TABLE `ptth_submissions` (
  `SubmissionID` int(11) NOT NULL,
  `ExamID` int(11) NOT NULL,
  `UserID` int(11) NOT NULL,
  `Score` float NOT NULL,
  `SubmittedAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_submission_answers`
--

CREATE TABLE `ptth_submission_answers` (
  `SubmissionID` int(11) NOT NULL,
  `QuestionID` int(11) NOT NULL,
  `selectedOption` enum('''A'', ''B'', ''C'', ''D''','','','') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_users`
--

CREATE TABLE `ptth_users` (
  `UserID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Role` enum('''Teacher'', ''Student''','','','') NOT NULL,
  `CreatedAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `ptth_exam`
--
ALTER TABLE `ptth_exam`
  ADD PRIMARY KEY (`ExamID`);

--
-- Chỉ mục cho bảng `ptth_exam_question`
--
ALTER TABLE `ptth_exam_question`
  ADD PRIMARY KEY (`ExamID`);

--
-- Chỉ mục cho bảng `ptth_questions`
--
ALTER TABLE `ptth_questions`
  ADD PRIMARY KEY (`QuestionID`),
  ADD KEY `CreatedBy` (`QuestionID`) USING BTREE;

--
-- Chỉ mục cho bảng `ptth_submissions`
--
ALTER TABLE `ptth_submissions`
  ADD PRIMARY KEY (`SubmissionID`);

--
-- Chỉ mục cho bảng `ptth_submission_answers`
--
ALTER TABLE `ptth_submission_answers`
  ADD PRIMARY KEY (`SubmissionID`,`QuestionID`);

--
-- Chỉ mục cho bảng `ptth_users`
--
ALTER TABLE `ptth_users`
  ADD PRIMARY KEY (`UserID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `ptth_exam`
--
ALTER TABLE `ptth_exam`
  MODIFY `ExamID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ptth_questions`
--
ALTER TABLE `ptth_questions`
  MODIFY `QuestionID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ptth_submissions`
--
ALTER TABLE `ptth_submissions`
  MODIFY `SubmissionID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ptth_users`
--
ALTER TABLE `ptth_users`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
