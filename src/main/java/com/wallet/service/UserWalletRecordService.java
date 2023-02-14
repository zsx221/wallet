package com.wallet.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wallet.entity.UserWalletRecord;

import java.util.List;

/**
 * @author huanghong
 * 金额变动明细
 */

public interface UserWalletRecordService extends IService<UserWalletRecord> {
    /**
     * 查询用户钱包金额变动详细
     *
     * @param userId 用户id
     * @author huanghong
     */
    List<UserWalletRecord> getDetails(String userId);
}
