package com.itxiaodu.credit.api;
import com.itxiaodu.credit.utils.ResultType;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.TimeUnit;

@FeignClient(value = "itxiaodu-credit-redis")
public interface RedisService {
    @RequestMapping("/set/redis/key/value/remote")
    ResultType<String> setRedisKeyValueRemote(@RequestParam("key") String key,@RequestParam("value") String value);
    @RequestMapping("/set/redis/key/value/remote/time")
    ResultType<String> setRedisKeyValueRemoteWithTimeout(@RequestParam("key") String key, @RequestParam("value") String value,
                                                         @RequestParam("time") long time, @RequestParam("TimeUnit") TimeUnit timeunit);
    @RequestMapping("/get/redis/value/by/key/remote")
    ResultType<String> getRedisValueByKeyRemote(@RequestParam("key") String key);
    @RequestMapping("/remove/redis/key/remote")
    ResultType<String> removeRedisKeyRemote(@RequestParam("key") String key);
}

