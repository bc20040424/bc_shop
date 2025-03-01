package com.ybc.entity.dto;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Setter
@Getter
public class UserInfoDto implements Serializable {
    private String userId;
    private String userName;
    private String email;
    private String avatar;
    private Date createdTime;
    private Date modifiedTime;
}
