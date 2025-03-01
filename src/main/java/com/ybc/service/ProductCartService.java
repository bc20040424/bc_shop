package com.ybc.service;

import java.util.List;

import com.ybc.entity.po.ProductInfo;
import com.ybc.entity.query.ProductCartQuery;
import com.ybc.entity.po.ProductCart;
import com.ybc.entity.vo.PaginationResultVO;
import com.ybc.mappers.ProductInfoMapper;

import javax.annotation.Resource;


/**
 *  业务接口
 */

public interface ProductCartService {

	/**
	 * 根据条件查询列表
	 */
	List<ProductCart> findListByParam(ProductCartQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(ProductCartQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<ProductCart> findListByPage(ProductCartQuery param);

	/**
	 * 新增
	 */
	Integer add(ProductCart bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<ProductCart> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<ProductCart> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(ProductCart bean,ProductCartQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(ProductCartQuery param);


	/**
	 * 根据Cid修改
	 */
	Integer updateProductCartByCid(ProductCart bean,String cid);


	/**
	 * 根据Cid删除
	 */
	Integer deleteProductCartByCid(String cid);


	/**
	 * 根据Cid查询对象
	 */
	ProductCart getProductCartByCid(String cid);



	/**
	 * 根据Uid修改
	 */
	Integer updateProductCartByUid(ProductCart bean,String uid);


	/**
	 * 根据Uid删除
	 */
	Integer deleteProductCartByUid(String uid);


	/**
	 * 根据Pid查询对象
	 */
	ProductCart getProductCartByPid(String pid);


	/**
	 * 根据Pid修改
	 */
	Integer updateProductCartByPid(ProductCart bean,String pid);


	/**
	 * 根据Pid删除
	 */
	Integer deleteProductCartByPid(String pid);

	ProductCart getProductCartByUid(String uid);

	//向购物车中添加商品
	void addProductToShopCar(String uid,String pid,Integer num);

	//删除购物车
	void deleteProductToShopCar(String cid);

	//清空购物车
	Integer deleteAll();

	//根据用户名查看购物车信息
	List<ProductCart>getShopCarByUserName(String userName);

}