package com.atguigu.job;

import com.atguigu.constant.RedisConstant;
import com.atguigu.utils.QiniuUtils;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

import java.util.Iterator;
import java.util.Set;

public class ClearImgJob {
    @Autowired
    JedisPool jedisPool;
    public void clearImg() {
        Set<String> sdiff = jedisPool.getResource().sdiff(RedisConstant.SETMEAL_PIC_RESOURCES, RedisConstant.SETMEAL_PIC_DB_RESOURCES);
        Iterator<String> iterator = sdiff.iterator();
        if ( iterator.hasNext() ) {
            String next = iterator.next();
            System.out.println("删除图片的名称是"+next);
            QiniuUtils.deleteFileFromQiniu(next);
            jedisPool.getResource().srem(RedisConstant.SETMEAL_PIC_RESOURCES, next);
        }
    }
}
