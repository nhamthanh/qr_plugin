import 'dart:async';

import 'package:flutter/services.dart';

class QrPlugin {
  static const MethodChannel _channel =
      const MethodChannel('qr_plugin');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static  get showAleartDialog async {
    await _channel.invokeMethod('showAlertDialog');
  }
}
