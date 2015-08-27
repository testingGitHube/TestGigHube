package testMap;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.basics.Settings;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Finder;
import org.sikuli.script.Match;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.Wait;

public class RemoteTest {

	private static WebDriver driverChrome;
	private static Actions action;

	public void startTesting() throws InterruptedException, Exception {
		Settings.ActionLogs = false;
		System.out.println("Hi :)");
		setUp();
		testMethod();
		tearDown();
		System.out.println("Bye :)");
	}

	@BeforeMethod
	public static void setUp() {

		// driverChrome = new FirefoxDriver();
		//
		System.setProperty("webdriver.chrome.driver",
				"C:\\chromedriver_win32\\chromedriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		LoggingPreferences loggingprefs = new LoggingPreferences();
		loggingprefs.enable(LogType.BROWSER, Level.ALL);
		capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
		driverChrome = new ChromeDriver(capabilities);
		
	}

	@AfterMethod
	public static void tearDown() {
		driverChrome.quit();
	}

	@Test
	public static void testMethod() throws InterruptedException, AWTException {

		// //////////////// WebDriver driverChrome
		// System.setProperty("webdriver.chrome.driver",
		// "C:\\chromedriver\\chromedriver.exe");
		System.out.println("open and maximize testpam");
		driverChrome.manage().window().maximize();
		driverChrome.get("https://testpam.granduke.net/login/");

		// ////^^^^^^^^^^^^^^

		// //////////////////// Login Page
		System.out.println("Login Page");
		WebElement userName = driverChrome.findElement(By
				.xpath("//input[@id='id_username']"));
		userName.sendKeys("kim");
		WebElement passwordName = driverChrome
				.findElement(By.id("id_password"));
		passwordName.sendKeys("islanders1980*");
		WebElement submitButton = driverChrome.findElement(By.name("submit"));
		submitButton.click();
		// ////^^^^^^^^^^^^^^^^^^^^^

		driverChrome.manage().timeouts()
				.implicitlyWait(10000, TimeUnit.SECONDS);
		action = new Actions(driverChrome);

		Thread.sleep(15000);

		// /////// IS MAP LOADED

		while (true) {
			try {

				isMapLoaded();
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// //^^^^^^^^^^^^^^^^^^^^^^^^

		// //////////// set defaults

		clickOn_TogglesImplementVisibility();

		// // ////////////
		Thread.sleep(2000);

		// // Open Four Windows
		//
		// // ///////////// Click on PAM
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Click on PAM");
		// clickOn_PAM();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click on 'Window' from PAM Menu
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click on 'Window' from PAM Menu");
		// clickOn_Window_FromPamMenu();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// click on Four Window Layout
		// System.out.println("Map Window Testing: Four Windows Opened");
		// clickOn_FourWindowLayout();
		//
		// // //^^^^^^^^^^^^^^^^^^^^^^^^
		// //
		//
		// Thread.sleep(2000);
		//
		// ///////// Closeing All PAM Bars
		while (true) {
			try {
				System.out.println("MAp Window Testing: Closeing All PAM Bars");
				closingAllPAMBars();

				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^^^^

		// Thread.sleep(2000);
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Include all Assets in View
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Include all Assets in View");
		// clickOn_IncludeAllAssetsInView();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Go to West
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Go to West");
		// goToThisPlace("West");
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Go to Outlook
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Go to Outlook");
		// goToThisPlace("Outlook");
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Go to Cypress
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Go to Cypress");
		// goToThisPlace("Cypress");
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Go to Smith Seeds
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Go to Smith Seeds");
		// goToThisPlace("Smith Seeds");
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Go to Smith Land and Cattle
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Go to Smith Land and Cattle");
		// goToThisPlace("Smith Land and Cattle");
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // //// ^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Count the Number of Assets
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Count the Number of Assets");
		// clickOn_CountTheNumberOfAssets();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click on a Barn
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click on a Barn (If any visible)");
		// clickOn_barn();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Remove All Highlighting From Assets
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Remove All Highlighting From Assets");
		// clickOn_RemoveAllHighlightingFromAssets();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Open Add Bookmark Window
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Open Add Bookmark Window");
		// clickOn_RecordsABookmarkOfTheCurrentView();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Write a Text to Bookmark
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Write a Text to Bookmark");
		// writeOn_addBookmark();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click on the Add Bookmark button
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click on the Add Bookmark Button");
		// clickOn_addBookmarkButton();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Open Add Bookmark Window
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Open Add Bookmark Window");
		// clickOn_RecordsABookmarkOfTheCurrentView();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Write a Text to Bookmark
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Write a Text to Bookmark");
		// writeOn_addBookmark();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click on the Cancel Bookmark Button
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click on the Cancel Bookmark Button");
		// clickOn_CancelBookmarkButton();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Manage Bookmarks Wondow
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Manage Bookmarks Window");
		// clickOn_ProducesAWindowWhereallBookmarksCanBeManaged();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Delete Bookmark by Red Cross
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Delete Bookmark By Red Cross");
		// clickOn_DeleteBookmarkByRedCross();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Close Manage Bookmarks Window
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Close Manage Bookmarks Window");
		// clickOn_CloseManageBookmarksWindow();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// click On Place a Marker on the Map at a
		// // Specific Point
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Place a Marker on the Map at a Specific Point");
		// clickOn_PlaceAMarkerOnTheMapAtASpecificPoint();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Write Name And Description On AddPlacemark
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Write Name And Description On AddPlacemark ");
		// writeOn_AddPlacemark_NameAndDescription();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Select From Who Else Can See This
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Select From Who Else Can See This");
		// selectAndDeleteFrom_WhoElseCanSeeThis();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// click On Submit From Add Placemark
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Submit From Add Placemark");
		// clickOn_SubmitFromAddPlacemark();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// click On Place a Marker on the Map at
		// // a
		// // Specific Point
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Place a Marker on the Map at a Specific Point");
		// clickOn_PlaceAMarkerOnTheMapAtASpecificPoint();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Cancel From Add Placemark
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Cancel From Add Placemark");
		// clickOn_CancelFromAddPlacemark();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);
		//
		// // ///////////// Right Click On A Marker
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Marker");
		// rightClickOnAMarker();
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Placemark
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Testing Placemark");
		// testingPlacemark();
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);
		// // /////////// Produces A Window Where All Placemarks Can Be Managed
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Produces A Window Where All Placemarks Can Be Managed");
		// clickOn_ProducesAWindowWhereAllPlacemarksCanBeManaged();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Delete Placemark By RedCross
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Delete Placemark By RedCross");
		// clickOn_DeletePlacemarkByRedCross();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Close Manage Placemarks Window by red cross
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Close Manage Placemarks Window By Red Cross");
		// clickOn_CloseManagePlacemarksWindowByRedCross();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Toggle Placemark Visibility
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Toggle Placemark Visibility");
		// clickOn_TogglePlacemarkVisibility();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// Remove Back Ground
		// while (true) {
		// try {
		// System.out
		// .println("*****    at this point we remove the background to make the changes more visible for you    *****");
		// removeBackGround();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);
		//
		// // /////////// Click On Add A Boundary To The Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Add A Boundary To The Map");
		// clickOn_AddABoundaryToTheMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// Using Boundary To The Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Using Boundary To The Map");
		// testingBoundaryToTheMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		//
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// Click On Opens The Boundary Manager
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Opens The Boundary Manager");
		// clickOn_OpensTheBoundaryManager();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		//
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// // Thread.sleep(2000);
		//
		// // /////////// Testing Boundary Manager
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Testing Boundary Manager");
		// testingBoundaryManager();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// Closing Boundary Manager By Red Cross
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Closing Boundary Manager By Red Cross");
		// closingBoundaryManagerByRedCross();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// Go Back To ESRI Aerial
		// while (true) {
		// try {
		// System.out
		// .println("*****    at this point we go back to ESRI Aerial    *****");
		// goBackToESRIAerial();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Toggles Implement Visibility
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Toggles Implement Visibility");
		// clickOn_TogglesImplementVisibility();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Automatically Update Implement Information
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Automatically Update Implement Information");
		// clickOn_AutomaticallyUpdateImplementInformation();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);
		// // ///////////// Click On Automatically Update Implement Information
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Automatically Update Implement Information");
		// clickOn_AutomaticallyUpdateImplementInformation();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);
		// // ///////////// Click On Toggles Implement Visibility
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Toggles Implement Visibility");
		// clickOn_TogglesImplementVisibility();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Toggles Ruler Visibility
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Toggles Ruler Visibility");
		// clickOn_TogglesRulerVisibility();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Using Ruler
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Using Ruler");
		// usingRuler();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Toggles Ruler Visibility
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Toggles Ruler Visibility");
		// clickOn_TogglesRulerVisibility();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// Include all Assets in View
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Include all Assets in View");
		// clickOn_IncludeAllAssetsInView();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Toggles Area Measure Tool Visibility
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Toggles Area Measure Tool Visibility");
		// clickOn_TogglesAreaMeasureToolVisibility();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Using Area Measure Tool
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Using Area Measure Tool");
		// usingAreaMeasureTool();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Toggles Area Measure Tool Visibility
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Toggles Area Measure Tool Visibility");
		// clickOn_TogglesAreaMeasureToolVisibility();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////// Closeing All PAM Bars
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Closeing All PAM Bars");
		// closingAllPAMBars();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);
		//
		// // /////////// toggles Legend Visibility
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Toggles Legend Visibility");
		// clickOn_togglesLegendVisibility();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// testing Legend Window Items
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Testing Legend Window Items");
		// testingLegendWindowItems();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// closing Legend Window By Red Cross
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Close Legend Window By Red Cross");
		// closingLegendWindowByRedCross();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // // ////^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On View Regional Layers
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On View Regional Layers");
		// clickOn_ViewRegionalLayers();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Tesing View Regional Layers
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Tesing View Regional Layers (We will have a closer look again later when we are zoomed in)");
		// tesing_ViewRegionalLayers();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Close View Regional Layers By Red Cross
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Close View Regional Layers By Red Cross");
		// clickOn_CloseViewRegionalLayersByRedCross();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Hide All Layers On Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Hide All Layers On Map (We will have a closer look again later when we are zoomed in)");
		// clickOn_HideAllLayersOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Zome In
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Click On Zome In");
		// clickOn_ZomeIn();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Zome Out
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Click On Zome Out");
		// clickOn_ZomeOut();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Magnifying Glass On Top Right Of Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Magnifying Glass On Top Right Of Map");
		// clickOn_MagnifyingGlassOnTopRightOfMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Magnifying Glass On Top Right Of Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Testing Magnifying Glass On Top Right Of Map");
		// testing_MagnifyingGlassOnTopRightOfMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On PAM
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Click On PAM");
		// clickOn_PAM();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Window From Pam Menu
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Window From Pam Menu");
		// clickOn_Window_FromPamMenu();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Big Map Layout
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Big Map Layout");
		// clickOn_BigMapLayout();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Layers Icon
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Click On Layers Icon");
		// clickOn_Layers_icon();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Layers Window Iteams
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Testing Layers Window Iteams");
		// testing_Layers_WindowIteams();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);

		// ///////////// Go to West
		while (true) {
			try {
				System.out.println("Map Window Testing: Go to West");
				goToThisPlace("West");

				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^^^^

		Thread.sleep(2000);

		// ///////////// Go to Outlook
		while (true) {
			try {
				System.out.println("Map Window Testing: Go to Outlook");
				goToThisPlace("Outlook");

				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^^^^

		Thread.sleep(2000);

		// ///////////// Go to Cypress
		while (true) {
			try {
				System.out.println("Map Window Testing: Go to Cypress");
				goToThisPlace("Cypress");

				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^^^^

		Thread.sleep(2000);

		// ///////////// Go to Smith Seeds
		while (true) {
			try {
				System.out.println("Map Window Testing: Go to Smith Seeds");
				goToThisPlace("Smith Seeds");

				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ^^^^^^^^^^^^^^^^^^^^^^^^

		Thread.sleep(2000);

		// ///////////// Go to Smith Land and Cattle
		while (true) {
			try {
				System.out
						.println("Map Window Testing: Go to Smith Land and Cattle");
				goToThisPlace("Smith Land and Cattle");

				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// // ^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Right Click On A Barn
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Barn (If There Is Any Visible One)");
		// rightClickOnABarn();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Zoom To On Map From Right Click On Items On
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Zoom To On Map From Right Click On Items On Map");
		// clickOn_ZoomToOnMap_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // /////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ////// ^^^^^^^^^^^^^^^^^^^^^
		//
		// // ///////////// Right Click On A Barn
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Barn (If There Is Any Visible One)");
		// rightClickOnABarn();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Move Farm From Right Click On Items On Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Move Farm From Right Click On A Barn On Map");
		// clickOn_MoveFarm_FromRightClickOnABarnOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Right Click On A Barn
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Barn (If There Is Any Visible One)");
		// rightClickOnABarn();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Show Attributes From Right Click On Items
		// // On Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Show Attributes From Right Click On Items On Map");
		// clickOn_ShowAttributes_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Show Attributes
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Testing Show Attributes");
		// testing_ShowAttributes("Smith Land and Cattle");
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Right Click On A Barn
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Barn (If There Is Any Visible One)");
		// rightClickOnABarn();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On View Documents From Right Click On Items On
		// // Map
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On View Documents From Right Click On Items On Map");
		// clickOn_ViewDocuments_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Right Click On A Barn
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Barn (If There Is Any Visible One)");
		// rightClickOnABarn();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Add Event From Right Click On Items On Map
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Add Event From Right Click On Items On Map");
		// clickOn_AddEvent_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Add Event
		//
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Testing Add Event");
		// testing_AddEvent();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Right Click On A Barn
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Barn (If There Is Any Visible One)");
		// rightClickOnABarn();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On View Events From Right Click On Items On
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On View Events From Right Click On Items On Map");
		// clickOn_ViewEvents_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Right Click On A Barn
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Barn (If There Is Any Visible One)");
		// rightClickOnABarn();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Asset Count From Right Click On Items On
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Asset Count From Right Click On Items On Map");
		// clickOn_AssetCount_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Right Click On A Barn
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Barn (If There Is Any Visible One)");
		// rightClickOnABarn();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Add Edit Notes From Right Click On Items On
		// // Map
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Add Edit Notes From Right Click On Items On Map");
		// clickOn_AddEditNotes_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Add/Edit Notes
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Testing Add/Edit Notes");
		// testing_AddEditNotes();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Close Add Edit Notes By Red Cross
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Close Add Edit Notes By Red Cross");
		// closeAddEditNotesByRedCross("Smith Land and Cattle");
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// ///////////// Right Click On A Barn
		while (true) {
			try {
				System.out
						.println("Map Window Testing: Right Click On A Barn (If There Is Any Visible One)");
				rightClickOnABarn();

				break;
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^

		Thread.sleep(2000);

		// /////////// Click On Load Fields From Right Click On Items On Map
		while (true) {
			try {
				System.out
						.println("Map Window Testing: Click On Load Fields From Right Click On Items On Map");
				clickOn_LoadFields_FromRightClickOnItemsOnMap();

				break;
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^
		Thread.sleep(2000);

		// ///////////// Go to NW-30-8-1-W3
		while (true) {
			try {
				System.out.println("Map Window Testing: Go to NW-30-8-1-W3");
				goToThisPlace("NW-30-8-1-W3");

				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);
		//
		// // /////////// Right Click On A Loaded Field
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Loaded Field");
		// rightClickOnALoadedField();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Zoom To On Map From Right Click On Items On
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Zoom To On Map From Right Click On Items On Map");
		// clickOn_ZoomToOnMap_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// Right Click On A Loaded Field
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Loaded Field");
		// rightClickOnALoadedField();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Show Attributes From Right Click On Items
		// // On Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Show Attributes From Right Click On Items On Map");
		// clickOn_ShowAttributes_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Show Attributes
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Testing Show Attributes");
		// testing_ShowAttributes("Wheat (CWAD) (2014-10-07)");
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// /////////// Right Click On A Loaded Field
		while (true) {
			try {
				System.out
						.println("Map Window Testing: Right Click On A Loaded Field");
				rightClickOnALoadedField();

				break;
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		// //^^^^^^^^^^^^^^^^^^^^^

		Thread.sleep(2000);

		// ///////////// Click On View Documents From Right Click On Items On
		// Map
		// Map
		while (true) {
			try {
				System.out
						.println("Map Window Testing: Click On View Documents From Right Click On Items On Map");
				clickOn_ViewDocuments_FromRightClickOnItemsOnMap();

				break;
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^

		// Thread.sleep(2000);
		//
		// // /////////// Right Click On A Loaded Field
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Loaded Field");
		// rightClickOnALoadedField();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Add Event From Right Click On Items On Map
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Add Event From Right Click On Items On Map");
		// clickOn_AddEvent_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Add Event
		//
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Testing Add Event");
		// testing_AddEvent();
		//
		// break;
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// Right Click On A Loaded Field
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Loaded Field");
		// rightClickOnALoadedField();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On View Events From Right Click On Items On
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On View Events From Right Click On Items On Map");
		// clickOn_ViewEvents_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // /////////// Right Click On A Loaded Field
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Loaded Field");
		// rightClickOnALoadedField();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Asset Count From Right Click On Items On
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Asset Count From Right Click On Items On Map");
		// clickOn_AssetCount_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		//
		// Thread.sleep(2000);
		//
		// // /////////// Right Click On A Loaded Field
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Right Click On A Loaded Field");
		// rightClickOnALoadedField();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // //^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Click On Add Edit Notes From Right Click On Items On
		// // Map
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Click On Add Edit Notes From Right Click On Items On Map");
		// clickOn_AddEditNotes_FromRightClickOnItemsOnMap();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Add/Edit Notes
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Testing Add/Edit Notes");
		// testing_AddEditNotes();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Close Add Edit Notes By Red Cross
		// // Map
		// while (true) {
		// try {
		// System.out
		// .println("Map Window Testing: Close Add Edit Notes By Red Cross");
		// closeAddEditNotesByRedCross("Wheat (CWAD) (2014-10-07)");
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Harvest
		// // Map
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Testing Harvest");
		// testingHarvest();
		//
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		//
		// // ////^^^^^^^^^^^^^^^^^^^^^
		//
		// Thread.sleep(2000);
		//
		// // ///////////// Testing Profit
		// // Map
		// while (true) {
		// try {
		// System.out.println("Map Window Testing: Testing Profit");
		// testingprofit();
		// break;
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		//
		// }
		// }
		// // ////^^^^^^^^^^^^^^^^^^^^^
		// Thread.sleep(2000);

		// ///////////// Testing Applied
		// Map
		while (true) {
			try {
				System.out.println("Map Window Testing: Testing Applied");
				testingApplied();
				break;
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^

		Thread.sleep(2000);

		// ///////////// Closing A Specific Section From Pam Bar
		// Map
		while (true) {
			try {
				System.out
						.println("Map Window Testing: Closing A Specific Section From Pam Bar");
				closeThisSpecificSectionFromPamBar("NW-30-8-1-W3");
				break;
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^
		Thread.sleep(2000);

		// ///////////// Click On Toggles Implement Visibility
		// Map
		while (true) {
			try {
				System.out
						.println("Map Window Testing: Click On Toggles Implement Visibility");
				clickOn_TogglesImplementVisibility();
				break;
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^
		Thread.sleep(2000);
		// ///////////// Right Click On An Implement
		// Map
		while (true) {
			try {
				System.out
						.println("Map Window Testing: Right Click On An Implement");
				rightClickOnAnImplement("tractor-green");
				break;
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		// ////^^^^^^^^^^^^^^^^^^^^^

		Thread.sleep(2000);

		// ///////////// Testing View Implement Path
		// Map
		while (true) {
			try {
				System.out
						.println("Map Window Testing: Testing View Implement Path");
				testing_ViewImplementPath();
				break;
			} catch (Exception e) {

				e.printStackTrace();

			}
		}
		System.out
				.println("********************************* End of Map Testing **************************************");
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Thread.sleep(600000);
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}

	// *******************************************************************************
	public static void clickOn_Window_FromPamMenu() {
		// System.out.println(new SimpleDateFormat("yyyyMMdd_HHmmss")
		// .format(Calendar.getInstance().getTime()));
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		// System.out.println(new SimpleDateFormat("yyyyMMdd_HHmmss")
		// .format(Calendar.getInstance().getTime()));
		for (WebElement we : divs) {
			try {
				if (we.getAttribute("class").equals("menu-text")
						&& we.getText().equals("Window")) {
					// it seems that for divs we have to click them not using
					// the
					// script
					// we.click();
					action.moveToElement(we).build().perform();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	public static void clickOn_PAM() {
		List<WebElement> imgs = driverChrome.findElements(By.tagName("img"));
		JavascriptExecutor executor = (JavascriptExecutor) driverChrome;
		WebElement Pam_Logo = null;

		for (WebElement we : imgs) {// in this for we find the WebElement whose
			// tagName is img and
			try { // src contains Pam-Logo then we click on it
					// ///pam/static/icons/navbar/selectorSprites/FarmCommandLogo-White
				if (we.getAttribute("src").contains("FarmCommandLogo-White")) {
					Pam_Logo = we;
					executor.executeScript("arguments[0].click();", we);

					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	static public void clickOn_FourWindowLayout() throws InterruptedException {
		List<WebElement> imgs = driverChrome.findElements(By.tagName("img"));
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		List<WebElement> as = driverChrome.findElements(By.tagName("a"));
		JavascriptExecutor executor = (JavascriptExecutor) driverChrome;
		while (true) {
			int count = 0;
			for (WebElement we : as) {

				count++;
				if (we.getText().contains("Four Window Layout")) {

					Thread.sleep(1000);

					executor.executeScript("arguments[0].click();", we);

					break;
				}
			}
			if (count == as.size()) {
				clickOn_PAM();
				clickOn_Window_FromPamMenu();
			} else {
				break;
			}
		}
	}

	// /******************************************************************************************************
	static public void clickOn_IncludeAllAssetsInView()
			throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		// //// invert the list

		ArrayList<WebElement> array = new ArrayList<WebElement>();

		for (int i = divs.size() - 1; i >= 0; i--) {
			array.add(divs.get(i));
		}

		divs = array;
		// ////
		for (WebElement we : divs) {
			try {
				if (we.getAttribute("title").contains(
						"Include all Assets in View")) {
					we.click();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}

	}

	// ******************************************************************************************************
	static void clickOn_CountTheNumberOfAssets() throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		for (WebElement we : divs) {
			try {
				if (we.getAttribute("title").contains(
						"Count the number of assets")) {
					we.click();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				System.out.println("see I told you :)");
			}
		}
		// System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
		// .format(Calendar.getInstance().getTime()));

	}

	// ******************************************************************************************************
	static void clickOn_barn() throws InterruptedException {
		List<WebElement> imgs = driverChrome.findElements(By.tagName("img"));
		for (WebElement we : imgs) {
			try {
				if (we.getAttribute("src")
						.contains("pam/static/icons/barn.png")) {
					try {// try is needed because some Elementa are not
							// clickable at
							// point (x, y). Other element would receive the
							// click
						we.click();
						Thread.sleep(2000);

						break;
					} catch (Exception e) {

					}
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_pinSBbank() throws InterruptedException {
		List<WebElement> imgs = driverChrome.findElements(By.tagName("img"));
		for (WebElement we : imgs) {
			try {
				if (we.getAttribute("src").contains(
						"https://api.tiles.mapbox.com/v3/marker/pin-s-bank")) {
					try {// try is needed because some Elementa are not
							// clickable at
							// point (x, y). Other element would receive the
							// click
						we.click();
						Thread.sleep(2000);

						break;
					} catch (Exception e) {

					}
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}

	}

	// ******************************************************************************************************
	static void clickOn_RemoveAllHighlightingFromAssets()
			throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		for (WebElement we : divs) {
			try {
				if (we.getAttribute("title").contains(
						"Remove all highlighting from assets")) {
					we.click();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}

	}

	// ******************************************************************************************************
	static void clickOn_RecordsABookmarkOfTheCurrentView()
			throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		for (WebElement we : divs) {
			try {
				if (we.getAttribute("title").contains(
						"Records a bookmark of the current view")) {
					we.click();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}

	}

	// ******************************************************************************************************
	static void writeOn_addBookmark() throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("input"));
		for (WebElement we : divs) {
			try {
				if (we.getAttribute("id").contains("id_name")) {
					we.sendKeys("We Just Wrote Something on Bookmark TextField");
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}

	}

	// ******************************************************************************************************
	static void clickOn_addBookmarkButton() throws InterruptedException {
		List<WebElement> buttons = driverChrome.findElements(By
				.tagName("button"));
		for (WebElement we : buttons) {
			try {
				if (we.getText().contains("Add Bookmark")) {
					we.click();
					;
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}

	}

	// ******************************************************************************************************
	static void clickOn_CancelBookmarkButton() throws InterruptedException {
		List<WebElement> buttons = driverChrome.findElements(By
				.tagName("button"));
		for (WebElement we : buttons) {
			try {
				if (we.getText().contains("Cancel")
						&& we.getAttribute("type").contains("button")) {
					we.click();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}

	}

	// ******************************************************************************************************
	static void clickOn_ProducesAWindowWhereallBookmarksCanBeManaged()
			throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		for (WebElement we : divs) {
			try {
				if (we.getAttribute("title").contains(
						"Produces a window where all bookmarks can be managed")) {
					we.click();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}

	}

	// ******************************************************************************************************
	static void clickOn_DeleteBookmarkByRedCross() throws InterruptedException {
		boolean breakIt = false;
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		for (WebElement weDiv : divs) {
			if (weDiv.getAttribute("class").contains("bookmarkRow")) {
				List<WebElement> bs = weDiv.findElements(By.tagName("b"));
				for (WebElement weB : bs) {
					if (weB.getText().equals(
							"We Just Wrote Something on Bookmark TextField")) {
						List<WebElement> imgs = weDiv.findElements(By
								.tagName("img"));
						for (WebElement we : imgs) {
							try {
								if (we.getAttribute("title").contains(
										"Delete Bookmark")) {
									we.click();
									driverChrome.switchTo().alert().accept();
									Thread.sleep(5000);

									Thread.sleep(2000);
									action.sendKeys(Keys.ENTER).build()
											.perform();
									Thread.sleep(2000);
									breakIt = true;
									break;
								}
							} catch (Exception e) {
								// System.out.println("see I told you :)");
							}
						}
					}
					if (breakIt) {
						break;
					}
				}
				if (breakIt) {
					break;
				}
			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_CloseManageBookmarksWindow()
			throws InterruptedException {
		boolean breakIt = false;
		List<WebElement> wes = driverChrome.findElements(By
				.className("ui-dialog-titlebar"));
		for (WebElement we : wes) {
			// Would it throw exception if a div does not have such an
			// attribute? YES :) so put try
			try {
				if (we.getTagName().equals("div")) {
					List<WebElement> spans = we
							.findElements(By.tagName("span"));
					for (WebElement weSpan : spans) {
						// System.out.println(innerWe.getTagName());
						if (weSpan.getText().equals("Manage Bookmarks")) {
							List<WebElement> as = we.findElements(By
									.tagName("a"));
							for (WebElement weA : as) {
								// System.out.println(innerWe.getTagName());
								if (weA.getText().equals("close")) {
									weA.click();
									Thread.sleep(2000);
									breakIt = true;
									break;
								}
							}
							if (breakIt) {
								break;
							}
						}
					}

				}
			} catch (Exception e) {

			}
			if (breakIt) {
				break;
			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_PlaceAMarkerOnTheMapAtASpecificPoint()
			throws InterruptedException {

		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		for (WebElement we : divs) {
			try {
				if (we.getAttribute("title").contains(
						"Place a marker on the map at a specific point")) {
					we.click();
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	static void writeOn_AddPlacemark_NameAndDescription()
			throws InterruptedException {
		String uniqueID = UUID.randomUUID().toString();

		// ////////// We do the code below to make sure that the element from
		// the new opened window is visible
		List<WebElement> inputs = driverChrome
				.findElements(By.tagName("input"));
		boolean breakIt = false;
		while (true) {

			for (WebElement we : inputs) {
				if (we.getAttribute("name").equals("title")) {
					breakIt = true;
					driverChrome.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;

				}
			}
			if (breakIt) {
				break;
			}
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			inputs = driverChrome.findElements(By.tagName("input"));
			Thread.sleep(1000);

		}
		// //////////////////// ^^^^^^^^^ We do the code above to make sure that
		// the element from the new opened window is visible

		List<WebElement> textareas = driverChrome.findElements(By
				.tagName("textarea"));
		// for name sometimes does not work
		Thread.sleep(1000);
		for (WebElement we : inputs) {
			try {

				if (we.getAttribute("name").equals("title")) {

					we.click();

					Thread.sleep(1000);
					we.clear();

					Thread.sleep(1000);
					we.sendKeys("Sina Golestanirad " + uniqueID);

					break;
				}
			} catch (Exception e) {
				e.printStackTrace();

				// System.out.println("see I told you :)");
			}
		}
		Thread.sleep(2000);
		for (WebElement we : textareas) {
			try {
				if (we.getAttribute("name").equals("description")) {
					we.sendKeys("Sina Golestanirad just bought a nice land here :)");
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();

				// System.out.println("see I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	static void selectAndDeleteFrom_WhoElseCanSeeThis()
			throws InterruptedException {

		List<WebElement> uls = driverChrome.findElements(By.tagName("ul"));

		for (WebElement we : uls) {
			try {
				if (we.getAttribute("class").contains("select2-choices")) {
					we.click();
					Thread.sleep(2000);
					action = new Actions(driverChrome);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_UP).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_UP).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ENTER).build().perform();
					Thread.sleep(2000);
					// /////////////////////////////////////
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_DOWN).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_UP).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_UP).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ARROW_UP).build().perform();
					Thread.sleep(1000);
					action.sendKeys(Keys.ENTER).build().perform();
					Thread.sleep(3000);
					// //////////////////////////////////////////

					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				// System.out.println("see I told you :)");
			}
		}
		List<WebElement> as = driverChrome.findElements(By.tagName("a"));
		for (WebElement we : as) {
			try {
				if (we.getAttribute("class").contains(
						"select2-search-choice-close")) {
					System.out
							.println("*****    Let's remove one of them    *****");

					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					break;
				}
			} catch (Exception e) {
				e.printStackTrace();
				// System.out.println("see I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_SubmitFromAddPlacemark() throws InterruptedException {

		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();

		Thread.sleep(1000);
		// List<WebElement> forms =
		// driverChrome.findElements(By.tagName("form"));
		// boolean breakIt = false;
		// for (WebElement we : forms) {
		// try {
		// if (we.getAttribute("class").contains("jsonform-hasrequired")) {
		// System.out.println("-->" + we.getAttribute("class"));
		// List<WebElement> divs = driverChrome.findElements(By
		// .tagName("div"));
		// for (WebElement weDiv : divs) {
		// List<WebElement> inputs = driverChrome.findElements(By
		// .tagName("input"));
		// for (WebElement weInput : inputs) {
		// if (weInput.getAttribute("value")
		// .contains("Submit")) {
		// System.out.println("==>"
		// + weInput.getAttribute("value"));
		// weInput.click();
		// Thread.sleep(1000);
		// breakIt = true;
		// break;
		// }
		// }
		// if (breakIt) {
		// break;
		// }
		// }
		//
		// }
		// } catch (Exception e) {
		// e.printStackTrace();
		// System.out.println("see I told you :)");
		// }
		// if (breakIt) {
		// break;
		// }
		// }
	}

	// ******************************************************************************************************
	static void clickOn_CancelFromAddPlacemark() throws InterruptedException {
		// ////////// We do the code below to make sure that the element from
		// the new opened window is visible
		List<WebElement> inputs = driverChrome
				.findElements(By.tagName("input"));
		boolean breakIt = false;
		while (true) {

			for (WebElement we : inputs) {
				if (we.getAttribute("name").equals("title")) {
					breakIt = true;
					driverChrome.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;

				}
			}
			if (breakIt) {
				break;
			}
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			inputs = driverChrome.findElements(By.tagName("input"));
			Thread.sleep(1000);

		}
		// //////////////////// ^^^^^^^^^ We do the code above to make sure that
		// the element from the new opened window is visible
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
	}

	// ******************************************************************************************************
	static void clickOn_ProducesAWindowWhereAllPlacemarksCanBeManaged()
			throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		for (WebElement we : divs) {
			try {
				if (we.getAttribute("title")
						.contains(
								"Produces a window where all placemarks can be managed")) {
					we.click();
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_DeletePlacemarkByRedCross() throws InterruptedException {

		boolean breakIt = false;
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		for (WebElement weDiv : divs) {
			if (weDiv.getAttribute("class").contains(
					"placemarkRow ui-state-default")) {
				List<WebElement> bs = weDiv.findElements(By.tagName("b"));
				for (WebElement weB : bs) {
					if (weB.getText().contains("Sina Golestanirad")) {
						List<WebElement> imgs = weDiv.findElements(By
								.tagName("img"));
						for (WebElement we : imgs) {
							try {
								if (we.getAttribute("title").contains(
										"Delete Placemark")) {
									we.click();
									driverChrome.switchTo().alert().accept();
									Thread.sleep(5000);

									Thread.sleep(2000);
									action.sendKeys(Keys.ENTER).build()
											.perform();
									Thread.sleep(2000);
									breakIt = true;
									break;
								}
							} catch (Exception e) {
								// System.out.println("see I told you :)");
							}
						}
					}
					if (breakIt) {
						break;
					}
				}
				if (breakIt) {
					break;
				}
			}
		}

	}

	// ******************************************************************************************************
	static void clickOn_CloseManagePlacemarksWindowByRedCross()
			throws InterruptedException {
		boolean breakIt = false;
		List<WebElement> wes = driverChrome.findElements(By
				.className("ui-dialog-titlebar"));
		for (WebElement we : wes) {
			// Would it throw exception if a div does not have such an
			// attribute? YES :) so put try
			try {
				if (we.getTagName().equals("div")) {
					List<WebElement> spans = we
							.findElements(By.tagName("span"));
					for (WebElement weSpan : spans) {
						// System.out.println(innerWe.getTagName());
						if (weSpan.getText().equals("Manage Placemarks")) {
							List<WebElement> as = we.findElements(By
									.tagName("a"));
							for (WebElement weA : as) {
								// System.out.println(innerWe.getTagName());
								if (weA.getText().equals("close")) {
									weA.click();
									Thread.sleep(2000);
									breakIt = true;
									break;
								}
							}
							if (breakIt) {
								break;
							}
						}
					}

				}
			} catch (Exception e) {

			}
			if (breakIt) {
				break;
			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_TogglePlacemarkVisibility() throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getAttribute("class").contains(
						"pam-icon-togglePlacemarks toolbar-button-icon")) {
					we.click();
					break;
				}
			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_TogglesRulerVisibility() throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getAttribute("class").contains(
						"pam-icon-map-ruler toolbar-button-icon")) {
					we.click();
					Thread.sleep(1000);
					break;
				}

			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void usingRuler() throws InterruptedException {

		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		for (WebElement we : divs) {
			try {
				if (we.getAttribute("id").contains("leaflet-map")) {
					Dimension dimension = we.getSize();
					action.moveToElement(we, (dimension.width) / 2,
							(dimension.height) / 2).click().build().perform();
					Thread.sleep(1000);
					action.moveToElement(we, ((dimension.width) / 2),
							((dimension.height) / 2) + (dimension.height) / 3)
							.click().build().perform();
					Thread.sleep(2000);
					action.moveToElement(we,
							((dimension.width) / 2) + ((dimension.width) / 3),
							((dimension.height) / 2) + ((dimension.height) / 3))
							.click().build().perform();
					Thread.sleep(2000);
					action.moveToElement(we,
							((dimension.width) / 2) + ((dimension.width) / 3),
							((dimension.height) / 2)).click().build().perform();
					Thread.sleep(2000);
					action.moveToElement(we, ((dimension.width) / 2),
							((dimension.height) / 2)).click().build().perform();
					Thread.sleep(2000);
					break;
				}
			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_togglesLegendVisibility() throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		for (WebElement we : divs) {
			try {
				if (we.getAttribute("title").contains(
						"Toggles legend visibility")) {
					we.click();
					break;
				}
			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void testingLegendWindowItems() throws InterruptedException {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		// System.out.println(sdf.format(cal.getTime()));
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		// //// invert the list

		ArrayList<WebElement> array = new ArrayList<WebElement>();

		for (int i = divs.size() - 1; i >= 0; i--) {
			array.add(divs.get(i));
		}

		divs = array;
		// ////

		int count = 0;

		for (WebElement we : divs) {

			try {
				if (we.getAttribute("id").contains("legend-Farm")
						|| we.getAttribute("id")
								.contains("legend-Sales Office")
						|| we.getAttribute("id").contains("legend-Hub")
						|| we.getAttribute("id").contains("legend-Territory")) {
					count++;

					List<WebElement> inputs = we.findElements(By
							.tagName("input"));

					for (WebElement weInput : inputs) {
						try {
							if (weInput.getAttribute("type").contains(
									"checkbox")) {
								if (!weInput.isSelected()) {
									weInput.click();
									Thread.sleep(3000);

								}
							}
						} catch (Exception e) {

						}
					}

					List<WebElement> as = we.findElements(By.tagName("a"));

					for (WebElement a : as) {

						action.click(a).build().perform();
						Thread.sleep(1000);
						for (int i = 0; i < 10; i++) {
							action.sendKeys(Keys.ARROW_LEFT).build().perform();
							Thread.sleep(200);
						}
						for (int i = 0; i < 10; i++) {
							action.sendKeys(Keys.ARROW_RIGHT).build().perform();
							Thread.sleep(200);
						}
						Thread.sleep(1000);
					}

					List<WebElement> selects = we.findElements(By
							.tagName("select"));
					for (WebElement select : selects) {
						select.click();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_DOWN).click().build()
								.perform();
						Thread.sleep(3000);
						select.click();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).click().build()
								.perform();
						Thread.sleep(1000);
					}
					List<WebElement> ps = we.findElements(By.tagName("p"));
					for (WebElement weP : ps) {
						if (weP.getText().contains("Show Labels")) {
							List<WebElement> inputs2 = weP.findElements(By
									.tagName("input"));
							for (WebElement weInput : inputs2) {
								try {
									if (weInput.getAttribute("type").contains(
											"checkbox")) {
										if (weInput.isSelected()) {
											weInput.click();
											Thread.sleep(3000);
										}
									}
								} catch (Exception e) {

								}
							}
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (count == 4) {
				break;
			}

		}
		Calendar cal2 = Calendar.getInstance();
		cal2.getTime();
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		// System.out.println(sdf2.format(cal2.getTime()));
	}

	// ******************************************************************************************************
	static void closingLegendWindowByRedCross() throws InterruptedException {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		// System.out.println(sdf.format(cal.getTime()));
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		boolean breakIt = false;
		// //// invert the list

		ArrayList<WebElement> array = new ArrayList<WebElement>();

		for (int i = divs.size() - 1; i >= 0; i--) {
			array.add(divs.get(i));
		}

		divs = array;
		// ////
		for (WebElement weDiv : divs) {

			if (weDiv.getAttribute("aria-labelledby") != null) {

				List<WebElement> spans = weDiv.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {
					if (weSpan.getText().equals("Legend")) {

						List<WebElement> as = weDiv.findElements(By
								.tagName("a"));
						for (WebElement weA : as) {
							try {
								if (weA.getAttribute("role").equals("button")) {
									weA.click();
									Thread.sleep(1000);
									breakIt = true;
									break;
								}
							} catch (Exception e) {
								// System.out.println("1");
							}
						}
						if (breakIt) {
							break;
						}
					}
				}

			}

			if (breakIt) {
				break;
			}
		}
		Calendar cal2 = Calendar.getInstance();
		cal2.getTime();
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		// System.out.println(sdf2.format(cal2.getTime()));
	}

	// ******************************************************************************************************
	static void clickOn_ViewRegionalLayers() throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		// //// invert the list

		ArrayList<WebElement> array = new ArrayList<WebElement>();

		for (int i = divs.size() - 1; i >= 0; i--) {
			array.add(divs.get(i));
		}

		divs = array;
		// ////
		for (WebElement weDiv : divs) {
			try {
				if (weDiv.getAttribute("title") != null) {
					if (weDiv.getAttribute("title").equals(
							"View regional layers")) {
						weDiv.click();
						Thread.sleep(1000);
						break;
					}
				}
			} catch (Exception e) {

			}
		}

	}

	// ******************************************************************************************************
	static void tesing_ViewRegionalLayers() throws InterruptedException {
		List<WebElement> inputs = driverChrome
				.findElements(By.tagName("input"));
		List<WebElement> checkedWeInouts = new ArrayList<WebElement>();
		for (WebElement weInput : inputs) {
			try {
				if (weInput.getAttribute("value") != null) {
					if (weInput.getAttribute("value").equals("dls_townships")
							|| weInput.getAttribute("value").equals(
									"dls_sections")
							|| weInput.getAttribute("value").equals(
									"dls_quarters")
							|| weInput.getAttribute("value").equals(
									"alberta_ecozones")
							|| weInput.getAttribute("value").equals(
									"alberta_ecodistricts")
							|| weInput.getAttribute("value").equals(
									"soil_temperature_map")
							|| weInput.getAttribute("value").equals(
									"rapideye_2012")
							|| weInput.getAttribute("value").equals(
									"rapideye_2013")
							|| weInput.getAttribute("value").equals(
									"rapideye_2014")
							|| weInput.getAttribute("value").equals(
									"rapideye_2015")) {
						checkedWeInouts.add(weInput);
						if (!weInput.isSelected()) {
							weInput.click();
						}
						Thread.sleep(1000);

					}
				}
			} catch (Exception e) {

			}
		}
		for (WebElement we : checkedWeInouts) {
			we.click();
			Thread.sleep(1000);

		}
		// /////////// hover over the blue ball
		System.out.println("Hover over the blue ball to get info");
		Thread.sleep(2000);
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {
				if (weSpan.getAttribute("data-original-title") != null) {
					if (weSpan.getAttribute("data-original-title").contains(
							"Shows the day of the year at which soil")) {
						action.moveToElement(weSpan).build().perform();
						Locatable locatable = (Locatable) weSpan;
						Coordinates coordinates = locatable.getCoordinates();
						Point point = coordinates.inViewPort();
						Robot robot = new Robot();
						robot.mouseMove(point.getX() + 5, point.getY() + 65);
						Thread.sleep(9000);
						robot.mouseMove(0, 0);
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// ///////////^^^^^^^^^^^^^^^^^^
	}

	// ******************************************************************************************************
	static void clickOn_CloseViewRegionalLayersByRedCross()
			throws InterruptedException {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		// System.out.println(sdf.format(cal.getTime()));
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		boolean breakIt = false;
		// //// invert the list

		ArrayList<WebElement> array = new ArrayList<WebElement>();

		for (int i = divs.size() - 1; i >= 0; i--) {
			array.add(divs.get(i));
		}

		divs = array;
		// ////
		for (WebElement weDiv : divs) {

			if (weDiv.getAttribute("aria-labelledby") != null) {

				List<WebElement> spans = weDiv.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {
					if (weSpan.getText().equals("Regional Layers")) {
						for (WebElement weSpan2 : spans) {
							if (weSpan2.getText().equals("close")) {
								weSpan2.click();
								breakIt = true;
								break;
							}
						}

						if (breakIt) {
							break;
						}
					}
				}

			}

			if (breakIt) {
				break;
			}
		}
		Calendar cal2 = Calendar.getInstance();
		cal2.getTime();
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		// System.out.println(sdf2.format(cal2.getTime()));
	}

	// ******************************************************************************************************
	static void clickOn_HideAllLayersOnMap() throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		for (WebElement weDiv : divs) {
			try {
				if (weDiv.getAttribute("title") != null) {
					if (weDiv.getAttribute("title").equals(
							"Hide all layers on map")) {
						weDiv.click();
						Thread.sleep(1000);
						break;
					}
				}
			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_ZomeIn() {
		List<WebElement> as = driverChrome.findElements(By.tagName("a"));
		for (WebElement weA : as) {
			try {
				if (weA.getAttribute("title") != null) {
					if (weA.getAttribute("title").equals("Zoom in")) {
						weA.click();
						Thread.sleep(1000);

					}
				}
			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_ZomeOut() {
		List<WebElement> as = driverChrome.findElements(By.tagName("a"));
		for (WebElement weA : as) {
			try {
				if (weA.getAttribute("title") != null) {
					if (weA.getAttribute("title").equals("Zoom out")) {
						weA.click();
						Thread.sleep(1000);

					}
				}
			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_MagnifyingGlassOnTopRightOfMap() {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		for (WebElement weDiv : divs) {
			try {
				if (weDiv.getAttribute("class") != null) {
					if (weDiv.getAttribute("class").equals(
							"leaflet-control-geocoder-icon")) {
						weDiv.click();
						Thread.sleep(1000);
						break;
					}
				}
			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void testing_MagnifyingGlassOnTopRightOfMap()
			throws InterruptedException {

		Thread.sleep(1000);
		action.sendKeys("SW 9-1-15 W3").build().perform();
		Thread.sleep(2000);

		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(6000);

		action.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();

		Thread.sleep(2000);
		action.sendKeys("50.1 -114.5").sendKeys(Keys.TAB)
				.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(2000);

		List<WebElement> inputs = driverChrome
				.findElements(By.tagName("input"));
		for (WebElement weInput : inputs) {
			try {
				if (weInput.getAttribute("placeholder") != null) {
					if (weInput.getAttribute("placeholder").contains(
							"e.g. 50.1 -114.5")) {
						weInput.click();
						Thread.sleep(500);
						action.sendKeys(Keys.ENTER).build().perform();
						Thread.sleep(6000);

					}
				}
			} catch (Exception e) {

			}
		}

		action.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();

		Thread.sleep(500);
		action.sendKeys("Lethbridge").sendKeys(Keys.TAB)
				.sendKeys(Keys.ARROW_LEFT).build().perform();
		Thread.sleep(2000);

		inputs = driverChrome.findElements(By.tagName("input"));
		for (WebElement weInput : inputs) {
			try {
				if (weInput.getAttribute("placeholder") != null) {
					if (weInput.getAttribute("placeholder").contains(
							"e.g. Calgary")) {
						weInput.click();
						Thread.sleep(500);
						action.sendKeys(Keys.ENTER).build().perform();
						Thread.sleep(6000);
						int countTime = 0;
						boolean breakIt = false;
						while (true) {
							List<WebElement> as = driverChrome.findElements(By
									.tagName("a"));
							for (WebElement a : as) {
								if (a.getText()
										.contains(
												"Lethbridge, City of Lethbridge, Alberta, Canada")) {
									action.sendKeys(Keys.TAB).build().perform();
									Thread.sleep(500);

									action.sendKeys(Keys.TAB).build().perform();
									Thread.sleep(500);

									action.sendKeys(Keys.ENTER).build()
											.perform();
									Thread.sleep(4000);
									breakIt = true;
									break;
								} else {
								}
								// Thread.sleep(1000);
								// countTime++;
							}
							if (breakIt || countTime == 30) {
								break;
							}
							Thread.sleep(1000);

						}
						Thread.sleep(500);

					}
				}
			} catch (Exception e) {

			}
		}
		Thread.sleep(2000);

		System.out
				.println("********    Let's have a look to Regional Layers    ********");
		Thread.sleep(1000);
		clickOn_ViewRegionalLayers();
		Thread.sleep(1000);
		tesing_ViewRegionalLayers();
		Thread.sleep(1000);
		clickOn_CloseViewRegionalLayersByRedCross();
		// Thread.sleep(1000);
	}

	// ******************************************************************************************************
	static void changingMapWinowSize() throws InterruptedException {
		boolean breakIt = false;

		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		System.out.println(divs.size());
		for (WebElement weDiv : divs) {
			if (weDiv.getAttribute("aria-labelledby") != null) {
				List<WebElement> spans = weDiv.findElements(By.tagName("span"));
				for (WebElement weSpan : spans) {
					if (weSpan.getText().equals("Map")) {

						action.clickAndHold(weSpan).build().perform();
						Thread.sleep(2000);
						action.moveByOffset(20, 0).build().perform();
						Thread.sleep(2000);
						action.release();
						Thread.sleep(2000);
						action.clickAndHold(weSpan).build().perform();
						Thread.sleep(2000);
						action.moveByOffset(0, 20).build().perform();
						Thread.sleep(2000);
						action.release();
						Thread.sleep(2000);
						action.clickAndHold(weSpan).build().perform();
						Thread.sleep(2000);
						action.moveByOffset(-20, 0).build().perform();
						Thread.sleep(2000);
						action.release();
						Thread.sleep(2000);
						action.clickAndHold(weSpan).build().perform();
						Thread.sleep(2000);
						action.moveByOffset(0, -20).build().perform();
						Thread.sleep(2000);
						action.release();
						breakIt = true;
						System.out.println(":)))");
						break;

					}
					if (breakIt) {
						break;
					}
				}
			}
			if (breakIt) {
				break;
			}
		}
		// action.dragAndDropBy(source, xOffset, yOffset)

	}

	// ******************************************************************************************************
	static void clickOn_Layers_icon() throws InterruptedException {
		List<WebElement> as = driverChrome.findElements(By.tagName("a"));
		boolean breakIt = false;
		while (true) {
			for (WebElement weA : as) {
				if (weA.getAttribute("title") != null) {
					try {
						if (weA.getAttribute("title").equals("Layers")) {
							weA.click();
							Thread.sleep(2000);
							breakIt = true;
							break;
						}
					} catch (Exception e) {
						System.out.println("**************");
						e.printStackTrace();
						System.out.println("**************");
					}
				}
			}
			if (breakIt) {
				break;
			}
			Thread.sleep(1000);
		}

	}

	// /////////

	// ******************************************************************************************************
	static void testing_Layers_WindowIteams() throws InterruptedException {
		// ////////// We do the code below to make sure that the element from
		// the new opened window is visible
		int times = 0;
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		boolean breakIt = false;
		while (true) {

			for (WebElement we : spans) {
				if (we.getText().contains("OpenStreetMap")) {
					breakIt = true;
					driverChrome.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					break;

				}
			}
			if (breakIt) {
				break;
			}
			if (times == 4) {
				times = 0;
				try {
					clickOn_Layers_icon();
					System.out
							.println("Oops!! It was either that bug of Selenium or the mouse was moved by you, now I will try to hover on layers icon again, as many times as it's opened properly, no worries :)");
					Thread.sleep(2000);
				} catch (Exception e) {
				}
			}
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			Thread.sleep(1000);
			times++;
		}
		// //////////////////// ^^^^^^^^^ We do the code above to make sure that
		// the element from the new opened window is visible
		// System.out.println(11111);
		spans = driverChrome.findElements(By.tagName("span"));
		breakIt = false;
		while (true) {
			int count = 0;
			for (WebElement weSpan : spans) {
				if (weSpan.getText() != null) {
					try {
						if (weSpan.getText().contains("MapQuest")
								|| weSpan.getText().contains("OpenStreetMap")
								|| weSpan.getText().contains("ESRI Aerial")
								|| weSpan.getText().contains("Google")
								|| weSpan.getText().contains("NRCan Toporama")
								|| weSpan.getText().contains("NRCan Landsat 7")
								|| weSpan.getText().contains("No Background")) {
							if (weSpan.getText().length() < 20) {
								System.out.println(weSpan.getText()
										+ " - checked");
							}
							action.moveToElement(weSpan).build().perform();
							Thread.sleep(500);
							action.click().build().perform();
							Thread.sleep(2000);

							count++;
						}
					} catch (Exception e) {
						System.out.println("==");
						e.printStackTrace();
						System.out.println("==");
					}
				}
				if (count == 7) {
					breakIt = true;
					break;
				}
			}
			if (breakIt) {
				break;

			} else {
				System.out
						.println("Oops!! It was either that bug of Selenium or the mouse was moved by you, now I will try to hover on layers icon again, as many times as it's opened properly, no worries :)");
				try {
					clickOn_Layers_icon();
				} catch (Exception e) {

				}
				Thread.sleep(1000);
			}
		}
		// /// back to ESRI Arial
		for (WebElement weSpan : spans) {
			if (weSpan.getText() != null) {
				try {
					if (weSpan.getText().contains("ESRI Aerial")) {
						System.out.println("Back To -> " + weSpan.getText());
						action.moveToElement(weSpan).build().perform();
						Thread.sleep(2000);
						action.click().build().perform();
						Thread.sleep(1000);

					}
				} catch (Exception e) {
					System.out.println("==");
					e.printStackTrace();
					System.out.println("==");
				}
			}
		}

	}

	// ******************************************************************************************************
	public static void clickOn_BigMapLayout() throws InterruptedException {
		List<WebElement> as = driverChrome.findElements(By.tagName("a"));
		boolean breakIt = false;
		while (true) {
			for (WebElement weA : as) {
				if (weA.getAttribute("title") != null) {
					try {
						if (weA.getAttribute("title").contains(
								"Predefined window layout with large map")) {
							weA.click();
							Thread.sleep(1000);
							breakIt = true;
							break;
						}
					} catch (Exception e) {// there should be a better way :)
						// e.printStackTrace();
						clickOn_PAM();
						Thread.sleep(1000);
						clickOn_Window_FromPamMenu();
						Thread.sleep(2000);

					}
				}
			}
			if (breakIt) {
				break;
			}
		}
	}

	// ******************************************************************************************************
	public static void rightClickOnABarn() throws InterruptedException {
		List<WebElement> imgs = driverChrome.findElements(By.tagName("img"));
		for (WebElement weImg : imgs) {
			try {// leaflet-marker-icon leaflet-zoom-hide leaflet-clickable
				if (weImg.getAttribute("src").contains("pam/static/icons/barn")
						&& weImg.getAttribute("class")
								.contains(
										"leaflet-marker-icon leaflet-zoom-hide leaflet-clickable")) {
					try {// try is needed because some Elementa are not
							// clickable at
							// point (x, y). Other element would receive the
							// click
							// System.out.println("=>" +
							// weImg.getAttribute("src"));
						// System.out.println("???x" + weImg.getLocation().x);
						// System.out.println("???y" + weImg.getLocation().y);
						// action.click(weImg).build().perform();
						// weImg.click();
						Thread.sleep(1000);
						action.contextClick(weImg).build().perform();
						Thread.sleep(3000);

						break;
					} catch (Exception e) {
						// e.printStackTrace();
						// System.out.println(123);
					}
				}
			} catch (Exception e) {
				// System.out.println(456);
				// e.printStackTrace();
				// System.out.println("see I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	public static void clickOn_ZoomToOnMap_FromRightClickOnItemsOnMap()
			throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Zoom To On Map")) {
					weSpan.click();
					Thread.sleep(1000);

				}

			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	public static void clickOn_LoadFields_FromRightClickOnItemsOnMap()
			throws InterruptedException {

		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {

			if (weSpan.getText().equals("Load Fields")) {
				try {
					weSpan.click();
					break;
				} catch (Exception e) {
					System.out.println(111111);
					e.printStackTrace();
				}

			}

			// try {
			// if (breakIt) {
			// break;
			// }
			// if (weSpan.getText().equals("Load Fields")) {
			// weSpan.click();
			// System.out
			// .println("Waiting For the Fields To Load Completely");
			// Thread.sleep(1000);
			// try {
			// driverChrome.switchTo().alert().accept();
			// Thread.sleep(5000);
			// action.sendKeys(Keys.ENTER).build().perform();
			// Thread.sleep(2000);
			//
			// System.out.println(1111);
			//
			// driverChrome.manage().timeouts()
			// .implicitlyWait(3, TimeUnit.SECONDS);
			// List<WebElement> gs = driverChrome.findElements(By
			// .tagName("g"));
			// if (gs.size() > 1) {
			// System.out.println(2222);
			// break;
			// } else {
			// System.out.println(3333);
			// rightClickOnABarn();
			// Thread.sleep(1000);
			// clickOn_LoadFields_FromRightClickOnItemsOnMap();
			// Thread.sleep(1000);
			// }
			//
			// } catch (Exception e) {
			//
			// breakIt = true;
			// }
			// }
			//
			// } catch (Exception e) {
			// e.printStackTrace();
			// System.out.println(4444);
			// }
		}
		System.out.println("Waiting For the Fields To Load Completely");
		while (true) {

			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			List<WebElement> gs = driverChrome.findElements(By.tagName("g"));
			if (gs.size() > 1) {
				driverChrome.manage().timeouts()
						.implicitlyWait(30, TimeUnit.SECONDS);
				Thread.sleep(2000);
				break;
			} else {
				Thread.sleep(3000);
			}
		}

	}

	// ******************************************************************************************************
	static public void closingAllPAMBars() throws InterruptedException {

		driverChrome.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		List<WebElement> abbrs = driverChrome.findElements(By.tagName("abbr"));

		for (WebElement weAbbr : abbrs) {
			try {

				if (weAbbr.getAttribute("class") != null) {

					if (weAbbr.getAttribute("class").equals(
							"search-choice-close")) {
						weAbbr.click();

						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("-->");
				e.printStackTrace();
			}
		}
		driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// ******************************************************************************************************
	static public void goToThisPlace(String place) throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		boolean breakIt = false;
		for (WebElement weSpan : spans) {
			if (weSpan.getText().contains("Select an Asset")) {
				weSpan.click();
				Thread.sleep(1000);
				List<WebElement> selects = driverChrome.findElements(By
						.tagName("select"));
				for (WebElement weSelect : selects) {
					if (weSelect.getAttribute("data-placeholder") != null) {
						try {
							if (weSelect.getAttribute("data-placeholder")
									.contains("Select an Asset")) {
								action.sendKeys(place).build().perform();
								Thread.sleep(500);
								action.sendKeys(Keys.ENTER).build().perform();
								Thread.sleep(500);
								// System.out.println("WEST :)");
								Thread.sleep(500);
								breakIt = true;
								break;
							}
						} catch (Exception e) {
							Thread.sleep(3000);
							closingAllPAMBars();
							System.out.println("goToThisPlace==>");
							e.printStackTrace();
						}
					}
				}
			}
			if (breakIt) {
				break;
			}
		}
	}

	// ******************************************************************************************************
	public static void clickOn_MoveFarm_FromRightClickOnABarnOnMap()
			throws InterruptedException {

		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Move Farm")) {
					weSpan.click();
					Thread.sleep(1000);
					List<WebElement> imgs = driverChrome.findElements(By
							.tagName("img"));
					for (WebElement weImg : imgs) {
						try {
							if (weImg.getAttribute("src").contains(
									"/pam/static/icons/blueBarn.png")) {

								try {// try is needed because some Elementa are
										// not
										// clickable at
										// point (x, y). Other element would
										// receive the
										// click
									// ////////////////////

									RemoteTest RemoteTest = new RemoteTest();
									URL imageURL = RemoteTest.getClass()
											.getResource("bluebarn.PNG");

									BufferedImage imageBuffered = ImageIO
											.read(imageURL);

									ImageIO.write(imageBuffered, "png",
											new File("blue.png"));
									Thread.sleep(3000);
									// ////////////////////////////////

									Screen screen = new Screen();
									Pattern img1 = new Pattern("blue.PNG");

									Pattern drop = new Pattern("blue.PNG");
									Point point = weImg.getLocation();
									screen.dragDrop(img1, drop.targetOffset(
											-(point.x / 2), 0));
									screen.wait(img1, 3);
									screen.dragDrop(img1,
											drop.targetOffset((point.x / 2), 0));
									Thread.sleep(5000);
									screen.doubleClick(img1);

									break;
								} catch (Exception e) {
									e.printStackTrace();
									System.out
											.println("see IIIIIIIIIII told you :)");
								}
							}
						} catch (Exception e) {
							e.printStackTrace();
							System.out.println("see I told you :)");
						}
					}
				}

			} catch (Exception e) {
				// e.printStackTrace();
				// System.out.println("seeeeeeeeeeee I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	public static void clickOn_ShowAttributes_FromRightClickOnItemsOnMap()
			throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Show Attributes")) {
					weSpan.click();

					Thread.sleep(2000);
					break;

				}

			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	public static void testing_ShowAttributes(String name)
			throws InterruptedException {
		try {
			driverChrome.switchTo().alert().accept();
			Thread.sleep(5000);
			action.sendKeys(Keys.ENTER).build().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out
					.println("Change Attribute Order From Default To Alphabetical");
			boolean breakIt = false;
			Thread.sleep(2000);
			action.sendKeys(Keys.ARROW_DOWN).build().perform();
			Thread.sleep(1000);
			List<WebElement> divs = driverChrome
					.findElements(By.tagName("div"));

			// //// invert the list

			ArrayList<WebElement> array = new ArrayList<WebElement>();

			for (int i = divs.size() - 1; i >= 0; i--) {
				array.add(divs.get(i));
			}

			divs = array;
			// //// closing by red cross
			System.out
					.println("Map Window Testing: Closing Show Attribute Window By Red Cross");
			Thread.sleep(1000);
			breakIt = false;
			divs = driverChrome.findElements(By.tagName("div"));
			for (WebElement weDiv : divs) {
				if (weDiv.getAttribute("aria-labelledby") != null) {
					List<WebElement> spans = weDiv.findElements(By
							.tagName("span"));
					for (WebElement weSpan : spans) {
						if (weSpan.getText().equals(name)) {
							List<WebElement> as = weDiv.findElements(By
									.tagName("a"));
							for (WebElement weA : as) {
								try {
									if (weA.getAttribute("role").contains(
											"button")) {
										weA.click();
										Thread.sleep(2000);
										breakIt = true;
										break;
									}
								} catch (Exception e2) {
									// System.out.println("see I told you :)");
								}
							}
						}
						if (breakIt) {
							break;
						}
					}
					if (breakIt) {
						break;
					}
				}
			}

			//
			// try {
			// for (WebElement weDiv : divs) {
			//
			// if (weDiv.getAttribute("aria-labelledby") != null) {
			// List<WebElement> labels = weDiv.findElements(By
			// .tagName("label"));
			//
			// for (WebElement weLabel : labels) {
			// if (weLabel.getText() != null) {
			// if (weLabel.getText()
			// .equals("Attribute Order:")) {
			// List<WebElement> inputs = weDiv
			// .findElements(By.tagName("input"));
			// for (WebElement weInput : inputs) {
			// if (weInput.getAttribute("value")
			// .equals("Submit")) {
			// System.out
			// .println("Click On Submit Button");
			// Thread.sleep(2000);
			// weInput.click();
			//
			// Thread.sleep(1000);
			// breakIt = true;
			// break;
			// }
			// }
			// }
			// }
			// if (breakIt) {
			// break;
			// }
			// }
			// }
			// if (breakIt) {
			// break;
			// }
			// }
			// // //////
			//
			// rightClickOnABarn();
			// Thread.sleep(1000);
			//
			// clickOn_ShowAttributes_FromRightClickOnItemsOnMap();
			// Thread.sleep(2000);
			//
			// // ////// click on cancel
			// breakIt = false;
			// divs = driverChrome.findElements(By.tagName("div"));
			//
			// // //// invert the list
			//
			// array = new ArrayList<WebElement>();
			//
			// for (int i = divs.size() - 1; i >= 0; i--) {
			// array.add(divs.get(i));
			// }
			//
			// divs = array;
			// // ////
			// for (WebElement weDiv : divs) {
			//
			// if (weDiv.getAttribute("aria-labelledby") != null) {
			// List<WebElement> labels = weDiv.findElements(By
			// .tagName("label"));
			//
			// for (WebElement weLabel : labels) {
			// if (weLabel.getText().equals("Attribute Order:")) {
			// List<WebElement> buttons = weDiv
			// .findElements(By.tagName("button"));
			// for (WebElement weButton : buttons) {
			// if (weButton.getText().equals("Cancel")) {
			// System.out
			// .println("Click On Cancel Button");
			// Thread.sleep(2000);
			// weButton.click();
			// Thread.sleep(1000);
			//
			// breakIt = true;
			// break;
			// }
			// }
			// }
			// if (breakIt) {
			// break;
			// }
			// }
			//
			// }
			// if (breakIt) {
			// break;
			// }
			// }
			//
			// // //// ^^^^^
			// } catch (Exception e1) {
			// e1.printStackTrace();
			// }
		}

	}

	// ******************************************************************************************************
	public static void clickOn_ViewDocuments_FromRightClickOnItemsOnMap()
			throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("View Documents")) {
					weSpan.click();
					Thread.sleep(1000);
				}

			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	public static void clickOn_AddEvent_FromRightClickOnItemsOnMap()
			throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Add Event")) {
					weSpan.click();
					Thread.sleep(1000);
				}

			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static public void testing_AddEvent() throws InterruptedException,
			AWTException {

		// ////// we get the computer time

		Calendar cal = Calendar.getInstance();

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String[] year_Month_day = sdf.format(cal.getTime()).split("/");
		String year = year_Month_day[0];
		String month = year_Month_day[1];
		String day = year_Month_day[2];

		// System.out.println(year);
		// System.out.println(month);// we should do for mounth as we did for
		// day
		// System.out.println(day);

		if (Integer.parseInt(day) == 1 || Integer.parseInt(day) == 2
				|| Integer.parseInt(day) == 3 || Integer.parseInt(day) == 4) {
			day = Integer.toString((Integer.parseInt(day) + 3));
		} else {
			day = Integer.toString((Integer.parseInt(day) - 1));
		}

		if (Integer.parseInt(month) == 1) {
			day = Integer.toString((Integer.parseInt(day) + 1));
		}

		// /////////////////^^^^^^^^^^^^
		Random rand = new Random();

		int randomNum = rand.nextInt(10) + 10;
		action.sendKeys("Testing Event Name").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		action.sendKeys("Testing Description").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		action.sendKeys("Testing Event Type").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		// //////////////////// Testing Start Date
		// String month = Integer.toString(randomNum);
		action.sendKeys(month).build().perform();
		Thread.sleep(1000);

		// rand = new Random();
		// randomNum = rand.nextInt(10) + 10;
		// String day = Integer.toString(randomNum);
		action.sendKeys(day).build().perform();
		Thread.sleep(1000);

		// rand = new Random();
		// randomNum = rand.nextInt(5) + 10;
		// String year = "2015";// Integer.toString(randomNum + 2000);
		action.sendKeys(year).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Keys.ARROW_RIGHT).build().perform();
		Thread.sleep(1000);
		// rand = new Random();
		int hour = rand.nextInt(5) + 2;

		action.sendKeys(Integer.toString(hour)).build().perform();
		Thread.sleep(1000);
		// rand = new Random();
		// randomNum = rand.nextInt(10) + 10;
		int minute = rand.nextInt(10) + 10;
		action.sendKeys(Integer.toString(minute)).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);

		List<WebElement> inputs = driverChrome.findElements(By.id("id_Start"));
		for (WebElement weInput : inputs) {
			try {
				if (weInput.getAttribute("type") != null) {
					if (weInput.getAttribute("type").equals("datetime-local")) {
						Dimension dimension = weInput.getSize();
						action.moveToElement(weInput, 0, 0).build().perform();
						Thread.sleep(500);
						action.moveByOffset(
								(dimension.width) - (dimension.height / 2),
								(dimension.height / 2)).build().perform();
						Thread.sleep(500);
						action.click().build().perform();
						Thread.sleep(500);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						Thread.sleep(1000);
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ENTER).build().perform();
						Thread.sleep(1000);
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("testing_AddEvent");
				e.printStackTrace();
			}
		}
		// /////////////
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(500);
		// ///////////// Testing End Date
		action.sendKeys(month).build().perform();
		Thread.sleep(1000);

		action.sendKeys(day).build().perform();
		Thread.sleep(1000);

		action.sendKeys(year).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Keys.ARROW_RIGHT).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Integer.toString(hour + 1)).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Integer.toString(minute + 4)).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);

		inputs = driverChrome.findElements(By.id("id_End"));
		for (WebElement weInput : inputs) {
			try {
				if (weInput.getAttribute("type") != null) {
					if (weInput.getAttribute("type").equals("datetime-local")) {
						Dimension dimension = weInput.getSize();
						action.moveToElement(weInput, 0, 0).build().perform();
						Thread.sleep(500);
						action.moveByOffset(
								(dimension.width) - (dimension.height / 2),
								(dimension.height / 2)).build().perform();
						Thread.sleep(500);
						action.click().build().perform();
						Thread.sleep(500);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						Thread.sleep(1000);
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ENTER).build().perform();
						Thread.sleep(1000);
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("testing_AddEvent");
				e.printStackTrace();
			}
		}
		// ///////////////
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(500);
		// ////////////// Testing Repeat
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(500);
		// /////////////////
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(500);
		// ////////////////// Testing End of Repeat
		action.sendKeys(month).build().perform();
		Thread.sleep(1000);

		action.sendKeys(day).build().perform();
		Thread.sleep(1000);

		action.sendKeys(year).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Keys.ARROW_RIGHT).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Integer.toString(hour + 1)).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Integer.toString(minute + 4)).build().perform();
		Thread.sleep(1000);

		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(1000);

		inputs = driverChrome.findElements(By.id("id_Endrepeat"));
		for (WebElement weInput : inputs) {
			try {
				if (weInput.getAttribute("type") != null) {
					if (weInput.getAttribute("type").equals("datetime-local")) {
						Dimension dimension = weInput.getSize();
						action.moveToElement(weInput, 0, 0).build().perform();
						Thread.sleep(500);
						action.moveByOffset(
								(dimension.width) - (dimension.height / 2),
								(dimension.height / 2)).build().perform();
						Thread.sleep(500);
						action.click().build().perform();
						Thread.sleep(500);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_DOWN).build().perform();
						Thread.sleep(1000);
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ARROW_UP).build().perform();
						Thread.sleep(1000);
						action.sendKeys(Keys.ENTER).build().perform();
						Thread.sleep(1000);
						break;
					}
				}
			} catch (Exception e) {
				System.out.println("testing_AddEvent");
				e.printStackTrace();
			}
		}
		// /////////////////
		action.sendKeys(Keys.TAB).build().perform();
		// ///////////////// Testing Notification
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ARROW_UP).build().perform();
		Thread.sleep(500);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(500);
		// //////////////////
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(500);
		// //////////////////
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		System.out.println("*****    Let's remove one of them    *****");
		Thread.sleep(2000);
		WebElement div = driverChrome.findElement(By.id("s2id_id_whoToNotify"));
		List<WebElement> as = div.findElements(By
				.className("select2-search-choice-close"));
		for (WebElement weA : as) {
			try {
				weA.click();
				Thread.sleep(1000);
				// JavascriptExecutor jse = (JavascriptExecutor) driverChrome;
				// jse.executeScript("window.scrollTo(0,500)", "");
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys("West").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		// //////
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys("Outlook").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		// //////
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys("Cypress").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		action.sendKeys("Smith seeds").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		action.sendKeys("Smith Land and Cattle").build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		WebElement weFinished = driverChrome.findElement(By.id("id_Finished"));
		action.click(weFinished).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(4000);
	}

	// ******************************************************************************************************
	public static void clickOn_ViewEvents_FromRightClickOnItemsOnMap()
			throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("View Events")) {
					weSpan.click();
					Thread.sleep(1000);
				}

			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	public static void clickOn_AssetCount_FromRightClickOnItemsOnMap()
			throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Asset Count")) {
					weSpan.click();
					Thread.sleep(1000);
				}

			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	public static void clickOn_AddEditNotes_FromRightClickOnItemsOnMap()
			throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Add/Edit Notes")) {
					weSpan.click();
					Thread.sleep(1000);
				}
			} catch (Exception e) {
			}
		}
	}

	// ******************************************************************************************************
	public static void testing_AddEditNotes() throws InterruptedException {

		action.sendKeys("Testing Add/Edit Notes").build().perform();

		List<WebElement> buttons = driverChrome.findElements(By
				.tagName("button"));
		for (WebElement weButton : buttons) {
			try {

				if (weButton.getText().equals("Comment")) {
					weButton.click();
					Thread.sleep(3000);
				}
			} catch (Exception e) {

			}
		}

		// /////////////////////////////////////////////// EDIT NOTE
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		// //// invert the list
		ArrayList<WebElement> array = new ArrayList<WebElement>();
		for (int i = divs.size() - 1; i >= 0; i--) {
			array.add(divs.get(i));
		}
		divs = array;
		// //// ^^^^ invert the list

		for (WebElement weDiv : divs) {
			try {

				if (weDiv.getText().equals("Testing Add/Edit Notes")) {
					action.contextClick(weDiv).build().perform();
					Thread.sleep(3000);
					List<WebElement> spans = driverChrome.findElements(By
							.tagName("span"));
					for (WebElement weSpan : spans) {
						try {

							if (weSpan.getText().equals("Edit Note")) {
								weSpan.click();
								Thread.sleep(1000);
								action.click().build().perform();
								Thread.sleep(1000);
								action.click().build().perform();
								Thread.sleep(1000);
								action.sendKeys(Keys.chord((Keys.CONTROL), "a"))
										.build().perform();
								// Robot robot = new Robot();
								// robot.keyPress(KeyEvent.VK_CONTROL);
								// robot.keyPress(KeyEvent.VK_A);
								// robot.keyRelease(KeyEvent.VK_A);
								// robot.keyRelease(KeyEvent.VK_CONTROL);
								Thread.sleep(1000);
								action.sendKeys("Testing Edit Note").build()
										.perform();
								Thread.sleep(1000);
								List<WebElement> buttons2 = driverChrome
										.findElements(By.id("saveButton"));
								for (WebElement weButton2 : buttons2) {
									try {

										if (weButton2.getText().equals("Save")) {
											weButton2.click();
											Thread.sleep(3000);
										}
									} catch (Exception e) {

									}
								}
							}
						} catch (Exception e) {
						}
					}
					//
					break;
				}
			} catch (Exception e) {
			}
		}
		// /////////////////////////////////////////^^^^^^^^^^^^^^^^^^^ Edit
		// Note

		// ///////////////////////////////////////// Delete Note

		divs = driverChrome.findElements(By.tagName("div"));
		int count = 0;
		for (WebElement weDiv : divs) {
			try {
				if (weDiv.getText().contains("Testing Edit Note")
						&& weDiv.getAttribute("id").equals("noteContent")) {
					count++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		for (int i = 0; i < count; i++) {
			deleteNote();
		}
		Thread.sleep(2000);
		// }
		// ///////////////////////////////////////// ^^^^^^^^^^^^^^^^^^^^^^^^^
		// Delete Note
	}

	// ******************************************************************************************************
	public static void deleteNote() throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		// //// invert the list
		ArrayList<WebElement> array = new ArrayList<WebElement>();
		for (int i = divs.size() - 1; i >= 0; i--) {
			array.add(divs.get(i));
		}
		divs = array;
		// ////

		boolean breakIt = false;
		for (WebElement weDiv : divs) {
			try {

				if (weDiv.getText().contains("Testing Edit Note")
						&& weDiv.getAttribute("id").equals("noteContent")) {

					action.contextClick(weDiv).build().perform();
					Thread.sleep(3000);
					List<WebElement> spans = driverChrome.findElements(By
							.tagName("span"));
					for (WebElement weSpan : spans) {
						try {

							if (weSpan.getText().equals("Delete Note")) {
								weSpan.click();
								Thread.sleep(1000);
								driverChrome.switchTo().alert().accept();
								Thread.sleep(5000);
								Thread.sleep(2000);
								action.sendKeys(Keys.ENTER).build().perform();
								Thread.sleep(2000);
								Thread.sleep(2000);
								breakIt = true;
								break;

							}
						} catch (Exception e) {

							continue;
						}
					}
					//

				}

			} catch (Exception e) {

				continue;
			}
			if (breakIt) {
				break;
			}
		}
	}

	// ******************************************************************************************************
	public static void closeAddEditNotesByRedCross(String title)
			throws InterruptedException {
		Calendar cal = Calendar.getInstance();
		cal.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		// System.out.println(sdf.format(cal.getTime()));
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		boolean breakIt = false;
		// //// invert the list

		ArrayList<WebElement> array = new ArrayList<WebElement>();

		for (int i = divs.size() - 1; i >= 0; i--) {
			array.add(divs.get(i));
		}

		divs = array;
		// ////
		for (WebElement weDiv : divs) {

			if (weDiv.getAttribute("aria-labelledby") != null) {

				List<WebElement> spans = weDiv.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {
					if (weSpan.getText().equals(title)) {
						for (WebElement weSpan2 : spans) {
							if (weSpan2.getText().equals("close")) {
								weSpan2.click();
								breakIt = true;
								break;
							}
						}

						if (breakIt) {
							break;
						}
					}
				}

			}

			if (breakIt) {
				break;
			}
		}
		Calendar cal2 = Calendar.getInstance();
		cal2.getTime();
		SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm:ss");
		// System.out.println(sdf2.format(cal2.getTime()));
	}

	// ******************************************************************************************************
	public static void rightClickOnALoadedField() throws InterruptedException {

		List<WebElement> gs = driverChrome.findElements(By.tagName("g"));
		try {
			action.contextClick(gs.get(gs.size() - 2)).build().perform();
		} catch (Exception e) {
			action.contextClick(gs.get(gs.size() - 1)).build().perform();
		}

	}

	// ******************************************************************************************************
	public static void isMapLoaded() throws InterruptedException {

		// // waiting for the first page to come up
		// WebDriverWait wait = new WebDriverWait(driverChrome, 100);
		// wait.until(ExpectedConditions.)

		// //

		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		int i = 0;
		while (true) {
			boolean breakIt = true;
			System.out
					.println("Waiting for map to load completely and applying some default settings, thanks for your patience.");
			for (WebElement weDiv : divs) {
				// System.out.println(i+++"==>"+weDiv.getText());
				try {
					// System.out.println(i+++"==>"+weDiv.getText());
					if (weDiv.getText().equals("Loading")) {
						// Thread.sleep(2000);
						// System.out.println(3);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = false;
						break;
					}
				} catch (Exception e) {
				}
			}
			if (breakIt) {
				break;
			} // System.out.println(i+++"==>"+weDiv2.getText());
			driverChrome.manage().timeouts()
					.implicitlyWait(5, TimeUnit.SECONDS);

			divs = driverChrome.findElements(By.tagName("div"));

		}
	}

	// ******************************************************************************************************
	static void clickOn_AddABoundaryToTheMap() throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getAttribute("class").contains(
						"pam-icon-addBoundary toolbar-button-icon")) {
					we.click();
					Thread.sleep(1000);
					break;
				}

			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void testingBoundaryToTheMap() throws InterruptedException,
			IOException, FindFailed {

		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		for (WebElement we : divs) {
			try {
				if (we.getAttribute("id").contains("leaflet-map")) {
					Dimension dimension = we.getSize();

					action.moveToElement(we, 4 * (dimension.width) / 8,
							4 * (dimension.height) / 8).click().build()
							.perform();
					Thread.sleep(1000);

					action.moveToElement(we, (5 * (dimension.width) / 8),
							(3 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);

					action.moveToElement(we, (6 * (dimension.width) / 8),
							(3 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);

					action.moveToElement(we, (7 * (dimension.width) / 8),
							(4 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);

					action.moveToElement(we, (7 * (dimension.width) / 8),
							(5 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					action.moveToElement(we, (6 * (dimension.width) / 8),
							(6 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					action.moveToElement(we, (5 * (dimension.width) / 8),
							(6 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					action.moveToElement(we, (4 * (dimension.width) / 8),
							(5 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					action.moveToElement(we, (4 * (dimension.width) / 8),
							(4 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {

			}
		}

		// /////////////////// We do the code below to make sure
		// that
		// the element from the new opened window is visible
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		boolean breakIt = false;
		while (true) {

			for (WebElement weSpan : spans) {

				if (weSpan.getText().equals("Add Boundary")) {

					Thread.sleep(1000);
					driverChrome.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					breakIt = true;
					break;

				}
			}
			if (breakIt) {
				break;
			}
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			Thread.sleep(1000);

		}
		// //////////////////// ^^^^^^^^^ We do the code above to make sure
		// that
		// the element from the new opened window is visible

		String uniqueID = UUID.randomUUID().toString();
		action.sendKeys("Testing_Add_Boundary_" + uniqueID).build().perform();
		Thread.sleep(1000);
		action.sendKeys(Keys.TAB).build().perform();
		System.out.println("Click on Add Boundary");
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Thread.sleep(2000);
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary");
		Thread.sleep(2000);
		List<WebElement> paths = driverChrome.findElements(By.tagName("path"));

		action.contextClick(paths.get(paths.size() - 1)).build().perform();
		// ///////////////////////// click on Edit Boundary
		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Edit Boundary")) {
					System.out.println("Click on Edit Boundary");
					Thread.sleep(1000);
					we.click();
					Thread.sleep(1000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// //////////// moving squares
		try {
			// ////////////////////
			System.out.println("Dragging one of those squares");

			RemoteTest RemoteTest = new RemoteTest();
			URL imageURL = RemoteTest.getClass().getResource("corner.PNG");

			BufferedImage imageBuffered = ImageIO.read(imageURL);

			ImageIO.write(imageBuffered, "png", new File("corner.png"));
			Thread.sleep(3000);
			// ////////////////////////////////

			Screen screen = new Screen();
			Pattern img1 = new Pattern("corner.PNG");

			Pattern drop = new Pattern("corner.PNG");

			screen.dragDrop(img1, drop.targetOffset(-100, -100));

			// screen.wait(img1, 3);
			Thread.sleep(2000);
			screen.dragDrop(img1, drop.targetOffset(200, 200));
		} catch (Exception e) {
			try {
				System.out.println(111);
				RemoteTest RemoteTest = new RemoteTest();
				URL imageURL = RemoteTest.getClass().getResource("leftCorner.png");

				BufferedImage imageBuffered = ImageIO.read(imageURL);

				ImageIO.write(imageBuffered, "png", new File("leftCorner.png"));
				Thread.sleep(3000);
				// ////////////////////////////////

				Screen screen = new Screen();
				Pattern img1 = new Pattern("leftCorner.png");

				Pattern drop = new Pattern("leftCorner.png");

				screen.dragDrop(img1, drop.targetOffset(-100, -100));
				Thread.sleep(2000);
				screen.dragDrop(img1, drop.targetOffset(200, 200));
				// screen.wait(img1, 3);
				Thread.sleep(2000);
			} catch (Exception e3) {
				e.printStackTrace();
			}
		}
		// // //////////////// we get all white squares
		divs = driverChrome.findElements(By.tagName("div"));
		List<WebElement> neededDivs = new ArrayList<WebElement>();
		for (WebElement weDiv : divs) {
			try {
				if (weDiv
						.getAttribute("class")
						.equals("leaflet-marker-icon leaflet-div-icon leaflet-editing-icon leaflet-zoom-hide leaflet-clickable leaflet-marker-draggable")) {
					neededDivs.add(weDiv);
				}
			} catch (Exception e) {

			}
		}
		// System.out.println(neededDivs.size());
		// // ////////
		System.out
				.println("Click on one the brighter squares (which cuts some part of the area)");
		Thread.sleep(5000);
		int i = 0;
		while (true) {
			try {
				neededDivs.get(i).click();
				Thread.sleep(2000);
				break;
			} catch (Exception e) {
				i++;
			}
		}
		// // /// we get all white squares
		divs = driverChrome.findElements(By.tagName("div"));
		neededDivs.clear();
		for (WebElement weDiv : divs) {
			try {
				if (weDiv
						.getAttribute("class")
						.equals("leaflet-marker-icon leaflet-div-icon leaflet-editing-icon leaflet-zoom-hide leaflet-clickable leaflet-marker-draggable")) {

					neededDivs.add(weDiv);
				}
			} catch (Exception e) {

			}
		}
		// // //////
		// System.out.println(neededDivs.size());
		System.out
				.println("Click on one the darker squares (which generates two more squares on its sides)");
		Thread.sleep(5000);
		i = 9;
		while (true) {
			try {
				neededDivs.get(i).click();
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				i++;
			}
		}
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary");
		Thread.sleep(2000);
		paths = driverChrome.findElements(By.tagName("path"));

		action.contextClick(paths.get(paths.size() - 1)).build().perform();
		// ////////// click on cancle edit

		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Cancel Edit")) {
					System.out.println("Click On Cancel Edit");
					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary");
		Thread.sleep(2000);
		paths = driverChrome.findElements(By.tagName("path"));
		Thread.sleep(1000);
		action.contextClick(paths.get(paths.size() - 1)).build().perform();
		// //////////////////////// click on Edit Boundary
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Edit Boundary")) {
					System.out.println("Click on Edit Boundary");
					Thread.sleep(1000);
					we.click();
					Thread.sleep(1000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary");
		Thread.sleep(2000);
		paths = driverChrome.findElements(By.tagName("path"));

		action.contextClick(paths.get(paths.size() - 1)).build().perform();
		// ////////// click on finish edit

		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Finish Edit")) {
					System.out.println("Click On Finish Edit");
					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary");
		Thread.sleep(2000);
		paths = driverChrome.findElements(By.tagName("path"));

		action.contextClick(paths.get(paths.size() - 1)).build().perform();
		// ////////// click on rename

		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Rename Boundary")) {
					System.out.println("Click On Rename Boundary");
					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// /////////////////// We do the code below to make sure
		// that
		// the element from the new opened window is visible
		spans = driverChrome.findElements(By.tagName("span"));
		breakIt = false;
		while (true) {

			for (WebElement weSpan : spans) {

				if (weSpan.getText().equals("Rename Boundary")) {

					Thread.sleep(1000);
					driverChrome.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					breakIt = true;
					break;
				}
			}
			if (breakIt) {
				break;
			}
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			Thread.sleep(1000);

		}
		// //////////////////// ^^^^^^^^^ We do the code above to make sure
		// that
		// the element from the new opened window is visible
		// // ////////////////////// click on the boundary area
		action.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
		Thread.sleep(1000);
		action.sendKeys("Testing_Rename_" + uniqueID).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.TAB).build().perform();
		System.out.println("Click on Submit");
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Thread.sleep(2000);
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary");
		Thread.sleep(2000);
		paths = driverChrome.findElements(By.tagName("path"));

		action.contextClick(paths.get(paths.size() - 1)).build().perform();
		// ///////////////////////// click on Zoom To On Map
		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Zoom To On Map")) {
					System.out.println("Click On Zoom To On Map");
					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}

		System.out
				.println("Clicking inside the boundary area which shows the dedicated name to it");
		paths = driverChrome.findElements(By.tagName("path"));

		action.click(paths.get(paths.size() - 1)).build().perform();
		Thread.sleep(2000);
		// ///////////////////////
	}

	// ******************************************************************************************************
	static void removeBackGround() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.mouseMove(0, 0);
		clickOn_Layers_icon();
		// Thread.sleep(2000);
		int times = 0;
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		// //// invert the list
		ArrayList<WebElement> array = new ArrayList<WebElement>();

		for (int i = spans.size() - 1; i >= 0; i--) {
			array.add(spans.get(i));
		}

		spans = array;
		// ////
		boolean breakIt = false;
		while (true) {

			for (WebElement we : spans) {
				if (we.getText().contains("OpenStreetMap")) {
					driverChrome.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					breakIt = true;
					break;
				}
			}
			if (breakIt) {
				break;
			}
			if (times == 2) {
				times = 0;
				try {
					System.out
							.println("Oops!! It was either that bug of Selenium or the mouse was moved by you, now I will try to hover on layers icon again, as many times as it's opened properly, no worries :)");
					Thread.sleep(1000);
					robot.mouseMove(0, 0);
					clickOn_Layers_icon();
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			Thread.sleep(1000);
			times++;
		}
		// //////////////////// ^^^^^^^^^ We do the code above to make sure that
		// the element from the new opened window is visible

		spans = driverChrome.findElements(By.tagName("span"));
		// //// invert the list
		array = new ArrayList<WebElement>();

		for (int i = spans.size() - 1; i >= 0; i--) {
			array.add(spans.get(i));
		}

		spans = array;
		// ////
		for (WebElement weSpan : spans) {
			if (weSpan.getText() != null) {
				try {
					if (weSpan.getText().contains("No Background")) {

						action.moveToElement(weSpan).build().perform();
						Thread.sleep(500);
						action.click().build().perform();
						Thread.sleep(1000);
						break;
					}
				} catch (Exception e) {
					System.out.println("==");
					e.printStackTrace();
					System.out.println("==");
				}
			}

		}
	}

	// ******************************************************************************************************
	static void goBackToESRIAerial() throws InterruptedException, AWTException {
		Robot robot = new Robot();
		robot.mouseMove(0, 0);
		clickOn_Layers_icon();
		// Thread.sleep(2000);
		int times = 0;
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		boolean breakIt = false;
		while (true) {

			for (WebElement we : spans) {
				if (we.getText().contains("OpenStreetMap")) {
					driverChrome.manage().timeouts()
							.implicitlyWait(30, TimeUnit.SECONDS);
					breakIt = true;
					break;

				}
			}
			if (breakIt) {
				break;
			}
			if (times == 2) {
				times = 0;
				try {

					System.out
							.println("Oops!! It was either that bug of Selenium or the mouse was moved by you, now I will try to hover on layers icon again, as many times as it's opened properly, no worries :)");
					Thread.sleep(1000);
					robot.mouseMove(0, 0);
					clickOn_Layers_icon();
					Thread.sleep(1000);
				} catch (Exception e) {
				}
			}
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			Thread.sleep(1000);
			times++;
		}
		// //////////////////// ^^^^^^^^^ We do the code above to make sure that
		// the element from the new opened window is visible

		spans = driverChrome.findElements(By.tagName("span"));

		// /// back to ESRI Arial
		for (WebElement weSpan : spans) {
			if (weSpan.getText() != null) {
				try {
					if (weSpan.getText().contains("ESRI Aerial")) {
						System.out.println("Back To -> " + weSpan.getText());
						action.moveToElement(weSpan).build().perform();
						Thread.sleep(1000);
						action.click().build().perform();
						Thread.sleep(1000);

					}
				} catch (Exception e) {
					System.out.println("==");
					e.printStackTrace();
					System.out.println("==");
				}
			}
		}

	}

	// ******************************************************************************************************
	static void clickOn_OpensTheBoundaryManager() throws InterruptedException {
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {
				if (weSpan.getAttribute("class").contains(
						"pam-icon-manageBoundaries toolbar-button-icon")) {
					weSpan.click();
					// Thread.sleep(1000);
					break;
				}

			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void testingBoundaryManager() throws InterruptedException {
		driverChrome.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		rightClickOnTheLastRenamedBoundaryFromBoumdaryManager();
		boolean breakIt = false;
		// ///////////////////////// click on Edit Boundary
		Thread.sleep(1000);
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Edit Boundary")) {
					System.out.println("Click on Edit Boundary");
					Thread.sleep(1000);
					we.click();
					Thread.sleep(1000);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// //////////// moving squares
		try {
			// ////////////////////
			System.out.println("Dragging one of those squares");

			RemoteTest RemoteTest = new RemoteTest();
			URL imageURL = RemoteTest.getClass().getResource("corner.PNG");

			BufferedImage imageBuffered = ImageIO.read(imageURL);

			ImageIO.write(imageBuffered, "png", new File("corner.png"));
			Thread.sleep(3000);
			// ////////////////////////////////

			Screen screen = new Screen();
			Pattern img1 = new Pattern("corner.PNG");

			Pattern drop = new Pattern("corner.PNG");

			screen.dragDrop(img1, drop.targetOffset(-100, -100));

			// screen.wait(img1, 3);
			Thread.sleep(2000);
			screen.dragDrop(img1, drop.targetOffset(200, 200));
		} catch (Exception e) {
			try {

				RemoteTest RemoteTest2 = new RemoteTest();
				URL imageURL2 = RemoteTest2.getClass().getResource(
						"leftCorner.png");

				BufferedImage imageBuffered2 = ImageIO.read(imageURL2);

				ImageIO.write(imageBuffered2, "png", new File("leftCorner.png"));
				Thread.sleep(3000);
				// ////////////////////////////////

				Screen screen2 = new Screen();
				Pattern img12 = new Pattern("leftCorner.png");

				Pattern drop2 = new Pattern("leftCorner.png");

				screen2.dragDrop(img12, drop2.targetOffset(-100, -100));
				Thread.sleep(2000);
				screen2.dragDrop(img12, drop2.targetOffset(200, 200));
				// screen.wait(img1, 3);
				Thread.sleep(2000);
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		// // //////////////// we get all white squares
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		List<WebElement> neededDivs = new ArrayList<WebElement>();
		for (WebElement weDiv : divs) {
			try {
				if (weDiv
						.getAttribute("class")
						.equals("leaflet-marker-icon leaflet-div-icon leaflet-editing-icon leaflet-zoom-hide leaflet-clickable leaflet-marker-draggable")) {
					neededDivs.add(weDiv);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// System.out.println(neededDivs.size());
		// // ////////
		System.out
				.println("Click on one the brighter squares (which cuts some part of the area)");
		Thread.sleep(2000);
		int i = 0;
		while (true) {
			try {
				neededDivs.get(i).click();
				Thread.sleep(2000);
				break;
			} catch (Exception e) {
				i++;
			}
		}
		// // /// we get all white squares
		divs = driverChrome.findElements(By.tagName("div"));
		neededDivs.clear();
		for (WebElement weDiv : divs) {
			try {
				if (weDiv
						.getAttribute("class")
						.equals("leaflet-marker-icon leaflet-div-icon leaflet-editing-icon leaflet-zoom-hide leaflet-clickable leaflet-marker-draggable")) {

					neededDivs.add(weDiv);
				}
			} catch (Exception e) {

			}
		}
		// // //////
		// System.out.println(neededDivs.size());
		System.out
				.println("Click on one the darker squares (which generates two more squares on its sides)");
		Thread.sleep(2000);
		i = 9;
		while (true) {
			try {
				neededDivs.get(i).click();
				Thread.sleep(1000);
				break;
			} catch (Exception e) {
				i++;
			}
		}
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary Manager");
		rightClickOnTheLastRenamedBoundaryFromBoumdaryManager();
		// ///////////////////////// click on Zoom To On Map
		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Zoom To On Map")) {
					System.out.println("Click On Zoom To On Map");
					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary Manager");
		rightClickOnTheLastRenamedBoundaryFromBoumdaryManager();
		// ////////// click on cancle edit

		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Cancel Edit")) {
					System.out.println("Click On Cancel Edit");
					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary Manager");
		rightClickOnTheLastRenamedBoundaryFromBoumdaryManager();
		// //////////////////////// click on Edit Boundary
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Edit Boundary")) {
					System.out.println("Click on Edit Boundary");
					Thread.sleep(1000);
					we.click();
					Thread.sleep(1000);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary Manager");
		rightClickOnTheLastRenamedBoundaryFromBoumdaryManager();
		// ////////// click on finish edit

		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Finish Edit")) {
					System.out.println("Click On Finish Edit");
					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary Manager");
		rightClickOnTheLastRenamedBoundaryFromBoumdaryManager();
		// ////////// click on rename

		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Rename Boundary")) {
					System.out.println("Click On Rename Boundary");
					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// /////////////////// We do the code below to make sure
		// that
		// the element from the new opened window is visible
		spans = driverChrome.findElements(By.tagName("span"));
		breakIt = false;
		while (true) {

			for (WebElement weSpan : spans) {

				if (weSpan.getText().equals("Rename Boundary")) {

					Thread.sleep(1000);
					driverChrome.manage().timeouts()
							.implicitlyWait(20, TimeUnit.SECONDS);
					breakIt = true;
					break;
				}
			}
			if (breakIt) {
				break;
			}
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			Thread.sleep(1000);

		}
		// //////////////////// ^^^^^^^^^ We do the code above to
		// make sure
		// that
		// the element from the new opened window is visible

		action.sendKeys(Keys.chord(Keys.CONTROL, "a")).build().perform();
		Thread.sleep(1000);
		String uniqueID = UUID.randomUUID().toString();
		action.sendKeys("Testing_Rename_" + uniqueID).build().perform();
		Thread.sleep(2000);
		action.sendKeys(Keys.TAB).build().perform();
		System.out.println("Click on Submit");
		Thread.sleep(2000);
		action.sendKeys(Keys.ENTER).build().perform();
		Thread.sleep(2000);
		Thread.sleep(2000);
		// // ////////////////////// right click on the last area
		System.out.println("Right Click On the Boundary Manager");
		rightClickOnTheLastRenamedBoundaryFromBoumdaryManager();
		// ////////// click on Delete Boundary

		Thread.sleep(1000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement we : spans) {
			try {
				if (we.getText().equals("Delete Boundary")) {
					System.out.println("Click On Delete Boundary");
					Thread.sleep(2000);
					we.click();
					Thread.sleep(2000);
					driverChrome.switchTo().alert().accept();
					Thread.sleep(1000);
					break;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// ******************************************************************************************************
	static void closingBoundaryManagerByRedCross() throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		boolean breakIt = false;
		// //// invert the list

		ArrayList<WebElement> array = new ArrayList<WebElement>();

		for (int i = divs.size() - 1; i >= 0; i--) {
			array.add(divs.get(i));
		}

		divs = array;
		// ////
		for (WebElement weDiv : divs) {

			if (weDiv.getAttribute("aria-labelledby") != null) {

				List<WebElement> spans = weDiv.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {
					if (weSpan.getText().equals("Boundary Manager")) {
						for (WebElement weSpan2 : spans) {
							if (weSpan2.getText().equals("close")) {
								weSpan2.click();
								breakIt = true;
								break;
							}
						}

						if (breakIt) {
							break;
						}
					}
				}

			}

			if (breakIt) {
				break;
			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_TogglesImplementVisibility()
			throws InterruptedException, StaleElementReferenceException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		try {
			for (WebElement weDiv : divs) {

				if (weDiv.getAttribute("title").contains(
						"Toggles implement visibility")) {
					weDiv.click();
					Thread.sleep(1000);
					break;
				}

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (e.getMessage().contains("Element is not clickable")) {
				System.out.println(1111);
				isMapLoaded();
			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_AutomaticallyUpdateImplementInformation()
			throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		for (WebElement weDiv : divs) {
			try {
				if (weDiv.getAttribute("title").contains(
						"Automatically update implement information")) {
					weDiv.click();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {
				// System.out.println("see I told you :)");
			}
		}
	}

	// ******************************************************************************************************
	static void clickOn_TogglesAreaMeasureToolVisibility()
			throws InterruptedException {
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		for (WebElement we : divs) {
			try {
				if (we.getAttribute("title").contains(
						"Toggles area measure tool visibility")) {
					we.click();
					break;
				}
			} catch (Exception e) {

			}
		}
	}

	// ******************************************************************************************************
	static void usingAreaMeasureTool() throws InterruptedException,
			AWTException {
		Dimension dimension = null;
		WebElement neededWe = null;
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));
		Robot robot = new Robot();
		for (WebElement we : divs) {
			try {
				if (we.getAttribute("id").contains("leaflet-map")) {
					neededWe = we;
					dimension = we.getSize();
					action.moveToElement(we, 2 * (dimension.width) / 8,
							4 * (dimension.height) / 8).click().build()
							.perform();
					Thread.sleep(1000);

					action.moveToElement(we, (3 * (dimension.width) / 8),
							(3 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);

					action.moveToElement(we, (4 * (dimension.width) / 8),
							(3 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);

					action.moveToElement(we, (5 * (dimension.width) / 8),
							(4 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);

					action.moveToElement(we, (5 * (dimension.width) / 8),
							(5 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					action.moveToElement(we, (4 * (dimension.width) / 8),
							(6 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					action.moveToElement(we, (3 * (dimension.width) / 8),
							(6 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					action.moveToElement(we, (2 * (dimension.width) / 8),
							(5 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					action.moveToElement(we, (2 * (dimension.width) / 8),
							(4 * (dimension.height) / 8)).click().build()
							.perform();
					Thread.sleep(1000);
					break;
				}
			} catch (Exception e) {

			}
		}
		// //////////// click on Cancel
		List<WebElement> as = driverChrome.findElements(By.tagName("a"));
		for (WebElement weA : as) {
			if (weA.getText().equals("Cancel")) {
				System.out.println("Click on Cancel");
				Thread.sleep(3000);
				weA.click();
				Thread.sleep(1000);
			}
		}
		// //////////// click on Measure Distance and Areas
		as = driverChrome.findElements(By.tagName("a"));
		for (WebElement weA : as) {
			if (weA.getAttribute("title") != null) {
				if (weA.getAttribute("title").equals(
						"Measure distances and areas")) {
					System.out
							.println("Hover over \"Measure distances and areas\" icon on top-right of the map");
					Thread.sleep(3000);
					robot.mouseMove(0, 0);
					action.moveToElement(weA, 3, 3).build().perform();
					Thread.sleep(1000);
					break;
				}
			}
		}
		// /////////// click on Create a new measurement
		as = driverChrome.findElements(By.tagName("a"));
		for (WebElement weA : as) {

			if (weA.getText().equals("Create a new measurement")) {
				System.out.println("Click on Create a new measurement");
				Thread.sleep(3000);
				weA.click();
				Thread.sleep(2000);
				break;
			}
		}
		// //////////////////////
		action.moveToElement(neededWe, 2 * (dimension.width) / 8,
				4 * (dimension.height) / 8).click().build().perform();
		Thread.sleep(1000);

		action.moveToElement(neededWe, (3 * (dimension.width) / 8),
				(3 * (dimension.height) / 8)).click().build().perform();
		Thread.sleep(1000);

		action.moveToElement(neededWe, (4 * (dimension.width) / 8),
				(3 * (dimension.height) / 8)).click().build().perform();
		Thread.sleep(1000);

		action.moveToElement(neededWe, (5 * (dimension.width) / 8),
				(4 * (dimension.height) / 8)).click().build().perform();
		Thread.sleep(1000);

		action.moveToElement(neededWe, (5 * (dimension.width) / 8),
				(5 * (dimension.height) / 8)).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(neededWe, (4 * (dimension.width) / 8),
				(6 * (dimension.height) / 8)).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(neededWe, (3 * (dimension.width) / 8),
				(6 * (dimension.height) / 8)).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(neededWe, (2 * (dimension.width) / 8),
				(5 * (dimension.height) / 8)).click().build().perform();
		Thread.sleep(1000);
		action.moveToElement(neededWe, (2 * (dimension.width) / 8),
				(4 * (dimension.height) / 8)).click().build().perform();
		Thread.sleep(1000);
		// /////////////// click on Finish Measurement
		as = driverChrome.findElements(By.tagName("a"));
		for (WebElement weA : as) {

			if (weA.getText().equals("Finish Measurement")) {
				System.out.println("Click on Finish Measurement");
				Thread.sleep(3000);
				weA.click();
				Thread.sleep(2000);
				break;
			}
		}
		// /////////////// click on Center on this Area
		as = driverChrome.findElements(By.tagName("a"));
		for (WebElement weA : as) {

			if (weA.getText().equals("Center on this Area")) {
				System.out.println("Click on Center on this Area");
				Thread.sleep(3000);
				weA.click();
				Thread.sleep(2000);
				break;
			}
		}
		// /////////////// click on Center on this Area
		as = driverChrome.findElements(By.tagName("a"));
		for (WebElement weA : as) {

			if (weA.getText().equals("Delete")) {
				System.out.println("Click on Delete");
				Thread.sleep(3000);
				weA.click();
				Thread.sleep(2000);
				break;
			}
		}
	}

	// ******************************************************************************************************
	public static void testingHarvest() throws InterruptedException {
		rightClickOnALoadedField();
		Thread.sleep(1000);
		boolean breakIt = false;
		WebElement harvest = null;
		// // /////////******************** click on Harvest
		System.out.println("Click on Harvest");
		Thread.sleep(2000);
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Harvest")) {
					weSpan.click();
					harvest = weSpan;
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click on Date
		System.out.println("Click on Date");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("Date")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(20, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// ////////////////
		clickOn_togglesLegendVisibility();
		// // //////////////// play with Harvest slider
		System.out.println("Playing with Harvest slider");
		Thread.sleep(2000);
		WebElement a = driverChrome.findElement(By.id("legend-Harvest"))
				.findElement(By.tagName("a"));
		action.click(a).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_LEFT).build().perform();
			Thread.sleep(200);
		}
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(200);
		}
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// /////////******************** click on Harvest
		System.out.println("Click on Harvest");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Harvest")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click on Moisture
		System.out.println("Click on Moisture");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("Moisture")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////////// play with Harvest slider
		System.out.println("Playing with Harvest slider");
		Thread.sleep(2000);
		a = driverChrome.findElement(By.id("legend-Harvest")).findElement(
				By.tagName("a"));
		action.click(a).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_LEFT).build().perform();
			Thread.sleep(200);
		}
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(200);
		}
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// /////////******************** click on Harvest
		System.out.println("Click on Harvest");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Harvest")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click on Productivity
		System.out.println("Click on Productivity");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("Productivity")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////////// play with Harvest slider
		System.out.println("Playing with Harvest slider");
		Thread.sleep(2000);
		a = driverChrome.findElement(By.id("legend-Harvest")).findElement(
				By.tagName("a"));
		action.click(a).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_LEFT).build().perform();
			Thread.sleep(200);
		}
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(200);
		}
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// //////////
		// /////////******************** click on Harvest
		System.out.println("Click on Harvest");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Harvest")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click on Vehicle
		System.out.println("Click on Vehicle");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("Vehicle")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////////// play with Harvest slider
		System.out.println("Playing with Harvest slider");
		Thread.sleep(2000);
		a = driverChrome.findElement(By.id("legend-Harvest")).findElement(
				By.tagName("a"));
		action.click(a).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_LEFT).build().perform();
			Thread.sleep(200);
		}
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(200);
		}
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// //////////
		// /////////******************** click on Harvest
		System.out.println("Click on Harvest");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Harvest")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click on Yield Raster
		System.out.println("Click Yield Raster");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("Yield Raster")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////////// play with Harvest slider
		System.out.println("Playing with Harvest slider");
		Thread.sleep(2000);
		a = driverChrome.findElement(By.id("legend-Harvest")).findElement(
				By.tagName("a"));
		action.click(a).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_LEFT).build().perform();
			Thread.sleep(200);
		}
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(200);
		}
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// //////////
		// /////////******************** click on Harvest
		System.out.println("Click on Harvest");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Harvest")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click on Show Precision Harvest Map
		System.out.println("Click on Show Precision Harvest Map");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("Show Precision Harvest Map")) {
						weSpan.click();
						Thread.sleep(3000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////// close Wheat (CWAD) (2014-10-07) window
		System.out.println("Closing Wheat (CWAD) (2014-10-07) window");
		Thread.sleep(2000);
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		boolean gotIt = false;
		for (WebElement weDiv : divs) {
			if (weDiv
					.getAttribute("class")
					.equals("ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix")) {
				spans = weDiv.findElements(By.tagName("span"));
				for (WebElement weSpan : spans) {
					if (weSpan.getText().equals("Wheat (CWAD) (2014-10-07)")) {
						gotIt = true;
						for (WebElement weSpan2 : spans) {
							if (weSpan2.getText().equals("close")) {
								weSpan2.click();
								Thread.sleep(2000);
								break;
							}
						}
						break;
					}
				}
			}
			if (gotIt) {
				break;
			}
		}
		// //////////////////////////
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// //////////
		// /////////******************** click on Harvest
		System.out.println("Click on Harvest");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Harvest")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click on No Raster
		System.out.println("Click on No Raster");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().contains("No Raster")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////////// Closing Legend Window
		System.out.println("Closing Legend Window");
		Thread.sleep(2000);
		closingLegendWindowByRedCross();
		Thread.sleep(2000);
	}

	// ******************************************************************************************************
	public static void rightClickOnTheLastRenamedBoundaryFromBoumdaryManager()
			throws InterruptedException {
		List<WebElement> neededTds = null;
		boolean breakIt = true;
		while (true) {
			breakIt = true;
			List<WebElement> tds = driverChrome.findElements(By.tagName("td"));
			boolean gotThem = false;
			neededTds = new ArrayList<WebElement>();
			for (WebElement weTd : tds) {

				try {
					if (weTd.getText().contains("Testing_Rename_")) {
						neededTds.add(weTd);
						gotThem = true;
					} else {
						if (gotThem) {
							break;
						}
					}
				} catch (Exception e) {
					if (e.getMessage().contains("element is not attached")) {
						// System.out.println(e.getMessage());
						breakIt = false;
					} else {// System.out.println(2222);
						e.printStackTrace();
					}
				}
			}
			if (breakIt) {
				break;
			}
		}
		try {
			action.moveToElement(neededTds.get(neededTds.size() - 1),
					(neededTds.get(neededTds.size() - 1).getSize().width) - 10,
					(neededTds.get(neededTds.size() - 1).getSize().height) / 2)
					.contextClick().build().perform();
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ******************************************************************************************************
	public static void testingprofit() throws InterruptedException {
		closeThisSpecificSectionFromPamBar("Wheat (CWAD) (2014-10-07)");
		rightClickOnALoadedField();
		Thread.sleep(1000);
		boolean breakIt = false;

		// // /////////******************** click on Profit
		System.out.println("Click on Profit");
		Thread.sleep(2000);
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Profit")) {
					weSpan.click();

					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click on Volume
		System.out.println("Click on Volume");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("Volume")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(20, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// ////////////////
		clickOn_togglesLegendVisibility();
		// // //////////////// play with Harvest slider
		System.out.println("Playing with Harvest slider");
		Thread.sleep(2000);
		WebElement a = driverChrome.findElement(By.id("legend-Profit"))
				.findElement(By.tagName("a"));
		action.click(a).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_LEFT).build().perform();
			Thread.sleep(200);
		}
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(200);
		}
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// /////////******************** click on Profit
		System.out.println("Click on Profit");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Profit")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}

		// ////// click on Show Precision Profit Map
		System.out.println("Click on Show Precision Profit Map");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("Show Precision Profit Map")) {
						weSpan.click();
						Thread.sleep(3000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////// close Wheat (CWAD) (2014-10-07) window
		System.out.println("Closing Wheat (CWAD) (2014-10-07) window");
		Thread.sleep(2000);
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		boolean gotIt = false;
		for (WebElement weDiv : divs) {
			if (weDiv
					.getAttribute("class")
					.equals("ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix")) {
				spans = weDiv.findElements(By.tagName("span"));
				for (WebElement weSpan : spans) {
					if (weSpan.getText().equals("Wheat (CWAD) (2014-10-07)")) {
						gotIt = true;
						for (WebElement weSpan2 : spans) {
							if (weSpan2.getText().equals("close")) {
								weSpan2.click();
								Thread.sleep(2000);
								break;
							}
						}
						break;
					}
				}
			}
			if (gotIt) {
				break;
			}
		}
		// //////////////////////////
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// //////////
		// /////////******************** click on Profit
		System.out.println("Click on Profit");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Profit")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click on No Raster
		System.out.println("Click on Border");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getAttribute("title").equals(
							"Remove all profit layers from map")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////////// Closing Legend Window
		System.out.println("Closing Legend Window");
		Thread.sleep(2000);
		closingLegendWindowByRedCross();
		Thread.sleep(2000);
	}

	// ******************************************************************************************************
	public static void closeThisSpecificSectionFromPamBar(String sectionName)
			throws InterruptedException {
		driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		List<WebElement> wes = driverChrome.findElements(By
				.className("chosen-single-with-deselect"));
		boolean breakIt = false;
		for (WebElement we : wes) {
			try {

				if (we.getTagName().equals("a")) {
					List<WebElement> spans = we
							.findElements(By.tagName("span"));
					for (WebElement weSpan : spans) {
						try {
							if (weSpan.getText().equals(sectionName)) {
								we.findElement(By.tagName("abbr")).click();
								Thread.sleep(2000);
								breakIt = true;
								break;
							}
						} catch (Exception e) {

						}
					}
				}
			} catch (Exception e) {
				System.out.println("-->");
				e.printStackTrace();
			}
			if (breakIt) {
				break;
			}
		}
		driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// ******************************************************************************************************
	public static void rightClickOnAnImplement(String implementName)
			throws InterruptedException {
		driverChrome.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		boolean breakIt = true;
		while (true) {
			List<WebElement> implement = driverChrome.findElements(By
					.className(implementName));

			List<WebElement> implementOff = driverChrome.findElements(By
					.className(implementName + "-off"));

			List<WebElement> implementss = new ArrayList<WebElement>();

			implementss.addAll(implement);
			implementss.addAll(implementOff);

			breakIt = true;
			for (WebElement weImplement : implementss) {
				try {

					if (weImplement.getTagName().equals("div")) {
						action.contextClick(weImplement).build().perform();
						Thread.sleep(2000);
						break;

					}
				} catch (Exception e) {

					// e.printStackTrace();
					if (e.getMessage().contains("element is not attached")) {
						breakIt = false;
					}
					Thread.sleep(2000);
				}
			}
			if (breakIt) {
				break;
			}
		}
		driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// ******************************************************************************************************
	public static void testing_ViewImplementPath() throws InterruptedException {
		driverChrome.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		boolean breakIt = true;
		List<WebElement> spans = new ArrayList<WebElement>();
		// /// Click On View Implement Path
		System.out.println("Click On View Implement Path");

		while (true) {
			breakIt = true;
			try {
				spans = driverChrome.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {

					if (weSpan.getText().equals("View Implement Path")) {
						weSpan.click();
						Thread.sleep(2000);
						break;
					}

				}
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}

		}

		// ///// Click On Last hour
		System.out.println("Click On Last hour");

		while (true) {
			breakIt = true;
			try {
				spans = driverChrome.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {

					if (weSpan.getText().equals("Last hour")) {
						weSpan.click();
						Thread.sleep(2000);
						break;
					}

				}
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}

		}

		// ///////////
		System.out.println("Right Click On An Implement");

		rightClickOnAnImplement("tractor-green");
		Thread.sleep(2000);
		// /// Click On View Implement Path
		System.out.println("Click On View Implement Path");

		while (true) {
			breakIt = true;
			try {

				spans = driverChrome.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {

					if (weSpan.getText().equals("View Implement Path")) {
						weSpan.click();
						Thread.sleep(2000);
						break;
					}

				}
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}

		}

		// ///// Click On Last 6 hours
		System.out.println("Click On Last 6 hours");

		while (true) {
			breakIt = true;
			try {
				spans = driverChrome.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {

					if (weSpan.getText().equals("Last 6 hours")) {
						weSpan.click();
						Thread.sleep(2000);
						break;
					}

				}
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}

		}

		// ///////////
		System.out.println("Right Click On An Implement");

		rightClickOnAnImplement("tractor-green");
		Thread.sleep(2000);
		// /// Click On View Implement Path
		System.out.println("Click On View Implement Path");

		while (true) {
			breakIt = true;
			try {
				spans = driverChrome.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {

					if (weSpan.getText().equals("View Implement Path")) {
						weSpan.click();
						Thread.sleep(2000);
						break;
					}

				}
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}

		}

		// ///// Click On Turn off path
		System.out.println("Click On Turn off path");

		while (true) {
			breakIt = true;
			try {

				spans = driverChrome.findElements(By.tagName("span"));

				for (WebElement weSpan : spans) {

					if (weSpan.getText().equals("Turn off path")) {
						weSpan.click();
						Thread.sleep(2000);
						break;
					}

				}
			} catch (Exception e) {
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}

		}

		// ///////////

		driverChrome.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	// ******************************************************************************************************
	public static void rightClickOnAMarker() throws InterruptedException {
		boolean breakIt = true;
		while (true) {
			breakIt = true;
			try {
				List<WebElement> imgs = driverChrome.findElements(By
						.tagName("img"));
				List<WebElement> neededImgs = new ArrayList<WebElement>();
				for (WebElement weImg : imgs) {
					if (weImg.getAttribute("src") != null) {
						if (weImg
								.getAttribute("src")
								.equals("https://testpam.granduke.net/pam/static/lib/leaflet/images/marker-icon.png")) {
							neededImgs.add(weImg);
						}
					}
				}
				action.contextClick(neededImgs.get(neededImgs.size() - 1))
						.build().perform();
				break;
			} catch (Exception e) {
				// e.printStackTrace();
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}
		}

	}

	// ******************************************************************************************************
	public static void testingPlacemark() throws InterruptedException {
		boolean breakIt = true;
		// //////// click on Edit Placemark Info
		// System.out.println("Click on Edit Placemark Info");
		// Thread.sleep(2000);
		// while (true) {
		// breakIt = true;
		// try {
		// List<WebElement> spans = driverChrome.findElements(By
		// .tagName("span"));
		//
		// for (WebElement weSpan : spans) {
		// if (weSpan.getText().equals("Edit Placemark Info")) {
		// weSpan.click();
		// Thread.sleep(2000);
		// break;
		// }
		// }
		// } catch (Exception e) {
		// System.out.println(11111);
		// e.printStackTrace();
		// if (e.getMessage().contains("element is not attached")) {
		// breakIt = false;
		// }
		// }
		// if (breakIt) {
		// break;
		// }
		// }
		// // ///////////
		// writeOn_AddPlacemark_NameAndDescription();
		// Thread.sleep(1000);
		// selectAndDeleteFrom_WhoElseCanSeeThis();
		// Thread.sleep(1000);
		// clickOn_SubmitFromAddPlacemark();
		// Thread.sleep(1000);
		// // //////
		// System.out.println("Right Click On The Placemark");
		Thread.sleep(2000);
		// rightClickOnAMarker();
		Thread.sleep(2000);
		// ////// Click on Move Placemark
		System.out.println("Click On Move Placemark	");
		Thread.sleep(2000);
		while (true) {
			breakIt = true;
			try {
				List<WebElement> spans = driverChrome.findElements(By
						.tagName("span"));

				for (WebElement weSpan : spans) {
					if (weSpan.getText().equals("Move Placemark")) {
						weSpan.click();
						Thread.sleep(2000);
						break;
					}
				}
			} catch (Exception e) {
				System.out.println(11111);
				e.printStackTrace();
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}
		}
		// /////////////// Moving a Red PlaceMark

		try {

			RemoteTest RemoteTest = new RemoteTest();
			URL imageURL = RemoteTest.getClass().getResource("redPlacemark.PNG");
			System.out.println("==>" + imageURL + "<==");
			BufferedImage imageBuffered = ImageIO.read(imageURL);

			ImageIO.write(imageBuffered, "png", new File("redPlacemark.PNG"));
			Thread.sleep(3000);
			// ////////////////////////////////

			Screen screen = new Screen();
			Pattern img1 = new Pattern("redPlacemark.PNG");
			Pattern drop = new Pattern("redPlacemark.PNG");
			drop.targetOffset(60, 60);

			screen.dragDrop(img1, drop);

			screen.wait(img1, 3);
			Thread.sleep(5000);
			screen.doubleClick(img1);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ******************************************************************************************************
	public static void rightClickOnMap() throws InterruptedException {
		boolean breakIt = true;
		while (true) {
			breakIt = true;
			try {
				List<WebElement> divs = driverChrome.findElements(By
						.tagName("div"));

				for (WebElement weDiv : divs) {
					try {
						if (weDiv.getAttribute("id").contains("leaflet-map")) {
							action.contextClick(weDiv).build().perform();
							Thread.sleep(2000);
							break;
						}
					} catch (Exception e) {

					}
				}
			} catch (Exception e) {
				// e.printStackTrace();
				if (e.getMessage().contains("element is not attached")) {
					breakIt = false;
				}
			}
			if (breakIt) {
				break;
			}
		}

	}

	// ******************************************************************************************************
	public static void testingApplied() throws InterruptedException {
		closeThisSpecificSectionFromPamBar("Wheat (CWAD) (2014-10-07)");
		rightClickOnALoadedField();
		Thread.sleep(1000);
		boolean breakIt = false;

		// // /////////******************** click on Applied
		System.out.println("Click On Applied");
		Thread.sleep(2000);
		List<WebElement> spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Applied")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}
			} catch (Exception e) {

			}
		}
		// ////// click on UAN_FE - Overlap
		System.out.println("Click On UAN_FE - Overlap");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("UAN_FE - Overlap")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(20, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// ////////////////
		clickOn_togglesLegendVisibility();
		// // //////////////// play with Harvest slider
		System.out.println("Playing with Harvest slider");
		Thread.sleep(2000);
		WebElement a = driverChrome.findElement(By.id("legend-Applied"))
				.findElement(By.tagName("a"));
		action.click(a).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_LEFT).build().perform();
			Thread.sleep(200);
		}
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(200);
		}
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// /////////******************** click on Profit
		System.out.println("Click On Applied");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Applied")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}

		// ////// Click On UAN_FE - Standard
		System.out.println("Click On UAN_FE - Standard");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("UAN_FE - Standard")) {
						weSpan.click();
						Thread.sleep(3000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// // //////////////// play with Harvest slider
		System.out.println("Playing with Harvest slider");
		Thread.sleep(2000);
		a = driverChrome.findElement(By.id("legend-Applied")).findElement(
				By.tagName("a"));
		action.click(a).build().perform();
		Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_LEFT).build().perform();
			Thread.sleep(200);
		}
		for (int i = 0; i < 10; i++) {
			action.sendKeys(Keys.ARROW_RIGHT).build().perform();
			Thread.sleep(200);
		}
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// /////////******************** click on Profit
		System.out.println("Click On Applied");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Applied")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// Click On Show Applied Summary
		System.out.println("Click On Show Applied Summary");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getText().equals("Show Applied Summary")) {
						weSpan.click();
						Thread.sleep(3000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////// close Spring Fertilizer and Seeding window
		System.out.println("Closing Spring Fertilizer And Seeding Window");
		Thread.sleep(2000);
		List<WebElement> divs = driverChrome.findElements(By.tagName("div"));

		boolean gotIt = false;
		for (WebElement weDiv : divs) {
			if (weDiv
					.getAttribute("class")
					.equals("ui-dialog-titlebar ui-widget-header ui-corner-all ui-helper-clearfix")) {
				spans = weDiv.findElements(By.tagName("span"));
				for (WebElement weSpan : spans) {
					if (weSpan.getText()
							.equals("Spring Fertilizer and Seeding")) {
						gotIt = true;
						for (WebElement weSpan2 : spans) {
							if (weSpan2.getText().equals("close")) {
								weSpan2.click();
								Thread.sleep(2000);
								break;
							}
						}
						break;
					}
				}
			}
			if (gotIt) {
				break;
			}
		}
		// //////////////////////////
		// //////////
		rightClickOnALoadedField();
		Thread.sleep(1000);
		// //////////
		// /////////******************** click on Applied
		System.out.println("Click on Applied");
		Thread.sleep(2000);
		spans = driverChrome.findElements(By.tagName("span"));
		for (WebElement weSpan : spans) {
			try {

				if (weSpan.getText().equals("Applied")) {
					weSpan.click();
					Thread.sleep(2000);
					break;
				}

			} catch (Exception e) {

			}
		}
		// ////// click On No Product
		System.out.println("Click On No Product");
		Thread.sleep(2000);
		while (true) {
			driverChrome.manage().timeouts()
					.implicitlyWait(3, TimeUnit.SECONDS);
			spans = driverChrome.findElements(By.tagName("span"));
			for (WebElement weSpan : spans) {
				try {

					if (weSpan.getAttribute("title").equals(
							"Remove all applied layers from map")) {
						weSpan.click();
						Thread.sleep(1000);
						driverChrome.manage().timeouts()
								.implicitlyWait(30, TimeUnit.SECONDS);
						breakIt = true;
						break;
					}

				} catch (Exception e) {

				}
			}
			if (breakIt) {
				break;
			}
		}
		// //////////////// Closing Legend Window
		System.out.println("Closing Legend Window");
		Thread.sleep(2000);
		closingLegendWindowByRedCross();
		Thread.sleep(2000);
	}

}//

