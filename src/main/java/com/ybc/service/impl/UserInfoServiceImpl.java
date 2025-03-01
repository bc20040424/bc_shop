package com.ybc.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import com.ybc.constants.Constants;
import com.ybc.entity.dto.UserInfoDto;
import com.ybc.exception.BusinessException;
import org.springframework.stereotype.Service;

import com.ybc.entity.enums.PageSize;
import com.ybc.entity.query.UserInfoQuery;
import com.ybc.entity.po.UserInfo;
import com.ybc.entity.vo.PaginationResultVO;
import com.ybc.entity.query.SimplePage;
import com.ybc.mappers.UserInfoMapper;
import com.ybc.service.UserInfoService;
import com.ybc.utils.StringTools;
import org.springframework.util.DigestUtils;


/**
 *  业务接口实现
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Resource
	private UserInfoMapper<UserInfo, UserInfoQuery> userInfoMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<UserInfo> findListByParam(UserInfoQuery param) {
		return this.userInfoMapper.selectList(param);
	}

	/**
	 * 根据条件查询列表
	 */
	@Override
	public Integer findCountByParam(UserInfoQuery param) {
		return this.userInfoMapper.selectCount(param);
	}

	/**
	 * 分页查询方法
	 */
	@Override
	public PaginationResultVO<UserInfo> findListByPage(UserInfoQuery param) {
		int count = this.findCountByParam(param);
		int pageSize = param.getPageSize() == null ? PageSize.SIZE15.getSize() : param.getPageSize();

		SimplePage page = new SimplePage(param.getPageNo(), count, pageSize);
		param.setSimplePage(page);
		List<UserInfo> list = this.findListByParam(param);
		PaginationResultVO<UserInfo> result = new PaginationResultVO(count, page.getPageSize(), page.getPageNo(), page.getPageTotal(), list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public Integer add(UserInfo bean) {
		return this.userInfoMapper.insert(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public Integer addBatch(List<UserInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.userInfoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或者修改
	 */
	@Override
	public Integer addOrUpdateBatch(List<UserInfo> listBean) {
		if (listBean == null || listBean.isEmpty()) {
			return 0;
		}
		return this.userInfoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 多条件更新
	 */
	@Override
	public Integer updateByParam(UserInfo bean, UserInfoQuery param) {
		StringTools.checkParam(param);
		return this.userInfoMapper.updateByParam(bean, param);
	}

	/**
	 * 多条件删除
	 */
	@Override
	public Integer deleteByParam(UserInfoQuery param) {
		StringTools.checkParam(param);
		return this.userInfoMapper.deleteByParam(param);
	}

	/**
	 * 根据Id获取对象
	 */
	@Override
	public UserInfo getUserInfoById(String id) {
		return this.userInfoMapper.selectById(id);
	}

	/**
	 * 根据Id修改
	 */
	@Override
	public Integer updateUserInfoById(UserInfo bean, String id) {
		return this.userInfoMapper.updateById(bean, id);
	}

	/**
	 * 根据Id删除
	 */
	@Override
	public Integer deleteUserInfoById(String id) {
		return this.userInfoMapper.deleteById(id);
	}

	/**
	 * 根据Username获取对象
	 */
	@Override
	public UserInfo getUserInfoByUsername(String username) {
		return this.userInfoMapper.selectByUsername(username);
	}

	/**
	 * 根据Username修改
	 */
	@Override
	public Integer updateUserInfoByUsername(UserInfo bean, String username) {
		return this.userInfoMapper.updateByUsername(bean, username);
	}

	/**
	 * 根据Username删除
	 */
	@Override
	public Integer deleteUserInfoByUsername(String username) {
		return this.userInfoMapper.deleteByUsername(username);
	}

	//注册功能
	@Override
	public void register(String email, String userName, String password) {
		UserInfo user=this.userInfoMapper.selectByEmail(email);
		if(user!=null){
			throw new BusinessException("该邮箱已被注册，请重新输入。");
		}
		UserInfo userInfo=new UserInfo();
//		String salt= UUID.randomUUID().toString().toUpperCase();
//		userInfo.setSalt(salt);
//		String oldPassword=userInfo.getPassword();
//		String md5Password=getMD5Password(oldPassword,salt);
//		userInfo.setPassword(md5Password);
		userInfo.setPassword(StringTools.encodeByMd5(password));
		userInfo.setEmail(email);
		userInfo.setUsername(userName);
		String userId=StringTools.getRandomNumber(Constants.LENGTH_8);
		userInfo.setId(userId);
		userInfo.setCreatedTime(new Date());
		this.userInfoMapper.insert(userInfo);

	}

	@Override
	public UserInfoDto login(String email, String password) {
		UserInfo userInfo=this.userInfoMapper.selectByEmail(email);
		if(userInfo==null||!userInfo.getPassword().equals(StringTools.encodeByMd5(password))){
			throw new BusinessException("账号或密码输入错误，请重新输入。");
		}
		UserInfoDto userInfoDto=new UserInfoDto();
		userInfoDto.setEmail(email);
		userInfoDto.setUserId(userInfo.getId());
		userInfoDto.setUserName(userInfo.getUsername());
		userInfo.setAvatar(userInfo.getAvatar());
		return userInfoDto;
	}
	//修改密码
	@Override
	public void updatePassword(String email, String oldPassword, String newPassword) {
		UserInfo userInfo=this.userInfoMapper.selectByEmail(email);
		if(userInfo==null){
			throw new BusinessException("该邮箱不存在，请检查。");
		}
		String oldPasswordMD5=StringTools.encodeByMd5(oldPassword);
		if(!oldPasswordMD5.equals(userInfo.getPassword())){
			throw new BusinessException("原密码输入不正确，请重新输入。");
		}
		userInfo.setPassword(StringTools.encodeByMd5(newPassword));
		userInfo.setModifiedTime(new Date());
		this.userInfoMapper.updateById(userInfo, userInfo.getId());
	}

	//修改用户名
	public void updateUserName(String email,String newName){
		UserInfo userInfo=this.userInfoMapper.selectByEmail(email);
		if(userInfo==null){
			throw new BusinessException("该邮箱不存在");
		}
		userInfo.setUsername(newName);
		userInfo.setModifiedTime(new Date());
		this.userInfoMapper.updateById(userInfo, userInfo.getId());
	}

	@Override
	public void updateAvatarById(String userId,String avatar) {
		UserInfo userInfo=this.userInfoMapper.selectById(userId);
		if (userInfo==null){
			throw new BusinessException("用户不存在。");
		}
		Integer count=userInfoMapper.updateAvatarByUserId(userId,avatar,new Date());
		if(count!=1){
			throw new BusinessException("更新头像失败。");
		}

	}

}