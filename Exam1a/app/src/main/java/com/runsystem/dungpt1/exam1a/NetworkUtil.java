package com.runsystem.dungpt1.exam1a;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by dungpt1 on 01-Aug-17.
 */

public class NetworkUtil {

    private static NetworkUtil sInstance;
    private static RequestQueue sRequestQueue;
    private static Context sContext;

    public static synchronized NetworkUtil getsInstance(Context context) {
        if (sInstance == null){
            sInstance = new NetworkUtil(context);
        }
        return sInstance;
    }

    public NetworkUtil(Context context) { initNetworkConfig(context); }

    public void initNetworkConfig(Context mContext) {
        sContext = mContext;
        sRequestQueue = getRequesQueue();
    }

    public RequestQueue getRequesQueue() {
        if (sRequestQueue == null){
            sRequestQueue = Volley.newRequestQueue(sContext);
        }
        return sRequestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req){
        getRequesQueue().add(req);
    }


}
