package com.kodilla.selenium.visual;

import com.kodilla.selenium.pom.WebDriverFactory;
import com.testautomationguru.ocular.Ocular;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class OcularExample {
    public static void main(String[] args) {
        WebDriver webDriver = WebDriverFactory.createDriver();
        Path resultsPath = Paths.get("c:/ocular/results");
        Path snapshotsPath = Paths.get("c:/ocular/snapshots");

        createDirectories(resultsPath, snapshotsPath);

        Ocular.config()
                .resultPath(resultsPath)
                .snapshotPath(snapshotsPath)
                .globalSimilarity(95)
                .saveSnapshot(true);

        WorldTimePage page = new WorldTimePage(webDriver);

        try {
            page.open();
            page.compare();
        } finally {
            page.close();
        }
    }

    private static void createDirectories(Path... paths) {
        for (Path path : paths) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                throw new IllegalStateException("Unable to create directory: " + path, e);
            }
        }
    }
}
