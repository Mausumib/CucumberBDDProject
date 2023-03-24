package com.planit.stepdefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="./src/test/resources/features",glue= "com.planit.stepdefinitions",
 monochrome=true, plugin = {"pretty","html:target/cucumber-report/cucumber.html"}, tags="@PlanitTest"
)

public class TestRunner {

}
