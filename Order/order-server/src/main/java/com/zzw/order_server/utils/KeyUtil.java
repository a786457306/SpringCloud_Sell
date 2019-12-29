package com.zzw.order_server.utils;

import java.util.Random;

/**
 * @author Daydreamer
 * @date 2019/12/20 15:41
 */
public class KeyUtil {

    /**
     * 生成唯一主键
     * 格式：时间戳 + 随机数
     * 在公司中那么多项目，不能保证这样生成主键一定唯一，不能这么简单
     * 需要写一个项目供各个服务来调用，生成主键
     *
     * @return
     */
    public static synchronized String uniqueKeyGenerator() {
        Random random = new Random();
        Integer randonNum = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(randonNum);
    }
}
