package com.kodilla.selenium.visual;

import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.snapshot.Snap;
import org.openqa.selenium.WebDriver;

@Snap("WorldTime.png")
public class WorldTimePage {
    private static final String PAGE_URL = "https://www.worldtimeserver.com/current_time_in_AW.aspx";

    private final WebDriver webDriver;

    public WorldTimePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void open() {
        webDriver.get(PAGE_URL);
    }

    public void compare() {
        Ocular.snapshot()
                .from(this)
                .sample()
                .using(webDriver)
                .compare();
    }

    public void close() {
        webDriver.quit();
    }
}
