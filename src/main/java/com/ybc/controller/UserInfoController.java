package com.ybc.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.ybc.config.AppConfig;
import com.ybc.constants.Constants;
import com.ybc.entity.dto.UserInfoDto;
import com.ybc.entity.query.UserInfoQuery;
import com.ybc.entity.po.UserInfo;
import com.ybc.entity.vo.ResponseVO;
import com.ybc.exception.BusinessException;
import com.ybc.service.UserInfoService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *  Controller
 */
@Validated
@RestController
public class UserInfoController extends ABaseController{

	@Resource
	private UserInfoService userInfoService;

	/**
	 * 根据Id查询对象
	 */
	@RequestMapping("/getUserInfoById")
	public ResponseVO getUserInfoById(String id) {
		return getSuccessResponseVO(userInfoService.getUserInfoById(id));
	}

	/**
	 * 根据Id修改对象
	 */
	@RequestMapping("/updateUserInfoById")
	public ResponseVO updateUserInfoById(UserInfo bean,String id) {
		userInfoService.updateUserInfoById(bean,id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Id删除
	 */
	@RequestMapping("/deleteUserInfoById")
	public ResponseVO deleteUserInfoById(String id) {
		userInfoService.deleteUserInfoById(id);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Username查询对象
	 */
	@RequestMapping("/getUserInfoByUsername")
	public ResponseVO getUserInfoByUsername(String username) {
		return getSuccessResponseVO(userInfoService.getUserInfoByUsername(username));
	}

	/**
	 * 根据Username修改对象
	 */
	@RequestMapping("/updateUserInfoByUsername")
	public ResponseVO updateUserInfoByUsername(UserInfo bean,String username) {
		userInfoService.updateUserInfoByUsername(bean,username);
		return getSuccessResponseVO(null);
	}

	/**
	 * 根据Username删除
	 */
	@RequestMapping("/deleteUserInfoByUsername")
	public ResponseVO deleteUserInfoByUsername(String username) {
		userInfoService.deleteUserInfoByUsername(username);
		return getSuccessResponseVO(null);
	}

	/**
	 * 注册功能
	 * @param email
	 * @param userName
	 * @param password
	 * @return
	 */
//	@GlobalInterceptor(checkParams = true)
	@RequestMapping("/register")
	public ResponseVO register(@NotEmpty @Email @Size(max=150) String email,
							   @NotEmpty  @Size(max=20) String userName,
							   @NotEmpty @Size(min=6,max = 16) String password){
		userInfoService.register(email,userName,password);
		return getSuccessResponseVO(null);
	}

	/**
	 * 登录功能
	 * @param email
	 * @param password
	 * @return
	 */

//	@GlobalInterceptor(checkParams = true)
	@RequestMapping("/login")
	public ResponseVO login(HttpSession session,  @NotEmpty @Email @Size(max=150)String email,
							@NotEmpty @Size(min=6,max = 16)String password){
		UserInfoDto userInfoDto=userInfoService.login(email,password);
		session.setAttribute("userId",userInfoDto.getUserId());
		session.setAttribute("userName",userInfoDto.getUserName());
		return getSuccessResponseVO(userInfoDto);
	}

	//退出功能
	@RequestMapping("/logout")
	public ResponseVO logout(HttpSession session){
		session.invalidate();
		return getSuccessResponseVO(null);
	}
	//更改用户密码
	@RequestMapping("rePwd")
	public ResponseVO rePwd(@NotEmpty  @Email String email,@NotEmpty String oldPassword,@NotEmpty String newPassword){
		userInfoService.updatePassword(email,oldPassword,newPassword);
		return getSuccessResponseVO(null);
	}
	//更改用户名
	@RequestMapping("reUserName")
	public ResponseVO reUserName (@NotEmpty @Email String email,@NotEmpty @Size(max = 20) String newName){
		userInfoService.updateUserName(email,newName);
		return getSuccessResponseVO(null);
	}
	//限制上传的文件类型
	public static final List<String>AVATAR_TYPE =new ArrayList<>();
	static{
		AVATAR_TYPE.add("image/jpeg");
		AVATAR_TYPE.add("image/png");
		AVATAR_TYPE.add("image/bmp");
		AVATAR_TYPE.add("image/gif");
		AVATAR_TYPE.add("image/jpg");
	}
	@RequestMapping("/updateAvatarById")
	public ResponseVO updateAvatarById(HttpSession session, MultipartFile file){
		if(file.isEmpty()){
			throw new BusinessException("文件为空");
		} else if (file.getSize()>Constants.AVATAR_MAX_SIZE) {
			throw new BusinessException("文件大小超过限制");
		} else if (!AVATAR_TYPE.contains(file.getContentType())){
			throw new BusinessException("不包含所允许的文件类型");
		}
		//将头像文件放在upload文件下
		String parent="E:/dystore/upload";
		File dir=new File(parent);
		if (!dir.exists()){
			dir.mkdirs();
		}
		String originFileName= file.getOriginalFilename();
		//获取文件名称中"."的下表索引
		int index=originFileName.lastIndexOf(".");
		String subString=originFileName.substring(index);
		//随机生成文件名称
		String fileName=UUID.randomUUID().toString().toUpperCase()+subString;
		File dest = new File(dir, fileName);
		try {
			file.transferTo(dest);
			System.out.println("File saved to: " + dest.getAbsolutePath());
		} catch (IOException e) {
			throw new BusinessException("文件保存失败", e);
		}
		String avatar="/upload/"+fileName;
		String userId=getIdFromSession(session);
		userInfoService.updateAvatarById(userId,avatar);
		return getSuccessResponseVO(null);
	}

}