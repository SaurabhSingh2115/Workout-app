package com.example.SnapWorkout.receivers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002\u00a8\u0006\u000f"}, d2 = {"Lcom/example/SnapWorkout/receivers/NetworkBroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "()V", "isNetworkAvailable", "", "context", "Landroid/content/Context;", "onReceive", "", "intent", "Landroid/content/Intent;", "showNotification", "title", "", "message", "app_debug"})
public final class NetworkBroadcastReceiver extends android.content.BroadcastReceiver {
    
    public NetworkBroadcastReceiver() {
        super();
    }
    
    @java.lang.Override
    public void onReceive(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    android.content.Intent intent) {
    }
    
    private final boolean isNetworkAvailable(android.content.Context context) {
        return false;
    }
    
    private final void showNotification(android.content.Context context, java.lang.String title, java.lang.String message) {
    }
}