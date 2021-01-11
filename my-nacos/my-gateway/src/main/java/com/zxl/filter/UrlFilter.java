package com.zxl.filter;

/**
 * 描述
 *
 * @author zxl
 * @version 1.0
 * @since 1.0
 */
public class UrlFilter {

    private static  final String nointerceterurl="/api/user_auth/login,/api/out/logout,/api/user_auth/smsLogin,/api/smsCode";
    /**
     * 用来判断 如果 当前的请求 在 放行的请求中存在,(不需要拦截 :true,否则需要拦截:false)
     * @return
     */
    public static boolean hasAutorize(String uri){
        String[] split = nointerceterurl.split(",");

        for (String s : split) {
            if(uri.contains(s)){
                //不需要拦截
                return true;
            }
        }

        //要拦截
        return false;
    }
}
