-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 05, 2011 at 05:15 PM
-- Server version: 5.1.53
-- PHP Version: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `trains`
--
CREATE DATABASE `trains` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `trains`;

-- --------------------------------------------------------

--
-- Table structure for table `bank`
--

CREATE TABLE IF NOT EXISTS `bank` (
  `cardnum` int(19) NOT NULL,
  `bankname` varchar(40) NOT NULL,
  PRIMARY KEY (`cardnum`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bank`
--

INSERT INTO `bank` (`cardnum`, `bankname`) VALUES
(1234567890, 'sbi'),
(2147483647, 'SBI'),
(879879870, 'kjhkh'),
(1234, 'asdf'),
(12345, 'IOB'),
(123, 'banhg'),
(11, 'qq1'),
(9876543, 'sbi'),
(12, 'sbi'),
(1215658976, 'sbi'),
(1234567, 'abcd'),
(12345678, 'abcd'),
(8907, 'sbi'),
(344, '123'),
(7689, 'hjki'),
(2345, 'SBI'),
(789, 'PNB'),
(89808, 'PNB'),
(123456, 'PNB'),
(578923, 'SBI'),
(1332435, 'PNB'),
(12577, 'PNB'),
(122, 'SBI'),
(312, 'SBI');

-- --------------------------------------------------------

--
-- Table structure for table `bookhistory`
--

CREATE TABLE IF NOT EXISTS `bookhistory` (
  `pnrno` int(5) NOT NULL,
  `date` date NOT NULL,
  `amount` int(5) NOT NULL,
  `cardnum` int(19) NOT NULL,
  `userid` varchar(20) NOT NULL,
  PRIMARY KEY (`pnrno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `bookhistory`
--

INSERT INTO `bookhistory` (`pnrno`, `date`, `amount`, `cardnum`, `userid`) VALUES
(43, '2011-11-03', 2342, 122, 'fufu1'),
(42, '2011-11-02', 14052, 1234567890, 'fufu1'),
(24, '2011-10-19', 1700, 8907, 'pulkit'),
(40, '2011-11-03', 19272, 1234567890, 'kshav'),
(39, '2011-11-02', 7372, 12577, 'fufu1'),
(28, '2011-10-19', 3400, 1234, 'rritisha'),
(31, '2011-10-19', 392, 2147483647, 'samarth793'),
(38, '2011-11-02', 193, 1332435, 'fufu1'),
(44, '2011-11-02', 1232, 2147483647, 'priyanshu');

-- --------------------------------------------------------

--
-- Table structure for table `customerdetails`
--

CREATE TABLE IF NOT EXISTS `customerdetails` (
  `userid` varchar(20) NOT NULL,
  `name` varchar(30) NOT NULL,
  `password` varchar(15) NOT NULL,
  `street` varchar(50) NOT NULL,
  `city` varchar(18) NOT NULL,
  `state` varchar(15) NOT NULL,
  `pincode` int(7) NOT NULL,
  `phone` int(12) NOT NULL,
  `emailid` varchar(35) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customerdetails`
--

INSERT INTO `customerdetails` (`userid`, `name`, `password`, `street`, `city`, `state`, `pincode`, `phone`, `emailid`) VALUES
('richaa', 'richu', '123456', 'bareilly', 'bareilly', 'up', 0, 0, 'drric88@gmail.com'),
('abc', 'xyz', '', 'GH', '', '', 0, 0, ''),
('fufu1', 'fufu', 'fufu', 'fufu', 'fufu', 'fufu', 123456, 2147483647, 'fufu@fufu.com'),
('kush', 'kush', '420', '220', 'jpr', 'rj', 123456, 2147483647, 'sweetsonu.meena@gmail.com'),
('shanu.bhardwaj', 'shanu', 'panshul', 'fatehganj', 'bareilly', 'up', 243001, 123, 'shanu10cool@gmail.com'),
('pulkit', 'pulkit', 'abcd', 'bareilly', 'bareilly', 'up', 243001, 87, 'abc@def.com'),
('', '', '', '', '', '', 0, 0, ''),
('rritisha', 'rritisha', 'rriti', 'iiit allahabad', '', 'uttar pradesh', 0, 0, 'rritisha2411@gmail.com'),
('samarth793', 'samarth', '12345', '307 kali bari', 'bareilly', 'up', 243001, 786, 'samarth793@gmail.com'),
('abcd', '', '', '', '', '', 0, 0, ''),
('dee', '', '', '', '', '', 0, 0, ''),
('dep', '', '', '', '', '', 0, 0, ''),
('hgcjfh', '', '', '', '', '', 0, 0, ''),
('risha', '', '', '', '', '', 0, 0, ''),
('bans', '', '', '', '', '', 0, 0, ''),
('rish1', 'rishabhbhardwaj', '123456', '', '', '', 0, 0, 'abc@def.com'),
('ab1', 'abqw', '1234', '', '', '', 0, 0, 'abc@def.com'),
('kshav', 'KeshavMaheshwari', 'pass', '', '', '', 0, 0, 'kshav1908@gmail.com'),
('priyanshu', 'priyanshusharma', 'sharma', 'd-92/11,jagdish vihar', 'bareilly', 'up', 243122, 2147483647, 'priyanshubly@gmail.com'),
('abc12', 'abcdef', 'abcabc', '', '', '', 0, 0, 'abc@def.com'),
('abcdef', 'abcddefg', 'qwerty', '', '', '', 0, 0, 'asd.cdf.w@b');

-- --------------------------------------------------------

--
-- Table structure for table `fare`
--

CREATE TABLE IF NOT EXISTS `fare` (
  `train_no` int(5) NOT NULL,
  `acseats` int(5) NOT NULL,
  `nonacseats` int(5) NOT NULL,
  PRIMARY KEY (`train_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fare`
--

INSERT INTO `fare` (`train_no`, `acseats`, `nonacseats`) VALUES
(14312, 1219, 650),
(14311, 1219, 650),
(19269, 1232, 750),
(19270, 1232, 750),
(9409, 2232, 1450),
(9410, 2232, 1450),
(12937, 2132, 1432),
(12938, 2132, 1432),
(12941, 2132, 1432),
(12942, 2142, 1412),
(12947, 2142, 1412),
(12948, 2142, 1412),
(19569, 2042, 1432),
(19570, 2042, 1432),
(14116, 2242, 1232),
(14115, 2242, 1232),
(14308, 2342, 1242),
(14307, 2342, 1242),
(14370, 2342, 1242),
(14369, 2342, 1242),
(14512, 2342, 1242),
(14511, 2342, 1242),
(12204, 842, 242),
(12203, 842, 242),
(12230, 842, 242),
(12229, 842, 242),
(12392, 942, 342),
(12391, 942, 342),
(14316, 942, 342),
(14315, 942, 342),
(14208, 742, 242),
(1269, 2742, 1442),
(12270, 2742, 1442),
(12433, 3742, 2442),
(12434, 3742, 2442),
(12611, 3242, 2442),
(12612, 3242, 2442),
(12687, 2742, 1442),
(12688, 2742, 1442),
(12272, 1742, 642),
(12271, 1742, 642),
(14018, 1742, 642),
(14017, 1742, 642),
(14674, 1642, 542),
(14673, 1642, 542),
(15610, 1642, 542),
(15609, 1642, 542),
(12138, 3642, 1942),
(12137, 3642, 1942),
(12450, 3672, 1922),
(12449, 3672, 1922),
(12904, 3672, 1922),
(12903, 3672, 1922),
(22926, 3572, 1822),
(22925, 3572, 1822),
(11028, 4572, 2822),
(11027, 4572, 2822),
(11048, 4532, 2722),
(11047, 4532, 2722),
(12164, 4532, 2722),
(12163, 4532, 2722),
(12030, 3456, 1988),
(12029, 3456, 1988),
(12032, 3556, 1928),
(12031, 3556, 1928),
(12498, 3456, 2018),
(12497, 3456, 2018),
(11058, 3556, 1758),
(11057, 3556, 1758),
(12332, 3213, 1223),
(12331, 3213, 1223),
(12431, 3213, 1223),
(12430, 3213, 1223),
(12537, 3213, 1223),
(12536, 3213, 1223),
(15359, 2213, 823),
(15360, 2213, 823),
(12345, 2213, 823),
(12344, 2213, 823),
(23432, 2213, 823),
(23431, 2213, 823),
(34543, 4313, 1823),
(34542, 4313, 1823),
(22344, 4313, 1823),
(22345, 4313, 1823),
(22442, 4313, 1823),
(22441, 4313, 1823),
(22354, 4313, 1823),
(22353, 4313, 1823),
(17653, 3212, 1543),
(17652, 3212, 1543),
(24143, 3212, 1543),
(24142, 3212, 1543),
(22312, 3212, 1543),
(22311, 3212, 1543),
(33431, 3212, 1543),
(33430, 3212, 1543),
(12523, 2212, 1843),
(12522, 2212, 1843),
(13312, 2212, 1843),
(13311, 2212, 1843),
(56567, 2212, 1843),
(56566, 2212, 1843),
(12112, 5323, 3643),
(12111, 3323, 1643),
(67686, 2323, 1643),
(67687, 2323, 1643);

-- --------------------------------------------------------

--
-- Table structure for table `passenger`
--

CREATE TABLE IF NOT EXISTS `passenger` (
  `pid` int(3) NOT NULL AUTO_INCREMENT,
  `name` varchar(25) NOT NULL,
  `age` int(2) NOT NULL,
  `gender` varchar(6) NOT NULL,
  `pnrno` int(5) NOT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=46 ;

--
-- Dumping data for table `passenger`
--

INSERT INTO `passenger` (`pid`, `name`, `age`, `gender`, `pnrno`) VALUES
(13, 'cbdhjcg', 12, 'male', 40),
(6, 'w2', 18, 'male', 38),
(10, 'q2', 25, 'male', 39),
(11, 'q3', 13, 'female', 39),
(12, 'q4', 20, 'female', 39),
(14, 'dvcgsdvh', 23, 'female', 40),
(15, 'dg', 23, 'male', 40),
(16, 'dgsh', 45, 'male', 40),
(17, 'fsggs', 56, 'male', 40),
(18, 'gfsw', 45, 'female', 40),
(38, 'abc1', 19, 'male', 44),
(37, 'abgh', 12, 'male', 43),
(36, 'i6', 13, 'female', 42),
(35, 'i5', 12, 'male', 42),
(34, 'i4', 45, 'female', 42),
(33, 'i3', 34, 'male', 42),
(32, 'i2', 13, 'female', 42),
(31, 'i1', 12, 'male', 42),
(40, 'abc1', 12, 'male', 45);

-- --------------------------------------------------------

--
-- Table structure for table `seatavail`
--

CREATE TABLE IF NOT EXISTS `seatavail` (
  `date` date NOT NULL,
  `trainno` int(5) NOT NULL,
  `acseats` int(3) NOT NULL,
  `nonacseats` int(3) NOT NULL,
  PRIMARY KEY (`date`,`trainno`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `seatavail`
--

INSERT INTO `seatavail` (`date`, `trainno`, `acseats`, `nonacseats`) VALUES
('2011-11-03', 12938, 70, 200),
('2011-11-04', 12938, 70, 200),
('2011-11-04', 12937, 70, 200),
('2011-11-03', 12937, 70, 200),
('2011-11-02', 12937, 70, 200),
('2011-11-03', 9410, 70, 200),
('2011-11-02', 14312, 5, 200),
('2011-11-04', 9410, 70, 200),
('2011-11-02', 9410, 70, 200),
('2011-11-04', 9409, 70, 200),
('2011-11-03', 9409, 70, 200),
('2011-11-02', 9409, 70, 200),
('2011-11-02', 19270, 70, 200),
('2011-11-03', 19270, 70, 200),
('2011-11-04', 19270, 70, 200),
('2011-11-04', 19269, 70, 200),
('2011-11-03', 19269, 70, 200),
('2011-11-02', 19269, 70, 200),
('2011-11-02', 14311, 70, 200),
('2011-11-03', 14311, 70, 200),
('2011-11-04', 14311, 70, 200),
('2011-11-04', 14312, 70, 200),
('2011-11-03', 14312, 70, 200),
('2011-11-02', 12270, 70, 200),
('2011-11-03', 12270, 70, 200),
('2011-11-04', 12270, 70, 200),
('2011-11-04', 12269, 70, 200),
('2011-11-03', 12269, 70, 200),
('2011-11-02', 12269, 70, 200),
('2011-11-02', 12433, 70, 200),
('2011-11-03', 12433, 70, 200),
('2011-11-04', 12433, 70, 200),
('2011-11-04', 12434, 70, 200),
('2011-11-03', 12434, 70, 200),
('2011-11-02', 12434, 70, 200),
('2011-11-02', 12611, 70, 200),
('2011-11-03', 12611, 70, 200),
('2011-11-04', 12611, 70, 200),
('2011-11-04', 12612, 70, 200),
('2011-11-03', 12612, 70, 200),
('2011-11-02', 12612, 70, 200),
('2011-11-02', 12687, 70, 200),
('2011-11-03', 12687, 70, 200),
('2011-11-04', 12687, 70, 200),
('2011-11-04', 12688, 70, 200),
('2011-11-03', 12688, 70, 200),
('2011-11-02', 12688, 70, 200),
('2011-11-02', 12272, 70, 200),
('2011-11-03', 12272, 70, 200),
('2011-11-04', 12272, 70, 200),
('2011-11-04', 12271, 70, 200),
('2011-11-03', 12271, 70, 200),
('2011-11-02', 12271, 70, 200),
('2011-11-02', 14018, 70, 200),
('2011-11-03', 14018, 70, 200),
('2011-11-04', 14018, 70, 200),
('2011-11-04', 14017, 70, 200),
('2011-11-03', 14017, 70, 200),
('2011-11-02', 14017, 70, 200),
('2011-11-03', 14674, 70, 200),
('2011-11-02', 14674, 70, 200),
('2011-11-04', 14674, 70, 200),
('2011-11-04', 14673, 70, 200),
('2011-11-03', 14673, 70, 200),
('2011-11-02', 14673, 70, 200),
('2011-11-02', 15610, 70, 200),
('2011-11-03', 15610, 70, 200),
('2011-11-04', 15610, 70, 200),
('2011-11-04', 15609, 70, 200),
('2011-11-03', 15609, 70, 200),
('2011-11-02', 15609, 70, 200),
('2011-11-02', 12138, 70, 200),
('2011-11-03', 12138, 70, 200),
('2011-11-04', 12138, 70, 200),
('2011-11-04', 12137, 70, 200),
('2011-11-03', 12137, 70, 200),
('2011-11-02', 12137, 70, 200),
('2011-11-02', 12450, 70, 200),
('2011-11-03', 12450, 70, 200),
('2011-11-04', 12450, 70, 200),
('2011-11-04', 12449, 70, 200),
('2011-11-03', 12449, 70, 200),
('2011-11-02', 12449, 70, 200),
('2011-11-02', 22926, 70, 200),
('2011-11-03', 22926, 70, 200),
('2011-11-04', 22926, 70, 200),
('2011-11-04', 22925, 70, 200),
('2011-11-03', 22925, 70, 200),
('2011-11-02', 22925, 70, 200),
('2011-11-02', 11028, 70, 200),
('2011-11-03', 11028, 70, 200),
('2011-11-04', 11028, 70, 200),
('2011-11-04', 11027, 70, 200),
('2011-11-03', 11027, 70, 200),
('2011-11-02', 11027, 70, 200),
('2011-11-02', 11048, 70, 200),
('2011-11-03', 11048, 70, 200),
('2011-11-04', 11048, 70, 200),
('2011-11-04', 11047, 70, 200),
('2011-11-03', 11047, 70, 200),
('2011-11-02', 11047, 70, 200),
('2011-11-02', 12164, 70, 200),
('2011-11-03', 12164, 70, 200),
('2011-11-04', 12164, 70, 200),
('2011-11-04', 12163, 70, 200),
('2011-11-03', 12163, 70, 200),
('2011-11-02', 12163, 70, 200),
('2011-11-02', 12030, 70, 200),
('2011-11-03', 12030, 70, 200),
('2011-11-04', 12030, 70, 200),
('2011-11-04', 12029, 70, 200),
('2011-11-03', 12029, 70, 200),
('2011-11-02', 12029, 70, 200),
('2011-11-02', 12032, 70, 200),
('2011-11-03', 12032, 70, 200),
('2011-11-04', 12032, 70, 200),
('2011-11-04', 12031, 70, 200),
('2011-11-03', 12031, 70, 200),
('2011-11-02', 12031, 70, 200),
('2011-11-02', 12498, 70, 200),
('2011-11-03', 12498, 70, 200),
('2011-11-04', 12498, 70, 200),
('2011-11-04', 12497, 70, 200),
('2011-11-03', 12497, 70, 200),
('2011-11-02', 12497, 70, 200),
('2011-11-02', 11058, 70, 200),
('2011-11-03', 11058, 70, 200),
('2011-11-04', 11058, 70, 200),
('2011-11-04', 11057, 70, 200),
('2011-11-03', 11057, 70, 200),
('2011-11-02', 11057, 70, 200),
('2011-11-02', 12938, 70, 200),
('2011-11-02', 12941, 70, 200),
('2011-11-03', 12941, 70, 200),
('2011-11-04', 12941, 70, 200),
('2011-11-04', 12942, 70, 200),
('2011-11-03', 12942, 70, 200),
('2011-11-02', 12942, 66, 200),
('2011-11-02', 12947, 68, 200),
('2011-11-03', 12947, 70, 200),
('2011-11-04', 12947, 70, 200),
('2011-11-04', 12948, 70, 200),
('2011-11-03', 12948, 70, 200),
('2011-11-02', 12948, 70, 200),
('2011-11-02', 19569, 70, 200),
('2011-11-03', 19569, 70, 200),
('2011-11-04', 19569, 70, 200),
('2011-11-04', 19570, 70, 200),
('2011-11-03', 19570, 70, 200),
('2011-11-02', 19570, 70, 200),
('2011-11-02', 14116, 70, 200),
('2011-11-03', 14116, 70, 200),
('2011-11-04', 14116, 70, 200),
('2011-11-04', 14115, 70, 200),
('2011-11-03', 14115, 70, 200),
('2011-11-02', 14115, 70, 207),
('2011-11-02', 14308, 70, 200),
('2011-11-03', 14308, 70, 200),
('2011-11-04', 14308, 70, 200),
('2011-11-04', 14307, 70, 200),
('2011-11-03', 14307, 66, 200),
('2011-11-02', 14307, 70, 200),
('2011-11-02', 14370, 70, 200),
('2011-11-03', 14370, 70, 200),
('2011-11-04', 14370, 70, 200),
('2011-11-04', 14369, 70, 200),
('2011-11-03', 14369, 70, 200),
('2011-11-02', 14369, 70, 200),
('2011-11-02', 14512, 64, 200),
('2011-11-03', 14512, 70, 200),
('2011-11-04', 14512, 70, 200),
('2011-11-04', 14511, 70, 200),
('2011-11-03', 14511, 70, 200),
('2011-11-02', 14511, 70, 200),
('2011-11-02', 12204, 70, 200),
('2011-11-03', 12204, 70, 200),
('2011-11-04', 12204, 70, 200),
('2011-11-04', 12203, 70, 200),
('2011-11-03', 12203, 70, 200),
('2011-11-02', 12203, 70, 200),
('2011-11-02', 12230, 70, 200),
('2011-11-03', 12230, 70, 200),
('2011-11-04', 12230, 70, 200),
('2011-11-04', 12229, 70, 200),
('2011-11-03', 12229, 70, 200),
('2011-11-02', 12229, 70, 200),
('2011-11-02', 12392, 70, 200),
('2011-11-03', 12392, 70, 200),
('2011-11-04', 12392, 70, 200),
('2011-11-04', 12391, 70, 200),
('2011-11-02', 12391, 70, 200),
('2011-11-03', 12391, 70, 200),
('2011-11-02', 14316, 70, 200),
('2011-11-03', 14316, 70, 200),
('2011-11-04', 14316, 70, 200),
('2011-11-04', 14315, 70, 200),
('2011-11-03', 14315, 70, 200),
('2011-11-02', 14315, 70, 200),
('2011-11-02', 14208, 70, 200),
('2011-11-03', 14208, 70, 200),
('2011-11-04', 14208, 70, 200),
('2011-11-04', 14207, 70, 200),
('2011-11-03', 14207, 70, 200),
('2011-11-02', 14207, 70, 200),
('2011-11-02', 12332, 70, 200),
('2011-11-03', 12332, 70, 200),
('2011-11-04', 12332, 70, 200),
('2011-11-04', 12331, 70, 200),
('2011-11-03', 12331, 70, 200),
('2011-11-02', 12331, 70, 200),
('2011-11-02', 12431, 70, 200),
('2011-11-03', 12431, 70, 200),
('2011-11-03', 12430, 70, 200),
('2011-11-04', 12431, 70, 200),
('2011-11-04', 12430, 70, 200),
('2011-11-02', 12430, 70, 200),
('2011-11-02', 12537, 70, 200),
('2011-11-03', 12537, 70, 200),
('2011-11-04', 12537, 70, 200),
('2011-11-04', 12536, 70, 200),
('2011-11-03', 12536, 70, 200),
('2011-11-02', 12536, 70, 200),
('2011-11-02', 15360, 70, 200),
('2011-11-03', 15360, 70, 200),
('2011-11-04', 15360, 70, 200),
('2011-11-04', 15359, 70, 200),
('2011-11-03', 15359, 70, 200),
('2011-11-02', 15359, 70, 200),
('2011-11-02', 12345, 70, 200),
('2011-11-03', 12345, 70, 200),
('2011-11-04', 12345, 70, 200),
('2011-11-04', 12344, 70, 200),
('2011-11-03', 12344, 70, 200),
('2011-11-02', 12344, 70, 200),
('2011-11-02', 23432, 70, 200),
('2011-11-03', 23432, 70, 200),
('2011-11-04', 23432, 70, 200),
('2011-11-04', 23431, 70, 200),
('2011-11-03', 23431, 70, 200),
('2011-11-02', 23431, 70, 200),
('2011-11-02', 34543, 70, 200),
('2011-11-03', 34543, 70, 200),
('2011-11-04', 34543, 70, 200),
('2011-11-04', 34542, 70, 200),
('2011-11-03', 34542, 70, 200),
('2011-11-02', 34542, 70, 200),
('2011-11-02', 22345, 70, 200),
('2011-11-03', 22345, 70, 200),
('2011-11-04', 22345, 70, 200),
('2011-11-04', 22344, 70, 200),
('2011-11-03', 22344, 70, 200),
('2011-11-02', 22344, 70, 200),
('2011-11-02', 22442, 70, 200),
('2011-11-03', 22442, 70, 200),
('2011-11-04', 22442, 70, 200),
('2011-11-04', 22441, 70, 200),
('2011-11-03', 22441, 70, 200),
('2011-11-02', 22441, 70, 200),
('2011-11-02', 22354, 70, 200),
('2011-11-03', 22354, 70, 200),
('2011-11-04', 22354, 70, 200),
('2011-11-04', 22353, 70, 200),
('2011-11-03', 22353, 70, 200),
('2011-11-02', 22353, 70, 200),
('2011-11-02', 17653, 70, 200),
('2011-11-03', 17653, 70, 200),
('2011-11-04', 17653, 70, 200),
('2011-11-04', 17652, 70, 200),
('2011-11-03', 17652, 70, 200),
('2011-11-02', 17652, 70, 200),
('2011-11-02', 24143, 70, 200),
('2011-11-03', 24143, 70, 200),
('2011-11-04', 24143, 70, 200),
('2011-11-04', 24142, 70, 200),
('2011-11-03', 24142, 70, 200),
('2011-11-02', 24142, 70, 200),
('2011-11-02', 22312, 70, 200),
('2011-11-03', 22312, 64, 200),
('2011-11-04', 22312, 70, 200),
('2011-11-04', 22311, 70, 200),
('2011-11-03', 22311, 70, 200),
('2011-11-02', 22311, 70, 200),
('2011-11-02', 33431, 70, 200),
('2011-11-03', 33431, 70, 200),
('2011-11-04', 33431, 70, 200),
('2011-11-04', 33430, 70, 200),
('2011-11-03', 33430, 70, 200),
('2011-11-02', 33430, 70, 200),
('2011-11-02', 12523, 70, 200),
('2011-11-03', 12523, 70, 200),
('2011-11-04', 12523, 70, 200),
('2011-11-04', 12522, 70, 200),
('2011-11-03', 12522, 70, 200),
('2011-11-02', 12522, 70, 200),
('2011-11-02', 13312, 70, 200),
('2011-11-03', 13312, 70, 200),
('2011-11-04', 13312, 70, 200),
('2011-11-04', 13311, 70, 200),
('2011-11-03', 13311, 70, 200),
('2011-11-02', 13311, 70, 200),
('2011-11-02', 56567, 70, 200),
('2011-11-03', 56567, 70, 200),
('2011-11-04', 56567, 70, 200),
('2011-11-04', 56566, 70, 200),
('2011-11-03', 56566, 70, 200),
('2011-11-02', 56566, 70, 198),
('2011-11-02', 12112, 70, 200),
('2011-11-03', 12112, 70, 200),
('2011-11-04', 12112, 70, 200),
('2011-11-04', 12111, 70, 200),
('2011-11-03', 12111, 70, 200),
('2011-11-02', 12111, 70, 200),
('2011-11-02', 67687, 70, 200),
('2011-11-03', 67687, 70, 200),
('2011-11-04', 67687, 70, 200),
('2011-11-03', 67686, 70, 200),
('2011-11-02', 67686, 70, 200);

-- --------------------------------------------------------

--
-- Table structure for table `test`
--

CREATE TABLE IF NOT EXISTS `test` (
  `name` varchar(15) NOT NULL,
  `age` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `test`
--

INSERT INTO `test` (`name`, `age`) VALUES
('rishabh', 18),
('deepshikha', 17),
('somya', 19),
('priyanshu', 19),
('samarth', 18),
('ayushi', 19),
('pulkit', 19),
('gagan', 18),
('gagan', 18),
('vishal', 19),
('', 0),
('shailu', 19),
('', 256),
('ashish', 20),
('anshul', 11),
('abc', 12),
('ram', 10),
('abcd', 12),
('abcdw', 11),
('abcdw', 11),
('qwety', 123),
('qwert', 12);

-- --------------------------------------------------------

--
-- Table structure for table `ticket1`
--

CREATE TABLE IF NOT EXISTS `ticket1` (
  `pnrno` int(5) NOT NULL AUTO_INCREMENT,
  `trainno` int(5) NOT NULL,
  `class` varchar(12) NOT NULL,
  `captcha` varchar(3) NOT NULL,
  PRIMARY KEY (`pnrno`),
  UNIQUE KEY `captcha` (`captcha`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=50 ;

--
-- Dumping data for table `ticket1`
--

INSERT INTO `ticket1` (`pnrno`, `trainno`, `class`, `captcha`) VALUES
(5, 11224, 'acseats', '06c'),
(6, 11224, 'acseats', 'sgn'),
(7, 11224, 'acseats', 'ahe'),
(8, 11224, 'acseats', 'vxr'),
(9, 11224, 'acseats', '8u7'),
(10, 11224, 'acseats', 'b15'),
(11, 14532, 'acseats', 'cd7'),
(12, 11224, 'acseats', '751'),
(13, 11224, 'acseats', '4b5'),
(14, 11224, 'acseats', '9wu'),
(15, 11224, 'acseats', '5fg'),
(16, 11223, 'acseats', 'i8u'),
(17, 11224, 'acseats', 'b0s'),
(18, 11224, 'acseats', '86u'),
(22, 11224, 'acseats', '8q3'),
(23, 11224, 'acseats', '8xe'),
(24, 11224, 'acseats', 'r16'),
(31, 11224, 'acseats', '496'),
(28, 11224, 'acseats', '848'),
(32, 99999, 'acseats', '5f2'),
(38, 14115, 'nonacseats', 'h85'),
(39, 56566, 'nonacseats', 'sv8'),
(40, 14115, 'acseats', 'ed5'),
(42, 14512, 'acseats', 'pa3'),
(43, 14307, 'acseats', '79x'),
(44, 14115, 'nonacseats', 'iyj'),
(45, 12947, 'acseats', '66p');

-- --------------------------------------------------------

--
-- Table structure for table `train`
--

CREATE TABLE IF NOT EXISTS `train` (
  `train_no` int(5) NOT NULL,
  `train_name` varchar(20) NOT NULL,
  `source` varchar(15) NOT NULL,
  `destination` varchar(15) NOT NULL,
  PRIMARY KEY (`train_no`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `train`
--

INSERT INTO `train` (`train_no`, `train_name`, `source`, `destination`) VALUES
(12942, 'adi asansol exp', 'allahabad', 'ahemdabad'),
(12938, 'garbha exp', 'allahabad', 'ahemdabad'),
(9410, 'adi patna spl', 'allahabad', 'ahemdabad'),
(19569, 'okha bsb exp', 'ahemdabad', 'allahabad'),
(12947, 'azimabad exp', 'ahemdabad', 'allahabad'),
(12941, 'adi asansol exp', 'ahemdabad', 'allahabad'),
(12937, 'garbha exp', 'ahemdabad', 'allahabad'),
(9409, 'adi patna spl', 'ahemdabad', 'allahabad'),
(19270, 'pbr motihari exp', 'bareilly', 'ahemdabad'),
(14311, 'ala hazrat exp', 'bareilly', 'ahemdabad'),
(19269, 'pbr motihari exp', 'ahemdabad', 'bareilly'),
(14312, 'ala hazrat exp', 'ahemdabad', 'bareilly'),
(12948, 'azimabad exp', 'allahabad', 'ahemdabad'),
(19570, 'okha bsb exp', 'allahabad', 'ahemdabad'),
(14116, 'hw ald exp', 'bareilly', 'allahabad'),
(14115, 'hw ald exp', 'allahabad', 'bareilly'),
(14308, 'be lko ald pass', 'bareilly', 'allahabad'),
(14307, 'be lko ald pass', 'allahabad', 'bareilly'),
(14370, 'triveni exp', 'bareilly', 'allahabad'),
(14369, 'triveni exp', 'allahabad', 'bareilly'),
(14512, 'nauchandi exp', 'bareilly', 'allahabad'),
(14511, 'nauchandi exp', 'allahabad', 'bareilly'),
(12204, 'garib rath', 'new delhi ', 'bareilly'),
(12203, 'garib rath', 'bareilly', 'new delhi'),
(12230, 'lucknow mail', 'new delhi', 'bareilly'),
(12229, 'lucknow mail', 'bareilly', 'new delhi'),
(12392, 'shramjevi exp', 'new delhi', 'bareilly'),
(12391, 'shramjevi exp', 'bareilly', 'new delhi'),
(14316, 'intercity exp', 'new delhi', 'bareilly'),
(14315, 'intercity exp', 'bareilly', 'new delhi'),
(14208, 'padmavat exp', 'new delhi', 'bareilly'),
(14207, 'padmavat exp', 'bareilly', 'new delhi'),
(12269, 'duronto exp', 'chennai', 'new delhi'),
(12270, 'duronto exp', 'new delhi', 'chennai'),
(12433, 'rajfdhani exp', 'chennai', 'new delhi'),
(12611, 'nzm garib rath', 'chennai', 'new delhi'),
(12612, 'nzm garib rath', 'new delhi', 'chennai'),
(12434, 'rajdhani ', 'new delhi', 'chennai'),
(12687, 'dehradhun exp', 'chennai', 'new delhi'),
(12688, 'dehradhun exp', 'new delhi', 'chennai'),
(12272, 'lko duronto exp', 'new delhi', 'lucknow'),
(12271, 'lko duronto exp', 'lucknow', 'new delhi'),
(14018, 'sadbhavna exp', 'new delhi', 'lucknow'),
(14017, 'sadbhavna exp', 'lucknow', 'new delhi'),
(14674, 'shaheed exp', 'new delhi', 'lucknow'),
(14673, 'shaheed exp', 'lucknow', 'new delhi'),
(15610, 'avadh assam exp', 'new delhi', 'lucknow'),
(15609, 'avadh assam exp', 'lucknow', 'new delhi'),
(12138, 'punjab mail', 'new delhi', 'mumbai'),
(12137, 'punjab mail', 'mumbai', 'new delhi'),
(12450, 'goa smprk emp', 'new delhi', 'mumbai'),
(12449, 'goa smprk emp', 'mumbai', 'new delhi'),
(12904, 'golden temple exp', 'new delhi', 'mumbai'),
(12903, 'goa smprk emp', 'mumbai', 'new delhi'),
(22926, 'paschim exp', 'new delhi', 'mumbai'),
(22925, 'paschim exp', 'mumbai', 'new delhi'),
(11028, 'mumbai mail', 'chennai', 'mumbai'),
(11027, 'mumbai mail', 'mumbai', 'chennai'),
(11048, 'mumbai exp', 'chennai', 'mumbai'),
(11047, 'mumbai exp', 'mumbai', 'chennai'),
(12164, 'chennai exp', 'chennai', 'mumbai'),
(12163, 'chennai exp', 'mumbai', 'chennai'),
(12030, 'swarn shtbdi', 'amritsar', 'new delhi'),
(12029, 'swarn shtbdi', 'new delhi', 'amritsar'),
(12032, 'amritsar exp', 'amritsar', 'new delhi'),
(12031, 'amritsar exp', 'new delhi', 'amritsar'),
(12498, 'shane punjab', 'amritsar', 'new delhi'),
(12497, 'shane punjab', 'new delhi', 'amritsar'),
(11058, 'asr de exp', 'amritsar', 'new delhi'),
(11057, 'asr de exp', 'new delhi', 'amritsar'),
(12332, 'ahm dli exp', 'ahemdabad', 'new delhi'),
(12331, 'ahm dli exp', 'new delhi', 'ahemdabad'),
(12431, 'ahm chen pass', 'ahemdabad', 'chennai'),
(12430, 'ahm chen pass', 'chennai', 'ahemdabad'),
(12537, 'ahm lko sfa', 'ahemdabad', 'lucknow'),
(12536, 'ahm lko sfa', 'lucknow', 'ahemdabad'),
(15360, 'ahm mum pass', 'ahemdabad', 'mumbai'),
(15359, 'ahm mum pass', 'mumbai', 'ahemdabad'),
(12345, 'bhuj exp', 'ahemdabad', 'amritsar'),
(12344, 'bhuj exp', 'amritsar', 'ahemdabad'),
(23431, 'duronto exp', 'allahabad', 'new delhi'),
(23432, 'duronto exp', 'new delhi', 'allahabad'),
(34543, 'ald chn sfa', 'allahabad', 'chennai'),
(34542, 'ald chn sfa', 'chennai', 'allahabad'),
(22345, 'rajdhani exp', 'allahabad', 'lucknow'),
(22344, 'rajdhani exp', 'lucknow', 'allahabad'),
(22442, 'darbanga exp', 'allahabad', 'mumbai'),
(22441, 'darbanga exp', 'mumbai', 'allahabad'),
(22354, 'tapa mandi exp', 'allahabad', 'amritsar'),
(22353, 'tapa mandi exp', 'amritsar', 'allahabad'),
(17653, 'anna exp', 'bareilly', 'chennai'),
(17652, 'anna exp', 'chennai', 'bareilly'),
(24143, 'ganga gomti ex', 'bareilly', 'lucknow'),
(24142, 'ganga gomti ex', 'lucknow', 'bareilly'),
(22312, 'shiv ganga exp', 'bareilly', 'mumbai'),
(22311, 'shiv ganga exp', 'mumbai', 'bareilly'),
(33431, 'varuna exp', 'bareilly', 'amritsar'),
(33430, 'varuna exp', 'amritsar', 'bareilly'),
(12523, 'chennai sfa', 'lucknow', 'chennai'),
(12522, 'chennai sfa', 'chennai', 'lucknow'),
(13312, 'bandra exp', 'lucknow', 'mumbai'),
(13311, 'bandra exp', 'mumbai', 'lucknow'),
(56567, 'amritsar sfa', 'lucknow', 'amritsar'),
(56566, 'amritsar sfa', 'amritsar', 'lucknow'),
(12112, 'amr chn exp', 'amritsar', 'chennai'),
(12111, 'amr chn exp', 'chennai', 'amritsar'),
(67687, 'bagh exp', 'amritsar', 'mumbai'),
(67686, 'bhag exp', 'mumbai', 'amritsar'),
(88888, 'abcd', 'ab', 'ef');
