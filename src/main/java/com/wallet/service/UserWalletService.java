package com.wallet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wallet.entity.UserWallet;

import java.math.BigDecimal;

/**
 * @author huanghong
 * 用户钱包信息
 */
public interface UserWalletService  extends IService<UserWallet> {
    /**
     * 获取钱包金额
     * @param userId 用户ID
     * @return
     */
    BigDecimal getUserBalance(String userId);

    /**
     * 消费
     * @param userId 用户ID
     * @param balance 消费金额
     * @return
     */
    Boolean consume(String userId, String balance);

    /**
     * 退款
     * @param userId 用户ID
     * @param money 退款金额
     * @return
     */
    Boolean refund(String userId, String money);
}
