package com.rtn_device_lock_task

import android.util.Log
import com.facebook.react.TurboReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.model.ReactModuleInfo
import com.facebook.react.module.model.ReactModuleInfoProvider

class DeviceLockTaskPackage : TurboReactPackage() {

    override fun getModule(name: String, reactAppContext: ReactApplicationContext): NativeModule? {

        if(name==DeviceLockTaskModule.NAME){
            return DeviceLockTaskModule(reactAppContext)
        }
        else{
            return null

        }
    }
    override fun getReactModuleInfoProvider()=ReactModuleInfoProvider {
        mapOf(
            DeviceLockTaskModule.NAME to ReactModuleInfo(
                DeviceLockTaskModule.NAME,DeviceLockTaskModule.NAME, _canOverrideExistingModule = false, _needsEagerInit = false,false, isTurboModule = true
            )
        )
    }

}
