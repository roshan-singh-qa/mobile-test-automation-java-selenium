package configurations;

import commons.DataMapper;
import configurations.sections.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Map;

public class Configs {
    private static Logger Log = LogManager.getLogger(Configs.class);
    static String configPath = System.getProperty("configPath");

    public static void loadEnvironmentConfiguration() throws IOException {
        AppDetails.androidAppName = getAttributeValueOf("app.android-app-name");
        AppDetails.iosAppName = getAttributeValueOf("app.ios-app-name");

        Timeout.page = getAttributeValueOf("timeout.page");
        Timeout.implicit = getAttributeValueOf("timeout.implicit");
        Timeout.explicit = getAttributeValueOf("timeout.explicit");
        Timeout.poolingInterval = getAttributeValueOf("timeout.poolingInterval");
        Timeout.avdLaunchTimeout = getAttributeValueOf("timeout.avdLaunchTimeout");
        Timeout.new_command_timeout = getAttributeValueOf("timeout.new_command_timeout");

        DriverDetails.verbose = getAttributeValueOf("driver-details.verbose");
        DriverDetails.platform = getAttributeValueOf("driver-details.platform");
        DriverDetails.protocol = getAttributeValueOf("driver-details.protocol");
        DriverDetails.domain = getAttributeValueOf("driver-details.domain");
        DriverDetails.port = getAttributeValueOf("driver-details.port");
        DriverDetails.serverUrl = getAttributeValueOf("driver-details.serverUrl");
        DriverDetails.listeners = getAttributeValueOf("driver-details.listeners");

        Map<String, String> androidCaps = getAttributeValueOf("capabilities.android");
        AndroidCapability.deviceName = androidCaps.get("deviceName");
        AndroidCapability.platformVersion = String.valueOf(androidCaps.get("platformVersion"));
        AndroidCapability.appPackage = androidCaps.get("appPackage");
        AndroidCapability.appActivity = androidCaps.get("appActivity");

        Map<String, String> iosCaps = getAttributeValueOf("capabilities.IOS");
        IosCapability.deviceName = iosCaps.get("deviceName");
        IosCapability.platformVersion = String.valueOf(iosCaps.get("platformVersion"));
        IosCapability.bundleId = iosCaps.get("bundleId");
        IosCapability.wdaLocalPort = iosCaps.get("wdaLocalPort");
        IosCapability.webkitDebugProxyPort = iosCaps.get("webkitDebugProxyPort");

        BrowserStack.username = getAttributeValueOf("browserStack.username");
        BrowserStack.accessKey = getAttributeValueOf("browserStack.accessKey");
        BrowserStack.appUrl = getAttributeValueOf("browserStack.appUrl");
        BrowserStack.serverUrl = getAttributeValueOf("browserStack.serverUrl");
        BrowserStack.deviceName = getAttributeValueOf("browserStack.device");
        BrowserStack.osVersion = getAttributeValueOf("browserStack.os-version");
        BrowserStack.build = getAttributeValueOf("browserStack.build");
        BrowserStack.project = getAttributeValueOf("browserStack.project");
        BrowserStack.sessionName = getAttributeValueOf("browserStack.sessionName");
        BrowserStack.deviceType = getAttributeValueOf("browserStack.deviceType");
    }

    @SuppressWarnings("unchecked")
    private static <T> T getAttributeValueOf(String value) throws IOException {
        String[] keyValuePair = value.split("\\.");
        return ((Map<T, T>) new DataMapper().getYamlFileAsMap(configPath).get(keyValuePair[0])).get(keyValuePair[1]);
    }
}