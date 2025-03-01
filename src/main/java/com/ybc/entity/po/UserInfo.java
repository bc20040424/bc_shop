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
public class UserInfo implements Serializable {


	/**
	 * 用户id
	 */
	private String id;

	/**
	 * 用户名
	 */
	private String username;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 盐值
	 */
	private String salt;

	/**
	 * 电话号码
	 */
	@JsonIgnore
	private String phone;

	/**
	 * 电子邮箱
	 */
	private String email;

	/**
	 * 性别:0-女，1-男
	 */
	private Integer gender;

	/**
	 * 头像
	 */
	private String avatar;

	/**
	 * 是否删除：0-未删除，1-已删除
	 */
	private Integer isDelete;

	/**
	 * 日志-创建人
	 */
	private String createdUser;

	/**
	 * 日志-创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createdTime;

	/**
	 * 日志-最后修改执行人
	 */
	private String modifiedUser;

	/**
	 * 日志-最后修改时间
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

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setSalt(String salt){
		this.salt = salt;
	}

	public String getSalt(){
		return this.salt;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return this.phone;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setGender(Integer gender){
		this.gender = gender;
	}

	public Integer getGender(){
		return this.gender;
	}

	public void setAvatar(String avatar){
		this.avatar = avatar;
	}

	public String getAvatar(){
		return this.avatar;
	}

	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	public Integer getIsDelete(){
		return this.isDelete;
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
		return "用户id:"+(id == null ? "空" : id)+"，用户名:"+(username == null ? "空" : username)+"，密码:"+(password == null ? "空" : password)+"，盐值:"+(salt == null ? "空" : salt)+"，电话号码:"+(phone == null ? "空" : phone)+"，电子邮箱:"+(email == null ? "空" : email)+"，性别:0-女，1-男:"+(gender == null ? "空" : gender)+"，头像:"+(avatar == null ? "空" : avatar)+"，是否删除：0-未删除，1-已删除:"+(isDelete == null ? "空" : isDelete)+"，日志-创建人:"+(createdUser == null ? "空" : createdUser)+"，日志-创建时间:"+(createdTime == null ? "空" : DateUtil.format(createdTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))+"，日志-最后修改执行人:"+(modifiedUser == null ? "空" : modifiedUser)+"，日志-最后修改时间:"+(modifiedTime == null ? "空" : DateUtil.format(modifiedTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()));
	}
}
