package com.example.SnapWorkout.activities

import android.app.Dialog
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.util.Log
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.SnapWorkout.Constants
import com.example.SnapWorkout.model.ExerciseModel
import com.example.SnapWorkout.adapter.ExerciseStatusAdapter
import com.example.SnapWorkout.R
import com.example.SnapWorkout.databinding.ActivityExerciseBinding
import com.example.SnapWorkout.databinding.DialogCustomBackConfirmationBinding
import kotlinx.coroutines.*
import java.util.*
import kotlin.collections.ArrayList

class ExerciseActivity : AppCompatActivity(), TextToSpeech.OnInitListener {

    private var binding: ActivityExerciseBinding? = null
    private var exerciseList: ArrayList<ExerciseModel>? = null
    private var currentExercisePosition = -1
    private var tts: TextToSpeech? = null
    private var player: MediaPlayer? = null
    private var exerciseAdapter: ExerciseStatusAdapter? = null

    private var exerciseTimerDuration: Long = 30
    private var timerJob: Job? = null

    // Coroutine scope tied to the activity lifecycle
    private val activityScope = CoroutineScope(Dispatchers.Main + Job())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityExerciseBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarExercise)

        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }

        binding?.toolbarExercise?.setNavigationOnClickListener {
            customDialogForBackButton()
        }

        tts = TextToSpeech(this, this)
        exerciseList = Constants.defaultExerciseList()
        setupRestView()
        setupExerciseStatusRecyclerView()
    }

    private fun setupRestView() {
        try {
            val soundURI = Uri.parse("android.resource://eu.tutorials.a7_minutesworkoutapp/" + R.raw.press_start)
            player = MediaPlayer.create(applicationContext, soundURI)
            player?.isLooping = false
            player?.start()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        binding?.apply {
            flRestView.visibility = View.VISIBLE
            tvTitle.visibility = View.VISIBLE
            upcomingLabel.visibility = View.VISIBLE
            tvUpcomingExerciseName.visibility = View.VISIBLE
            tvExerciseName.visibility = View.INVISIBLE
            flExerciseView.visibility = View.INVISIBLE
            ivImage.visibility = View.INVISIBLE
        }

        // Cancel any existing timer
        timerJob?.cancel()

        binding?.tvUpcomingExerciseName?.text = exerciseList!![currentExercisePosition + 1].getName()
        startRestTimer()
    }

    private fun startRestTimer() {
        var progress = 0
        binding?.progressBar?.progress = progress

        timerJob = activityScope.launch {
            for (timeLeft in 10 downTo 1) {
                binding?.progressBar?.progress = progress
                binding?.tvTimer?.text = timeLeft.toString()
                delay(1000) // Wait for 1 second
                progress++
            }

            // Timer finished
            currentExercisePosition++
            exerciseList!![currentExercisePosition].setIsSelected(true)
            exerciseAdapter?.notifyDataSetChanged()
            setupExerciseView()
        }
    }

    private fun setupExerciseView() {
        binding?.apply {
            flRestView.visibility = View.INVISIBLE
            tvTitle.visibility = View.INVISIBLE
            tvUpcomingExerciseName.visibility = View.INVISIBLE
            upcomingLabel.visibility = View.INVISIBLE
            tvExerciseName.visibility = View.VISIBLE
            flExerciseView.visibility = View.VISIBLE
            ivImage.visibility = View.VISIBLE
        }

        timerJob?.cancel()

        speakOut(exerciseList!![currentExercisePosition].getName())

        binding?.ivImage?.setImageResource(exerciseList!![currentExercisePosition].getImage())
        binding?.tvExerciseName?.text = exerciseList!![currentExercisePosition].getName()

        startExerciseTimer()
    }

    private fun startExerciseTimer() {
        var progress = 0
        binding?.progressBarExercise?.progress = progress

        timerJob = activityScope.launch {
            for (timeLeft in exerciseTimerDuration.toInt() downTo 1) {
                binding?.progressBarExercise?.progress = progress
                binding?.tvTimerExercise?.text = timeLeft.toString()
                delay(1000) // Wait for 1 second
                progress++
            }

            // Timer finished
            if (currentExercisePosition < exerciseList?.size!! - 1) {
                exerciseList!![currentExercisePosition].apply {
                    setIsSelected(false)
                    setIsCompleted(true)
                }
                exerciseAdapter?.notifyDataSetChanged()
                setupRestView()
            } else {
                finish()
                startActivity(Intent(this@ExerciseActivity, FinishActivity::class.java))
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // Cancel all coroutines started in this activity
        activityScope.cancel()

        // Cleanup resources
        tts?.apply {
            stop()
            shutdown()
        }

        player?.stop()
        binding = null
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val result = tts?.setLanguage(Locale.US)
            if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "The Language specified is not supported!")
            }
        } else {
            Log.e("TTS", "Initialization Failed!")
        }
    }

    private fun speakOut(text: String) {
        tts!!.speak(text, TextToSpeech.QUEUE_FLUSH, null, "")
    }

    private fun setupExerciseStatusRecyclerView() {
        binding?.rvExerciseStatus?.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        exerciseAdapter = ExerciseStatusAdapter(exerciseList!!)
        binding?.rvExerciseStatus?.adapter = exerciseAdapter
    }

    private fun customDialogForBackButton() {
        val customDialog = Dialog(this)
        val dialogBinding = DialogCustomBackConfirmationBinding.inflate(layoutInflater)

        customDialog.setContentView(dialogBinding.root)
        customDialog.setCanceledOnTouchOutside(false)

        dialogBinding.tvYes.setOnClickListener {
            this@ExerciseActivity.finish()
            customDialog.dismiss()
        }
        dialogBinding.tvNo.setOnClickListener {
            customDialog.dismiss()
        }

        customDialog.show()
    }
}