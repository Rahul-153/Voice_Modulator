package com.example.voicemodulation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallConfig
import com.zegocloud.uikit.prebuilt.call.ZegoUIKitPrebuiltCallFragment


class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        addCallFragment()
    }

    private fun addCallFragment() {
        val appID = intent.getLongExtra("appID", 0L)
        val appSign = intent.getStringExtra("appSign")
        val userID = intent.getStringExtra("userID")
        val userName = intent.getStringExtra("userName")
        val callID = intent.getStringExtra("callID")

        // You can also use GroupVideo/GroupVoice/OneOnOneVoice to make more types of calls.
        val config = ZegoUIKitPrebuiltCallConfig.oneOnOneVideoCall()
        val fragment = ZegoUIKitPrebuiltCallFragment.newInstance(
            appID, appSign!!, userID!!, userName!!, callID!!, config
        )
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commitNow()
    }
}


