package com.wallet.controller;

import com.wallet.conmon.R;
import com.wallet.service.UserWalletService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author huanghong
 * 用户钱包
 */

@RestController
@RequestMapping("/api/userWallet")
public class UserWalletController {
    @Resource
    private UserWalletService userWalletService;

    /**
     * @param userId 用户id
     * @author huanghong
     * 查询用户钱包余额
     */
    @GetMapping("/getUserBalance")
    public R getUserBalance(@RequestParam(value = "userId") String userId) {
        BigDecimal balance = userWalletService.getUserBalance(userId);
        return R.ok().put("data", balance);
    }

    /**
     * @param userId 用户id
     * @author huanghong
     * 用户消费100元的接口
     */
    @PostMapping("/consume")
    public R consume(@RequestParam(value = "userId") String userId,
                     @RequestParam(value = "money") String money) {
        Boolean flag = userWalletService.consume(userId, money);
        return flag ? R.ok("消费成功") : R.error("消费失败");
    }

    /**
     * @param userId 用户id
     * @author huanghong
     * 用户退款20元接口
     */
    @PostMapping("/refund")
    public R refund(@RequestParam(value = "userId") String userId,
                    @RequestParam(value = "money") String money) {
        Boolean flag = userWalletService.refund(userId, money);
        return flag ? R.ok("退款成功") : R.error("退款失败");
    }
}
