package com.zxl.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zxl.entity.R;
import com.zxl.entity.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * <p>
 * Description
 * </p>
 *
 * @author zxl
 * @version v1.0.0
 * @date 2021/01/12 22:54
 * @see
 */
@Component
@Slf4j
public class MyAccessDeniedHandler implements AccessDeniedHandler {

  @Resource private ObjectMapper objectMapper;

  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
                     AccessDeniedException e) throws
      IOException {
    response.setContentType("application/json;charset=UTF-8");
    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
    PrintWriter writer = response.getWriter();
    log.info("MooseAccessDeniedHandler 用户无权访问 [{}]", e.getMessage());

    objectMapper.writeValue(writer, R.fail(ResultCode.PERMISSION_ACCESS_DENIED));
  }
}
