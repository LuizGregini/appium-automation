package utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import static core.DriverFactory.getDriver;

public class ScreenshotWatcher implements TestWatcher {

    private static final ThreadLocal<byte[]> screenshotBytes = new ThreadLocal<>();

    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        anexarScreenshot(context);
    }

    @Override
    public void testSuccessful(ExtensionContext context) {
        anexarScreenshot(context);
    }

    private void anexarScreenshot(ExtensionContext context) {
        byte[] screenshot = screenshotBytes.get();
        if (screenshot == null) {
            try {
                screenshot = ((TakesScreenshot) getDriver())
                        .getScreenshotAs(OutputType.BYTES);
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        screenshotBytes.remove();
        Allure.getLifecycle().addAttachment(
                "Screenshot - " + context.getDisplayName(),
                "image/png",
                "png",
                screenshot
        );
    }

    public static void salvarScreenshot() {
        try {
            screenshotBytes.set(((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}