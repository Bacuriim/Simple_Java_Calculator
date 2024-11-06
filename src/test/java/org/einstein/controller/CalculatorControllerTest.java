package org.einstein.controller;

import javafx.scene.control.Button;
import org.junit.Before;
import org.testfx.framework.junit.ApplicationTest;

import static org.mockito.Mockito.spy;

public class CalculatorControllerTest extends ApplicationTest {
	private CalculatorController controller;
	
	@Before
	public void setUp() {
		controller = spy(CalculatorController.class);
		
		controller.buttonForOne = new Button();
		controller.buttonForTwo = new Button();
		controller.buttonForThree = new Button();
		controller.buttonForFour = new Button();
		controller.buttonForFive = new Button();
		controller.buttonForSix = new Button();
		controller.buttonForSeven = new Button();
		
		
		
		controller.buttonForOne = new Button();
		controller.buttonForOne = new Button();
		controller.buttonForOne = new Button();
		controller.buttonForOne = new Button();
		controller.buttonForOne = new Button();
		controller.buttonForOne = new Button();
		controller.buttonForOne = new Button();
		controller.buttonForOne = new Button();
	}
}
