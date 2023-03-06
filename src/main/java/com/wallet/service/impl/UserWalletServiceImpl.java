package com.wallet.service.impl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wallet.entity.Wallet;
import com.wallet.entity.WalletRecord;
import com.wallet.mapper.WalletMapper;
import com.wallet.service.WalletRecordService;
import com.wallet.service.WalletService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserWalletServiceImpl extends ServiceImpl<WalletMapper, Wallet> implements WalletService {

    @Resource
    private WalletRecordService userWalletRecordService;

    /**
     * 获取用户钱包
     * @param userId 用户ID
     * @return
     */

    @Override
    public BigDecimal getUserBalance(String userId) {

        Wallet wallet = this.getOne(Wrappers.lambdaQuery(Wallet.class)
                .eq(Wallet::getUserId, userId));
        return wallet.getBalance();

    }

    /**
     * 消费
     * @author xhd
     * @param userId 用户ID
     * @param money 金额
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean consume(String userId, String money) {
        Wallet wallet = this.getOne(Wrappers.lambdaQuery(Wallet.class)
                .eq(Wallet::getUserId, userId));

        BigDecimal balanceDecimal = new BigDecimal(money);
        BigDecimal balance = wallet.getBalance().subtract(balanceDecimal);

        wallet.setBalance(balance);
        boolean a = this.updateById(wallet);

        WalletRecord userRecord = new WalletRecord();
        userRecord.setUserId(userId);
        userRecord.setCreateTime(new Date());
        userRecord.setUpdateTime(new Date());
        userRecord.setTradeName("消费" + money + "元");
        userRecord.setTradeType(1);

        boolean b = userWalletRecordService.save(userRecord);
        return a && b;
    }

    /**
     * @author xhd
     * 退款
     * @param userId 用户id
     * @param money  金额
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean refund(String userId, String money) {
        Wallet wallet = this.getOne(Wrappers.lambdaQuery(Wallet.class)
                .eq(Wallet::getUserId, userId));

        BigDecimal balanceDecimal = new BigDecimal(money);
        BigDecimal balance = wallet.getBalance().add(balanceDecimal);

        wallet.setBalance(balance);
        boolean a = this.updateById(wallet);

        WalletRecord userRecord = new WalletRecord();
        userRecord.setUserId(userId);
        userRecord.setCreateTime(new Date());
        userRecord.setUpdateTime(new Date());
        userRecord.setTradeName("退款" + money + "元");
        userRecord.setTradeType(2);

        boolean b = userWalletRecordService.save(userRecord);
        return a && b;
    }
}
