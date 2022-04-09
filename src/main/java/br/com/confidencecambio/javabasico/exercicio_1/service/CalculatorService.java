package br.com.confidencecambio.javabasico.exercicio_1.service;

import org.springframework.stereotype.Service;

import br.com.confidencecambio.javabasico.exercicio_1.calculator.interfaces.HeathCalculatorStrategy;

@Service
public class CalculatorService {
    
    public double calculate(HeathCalculatorStrategy heathCalculatorStrategy) {
        return heathCalculatorStrategy.calculate();
    }
}
