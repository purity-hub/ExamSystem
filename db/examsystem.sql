/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : examsystem

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 31/08/2022 17:43:10
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `teacher_id` int NULL DEFAULT NULL,
  `type` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `credit` int NULL DEFAULT NULL,
  `time` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '课程' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, 'java程序设计', 1, '选修课', 3, 48);
INSERT INTO `course` VALUES (2, '数据库', 1, '必修课', 4, 48);
INSERT INTO `course` VALUES (3, '计算机网络', 1, '必修课', 3, 48);
INSERT INTO `course` VALUES (4, '计算机组成原理', 1, '必修课', 3, 48);
INSERT INTO `course` VALUES (16, '测试', 2, '必修课', 3, 48);

-- ----------------------------
-- Table structure for exam
-- ----------------------------
DROP TABLE IF EXISTS `exam`;
CREATE TABLE `exam`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `single_total` int NULL DEFAULT NULL,
  `multiple_total` int NULL DEFAULT NULL,
  `judgment_total` int NULL DEFAULT NULL,
  `short_total` int NULL DEFAULT NULL COMMENT '简答题数量',
  `end_time` datetime NULL DEFAULT NULL COMMENT '考试时间',
  `start_time` datetime NULL DEFAULT NULL COMMENT '开始考试时间',
  `create_by` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '创建者教师',
  `total_score` int NULL DEFAULT 100,
  `single_score` int NULL DEFAULT NULL,
  `multiple_score` int NULL DEFAULT NULL,
  `short_score` int NULL DEFAULT NULL,
  `judgment_score` int NULL DEFAULT NULL,
  `miaoshu` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '描述',
  `state` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `exam_time` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam
-- ----------------------------
INSERT INTO `exam` VALUES (1, 'java期末考试', '2022-06-03 07:40:52', 15, 5, 5, 3, '2022-11-20 09:21:00', '2022-06-02 07:41:00', 'admin', 112, 4, 4, 4, 4, '', NULL, 100);
INSERT INTO `exam` VALUES (2, '数据库期末考试', '2022-06-03 13:23:53', 15, 5, 6, 5, '2022-06-03 15:04:00', '2022-06-03 13:24:00', 'admin', 124, 4, 4, 4, 4, '', NULL, 100);
INSERT INTO `exam` VALUES (3, '11', '2022-06-03 17:33:25', 5, 5, 1, 1, '2022-06-03 10:23:00', '2022-06-03 09:33:00', 'admin', 67, 10, 1, 11, 1, '', NULL, 50);
INSERT INTO `exam` VALUES (4, '测试', '2022-06-03 17:37:13', 11, 11, 11, 11, '2022-06-03 11:40:00', '2022-06-03 09:38:00', 'admin', 484, 11, 11, 11, 11, '', NULL, 122);
INSERT INTO `exam` VALUES (6, '测试期末考试', '2022-06-05 16:57:22', 10, 5, 5, 4, '2022-06-05 10:36:00', '2022-06-05 08:56:00', 'purity', 70, 3, 3, 5, 1, '测试期末考试', NULL, 100);

-- ----------------------------
-- Table structure for exam_course
-- ----------------------------
DROP TABLE IF EXISTS `exam_course`;
CREATE TABLE `exam_course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `exam_id` int NULL DEFAULT NULL,
  `course_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `exam_course_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of exam_course
-- ----------------------------
INSERT INTO `exam_course` VALUES (1, 1, 1);
INSERT INTO `exam_course` VALUES (2, 2, 2);
INSERT INTO `exam_course` VALUES (3, 4, 3);
INSERT INTO `exam_course` VALUES (4, 3, 4);
INSERT INTO `exam_course` VALUES (5, 6, 16);

-- ----------------------------
-- Table structure for judgment
-- ----------------------------
DROP TABLE IF EXISTS `judgment`;
CREATE TABLE `judgment`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `exam_id` int NULL DEFAULT NULL,
  `question` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `answer` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of judgment
-- ----------------------------
INSERT INTO `judgment` VALUES (4, 1, '在异常处理中，若try中的代码可能产生多种异常则可以对应多个catch语句，若catch中的参数类型有父类子类关系，此时应该将父类放在后面，子类放在前面。', '对');
INSERT INTO `judgment` VALUES (5, 1, '子类只能继承父类的public，protected和同一个包中的package级的成员。', '对');
INSERT INTO `judgment` VALUES (6, 1, '在类中实现一个接口，则一定要实现接口中的所有方法', '错');
INSERT INTO `judgment` VALUES (7, 1, '抽象方法不仅有方法头，还应该有方法体', '错');
INSERT INTO `judgment` VALUES (8, 1, '在比较str1和str2两个字符串对象值是否相等时使用语句str1==str2', '对');
INSERT INTO `judgment` VALUES (9, 1, 'Java的源代码中定义几个类，编译结果就生成几个以.class为后缀的字节码文件', '对');
INSERT INTO `judgment` VALUES (10, 1, 'Java程序里,创建新的类对象用关键字new，回收无用的类对象使用关键字free。 （× ） java自动回收机制', '错');
INSERT INTO `judgment` VALUES (11, 1, '如果源文件包含import语句，则该语句必须是除空行和注释行外的第一个语句行。', '对');
INSERT INTO `judgment` VALUES (12, 1, '拥有abstract方法的类是抽象类，但抽象类中可以没有abstract方法', '对');
INSERT INTO `judgment` VALUES (13, 1, '静态初始化器是在其所属的类加载内存时由系统自动调用执行', '对');
INSERT INTO `judgment` VALUES (14, 1, '在Java中对象可以赋值，只要使用赋值号（等号）即可，相当于生成了一个各属性与赋值对象相同的新对象', '错');
INSERT INTO `judgment` VALUES (15, 1, 'Java applet也能够存取客户机磁盘上的文件', '对');
INSERT INTO `judgment` VALUES (16, 6, '1+1=2?', '对');

-- ----------------------------
-- Table structure for multiple_choice
-- ----------------------------
DROP TABLE IF EXISTS `multiple_choice`;
CREATE TABLE `multiple_choice`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `exam_id` int NULL DEFAULT NULL,
  `question` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `a_choice` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `b_choice` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `c_choice` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `d_choice` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `answer` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of multiple_choice
-- ----------------------------
INSERT INTO `multiple_choice` VALUES (3, 6, '1+1=2?', '对', '对', '对', '错', 'ABCD');
INSERT INTO `multiple_choice` VALUES (4, 1, '1+1?', '1', '2', '1', '1', 'ACD');

-- ----------------------------
-- Table structure for short_answer
-- ----------------------------
DROP TABLE IF EXISTS `short_answer`;
CREATE TABLE `short_answer`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `exam_id` int NULL DEFAULT NULL,
  `question` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `answer` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of short_answer
-- ----------------------------
INSERT INTO `short_answer` VALUES (2, 1, '1+1=2?', '2');
INSERT INTO `short_answer` VALUES (3, 1, '开发与运行Java程序需要经过的三个主要步骤为', '编辑源程序     、编译生成字节码     和       解释运行字节码        。');
INSERT INTO `short_answer` VALUES (4, 1, '设 x = 2 ，则表达式 ( x + + )／3 的值是', '0');
INSERT INTO `short_answer` VALUES (5, 1, '接口中的方法只能是', '抽象方法');

-- ----------------------------
-- Table structure for single_choice
-- ----------------------------
DROP TABLE IF EXISTS `single_choice`;
CREATE TABLE `single_choice`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `exam_id` int NULL DEFAULT NULL,
  `question` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `a_choice` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `b_choice` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `c_choice` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `d_choice` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `answer` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of single_choice
-- ----------------------------
INSERT INTO `single_choice` VALUES (1, 1, '编译Java Application 源程序文件将产生相应的字节码文件，这些字节码文件的扩展名为', 'dll', 'exe', 'txt1', 'zip', 'B');
INSERT INTO `single_choice` VALUES (2, 1, '如下哪个是合法的Java中的标识符', 'fieldname ', 'super ', '#number', '3number ', 'A');
INSERT INTO `single_choice` VALUES (5, 1, '设 x = 1 , y = 2 , z = 3，则表达式 y＋＝z－－/＋＋x 的值是', '3', '3.5', '4', '5', 'A');
INSERT INTO `single_choice` VALUES (6, 1, '不允许作为类及类成员的访问控制符的是', 'public ', 'private', 'static', 'protected', 'C');
INSERT INTO `single_choice` VALUES (7, 1, '为AB类的一个无形式参数无返回值的方法method书写方法头，使得使用类名AB作为前缀就可以调用它，该方法头的形式为', 'static void method( )', ' public void method( )', 'final void method( )', 'abstract void method( )', 'A');
INSERT INTO `single_choice` VALUES (9, 1, '下列哪一个import命令可以使我们在程序中创建输入/输出流对象', 'import java.sql', 'import java.sql', 'import java.io', 'import java.net.;', 'C');
INSERT INTO `single_choice` VALUES (10, 1, 'Java“一次编译，随处运行”的特点在于其', '跨平台性', '面向对象型', '多线程性', '安全性', 'A');
INSERT INTO `single_choice` VALUES (11, 1, '下列有关类、对象和实例的叙述，正确的是', '类就是对象，对象就是类，实例是对象的另一个名称，三者没有差别', '类是对象的抽象，对象是类的具体化，实例是对象的另一个名称', '对象是类的抽象，类是对象的具体化，实例是对象的另一个名称', '类是对象的抽象，对象是类的具体化，实例是类的另一个名称', 'B');
INSERT INTO `single_choice` VALUES (12, 1, '下列（  ）不是面向对象程序设计方法的特点', '封装', '继承', '多态', '结构化', 'D');
INSERT INTO `single_choice` VALUES (13, 2, '1+1=2?', '1', '2', '3', '4', 'B');
INSERT INTO `single_choice` VALUES (14, 6, '测试', '1', '2', '3', '4', 'A');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `account` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_role` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `name` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `gender` int NULL DEFAULT NULL,
  `age` int NULL DEFAULT NULL,
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', '123456', 'admin', '2022-06-02 13:21:44', '罗鸿林', 1, 12, '18870745179');
INSERT INTO `user` VALUES (2, 'purity', '11111111', 'teacher', '2022-06-02 14:11:38', '罗鸿运', 1, 1111, '18870745179');
INSERT INTO `user` VALUES (3, '光头强', '111111', 'student', '2022-06-04 09:09:10', '光头强', 1, 23, '11111111111');
INSERT INTO `user` VALUES (4, 'purity-good', '11111111', 'student', '2022-08-29 05:30:50', '罗鸿天', 1, 1111, '18870745179');

-- ----------------------------
-- Table structure for user_course
-- ----------------------------
DROP TABLE IF EXISTS `user_course`;
CREATE TABLE `user_course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `course_id` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_source_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_course
-- ----------------------------
INSERT INTO `user_course` VALUES (2, 3, 1);
INSERT INTO `user_course` VALUES (3, 2, 2);
INSERT INTO `user_course` VALUES (8, 1, 1);
INSERT INTO `user_course` VALUES (9, 3, 16);

-- ----------------------------
-- Table structure for user_exam
-- ----------------------------
DROP TABLE IF EXISTS `user_exam`;
CREATE TABLE `user_exam`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `exam_id` int NULL DEFAULT NULL,
  `mark` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `user_exam_id_uindex`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_exam
-- ----------------------------
INSERT INTO `user_exam` VALUES (2, 3, 1, 100);
INSERT INTO `user_exam` VALUES (3, 3, 6, 6);

SET FOREIGN_KEY_CHECKS = 1;
