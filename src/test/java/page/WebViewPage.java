package page;

import core.BasePage;
import org.openqa.selenium.By;
import static core.DriverFactory.getDriver;

public class WebViewPage extends BasePage {

    private final By campoEmail = (By.id("email"));
    private final By campoSenha = (By.id("senha"));
    private final By campoEntrar = (By.xpath("//*[text()='Entrar']"));
    private final By resultLoginWithSucess = (By.xpath("//div[@class='alert alert-success']"));

    public void deveDigitarEmail(){
        escrever(campoEmail, "YouHaveCreatedANewUserForAccess");
    }

    public void deveDigitarPassword(){
        escrever(campoSenha, "YouHaveCreatedANewPasswordForAccess");
    }

    public void deveClicarEmEntrar(){
        clicar(campoEntrar);
    }

    public void deveChamarWebView(){
        switchToWebView();
    }

    public String verificaLoginSucess(){
        return getDriver().findElement(resultLoginWithSucess).getText();
    }
}
