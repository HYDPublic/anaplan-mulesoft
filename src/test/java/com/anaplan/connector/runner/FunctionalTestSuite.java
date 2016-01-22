package com.anaplan.connector.runner;

import com.anaplan.connector.functional.DeleteFromModelTestCases;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import com.anaplan.connector.functional.ExportFromModelTestCases;
import com.anaplan.connector.functional.ImportToModelTestCases;
import com.anaplan.connector.functional.RunProcessTestCases;
import com.anaplan.connector.AnaplanConnector;
import org.mule.tools.devkit.ctf.mockup.ConnectorTestContext;

@RunWith(Suite.class)
@SuiteClasses({
        DeleteFromModelTestCases.class,
        ExportFromModelTestCases.class,
        ImportToModelTestCases.class,
        RunProcessTestCases.class})
public class FunctionalTestSuite {

    @BeforeClass
    public static void initialiseSuite() {
        ConnectorTestContext.initialize(AnaplanConnector.class);
    }

    @AfterClass
    public static void shutdownSuite() {
        ConnectorTestContext.shutDown();
    }

}