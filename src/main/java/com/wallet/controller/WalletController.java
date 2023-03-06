package com.wallet.controller;

import com.wallet.conmon.R;
import com.wallet.service.WalletService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author xhd
 * 用户钱包
 */

@RestController
@RequestMapping("/api/Wallet")
public class WalletController {
    @Resource
    private WalletService WalletService;

    /**
     * @param Id 用户id
     * @author xhd
     * 查询用户钱包余额
     */
    @GetMapping("/getBalance")
    public R getBalance(@RequestParam(value = "Id") String Id) {
        BigDecimal balance = WalletService.getUserBalance(Id);
        return R.ok().put("data", balance);
    }

    /**
     * @param Id 用户id
     * @author xhd
     * 用户消费100元的接口
     */
    @PostMapping("/consume")
    public R consume(@RequestParam(value = "Id") String Id,
                     @RequestParam(value = "money") String money) {
        Boolean flag = WalletService.consume(Id, money);
        return flag ? R.ok("消费成功") : R.error("消费失败");
    }

    /**
     * @param Id 用户id
     * @author xhd
     * 用户退款20元接口
     */
    @PostMapping("/refund")
    public R refund(@RequestParam(value = "Id") String Id,
                    @RequestParam(value = "money") String money) {
        Boolean flag = WalletService.refund(Id, money);
        return flag ? R.ok("退款成功") : R.error("退款失败");
    }
}
