package com.example.jakke.boundservices;

import android.app.Service;
import android.content.Intent;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.icu.text.SimpleDateFormat;
import android.os.Build;
import android.os.IBinder;
import android.os.Binder;
import android.os.StrictMode;
import android.support.annotation.RequiresApi;
import java.sql.Time;
import java.util.Date;
import java.util.Locale;

public class MyService extends Service {

    private final IBinder iBinder = new MyLocalBinder();

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return iBinder;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public String getCurrentTime() {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        return (df.format(new Date()));
    }

    public class MyLocalBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }
}
