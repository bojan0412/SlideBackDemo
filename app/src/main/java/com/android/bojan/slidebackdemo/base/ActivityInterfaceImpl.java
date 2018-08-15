package com.android.bojan.slidebackdemo.base;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.android.bojan.slidebackdemo.helper.ActivityStackManager;

/**
 * Create by bojan
 * on 2018/8/15
 */
public class ActivityInterfaceImpl extends Activity implements ActivityInterface {
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks;

    @Override
    public void setActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks callbacks) {
        mActivityLifecycleCallbacks = callbacks;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityStackManager.addToStack(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityStackManager.removeFromStack(this);
        if (mActivityLifecycleCallbacks != null) {
            mActivityLifecycleCallbacks.onActivityDestroyed(this);
        }
    }
}
