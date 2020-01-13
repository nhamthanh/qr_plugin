package com.thanh.qr_plugin

import android.app.Activity;
import android.app.Dialog;
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class QrPlugin: MethodCallHandler {
  /** Plugin registration. */
  Activity context;
  MethodChannel methodChannel;

  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "qr_plugin")
      channel.setMethodCallHandler(QrPlugin())
    }
  }

  public QrPlugin(Activity activity, MethodChannel methodChannel) {
    this.context = activity;
    this.methodChannel = methodChannel;
    this.methodChannel.setMethodCallHandler(this);
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else if(call.method.equalsIgnoreCase("showAlertDialog")) {
      Dialog dialog=new Dialog(context);
      dialog.setTitle("Hi, My Name is Flutter");
      dialog.show();
    } else {
      result.notImplemented();
    }
  }
}
