/*
package br.com.projeto.erudio.controller;

import br.com.projeto.erudio.exceptions.ResourceNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static br.com.projeto.erudio.util.Util.convertToDouble;
import static br.com.projeto.erudio.util.Util.isNumeric;


@RestController
public class MathController {


    @RequestMapping(value = "/soma/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double soma(@PathVariable(value = "numberOne") String numberOne,
                       @PathVariable(value = "numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("FORMATO DE NUMERO E INVALIDO");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/multiplicacao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiplicacao(@PathVariable(value = "numberOne") String numberOne,
                                @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("FORMATO DE NUMERO E INVALIDO");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/divisao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divisao(@PathVariable(value = "numberOne") String numberOne,
                          @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("FORMATO DE NUMERO E INVALIDO");
        }
        //se a excecao acima nao stiver ativa entao habilite a excecao abaixo
        if (numberTwo.equalsIgnoreCase("0") || numberTwo.equalsIgnoreCase("-0") || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("FORMATO DE NUMERO E INVALIDO PARA O DENOMINADOR");
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/subtracao/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtracao(@PathVariable(value = "numberOne") String numberOne,
                            @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("FORMATO DE NUMERO E INVALIDO");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping(value = "/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double media(@PathVariable(value = "numberOne") String numberOne,
                        @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("FORMATO DE NUMERO E INVALIDO");
        }

        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2;
    }

    @RequestMapping(value = "/raizquadradamultipla/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double raizQuadradaMultipla(@PathVariable(value = "numberOne") String numberOne,
                                       @PathVariable(value = "numberTwo") String numberTwo) {

        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new ResourceNotFoundException("FORMATO DE NUMERO E INVALIDO");
        }
        return Math.sqrt(convertToDouble(numberOne) + convertToDouble(numberTwo));
    }

    @RequestMapping(value = "/raizquadrada/{numberOne}", method = RequestMethod.GET)
    public Double raizQuadrada(@PathVariable(value = "numberOne") String numberOne) {

        if (!isNumeric(numberOne)) {
            throw new ResourceNotFoundException("FORMATO DE NUMERO E INVALIDO");
        }
        return Math.sqrt(convertToDouble(numberOne));
    }


}*/
