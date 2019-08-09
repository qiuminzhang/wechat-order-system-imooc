/**
 * VO, stands for view objects, defines the result formant and
 * contains data that will be sent to frontend.
 */
package com.wechatapp.sell.VO;

import lombok.Data;

/**
 * Http 请求返回的最外层对象
 */

@Data
public class ResultVO<T> {

    /** Error Code*/
    private Integer code;

    private String msg;

    /** Specific Info*/
    private T data; // Data is an object, it could be a list...
}
