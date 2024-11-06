package org.einstein.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextFormatter;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculatorController implements Initializable {

	@FXML
	protected TextArea taResult;
	
	@FXML
	protected Button buttonForOne;

	@FXML
	protected Button buttonForTwo;

	@FXML
	protected Button buttonForThree;

	@FXML
	protected Button buttonForFour;

	@FXML
	protected Button buttonForFive;

	@FXML
	protected Button buttonForSix;

	@FXML
	protected Button buttonForSeven;

	@FXML
	protected Button buttonForEight;

	@FXML
	protected Button buttonForNine;

	@FXML
	protected Button buttonForZero;

	@FXML
	protected Button buttonPlus;

	@FXML
	protected Button buttonMinus;

	@FXML
	protected Button buttonMulti;

	@FXML
	protected Button buttonDivide;
	
	@FXML
	protected Button buttonPoint;
	
	@FXML
	protected Button buttonResult;
	
	@FXML
	protected Button buttonClear;
	
	@FXML
	protected Button buttonErase;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		setButtons();
		setTextArea();
	}
	
	public void setTextArea() {
		taResult.textProperty().addListener((observable, oldValue, newValue) -> {
			applyInputFilter();
		});
		taResult.setOpacity(100);
		taResult.setDisable(true);
	}
	
	public void setButtons() {
		setButtonForZero();
		setButtonForOne();
		setButtonForTwo();
		setButtonForThree();
		setButtonForFour();
		setButtonForFive();
		setButtonForSix();
		setButtonForSeven();
		setButtonForEight();
		setButtonForNine();
		
		setButtonPlus();
		setButtonMinus();
		setButtonMulti();
		setButtonDivide();
		setButtonPoint();
		
		setButtonResult();
		setButtonClear();
		setButtonErase();
	}

	public void setButtonForZero() {
		buttonForZero.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("0"));
		});
	}
	
	public void setButtonForOne() {
		buttonForOne.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("1"));
		});
	}
	
	public void setButtonForTwo() {
		buttonForTwo.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("2"));
		});
	}

	public void setButtonForThree() {
		buttonForThree.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("3"));
		});
	}

	public void setButtonForFour() {
		buttonForFour.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("4"));
		});
	}

	public void setButtonForFive() {
		buttonForFive.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("5"));
		});
	}

	public void setButtonForSix() {
		buttonForSix.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("6"));
		});
	}

	public void setButtonForSeven() {
		buttonForSeven.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("7"));
		});
	}

	public void setButtonForEight() {
		buttonForEight.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("8"));
		});
	}

	public void setButtonForNine() {
		buttonForNine.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("9"));
		});
	}

	public void setButtonPlus() {
		buttonPlus.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("+"));
		});
	}

	public void setButtonMinus() {
		buttonMinus.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("-"));
		});
	}

	public void setButtonMulti() {
		buttonMulti.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("x"));
		});
	}

	public void setButtonDivide() {
		buttonDivide.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculatorsText("/"));
		});
	}
	
	public void setButtonPoint() {
		buttonPoint.setOnAction(event -> {
			taResult.setText(taResult.getText() + ".");
		});
	}
	
	public void setButtonResult() {
		buttonResult.setOnAction(event -> {
			clearResultInvalidText();
			taResult.setText(calculateResult());
		});
	}

	public void setButtonClear() {
		buttonClear.setOnAction(event -> {
			taResult.clear();
		});
	}
	
	public void setButtonErase() {
		buttonErase.setOnAction(event -> {
			eraseResultText();
		});
	}
	
	public String calculatorsText(String value) {
		return taResult.getText() + value;
	}
	
	public String calculateSum(String a, String b) {
		a = a.isEmpty() ? "0" : a;
		b = b.isEmpty() ? "0" : b;
		return String.valueOf(Float.parseFloat(a) + Float.parseFloat(b));
	}

	public String calculateSubtract(String a, String b) {
		a = a.isEmpty() ? "0" : a;
		b = b.isEmpty() ? "0" : b;
		return String.valueOf(Float.parseFloat(a) - Float.parseFloat(b));
	}

	public String calculateMultiplication(String a, String b) {
		a = a.isEmpty() ? "0" : a;
		b = b.isEmpty() ? "0" : b;
		return String.valueOf(Float.parseFloat(a) * Float.parseFloat(b));
	}

	public String calculateDivision(String a, String b) {
		a = a.isEmpty() ? "0" : a;
		b = b.isEmpty() ? "0" : b;
		String result;
		try {
			result = !a.equals("0") && b.equals("0") ? "Infinito" : String.valueOf(Float.parseFloat(a) / Float.parseFloat(b));
		} catch (Exception e) {
			result = a.equals("0") && b.equals("0") ? "Indefinido" : String.valueOf(Float.parseFloat(a) / Float.parseFloat(b));
		}
		
		return result;
	}
	
	public String calculateResult() {
		int sumOperatorIndex = taResult.getText().indexOf("+");
		int subtractOperatorIndex = taResult.getText().indexOf("-");
		int multiplicationOperatorIndex = taResult.getText().indexOf("x");
		int divisionOperatorIndex = taResult.getText().indexOf("/");
		String result = taResult.getText();
		if (taResult.getText().contains("x")) {
			result = calculateMultiplication(taResult.getText(0, multiplicationOperatorIndex), taResult.getText(multiplicationOperatorIndex + 1, taResult.getText().length()));
		} else if (taResult.getText().contains("/")) {
			result = calculateDivision(taResult.getText(0, divisionOperatorIndex), taResult.getText(divisionOperatorIndex + 1, taResult.getText().length()));
		} else if (taResult.getText().contains("+")) {
			result = calculateSum(taResult.getText(0, sumOperatorIndex), taResult.getText(sumOperatorIndex + 1, taResult.getText().length()));
		} else if (taResult.getText().contains("-")) {
			result = calculateSubtract(taResult.getText(0, subtractOperatorIndex), taResult.getText(subtractOperatorIndex + 1, taResult.getText().length()));
		}
		return result;
	}
	
	public void clearResultInvalidText() {
		if (taResult.getText().contains("Indefinido")
				|| taResult.getText().contains("Infinito")) {
			taResult.clear();
		}
	}
	
	public void eraseResultText() {
		if (taResult.getText().length() - 1 < 0) return;
		taResult.setText(taResult.getText().substring(0, taResult.getText().length() - 1));
	}

	private void applyInputFilter() {
		taResult.setTextFormatter(new TextFormatter<>(change -> {
			String newText = change.getControlNewText();

			// Regex permite números e operações com apenas um ponto decimal por número
			if (newText.matches("(\\d+(\\.\\d*)?)?([+\\-x/](\\d+(\\.\\d*)?)?)*")) {
				return change;
			}

			return null;
		}));
	}


}
