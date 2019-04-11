package com.hl.htk_customer.utils;

import android.app.Activity;
import android.widget.Toast;

import com.hl.htk_customer.R;
import com.hl.htk_customer.model.CommonMsg;
import com.loopj.android.http.RequestParams;

public class JPushUtil {

    public static final String NEW_ORDER="1";
    public static final String CANNEL_ORDER="3";

    public static void sendNotification(final Activity context, String mobilePhone, String title, String content, String actionName){
        RequestParams params = AsynClient.getRequestParams();

        params.put("mobilePhone", mobilePhone);
        params.put("title", title);
        params.put("content", content);
        params.put("actionName", actionName);

        AsynClient.post(MyHttpConfing.sendNotification, context, params, new GsonHttpResponseHandler() {
            @Override
            protected Object parseResponse(String rawJsonData) throws Throwable {
                return null;
            }

            @Override
            public void onFailure(int statusCode, String rawJsonData, Object errorResponse) {
                UiFormat.tryRequest(rawJsonData);
                Toast.makeText(context, "推送失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSuccess(int statusCode, String rawJsonResponse, Object response) {
                CommonMsg commonMsg = UiFormat.getCommonMsg(rawJsonResponse);
                if (commonMsg.getCode() == 100) {

                } else {

                }
            }
        });
    }
}
