package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.MenuPage;
import page.SwipeListPage;
import static org.junit.jupiter.api.Assertions.*;

public class SwipeListTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    SwipeListPage swipeListPage = new SwipeListPage();

    @Test
    public void deveInteragirWithSwipeList(){
        menuPage.abrirSwipeList();
        swipeListPage.swipeOpcao1();
        swipeListPage.clicarEmMais();
        assertEquals("Opção 1 (+)", swipeListPage.resultOpcao1());
        swipeListPage.swipeOpcao4();
        swipeListPage.clicarEmMenos();
        assertEquals("Opção 4 (-)", swipeListPage.resultOpcao4());
        System.out.println(swipeListPage.resultOpcao5());
        assertEquals("Opção 5 (-)", swipeListPage.resultOpcao5());
        swipeListPage.swipeOpcao5();
        assertEquals("Opção 5", swipeListPage.resultOpcao5());
    }
}
