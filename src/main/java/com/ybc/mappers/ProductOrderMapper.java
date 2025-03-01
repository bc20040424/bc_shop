package com.ybc.mappers;

import com.ybc.entity.dto.OrderDto;
import com.ybc.entity.po.ProductOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  数据库操作接口
 */
@Mapper
public interface ProductOrderMapper<T,P> extends BaseMapper<T,P> {




	/**
	 * 根据Oid更新
	 */
	 Integer updateByOid(@Param("bean") ProductOrder bean,@Param("oid") String oid);


	/**
	 * 根据Oid删除
	 */
	 Integer deleteByOid(@Param("oid") String oid);


	/**
	 * 根据Oid获取对象
	 */
	 T selectByOid(@Param("oid") String oid);

	 //根据uid查询数据
	ProductOrder selectByUid(@Param("uid")String uid);

	 //新增订单
	Integer addOrder(@Param("productOrder")ProductOrder productOrder);

	List<OrderDto> selectByOidToSaveRedis(@Param("oid")String oid);




}
