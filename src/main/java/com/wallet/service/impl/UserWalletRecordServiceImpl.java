package com.wallet.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wallet.entity.UserWalletRecord;
import com.wallet.mapper.UserWalletRecordMapper;
import com.wallet.service.UserWalletRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author huanghong
 * 金额变动明细
 */
@Service
public class UserWalletRecordServiceImpl extends ServiceImpl<UserWalletRecordMapper, UserWalletRecord> implements UserWalletRecordService {
    /**
     * 查询用户钱包金额变动明细
     *
     * @param userId 用户id
     */
    @Override
    public List<UserWalletRecord> getDetails(String userId) {
        return this.list(Wrappers.lambdaQuery(UserWalletRecord.class)
                .eq(UserWalletRecord::getUserId, userId));
    }
}
