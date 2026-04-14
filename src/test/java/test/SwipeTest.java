package test;

import core.BaseTest;
import org.junit.jupiter.api.Test;
import page.MenuPage;
import page.SwipePage;
import static org.junit.jupiter.api.Assertions.*;

public class SwipeTest extends BaseTest {

    MenuPage menuPage = new MenuPage();
    SwipePage swipePage= new SwipePage();

    @Test
    public void deveInteragirWithSwipe(){
        menuPage.abrirSwipe();
        assertEquals("a esquerda", swipePage.resultTextoEsquerda());
        swipePage.realizaSwipeUmaUnicaVez();
        assertEquals("E veja se", swipePage.resultTextoMeio());
        swipePage.realizaSwipeUmaUnicaVez();
        assertEquals("Chegar até o fim!", swipePage.resultTextoMFim());
        swipePage.swipeAteFinal();
    }
}
