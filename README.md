1) yarn add ../RTNVideoDownloader2
2) node MyApp/node_modules/react-native/scripts/generate-codegen-artifacts.js \
  --path MyApp/ \
  --outputPath RTNVideoDownloader2/generated/	
3) RCT_NEW_ARCH_ENABLED=1 bundle exec pod install
4) yarn ios
