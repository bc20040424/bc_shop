package com.ybc.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.ybc.constants.Constants;
import com.ybc.entity.po.ProductInfo;
import com.ybc.entity.po.UserInfo;
import com.ybc.entity.query.ProductInfoQuery;
import com.ybc.entity.query.UserInfoQuery;
import com.ybc.exception.BusinessException;
import com.ybc.mappers.ProductInfoMapper;
import com.ybc.mappers.UserInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.ybc.entity.enums.PageSize;
import com.ybc.entity.query.ProductCartQuery;
import com.ybc.entity.po.ProductCart;
import com.ybc.entity.vo.PaginationResultVO;
import com.ybc.entity.query.SimplePage;
import com.ybc.mappers.ProductCartMapper;
import com.ybc.service.ProductCartService;
import com.ybc.utils.StringTools;


/**
 *  业务接口实现
 */
@Service("productCartService")
public class ProductCartServiceImpl implements ProductCartService {
	@Resource
	private ProductInfoMapper<ProductInfo, ProductInfoQuery> productInfoMapper;

	@Resource
	private ProductCartMapper<ProductCart, ProductCartQuery> productCartMapper;

	@Resource
	private UserInfoMapper<UserInfo, UserInfoQuery> userInfoMapper;
	@Autowired
	private static final Logger logger= LoggerFactory.getLogger(ProductInfoServiceImpl.class);

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<ProductCart> findListByParam(ProductCartQuery param) {
		return this.productCartMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(ProductCartQuery param) {
		return this.productCartMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<ProductCart> findListByPage(ProductCartQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<ProductCart> list = this.findListByParam(param);
		PaginationResultVO<ProductCart> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(ProductCart bean) {
		return this.productCartMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<ProductCart> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.productCartMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<ProductCart> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.productCartMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(ProductCart bean, ProductCartQuery param) {
		StringTools.checkParam(param);
		return this.productCartMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(ProductCartQuery param) {
		StringTools.checkParam(param);
		return this.productCartMapper.deleteByParam(param);
	}

	/**
	 * 根据Cid获取对象
	 */
	@Override
	public ProductCart getProductCartByCid(String cid) {
		return this.productCartMapper.selectByCid(cid);
	}

	/**
	 * 根据Cid修改
	 */
	@Override
	public Integer updateProductCartByCid(ProductCart bean, String cid) {
		return this.productCartMapper.updateByCid(bean, cid);
	}

	/**
	 * 根据Cid删除
	 */
	@Override
	public Integer deleteProductCartByCid(String cid) {
		return this.productCartMapper.deleteByCid(cid);
	}



	/**
	 * 根据Uid获取对象
	 */
	@Override
	public ProductCart getProductCartByUid(String uid) {
		return this.productCartMapper.selectByUid(uid);
	}


	/**
	 * 根据Uid修改
	 */
	@Override
	public Integer updateProductCartByUid(ProductCart bean, String uid) {
		return this.productCartMapper.updateByUid(bean, uid);
	}

	/**
	 * 根据Uid删除
	 */
	@Override
	public Integer deleteProductCartByUid(String uid) {
		return this.productCartMapper.deleteByUid(uid);
	}

	/**
	 * 根据Pid获取对象
	 */
	@Override
	public ProductCart getProductCartByPid(String pid) {
		return this.productCartMapper.selectByPid(pid);
	}

	/**
	 * 根据Pid修改
	 */
	@Override
	public Integer updateProductCartByPid(ProductCart bean, String pid) {
		return this.productCartMapper.updateByPid(bean, pid);
	}

	/**
	 * 根据Pid删除
	 */
	@Override
	public Integer deleteProductCartByPid(String pid) {
		return this.productCartMapper.deleteByPid(pid);
	}

	//新建购物车(向购物车里添加商品)
	@Override
	public void addProductToShopCar(String uid, String pid, Integer num) {
		try{
			ProductCart productCart=this.productCartMapper.selectByUid(uid);
			ProductCart productCartByPid=this.productCartMapper.selectByPid(pid);
			ProductInfo productInfo=this.productInfoMapper.selectById(Integer.parseInt(pid));
			UserInfo userInfo=this.userInfoMapper.selectById(uid);
			if (productCart!=null){
				throw new BusinessException("已存在，请勿重复插入。");
			}
			if (productInfo==null) {
				throw new BusinessException("未找到该商品，请检查");
			}
			if(userInfo==null){
				throw new BusinessException("未找到该用户，请检查。");
			}
			ProductCart productCartImpl=new ProductCart();
			String cid=StringTools.getRandomNumber(Constants.LENGTH_5);
			String user=userInfo.getUsername();
			productCartImpl.setCid(cid);
			productCartImpl.setUid(uid);
			productCartImpl.setPid(pid);
			productCartImpl.setCreatedTime(new Date());
			productCartImpl.setPrice(productInfo.getPrice());
			productCartImpl.setNum(num);
			productCartImpl.setCreatedUser(user);
			Integer count=this.productCartMapper.insertByBean(productCartImpl);
			if(count!=1){
				throw new BusinessException("插入失败，请联系管理员。");
			}
			//如果购物车里已经有了该商品，则执行以下逻辑。
			ProductCart result=productCartMapper.selectByPidAndUid(uid,pid);
			if (productCartByPid!=null){
				String pidExist=result.getCid();
				Integer number=result.getNum()+num;
				Integer rows=productCartMapper.updateNumByCid(pidExist,number,new Date(),userInfo.getCreatedUser());
				if (rows!=1){
					throw new BusinessException("更新失败，请联系管理员。");
				}
			}
		}catch(Exception e){
			logger.error("添加失败，请联系管理员。");
		}

	}

	@Override
	public void deleteProductToShopCar(String cid) {
		ProductCart productCart=this.productCartMapper.selectByCid(cid);
		if(productCart==null){
			throw new BusinessException("该商品不存在，请检查。");
		}
		Integer num=this.productCartMapper.deleteByCid(cid);
		if(num!=1){
			throw  new BusinessException("删除失败，请联系管理员");
		}
	}

	//清空购物车
	@Override
	public Integer deleteAll() {
		return this.productCartMapper.deleteAll();
	}

	//根据用户名查看购物车信息
	@Override
	public List<ProductCart> getShopCarByUserName(String userName) {
		UserInfo userInfo=this.userInfoMapper.selectByUsername(userName);
		if(userInfo==null){
			throw new BusinessException("该用户不存在，请检查");
		}
		List<ProductCart>productCart=this.productCartMapper.selectShopCarByUser(userName);
		for(ProductCart productCartEntity:productCart){
			productCartEntity.setModifiedTime(null);
			productCartEntity.setModifiedUser(null);
			productCartEntity.setCreatedUser(userInfo.getUsername());
			productCartEntity.setCreatedTime(userInfo.getCreatedTime());
		}
		if (productCart.isEmpty()){
			throw new BusinessException("未查询到相关信息");
		}
		return productCart;
	}
}