package com.syahrido.mualim.example.aplikasiabsen

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.syahrido.mualim.example.aplikasiabsen.coroutine.moveWithCoroutine
import com.syahrido.mualim.example.aplikasiabsen.databinding.ActivityMainBinding
import kotlinx.coroutines.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(MainActivity::class.java.name, "Launching activity")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAnimation()

        moveWithCoroutine(this, LoginActivity::class.java)
    }

    private fun setAnimation() {
        val topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        val bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        binding.appIcon.animation = topAnimation
        binding.tvName.animation = bottomAnimation
    }

    private fun goHomePage(): Job {
        return CoroutineScope(Dispatchers.Main).launch {
            delay(3000)
            startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            finish()
        }
    }

    override fun onBackPressed() {
    }
}