package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SplashPage extends BasePage {

    private final By textoSplash = (AppiumBy.xpath("//android.widget.TextView[@text='Splash!']"));

    public String splashEmTela(){
        return obterTexto(textoSplash);
    }

    public boolean aguardarsplashSumir(){
        esperarElementoSumir(textoSplash);
        return true;
    }
}
