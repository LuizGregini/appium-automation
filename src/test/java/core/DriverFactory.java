package core;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import java.net.MalformedURLException;
import java.net.URL;

    public class DriverFactory {

            private static AndroidDriver driver;
            private static final String APP_PACKAGE = "com.ctappium";

            public static AndroidDriver getDriver() {
                if (driver == null) {
                    try {
                        URL remoteURL = new URL("http://127.0.0.1:4723");
                        UiAutomator2Options options = new UiAutomator2Options()
                                .setPlatformName("Android")
                                .setAutomationName("UiAutomator2")
                                .setDeviceName("emulator-5554")
                                .setUdid("emulator-5554")
                                //.setApp("C:/Users/gus_t/Estudo/Curso_Java_Nelio_Udemy/PrimeiroPrograma/CursoAppium/src/test/java/apks/CTAppium_2_0.apk")
                                .setApp("C:/Users/gus_t/Estudo/Curso_Java_Nelio_Udemy/PrimeiroPrograma/CursoAppium/src/test/java/apks/CTAppium_1_2.apk")
                                .setAutoGrantPermissions(true)
                                .amend("appium:disableWindowAnimation", true)
                                .amend("appium:forceAppLaunch", true)
                                .amend("appium:fullReset", false)
                                .amend("appium:noReset", false)
                                .amend("appium:chromedriverExecutable","C:/Users/gus_t/Estudo/Curso_Java_Nelio_Udemy/PrimeiroPrograma/CursoAppium/src/test/java/drivers/chromedriver.exe")
                                .amend("appium:newCommandTimeout", 300);
                        driver = new AndroidDriver(remoteURL, options);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException(
                                "Erro ao criar URL do Appium. Verifique o endpoint.",
                                e
                        );
                    }
                }
                return driver;
            }

            public static void quitDriver() {
                if (driver != null) {
                    driver.quit();
                    driver = null;
                }
            }

        public static void fecharApp() {
            if (driver != null) {
                driver.terminateApp(APP_PACKAGE);
            }
        }
    }
