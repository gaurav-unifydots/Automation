package com.unifydots.tests;

import com.unifydots.base.BaseTest;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest  {

    private static org.apache.log4j.Logger log = Logger.getLogger(PropertiesTest.class);


    @Test(description = "Properties Test")
    public void PrintNumbers() throws IOException {
        Properties application=BaseTest.readPropertiesFileContents("EN","COMMON");
        log.debug("base url value from property file ");
        String value=BaseTest.getEnvironmentConfig("base.url");
        log.error(value);
        value=BaseTest.getCountryConfig("base.url");
        log.info(value);

    }

}
