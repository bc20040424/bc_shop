package com.ybc.controller;

import java.util.List;

import com.ybc.entity.query.ProductOrderItemQuery;
import com.ybc.entity.po.ProductOrderItem;
import com.ybc.entity.vo.ResponseVO;
import com.ybc.service.ProductOrderItemService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("productOrderItemController")
@RequestMapping("/productOrderItem")
public class ProductOrderItemController extends ABaseController{

	@Resource
	private ProductOrderItemService productOrderItemService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataListItem")
	public ResponseVO loadDataListItem(ProductOrderItemQuery query){
		return getSuccessResponseVO(productOrderItemService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/addOrderItem")
	public ResponseVO addOrderItem(ProductOrderItem bean,String oid,Integer pid) {
		productOrderItemService.add(bean,oid,pid);
		return getSuccessResponseVO(null);
	}


	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getProductOrderItemById")
	public ResponseVO getProductOrderItemById(String id) {
		return getSuccessResponseVO(productOrderItemService.getProductOrderItemById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateProductOrderItemById")
	public ResponseVO updateProductOrderItemById(ProductOrderItem bean,String id) {
		Integer count=productOrderItemService.updateProductOrderItemById(bean,id);
		return getSuccessResponseVO(count);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteProductOrderItemById")
	public ResponseVO deleteProductOrderItemById(String id) {
		Integer count=productOrderItemService.deleteProductOrderItemById(id);
		return getSuccessResponseVO(count);
	}

}