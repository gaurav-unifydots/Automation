package com.unifydots.tests;

import com.unifydots.base.BaseTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest  {


    @Test(description = "Properties Test")
    public void PrintNumbers() throws IOException {
        Properties application=BaseTest.readPropertiesFileContents("EN","COMMON");
        System.out.println("base url value from property file "+application.getProperty("base.url"));

    }

}
