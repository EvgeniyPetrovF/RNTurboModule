package com.rtnvideodownloader;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.io.File;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.HashMap;
import com.rtnvideodownloader.NativeVideoDownloaderSpec;

public class VideoDownloaderModule extends NativeVideoDownloaderSpec {
    private ReactApplicationContext reactContext;
    public static String NAME = "RTNVideoDownloader";

    VideoDownloaderModule(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override
    public void add(double a, double b, Promise promise) {

        promise.resolve(a + b);
    }

    // public void downloadVideo(String urlToDownload, String videoSaveName) {
    //   try {
    //     URL u = new URL(urlToDownload);
    //     URLConnection conn = u.openConnection();
    //     int contentLength = conn.getContentLength();

    //     DataInputStream stream = new DataInputStream(u.openStream());
    //     byte[] buffer = new byte[contentLength];
    //     stream.readFully(buffer);
    //     stream.close();
    //     File root = Environment.getExternalStorageDirectory();
    //     File fileDirectory = reactContext.getFilesDir();
    //     File yourFile = new File(root.getAbsolutePath()+"/Movies/", videoSaveName);
        
    //     yourFile.createNewFile();
    //     FileOutputStream oFile = new FileOutputStream(yourFile, false);
    //     DataOutputStream fos = new DataOutputStream(oFile);
    //     fos.write(buffer);
    //     fos.flush();
    //     fos.close();
        
    //     ContentValues valuesvideos = new ContentValues();
    //     valuesvideos.put(MediaStore.Video.Media.RELATIVE_PATH, "Movies/");
    //     valuesvideos.put(MediaStore.Video.Media.TITLE, videoSaveName);
    //     valuesvideos.put(MediaStore.Video.Media.DISPLAY_NAME, videoSaveName);
    //     valuesvideos.put(MediaStore.Video.Media.MIME_TYPE, "video/mp4");
    //     valuesvideos.put(
    //         MediaStore.Video.Media.DATE_ADDED, 
    //         System.currentTimeMillis() / 1000);
    //     valuesvideos.put(MediaStore.Video.Media.DATE_TAKEN, System.currentTimeMillis());
    //     valuesvideos.put(MediaStore.Video.Media.IS_PENDING, 1);

    //     ContentResolver resolver = reactContext.getContentResolver();
    //     Uri collection = 
    //         MediaStore.Video.Media.getContentUri(MediaStore.VOLUME_EXTERNAL_PRIMARY);
    //     Uri uriSavedVideo = resolver.insert(collection, valuesvideos);

    //     valuesvideos.clear();
    //     valuesvideos.put(MediaStore.Video.Media.IS_PENDING, 0);
    //     reactContext.getContentResolver().update(uriSavedVideo, valuesvideos, null, null);
    //     } catch(FileNotFoundException e) {
    //       Log.i("Tag", "filenotfound");
    //       return; 
    //     } catch (IOException e) {
    //       Log.i("Tag", "IOexception");
    //       e.printStackTrace();
    //       return; 
    //     }
    //   }

    @ReactMethod
    public void downloadVideo(String videoUrl, String newVideoName) {
      DownloadManager manager = (DownloadManager) getReactApplicationContext().getSystemService(Context.DOWNLOAD_SERVICE);
      Uri uri = Uri.parse(videoUrl);

      DownloadManager.Request request = new DownloadManager.Request(uri);
      request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
              .setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES,
                      File.separator + "videos" + File.separator + newVideoName);
      long reference = manager.enqueue(request);
    }
}