package com.meuapp;

import com.meuapp.controller.ScraperController;
import com.meuapp.service.FileZipper;
import com.meuapp.service.PdfExtractor;
import com.meuapp.service.SaveCsv;
import com.meuapp.service.TableExtractor;

public class Main {

    public static void main(String[] args) {
        ScraperController controller = new ScraperController();
        controller.iniciarScraping();
        FileZipper.compactarAnexos();

        String caminhoPdf = "C:\\Users\\USER\\OneDrive\\Documentos\\estudos\\Projetos-Java\\Intuitive-care\\downloads\\Anexo I.pdf";
        String caminhoCsv = "C:\\Users\\USER\\OneDrive\\Documentos\\estudos\\Projetos-Java\\Intuitive-care\\downloads";
        // Chama o método para extrair texto
        PdfExtractor.extrairTextoDePdf(caminhoPdf);
        // Chama o método para processar a tabela
        TableExtractor.extrairTabelaDePdf(caminhoPdf);
        // Salvar a tabela em CSV
        SaveCsv.salvarTabelaEmCsv(caminhoCsv);

        System.out.println("Programa finalizado com sucesso!");
    }
}
