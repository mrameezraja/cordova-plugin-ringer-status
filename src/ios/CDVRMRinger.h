

#import <Cordova/CDVPlugin.h>
#import "SharkfoodMuteSwitchDetector.h"

@interface CDVRMRinger : CDVPlugin
{
    SharkfoodMuteSwitchDetector* detector;
}

@property (nonatomic, retain) SharkfoodMuteSwitchDetector* detector;

- (void) getStatus:(CDVInvokedUrlCommand*)command;
- (void) vibrate:(CDVInvokedUrlCommand*)command;

@end

