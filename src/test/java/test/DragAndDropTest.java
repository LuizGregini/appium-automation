package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.DragAndDropPage;
import page.MenuPage;
import static org.junit.jupiter.api.Assertions.*;

public class DragAndDropTest extends BaseTest {

    private String[] estadoInicial = new String[]{"Esta", "é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "qualquer local desejado."};
    private String[] estadoIntermediario = new String[]{"é uma lista", "Drag em Drop!", "Faça um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
    private String[] estadoFinal = new String[]{"Faça um clique longo,", "é uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

    MenuPage menuPage = new MenuPage();
    DragAndDropPage dragAndDropPage = new DragAndDropPage();

    @Test
    public void deveInteragirComDragAndDrop(){
        menuPage.abrirDragAndDrop();
        dragAndDropPage.percorreElementos();
        assertArrayEquals(estadoInicial, dragAndDropPage.percorreElementos().toArray(new String[0]));
        dragAndDropPage.actionDragEstaParaArraste();
        dragAndDropPage.percorreElementos();
        assertArrayEquals(estadoIntermediario, dragAndDropPage.percorreElementos().toArray(new String[0]));
        dragAndDropPage.actionDragFacaLista();
        dragAndDropPage.percorreElementos();
        assertArrayEquals(estadoFinal, dragAndDropPage.percorreElementos().toArray(new String[0]));
    }
}
