package com.dt.user.store;

import com.dt.user.config.JsonData;
import org.springframework.stereotype.Component;

/**
 * local login store
 *
 * @author xuxueli 2018-04-02 20:03:11
 */
@Component
public class SsoLoginStore extends JsonData {

    private static int redisExpireMinite = 1440;    // 1440 minite, 24 hour

    /**
     * put
     *
     * @param storeKey
     */
    public void put(String storeKey, String val) {
        String redisKey = redisKey(storeKey);
        redisService.setString(redisKey, val, redisExpireMinite * 60L);  // minite to second
    }

    private String redisKey(String token) {
        return "".concat("#").concat(token);
    }

}
