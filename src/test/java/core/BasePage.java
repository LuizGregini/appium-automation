package core;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.openqa.selenium.interactions.Sequence;
import java.util.Collections;
import java.util.stream.Collectors;
import static core.DriverFactory.getDriver;

public class BasePage {

    boolean podeFazerSwipe;

    public void clicar(By locator){
        WebElement el = esperarElementoClicavel(locator);
        try {
            el.click();
        } catch (Exception e){
            throw new IllegalStateException(
                    "Não foi possível clicar no elemento: " + locator, e
            );
        }
    }

    public void escrever(By locator, String texto){
        WebElement el = esperarElementoVisivel(locator);
        if(!el.isEnabled()){
            throw new IllegalStateException("Elemento " + locator + " não está habilitado para digitação");
        }
        el.clear();
        el.sendKeys(texto);
    }

    public String obterTexto(By locator){
        return esperarElementoVisivel(locator).getAttribute("text");
    }

    public String clicarPorTexto(String texto) {
        By locator = AppiumBy.xpath(
                "//*[@text='" + texto + "']/ancestor::*[@clickable='true'][1]");
        WebElement elemento = new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(locator));
        elemento.click();
        return texto;
    }

    public boolean isMarcado(By locator){
        return Boolean.parseBoolean(
                esperarElementoVisivel(locator).getAttribute("checked"));
    }

    public String obterTextoComReplace(By locator, String stringAntiga, String stringNova){
        return Objects.requireNonNull(esperarElementoVisivel(locator).getAttribute("text")).replace(stringAntiga, stringNova).trim();
    }

    private WebElement esperarElementoClicavel(By locator) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement esperarElementoVisivel(By locator){
        return new WebDriverWait(getDriver(), Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void esperarElementoSumir(By locator){
        new WebDriverWait(getDriver(), Duration.ofSeconds(15))
                .until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void tap(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                x, y
        ));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        getDriver().perform(Collections.singletonList(tap));
    }

    public void clicarSeekBar(By locator, double posicao){
        int delta = 50;
        WebElement seek = getDriver().findElement(locator);
        int y = seek.getLocation().y + (seek.getSize().height / 2);
        int xInixial = seek.getLocation().x + delta;
        System.out.println(y);
        int x = (int) (xInixial + ((seek.getSize().width - 2*delta) * posicao));
        System.out.println(x);
        tap(x,y);
    }

    public boolean isElementoVisivel(By locator){
        try {
            new WebDriverWait(getDriver(), Duration.ofSeconds(4))
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public void longPress(By locator, int duracao) {
        WebElement element = esperarElementoVisivel(locator);
        getDriver().executeScript("mobile: longClickGesture", Map.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "duration", duracao
        ));
    }

    public void scrollTelaParaBaixo(By locator) {
        isElementoVisivel(locator);
        Dimension size = getDriver().manage().window().getSize();
        getDriver().executeScript("mobile: scrollGesture", Map.of(
                "left", 0,
                "top", (int) (size.height * 0.3),
                "width", size.width,
                "height", (int) (size.height * 0.3),
                "direction", "down",
                "percent", 1.0
        ));
    }

    public boolean scrollTelaParaBaixoAteEncontrar(By locator, String direcao) {
        Dimension size = getDriver().manage().window().getSize();
        boolean podeRolar = true;
        while (podeRolar) {
            if (isElementoVisivel(locator)) {
                System.out.println("Achou o elemento: " + locator);
                return true;
            }
            podeRolar = (Boolean) getDriver().executeScript("mobile: scrollGesture", Map.of(
                    "left", 0,
                    "top", (int) (size.height * 0.15),
                    "width", size.width,
                    "height", (int) (size.height * 0.55),
                    "direction", direcao,
                    "percent", 1.0
            ));
        }
        System.out.println("Não achou o elemento: " + locator);
        return false;
    }

    public boolean swipeAteFinalWithPossition(By locator, String direcao){
        do {
            podeFazerSwipe = isElementoVisivel(locator);
            Dimension size = getDriver().manage().window().getSize();
            getDriver().executeScript("mobile: swipeGesture", Map.of(
                    "left", size.width / 4,
                    "top", size.height / 2,
                    "width", size.width / 2,
                    "height", 1,
                    "direction", direcao,
                    "percent", 0.8
            ));
            System.out.println(podeFazerSwipe);
        } while (podeFazerSwipe);
        return false;
    }

    public void swipeUmaVez(By locator){
        isElementoVisivel(locator);
        Dimension size = getDriver().manage().window().getSize();
        getDriver().executeScript("mobile: swipeGesture", Map.of(
                "left", size.width / 4,
                "top", size.height / 2,
                "width", size.width / 2,
                "height", 1,
                "direction", "left",
                "percent", 0.8
        ));
    }

    public void swipePorLocationWithLocator(By locator, String direcao){
        isElementoVisivel(locator);
        WebElement element = getDriver().findElement(locator);
        Rectangle areaRetangulo = element.getRect();
        System.out.println("x: " + areaRetangulo.getX() + " y: " + areaRetangulo.getY() + " w: " + areaRetangulo.getWidth() + " h: " + areaRetangulo.getHeight());
        getDriver().executeScript("mobile: swipeGesture", Map.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", direcao,
                "percent", 1.0
        ));
    }

    public void dragAndDrop(By locatorInitial, By locatorFinal, int width){
        isElementoVisivel(locatorInitial);
        isElementoVisivel(locatorFinal);
        WebElement initialElementDrag = getDriver().findElement(locatorInitial);
        WebElement finalElementDrag = getDriver().findElement(locatorFinal);
        Rectangle rect = finalElementDrag.getRect();
        getDriver().executeScript("mobile: dragGesture", Map.of(
                "elementId", ((RemoteWebElement) initialElementDrag).getId(),
                "endX", rect.getX() + rect.getWidth() / 2,
                "endY", rect.getY() + width
        ));
    }

    public List<String> percorreListaElement(){
        List<WebElement> elementosDepois = getDriver().findElements(
                AppiumBy.className("android.widget.TextView"));
        List<String> listaDepois = elementosDepois.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        System.out.println(listaDepois);
        return listaDepois;
    }

    public void switchToWebView() {
        for (String context : getDriver().getContextHandles()) {
            if (context.contains("WEBVIEW")) {
                getDriver().context(context);
                break;
            }
        }
    }

}
