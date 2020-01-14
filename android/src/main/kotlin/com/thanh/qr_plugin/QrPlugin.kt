package com.thanh.qr_plugin

import android.app.Activity
import android.app.Dialog
//import android.support.v7.app.AlertDialog;
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class QrPlugin(activity: Activity, methodChannel: MethodChannel): MethodCallHandler {
  /** Plugin registration. */
    var context: Activity
    var methodChannel: MethodChannel

  companion object {
    @JvmStatic
    fun registerWith(registrar: Registrar) {
      val channel = MethodChannel(registrar.messenger(), "qr_plugin");
      channel.setMethodCallHandler(QrPlugin(registrar.activity(), channel));
    }
  }

  override fun onMethodCall(call: MethodCall, result: Result) {
    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else if (call.method == "showAlertDialog") {
        val dialog = Dialog(context)
        dialog.setTitle("Hi, My Name is Flutter")
        dialog.show()
    } else {
      result.notImplemented();
    }
  }

    init {
        context = activity
        this.methodChannel = methodChannel
        this.methodChannel.setMethodCallHandler(this)
    }
}
