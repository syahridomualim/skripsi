package com.syahrido.mualim.example.aplikasiabsen.coroutine

import android.app.Activity
import android.content.Context
import android.content.Intent
import kotlinx.coroutines.*

fun <T> Activity.moveWithCoroutine(context: Context, activity: Class<T>): Job {
    return CoroutineScope(Dispatchers.Main).launch {
        delay(3000)
        startActivity(Intent(context, activity))
        finish()
    }
}
