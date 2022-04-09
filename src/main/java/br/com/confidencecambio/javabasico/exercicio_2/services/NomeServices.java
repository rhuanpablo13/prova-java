package br.com.confidencecambio.javabasico.exercicio_2.services;

import br.com.confidencecambio.javabasico.exercicio_2.abs.Entidade;

public class NomeServices {
    
    public boolean criarEntidade(Entidade entidade) {
        // Nome não pode ser nulo
        // Nome não pode ser vazio
        if (entidade.getNome() == null || entidade.getNome().isBlank()) {
            System.out.println("Nome não pode ser nulo ou vazio!");
            return false;
        }

        // Nome não pode conter espaços extras no início e no fim
        if (isEspacoEmBrancoInicioEFim(entidade.getNome())) {
            System.out.println("O nome não pode conter espaços em branco no inicio e/ou fim");
            return false;
        }

        System.out.println("parabéns vc criou uma entidade: " + entidade.getNome());
        return true;
    }

    // Deve ser possível obter o primeiro nome. Exemplo: Se o nome for "João Soares Silva", deve retornar "João".
    public String getPrimeiroNome(String nome) {
        String arr[] = nome.split(" ", 2);
        if (arr.length > 0) return arr[0];
        return nome;
    }

    // Retornar o último nome. Exemplo: Se o nome for "João Soares Silva", deve retornar "Soares Silva".
    public String getUltimoNome(String nome) {
        String arr[] = nome.split(" ", 2);
        if (arr.length > 0) return arr[1];
        return nome;
    }

    // Retornar o nome todo em letras maiúsculas.
    public String getNomeMaiusculo(String nome) {
        return nome.toUpperCase();
    }

    // Retornar o nome abreviado. Exemplo: Se o nome for "João Soares Silva", retornar "João S. Silva".
    public String getNomeAbreviado(String nome) {
        String arr[] = nome.split(" ");
        String temp = "";
        if (arr.length > 0) {
            for (int i = 1; i < arr.length-1; i++) {
                temp += " " + arr[i].substring(0, 1) + ". ";
            }
            temp = arr[0] + temp + arr[arr.length - 1];
        } else {
            temp = nome.substring(0, 1) + ". ";
        }
        return temp;
    }

    private boolean isEspacoEmBrancoInicioEFim(String str) {
        if (str.length() == 0) return false;
        return Character.isWhitespace(str.charAt(str.length() - 1)) || Character.isWhitespace(str.charAt(0));
    }
}
