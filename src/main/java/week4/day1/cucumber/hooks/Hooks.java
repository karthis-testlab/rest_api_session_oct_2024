package week4.day1.cucumber.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class Hooks {
	
	@Before
	public void runBeforeScenario() {
		System.err.println("Running before each scenario.");
	}
	
	@After
	public void runAfterScenario() {
		System.err.println("Running after each scenario.");
	}
	
	@BeforeStep
	public void runBeforeEachStep() {
		System.err.println("Running before each scenario step.");
	}
	
	@AfterStep
	public void runAfterEachStep() {
		System.err.println("Running after each scenario step.");
	}

}