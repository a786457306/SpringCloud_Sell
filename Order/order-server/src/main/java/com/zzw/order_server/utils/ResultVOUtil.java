package com.zzw.order_server.utils;

import com.zzw.order_server.vo.ResultVO;

/**
 * @author Daydreamer
 * @date 2019/12/20 16:57
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("success");
        resultVO.setData(object);
        return resultVO;
    }
}
