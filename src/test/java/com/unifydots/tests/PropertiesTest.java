package com.unifydots.tests;

import com.unifydots.base.BaseTest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest  {

    public static Logger log = LogManager.getLogger();


    @Test(description = "Properties Test")
    public void PrintNumbers() throws IOException {
        Properties application=BaseTest.readPropertiesFileContents("EN","COMMON");
        log.debug("base url value from property file ");

    }

}
