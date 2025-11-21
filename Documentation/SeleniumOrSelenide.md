## Selenium или Selenide 

>Изначально был **_Selenium_**, а **_Selenide_** это уже надстройка над Селениумом, которая значительно упращает работу. 

Selenium Web Driver - это "голый" фреймворк
````Java
// Selenium - нужно всё делать вручную
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
WebElement searchInput = driver.findElement(By.id("search"));
searchInput.sendKeys("Selenide");
searchInput.submit();
````
Selenide - это "умная" надстройка над Selenium

````Java
// Selenide - многое уже "из коробки"
open("https://google.com");
$("#search").setValue("Selenide").pressEnter();
````