package com.example.zhongcheng.components;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by zhongcheng on 16/7/27.
 */
public class MyService extends Service {
    //    public MyBinder binder = new MyBinder();
    Messenger messenger = new Messenger(new MyInternalHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("service", "onbind");

        return messenger.getBinder();
//        return mBinder;
    }

    public class MyInternalHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    Log.e("remote", "success");
//                    MyRect my = msg.getData().getParcelable("data");
                    Bundle bundle=msg.getData();
                    bundle.getParcelable("data");

                    Log.e("remote", bundle.toString());
//                    Log.e("remote", msg.getData().getParcelable("data").toString());
            }
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("service", "onCreate" + Thread.currentThread().toString());
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e("service", "onStart");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("service", "onDestory");
    }
//    public class MyBinder extends Binder {
//        public MyService getMyService(){
//            return MyService.this;
//        }
//
//    }

    @Override
    public boolean bindService(Intent service, ServiceConnection conn, int flags) {
        Log.e("service", "bind");
        return super.bindService(service, conn, flags);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void unbindService(ServiceConnection conn) {
        Log.e("service", "unbind");
        super.unbindService(conn);
    }


//    private final IRemoteService.Stub mBinder = new IRemoteService.Stub() {
//
//
//        @Override
//        public MyRect get() throws RemoteException {
//            return new MyRect(1,1);
//        }
//
//        @Override
//        public void set(MyRect myrect) throws RemoteException {
//            Log.e("remoteset",""+myrect.toString());
//        }
//    };
}