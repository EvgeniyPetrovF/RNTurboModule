#import "RTNVideoDownloaderSpec.h"
#import "RTNVideoDownloader.h"
#import <AssetsLibrary/AssetsLibrary.h>

@implementation RTNVideoDownloader

RCT_EXPORT_MODULE()

-(void)downloadVideo:(NSString *)urlToDownload videoSaveName:(NSString *)videoSaveName
{
dispatch_async(dispatch_get_global_queue(DISPATCH_QUEUE_PRIORITY_DEFAULT, 0), ^{
    NSLog(@"Downloading Started");
    NSLog(@"Current user’s home directory is %@", NSHomeDirectory());

    NSURL  *url = [NSURL URLWithString:urlToDownload];
    NSData *urlData = [NSData dataWithContentsOfURL:url];
    
    if (urlData)
        {
        NSArray *paths = NSSearchPathForDirectoriesInDomains(NSDocumentDirectory, NSUserDomainMask, YES);
        NSString  *documentsDirectory = [paths objectAtIndex:0];

        NSString  *filePath = [NSString stringWithFormat:@"%@/%@", documentsDirectory,videoSaveName];
        dispatch_async(dispatch_get_main_queue(), ^{
            [urlData writeToFile:filePath atomically:YES];
            NSLog(@"File Saved !");
        });

        NSURL *fileUrl = [NSURL URLWithString:filePath];
        ALAssetsLibrary *assetsLibrary = [[ALAssetsLibrary alloc] init];
        [assetsLibrary writeVideoAtPathToSavedPhotosAlbum:fileUrl completionBlock:^(NSURL *assetURL, NSError *error) {
            if (error == nil) {
                NSLog(@"Save video succeed.:%@",assetURL);
            } else {
                NSLog(@"Save video fail:%@",error);
            }
        }];
        }
    });
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:
    (const facebook::react::ObjCTurboModule::InitParams &)params
{
    return std::make_shared<facebook::react::NativeVideoDownloaderSpecJSI>(params);
}

@end