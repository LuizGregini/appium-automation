package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class CliquesPage extends BasePage {

    private final By campoCliqueLongo = (AppiumBy.xpath("//android.widget.TextView[@text='Clique Longo']"));
    private final By resultCampoCliqueLongo = (AppiumBy.xpath("(//android.widget.TextView[@text='Clique Longo'])[2]"));

    public void cliqueLongo(){
            longPress(campoCliqueLongo, 2000);
    }

    public String resultCliqueLongo(){
        return obterTexto(resultCampoCliqueLongo);
    }
}
