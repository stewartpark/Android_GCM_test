package com.test.gcm_test;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;

/**
 * Created by jyp on 10/31/14.
 */
public class GCMBroadcastReceiver extends WakefulBroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.i("GCMBroadcastReceiver.java | onReceive", "|" + "=================" + "|");
        Bundle bundle = intent.getExtras();
        for (String key : bundle.keySet())
        {
            Object value = bundle.get(key);
            Log.i("GCMBroadcastReceiver.java | onReceive", "|" + String.format("%s : %s (%s)", key, value.toString(), value.getClass().getName()) + "|");
        }
        Log.i("GCMBroadcastReceiver.java | onReceive", "|" + "=================" + "|");

        // Explicitly specify that GcmIntentService will handle the intent.
        ComponentName comp = new ComponentName(context.getPackageName(), GCMIntentService.class.getName());
        // Start the service, keeping the device awake while it is launching.
        startWakefulService(context, intent.setComponent(comp));
        setResultCode(Activity.RESULT_OK);
    }
}
