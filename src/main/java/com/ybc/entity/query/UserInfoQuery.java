package com.ybc.entity.query;

import java.util.Date;


/**
 * 参数
 */
public class UserInfoQuery extends BaseParam {


	/**
	 * 用户id
	 */
	private String id;

	private String idFuzzy;

	/**
	 * 用户名
	 */
	private String username;

	private String usernameFuzzy;

	/**
	 * 密码
	 */
	private String password;

	private String passwordFuzzy;

	/**
	 * 盐值
	 */
	private String salt;

	private String saltFuzzy;

	/**
	 * 电话号码
	 */
	private String phone;

	private String phoneFuzzy;

	/**
	 * 电子邮箱
	 */
	private String email;

	private String emailFuzzy;

	/**
	 * 性别:0-女，1-男
	 */
	private Integer gender;

	/**
	 * 头像
	 */
	private String avatar;

	private String avatarFuzzy;

	/**
	 * 是否删除：0-未删除，1-已删除
	 */
	private Integer isDelete;

	/**
	 * 日志-创建人
	 */
	private String createdUser;

	private String createdUserFuzzy;

	/**
	 * 日志-创建时间
	 */
	private String createdTime;

	private String createdTimeStart;

	private String createdTimeEnd;

	/**
	 * 日志-最后修改执行人
	 */
	private String modifiedUser;

	private String modifiedUserFuzzy;

	/**
	 * 日志-最后修改时间
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

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return this.username;
	}

	public void setUsernameFuzzy(String usernameFuzzy){
		this.usernameFuzzy = usernameFuzzy;
	}

	public String getUsernameFuzzy(){
		return this.usernameFuzzy;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return this.password;
	}

	public void setPasswordFuzzy(String passwordFuzzy){
		this.passwordFuzzy = passwordFuzzy;
	}

	public String getPasswordFuzzy(){
		return this.passwordFuzzy;
	}

	public void setSalt(String salt){
		this.salt = salt;
	}

	public String getSalt(){
		return this.salt;
	}

	public void setSaltFuzzy(String saltFuzzy){
		this.saltFuzzy = saltFuzzy;
	}

	public String getSaltFuzzy(){
		return this.saltFuzzy;
	}

	public void setPhone(String phone){
		this.phone = phone;
	}

	public String getPhone(){
		return this.phone;
	}

	public void setPhoneFuzzy(String phoneFuzzy){
		this.phoneFuzzy = phoneFuzzy;
	}

	public String getPhoneFuzzy(){
		return this.phoneFuzzy;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return this.email;
	}

	public void setEmailFuzzy(String emailFuzzy){
		this.emailFuzzy = emailFuzzy;
	}

	public String getEmailFuzzy(){
		return this.emailFuzzy;
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

	public void setAvatarFuzzy(String avatarFuzzy){
		this.avatarFuzzy = avatarFuzzy;
	}

	public String getAvatarFuzzy(){
		return this.avatarFuzzy;
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
