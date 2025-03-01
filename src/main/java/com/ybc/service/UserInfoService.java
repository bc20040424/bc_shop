package com.ybc.service;

import java.util.List;


import com.ybc.entity.dto.UserInfoDto;
import com.ybc.entity.query.UserInfoQuery;
import com.ybc.entity.po.UserInfo;
import com.ybc.entity.vo.PaginationResultVO;


/**
 *  业务接口
 */
public interface UserInfoService {

	/**
	 * 根据条件查询列表
	 */
	List<UserInfo> findListByParam(UserInfoQuery param);

	/**
	 * 根据条件查询列表
	 */
	Integer findCountByParam(UserInfoQuery param);

	/**
	 * 分页查询
	 */
	PaginationResultVO<UserInfo> findListByPage(UserInfoQuery param);

	/**
	 * 新增
	 */
	Integer add(UserInfo bean);

	/**
	 * 批量新增
	 */
	Integer addBatch(List<UserInfo> listBean);

	/**
	 * 批量新增/修改
	 */
	Integer addOrUpdateBatch(List<UserInfo> listBean);

	/**
	 * 多条件更新
	 */
	Integer updateByParam(UserInfo bean,UserInfoQuery param);

	/**
	 * 多条件删除
	 */
	Integer deleteByParam(UserInfoQuery param);

	/**
	 * 根据Id查询对象
	 */
	UserInfo getUserInfoById(String id);


	/**
	 * 根据Id修改
	 */
	Integer updateUserInfoById(UserInfo bean,String id);


	/**
	 * 根据Id删除
	 */
	Integer deleteUserInfoById(String id);


	/**
	 * 根据Username查询对象
	 */
	UserInfo getUserInfoByUsername(String username);


	/**
	 * 根据Username修改
	 */
	Integer updateUserInfoByUsername(UserInfo bean,String username);


	/**
	 * 根据Username删除
	 */
	Integer deleteUserInfoByUsername(String username);

	//注册
	void register (String email,String userName,String password );
	//登录
	UserInfoDto login(String email, String password);
	//修改密码
	void updatePassword(String email,String oldPassword,String newPassword);
	//更新名称
	void updateUserName(String newName,String email);

	void updateAvatarById(String userId,String avatar);

}