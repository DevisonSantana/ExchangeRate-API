package models.menu;

import java.util.Scanner;

import models.http.RequestAPI;

public class OptionsMenu {
    Scanner scanner = new Scanner(System.in);
    public void main () {
        //TODO menu options select [1- show codes. 2- latest, 3- exchange rate and result]
        try {
            int key = scanner.nextInt();
            switch (key) {
                case 1:
                    listSupportedCodes();
                    break;
                default:
                    break;
            }
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("OCORREU UM ERRO");
        }
    }
    private void listSupportedCodes () {
        RequestAPI requestAPI = new RequestAPI();
        requestAPI.showCodes();
    }
}
