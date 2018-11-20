package com.mrameezraja.plugins;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

public class CDVRMRinger extends CordovaPlugin {
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("getStatus")) {
            this.getRingerMode(callbackContext);
            return true;
        } else  if (action.equals("vibrate")){
            Vibrator v = (Vibrator) cordova.getActivity().getSystemService(Context.VIBRATOR_SERVICE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                v.vibrate(VibrationEffect.createOneShot(500, VibrationEffect.DEFAULT_AMPLITUDE));
            } else {
                //deprecated in API 26
                v.vibrate(500);
            }
        }
        return false;
    }

    private void getRingerMode(CallbackContext callbackContext) {
        Context context = cordova.getActivity().getApplicationContext();
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);

        switch (audioManager.getRingerMode()) {
            case AudioManager.RINGER_MODE_SILENT:
                callbackContext.success(1);
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                callbackContext.success(1);
                break;
            case AudioManager.RINGER_MODE_NORMAL:
                callbackContext.success(0);
                break;
        }
    }
}
