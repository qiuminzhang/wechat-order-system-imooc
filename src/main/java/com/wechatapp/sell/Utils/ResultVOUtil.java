package com.wechatapp.sell.Utils;

import com.wechatapp.sell.VO.ResultVO;

import javax.xml.transform.Result;

/**
 * Util class for ResultVO, so that we don't need redundant code when build a resultVO
 */

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("success");
        return resultVO;
    }

    public static ResultVO success(){    // like delete method
        return success(null);
    }

    public static ResultVO error(Integer code, String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return resultVO;
    }
}
