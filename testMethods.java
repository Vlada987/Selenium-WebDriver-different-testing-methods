package tests;

// Multiple simple automation tests methods- main method is on 
// the bottom.
// For execute any of tests first run the setup(); method than
// desired test method.

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testMethods {

   public static WebDriver driver;
   public static WebDriverWait wt;
  
  //Method for oppening the browser
  public static void setup(){
    System.setProperty("webdriver.gecko.driver", "C:\\Users\\zikaz\\OneDrive\\Desktop\\SimpleTests\\SimpleTest\\lib\\geckodriver.exe");
    driver = new FirefoxDriver();
    wt = new WebDriverWait(driver, Duration.ofSeconds(3));
    driver.manage().window().maximize();

  }
 
  //Function to pick up the element drag, and drop on other spot
  public static void dragAndDrop(){
    driver.get("https://the-internet.herokuapp.com/drag_and_drop");
    WebElement a = driver.findElement(By.xpath("//div[@id='column-a']"));
    WebElement b = driver.findElement(By.xpath("//div[@id='column-b']"));
    Actions ac = new Actions(driver);
    ac.dragAndDrop(a, b).build().perform();
   }

   //Function for selecting radio buttons
  public static void radioButton(){
    driver.get("https://qa-automation-practice.netlify.app/radiobuttons.html");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//button[@id='sidebarCollapse']")).click();
    List <WebElement> buttons = driver.findElements(By.xpath("//label[@class='form-check-label']"));
    for(WebElement button: buttons){
      if(button.getText().equalsIgnoreCase("Radio button 2")){
        button.click();
     }
    }
   }

   //Function to select a date in a calendar
   public static void datePickerSelect(){
    driver.get("https://jqueryui.com/datepicker/");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='datepicker']")).click();
    String month = "April";
    String year = "2025";
    String day = "23";
    while(!(driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals(month)) 
    && driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText().equals(year)){
    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
      }
    List <WebElement> days = driver.findElements(By.xpath("//a[@class='ui-state-default']"));
    for(WebElement d:days){
      if(d.getText().equals(day)){
        d.click();
      }
    }
  }

   //DropDown selection in a different frame whitin a webpage
   public static void frameSelect(){
    driver.get(https://www.hyrtutorials.com/p/frames-practice);  
    WebElement frame1 = driver.findElement(By.cssSelector("#frm1"));
    driver.switchTo().frame(frame1);
    WebElement dropDownMenu = driver.findElement(By.cssSelector("#selectnav2"));
    Select s1 = new Select(dropDownMenu);
    s1.selectByIndex(2);
  }

   //Search and play a video on YouTube
   public static void playAsongOnYouT(){
    driver.get("https://www.youtube.com/");
    driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
    By search = By.xpath("//input[@id='search']");
    driver.findElement(search).sendKeys("despacito");
    driver.findElement(search).submit();
    By songDespacito = By.xpath("//a[@title='Luis Fonsi - Despacito ft. Daddy Yankee']");
    driver.findElement(songDespacito).click();
 }
       
  //Function for selecting a checkbox
  public static void checkbox(){
    driver.get("https://the-internet.herokuapp.com/checkboxes");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    List <WebElement> bb = driver.findElements(By.xpath("//input[@type='checkbox']"));
    for(WebElement b: bb){
        if(b.getText().equalsIgnoreCase("checkbox 1")){
            b.click();
   }
  }     
 }

  //Funcion for selection a dropdown menu
  public static void dropDown(){
    driver.get("https://the-internet.herokuapp.com/dropdown");
    WebElement dDown = driver.findElement(By.id("dropdown"));
    Select s = new Select(dDown);
    s.selectByIndex(2);
 }


  //Function for handling jsAlerts on a webpage
  public static void jsAlerts(){
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    By jsAlert1 = By.xpath("//button[@onclick='jsAlert()']");
    driver.findElement(jsAlert1).click();
    Alert a = driver.switchTo().alert();
    a.accept();
  
    }

   //Fuction to navigate to other window.
  public static void windowHandle(){
    driver.get("http://omayo.blogspot.com/");
    String mainWindow = driver.getWindowHandle();
    driver.findElement(By.linkText("Open a popup window")).click();
    Set<String> windows = driver.getWindowHandles();
    java.util.Iterator<String> it = windows.iterator();
    it.next();
    String secondWindow = it.next();
    driver.switchTo().window(secondWindow);
    driver.close();
    driver.switchTo().window(mainWindow);

    }

   //Fuction 2 to navigate to other window.
  public static void windowHandle(){
    driver.get("http://omayo.blogspot.com/");
    String mainWindow = driver.getWindowHandle();
    String mainTitle = driver.getTitle();
    driver.findElement(By.linkText("Open a popup window")).click();
    Set<String> windows = driver.getWindowHandles();
    java.util.Iterator<String> it1 = windows.iterator();
    while(it1.hasNext()){
      String window = it1.next();
      driver.switchTo().window(window);
      if(!driver.getTitle().equals(mainTitle)){
        driver.close();
       }
     }    
 }

   //Fuction to open a new tab and and navigate to other URL.
  public static void windowHandle(){
    driver.get("https://www.google.com/");
    String mainHandle = driver.getWindowHandle();
    JavascriptExecutor jv = (JavascriptExecutor) driver;
    jv.executeScript("window.open()");
    Set<String> Handles = driver.getWindowHandles();
    java.util.Iterator<String> it = Handles.iterator();
    it.next();
    String secondHandle = it.next();
    driver.switchTo().window(secondHandle);
    driver.get("https://www.youtube.com/");

    }
   //Handling a drop down menu without select class
   public static void dropDown2(String... value){
    driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
    driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='justAnInputBox']")).click();
    List<WebElement> elements = driver.findElements(By.xpath("//span[@class='comboTreeItemTitle']"));
    if(!value[0].equals("all")){
      for(WebElement el:elements){
        String elTXT = el.getText();
        for(String val:value){
          if(elTXT.equals(val)){
            el.click();
            break;
          }
        }
      }
    }
    else{
      for(WebElement ele:elements){
        ele.click();
      }
    }   
  }
    public static void checkBox10sDelay(){
      driver.get("http://omayo.blogspot.com/");
      WebDriverWait wait12s = new WebDriverWait(driver, Duration.ofSeconds(12));
      driver.findElement(By.xpath("//button[@onclick='setTimeout(myFunctionAXD,10000)']")).click();
      WebElement checkbox = driver.findElement(By.xpath("//input[@id='dte']"));
      wait12s.until(ExpectedConditions.elementToBeClickable(checkbox)).click();


  }

    public static void main(String[] args) {
  
  }
}
