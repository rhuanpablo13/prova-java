package br.com.confidencecambio.javabasico.service;


import org.junit.Before;
import org.junit.Test;

import br.com.confidencecambio.javabasico.exercicio_2.modelos.Cliente;
import br.com.confidencecambio.javabasico.exercicio_2.services.NomeServices;

import static org.junit.Assert.assertEquals;

public class NomeServiceTest {

    private NomeServices service;
    private String nomeTest = "João Soares Silva";

    @Before
    public void init(){
         service = new NomeServices();
    }


    @Test
    public void quandoPassarUmNomeNuloRetornaFalse(){
        boolean retorno = service.criarEntidade(new Cliente(null));
        assertEquals(retorno, false);
    }

    @Test
    public void quandoPassarUmNomeBrancoRetornaFalse(){
        boolean retorno = service.criarEntidade(new Cliente(" "));
        assertEquals(retorno, false);
    }

    @Test
    public void quandoPassarUmNomeBrancoInicioEFimRetornaFalse(){
        boolean retorno = service.criarEntidade(new Cliente(" João Silva "));
        assertEquals(retorno, false);
    }

    @Test
    public void primeiroNome(){
        String retorno = service.getPrimeiroNome(nomeTest);
        assertEquals(retorno, "João");
    }

    @Test
    public void ultimoNome(){
        String retorno = service.getUltimoNome(nomeTest);
        assertEquals(retorno, "Soares Silva");
    }

    @Test
    public void nomeLetrasMaiusculas(){
        String retorno = service.getNomeMaiusculo(nomeTest);
        assertEquals(retorno, "JOÃO SOARES SILVA");
    }

    @Test
    public void nomeAbreviado(){
        String retorno = service.getNomeAbreviado(nomeTest);
        assertEquals(retorno, "João S. Silva");
    }

}