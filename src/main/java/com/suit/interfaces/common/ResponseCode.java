package com.suit.interfaces.common;
import static com.suit.interfaces.common.ResponseResult.ResponseParam.buildParam;
import static com.suit.interfaces.common.ResponseResult.ResponseParam;

/**
 * <p>
 * 返回码
 * </p>
 *
 * @author gongxc
 * @date 2020/7/3
 */

public enum ResponseCode {
    SUCCESS(buildParam(0, "成功"));
    public final  ResponseParam PARAM;
    ResponseCode(ResponseParam param){
        this.PARAM = param;
    }
}
