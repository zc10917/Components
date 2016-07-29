package com.example.zhongcheng.components;

import android.app.IntentService;
import android.content.Intent;

/**
 * Created by zhongcheng on 16/7/28.
 */
public class MyIntentService extends IntentService{
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

    }
}
