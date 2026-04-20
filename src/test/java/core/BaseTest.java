package core;

import io.qameta.allure.Attachment;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page.MenuPage;
import page.SBNLoginPage;
import utils.ScreenshotWatcher;
import java.io.File;
import java.io.IOException;
import static core.DriverFactory.getDriver;

@ExtendWith(ScreenshotWatcher.class)
public class BaseTest {

    public void realizarLogin() {
        MenuPage menuPage = new MenuPage();
        SBNLoginPage sbnLoginPage = new SBNLoginPage();
        menuPage.abrirNativo();
        sbnLoginPage.deveDigitarNome();
        sbnLoginPage.deveDigitarSenha();
        sbnLoginPage.clicarEntrar();
    }

    @Attachment(value = "Screenshot da falha", type = "image/png")
    public byte[] tirarScreenshot() {
        try {
            return ((TakesScreenshot) getDriver())
                    .getScreenshotAs(OutputType.BYTES);
        } catch (Exception e) {
            return new byte[0];
        }
    }

    public void gerarScreenshot(String nome){
        try {
            File file = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            File destino = new File("target/screenshots/" + nome + ".png");
            FileUtils.forceMkdirParent(destino);
            FileUtils.copyFile(file, destino);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        ScreenshotWatcher.salvarScreenshot();
        String nomeClasse = testInfo.getTestClass().get().getSimpleName();
        String nomeMetodo = testInfo.getTestMethod().get().getName();
        gerarScreenshot(nomeClasse + "_" + nomeMetodo);
        DriverFactory.fecharApp();
        DriverFactory.quitDriver();
    }
}
