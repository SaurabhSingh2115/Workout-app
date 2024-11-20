package com.example.SnapWorkout.activities;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\tH\u0016J\b\u0010 \u001a\u00020\u0019H\u0002J\b\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\b\u0010\'\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006("}, d2 = {"Lcom/example/SnapWorkout/activities/ExerciseActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/speech/tts/TextToSpeech$OnInitListener;", "()V", "activityScope", "Lkotlinx/coroutines/CoroutineScope;", "binding", "Lcom/example/SnapWorkout/databinding/ActivityExerciseBinding;", "currentExercisePosition", "", "exerciseAdapter", "Lcom/example/SnapWorkout/adapter/ExerciseStatusAdapter;", "exerciseList", "Ljava/util/ArrayList;", "Lcom/example/SnapWorkout/model/ExerciseModel;", "Lkotlin/collections/ArrayList;", "exerciseTimerDuration", "", "player", "Landroid/media/MediaPlayer;", "timerJob", "Lkotlinx/coroutines/Job;", "tts", "Landroid/speech/tts/TextToSpeech;", "customDialogForBackButton", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInit", "status", "setupExerciseStatusRecyclerView", "setupExerciseView", "setupRestView", "speakOut", "text", "", "startExerciseTimer", "startRestTimer", "app_debug"})
public final class ExerciseActivity extends androidx.appcompat.app.AppCompatActivity implements android.speech.tts.TextToSpeech.OnInitListener {
    private com.example.SnapWorkout.databinding.ActivityExerciseBinding binding;
    private java.util.ArrayList<com.example.SnapWorkout.model.ExerciseModel> exerciseList;
    private int currentExercisePosition = -1;
    private android.speech.tts.TextToSpeech tts;
    private android.media.MediaPlayer player;
    private com.example.SnapWorkout.adapter.ExerciseStatusAdapter exerciseAdapter;
    private long exerciseTimerDuration = 30L;
    private kotlinx.coroutines.Job timerJob;
    private final kotlinx.coroutines.CoroutineScope activityScope = null;
    
    public ExerciseActivity() {
        super();
    }
    
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupRestView() {
    }
    
    private final void startRestTimer() {
    }
    
    private final void setupExerciseView() {
    }
    
    private final void startExerciseTimer() {
    }
    
    @java.lang.Override
    protected void onDestroy() {
    }
    
    @java.lang.Override
    public void onInit(int status) {
    }
    
    private final void speakOut(java.lang.String text) {
    }
    
    private final void setupExerciseStatusRecyclerView() {
    }
    
    private final void customDialogForBackButton() {
    }
}