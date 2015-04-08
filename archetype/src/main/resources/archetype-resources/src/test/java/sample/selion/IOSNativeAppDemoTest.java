/*-------------------------------------------------------------------------------------------------------------------*\
|  Copyright (C) 2014 eBay Software Foundation                                                                        |
|                                                                                                                     |
|  Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance     |
|  with the License.                                                                                                  |
|                                                                                                                     |
|  You may obtain a copy of the License at                                                                            |
|                                                                                                                     |
|       http://www.apache.org/licenses/LICENSE-2.0                                                                    |
|                                                                                                                     |
|  Unless required by applicable law or agreed to in writing, software distributed under the License is distributed   |
|  on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for  |
|  the specific language governing permissions and limitations under the License.                                     |
\*-------------------------------------------------------------------------------------------------------------------*/

package ${package}.sample.selion;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Reporter;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import com.paypal.selion.annotations.MobileTest;
import com.paypal.selion.platform.grid.Grid;
import com.paypal.selion.reports.runtime.MobileReporter;

/**
 * This test class demonstrates how to use SeLion for running tests against a Native iOS app.
 *  
 */
public class IOSNativeAppDemoTest {

    /**
     * This test demonstrates how to use SeLion for running tests against a Native IOS app using appium.
     * This test case needs an local IOS simulator spawned. 
     */
    @MobileTest(appName = "InternationalMountains")
    @Test
    public void testMethod() throws InterruptedException {
        //Log a screenshot to the report and label it "My Screenshot 1"
        MobileReporter.log("My Screenshot 1", true);
        //To gain access to the IOSRemoteWebDriver, we use the thread safe helper method Grid.driver() 
        //which provides an instance of IOSRemoteWebDriver for the current Test method. 
        List<WebElement> cells = Grid.driver().findElements(By.className("UIATableCell"));
        assertEquals(9, cells.size());

        // get the 1st mountain
        WebElement first = cells.get(0);
        first.click();
        Thread.sleep(10 * 1000);

      //Log a screenshot to the report and label it "My Screenshot 2"
        MobileReporter.log("My Screenshot 2", true);

        // access the content
        By selector = By.xpath("//UIAStaticText[contains(@name,'climbed')]");
        WebElement text = Grid.driver().findElement(selector);
        Reporter.log(text.getAttribute("name"),true);
    }
}
