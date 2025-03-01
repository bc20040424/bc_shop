package com.ybc.component;

import com.ybc.constants.Constants;
import com.ybc.entity.dto.OrderDto;
import com.ybc.exception.BusinessException;
import com.ybc.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;



@Component
public class RedisComponent {
    @Autowired
    private static final Logger logger= LoggerFactory.getLogger(RedisComponent.class);
    @Resource
    private RedisUtils redisUtils;
    public void saveOrder(OrderDto bean){
        redisUtils.setex(Constants.ORDER_ID+bean.getOid(),String.valueOf(bean.getStatus()),Constants.EXPIRE_TEN_MINUTES);

    }
}
