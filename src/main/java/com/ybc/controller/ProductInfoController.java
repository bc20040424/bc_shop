package com.ybc.controller;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ybc.entity.dto.ProductDto;
import com.ybc.entity.po.UserInfo;
import com.ybc.entity.query.ProductInfoQuery;
import com.ybc.entity.po.ProductInfo;
import com.ybc.entity.vo.ResponseVO;
import com.ybc.exception.BusinessException;
import com.ybc.service.ProductInfoService;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("productInfoController")
@RequestMapping("/productInfo")

public class ProductInfoController extends ABaseController{

	@Resource
	private ProductInfoService productInfoService;
	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataList")
	public ResponseVO loadDataList(ProductInfoQuery query){
		return getSuccessResponseVO(productInfoService.findListByPage(query));
	}

	/**
	 * 根据Id修改商品信息
	 */
	@RequestMapping("/updateProductInfoById")
	public ResponseVO updateProductInfoById(ProductDto bean,Integer id){
		Integer number=productInfoService.updateProductInfoById(bean,id);
		return getSuccessResponseVO(number);
	}


	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteProductInfoById")
	public ResponseVO deleteProductInfoById(Integer id) {
		productInfoService.deleteProductInfoById(id);
		return getSuccessResponseVO(null);
	}

	@RequestMapping("/selectById")
	public ResponseVO selectById(Integer id){
		ProductInfo productInfo= productInfoService.selectByProductId(id);
		return getSuccessResponseVO(productInfo);
	}
	//寻找最热门的前5名的商品
	@RequestMapping("/findHotProduct")
	public ResponseVO findHotProduct(){
		List<ProductInfo> hotProduct=productInfoService.getHotProduct();
		return getSuccessResponseVO(hotProduct);
	}
	//寻找最新上架前5的商品
	@RequestMapping("/findNewProduct")
	public ResponseVO findNewProduct(){
		List<ProductInfo> newProduct=productInfoService.getNewProduct();
		return getSuccessResponseVO(newProduct);
	}

	/**
	 * 新增商品
	 */
	@RequestMapping("/add")
	public ResponseVO add(@RequestBody ProductInfo bean) {
		Integer number=productInfoService.add(bean);
		return getSuccessResponseVO(number);
	}
}