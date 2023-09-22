/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, {useEffect} from 'react';
import {PermissionsAndroid, Platform, SafeAreaView, Text} from 'react-native';
import RTNVideoDownloader from 'rtn-video-downloader/js/NativeVideoDownloader';

const getPermission = async () => {
  if (Platform.OS === 'android') {
    await PermissionsAndroid.requestMultiple([
      PermissionsAndroid.PERMISSIONS.WRITE_EXTERNAL_STORAGE,
      PermissionsAndroid.PERMISSIONS.READ_EXTERNAL_STORAGE,
    ]);
  }
};
function App(): JSX.Element {
  useEffect(() => {
    getPermission();

    RTNVideoDownloader?.downloadVideo(
      'https://select-public-bucket.s3.amazonaws.com/text-chat/10022023-104120+018-sample-mp4-file.mp4',
      'thevideo.mp4',
    );

    RTNVideoDownloader?.add(1, 2).then(console.log);
  }, []);

  return (
    <SafeAreaView>
      <Text>123</Text>
    </SafeAreaView>
  );
}

export default App;
