package com.ybc.mappers;

import com.ybc.entity.dto.ProductDto;
import com.ybc.entity.po.ProductInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  数据库操作接口
 */
@Mapper
public interface ProductInfoMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据Id更新
	 */
	 Integer updateById(@Param("bean") ProductDto bean, @Param("id") Integer id);


	/**
	 * 根据Id删除
	 */
	 Integer deleteById(@Param("id") Integer id);


	/**
	 * 根据Id获取对象
	 */
	 T selectById(@Param("id") Integer id);

	 List<ProductInfo> selectHotProduct();

	 List<ProductInfo> selectNewProduct();

	/**
	 * 批量新增
	 * @param bean
	 * @return
	 */
	Integer add(@Param("bean")ProductInfo bean);


}
