package com.mdy.nohttpozner.util;

import com.alibaba.fastjson.JSONObject;
import com.yolanda.nohttp.Headers;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.RestRequest;
import com.yolanda.nohttp.rest.StringRequest;

/**
 * Created by cecha on 2016/11/29.
 */

public class RequestHttp extends RestRequest<JSONObject> {
    public RequestHttp(String url) {
        super(url,RequestMethod.POST);
    }

    public RequestHttp(String url, RequestMethod requestMethod) {
        super(url, requestMethod);
    }

    @Override
    public JSONObject parseResponse(Headers responseHeaders, byte[] responseBody) throws Throwable {
        String result = StringRequest.parseResponseString(responseHeaders,responseBody);
        return JSONObject.parseObject(result);
    }


}
