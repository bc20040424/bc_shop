package com.ybc.service;

import java.util.List;

import com.ybc.entity.po.ProductOrder;
import com.ybc.entity.query.ProductOrderItemQuery;
import com.ybc.entity.po.ProductOrderItem;
import com.ybc.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface ProductOrderItemService {

	/**
	 * 根据条件查询列表
	 */
	List<ProductOrderItem> findListByParam(ProductOrderItemQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ProductOrderItemQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<ProductOrderItem> findListByPage(ProductOrderItemQuery param);

	/**
	 * 新增
	 */
	Integer add(ProductOrderItem bean,String oid,Integer pid);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<ProductOrderItem> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<ProductOrderItem> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(ProductOrderItem bean,ProductOrderItemQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ProductOrderItemQuery param);

	/**
	 * 根据Id查询对象
	 */
	ProductOrderItem getProductOrderItemById(String id);


	/**
	 * 根据Id修改
	 */
	Integer updateProductOrderItemById(ProductOrderItem bean,String id);


	/**
	 * 根据Id删除
	 */
	Integer deleteProductOrderItemById(String id);

}