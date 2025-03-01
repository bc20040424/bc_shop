package com.ybc.controller;

import java.util.ArrayList;
import java.util.List;

import com.ybc.component.RedisComponent;
import com.ybc.entity.dto.OrderDto;
import com.ybc.entity.query.ProductOrderQuery;
import com.ybc.entity.po.ProductOrder;
import com.ybc.entity.vo.ResponseVO;
import com.ybc.exception.BusinessException;
import com.ybc.mappers.ProductOrderMapper;
import com.ybc.service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("productOrderController")
@RequestMapping("/productOrder")
public class ProductOrderController extends ABaseController{

	@Resource
	private ProductOrderService productOrderService;
	@Resource
	private ProductOrderMapper<ProductOrder,ProductOrderQuery>productOrderMapper;
    @Resource
    private RedisComponent redisComponent;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataListOrder")
	public ResponseVO loadDataListOrder(ProductOrderQuery query){
		return getSuccessResponseVO(productOrderService.findListByPage(query));
	}

	//添加并查询未支付订单
	@RequestMapping("/addOrderUnpaid")
	public ResponseVO addOrderUnPaid(String oid,String uid) {
		List<OrderDto> productOrderImpl=this.productOrderMapper.selectByOidToSaveRedis(oid);
		if(productOrderImpl==null){
			throw new BusinessException("该订单不存在,请检查.");
		}
		for (OrderDto order:productOrderImpl){
			order.setStatus(0);
			order.setUid(uid);
			order.setOid(oid);
			redisComponent.saveOrder(order);
		}
		return getSuccessResponseVO(null);
	}
	//添加支付成功的订单
	@RequestMapping("/addOrderSuccess")
	public ResponseVO addOrderSuccess(ProductOrder  productOrder,String id) {
		productOrderService.add(productOrder,id);
		return getSuccessResponseVO(null);
	}
	/**
	 * 根据Oid查询对象
	 */
	@RequestMapping("/getProductOrderByOid")
	public ResponseVO getProductOrderByOid(String oid) {
		return getSuccessResponseVO(productOrderService.getProductOrderByOid(oid));
	}

	/**
	 * 根据Oid修改对象
	 */
	@RequestMapping("/updateProductOrderByOid")
	public ResponseVO updateProductOrderByOid(ProductOrder bean,String id) {
		Integer count=productOrderService.updateProductOrderByOid(bean,id);
		return getSuccessResponseVO(count);
	}

	/**
	 * 根据Oid删除（取消订单）
	 */
	@RequestMapping("/deleteProductOrderByOid")
	public ResponseVO deleteProductOrderByOid(String oid) {
		Integer count=productOrderService.deleteProductOrderByOid(oid);
		return getSuccessResponseVO(count);
	}

	/**
	 * 结算商品总价
	 * @param oid
	 * @return
	 */
	@RequestMapping("/totalPrice")
	public ResponseVO totalPrice(String oid) {
		Integer totalPrice=productOrderService.payCount(oid);
		return getSuccessResponseVO("总价为:"+totalPrice);
	}
}