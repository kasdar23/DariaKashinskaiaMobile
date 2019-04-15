# DariaKashinskaiaMobile
запуск моих тестов через:  
DariaKashinskaiaMobile/src/test/java/resources/testNgNativeApp.xml 
DariaKashinskaiaMobile/src/test/java/resources/testNgWebApp.xml

Answers:
1.	Change settings to run web test on a certain iOS device in mobile cloud. Run test with your changes. Did test pass?
Yes, it passed.

2.	Change settings to run native test on a certain/random Android device in mobile cloud. 
Add support of appPackage and appActivity parameters for Android devices (reading from a .properties file and then setting in the DesiredCapabilities). Locally installed Appium DT has no need in these parameters, but for Appium server of EPAM mobile cloud it’s mandatory.

mCurrentFocus=Window{b25d8cb u0 com.example.android.contactmanager/com.example.android.contactmanager.ContactManager}

appPackage = com.example.android.contactmanager

appActivity = com.example.android.contactmanager.ContactManager

3.	 Run test with your changes. Did test pass? 
Yes, it passed

4.	Try to use autoLaunch capability with app as before instead of appPackage and appActivity. Does this approach work?

No, it doesn’t work. 
org.openqa.selenium.SessionNotCreatedException: Unable to create a new remote session. Please check the server log for more details. Original error: {"status":13,"value":{"message":"An unknown server-side error occurred while processing the command. Original error: The desired capabilities must include either an app, appPackage or browserName"},"sessionId":null} (WARNING: The server did not provide any stacktrace information)

5.	What’s wrong with our code? How to fix/improve it? Implement your suggestions.

Setting autoLaunch to false means that application install will not be performed. But the app is still executed if it is already installed on the device. I retuned appPackage and appActivity and chose autoLaunch as true.
