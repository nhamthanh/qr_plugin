#import "QrPlugin.h"
#import <qr_plugin/qr_plugin-Swift.h>

@implementation QrPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftQrPlugin registerWithRegistrar:registrar];
}
@end
