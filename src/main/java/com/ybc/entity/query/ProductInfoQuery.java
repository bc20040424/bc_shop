package com.ybc.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class ProductInfoQuery extends BaseParam {


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

	private String itemTypeFuzzy;

	/**
	 * 商品标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 商品卖点
	 */
	private String sellPoint;

	private String sellPointFuzzy;

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

	private String imageFuzzy;

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
	private String createdTime;

	private String createdTimeStart;

	private String createdTimeEnd;

	/**
	 * 最后修改时间
	 */
	private String modifiedTime;

	private String modifiedTimeStart;

	private String modifiedTimeEnd;

	/**
	 * 创建人
	 */
	private String createdUser;

	private String createdUserFuzzy;

	/**
	 * 最后修改人
	 */
	private String modifiedUser;

	private String modifiedUserFuzzy;


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

	public void setItemTypeFuzzy(String itemTypeFuzzy){
		this.itemTypeFuzzy = itemTypeFuzzy;
	}

	public String getItemTypeFuzzy(){
		return this.itemTypeFuzzy;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return this.title;
	}

	public void setTitleFuzzy(String titleFuzzy){
		this.titleFuzzy = titleFuzzy;
	}

	public String getTitleFuzzy(){
		return this.titleFuzzy;
	}

	public void setSellPoint(String sellPoint){
		this.sellPoint = sellPoint;
	}

	public String getSellPoint(){
		return this.sellPoint;
	}

	public void setSellPointFuzzy(String sellPointFuzzy){
		this.sellPointFuzzy = sellPointFuzzy;
	}

	public String getSellPointFuzzy(){
		return this.sellPointFuzzy;
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

	public void setImageFuzzy(String imageFuzzy){
		this.imageFuzzy = imageFuzzy;
	}

	public String getImageFuzzy(){
		return this.imageFuzzy;
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

}
