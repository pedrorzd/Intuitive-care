package com.meuapp.service;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class TableExtractor {
    public static void extrairTabelaDePdf(String caminhoPdf) {
        try {
            // Carregar o documento PDF
            File pdf = new File("C:\\Users\\USER\\OneDrive\\Documentos\\estudos\\Projetos-Java\\Intuitive-care\\downloads\\Anexo I.pdf");
            PDDocument document = Loader.loadPDF(pdf);
            PDFTextStripper stripper = new PDFTextStripper();
            String texto = stripper.getText(document);

            // Divida o texto por linhas
            String[] linhas = texto.split("\n");
            System.out.println("[INFO] Tabela extraída:");

            // Exemplo simples: separando colunas por espaços ou tabulação
            for (String linha : linhas) {
                // Separa a linha em colunas com base em dois ou mais espaços
                String[] colunas = linha.split("\\s{2,}");

                // Exibir as colunas de cada linha
                for (String coluna : colunas) {
                    System.out.print(coluna + " | ");
                }
                System.out.println();
            }

            document.close();
        } catch (IOException e) {
            System.out.println("[ERRO] Não foi possível ler o arquivo PDF: " + e.getMessage());
        } finally {
            System.out.println("");
        }
    }
}
