package com.fenghua.auto.finance.wxpay.sdk.service;

import com.fenghua.auto.finance.wxpay.sdk.common.Configure;
import com.fenghua.auto.finance.wxpay.sdk.protocol.closeorder_protocol.CloseOrderReqData;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 16:04
 */
public class CloseOrderService extends BaseService{

    public CloseOrderService() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        super(Configure.REVERSE_API);
    }

    /**
     * 请求撤销服务
     * @param reverseReqData 这个数据对象里面包含了API要求提交的各种数据字段
     * @return API返回的XML数据
     * @throws Exception
     */
    public String request(CloseOrderReqData reverseReqData) throws Exception {

        //--------------------------------------------------------------------
        //发送HTTPS的Post请求到API地址
        //--------------------------------------------------------------------
        String responseString = sendPost(reverseReqData);

        return responseString;
    }

}
