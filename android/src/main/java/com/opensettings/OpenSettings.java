package com.opensettings;

import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class OpenSettings extends ReactContextBaseJavaModule {

    private ReactContext reactContext;

    public OpenSettings(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "RNOpenSettings";
    }

    //region React Native Methods
    @ReactMethod
    public void openSettings() {
        Intent openSettingsIntent = new Intent(Settings.ACTION_SETTINGS);
        openSettingsIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        openSettingsIntent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        openSettingsIntent.addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS);       
        reactContext.startActivity(openSettingsIntent);
    }
    //endregion
}
