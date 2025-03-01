package com.ybc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.ybc.constants.Constants;
import com.ybc.entity.dto.ProductDto;
import com.ybc.entity.po.UserInfo;
import com.ybc.exception.BusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.ybc.entity.enums.PageSize;
import com.ybc.entity.query.ProductInfoQuery;
import com.ybc.entity.po.ProductInfo;
import com.ybc.entity.vo.PaginationResultVO;
import com.ybc.entity.query.SimplePage;
import com.ybc.mappers.ProductInfoMapper;
import com.ybc.service.ProductInfoService;
import com.ybc.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("productInfoService")
public class ProductInfoServiceImpl implements ProductInfoService {

	@Resource
	private ProductInfoMapper<ProductInfo, ProductInfoQuery> productInfoMapper;
	@Autowired
	private static final Logger logger=  LoggerFactory.getLogger(ProductInfoServiceImpl.class);
	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<ProductInfo> findListByParam(ProductInfoQuery param) {
		return this.productInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ProductInfoQuery param) {
		return this.productInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<ProductInfo> findListByPage(ProductInfoQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<ProductInfo> list = this.findListByParam(param);
		PaginationResultVO<ProductInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}




	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<ProductInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.productInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(ProductInfo bean, ProductInfoQuery param) {
		StringTools.checkParam(param);
		return this.productInfoMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ProductInfoQuery param) {
		StringTools.checkParam(param);
		return this.productInfoMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public ProductInfo getProductInfoById(Integer id) {
		return this.productInfoMapper.selectById(id);
	}

	/**
	 * 根据Id修改商品(单个条件)
	 */
	@Override
	public Integer updateProductInfoById(ProductDto bean,Integer id) {
		ProductInfo productInfo=this.productInfoMapper.selectById(id);
		if(productInfo==null){
			throw new BusinessException("该商品不存在，请重新输入。");
		}
		bean.setModifiedTime(new Date());
		Integer num= this.productInfoMapper.updateById(bean,id);
		if(num!=1){
			throw new BusinessException("修改失败，请联系管理员");
		}
		return num;
	}

	/**
	 * 根据Id删除商品
	 */
	@Override
	public Integer deleteProductInfoById(Integer id) {
		ProductInfo productInfo=this.productInfoMapper.selectById(id);
		if(productInfo==null){
			throw new BusinessException("该商品不存在，请检查。");
		}else {
			return this.productInfoMapper.deleteById(id);
		}
	}

	@Override
	public ProductInfo selectByProductId(Integer id) {
		ProductInfo productInfo=this.productInfoMapper.selectById(id);
		if(productInfo==null){
			throw new BusinessException("该商品不存在，请重新输入。");
		}else{
			productInfo.setPriority(null);
			productInfo.setCreatedUser(null);
			productInfo.setCreatedTime(null);
			productInfo.setModifiedUser(null);
			productInfo.setModifiedTime(null);
			return productInfo;
		}

	}

	@Override
	public List<ProductInfo> getHotProduct() {
		List<ProductInfo>hotProduct=this.productInfoMapper.selectHotProduct();
		//将不必要的数据设为空，，提升性能
		for(ProductInfo productInfo:hotProduct){
			productInfo.setModifiedTime(null);
			productInfo.setCreatedTime(null);
			productInfo.setCreatedUser(null);
			productInfo.setModifiedUser(null);
			productInfo.setPriority(null);
		}
		return hotProduct;
	}

	@Override
	public List<ProductInfo> getNewProduct() {
		List<ProductInfo> newProduct=this.productInfoMapper.selectNewProduct();
		//同理
		for(ProductInfo productInfo:newProduct){
			productInfo.setModifiedTime(null);
			productInfo.setCreatedTime(null);
			productInfo.setCreatedUser(null);
			productInfo.setModifiedUser(null);
			productInfo.setPriority(null);
		}
		return newProduct;
	}

	/**
	 *新增
	 */
	@Override
	public Integer add(ProductInfo bean) {
		try{
			if(bean==null){
				return 0;
			}
			String id= StringTools.getRandomNumber(Constants.LENGTH_8);
			bean.setId(Integer.parseInt(id));
			bean.setModifiedTime(new Date());
			bean.setCreatedTime(new Date());
			bean.setCreatedUser(Constants.CREATED_USER);
			bean.setModifiedUser(Constants.MODIFIED_USER);
			bean.setNum(Constants.PRODUCT_NUM);
		}catch (Exception e){
			logger.error("发生未知错误，请联系管理员。");
		}
		Integer number=this.productInfoMapper.add(bean);
		return number;
	}

	@Override
	public Integer addBatch(List<ProductInfo> listBean) {
		return 0;
	}

	//TODO 后续增加添加商品图片功能,和前面的添加头像功能逻辑一样.
}