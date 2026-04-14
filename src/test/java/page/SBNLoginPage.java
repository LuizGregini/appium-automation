package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SBNLoginPage extends BasePage {

    private final By campoNome = (AppiumBy.xpath("//android.widget.EditText[@text='Nome']"));
    private final By campoSenha = (AppiumBy.xpath("//android.widget.EditText[@text='Senha']"));
    private final By campoEntrar = (AppiumBy.xpath("//android.widget.Button"));
    private final By campoReset = (AppiumBy.xpath("//android.widget.TextView[@text='RESET']"));
    private final By mensagemLoginInvalido = (AppiumBy.xpath("//android.widget.TextView[@text='Usuário ou senha inválido']"));

    public void deveDigitarNome(){
        escrever(campoNome, "nikinha@teste.com");
    }

    public void deveDigitarSenha(){
        escrever(campoSenha, "neymar123");
    }

    public void deveDigitarSenhaIncorreta(){
        escrever(campoSenha, "chavinho123");
    }

    public void clicarEntrar(){
        clicar(campoEntrar);
    }

    public boolean deveVerificarCampoReset(){
        return isElementoVisivel(campoReset);
    }

    public String deveRetornaMensagemLoginInvalido(){
        return obterTexto(mensagemLoginInvalido);
    }
}
