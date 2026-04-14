package core;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import page.MenuPage;
import page.SBNLoginPage;
import java.io.File;
import java.io.IOException;

public class BaseTest {

    public void realizarLogin() {
        MenuPage menuPage = new MenuPage();
        SBNLoginPage sbnLoginPage = new SBNLoginPage();
        menuPage.abrirNativo();
        sbnLoginPage.deveDigitarNome();
        sbnLoginPage.deveDigitarSenha();
        sbnLoginPage.clicarEntrar();
    }

    public void gerarScreenshot(String nome){
        try {
            File file = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
            File destino = new File("target/screenshots/" + nome + ".png");
            FileUtils.forceMkdirParent(destino);
            FileUtils.copyFile(file, destino);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        String nomeClasse = testInfo.getTestClass().get().getSimpleName();
        String nomeMetodo = testInfo.getTestMethod().get().getName();
        gerarScreenshot(nomeClasse + "_" + nomeMetodo);
        DriverFactory.fecharApp();
        DriverFactory.quitDriver();
    }
}
