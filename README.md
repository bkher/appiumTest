# Android and iOS AutomationFramework
One solution for Android and iOS automation



Tools & libraries
==================================================================================

The test automation framework is comprised of following tools and libraries  

- Appium [9.2.3]: - Mobile app automation
- JAVA  [1.8]: - Programming language  
- TestNg [7.10.2]: - TestNg Java testing framework  
- Maven [3.0.0-M5]: - Build tool       
- Git: - Version Control  
- Eclipse: - Integrated Development Environment  
- Loggers [1.7.13]: - Log4J
- Reporting tool [2.41.2]:- Extent Manger
- Jenkins : CI tool


Framework Setup steps
==================================================================================


Now open terminal  and  navigate to downloaded  folder and  execute command “mvn clean install” This will add your local archetype into the local maven repository. You can see the build log for a message that mentions about this addition.


Run automation on Mobile
==================================================================================


Pre-requiste:
Android Automation setup : http://appium.io/docs/en/drivers/android-uiautomator2/
iOS Automation setup: http://appium.io/docs/en/drivers/ios-xcuitest-real-devices/  

Execute below command

mvn test
-Dplatform=android [android/iOS]
-Dgroups=mobile [mobile/web/api]
-Dtarget=androidDevice [avd,androidDevice,simulator,iPhone ]
-DtestDataType=mock [mock, real] - Optional


| Parameter        | Required/Optional |Comments  |
| ------------- |:-------------:| -----:|
| platform | Required | android/iOS|
| target | Required | avd/androidDevice/simulator/iPhone|
| groups | Required  | testng group name e.g mobile,android,ios  |
| runMode | Optional | saucelab [if not passed default value is "local"] |
| sauceUsername | Required incase runMode is saucelab | sauce lab username|
| sauceAccessKey   | Required incase runMode is saucelab  | sauce lab access key |
| testDataJson | Optional| path to your testdata json file |
| appPath | Required | app/ipa path from local|
| deviceName | - Required incase runMode is saucelab, - Required for iOS run/ Optional for android| avd/androidDevice/simulator/iPhone|
| sauceStorageId | - Required incase runMode is saucelab, - Required any of suaceStorageId or appName|storage id of app/ipa uploaded on sauce lab|
| platform | Required | android/iOS|
| appName |  - Required incase runMode is saucelab, - Required any of suaceStorageId or appName|app/ipa name uploaded on sauce lab|




---------------------------------------------------------------------------------
Run Your testcases on your own testdata by using test data json file
-----------------------------------------------------------------------------

Just include below parameters in your run command and your testcase will be executed with your testdata

-DtestDataJson="path to your testdata json file"






