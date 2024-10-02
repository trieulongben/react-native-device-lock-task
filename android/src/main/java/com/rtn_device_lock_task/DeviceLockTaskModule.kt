package com.rtn_device_lock_task

import android.app.ActivityManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext


class DeviceLockTaskModule(reactContext: ReactApplicationContext) :
    NativeDeviceLockTaskSpec(reactContext) {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun isAppInLockTaskMode(promise: Promise?) {
        try {
            val mActivity = currentActivity
            if (mActivity != null) {
                val activityManager =
                    mActivity.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager

                // When SDK version is 23
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    val lockTaskMode = activityManager.lockTaskModeState
                    promise!!.resolve(lockTaskMode == ActivityManager.LOCK_TASK_MODE_PINNED)
                } else {
                    promise!!.resolve(activityManager.isInLockTaskMode)
                }
            }
        } catch (e: Exception) {
            promise!!.reject(e)
        }
    }

    private
    val ACTIVITY_GONE: String = "ACTIVITY_GONE"

    private
    val LOCKED_TASK: String = "LOCKED_TASK"

    private
    val UNLOCKED_TASK: String = "UNLOCKED_TASK"

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun startLockTask(promise: Promise?) {
        try {
            if (promise == null) return
            val mActivity = currentActivity
                ?: return promise.reject(ACTIVITY_GONE, "Activity gone or mismatch")
            mActivity.startLockTask()
            promise.resolve(LOCKED_TASK)
        } catch (e: java.lang.Exception) {
            promise!!.reject(e)
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun stopLockTask(promise: Promise?) {
        try {
            if (promise == null) return
            val mActivity = currentActivity
                ?: return promise.reject(ACTIVITY_GONE, "Activity gone or mismatch")
            mActivity.stopLockTask()
            promise.resolve(UNLOCKED_TASK)
        } catch (e: java.lang.Exception) {
            promise!!.reject(e)
        }
    }

    companion object{
        val NAME="RTNDeviceLockTask"
    }
}