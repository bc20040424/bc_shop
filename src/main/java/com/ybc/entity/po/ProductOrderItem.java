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
public class ProductOrderItem implements Serializable {


	/**
	 * 订单中的商品记录的id
	 */
	private String id;

	/**
	 * 所归属的订单的id
	 */
	private String oid;

	/**
	 * 商品的id
	 */
	private String pid;

	/**
	 * 商品标题
	 */
	private String title;

	/**
	 * 商品图片
	 */
	private String image;

	/**
	 * 商品价格
	 */
	private Long price;

	/**
	 * 购买数量
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


	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setOid(String oid){
		this.oid = oid;
	}

	public String getOid(){
		return this.oid;
	}

	public void setPid(String pid){
		this.pid = pid;
	}

	public String getPid(){
		return this.pid;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return this.image;
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
		return "订单中的商品记录的id:"+(id == null ? "空" : id)+"，所归属的订单的id:"+(oid == null ? "空" : oid)+"，商品的id:"+(pid == null ? "空" : pid)+"，商品标题:"+(title == null ? "空" : title)+"，商品图片:"+(image == null ? "空" : image)+"，商品价格:"+(price == null ? "空" : price)+"，购买数量:"+(num == null ? "空" : num)+"，创建人:"+(createdUser == null ? "空" : createdUser)+"，创建时间:"+(createdTime == null ? "空" : DateUtil.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，修改人:"+(modifiedUser == null ? "空" : modifiedUser)+"，修改时间:"+(modifiedTime == null ? "空" : DateUtil.format(modifiedTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
