package com.zhichengstudio.godotplugins.flurry;

import android.app.Activity;
import android.util.Log;

import com.flurry.android.Constants;
import com.flurry.android.FlurryAgent;
import com.flurry.android.FlurryPerformance;

import org.godotengine.godot.Godot;
import org.godotengine.godot.plugin.GodotPlugin;
import org.godotengine.godot.plugin.UsedByGodot;

import java.util.Map;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;

/**
 * Created by IntelliJ IDEA
 * Author: vhly
 * Email: vhly@163.com
 * Date:  2021/7/18
 */
@Keep
public class FlurryPlugin extends GodotPlugin {

    public FlurryPlugin(Godot godot) {
        super(godot);
    }

    @NonNull
    @Override
    public String getPluginName() {
        return "Flurry";
    }

    /**
     * Init Flurry sdk with app key and channel, and set debug or not.
     *
     * @param appKey
     * @param channel
     * @param isDebug
     */
    @UsedByGodot
    public void initSDK(String appKey, String channel, boolean isDebug) {
        Activity activity = getActivity();
        if (activity != null) {
            new FlurryAgent.Builder()
                    .withDataSaleOptOut(false) //CCPA - the default value is false
                    .withCaptureUncaughtExceptions(true)
                    .withIncludeBackgroundSessionsInMetrics(true)
                    .withLogLevel(Log.VERBOSE)
                    .withLogEnabled(isDebug)
                    .withPerformanceMetrics(FlurryPerformance.ALL)
                    .build(activity, appKey);
        }
    }

    @UsedByGodot
    public void setUserId(String userId) {
        FlurryAgent.setUserId(userId);
    }

    @UsedByGodot
    public void setAge(int age) {
        FlurryAgent.setAge(age);
    }

    @UsedByGodot
    public void setGender(int gender) {
        byte genderValue = Constants.UNKNOWN;
        switch (gender) {
            case Constants.FEMALE:
                genderValue = Constants.FEMALE;
                break;
            case Constants.MALE:
                genderValue = Constants.MALE;
                break;
        }
        FlurryAgent.setGender(genderValue);
    }

    /**
     * 发送日志ID
     *
     * @param eventId String
     */
    @UsedByGodot
    public void logEvent(String eventId) {
        FlurryAgent.logEvent(eventId);
    }

    /**
     * 发送日志ID
     *
     * @param eventId String
     * @param isTimed boolean isTime event
     */
    @UsedByGodot
    public void logEvent(String eventId, boolean isTimed) {
        FlurryAgent.logEvent(eventId, isTimed);
    }

    /**
     * 发送日志，并且配置参数
     *
     * @param eventId String
     * @param params  Map&lt;String,String&gt;
     */
    @UsedByGodot
    public void logEvent(String eventId, Map<String, String> params) {
        FlurryAgent.logEvent(eventId, params);
    }

    /**
     * 记录支付日志
     *
     * @param productName   String
     * @param productId     String
     * @param quantity      int
     * @param price         double
     * @param currency      String
     * @param transactionId String
     * @param params        Map&lt;String,String&gt;
     */
    @UsedByGodot
    public void logPayment(String productName,
                           String productId,
                           int quantity,
                           double price,
                           String currency,
                           String transactionId,
                           Map<String, String> params) {
        FlurryAgent.logPayment(productName, productId, quantity, price, currency, transactionId, params);
    }

    @UsedByGodot
    public void logError(String errorId,
                         String message,
                         String errorClass) {
        FlurryAgent.onError(errorId, message, errorClass);
    }
}