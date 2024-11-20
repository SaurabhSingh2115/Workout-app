package com.example.SnapWorkout.activities

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.SnapWorkout.databinding.ActivityMainBinding
import com.example.SnapWorkout.fragments.InstructionsFragment
import com.example.SnapWorkout.receivers.NetworkBroadcastReceiver

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private lateinit var prefs: SharedPreferences
    private lateinit var networkBroadcastReceiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        prefs = getSharedPreferences("SnapWorkout", MODE_PRIVATE)

        // Show instructions on first launch
        if (prefs.getBoolean("firstRun", true)) {
            showInstructions()
            prefs.edit().putBoolean("firstRun", false).apply()
        }

        binding?.flStart?.setOnClickListener {
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }

        binding?.flBMI?.setOnClickListener {
            val intent = Intent(this, BMIActivity::class.java)
            startActivity(intent)
        }

        binding?.flHistory?.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java)
            startActivity(intent)
        }

        binding?.fab?.setOnClickListener {
            val intent = Intent(this, MapsActivity::class.java)
            startActivity(intent)
        }

        // Add listener for "Show Instructions" button
        binding?.btnShowInstructions?.setOnClickListener {
            showInstructions()
        }

        // Initialize and register the network broadcast receiver
        networkBroadcastReceiver = NetworkBroadcastReceiver()
        val intentFilter = IntentFilter().apply {
            addAction("android.net.conn.CONNECTIVITY_CHANGE") // For older APIs
            addAction("android.net.conn.CONNECTIVITY_ACTION") // For modern APIs
        }
        registerReceiver(networkBroadcastReceiver, intentFilter)
    }

    private fun showInstructions() {
        val instructionsFragment = InstructionsFragment()
        instructionsFragment.show(supportFragmentManager, "instructions")
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null

        // Unregister the broadcast receiver to avoid memory leaks
        unregisterReceiver(networkBroadcastReceiver)
    }
}
