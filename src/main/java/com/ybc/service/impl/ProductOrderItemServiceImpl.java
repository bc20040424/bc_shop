package com.ybc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ybc.constants.Constants;
import com.ybc.entity.po.ProductInfo;
import com.ybc.entity.po.ProductOrder;
import com.ybc.entity.query.ProductInfoQuery;
import com.ybc.entity.query.ProductOrderQuery;
import com.ybc.exception.BusinessException;
import com.ybc.mappers.ProductInfoMapper;
import com.ybc.mappers.ProductOrderMapper;
import org.springframework.stereotype.Service;

import com.ybc.entity.enums.PageSize;
import com.ybc.entity.query.ProductOrderItemQuery;
import com.ybc.entity.po.ProductOrderItem;
import com.ybc.entity.vo.PaginationResultVO;
import com.ybc.entity.query.SimplePage;
import com.ybc.mappers.ProductOrderItemMapper;
import com.ybc.service.ProductOrderItemService;
import com.ybc.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("productOrderItemService")
public class ProductOrderItemServiceImpl implements ProductOrderItemService {

	@Resource
	private ProductOrderItemMapper<ProductOrderItem, ProductOrderItemQuery> productOrderItemMapper;
	@Resource
	private ProductOrderMapper<ProductOrder,ProductOrderQuery> productOrderMapper;
	@Resource
	private ProductInfoMapper<ProductInfo, ProductInfoQuery>productInfoMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<ProductOrderItem> findListByParam(ProductOrderItemQuery param) {
		return this.productOrderItemMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ProductOrderItemQuery param) {
		return this.productOrderItemMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<ProductOrderItem> findListByPage(ProductOrderItemQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<ProductOrderItem> list = this.findListByParam(param);
		PaginationResultVO<ProductOrderItem> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(ProductOrderItem bean,String oid,Integer pid) {
		ProductOrderItem productOrderItem=this.productOrderItemMapper.selectByOid(oid);
		ProductInfo productInfo=this.productInfoMapper.selectById(pid);
		ProductOrder productOrder=this.productOrderMapper.selectByOid(oid);
		if(productOrderItem!=null){
			throw new BusinessException("订单已存在,请勿重复插入");
		}
		if(productInfo==null){
			throw new BusinessException("该商品不存在");
		}
		String id=StringTools.getRandomNumber(Constants.LENGTH_8);
		bean.setId(id);
		bean.setPid(String.valueOf(productInfo.getId()));
		bean.setOid(oid);
		bean.setCreatedTime(productOrder.getPayTime());
		bean.setCreatedUser(productOrder.getRecvName());
		bean.setModifiedTime(null);
		bean.setModifiedUser(null);
		Integer num=this.productOrderItemMapper.insertOrderItem(bean);
		if(num!=1){
			throw new BusinessException("数据插入异常,请联系管理员");
		}
		return num;
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<ProductOrderItem> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.productOrderItemMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<ProductOrderItem> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.productOrderItemMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(ProductOrderItem bean, ProductOrderItemQuery param) {
		StringTools.checkParam(param);
		return this.productOrderItemMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ProductOrderItemQuery param) {
		StringTools.checkParam(param);
		return this.productOrderItemMapper.deleteByParam(param);
	}



	/**
	 * 根据Id获取对象
	 */
	@Override
	public ProductOrderItem getProductOrderItemById(String id) {
		return this.productOrderItemMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateProductOrderItemById(ProductOrderItem bean, String id) {
		ProductOrderItem productOrderItem=this.productOrderItemMapper.selectById(id);
		if(productOrderItem==null){
			throw new BusinessException("该订单不存在，请重新输入。");
		}
		Integer count= this.productOrderItemMapper.updateById(bean, id);
		if(count!=1){
			throw new BusinessException("修改失败，请检查。");
		}
		return count;
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteProductOrderItemById(String id) {
		ProductOrderItem productOrderItem=this.productOrderItemMapper.selectById(id);
		if(productOrderItem==null){
			throw new BusinessException("该订单不存在，请重新输入。");
		}
		Integer count= this.productOrderItemMapper.deleteById(id);
		if(count!=1){
			throw new BusinessException("删除失败，请检查。");
		}
		return count;
	}
}