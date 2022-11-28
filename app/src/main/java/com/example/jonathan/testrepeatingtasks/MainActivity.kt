package com.example.jonathan.testrepeatingtasks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var mTextView: TextView? = null

    private val mHandler = Handler(Looper.getMainLooper())

    private val mRunnable = object : Runnable {
        override fun run() {
            runCount++

            Log.d(TAG, "mRunnable: runCount=$runCount")

            mTextView?.text = "runCount=$runCount"

            mHandler.postDelayed(this, UPDATE_INTERVAL)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextView = findViewById(R.id.run_count_text_view)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")

        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume")

        super.onResume()

        startRepeatingTask()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")

        super.onPause()

        stopRepeatingTask()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")

        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")

        super.onDestroy()
    }

    private fun startRepeatingTask() {
        Log.d(TAG, "startRepeatingTask")

        mRunnable.run()
    }

    private fun stopRepeatingTask() {
        Log.d(TAG, "stopRepeatingTask")

        mHandler.removeCallbacks(mRunnable)
    }

    companion object {
        private const val TAG = "TRPT: MainActivity"

        private const val UPDATE_INTERVAL = 5000L

        private var runCount = 0
    }
}