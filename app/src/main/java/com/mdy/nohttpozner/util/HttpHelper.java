package com.mdy.nohttpozner.util;

import android.content.Context;

import com.mdy.nohttpozner.commant.OznerPreference;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;

import org.json.JSONObject;

/**
 * Created by cecha on 2016/11/28.
 */

public class HttpHelper {
    public void getPhoneCode(Context context, String tel) {
        String url = OznerPreference.serverAddr(context) + "/OznerServer/GetPhoneCode";
        Request<JSONObject> request = NoHttp.createJsonObjectRequest(url, RequestMethod.POST);
        request.add("phone", tel);
        CallServer.getInstance().add(0, request, null);
    }

    public void callCancelRequest(Object sign){
        CallServer.getInstance().cancelBySign(sign);
    }

    public void callCancelAll(){
        CallServer.getInstance().cancelAll();
    }

}
