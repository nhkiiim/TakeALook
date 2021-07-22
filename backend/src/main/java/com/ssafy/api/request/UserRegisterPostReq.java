package com.ssafy.api.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 유저 회원가입 API ([POST] /api/v1/users) 요청에 필요한 리퀘스트 바디 정의.
 */
@Getter
@Setter
@ToString
@ApiModel("UserRegisterPostRequest")
public class UserRegisterPostReq {
	@ApiModelProperty(name="유저 userId", example="ssafy")
	String userId;

	@ApiModelProperty(name="유저 password", example="1234")
	String password;

	@ApiModelProperty(name="유저 name", example="싸피")
	String name;

	@ApiModelProperty(name="유저 email", example="ssafy@ssafy.com")
	String email;

	@ApiModelProperty(name="유저 address", example="서울")
	String address;

}
