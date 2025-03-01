package com.ybc.entity.po;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.ybc.entity.enums.DateTimePatternEnum;
import com.ybc.utils.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductInfo implements Serializable {


	/**
	 * 商品id
	 */
	private Integer id;

	/**
	 * 分类id
	 */
	private Integer categoryId;

	/**
	 * 商品系列
	 */
	private String itemType;

	/**
	 * 商品标题
	 */
	private String title;

	/**
	 * 商品卖点
	 */
	private String sellPoint;

	/**
	 * 商品单价
	 */
	private Long price;

	/**
	 * 库存数量
	 */
	private Integer num;

	/**
	 * 图片路径
	 */
	private String image;

	/**
	 * 商品状态  1：上架   2：下架   3：删除
	 */
	private Integer status;

	/**
	 * 显示优先级
	 */
	private Integer priority;

	/**
	 * 创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	/**
	 * 最后修改时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date modifiedTime;

	/**
	 * 创建人
	 */
	private String createdUser;

	/**
	 * 最后修改人
	 */
	private String modifiedUser;


	public void setId(Integer id){
		this.id = id;
	}

	public Integer getId(){
		return this.id;
	}

	public void setCategoryId(Integer categoryId){
		this.categoryId = categoryId;
	}

	public Integer getCategoryId(){
		return this.categoryId;
	}

	public void setItemType(String itemType){
		this.itemType = itemType;
	}

	public String getItemType(){
		return this.itemType;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setSellPoint(String sellPoint){
		this.sellPoint = sellPoint;
	}

	public String getSellPoint(){
		return this.sellPoint;
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

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return this.image;
	}

	public void setStatus(Integer status){
		this.status = status;
	}

	public Integer getStatus(){
		return this.status;
	}

	public void setPriority(Integer priority){
		this.priority = priority;
	}

	public Integer getPriority(){
		return this.priority;
	}

	public void setCreatedTime(Date createdTime){
		this.createdTime = createdTime;
	}

	public Date getCreatedTime(){
		return this.createdTime;
	}

	public void setModifiedTime(Date modifiedTime){
		this.modifiedTime = modifiedTime;
	}

	public Date getModifiedTime(){
		return this.modifiedTime;
	}

	public void setCreatedUser(String createdUser){
		this.createdUser = createdUser;
	}

	public String getCreatedUser(){
		return this.createdUser;
	}

	public void setModifiedUser(String modifiedUser){
		this.modifiedUser = modifiedUser;
	}

	public String getModifiedUser(){
		return this.modifiedUser;
	}

	@Override
	public String toString (){
		return "商品id:"+(id == null ? "空" : id)+"，分类id:"+(categoryId == null ? "空" : categoryId)+"，商品系列:"+(itemType == null ? "空" : itemType)+"，商品标题:"+(title == null ? "空" : title)+"，商品卖点:"+(sellPoint == null ? "空" : sellPoint)+"，商品单价:"+(price == null ? "空" : price)+"，库存数量:"+(num == null ? "空" : num)+"，图片路径:"+(image == null ? "空" : image)+"，商品状态  1：上架   2：下架   3：删除:"+(status == null ? "空" : status)+"，显示优先级:"+(priority == null ? "空" : priority)+"，创建时间:"+(createdTime == null ? "空" : DateUtil.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，最后修改时间:"+(modifiedTime == null ? "空" : DateUtil.format(modifiedTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，创建人:"+(createdUser == null ? "空" : createdUser)+"，最后修改人:"+(modifiedUser == null ? "空" : modifiedUser);
	}
}
