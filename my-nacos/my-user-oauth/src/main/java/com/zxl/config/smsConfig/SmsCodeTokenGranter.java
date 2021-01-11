package com.zxl.config.smsConfig;


import com.zxl.entity.Result;
import com.zxl.entity.myUser.User;
import com.zxl.feign.UserFeign;
import com.zxl.util.UserJwt;
import org.apache.commons.lang.StringUtils;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.provider.*;
import org.springframework.security.oauth2.provider.token.AbstractTokenGranter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Description:
 * </p>
 *
 * @author zxl
 * @version v1.0.0
 * @date 2020-07-29 22:53:22:53

 */

public class SmsCodeTokenGranter extends AbstractTokenGranter {
  private static final String SMS_GRANT_TYPE = "sms_code";

  private static final String DEFAULT_PARAMETER_NAME_PHONE ="phone";

//  private AccountService accountService;

 // private RedisUtil redisUtil;


  private  UserFeign userFeign;

  public void setUserFeign(UserFeign userFeign) {
    this.userFeign = userFeign;
  }

  public UserFeign getUserFeign() {
    return userFeign;
  }



  public SmsCodeTokenGranter(AuthorizationServerTokenServices tokenServices,
                             ClientDetailsService clientDetailsService,
                             OAuth2RequestFactory requestFactory) {
    super(tokenServices, clientDetailsService, requestFactory, SMS_GRANT_TYPE);
  }

 /* public void setAccountService(AccountService accountService) {
    this.accountService = accountService;
  }*/
/*
  public void setAccountService(AccountService accountService) {
    this.accountService = accountService;
  }

  public void setRedisUtil(RedisUtil redisUtil) {
    this.redisUtil = redisUtil;
  }*/

  /**
   * 重写 getOAuth2Authentication 函数，在这个函数中，自定义授权认证逻辑；校验手机号 + 短信验证码是否一致
     getOAuth2Authentication， 手机和验证码校验无误， 返回 OAuth2Authentication 授权信息（access_token）
   * @param client
   * @param tokenRequest
   * @return
     */
  @Override
  protected OAuth2Authentication getOAuth2Authentication(ClientDetails client,
                                                         TokenRequest tokenRequest)  {

    Map<String, String> parameters =
        new LinkedHashMap<String, String>(tokenRequest.getRequestParameters());

    // 客户端提交的手机号码
    String phoneNumber = parameters.get(DEFAULT_PARAMETER_NAME_PHONE);
    Result<User> result = userFeign.findByUsername(phoneNumber);

    if(StringUtils.isBlank(String.valueOf(result.getData()))){
     // throw new Exception("");
      return null;
    }
    String userName = result.getData().getUsername();
    String password = result.getData().getPassword();
    /*if (StringUtils.isBlank(phoneNumber)) {
      throw new BusinessException(ResultCode.PHONE_NUMBER_IS_EMPTY);
    }

    // 客户端提交的验证码
    String smsCode = parameters.get(CommonConstant.DEFAULT_PARAMETER_NAME_CODE_SMS);
    if (StringUtils.isBlank(smsCode)) {
      throw new BusinessException(ResultCode.SMS_CODE_IS_EMPTY);
    }*/

    //sms_login
   /* String smsCodeKey = String.format(CacheNameConstant.SMS_CODE_KEY, "sms_login", phoneNumber);
    SmsCodeDTO smsCodeDTO = (SmsCodeDTO) redisUtil.getValue(smsCodeKey);*/

    // 获取服务中保存的用户验证码, 在生成好后放到缓存中
   /* if (ObjectUtils.isEmpty(smsCodeDTO) || smsCodeDTO.getExpired()) {
      throw new BusinessException(ResultCode.SMS_CODE_ERROR);
    }
    String smsCodeCached = smsCodeDTO.getCode();
    if (!StringUtils.equals(smsCode, smsCodeCached)) {
      throw new BusinessException(ResultCode.SMS_CODE_ERROR);
    }

    // 验证通过后从缓存中移除验证码 etc...
    redisUtil.removeValue(smsCodeKey);*/

    // 客户端提交的手机号码
  //  AccountDTO accountDTO = accountService.getAccountByPhone(phoneNumber);
   /* AccountDTO accountDTO = new AccountDTO();
    accountDTO.setAccountId(775113182741004288L);
    accountDTO.setAccountName(phoneNumber);*/
 //   accountDTO.setAccountName("szitheima");
  //  accountDTO.setPhone("13999999999");
  //  accountDTO.setStatus("1");
    //accountDTO.setCreateTime();

    // TODO: if account not exist , create a new account ??
   /* if (ObjectUtils.isEmpty(accountDTO)) {
      throw new BusinessException(ResultCode.PHONE_NOT_EXITS);
    }
*/
    // TODO: 权限查询 etc...
    /*RoleDTO role = new RoleDTO();
    role.setRole("USER");*/
    //accountService.getAccountRole(accountDTO.getAccountId());

    // 根据手机号码查询用户 ...

    List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(new SimpleGrantedAuthority("goods_list"));
    grantedAuthorities.add(new SimpleGrantedAuthority("seckill_list"));
  //  UserDetails user = new MooseUserDetails(accountDTO, null, grantedAuthorities);
  //  UserJwt userJwt = new UserJwt();
    UserDetails user = new UserJwt(userName, password,phoneNumber, grantedAuthorities);

    // 验证用户状态(是否禁用 etc...)

    Authentication userAuth =
        new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
    // org.springframework.security.core.userdetails.UserDetails 接口的, 所以有 user.getAuthorities()
    // 当然该参数传null也行
    ((AbstractAuthenticationToken) userAuth).setDetails(parameters);
    OAuth2Request storedOAuth2Request =
        getRequestFactory().createOAuth2Request(client, tokenRequest);
    return new OAuth2Authentication(storedOAuth2Request, userAuth);
  }
}
