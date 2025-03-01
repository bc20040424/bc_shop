package com.ybc.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class ProductOrderItemQuery extends BaseParam {


	/**
	 * 订单中的商品记录的id
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 所归属的订单的id
	 */
	private String oid;

	private String oidFuzzy;

	/**
	 * 商品的id
	 */
	private String pid;

	private String pidFuzzy;

	/**
	 * 商品标题
	 */
	private String title;

	private String titleFuzzy;

	/**
	 * 商品图片
	 */
	private String image;

	private String imageFuzzy;

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


	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return this.id;
	}

	public void setIdFuzzy(String idFuzzy){
		this.idFuzzy = idFuzzy;
	}

	public String getIdFuzzy(){
		return this.idFuzzy;
	}

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

	public void setPid(String pid){
		this.pid = pid;
	}

	public String getPid(){
		return this.pid;
	}

	public void setPidFuzzy(String pidFuzzy){
		this.pidFuzzy = pidFuzzy;
	}

	public String getPidFuzzy(){
		return this.pidFuzzy;
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
