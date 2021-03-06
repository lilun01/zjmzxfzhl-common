package com.zjmzxfzhl.common.remote.feign;

import com.zjmzxfzhl.common.core.Result;
import com.zjmzxfzhl.common.core.base.UserInfo;
import com.zjmzxfzhl.common.core.constant.SecurityConstants;
import com.zjmzxfzhl.common.core.constant.ServiceNameConstants;
import com.zjmzxfzhl.common.remote.feign.factory.RemoteSysUserServiceFallbackFactory;
import com.zjmzxfzhl.common.core.base.UserInfoService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 庄金明
 * @date
 */
@FeignClient(path = "sys", contextId = RemoteSysUserService.BEAN_ID, qualifier = RemoteSysUserService.BEAN_ID, name =
        ServiceNameConstants.SYS_SERVICE, fallbackFactory = RemoteSysUserServiceFallbackFactory.class)
public interface RemoteSysUserService extends UserInfoService {
    String BEAN_ID = "remoteSysUserService";

    /**
     * 通过用户名查询用户信息
     *
     * @param userId 用户名
     * @param inner
     * @return Result
     */
    @Override
    @GetMapping("/user/info")
    Result<UserInfo> info(@RequestParam("userId") String userId, @RequestHeader(SecurityConstants.INNER) String inner);

}
