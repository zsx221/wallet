package com.wallet.service.impl;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wallet.entity.UserWallet;
import com.wallet.entity.UserWalletRecord;
import com.wallet.mapper.UserWalletMapper;
import com.wallet.service.UserWalletRecordService;
import com.wallet.service.UserWalletService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserWalletServiceImpl extends ServiceImpl<UserWalletMapper, UserWallet> implements UserWalletService {

    @Resource
    private UserWalletRecordService userWalletRecordService;

    /**
     * 获取用户钱包
     * @param userId 用户ID
     * @return
     */

    @Override
    public BigDecimal getUserBalance(String userId) {

        UserWallet wallet = this.getOne(Wrappers.lambdaQuery(UserWallet.class)
                .eq(UserWallet::getUserId, userId));
        return wallet.getBalance();

    }

    /**
     * 消费
     * @author huanghong
     * @param userId 用户ID
     * @param money 金额
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean consume(String userId, String money) {
        UserWallet wallet = this.getOne(Wrappers.lambdaQuery(UserWallet.class)
                .eq(UserWallet::getUserId, userId));

        BigDecimal balanceDecimal = new BigDecimal(money);
        BigDecimal balance = wallet.getBalance().subtract(balanceDecimal);

        wallet.setBalance(balance);
        boolean a = this.updateById(wallet);

        UserWalletRecord userRecord = new UserWalletRecord();
        userRecord.setUserId(userId);
        userRecord.setCreateTime(new Date());
        userRecord.setUpdateTime(new Date());
        userRecord.setTradeName("消费" + money + "元");
        userRecord.setTradeType(1);

        boolean b = userWalletRecordService.save(userRecord);
        return a && b;
    }

    /**
     * @author huanghong
     * 退款
     * @param userId 用户id
     * @param money  金额
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean refund(String userId, String money) {
        UserWallet wallet = this.getOne(Wrappers.lambdaQuery(UserWallet.class)
                .eq(UserWallet::getUserId, userId));

        BigDecimal balanceDecimal = new BigDecimal(money);
        BigDecimal balance = wallet.getBalance().add(balanceDecimal);

        wallet.setBalance(balance);
        boolean a = this.updateById(wallet);

        UserWalletRecord userRecord = new UserWalletRecord();
        userRecord.setUserId(userId);
        userRecord.setCreateTime(new Date());
        userRecord.setUpdateTime(new Date());
        userRecord.setTradeName("退款" + money + "元");
        userRecord.setTradeType(2);

        boolean b = userWalletRecordService.save(userRecord);
        return a && b;
    }
}
