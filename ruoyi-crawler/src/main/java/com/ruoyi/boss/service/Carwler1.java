package com.admin.boss.service;

import cn.hutool.core.map.MapBuilder;
import com.admin.common.core.domain.entity.SysUser;
import com.admin.common.utils.spring.SpringUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Service
@Slf4j
public class Carwler1 {

    public void boss() throws IOException {
        WebDriverManager.chromedriver().setup();

        // 设置浏览器参数
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        /**
         excludeSwitches", Arrays.asList("enable-automation")在高版本的谷歌浏览器是无法屏蔽
         window.navigator.webdriver 为false 的特征，这里写出来是为了配合其他参数来关闭浏览器上显示"正在收到自动测试软件控制"的提示
         **/
        options.setExperimentalOption("excludeSwitches", Arrays.asList("enable-automation"));
        options.addArguments("--disable-blink-features");
        options.addArguments("--disable-blink-features=AutomationControlled");
        options.setExperimentalOption("useAutomationExtension", false);

        options.setExperimentalOption("prefs", prefs);
        ChromeDriver driver = new ChromeDriver(options);

        driver.manage().window().setSize(new Dimension(1280, 1024));

        // 去除seleium全部指纹特征
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("stealth.min.js");
        byte[] bytes = new byte[0];
        bytes = new byte[inputStream.available()];
        inputStream.read(bytes);
        String js = new String(bytes);
        // MapBuilder是依赖hutool工具包的api
        Map<String, Object> commandMap = MapBuilder.create(new LinkedHashMap<String, Object>()).put("source", js)
                .build();
        // executeCdpCommand这个api在selenium3中是没有的,请使用selenium4才能使用此api
        //driver.executeScript("Page.addScriptToEvaluateOnNewDocument", commandMap);


        try {
           // driver.get("https://www.baidu.com/link?url=IhCvmpkYmHBGOVmdairPSzG4XkfL2YZL_AQDEr6z4Ni&wd=&eqid=f828b2220000ef620000000262e934e1");
           // driver.get("https://bot.sannysoft.com/ ");
            driver.get("https://www.zaixian100f.com/home/index/index/id/1523");
            driver.manage().addCookie(new Cookie("Hm_lpvt_8467c6755112b28be8e7a016946a672e", "1663421958"));
            driver.manage().addCookie(new Cookie("Hm_lvt_8467c6755112b28be8e7a016946a672e", "1663421562"));
            driver.manage().addCookie(new Cookie("HMACCOUNT_BFESS", "5B7825F598C819D4"));
            driver.manage().addCookie(new Cookie("zaixian100forganization_url", "https://www.zaixian100f.com/home/index/index/id/1523"));
            driver.manage().addCookie(new Cookie("zaixian100forganization_id", "1523"));
            driver.manage().addCookie(new Cookie("zaixian100forganization_name", "河北冶金建设集团有限公司"));
            driver.manage().addCookie(new Cookie("PHPSESSID", "i8tio78hqjcva3qpqnbcb5nec6"));

            driver.navigate().refresh(); //刷新页面
            driver.navigate().to("https://www.zaixian100f.com/exam/test_paper/item/term_id/149.html"); //答题页面

            // 遍历题库
            String html = driver.getPageSource();
            log.info(html);
            // 保存数据

            WebElement fruits = driver.findElement(By.id("fruits"));


            Document document = Jsoup.parse(html);
            MongoTemplate mongoTemplate = SpringUtils.getBean(MongoTemplate.class);
            SysUser sysUser = new SysUser();
            sysUser.setUserId(11L);

            mongoTemplate.insert(sysUser);

            driver.getTouch();
            WebElement elements = driver.findElement(By.tagName("body"));

            String s1 = elements.getText().toString();
            System.out.println(s1);
            String s = driver.getTitle().toString();
            System.out.println(s);
        } finally {
            //driver.close();
        }


    }
}
