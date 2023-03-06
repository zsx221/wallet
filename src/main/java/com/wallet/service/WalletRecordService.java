package com.wallet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wallet.entity.WalletRecord;

import java.util.List;

/**
 * @author xhd
 * 金额变动明细
 */

public interface WalletRecordService extends IService<WalletRecord> {
    /**
     * 查询用户钱包金额变动详细
     *
     * @param userId 用户id
     * @author xhd
     */
    List<WalletRecord> getDetails(String userId);
}
