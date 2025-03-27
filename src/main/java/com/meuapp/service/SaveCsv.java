package com.meuapp.service;

import com.opencsv.CSVWriter;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SaveCsv {
    public static void salvarTabelaEmCsv(String caminhoCsv) {
        try {
            // Carregar o documento PDF
            File pdf = new File("C:\\Users\\USER\\OneDrive\\Documentos\\estudos\\Projetos-Java\\Intuitive-care\\downloads\\Anexo I.pdf");
            PDDocument document = Loader.loadPDF(pdf);
            PDFTextStripper stripper = new PDFTextStripper();
            String texto = stripper.getText(document);

            // Divida o texto por linhas
            String[] linhas = texto.split("\n");

            // Criar o arquivo CSV
            FileWriter fileWriter = new FileWriter(caminhoCsv);
            CSVWriter csvWriter = new CSVWriter(fileWriter);

            // Processar cada linha e salvar no CSV
            for (String linha : linhas) {
                // Divida a linha em colunas com base em dois ou mais espaços
                String[] colunas = linha.split("\\s{2,}");

                // Escrever a linha no arquivo CSV
                csvWriter.writeNext(colunas);
            }

            // Fechar os recursos
            csvWriter.close();
            document.close();

            System.out.println("[INFO] Tabela salva em CSV com sucesso!");

        } catch (IOException e) {
            System.out.println("[ERRO] Não foi possível ler o arquivo PDF ou salvar o CSV: " + e.getMessage());
        } finally {
            System.out.println("[INFO] Tabela salva com sucesso!");
        }
    }
}
