// Generated by view binder compiler. Do not edit!
package com.example.SnapWorkout.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.SnapWorkout.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityFinishBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button btnFinish;

  @NonNull
  public final Toolbar toolbarFinishActivity;

  @NonNull
  public final TextView tvEnd;

  private ActivityFinishBinding(@NonNull LinearLayout rootView, @NonNull Button btnFinish,
      @NonNull Toolbar toolbarFinishActivity, @NonNull TextView tvEnd) {
    this.rootView = rootView;
    this.btnFinish = btnFinish;
    this.toolbarFinishActivity = toolbarFinishActivity;
    this.tvEnd = tvEnd;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityFinishBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityFinishBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_finish, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityFinishBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnFinish;
      Button btnFinish = ViewBindings.findChildViewById(rootView, id);
      if (btnFinish == null) {
        break missingId;
      }

      id = R.id.toolbar_finish_activity;
      Toolbar toolbarFinishActivity = ViewBindings.findChildViewById(rootView, id);
      if (toolbarFinishActivity == null) {
        break missingId;
      }

      id = R.id.tvEnd;
      TextView tvEnd = ViewBindings.findChildViewById(rootView, id);
      if (tvEnd == null) {
        break missingId;
      }

      return new ActivityFinishBinding((LinearLayout) rootView, btnFinish, toolbarFinishActivity,
          tvEnd);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
