package com.transistorsoft.flutter.backgroundgeolocation;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.FlutterNativeView;

import com.google.android.gms.common.GoogleApiAvailability;
import com.transistorsoft.flutter.backgroundgeolocation.streams.ActivityChangeStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.ConnectivityChangeStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.EnabledChangeStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.GeofenceStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.GeofencesChangeStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.HeartbeatStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.HttpStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.LocationStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.MotionChangeStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.NotificationActionStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.PowerSaveChangeStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.ProviderChangeStreamHandler;
import com.transistorsoft.flutter.backgroundgeolocation.streams.ScheduleStreamHandler;
import com.transistorsoft.locationmanager.adapter.BackgroundGeolocation;
import com.transistorsoft.locationmanager.adapter.TSConfig;
import com.transistorsoft.locationmanager.adapter.callback.*;
import com.transistorsoft.locationmanager.data.LocationModel;
import com.transistorsoft.locationmanager.data.SQLQuery;
import com.transistorsoft.locationmanager.device.DeviceSettingsRequest;
import com.transistorsoft.locationmanager.event.TerminateEvent;
import com.transistorsoft.locationmanager.geofence.TSGeofence;
import com.transistorsoft.locationmanager.location.TSCurrentPositionRequest;
import com.transistorsoft.locationmanager.location.TSLocation;
import com.transistorsoft.locationmanager.location.TSWatchPositionRequest;
import com.transistorsoft.locationmanager.logger.TSLog;
import com.transistorsoft.locationmanager.scheduler.TSScheduleManager;
import com.transistorsoft.locationmanager.util.Sensors;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * FlutterBackgroundGeolocationPlugin
 */
public class FLTBackgroundGeolocationPlugin {
    public static final String PLUGIN_ID                  = "com.transistorsoft/flutter_background_geolocation";
    private static final String METHOD_CHANNEL_NAME         = PLUGIN_ID + "/methods";

    private static final String ACTION_RESET             = "reset";
    private static final String ACTION_READY             = "ready";

    private static final String ACTION_REGISTER_HEADLESS_TASK = "registerHeadlessTask";
    private static final String ACTION_GET_STATE         = "getState";
    private static final String ACTION_START_SCHEDULE    = "startSchedule";
    private static final String ACTION_STOP_SCHEDULE     = "stopSchedule";
    private static final String ACTION_LOG               = "log";
    private static final String ACTION_REQUEST_SETTINGS  = "requestSettings";
    private static final String ACTION_SHOW_SETTINGS     = "showSettings";
    private static final String ACTION_REGISTER_PLUGIN   = "registerPlugin";

    private static final String JOB_SERVICE_CLASS         = "com.transistorsoft.flutter.backgroundgeolocation.HeadlessTask";

    private boolean mIsInitialized;
    private boolean mReady;
    private Intent mLaunchIntent;
    private Context mContext;
    private PluginRegistry.Registrar mRegistrar;

    /** Plugin registration. */
    public static void registerWith(Registrar registrar) {
    }

    private FLTBackgroundGeolocationPlugin(final PluginRegistry.Registrar registrar) {

    }
}
