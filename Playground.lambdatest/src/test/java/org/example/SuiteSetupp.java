package org.example;

import org.testng.annotations.BeforeSuite;

public class SuiteSetupp {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite(){
        System.out.println("beforeSuite");
    }
}