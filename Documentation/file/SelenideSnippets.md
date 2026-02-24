## Сниппеты в Selenide 

### **Команды браузера**

- `open (relativeOrAbsoluteUrl https://google.com)` -- открывает абсолютный урл
- `open (relativeOrAbsoluteUrl "/customer/orders")` -- открывает относительный урл
- `//-Dselenide.baseUrl=http://123.23.23.1` -- урл, который подставляется к энд поинту выше


- `Selenide.back ()` -- Кнопочка назад в браузере.
- `Selenide.refresh ()` -- Обновление браузера.

- `Selenide.clearBrowserCookies()` -- Очистка куки браузера.
- `Selenide.clearBrowserLocalStorage();` -- Очистка хранилища браузера.
- `executeJavaScript (jsCode:"sessionStorage.clear();");` -- Очистка хранилища сессии


- `Selenide.confirm()` -- подтвердить Алёрт
- `Selenide.dismiss()` -- отклонить Алёрт


- `Selenide.closeWindow ()` - закрывает вкладку
- `Selenide.closeWebDriver ()` -- закрывает весь Веб Драйвер


- `Selenide.switchTo().frame (new)` -- переключение между фреймами.
- `Selenide.switchTo().defaultContent()` -- вернуться на главную
- `Selenide.switchTo().window("The Internet");`

- `var cookie=new Cookie(name: "foo", value: "bar"
WebDriverRunner.getWebDriver().manage().addCookie(cookie)`


### **Команды Селекторы (Поиска)**
- `$(cssSelector:"div").click();` -- найти и кликнуть по элементу
- `element( cssSelector: "div").click()` -- element является Альтернативой $, может пригодится при тестах на котлине, так как там $ зарезервированный символ языком.


- `$(cssSelector:"div", index: 2).click();` -- кликает по третьему див элементу.
- `$x("//div)` -- через "Доллар Икс" можно прописывать иксПаф локаторы


- `$(seleniumSelector:byText(elementText:"full text")).click()` -- поиск по полному совпадению по тексту
- `$(seleniumSelector:byText(elementText:"ull text")).click()` -- поиск по частичному совпадению по тексту


- `$(seleniumSelector:byTagAndText("div", "full text"));` -- поиск по тэгу и полному совпадению
- `$(seleniumSelector:withTagAndText("div", "ull text"));` -- поиск по тэгу и частичному совпадению.


- `$(cssSelector:"").parent();` -- подняться вверх по родителю
- `$(cssSelector:"").sibling(1);` -- братья, сестры
- `$(cssSelector:"").preceding(1);`
- `$(cssSelector:"").closest("div");` -- предок с тэгом див.  
- `$(cssSelector:"").ancestor("div");` // the same as closest
- `$(cssSelector:"div:last-child");`


- `$("div").$("h1").find(byText("abc")).click();`
- `$(byAttribute("abc", "x")).click();`
- `$("[abc=x]").click();`


- `$(byId("mytext")).click();`
- `$("#mytext").click();`


- `$(byClassName("red")).click();`
- `$(".red").click();`

### **Команды действия (нажать, кликнуть и т.д)**

- `$(cssSelector:"").click();`
- `$(cssSelector:"").doubleClick();`
- `$(cssSelector:"").contextClick(); (правый клик)`

- `$cssSelector:("").hover();`

- `$cssSelector:("").setValue("text");` -- полностью стирает и вписывает текст
- `$cssSelector:("").append("text");` -- не стирает, а дополняет
- `$cssSelector:("").clear();` -- очищают поле
- `$cssSelector:("").setValue("");` // clear


- `$cssSelector:("div").sendKeys("c");` -- симулирует отправку хоткея пользователем
- `actions().sendKeys("c").perform();` //hotke y c on whole application
- `actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform();` // Ctrl + F
- `$("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));`


- `$("").pressEnter();`
- `$("").pressEscape();`
- `$("").pressTab();`

```
    // complex actions with keybord and mouse, example
    actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

    // old html actions don't work with many modern frameworks
    $("").selectOption("dropdown_option");
    $("").selectRadio("radio_options");
 ```

### **Команды ассершен (пока хз че это)**
- `$("").shouldBe(visible);`
- `$("").shouldNotBe(visible);`
- `$("").shouldHave(text("abc"));`
- `$("").shouldNotHave(text("abc"));`
- `$("").should(appear);`
- `$("").shouldNot(appear);`
- `$("").shouldBe(visible, Duration.ofSeconds(30));` - // longer timeouts

### **Команды кондишены (Что проверяем)**
- `$("").shouldBe(visible);` -- проверка на видимость
- `$("").shouldBe(hidden);` -- проверка на скрытность

- `$("").shouldHave(text("abc"));` -- проверяет частичное совпадение в слове
- `$("").shouldHave(exactText("abc"));` -- проверяет полное совпадение, то есть слово должно быть абц
- `$("").shouldHave(textCaseSensitive("abc"));`
- `$("").shouldHave(exactTextCaseSensitive("abc"));`
- `$("").should(matchText("[0-9]abc$"));`

- `$("").shouldHave(cssClass("red"));`
- `$("").shouldHave(cssValue("font-size", "12"));`

- `$("").shouldHave(value("25"));`
- `$("").shouldHave(exactValue("25"));`
- `$("").shouldBe(empty);`

- `$("").shouldHave(attribute("disabled"));`
- `$("").shouldHave(attribute("name", "example"));`
- `$("").shouldHave(attributeMatching("name", "[0-9]abc$"));`

- `$("").shouldBe(checked);` // for checkboxes


    // Warning! Only checks if it is in DOM, not if it is visible! You don't need it in most tests!
    $("").should(exist);

    // Warning! Checks only the "disabled" attribute! Will not work with many modern frameworks
    $("").shouldBe(disabled);
    $("").shouldBe(enabled);

### **Команды коллекшн (Что проверяем)**
- `$$("div");` // does nothing!

- `$$x("//div");` // by XPath

- ```
    // selections
    $$("div").filterBy(text("123")).shouldHave(size(1));
    $$("div").excludeWith(text("123")).shouldHave(size(1));

- `$$("div").first().click();`
- `elements("div").first().click();`
- ```
  // $("div").click();
  
    $$("div").last().click();
    $$("div").get(1).click(); // the second! (start with 0)
    $("div", 1).click(); // same as previous
    $$("div").findBy(text("123")).click(); //  finds first

- ```
  // assertions
  
    $$("").shouldHave(size(0));
    $$("").shouldBe(CollectionCondition.empty); // the same

    $$("").shouldHave(texts("Alfa", "Beta", "Gamma"));
    $$("").shouldHave(exactTexts("Alfa", "Beta", "Gamma"));

    $$("").shouldHave(textsInAnyOrder("Beta", "Gamma", "Alfa"));
    $$("").shouldHave(exactTextsCaseSensitiveInAnyOrder("Beta", "Gamma", "Alfa"));

    $$("").shouldHave(itemWithText("Gamma")); // only one text

    $$("").shouldHave(sizeGreaterThan(0));
    $$("").shouldHave(sizeGreaterThanOrEqual(1));
    $$("").shouldHave(sizeLessThan(3));
    $$("").shouldHave(sizeLessThanOrEqual(2));


### **Команды файло-операторов**

-   ```
    File file1 = $("a.fileLink").download(); // only for <a href=".."> links
    File file2 = $("div").download(DownloadOptions.using(FileDownloadMode.FOLDER)); // more common options, but may have problems with Grid/Selenoid

    File file = new File("src/test/resources/readme.txt");
    $("#file-upload").uploadFile(file);
    $("#file-upload").uploadFromClasspath("readme.txt");
    // don't forget to submit!
    $("uploadButton").click();

