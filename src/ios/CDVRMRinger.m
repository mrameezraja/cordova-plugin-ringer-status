
#import "CDVRMRinger.h"
#import <AudioToolbox/AudioToolbox.h>

@implementation CDVRMRinger

@synthesize detector;

- (void)pluginInitialize
{
    self.detector = [SharkfoodMuteSwitchDetector shared];
    __weak CDVRMRinger *self_ = self;
    self.detector.silentNotify = ^(BOOL silent){
        NSString *js = [NSString stringWithFormat:@"cordova.fireWindowEvent('didRingerChanged', %d);", silent];
        [self_.commandDelegate evalJs: js];
    };
}

- (void) getStatus:(CDVInvokedUrlCommand *)command
{
    [self.commandDelegate runInBackground:^(){
        CDVPluginResult* pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsBool:self.detector.isMute];
        [self.commandDelegate sendPluginResult:pluginResult callbackId: command.callbackId];
    }];
}

- (void) vibrate:(CDVInvokedUrlCommand *)command
{
    [self.commandDelegate runInBackground:^(){
        AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
    }];
}
@end
