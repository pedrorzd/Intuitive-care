package com.meuapp.service;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PdfExtractor {
    // Metodo para extrair texto do PDF
    public static void extrairTextoDePdf(String caminhoPdf) {
        try {
            // Carregar o documento PDF
            File pdf = new File("C:\\Users\\USER\\OneDrive\\Documentos\\estudos\\Projetos-Java\\Intuitive-care\\downloads\\Anexo I.pdf");
            PDDocument document = Loader.loadPDF(pdf);

            // Criar o stripper para extrair texto
            PDFTextStripper stripper = new PDFTextStripper();

            // Extrair todo o texto
            String texto = stripper.getText(document);
            System.out.println("[INFO] Texto extraído do PDF:");
            System.out.println(texto);

            // Fechar o documento
            document.close();

        } catch (IOException e) {
            System.out.println("[ERRO] Não foi possível ler o arquivo PDF: " + e.getMessage());
        } finally {
            System.out.println("[INFO] Fim do arquivo PDF!");
        }
    }
}