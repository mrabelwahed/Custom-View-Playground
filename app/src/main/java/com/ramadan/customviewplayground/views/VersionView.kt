package com.ramadan.customviewplayground.views

import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import java.lang.Exception

class VersionView @JvmOverloads constructor(context: Context,
                                            attrs: AttributeSet? = null,
                                            defStyleAttr: Int = 0) :
   AppCompatTextView(context,attrs,defStyleAttr) {

    init {
        setVersion()
    }

    private fun setVersion(){
        try {
            val packageInfo =context.packageManager.getPackageInfo(context.packageName,0)
            text = packageInfo.versionName
        }catch (error:Exception){
        }
        setBackgroundColor(Color.CYAN)
    }
}