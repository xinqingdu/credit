package com.itxiaodu.credit.controller;

import com.itxiaodu.credit.utils.ResultType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class RedisController {
    RedisController() {

    }
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @RequestMapping("/set/redis/key/value/remote")
    ResultType<String> setRedisKeyValueRemote(@RequestParam("key") String key, @RequestParam("value") String value) {
        try {
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            stringStringValueOperations.set(key,value);
            return ResultType.successWithoutData();
        }catch (Exception e){
            return ResultType.fail(e.getMessage());
        }
    }

    @RequestMapping("/set/redis/key/value/remote/time")
    ResultType<String> setRedisKeyValueRemoteWithTimeout(@RequestParam("key") String key, @RequestParam("value") String value,
                                                         @RequestParam("time") long time, @RequestParam("TimeUnit") TimeUnit timeunit) {
        try {
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            stringStringValueOperations.set(key,value,time,timeunit);
            return ResultType.successWithoutData();
        }catch (Exception e){
            return ResultType.fail(e.getMessage());
        }
    }

    @RequestMapping("/get/redis/value/by/key/remote")
    ResultType<String> getRedisValueByKeyRemote(@RequestParam("key") String key) {
        try {
            ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
            String value= stringStringValueOperations.get(key);
            return ResultType.successWithData(value);
        }catch (Exception e){
            return ResultType.fail(e.getMessage());
        }
    }

    @RequestMapping("/remove/redis/key/remote")
    ResultType<String> removeRedisKeyRemote(@RequestParam("key") String key) {
        try {
            stringRedisTemplate.delete(key);
            return ResultType.successWithoutData();
        }catch (Exception e){
            return ResultType.fail(e.getMessage());
        }
    }
}
