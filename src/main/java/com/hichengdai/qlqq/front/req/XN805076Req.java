package com.hichengdai.qlqq.front.req;

public class XN805076Req {
	// 手机号
	private String mobile;
	// 登陆密码
	private String loginPwd;
	// 登陆密码强度 1=弱；2=中；3=强
	private String loginPwdStrength;
	// 推荐人
	private String userReferee;
	// 验证码
	private String smsCaptcha;

	private String companyCode;
	// 是否商户 1 是；商户手机号区分不同商户
	private String isMall;

	public String getIsMall() {
		return isMall;
	}

	public void setIsMall(String isMall) {
		this.isMall = isMall;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginPwd() {
		return loginPwd;
	}

	public void setLoginPwd(String loginPwd) {
		this.loginPwd = loginPwd;
	}

	public String getLoginPwdStrength() {
		return loginPwdStrength;
	}

	public void setLoginPwdStrength(String loginPwdStrength) {
		this.loginPwdStrength = loginPwdStrength;
	}

	public String getUserReferee() {
		return userReferee;
	}

	public void setUserReferee(String userReferee) {
		this.userReferee = userReferee;
	}

	public String getSmsCaptcha() {
		return smsCaptcha;
	}

	public void setSmsCaptcha(String smsCaptcha) {
		this.smsCaptcha = smsCaptcha;
	}

}
