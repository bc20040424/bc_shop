package com.ybc.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class ProductOrderQuery extends BaseParam {


	/**
	 * 订单id
	 */
	private String oid;

	private String oidFuzzy;

	/**
	 * 用户id
	 */
	private String uid;

	private String uidFuzzy;

	/**
	 * 收货人姓名
	 */
	private String recvName;

	private String recvNameFuzzy;

	/**
	 * 收货人电话
	 */
	private String recvPhone;

	private String recvPhoneFuzzy;

	/**
	 * 收货人所在省
	 */
	private String recvProvince;

	private String recvProvinceFuzzy;

	/**
	 * 收货人所在市
	 */
	private String recvCity;

	private String recvCityFuzzy;

	/**
	 * 收货人所在区
	 */
	private String recvArea;

	private String recvAreaFuzzy;

	/**
	 * 收货详细地址
	 */
	private String recvAddress;

	private String recvAddressFuzzy;

	/**
	 * 总价
	 */
	private Long totalPrice;

	/**
	 * 状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成
	 */
	private Integer status;

	/**
	 * 下单时间
	 */
	private String orderTime;

	private String orderTimeStart;

	private String orderTimeEnd;

	/**
	 * 支付时间
	 */
	private String payTime;

	private String payTimeStart;

	private String payTimeEnd;

	/**
	 * 创建人
	 */
	private String createdUser;

	private String createdUserFuzzy;

	/**
	 * 创建时间
	 */
	private String createdTime;

	private String createdTimeStart;

	private String createdTimeEnd;

	/**
	 * 修改人
	 */
	private String modifiedUser;

	private String modifiedUserFuzzy;

	/**
	 * 修改时间
	 */
	private String modifiedTime;

	private String modifiedTimeStart;

	private String modifiedTimeEnd;


	public void setOid(String oid){
		this.oid = oid;
	}

	public String getOid(){
		return this.oid;
	}

	public void setOidFuzzy(String oidFuzzy){
		this.oidFuzzy = oidFuzzy;
	}

	public String getOidFuzzy(){
		return this.oidFuzzy;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return this.uid;
	}

	public void setUidFuzzy(String uidFuzzy){
		this.uidFuzzy = uidFuzzy;
	}

	public String getUidFuzzy(){
		return this.uidFuzzy;
	}

	public void setRecvName(String recvName){
		this.recvName = recvName;
	}

	public String getRecvName(){
		return this.recvName;
	}

	public void setRecvNameFuzzy(String recvNameFuzzy){
		this.recvNameFuzzy = recvNameFuzzy;
	}

	public String getRecvNameFuzzy(){
		return this.recvNameFuzzy;
	}

	public void setRecvPhone(String recvPhone){
		this.recvPhone = recvPhone;
	}

	public String getRecvPhone(){
		return this.recvPhone;
	}

	public void setRecvPhoneFuzzy(String recvPhoneFuzzy){
		this.recvPhoneFuzzy = recvPhoneFuzzy;
	}

	public String getRecvPhoneFuzzy(){
		return this.recvPhoneFuzzy;
	}

	public void setRecvProvince(String recvProvince){
		this.recvProvince = recvProvince;
	}

	public String getRecvProvince(){
		return this.recvProvince;
	}

	public void setRecvProvinceFuzzy(String recvProvinceFuzzy){
		this.recvProvinceFuzzy = recvProvinceFuzzy;
	}

	public String getRecvProvinceFuzzy(){
		return this.recvProvinceFuzzy;
	}

	public void setRecvCity(String recvCity){
		this.recvCity = recvCity;
	}

	public String getRecvCity(){
		return this.recvCity;
	}

	public void setRecvCityFuzzy(String recvCityFuzzy){
		this.recvCityFuzzy = recvCityFuzzy;
	}

	public String getRecvCityFuzzy(){
		return this.recvCityFuzzy;
	}

	public void setRecvArea(String recvArea){
		this.recvArea = recvArea;
	}

	public String getRecvArea(){
		return this.recvArea;
	}

	public void setRecvAreaFuzzy(String recvAreaFuzzy){
		this.recvAreaFuzzy = recvAreaFuzzy;
	}

	public String getRecvAreaFuzzy(){
		return this.recvAreaFuzzy;
	}

	public void setRecvAddress(String recvAddress){
		this.recvAddress = recvAddress;
	}

	public String getRecvAddress(){
		return this.recvAddress;
	}

	public void setRecvAddressFuzzy(String recvAddressFuzzy){
		this.recvAddressFuzzy = recvAddressFuzzy;
	}

	public String getRecvAddressFuzzy(){
		return this.recvAddressFuzzy;
	}

	public void setTotalPrice(Long totalPrice){
		this.totalPrice = totalPrice;
	}

	public Long getTotalPrice(){
		return this.totalPrice;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setOrderTime(String orderTime){
		this.orderTime = orderTime;
	}

	public String getOrderTime(){
		return this.orderTime;
	}

	public void setOrderTimeStart(String orderTimeStart){
		this.orderTimeStart = orderTimeStart;
	}

	public String getOrderTimeStart(){
		return this.orderTimeStart;
	}
	public void setOrderTimeEnd(String orderTimeEnd){
		this.orderTimeEnd = orderTimeEnd;
	}

	public String getOrderTimeEnd(){
		return this.orderTimeEnd;
	}

	public void setPayTime(String payTime){
		this.payTime = payTime;
	}

	public String getPayTime(){
		return this.payTime;
	}

	public void setPayTimeStart(String payTimeStart){
		this.payTimeStart = payTimeStart;
	}

	public String getPayTimeStart(){
		return this.payTimeStart;
	}
	public void setPayTimeEnd(String payTimeEnd){
		this.payTimeEnd = payTimeEnd;
	}

	public String getPayTimeEnd(){
		return this.payTimeEnd;
	}

	public void setCreatedUser(String createdUser){
		this.createdUser = createdUser;
	}

	public String getCreatedUser(){
		return this.createdUser;
	}

	public void setCreatedUserFuzzy(String createdUserFuzzy){
		this.createdUserFuzzy = createdUserFuzzy;
	}

	public String getCreatedUserFuzzy(){
		return this.createdUserFuzzy;
	}

	public void setCreatedTime(String createdTime){
		this.createdTime = createdTime;
	}

	public String getCreatedTime(){
		return this.createdTime;
	}

	public void setCreatedTimeStart(String createdTimeStart){
		this.createdTimeStart = createdTimeStart;
	}

	public String getCreatedTimeStart(){
		return this.createdTimeStart;
	}
	public void setCreatedTimeEnd(String createdTimeEnd){
		this.createdTimeEnd = createdTimeEnd;
	}

	public String getCreatedTimeEnd(){
		return this.createdTimeEnd;
	}

	public void setModifiedUser(String modifiedUser){
		this.modifiedUser = modifiedUser;
	}

	public String getModifiedUser(){
		return this.modifiedUser;
	}

	public void setModifiedUserFuzzy(String modifiedUserFuzzy){
		this.modifiedUserFuzzy = modifiedUserFuzzy;
	}

	public String getModifiedUserFuzzy(){
		return this.modifiedUserFuzzy;
	}

	public void setModifiedTime(String modifiedTime){
		this.modifiedTime = modifiedTime;
	}

	public String getModifiedTime(){
		return this.modifiedTime;
	}

	public void setModifiedTimeStart(String modifiedTimeStart){
		this.modifiedTimeStart = modifiedTimeStart;
	}

	public String getModifiedTimeStart(){
		return this.modifiedTimeStart;
	}
	public void setModifiedTimeEnd(String modifiedTimeEnd){
		this.modifiedTimeEnd = modifiedTimeEnd;
	}

	public String getModifiedTimeEnd(){
		return this.modifiedTimeEnd;
	}

}
