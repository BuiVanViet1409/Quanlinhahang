-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 23, 2022 at 06:16 AM
-- Server version: 10.4.21-MariaDB
-- PHP Version: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `quanlinhahang`
--

-- --------------------------------------------------------

--
-- Table structure for table `chitiethoadons`
--

CREATE TABLE `chitiethoadons` (
  `maCTHD` bigint(20) NOT NULL,
  `soLuong` int(11) NOT NULL,
  `thanhtien` double NOT NULL,
  `maHoaDon` bigint(20) DEFAULT NULL,
  `maMonAn` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `chitiethoadons`
--

INSERT INTO `chitiethoadons` (`maCTHD`, `soLuong`, `thanhtien`, `maHoaDon`, `maMonAn`) VALUES
(12, 1, 55000, 9, 4),
(13, 1, 25000, 9, 7),
(14, 1, 15000, 9, 12);

-- --------------------------------------------------------

--
-- Table structure for table `datbans`
--

CREATE TABLE `datbans` (
  `maDatBan` bigint(20) NOT NULL,
  `content` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(100) CHARACTER SET utf8 NOT NULL,
  `hoTen` varchar(50) CHARACTER SET utf8 NOT NULL,
  `ngayden` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `soluong` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `hoadons`
--

CREATE TABLE `hoadons` (
  `maHoaDon` bigint(20) NOT NULL,
  `address` varchar(100) CHARACTER SET utf8 NOT NULL,
  `email` varchar(100) CHARACTER SET utf8 NOT NULL,
  `ngayLap` date DEFAULT NULL,
  `note` varchar(200) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(20) COLLATE utf8_unicode_ci DEFAULT NULL,
  `ten` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `hoadons`
--

INSERT INTO `hoadons` (`maHoaDon`, `address`, `email`, `ngayLap`, `note`, `phone`, `ten`) VALUES
(9, 'Ninh Đa', 'mikubui.1409@gmail.com', '2022-01-15', 'ahahha', '0966467356', 'Bùi Văn Việt');

-- --------------------------------------------------------

--
-- Table structure for table `lienhes`
--

CREATE TABLE `lienhes` (
  `maLienHe` bigint(20) NOT NULL,
  `email` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `hoTen` varchar(60) COLLATE utf8_unicode_ci NOT NULL,
  `noidung` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `lienhes`
--

INSERT INTO `lienhes` (`maLienHe`, `email`, `hoTen`, `noidung`, `phone`) VALUES
(1, 'mikubui.1409@gmail.com', 'Bùi Văn Việt', 'Đã liên hệ lại', '0966467356');

-- --------------------------------------------------------

--
-- Table structure for table `monans`
--

CREATE TABLE `monans` (
  `maMonAn` bigint(20) NOT NULL,
  `gia` double NOT NULL,
  `image` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `mota` varchar(500) CHARACTER SET utf8 NOT NULL,
  `tenMonAn` varchar(100) CHARACTER SET utf8 NOT NULL,
  `maNhomMon` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `monans`
--

INSERT INTO `monans` (`maMonAn`, `gia`, `image`, `mota`, `tenMonAn`, `maNhomMon`) VALUES
(1, 65000, 'p27230de6-3d0b-43bb-bbc2-cf8e7a31a579.jpg', 'Từ lâu đã trở thành món ăn quen thuộc với mỗi người với sự kết hợp hài hòa của các nguyên liệu tươi ngon: thịt ba chỉ, tôm tươi lột vỏ, rau sống và bún tươi kết hợp với nước chấm chuẩn vị', 'Gỏi tôm thịt', 1),
(2, 45000, 'p96986c4f-bbe9-4d8b-9a44-2b81b1f30bb7.jpg', 'Nem lụi là một trong những món ăn giàu chất đạm được ăn kèm cùng rau sống và chấm với nước mắm chua ngọt mang lại hương vị cực ngon. hoặc chấm với gan và đậu phộng xay nhuyễn', 'Nem lụi', 1),
(3, 35000, 'p920d5cff-faed-441a-880a-fc8c6a031bc9.jpg', 'Là món cuốn ngon với sự kết hợp độc đáo giữa bánh tráng, thịt heo và da giòn. Món ăn hấp dẫn bởi thịt và da vàng ruộm, giòn rụm ăn kèm với đồ chua và nước mắm chua ngọt.', 'Bì cuốn', 1),
(4, 55000, 'p9b563c14-c4b6-43bd-9dea-c600f5308eac.jpg', 'Làm từ lạp xưởng, trứng gà, cà rốt, rau xà lách, củ sắn, tôm khô, rau thơm. Thái nhỏ các loại và gói cùng lớp bánh tráng mềm thơm', 'Bò bía mặn', 1),
(5, 55000, 'p4d754d16-cdc5-4293-b69b-f35c4eea8348.jpg', 'Đây là một món ăn đơn giản và dễ làm. Mỗi cuốn phở gồm thịt bò xào, xà lách, rau thơm, cà rốt được chấm với nước mắm chua cay dễ ăn', 'Phở cuốn', 1),
(6, 45000, 'pe01b82c5-91e9-4853-a202-b16fd60fb67e.jpg', 'Bánh xèo với lớp bột bên ngoài giòn rụm, nóng hổi có thể khiến bất cứ ai mê mẩn. Phần thịt ngọt bên trong giúp bánh tròn vị hơn', 'Bánh xèo', 1),
(7, 25000, 'pa0bdbdfa-da95-43cb-8f50-9276409debea.jpg', '', 'Bia', 5),
(8, 15000, 'p3de9051e-9e2a-4106-9811-6714968a1d78.jpg', '', 'Trà chanh', 5),
(9, 35000, 'pf1c4ebf1-a9c7-41eb-aa7b-e5192b2dae59.jpg', '', 'Sinh tố dâu', 5),
(10, 145000, 'p6d6ff4e8-52ab-4934-ac3d-0977f1de2588.jpg', '', 'Rượu vang đỏ', 5),
(11, 20000, 'pf36e27a8-dfc4-49d9-b444-85e5b5284db6.jpg', '', 'StrongBow', 5),
(12, 15000, 'pc6892eaf-1d55-4fc5-9f63-4c92825fe4c2.jpg', '', '7 Up', 5),
(13, 155000, 'pa2afb48b-351c-4d3a-ac2c-15231ad39e2d.jpg', 'Thịt bò nhúng dấm nên chọn loại thịt thăn bò nõn hoặc phi lê bò mềm. Món lẩu bò nhúng dấm này rất thích hợp với những buổi tụ tập gia đình và bạn bè, các bạn có thể thay đổi lượng nguyên liệu cho vừa đủ', 'Lẩu bò nhúng giấm', 2),
(14, 165000, 'p97b6a69c-a826-4c71-83dd-51437f836cd0.jpg', 'Có vị ngọt thanh mát, thơm mềm và mùi hương lôi cuốn không thể cưỡng nổi. Với những miếng giò tai dai giòn, chả cá rán thơm béo, đậu hũ nóng hổi, những con rạm chiên giòn thấm đều gia vị, ngậm đủ nước lẩu càng thơm béo', 'Lẩu riêu cua bắp bò', 2),
(15, 155000, 'pc3d36c40-6a39-432f-87a7-878722b326a6.jpg', 'Là sự kết hợp độc đáo giữ vị ngọt nước từ xương heo và cá thác lác, vị đắng nhẫn nhẫn của khổ qua. Vị đắng được trung hòa bởi các hương vị khác tạo nên một vị ngọt đậm đà lạ miệng và không kém phần hấp dẫn', 'Lẩu cá thác lác', 2),
(16, 145000, 'pe4082394-d92f-4ded-820c-7a6a1dff750e.jpg', 'Với nguyên liệu chủ yếu là rau củ quả hay nấm, cùng tàu hủ, mộc chay vô cùng bắt mắt. Nếu là người thích chua cay thì lẩu chay thái lan sẽ làm thảo mãn bạn, nếu là người không ăn cay được thì món lẩu rau nấm chứa nhiều chất xơ tốt cho sức khỏe gia đình bạn', 'Lẩu chay', 2),
(17, 135000, 'p2d46577a-454e-4dba-8b96-81767641c72d.jpg', 'Đặc sản miền Tây Nam Bộ. Có lẽ được trời phú cho nguồn cá tôm phong phú mà nơi đây cũng sản sinh ra nhiều món lẩu đa dạng. Lẩu cá kèo là một trong những nét đặc sắc của con dân miền sông nước đấy.', 'Lẩu cá kèo', 2),
(18, 135000, 'pfc848cc3-bca9-4fe0-bd44-81d0aad0bc1b.jpg', 'Lẩu gà ớt hiểm có vị cay nồng của ớt hơi the the, ngược lại nước lẩu thì vô cùng ngọt và thơm bởi kỷ tử, hoa hồi, quế,… Tất cả tạo nên một mùi hương khó cưỡng mà những ai thưởng thức qua sẽ không bao giờ quên.', 'Lẩu gà ớt hiểm', 2),
(19, 85000, 'pa5506e42-0c4d-4805-9f67-d22a82e3ab77.jpg', 'Vị thơm của xôi, vị ngọt thanh mát của xoài đã tạo nên món xôi xoài ngon khó cưỡng, chinh phục nhiều thực khách ngay từ lần thử đầu tiên', 'Tép đồng xào bông điên điển', 4),
(20, 65000, 'pc41f86bd-1b74-410c-b1d4-45581ee91f5f.jpg', 'Món ăn thơm lừng mùi tỏi hòa quyện mùi thơm của hành lá và ngò gai. Măng trúc giòn ngon, thịt bò mềm, thấm đều gia vị món ăn sẽ ngon hơn nếu chấm với nước tương cà ăn kèm với cơm nhé!', 'Măng trúc xào', 4),
(21, 145000, 'pfa0d1081-7a09-490e-9256-8b207ffdcbea.jpg', 'Gỏi bắp bò hoa chuối vừa thơm ngon, lạ miệng lại giàu dinh dưỡng với thịt bò mềm ngon, hoa chuối giòn ngon, nước gỏi chua cay đậm đà thật hấp dẫn.', 'Nộm bắp bò hoa chuối', 4),
(22, 35000, 'p02438d0c-1594-42b7-997a-e027c085892e.jpg', 'Vị thơm của xôi, vị ngọt thanh mát của xoài đã tạo nên món xôi xoài ngon khó cưỡng, chinh phục nhiều thực khách ngay từ lần thử đầu tiên', 'Xôi xoài dẻo', 4),
(23, 55000, 'p4d228760-dd20-46f7-ae53-2763848aaf11.jpg', 'Món nộm rau muống xanh tươi mát cùng màu vàng đều đẹp mắt của tôm khô. Khi nếm thử sẽ cảm nhận được sự hòa quyện của vị chua, cay, ngọt cùng 1 lúc. Ăn kèm cơm trắng đảm bảo thơm ngon bất ngờ, ăn mãi không ngừng tay.', 'Nộm rau muống', 4),
(24, 55000, 'pbb31b32a-7501-43d9-882d-ef098a7e81ce.jpg', 'Salad rau mầm trộn thịt bò ngon đậm đà là sự kết hợp giữa vị ngọt của thịt bò, vị cay hăng của rau mầm, hành tây cùng vị cay, chua ngọt của nước trộn.', 'Salad rau mầm thịt bò', 4),
(25, 65000, 'p287141b1-cb13-438c-ac44-f410181638dd.jpg', 'Khi thưởng thức, bạn sẽ cảm nhận được từng thớ thịt bò đậm vị, ngọt mềm như tan ngay nơi đầu lưỡi hòa cùng hương thơm đặc trưng của sả xen lẫn chút cay nhẹ. Phải nói là cực kỳ kích thích vị giác của bất kỳ ai luôn đấy.', 'Bò nướng sả', 3),
(26, 115000, 'p071ef871-d953-444c-92c9-af48db8695de.jpg', 'Món cá lăng nướng thơm ngon, vừa ăn. Thịt cá dai mềm, thấm đậm gia vị, cá ăn kèm với rau sống cuốn bánh tráng hoặc ăn kèm cơm trắng cũng rất ngon và dinh dưỡng.', 'Cá lăng nướng', 3),
(27, 35000, 'p89f3cc50-6704-488c-b718-4d1fe1b4dd99.jpg', 'Hàu nướng mỡ hành là một trong những món hải sản hấp dẫn, hương vị béo thơm, ngon “ngây ngất” Món này có thể dùng kèm với rau răm, nước mắm ngọt thêm vài lát ớt nữa sẽ rất ngon và đậm vị.', 'Hàu nướng', 3),
(28, 85000, 'pbf98b9ce-0817-4e11-b789-72ceb9161052.jpg', 'Mực nướng thơm ngon dai sừn sựt, đậm đà, thơm mùi chao cùng các gia vị cay đậm đà, ăn cùng với rau sống và chấm muối ớt xanh để tăng thêm hương vị cho món ăn nhé!', 'Mực nướng', 3),
(29, 135000, 'pa3b126b6-87c2-4350-ad93-b3e8613f6b4c.jpg', 'Gà nướng ăn với cơm lam là một trong những đặc sản núi rừng nổi tiếng của người đồng bào Tây Nguyên. Gà nướng thơm lừng, cơm lam dẻo ngọt khiến ai đã từng ăn một lần sẽ không bao giờ quên.', 'Gà nướng cơm lam', 3),
(30, 75000, 'p9af4acad-2719-4bf6-9d7a-18970c6bfa1e.jpg', 'Ếch nướng muối ớt có hương vị thơm ngon, từng thớ thịt mềm, giòn ruộm cộng với vị mặn mòi của muối ớt rất hấp dẫn vị giác.', 'Ếch nướng muối ớt', 3);

-- --------------------------------------------------------

--
-- Table structure for table `nhommonans`
--

CREATE TABLE `nhommonans` (
  `maNhomMon` bigint(20) NOT NULL,
  `tenNhomMon` varchar(100) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `nhommonans`
--

INSERT INTO `nhommonans` (`maNhomMon`, `tenNhomMon`) VALUES
(1, 'Cuốn'),
(2, 'Lẩu'),
(3, 'Nướng'),
(4, 'Món ăn nhẹ'),
(5, 'Đồ uống');

-- --------------------------------------------------------

--
-- Table structure for table `quantris`
--

CREATE TABLE `quantris` (
  `username` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(60) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `quantris`
--

INSERT INTO `quantris` (`username`, `password`) VALUES
('admin', '$2a$10$TNPqpq32LBJ43lK/smZYu.Y5BYzZx22n.jhlu1VrkAhzEgRK0FwMm');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `chitiethoadons`
--
ALTER TABLE `chitiethoadons`
  ADD PRIMARY KEY (`maCTHD`),
  ADD KEY `FK5g2sse3ncdktd5uecoufaxfaq` (`maHoaDon`),
  ADD KEY `FKns8ppvrwm1bc01v4swepmnseo` (`maMonAn`);

--
-- Indexes for table `datbans`
--
ALTER TABLE `datbans`
  ADD PRIMARY KEY (`maDatBan`);

--
-- Indexes for table `hoadons`
--
ALTER TABLE `hoadons`
  ADD PRIMARY KEY (`maHoaDon`);

--
-- Indexes for table `lienhes`
--
ALTER TABLE `lienhes`
  ADD PRIMARY KEY (`maLienHe`);

--
-- Indexes for table `monans`
--
ALTER TABLE `monans`
  ADD PRIMARY KEY (`maMonAn`),
  ADD KEY `FK2ht5gd4wq8ulk51s6u88wusce` (`maNhomMon`);

--
-- Indexes for table `nhommonans`
--
ALTER TABLE `nhommonans`
  ADD PRIMARY KEY (`maNhomMon`);

--
-- Indexes for table `quantris`
--
ALTER TABLE `quantris`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `chitiethoadons`
--
ALTER TABLE `chitiethoadons`
  MODIFY `maCTHD` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `datbans`
--
ALTER TABLE `datbans`
  MODIFY `maDatBan` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `hoadons`
--
ALTER TABLE `hoadons`
  MODIFY `maHoaDon` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `lienhes`
--
ALTER TABLE `lienhes`
  MODIFY `maLienHe` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `monans`
--
ALTER TABLE `monans`
  MODIFY `maMonAn` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT for table `nhommonans`
--
ALTER TABLE `nhommonans`
  MODIFY `maNhomMon` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `chitiethoadons`
--
ALTER TABLE `chitiethoadons`
  ADD CONSTRAINT `FK5g2sse3ncdktd5uecoufaxfaq` FOREIGN KEY (`maHoaDon`) REFERENCES `hoadons` (`maHoaDon`),
  ADD CONSTRAINT `FKns8ppvrwm1bc01v4swepmnseo` FOREIGN KEY (`maMonAn`) REFERENCES `monans` (`maMonAn`);

--
-- Constraints for table `monans`
--
ALTER TABLE `monans`
  ADD CONSTRAINT `FK2ht5gd4wq8ulk51s6u88wusce` FOREIGN KEY (`maNhomMon`) REFERENCES `nhommonans` (`maNhomMon`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
