//package com.demoblaze.common.base;
//
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//
///**
// * this is a browser based class contains browser implementations
// */
//public class BaseBrowser extends BaseWebDriver {
//
//    public void openInGrid(String browser) {
//        if (!isDriverActive()) {
//            log.info("Browser Not Available, Starting....");
//            if (getDriver() != null) getDriver().quit();
//            startSeleniumGrid(browser);
//        } else {
//            log.info("Browser Available and Restarting....");
//            if (getDriver() != null) getDriver().quit();
//            startSeleniumGrid(browser);
//        }
//    }
//
//    public void restartBrowser(String browser) {
//        if (!isDriverActive()) {
//            log.info("Browser Not Available, Starting....");
//            openBrowser(browser);
//        } else {
//            log.info("Browser Available and Restarting....");
//            quite();
//            openBrowser(browser);
//        }
//    }
//
//    /**
//     * check current opened browser and if not same as the given name, open it
//     *
//     * @param browserName firefox, chrome, ie
//     * @return if browser current driver closed and opened a new one return true
//     */
//    public boolean isBrowserReopened(String browserName) {
//        boolean isChanged = false;
//        if (browserName.equalsIgnoreCase("firefox") && !(getDriver() instanceof FirefoxDriver)) {
//            restartBrowser("firefox");
//            isChanged = true;
//        } else if (browserName.equalsIgnoreCase("chrome") && !(getDriver() instanceof ChromeDriver)) {
//            restartBrowser("chrome");
//            isChanged = true;
//        } else if (browserName.equalsIgnoreCase("ie") && !(getDriver() instanceof InternetExplorerDriver)) {
//            restartBrowser("ie");
//            isChanged = true;
//        } else if (!isDriverActive()) {
//            restartBrowser(browserName);
//            isChanged = true;
//        }
//        return isChanged;
//    }
//
//    public void navigateToUrl(String url) {
//        getDriver().navigate().to(url);
//    }
//}
