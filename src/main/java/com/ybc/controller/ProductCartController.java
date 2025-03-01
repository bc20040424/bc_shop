package com.ybc.controller;

import java.util.List;

import com.ybc.entity.po.UserInfo;
import com.ybc.entity.query.ProductCartQuery;
import com.ybc.entity.po.ProductCart;
import com.ybc.entity.query.UserInfoQuery;
import com.ybc.entity.vo.ResponseVO;
import com.ybc.exception.BusinessException;
import com.ybc.mappers.UserInfoMapper;
import com.ybc.service.ProductCartService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *  Controller
 */
@RestController("productCartController")
@RequestMapping("/productCart")
public class ProductCartController extends ABaseController{

	@Resource
	private ProductCartService productCartService;
    @Resource
	private UserInfoMapper<UserInfo, UserInfoQuery> userInfoMapper;

	/**
	 * 根据条件分页查询
	 */
	@RequestMapping("/loadDataListCart")
	public ResponseVO loadDataListCart(ProductCartQuery query){
		return getSuccessResponseVO(productCartService.findListByPage(query));
	}

	/**
	 * 新增
	 */
	@RequestMapping("/addCart")
	public ResponseVO addCart(String uid,String pid,Integer num) {
		UserInfo userInfo=userInfoMapper.selectById(uid);
		if(userInfo==null){
			throw new BusinessException("该用户不存在，请重新输入。");
		}
		productCartService.addProductToShopCar(uid,pid,num);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Cid查询对象
	 */
	@RequestMapping("/getProductCartByCid")
	public ResponseVO getProductCartByCid(String cid) {
		return getSuccessResponseVO(productCartService.getProductCartByCid(cid));
	}

	/**
	 * 根据Cid修改对象
	 */
	@RequestMapping("/updateProductCartByCid")
	public ResponseVO updateProductCartByCid(ProductCart bean,String cid) {
		productCartService.updateProductCartByCid(bean,cid);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Cid删除
	 */
	@RequestMapping("/deleteProductCartByCid")
	public ResponseVO deleteProductCartByCid(String cid) {
		productCartService.deleteProductToShopCar(cid);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Uid查询对象
	 */
	@RequestMapping("/getProductCartByUid")
	public ResponseVO getProductCartByUid(String uid) {
		return getSuccessResponseVO(productCartService.getProductCartByUid(uid));
	}

	/**
	 * 根据Uid修改对象
	 */
	@RequestMapping("/updateProductCartByUid")
	public ResponseVO updateProductCartByUid(ProductCart bean,String uid) {
		productCartService.updateProductCartByUid(bean,uid);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Uid删除
	 */
	@RequestMapping("/deleteProductCartByUid")
	public ResponseVO deleteProductCartByUid(String uid) {
		productCartService.deleteProductCartByUid(uid);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Pid查询对象
	 */
	@RequestMapping("/getProductCartByPid")
	public ResponseVO getProductCartByPid(String pid) {
		return getSuccessResponseVO(productCartService.getProductCartByPid(pid));
	}

	/**
	 * 根据Pid修改对象
	 */
	@RequestMapping("/updateProductCartByPid")
	public ResponseVO updateProductCartByPid(ProductCart bean,String pid) {
		productCartService.updateProductCartByPid(bean,pid);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Pid删除
	 */
	@RequestMapping("/deleteProductCartByPid")
	public ResponseVO deleteProductCartByPid(String pid) {
		productCartService.deleteProductCartByPid(pid);
		return getSuccessResponseVO(null);
	}

	//清空购物车
	@RequestMapping("/deleteAll")
	public ResponseVO deleteAll(){
		Integer num=productCartService.deleteAll();
		if(num==0){
			throw new BusinessException("已经为空，不能删除");
		}
		return getSuccessResponseVO(num);
	}

	//根据用户名查信息
	@RequestMapping("/selectByName")
	public ResponseVO selectByName(String name){
		List<ProductCart>productCarts=productCartService.getShopCarByUserName(name);
		return getSuccessResponseVO(productCarts);
	}

}