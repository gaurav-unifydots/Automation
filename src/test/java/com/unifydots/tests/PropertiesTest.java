package com.unifydots.tests;

import com.unifydots.base.WebBase;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Properties;

public class PropertiesTest  {

    private static org.apache.log4j.Logger log = Logger.getLogger(PropertiesTest.class);


    @Test(description = "Properties Test")
    public void PrintNumbers() throws IOException {
        Properties application= WebBase.readPropertiesFileContents("EN","COMMON");
        log.debug("base url value from property file ");
        String value= WebBase.getEnvironmentConfig("base.url");
        Assert.assertNotNull(value,"Base URL cannot be null");
        value= WebBase.getCountryConfig("base.url");
        Assert.assertNotNull(value,"Base URL cannot be null");

    }

}
