// IMyAidlInterface.aidl
package com.example.zhongcheng.components;

// Declare any non-default types here with import statements
import com.example.zhongcheng.components.MyRect;
interface IRemoteService {

    MyRect get();
    void set(inout MyRect myrect);


}
