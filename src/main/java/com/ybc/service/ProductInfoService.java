package com.ybc.service;

import java.util.List;

import com.ybc.entity.dto.ProductDto;

import com.ybc.entity.query.ProductInfoQuery;
import com.ybc.entity.po.ProductInfo;
import com.ybc.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface ProductInfoService {

	/**
	 * 根据条件查询列表
	 */
	List<ProductInfo> findListByParam(ProductInfoQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ProductInfoQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<ProductInfo> findListByPage(ProductInfoQuery param);

	/**
	 * 新增
	 */
	Integer add(ProductInfo bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<ProductInfo> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<ProductInfo> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(ProductInfo bean,ProductInfoQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ProductInfoQuery param);

	/**
	 * 根据Id查询对象
	 */
	ProductInfo getProductInfoById(Integer id);


	/**
	 * 根据Id修改
	 */
	Integer updateProductInfoById(ProductDto bean, Integer id);


	/**
	 * 根据Id删除
	 */
	Integer deleteProductInfoById(Integer id);

	ProductInfo selectByProductId(Integer id);
	//查询最热商品前5名排行
	List<ProductInfo>getHotProduct();
	//查询最新商品前5名排行
	List<ProductInfo>getNewProduct();

}