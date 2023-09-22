/**
 * This code was generated by [react-native-codegen](https://www.npmjs.com/package/react-native-codegen).
 *
 * Do not edit this file as changes may cause incorrect behavior and will be lost
 * once the code is regenerated.
 *
 * @generated by codegen project: GenerateModuleH.js
 */

#include "RTNVideoDownloaderSpecJSI.h"

namespace facebook {
namespace react {

static jsi::Value __hostFunction_NativeVideoDownloaderCxxSpecJSI_add(jsi::Runtime &rt, TurboModule &turboModule, const jsi::Value* args, size_t count) {
  return static_cast<NativeVideoDownloaderCxxSpecJSI *>(&turboModule)->add(rt, args[0].asNumber(), args[1].asNumber());
}
static jsi::Value __hostFunction_NativeVideoDownloaderCxxSpecJSI_downloadVideo(jsi::Runtime &rt, TurboModule &turboModule, const jsi::Value* args, size_t count) {
  static_cast<NativeVideoDownloaderCxxSpecJSI *>(&turboModule)->downloadVideo(rt, args[0].asString(rt), args[1].asString(rt));
  return jsi::Value::undefined();
}

NativeVideoDownloaderCxxSpecJSI::NativeVideoDownloaderCxxSpecJSI(std::shared_ptr<CallInvoker> jsInvoker)
  : TurboModule("RTNVideoDownloader", jsInvoker) {
  methodMap_["add"] = MethodMetadata {2, __hostFunction_NativeVideoDownloaderCxxSpecJSI_add};
  methodMap_["downloadVideo"] = MethodMetadata {2, __hostFunction_NativeVideoDownloaderCxxSpecJSI_downloadVideo};
}


} // namespace react
} // namespace facebook