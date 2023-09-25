//package com.demoblaze.common.helpers.files.base;
//
//import com.vodafone.common.MyLogger;
//import com.vodafone.common.helpers.Connections;
//import com.vodafone.common.helpers.windows.WindowsRegistry;
//import com.vodafone.common.properties.PropertiesManager;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.apache.logging.log4j.core.Logger;
//import org.junit.Assert;
//import org.openqa.selenium.*;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.firefox.FirefoxProfile;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.ie.InternetExplorerOptions;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.LocalFileDetector;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.URL;
//import java.nio.file.Paths;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.concurrent.TimeUnit;
//
///**
// * this a base driver class used by extending it and  using 'getDriver' as a WebDriver object
// * this class support configuration for chrome, firefox, IE browsers
// *
// */
//public class BaseWebDriver {
//    public static Logger log = new MyLogger().getLogger();
//    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
//    public static String Downloads_PATH = Paths.get("").toAbsolutePath().toString();
//    private final String WEBDrivers_PATH = "WebDrivers";
//    private final PropertiesManager propertiesManager = new PropertiesManager();
//    private boolean IS_GRID;
//    public WebDriver getDriver() {
//        if (driver.get() == null)
//            log.info("WebDriver was not initialized...");
//        return driver.get();
//    }
//    public void setDriver(WebDriver d) {
//        driver.set(d);
//    }
//    public void setFirefoxProp(String version, boolean debug) {
//        if(version!=null&&!version.equals(""))
//            WebDriverManager.firefoxdriver().browserVersion(version.split("\\.")[0]);
//        WebDriverManager.firefoxdriver().cachePath(WEBDrivers_PATH).setup();
//        System.setProperty("webdriver.firefox.marionette", "true");
//
//        if (!debug)
//            System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
//    }
//    public void setIEProp() {
//        WebDriverManager.iedriver().cachePath(WEBDrivers_PATH).setup();
//    }
//    private void setChromeDriverPath(String version, String debug) {
//        if(version!=null&&!version.equals(""))
//            WebDriverManager.chromedriver().browserVersion(version.split("\\.")[0]);
//        WebDriverManager.chromedriver(). cachePath(WEBDrivers_PATH).setup();
//        //  disable debug
//        if (debug.equals("false"))
//            System.setProperty("webdriver.chrome.silentOutput", "true");
//        System.setProperty("webdriver.chrome.verboseLogging", debug);
//    }
//    private void setFirefoxPreference(FirefoxOptions fxOpt) {
//
//        // disable download popups
//        fxOpt.addPreference("browser.download.folderList", 2);
//        fxOpt.addPreference("browser.download.dir", Downloads_PATH);
//        fxOpt.addPreference("browser.download.manager.alertOnEXEOpen", false);
//        fxOpt.addPreference("browser.helperApps.neverAsk.saveToDisk",
//                "application/msword, application/csv, application/ris, text/csv, image/png, application/pdf, text/html, text/plain, application/zip, application/x-zip, application/x-zip-compressed, application/download, application/octet-stream");
//        fxOpt.addPreference("browser.download.manager.showWhenStarting", false);
//        fxOpt.addPreference("browser.download.manager.focusWhenStarting", false);
//        fxOpt.addPreference("browser.download.useDownloadDir", true);
//        fxOpt.addPreference("browser.helperApps.alwaysAsk.force", false);
//        fxOpt.addPreference("browser.download.manager.alertOnEXEOpen", false);
//        fxOpt.addPreference("browser.download.manager.closeWhenDone", true);
//        fxOpt.addPreference("browser.download.manager.showAlertOnComplete", false);
//        fxOpt.addPreference("browser.download.manager.useWindow", false);
//        fxOpt.addPreference("services.sync.prefs.sync.browser.download.manager.showWhenStarting", false);
//        fxOpt.addPreference("pdfjs.disabled", true);
//        // open new link in new tab
//        fxOpt.addPreference("browser.link.open_newwindow", 3);
//        // to handle insecure connection "BSS"
//        fxOpt.addPreference("acceptInsecureCerts", true);
//
//    }
//    private void setChromePreference(ChromeOptions opt) {
//
//        HashMap<String, Object> chromeOptionsMap = new HashMap<>();
//        opt.addArguments("--fast-start");
//        opt.addArguments("disable-infobars");
//        opt.addArguments("--disable-extensions");
//        opt.addArguments("--ignore-ssl-errors=yes");
//        opt.addArguments("--ignore-certificate-errors");
//        opt.addArguments("--disable-gpu");
//        opt.addArguments("--no-sandbox");
//        opt.addArguments("--remote-allow-origins=*");
//        opt.addArguments("--disable-dev-shm-usage");
//
//        chromeOptionsMap.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
//        chromeOptionsMap.put("plugins.always_open_pdf_externally", true);
//        chromeOptionsMap.put("download.default_directory", Downloads_PATH);
//        chromeOptionsMap.put("download.prompt_for_download", false);
//        chromeOptionsMap.put("profile.default_content_settings.popups", 0);
//        chromeOptionsMap.put("safebrowsing.enabled", false);
//
//        opt.setExperimentalOption("prefs", chromeOptionsMap);
//        opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
//        opt.setExperimentalOption("useAutomationExtension", false);
//    }
//
//    private WebDriver setDriverConfig(String browserName) {
//        DesiredCapabilities cap = new DesiredCapabilities();
//        Proxy proxy = new Proxy();
//        proxy.setProxyAutoconfigUrl("http://vf-grp-de-pac.internal.vodafone.com/proxy.pac");
//        cap.setCapability(CapabilityType.PROXY, proxy);
//        switch (browserName.toLowerCase()) {
//            case "firefox":
//                FirefoxOptions firefoxOptions = new FirefoxOptions(cap);
//                firefoxOptions.setHeadless(Boolean.parseBoolean(propertiesManager.getProp( "HeadlessBrowser" )));
//                firefoxOptions.setProxy(proxy);
//                setFirefoxPreference(firefoxOptions);
//                driver.set(new FirefoxDriver(firefoxOptions));
//                break;
//            case "chrome":
//                ChromeOptions chromeOptions = new ChromeOptions();
//                chromeOptions.setHeadless(Boolean.parseBoolean(propertiesManager.getProp( "HeadlessBrowser" )));
//                chromeOptions.setProxy(proxy);
//                setChromePreference(chromeOptions);
//                driver.set(new ChromeDriver(chromeOptions));
//                break;
//            case "ie":
//                cap.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
//                cap.setCapability("ignoreZoomSetting", true);
//                cap.setCapability("nativeEvents", false);
//                cap.setCapability("unexpectedAlertBehaviour", "accept");
//                cap.setCapability("ignoreProtectedModeSettings", true);
//                cap.setCapability("disable-popup-blocking", true);
//                cap.setCapability("enablePersistentHover", true);
//                InternetExplorerOptions opt = new InternetExplorerOptions(cap);
//                driver.set(new InternetExplorerDriver(opt));
//                break;
//            default:
//                log.info("Couldn't get find configuration for browser>> " + browserName);
//                FirefoxProfile profile = new FirefoxProfile();
//                FirefoxOptions option = new FirefoxOptions();
//                profile.setPreference("network.http.phishy-userpass-length", 255);
//                profile.setPreference("network.automatic-ntlm-auth.trusted-uris", "ecrm-test-fe");
//                profile.setPreference("browser.safebrowsing.malware.enabled", false);
//                option.setProfile(profile);
//                driver.set(new FirefoxDriver(option));
//                break;
//        }
//        return driver.get();
//    }
//    /**
//     * used to initiate webDriver object, method check if there's connection to grid first and if not it runs locally.
//     * @param browserName browser name (firefox, chrome , ie)
//     * @return initiated webDriver object
//     */
//    public WebDriver openBrowser(String browserName) {
//        if (new Connections().checkConnection("selenium.tools.ci.vodafone.com", 0))
//            if (browserName.toLowerCase().contains("chrome") || browserName.toLowerCase().contains("firefox")) {
//                startSeleniumGrid(browserName);
//                return getDriver();
//            }
//        log.info("Opening browser>>>" + browserName);
//        String localOS =  System.getProperty("os.name").toLowerCase();
//        if(localOS.contains("windows")){
//            openWindowsBrowser(browserName);
//        }else{
//            openUnixBrowser(browserName);
//        }
//        return driver.get();
//    }
//
//    private void setUpWebDriver(WebDriverManager webDriverManager){
//        Connections connect = new Connections();
//        if (!connect.checkConnection(propertiesManager.getProp("m2mPortal.URL"), 8080)) {
//            String user=propertiesManager.getProp("VPN.Proxy.Local.Username");
//            String passw=propertiesManager.getProp("VPN.Proxy.Local.Password");
//            String host=propertiesManager.getProp("VPN.Proxy.Host");
//            String port=propertiesManager.getProp("VPN.Proxy.Port");
//            if (passw != null && !passw.isEmpty()) {
//                webDriverManager.proxyUser(user).proxyPass(passw).proxy("http://"+host+":"+port).proxy("https://"+host+":"+port).setup();
//            } else {
//                webDriverManager.proxy("http://"+host+":"+port).proxy("https://"+host+":"+port).setup();
//            }
//        }else{
//            webDriverManager.setup();
//        }
//    }
//
//    private void openUnixBrowser(String browserName){
//        if (browserName.equalsIgnoreCase("ie")) {
//            setIEProp();
//            setDriverConfig("ie");
//        }else if (browserName.equalsIgnoreCase("firefox")) {
//            setUpWebDriver(WebDriverManager.firefoxdriver());
//            setDriverConfig("firefox");
//        }else if (browserName.equalsIgnoreCase("chrome")) {
//            setUpWebDriver(WebDriverManager.chromedriver());
//            setDriverConfig("chrome");
//        }else {
//            throw new Error("Given browser name either not installed or not found!!!");
//        }
//    }
//    private void openWindowsBrowser(String browserName){
//        log.info("Opening browser>>>" + browserName);
//        WindowsRegistry reg = new WindowsRegistry();
//        String ver;
//        if (browserName.equalsIgnoreCase("ie")) {
//            setIEProp();
//            setDriverConfig("ie");
//        }
//        // check if whether firefox browser installed or not and if found start it
//        else if (browserName.equalsIgnoreCase("firefox") && !(ver = reg.getAppVersion("firefox")).equals("")) {
//            log.info("\tFound Firefox browser with Version>>> " + ver);
//            setFirefoxProp(ver,false);
//            setDriverConfig("firefox");
//        }
//        // check chrome installed or not and if found start it
//        else if (browserName.equalsIgnoreCase("chrome") && !(ver = reg.getAppVersion("chrome")).equals("")) {
//            log.info("\tFound Chrome browser with Version>>> " + ver);
//            setChromeDriverPath(ver,"false");
//            setDriverConfig("chrome");
//        }
//        // default
//        else {
//            throw new Error("Given browser name either not installed or not found!!!");
//        }
//    }
//
//    /**
//     * check if browser is available and opened
//     *
//     * @return browser availability status
//     */
//    public boolean isDriverActive() {
//        if (getDriver() == null || getDriver().toString().contains("(null)")) {
//            return false;
//        } else {
//            try {
//                getDriver().getWindowHandle().toString();
//            } catch (NoSuchSessionException | NoSuchWindowException e) {
//                log.info("Error: " + e.getMessage());
//                return false;
//            } catch (WebDriverException e) {
//                if (e.getMessage().contains(" not reachable") || e.getMessage().contains("localhost")) {
//                    log.info("Error: " + e.getMessage());
//                    return false;
//                } else e.printStackTrace();
//            }
//        }
//        return true;
//    }
//
//    /**
//     * initiate webdriver in selenium grid
//     *
//     * @param gridBrowser browser name (firefox, chrome)
//     * @return
//     */
//    public WebDriver startSeleniumGrid(String gridBrowser) {
//        PropertiesManager props = new PropertiesManager();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//        com.vodafone.common.Proxy proxyManager = new com.vodafone.common.Proxy();
//        System.out.println("Grid Browser Name >> : " + gridBrowser);
//        String gridURL = props.getProp("Grid.url") +"/wd/hub";
//        try {
//            switch (gridBrowser) {
//                case "firefox":
//                    firefoxOptions.setCapability(CapabilityType.BROWSER_NAME, "firefox");
//                    firefoxOptions.setProxy(proxyManager.getGridProxy());
//                    setFirefoxPreference(firefoxOptions);
//                    driver.set(new RemoteWebDriver(new URL(gridURL), firefoxOptions));
//                    driver.get().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//                    break;
//                case "all":
//                    System.out.println("Browser automation configured to run on all browsers : TODO");
//                    break;
//                case "none":
//                    /* Browser automation is not required */
//                    System.out.println("Browser automation is not required");
//                    return null;
//                case "chrome":
//                    chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//                    chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
//                    chromeOptions.setProxy(proxyManager.getGridProxy());
//                    chromeOptions.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
//                    setChromePreference(chromeOptions);
//                    driver.set(new RemoteWebDriver(new URL(gridURL), chromeOptions));
//                    driver.get().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//                    break;
//                default:
//                    gridBrowser = "chrome";
//                    chromeOptions.setCapability(CapabilityType.BROWSER_NAME, "chrome");
//                    chromeOptions.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
//                    chromeOptions.setProxy(proxyManager.getGridProxy());
//                    chromeOptions.setCapability("chrome.switches", Arrays.asList("--ignore-certificate-errors"));
//                    setChromePreference(chromeOptions);
//                    driver.set(new RemoteWebDriver(new URL(gridURL), chromeOptions));
//                    driver.get().manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//            }
//            IS_GRID = true;
//        } catch (Exception e) {
//            System.out.println("Selenium grid host calling error");
//            if (getDriver() != null) {
//                getDriver().quit();
//            }
//            e.printStackTrace();
//            log.catching(e);
//            Assert.fail("Start Selenium Grid Error ! Quiting ");
//        }
//        enableFileDetector();
//        return driver.get();
//    }
//
//    private void enableFileDetector(){
//        ((RemoteWebDriver)getDriver()).setFileDetector(new LocalFileDetector());
//    }
//
//    public void quite(){
//        if (isDriverActive()) getDriver().quit();
//        driver.remove();
//    }
//}
//
