package com.mdy.nohttpozner.util;

import android.content.Context;
import android.telephony.TelephonyManager;

import com.mdy.nohttpozner.commant.OznerPreference;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;

import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by cecha on 2016/11/28.
 */

public class HttpHelper {

    public static void getPhoneCode(Context context, String tel, OnResponseListener listener) {
        String url = OznerPreference.serverAddr(context) + "/OznerServer/GetPhoneCode";
        Request<JSONObject> request = NoHttp.createJsonObjectRequest(url, RequestMethod.POST);
        request.add("phone", tel);
        CallServer.getInstance().add(0, request, listener);
    }
    public static void loginIn(Context context, String tel,String code, OnResponseListener listener) {
        String url = OznerPreference.serverAddr(context) + "/OznerServer/Login";
        Request<JSONObject> request = NoHttp.createJsonObjectRequest(url, RequestMethod.POST);
        request.add("UserName", tel);
        request.add("PassWord", code);
        request.add("miei", getImie(context));
        request.add("devicename", android.os.Build.MANUFACTURER);
        CallServer.getInstance().add(0, request, listener);
    }
    public static void getVoiceCode(Context context, String tel, OnResponseListener listener) {
        String url = OznerPreference.serverAddr(context) + "/OznerServer/Login";
        Request<JSONObject> request = NoHttp.createJsonObjectRequest(url, RequestMethod.POST);
        request.add("phone", tel);
        CallServer.getInstance().add(0, request, listener);
    }

    public static void callCancelRequest(Object sign){
        CallServer.getInstance().cancelBySign(sign);
    }

    public static void callCancelAll(){
        CallServer.getInstance().cancelAll();
    }

    /**
     * 获取手机mac地址<br/>
     * 错误返回12个0
     */
    public static String getImie(Context context) {
        // 获取mac地址：
        try {
            TelephonyManager telephonemanage = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            return telephonemanage.getDeviceId();
        } catch (Exception ex) {
            return UUID.randomUUID().toString();
        }
    }
}
