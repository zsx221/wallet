package com.wallet.controller;

import com.wallet.conmon.R;
import com.wallet.entity.UserWalletRecord;
import com.wallet.service.UserWalletRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/userWalletRecord")
public class UserWalletRecordController {
    @Resource
    private UserWalletRecordService userWalletRecordService;

    /**
     * 查询用户钱包金额变动明细
     */
    @GetMapping("/getDetails")
    public R getDetails(@RequestParam(value = "userId") String userId){
        List<UserWalletRecord> list = userWalletRecordService.getDetails(userId);
        return R.ok().put("data",list);
    }
}
