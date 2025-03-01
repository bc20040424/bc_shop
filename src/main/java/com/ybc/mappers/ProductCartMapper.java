package com.ybc.mappers;
import com.ybc.entity.po.ProductCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.Date;
import java.util.List;


@Mapper
public interface ProductCartMapper<T,P> extends BaseMapper<T,P> {

	/**
	 * 根据Cid更新
	 */
	 Integer updateByCid(@Param("bean") T t,@Param("cid") String cid);

	 Integer updateNumByCid(@Param("cid")String cid, @Param("num")Integer num, @Param("createdTime")Date createdTime,@Param("createdUser")String createdUser);


	/**
	 * 根据Cid删除
	 */
	 Integer deleteByCid(@Param("cid") String cid);


	/**
	 * 根据Cid获取对象
	 */
	 T selectByCid(@Param("cid") String cid);


	/**
	 * 根据Uid更新
	 */
	 Integer updateByUid(@Param("bean") T t,@Param("uid") String uid);


	/**
	 * 根据Uid删除
	 */
	 Integer deleteByUid(@Param("uid") String uid);


	/**
	 * 根据Uid获取对象
	 */
	 T selectByUid(@Param("uid") String uid);


	/**
	 * 根据Pid更新
	 */
	 Integer updateByPid(@Param("bean") T t,@Param("pid") String pid);


	/**
	 * 根据Pid删除
	 */
	 Integer deleteByPid(@Param("pid") String pid);


	/**
	 * 根据Pid获取对象
	 */
	 T selectByPid(@Param("pid") String pid);

	 T selectByPidAndUid(@Param("uid")String uid,@Param("pid")String pid);

	 Integer insertByBean(@Param("bean")ProductCart bean);

	 //清空购物车
	Integer deleteAll();

	List<ProductCart> selectShopCarByUser(@Param("userName")String userName);



}
