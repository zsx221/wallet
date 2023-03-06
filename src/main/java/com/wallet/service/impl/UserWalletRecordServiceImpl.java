package com.wallet.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.wallet.entity.WalletRecord;
import com.wallet.mapper.WalletRecordMapper;
import com.wallet.service.WalletRecordService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xhd
 * 金额变动明细
 */
@Service
public class UserWalletRecordServiceImpl extends ServiceImpl<WalletRecordMapper, WalletRecord> implements WalletRecordService {
    /**
     * 查询用户钱包金额变动明细
     *
     * @param userId 用户id
     */
    @Override
    public List<WalletRecord> getDetails(String userId) {
        return this.list(Wrappers.lambdaQuery(WalletRecord.class)
                .eq(WalletRecord::getUserId, userId));
    }
}
