package com.example.zhongcheng.components;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;




public class MainActivity extends AppCompatActivity implements ServiceConnection, View
        .OnClickListener {
    boolean bind = false;
//    IRemoteService iRemoteService;

    @Bind(R.id.btn1)
    Button btn1;
    @Bind(R.id.btn2)
    Button btn2;
    @Bind(R.id.btn3)
    Button btn3;
    @Bind(R.id.btn4)
    Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e("Activity", "start");
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);


    }

    @Override
    protected void onDestroy() {
        if(bind){
            unbindService(this);
            bind = false;
        }
        Log.e("Activity", "destroy");
        super.onDestroy();


    }

    @Override
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
//        MyService.MyBinder myBinder= (MyService.MyBinder)iBinder;
//
//        MyService myService = myBinder.getMyService();
//        iRemoteService = IRemoteService.Stub.asInterface(iBinder);
    }

    @Override
    public void onServiceDisconnected(ComponentName componentName) {

    }

    @Override
    public void onClick(View view) {
        Intent intent  = new Intent("remote");
        switch (view.getId()){
            case R.id.btn1:
                startService(intent);




                break;
            case R.id.btn2:
                stopService(intent);
                break;
            case R.id.btn3:
                bind = true;
                bindService(intent,this,BIND_AUTO_CREATE);
                break;
            case R.id.btn4:
                if(bind){

                    unbindService(this);
                    bind = false;
                }
                break;
        }
    }
}
