package com.ybc.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ybc.entity.enums.DateTimePatternEnum;
import com.ybc.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;


@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductCart implements Serializable {


	/**
	 * 购物车数据id
	 */
	private String cid;

	/**
	 * 用户id
	 */
	private String uid;

	/**
	 * 商品id
	 */
	private String pid;

	/**
	 * 加入时商品单价
	 */
	private Long price;

	/**
	 * 商品数量
	 */
	private Integer num;

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


	public void setCid(String cid){
		this.cid = cid;
	}

	public String getCid(){
		return this.cid;
	}

	public void setUid(String uid){
		this.uid = uid;
	}

	public String getUid(){
		return this.uid;
	}

	public void setPid(String pid){
		this.pid = pid;
	}

	public String getPid(){
		return this.pid;
	}

	public void setPrice(Long price){
		this.price = price;
	}

	public Long getPrice(){
		return this.price;
	}

	public void setNum(Integer num){
		this.num = num;
	}

	public Integer getNum(){
		return this.num;
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
		return "购物车数据id:"+(cid == null ? "空" : cid)+"，用户id:"+(uid == null ? "空" : uid)+"，商品id:"+(pid == null ? "空" : pid)+"，加入时商品单价:"+(price == null ? "空" : price)+"，商品数量:"+(num == null ? "空" : num)+"，创建人:"+(createdUser == null ? "空" : createdUser)+"，创建时间:"+(createdTime == null ? "空" : DateUtil.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，修改人:"+(modifiedUser == null ? "空" : modifiedUser)+"，修改时间:"+(modifiedTime == null ? "空" : DateUtil.format(modifiedTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
