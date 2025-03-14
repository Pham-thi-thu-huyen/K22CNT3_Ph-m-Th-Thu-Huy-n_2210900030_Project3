-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 13, 2025 lúc 05:36 PM
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
-- Cơ sở dữ liệu: `ptth_qldethi_lichsu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_exam`
--

CREATE TABLE `ptth_exam` (
  `ExamID` int(11) NOT NULL,
  `Title` varchar(255) NOT NULL,
  `description` tinytext NOT NULL,
  `CreatedBy` int(11) NOT NULL,
  `CreatedAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptth_exam`
--

INSERT INTO `ptth_exam` (`ExamID`, `Title`, `description`, `CreatedBy`, `CreatedAt`) VALUES
(1, 'Đề thi 01', 'Đề thi tham khảo Môn LỊCH SỬ của Bộ GD&ĐT ', 1, '2025-03-13 03:49:06'),
(3, 'Đề thi 02', 'Đề thi thử Tốt nghiệp THPT Quốc gia 2024', 2, '2025-03-13 08:32:28');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_exam_question`
--

CREATE TABLE `ptth_exam_question` (
  `ExamID` int(11) NOT NULL,
  `QuestionID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptth_exam_question`
--

INSERT INTO `ptth_exam_question` (`ExamID`, `QuestionID`) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 4),
(1, 5),
(1, 6),
(1, 7),
(1, 8),
(1, 9),
(1, 10),
(2, 1),
(2, 2),
(2, 3),
(2, 4),
(2, 5);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_questions`
--

CREATE TABLE `ptth_questions` (
  `QuestionID` int(11) NOT NULL,
  `content` tinytext NOT NULL,
  `OptionA` varchar(255) NOT NULL,
  `OptionB` varchar(255) NOT NULL,
  `OptionC` varchar(255) NOT NULL,
  `OptionD` varchar(255) NOT NULL,
  `CorrectOption` tinytext NOT NULL,
  `CreatedBy` int(11) NOT NULL,
  `CreatedAt` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptth_questions`
--

INSERT INTO `ptth_questions` (`QuestionID`, `content`, `OptionA`, `OptionB`, `OptionC`, `OptionD`, `CorrectOption`, `CreatedBy`, `CreatedAt`) VALUES
(1, ' Trong đường lối đổi mới đất nước (từ tháng 12 - 1986), Đảng Cộng sản Việt Nam chủ trương', 'mở chiến dịch Biên giới thu - đông.', ' phát động cao trào kháng Nhật cứu nước', 'thực hiện chính sách đại đoàn kết dân tộc.', 'Tân Việt Cách mạng đảng.', 'A', 1, '2025-03-13 08:16:08'),
(2, 'Hội nghị Ianta (tháng 2-1945) quyết định thành lập tổ chức Liên hợp quốc nhằm', 'duy trì hòa bình và an ninh thế giới.', 'thiết lập trật tự thế giới đơn cực.', 'triển khai Kế hoạch Mácsan của Mĩ.', 'thúc đẩy cuộc cách mạng công nghệ.', 'B', 1, '2025-03-13 08:17:19'),
(3, ' Hiệp hội các quốc gia Đông Nam Á (ASEAN) được thành lập trong bối cảnh', ' trật tự thế giới hai cực Ianta đã sụp đổ.', 'xu thế liên kết khu vực đang phát triển.', 'tất cả các nước châu Á đã giành độc lập.', 'chủ nghĩa thực dân cũ hoàn toàn sụp đổ.', 'C', 1, '2025-03-13 08:20:15'),
(4, ' Cuộc Tiến công chiến lược năm 1972 của quân dân miền Nam Việt Nam thắng lợi buộc Mĩ phải', 'kí Hiệp định Giơnevơ về Đông Dương.', 'tuyên bố \"Mĩ hóa\" trở lại chiến tranh xâm lược.', 'chấp nhận kí với Việt Nam Hiệp định Sơ bộ.', 'tuyên bố \"phi Mĩ hóa\" chiến tranh xâm lược.', 'D', 1, '2025-03-13 08:21:28'),
(5, ' Nhận xét nào sau đây phản ánh đúng tình hình Việt Nam trong những năm 20 của thế kỉ XX?', 'Các giai cấp đại diện cho phương thức sản xuất phong kiến bị xóa bỏ hoàn toàn.', 'Những giai cấp mới xuất hiện tham gia giải quyết nhiệm vụ dân tộc, dân chủ.', 'Xã hội Việt Nam xuất hiện nhiều mâu thuẫn mới, bao trùm là mâu thuẫn giai cấp.', 'Giai cấp công nhân ra đời, phát triển nhanh về số lượng và nắm quyền lãnh đạo cách mạng.', 'A', 1, '2025-03-13 08:22:45'),
(6, ' Chi bộ Cộng sản đầu tiên ra đời ở Việt Nam vào tháng 3-1929 chứng tỏ', ' sự nhạy bén của một số hội viên tiên tiến trong Hội Việt Nam Cách mạng Thanh niên.', 'quyền lãnh đạo cách mạng Việt Nam đã chuyển hẳn sang giai cấp vô sản.', 'giai cấp công nhân ở Việt Nam đã có đội tiên phong lãnh đạo cách mạng.', 'Quốc tế Cộng sản luôn theo dõi và chỉ đạo trực tiếp đối với cách mạng Việt Nam.', 'A', 1, '2025-03-13 08:25:05'),
(7, ' Sự phát triển nhanh chóng của quan hệ thương mại quốc tế là một trong những biểu hiện của', 'cuộc Chiến tranh lạnh.', 'xu thế toàn cầu hóa.', 'mâu thuẫn Đông - Tây.', 'cuộc khủng hoảng dầu mỏ.', 'C', 1, '2025-03-13 08:26:27'),
(8, 'Trong giai đoạn 1941-1945, cách mạng Việt Nam thực hiện nhiệm vụ nào sau đây?', 'Xây dựng lực lượng vũ trang.', 'Tiến hành điện khí hóa nông thôn.', 'Hiện đại hóa xã hội chủ nghĩa.', 'Công nghiệp hóa xã hội chủ nghĩa.', 'B', 1, '2025-03-13 08:28:21'),
(9, 'Trong phong trào yêu nước và cách mạng ở Việt Nam đầu thế kỉ XX, Phan Châu Trinh đã', 'mở cuộc vận động Duy tân ở Trung Kì.', 'tăng cưởng thực hiện chủ trương vô sản hóa.', ' thành lập Đông Dương Cộng sản đảng.', 'thành lập Đông Dương Cộng sản liên đoàn.', 'A', 1, '2025-03-13 08:29:32'),
(10, 'Phong trào Đồng khởi (1959-1960) ở Việt Nam dẫn đến sự ra đời của', 'Mặt trận Dân tộc giải phóng miền Nam Việt Nam.', 'tổ chức Việt Nam Quang phục hội.', 'Hội Liên hiệp các dân tộc bị áp bức ở Á Đông.', 'Nhà xuất Bản tiến bộ Nam đồng thư xã.', 'B', 1, '2025-03-13 08:30:27'),
(11, 'Xu thế toàn cầu hoá dẫn đến hệ quả tiêu cực nào sau đây?', 'Giải quyết được triệt để bất công xã hội.', 'Tạo ra nguy cơ đánh mất bản sắc dân tộc.', 'Kìm hãm lực lượng sản xuất phát triển.', 'Hạn chế sự chuyển biến về cơ cấu kinh tế.', 'C', 2, '2025-03-13 08:34:44'),
(12, ' Trong giai đoạn 1939-1945, thực dân Pháp thực hiện chính sách nào sau đây ở Đông Dương?', ' Kinh tế chỉ huy.', ' Cải cách mở cửa.', 'Hợp tác toàn diện.', 'Phát triển du lịch.', 'B', 2, '2025-03-13 08:35:55'),
(13, 'Trong cơ cấu tổ chức của Liên hợp quốc không có cơ quan nào?', ' Đại hội đồng.', 'Ban thư kí.', 'Ủy ban châu Âu.', 'Hội đồng Bảo an.', 'B', 2, '2025-03-13 08:37:04'),
(14, ' Chỉ một tuần sau khi nước Việt Nam Dân chủ Cộng hoà ra đời, Chính phủ lâm thời công bố', 'Lệnh tổng tuyển cử trong cả nước.', 'Cho lưu hành tiền Việt Nam mới.', ' Danh sách Chính phủ liên hiệp kháng chiến', 'Thành lập Vệ quốc đoàn.', 'D', 2, '2025-03-13 08:38:20'),
(15, 'Trong những năm 1927-1930, Việt Nam Quốc dân đảng có hoạt động nào sau đây?', 'Tổ chức ám sát Badanh.', 'Xuất bản báo Búa liềm.', 'Thành lập chi bộ cộng sản.', 'Chống phát xít Nhật.', 'B', 2, '2025-03-13 08:39:31');

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

--
-- Đang đổ dữ liệu cho bảng `ptth_submissions`
--

INSERT INTO `ptth_submissions` (`SubmissionID`, `ExamID`, `UserID`, `Score`, `SubmittedAt`) VALUES
(1, 1, 1, 8, '2025-03-13 04:31:06');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_submission_answer`
--

CREATE TABLE `ptth_submission_answer` (
  `QuestionID` int(11) NOT NULL,
  `SubmissionID` int(11) NOT NULL,
  `answer` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptth_submission_answer`
--

INSERT INTO `ptth_submission_answer` (`QuestionID`, `SubmissionID`, `answer`) VALUES
(1, 1, 'A'),
(4, 3, 'C');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_submission_answers`
--

CREATE TABLE `ptth_submission_answers` (
  `SubmissionID` int(11) NOT NULL,
  `QuestionID` int(11) NOT NULL,
  `selectedOption` tinytext NOT NULL,
  `selected_option` tinytext NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `ptth_users`
--

CREATE TABLE `ptth_users` (
  `UserID` int(11) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Role` enum('TEACHER','STUDENT') NOT NULL DEFAULT 'STUDENT'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `ptth_users`
--

INSERT INTO `ptth_users` (`UserID`, `FullName`, `Password`, `Email`, `Role`) VALUES
(1, 'huyencute123', '$2a$10$JF/vsknyOmfSjFe.uhnvMuEPYIX1JxSKAS1XBiba3C3GJPlde2.q6', 'huyenphamthithu12033@gmail.com', 'TEACHER'),
(2, 'huyencute123', '$2a$10$O4n08gh/XHrZUwcJtsltd.0UM4BCJPc5IV.5vsXdJOXd3tiqGzwzy', 'huyenphamthithu1202@gmail.com', 'TEACHER'),
(3, 'huyencute123', '$2a$10$Ek3.nl5ebeiDM56h0ycKQO4ZmJgAVwrepactHkE4doVym8VRBgeNa', 'huyen123@gmail.com', 'TEACHER');

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
  ADD PRIMARY KEY (`ExamID`,`QuestionID`);

--
-- Chỉ mục cho bảng `ptth_questions`
--
ALTER TABLE `ptth_questions`
  ADD PRIMARY KEY (`QuestionID`);

--
-- Chỉ mục cho bảng `ptth_submissions`
--
ALTER TABLE `ptth_submissions`
  ADD PRIMARY KEY (`SubmissionID`);

--
-- Chỉ mục cho bảng `ptth_submission_answer`
--
ALTER TABLE `ptth_submission_answer`
  ADD PRIMARY KEY (`QuestionID`,`SubmissionID`);

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
  MODIFY `ExamID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT cho bảng `ptth_exam_question`
--
ALTER TABLE `ptth_exam_question`
  MODIFY `ExamID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT cho bảng `ptth_questions`
--
ALTER TABLE `ptth_questions`
  MODIFY `QuestionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT cho bảng `ptth_submissions`
--
ALTER TABLE `ptth_submissions`
  MODIFY `SubmissionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=94;

--
-- AUTO_INCREMENT cho bảng `ptth_submission_answer`
--
ALTER TABLE `ptth_submission_answer`
  MODIFY `QuestionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=44;

--
-- AUTO_INCREMENT cho bảng `ptth_submission_answers`
--
ALTER TABLE `ptth_submission_answers`
  MODIFY `SubmissionID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT cho bảng `ptth_users`
--
ALTER TABLE `ptth_users`
  MODIFY `UserID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
