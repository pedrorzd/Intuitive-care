package com.meuapp.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WebScraper {

    private static final String ANS_URL = "https://www.gov.br/ans/pt-br/acesso-a-informacao/participacao-dasociedade/atualizacao-do-rol-de-procedimentos";

    public static Map<String, String> buscarLinksAnexos() {
        Map<String, String> anexos = new HashMap<>();

        try {
            Document doc = Jsoup.connect(ANS_URL).get();

            Elements links = doc.select("a[href]");

            for (Element link : links) {
                String url = link.absUrl("href");
                String texto = link.text();

                if (texto.contains("Anexo I")) {
                    anexos.put("Anexo I", url);
                } else if (texto.contains("Anexo II")) {
                    anexos.put("Anexo II", url);
                }
            }

            if (anexos.isEmpty()) {
                System.out.println("Nenhum link de anexo encontrado.");
            } else {
                System.out.println("Links encontrados: " + anexos);
            }

        } catch (IOException e) {
            System.out.println("Erro ao acessar o site da ANS: " + e.getMessage());
        }

        return anexos;
    }
}
