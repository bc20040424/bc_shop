package com.ybc.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class ProductCartQuery extends BaseParam {


	/**
	 * 购物车数据id
	 */
	private String cid;

	private String cidFuzzy;

	/**
	 * 用户id
	 */
	private String uid;

	private String uidFuzzy;

	/**
	 * 商品id
	 */
	private String pid;

	private String pidFuzzy;

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


	public void setCid(String cid){
		this.cid = cid;
	}

	public String getCid(){
		return this.cid;
	}

	public void setCidFuzzy(String cidFuzzy){
		this.cidFuzzy = cidFuzzy;
	}

	public String getCidFuzzy(){
		return this.cidFuzzy;
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
