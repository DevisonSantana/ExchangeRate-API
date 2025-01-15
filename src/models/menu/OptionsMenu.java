package models.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import models.http.RequestAPI;

public class OptionsMenu {
    private Scanner scanner = new Scanner(System.in);

    public void main() {
        int key = -1;
        while (key != 0) {

            System.out.println("""
                    1 - listar codigos
                    2 - fazer conversão
                    0 - sair
                    """);
            try {
                key = scanner.nextInt();
                switch (key) {
                    case 1:
                        listSupportedCodes();
                        break;
                    case 2:
                        moedaSelecionar();
                        break;
                    default:
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção não reconhecida");
            }
        }
    }

    private void listSupportedCodes() {
        RequestAPI requestAPI = new RequestAPI();
        var codigos = requestAPI.showCodes();
        codigos.forEach(System.out::println);
    }

    private void moedaSelecionar() {
        Scanner leitura = new Scanner(System.in);
        RequestAPI requestAPI = new RequestAPI();

        System.out.println("Selecione o codigo de moeda que será convertida");
        String codigoMoeda = leitura.nextLine().toUpperCase();
        scanner.nextLine();

        System.out.println("Selecione o codigo da moeda para qual moeda você quer converter");
        String codigoMoedaConverter = leitura.nextLine().toUpperCase();

        System.out.println("Digite um valor a ser convertido");
        String valor = leitura.nextLine();
        
        var x = requestAPI.converteMoeda(codigoMoeda, codigoMoedaConverter, valor);

        System.out.println("""
                Moeda base: %s
                Moeda para conversão: %s
                Valor de taxa: %s
                Valor %s %s convertido: %s
                """.formatted(x.getBase(),
                x.getAlvo(),
                x.getTaxa(),
                codigoMoeda,
                valor,
                x.getValorConvertido()));
    }
}
