package br.com.confidencecambio.javabasico.exercicio_1.calculator;

import br.com.confidencecambio.javabasico.exercicio_1.calculator.interfaces.HeathCalculatorStrategy;

public class IMCCalculator implements HeathCalculatorStrategy {

    private Double weight; // peso
    private Double height; // altura

    public IMCCalculator(Double height, Double weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public double calculate() {
        return weight / (height * height);
    }
}
