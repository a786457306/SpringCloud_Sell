package com.zzw.order.utils;

import com.zzw.order.vo.ResultVO;

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
