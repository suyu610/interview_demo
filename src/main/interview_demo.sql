/*
 Source Server Version : 80031 (8.0.31)
 Source Schema         : interview_demo

 Target Server Type    : MySQL
 File Encoding         : 65001
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `result`;
CREATE TABLE `result` (
  `input` decimal(65,6) NOT NULL,
  `result` decimal(65,6) NOT NULL,
  `ratio` decimal(65,6) NOT NULL,
  PRIMARY KEY (`input`,`ratio`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

SET FOREIGN_KEY_CHECKS = 1;
