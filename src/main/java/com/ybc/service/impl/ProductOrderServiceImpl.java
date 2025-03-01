package com.ybc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import com.ybc.component.RedisComponent;
import com.ybc.constants.Constants;
import com.ybc.entity.dto.OrderDto;
import com.ybc.entity.po.ProductOrderItem;
import com.ybc.entity.po.UserInfo;
import com.ybc.entity.query.ProductOrderItemQuery;
import com.ybc.entity.query.UserInfoQuery;
import com.ybc.exception.BusinessException;
import com.ybc.mappers.ProductOrderItemMapper;
import com.ybc.mappers.UserInfoMapper;
import io.lettuce.core.GeoArgs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.ybc.entity.enums.PageSize;
import com.ybc.entity.query.ProductOrderQuery;
import com.ybc.entity.po.ProductOrder;
import com.ybc.entity.vo.PaginationResultVO;
import com.ybc.entity.query.SimplePage;
import com.ybc.mappers.ProductOrderMapper;
import com.ybc.service.ProductOrderService;
import com.ybc.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("productOrderService")
public class ProductOrderServiceImpl implements ProductOrderService {

	@Resource
	private ProductOrderMapper<ProductOrder, ProductOrderQuery> productOrderMapper;
	@Resource
	private UserInfoMapper<UserInfo, UserInfoQuery> userInfoMapper;
	@Resource
	private ProductOrderItemMapper<ProductOrderItem, ProductOrderItemQuery>productOrderItemMapper;
	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<ProductOrder> findListByParam(ProductOrderQuery param) {
		return this.productOrderMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ProductOrderQuery param) {
		return this.productOrderMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<ProductOrder> findListByPage(ProductOrderQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<ProductOrder> list = this.findListByParam(param);
		PaginationResultVO<ProductOrder> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(ProductOrder bean,String uid) {
		UserInfo userInfo=this.userInfoMapper.selectById(uid);
		if(userInfo==null){
			throw new BusinessException("该用户不存在");
		}
		String oid=StringTools.getRandomNumber(Constants.LENGTH_5);
		bean.setOid(oid);
		bean.setCreatedTime(new Date());
		bean.setUid(userInfo.getId());
		bean.setCreatedUser(userInfo.getUsername());
		bean.setOrderTime(new Date());
		bean.setModifiedUser(null);
		bean.setModifiedTime(null);
		Integer count=this.productOrderMapper.addOrder(bean);
		if(count!=1){
			throw new BusinessException("创建订单失败,请联系管理员");
		}
		return count;
	}

	/**
	 * 根据Oid获取对象
	 */
	@Override
	public ProductOrder getProductOrderByOid(String oid) {
		return this.productOrderMapper.selectByOid(oid);
	}

	/**
	 * 根据Oid修改
	 */
	@Override
	public Integer updateProductOrderByOid(ProductOrder bean,String id) {
		ProductOrder productOrder=this.productOrderMapper.selectByOid(id);
		UserInfo userInfo=this.userInfoMapper.selectById(productOrder.getUid());
		if(productOrder==null){
			throw new BusinessException("该订单不存在，请重新输入。");
		}
		bean.setModifiedUser(userInfo.getUsername());
		bean.setModifiedTime(new Date());
		Integer count=this.productOrderMapper.updateByOid(bean,id);
		if (count!=1){
			throw new BusinessException("更新失败，请检查。");
		}
		return count;
	}

	/**
	 * 根据Oid删除
	 */
	@Override
	public Integer deleteProductOrderByOid(String oid) {
		ProductOrder productOrder=this.productOrderMapper.selectByOid(oid);
		if(productOrder==null){
			throw new BusinessException("该订单不存在，请重新输入。");
		}
		Integer count=this.productOrderMapper.deleteByOid(oid);
		if (count!=1){
			throw new BusinessException("删除失败，请检查。");
		}
		return count;
	}

	//TODO 结算逻辑有问题,后续更改
	@Override
	public Integer payCount(String oid) {
		ProductOrder productOrder=this.productOrderMapper.selectByOid(oid);
		if(productOrder==null){
			throw new BusinessException("未查询到该商品,请检查");
		}
		Integer count=productOrder.getNum();
		//数据库里字段不小心写成total了,懒得改了,这里的价格指的是单价.
		Integer price=productOrder.getTotalPrice();
		//总价
		Integer totalPrice=count*price;
		return totalPrice;
	}

//TODO 具体的订单定时取消处理，暂时没整明白，后续处理。

//	public void createOrder(ProductOrder productOrder,String uid,Integer status) {
//		// 保存订单到数据库
//		add(productOrder,uid,status);
//		// 在 Redis 中设置订单键，15 分钟后过期
//		redisTemplate.opsForValue().set("order:" + productOrder.getOid(), productOrder.getUid(), 15, TimeUnit.MINUTES);
//	}
//	public void cancelOrder(String orderId) {
//		ProductOrder order = productOrderMapper.selectByOid(orderId);
//		if (order != null) {
//			order.setStatus(2);
//			add(order,order.getUid(),order.getStatus());
//			System.out.println("订单 " + orderId + " 已取消");
//		}
//	}


}