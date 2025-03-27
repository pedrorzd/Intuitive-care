package com.meuapp;

import com.meuapp.controller.ScraperController;
import com.meuapp.service.FileZipper;

public class Main {

    public static void main(String[] args) {
        ScraperController controller = new ScraperController();
        controller.iniciarScraping();
        FileZipper.compactarAnexos();
        System.out.println("Programa finalizado com sucesso!");
    }
}
