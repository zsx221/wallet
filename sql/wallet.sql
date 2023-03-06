
/*用户交易表user_record*/
DROP TABLE IF EXISTS `user_record`;
CREATE TABLE `user_record`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户id',
  `trade_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '交易名称',
  `trade_money` decimal(10, 2) NULL DEFAULT NULL COMMENT '交易金额',
  `trade_type` int NULL DEFAULT NULL COMMENT '交易类型（1支出 2收入）',
  `trade_time` datetime NULL DEFAULT NULL COMMENT '交易时间',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户交易表' ROW_FORMAT = Dynamic;

/*用户钱包表user_wallet*/

DROP TABLE IF EXISTS `user_wallet`;
CREATE TABLE `user_wallet`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户id',
  `balance` decimal(10, 2) NULL DEFAULT NULL COMMENT '余额',
  `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;


