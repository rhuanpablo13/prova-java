package br.com.confidencecambio.javabasico.exercicio_1.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.confidencecambio.javabasico.exercicio_1.calculator.IMCCalculator;
import br.com.confidencecambio.javabasico.exercicio_1.dto.ImcDTO;
import br.com.confidencecambio.javabasico.exercicio_1.service.CalculatorService;

@RestController
@RequestMapping(value = "/calculator")
public class CalculatorController {
    
    @Autowired
    private CalculatorService calculatorService;

    @PostMapping("/imc")
    public ResponseEntity<String> calculateIMC(@Validated @RequestBody ImcDTO imcDTO, BindingResult bindResult) {

        List<String> errors = new ArrayList<>();
        
        // validação básica para entrada de dados
        validateImcDto(imcDTO, bindResult);
        if (bindResult.hasErrors()) {
            bindResult.getAllErrors().forEach(e -> errors.add(e.getDefaultMessage()));
            return ResponseEntity.badRequest().body(errors.toString());
        }

        // calculadora de imc
        IMCCalculator imcCalculator = new IMCCalculator(imcDTO.getHeight(), imcDTO.getWeight());
        double imc = calculatorService.calculate(imcCalculator);
        return ResponseEntity.ok("Seu imc é de: " + String.format("%.2f", imc));
    }


    private void validateImcDto(ImcDTO imcDTO, BindingResult bindResult) {
        if (imcDTO == null) {
            bindResult.addError(new ObjectError(ImcDTO.class.getSimpleName(), "Erro ao processar requisição"));
            return;
        }

        if (imcDTO.getHeight() == null || imcDTO.getHeight() < 1) {
            bindResult.addError(new ObjectError(ImcDTO.class.getSimpleName(), "Informe uma altura válida"));
        }

        if (imcDTO.getWeight() == null || imcDTO.getWeight() < 1) {
            bindResult.addError(new ObjectError(ImcDTO.class.getSimpleName(), "Informe um peso válido"));
        }
    }
}
