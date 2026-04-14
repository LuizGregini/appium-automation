package page;

import core.BasePage;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

import java.util.List;

public class DragAndDropPage extends BasePage {

    private final By textoEsta = (AppiumBy.xpath("//android.widget.TextView[@text='Esta']"));
    private final By textoArrastePara = (AppiumBy.xpath("//android.widget.TextView[@text='e arraste para']"));
    private final By textoFacaCliqueLongo = (AppiumBy.xpath("//android.widget.TextView[@text='Faça um clique longo,']"));
    private final By textoEUmaLista = (AppiumBy.xpath("//android.widget.TextView[@text='é uma lista']"));

    public void actionDragEstaParaArraste(){
        dragAndDrop(textoEsta, textoArrastePara, 200);
    }

    public void actionDragFacaLista(){
        dragAndDrop(textoFacaCliqueLongo, textoEUmaLista, -200);
    }

    public List<String> percorreElementos(){
        esperarElementoVisivel(textoEsta);
        return percorreListaElement();
    }
}
