package com.ybc.mappers;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 *  数据库操作接口
 */
@Mapper
public interface UserInfoMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据Id更新
	 */
	 Integer updateById(@Param("bean") T t,@Param("id") String id);


	/**
	 * 根据Id删除
	 */
	 Integer deleteById(@Param("id") String id);


	/**
	 * 根据Id获取对象
	 */
	 T selectById(@Param("id") String id);


	/**
	 * 根据Username更新
	 */
	 Integer updateByUsername(@Param("bean") T t,@Param("username") String username);


	/**
	 * 根据Username删除
	 */
	 Integer deleteByUsername(@Param("username") String username);


	/**
	 * 根据Username获取对象
	 */
	 T selectByUsername(@Param("username") String username);

	 T selectByEmail(@Param("email")String email);

	Integer updateAvatarByUserId(@Param("userId")String userId, @Param("avatar")String avatar, @Param("modTime")Date modTime);
}
