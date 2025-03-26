package com.meuapp.controller;

import com.meuapp.service.FileDownloader;
import com.meuapp.service.FileZipper;
import com.meuapp.service.WebScraper;

import java.io.IOException;
import java.util.Map;

public class ScraperController {

    private static final String OUTPUT_FOLDER = "downloads/";

    public void iniciarScraping() {
        try {
            // Buscar os links dos Anexos
            Map<String, String> anexos = WebScraper.buscarLinksAnexos();

            // Baixar os arquivos
            for (Map.Entry<String, String> entry : anexos.entrySet()) {
                String fileName = entry.getKey() + ".pdf";
                String fileURL = entry.getValue();
                FileDownloader.downloadFile(fileURL, OUTPUT_FOLDER + fileName);
            }

            // Compactar os arquivos baixados em um ZIP
            FileZipper.zipFiles(OUTPUT_FOLDER, OUTPUT_FOLDER + "anexos.zip");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
