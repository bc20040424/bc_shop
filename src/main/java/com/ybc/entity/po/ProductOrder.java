package com.ybc.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import com.ybc.entity.enums.DateTimePatternEnum;
import com.ybc.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class ProductOrder implements Serializable {


	/**
	 * 订单id
	 */
	private String oid;

	/**
	 * 用户id
	 */
	private String uid;

	/**
	 * 收货人姓名
	 */
	private String recvName;

	/**
	 * 收货人电话
	 */
	private String recvPhone;

	/**
	 * 收货人所在省
	 */
	private String recvProvince;

	/**
	 * 收货人所在市
	 */
	private String recvCity;

	/**
	 * 收货人所在区
	 */
	private String recvArea;

	/**
	 * 收货详细地址
	 */
	private String recvAddress;

	/**
	 * 总价
	 */
	private Integer totalPrice;

	/**
	 * 状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成
	 */
	private Integer status;

	/**
	 * 下单时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date orderTime;

	/**
	 * 支付时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date payTime;

	/**
	 * 创建人
	 */
	private String createdUser;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	/**
	 * 修改人
	 */
	private String modifiedUser;

	/**
	 * 修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedTime;

	/**
	 * 购买数量
	 */
	private Integer num;

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setOid(String oid){
		this.oid = oid;
	}

	public String getOid(){
		return this.oid;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return this.uid;
	}

	public void setRecvName(String recvName){
		this.recvName = recvName;
	}

	public String getRecvName(){
		return this.recvName;
	}

	public void setRecvPhone(String recvPhone){
		this.recvPhone = recvPhone;
	}

	public String getRecvPhone(){
		return this.recvPhone;
	}

	public void setRecvProvince(String recvProvince){
		this.recvProvince = recvProvince;
	}

	public String getRecvProvince(){
		return this.recvProvince;
	}

	public void setRecvCity(String recvCity){
		this.recvCity = recvCity;
	}

	public String getRecvCity(){
		return this.recvCity;
	}

	public void setRecvArea(String recvArea){
		this.recvArea = recvArea;
	}

	public String getRecvArea(){
		return this.recvArea;
	}

	public void setRecvAddress(String recvAddress){
		this.recvAddress = recvAddress;
	}

	public String getRecvAddress(){
		return this.recvAddress;
	}

	public void setTotalPrice(Integer totalPrice){
		this.totalPrice = totalPrice;
	}

	public Integer getTotalPrice(){
		return this.totalPrice;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setOrderTime(Date orderTime){
		this.orderTime = orderTime;
	}

	public Date getOrderTime(){
		return this.orderTime;
	}

	public void setPayTime(Date payTime){
		this.payTime = payTime;
	}

	public Date getPayTime(){
		return this.payTime;
	}

	public void setCreatedUser(String createdUser){
		this.createdUser = createdUser;
	}

	public String getCreatedUser(){
		return this.createdUser;
	}

	public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}

	public Date getCreatedTime(){
		return this.createdTime;
	}

	public void setModifiedUser(String modifiedUser){
		this.modifiedUser = modifiedUser;
	}

	public String getModifiedUser(){
		return this.modifiedUser;
	}

	public void setModifiedTime(Date modifiedTime){
		this.modifiedTime = modifiedTime;
	}

	public Date getModifiedTime(){
		return this.modifiedTime;
	}

	@Override
	public String toString (){
		return "订单id:"+(oid == null ? "空" : oid)+"，用户id:"+(uid == null ? "空" : uid)+"，收货人姓名:"+(recvName == null ? "空" : recvName)+"，收货人电话:"+(recvPhone == null ? "空" : recvPhone)+"，收货人所在省:"+(recvProvince == null ? "空" : recvProvince)+"，收货人所在市:"+(recvCity == null ? "空" : recvCity)+"，收货人所在区:"+(recvArea == null ? "空" : recvArea)+"，收货详细地址:"+(recvAddress == null ? "空" : recvAddress)+"，总价:"+(totalPrice == null ? "空" : totalPrice)+"，状态：0-未支付，1-已支付，2-已取消，3-已关闭，4-已完成:"+(status == null ? "空" : status)+"，下单时间:"+(orderTime == null ? "空" : DateUtil.format(orderTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，支付时间:"+(payTime == null ? "空" : DateUtil.format(payTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，创建人:"+(createdUser == null ? "空" : createdUser)+"，创建时间:"+(createdTime == null ? "空" : DateUtil.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，修改人:"+(modifiedUser == null ? "空" : modifiedUser)+"，修改时间:"+(modifiedTime == null ? "空" : DateUtil.format(modifiedTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
