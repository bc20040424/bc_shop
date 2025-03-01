package com.ybc.mappers;

import com.ybc.entity.po.ProductOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 *  数据库操作接口
 */
@Mapper
public interface ProductOrderItemMapper<T,P> extends BaseMapper<T,P> {




	/**
	 * 根据Id更新
	 */
	 Integer updateById(@Param("bean") T t,@Param("id") String id);


	/**
	 * 根据Id删除
	 */
	 Integer deleteById(@Param("id") String id);


	/**
	 * 根据Id获取对象
	 */
	 T selectById(@Param("id") String id);

	 //创建订单交易完成时所生成的具体订单信息
	Integer insertOrderItem(@Param("productOrderItem")ProductOrderItem productOrderItem);

	ProductOrderItem selectByOid(@Param("oid")String oid);


}
