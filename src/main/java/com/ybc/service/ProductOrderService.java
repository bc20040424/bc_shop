package com.ybc.service;

import java.util.List;

import com.ybc.entity.dto.OrderDto;
import com.ybc.entity.query.ProductOrderQuery;
import com.ybc.entity.po.ProductOrder;
import com.ybc.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface ProductOrderService {

	/**
	 * 根据条件查询列表
	 */
	List<ProductOrder> findListByParam(ProductOrderQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ProductOrderQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<ProductOrder> findListByPage(ProductOrderQuery param);

	/**
	 * 新增
	 */
	Integer add(ProductOrder bean,String uid);

	/**
	 * 根据Oid查询对象
	 */
	ProductOrder getProductOrderByOid(String oid);


	/**
	 * 根据Oid修改
	 */
	Integer updateProductOrderByOid(ProductOrder bean,String oid);


	/**
	 * 根据Oid删除
	 */
	Integer deleteProductOrderByOid(String oid);

	//计算所购商品总价
	Integer payCount(String oid);

}