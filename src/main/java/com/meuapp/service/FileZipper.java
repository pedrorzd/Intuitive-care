package com.meuapp.service;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

    public class FileZipper {

        private static final String ZIP_FILE = "downloads/anexos.zip"; // Caminho do ZIP final

        public static void compactarAnexos() {
            try {
                File pasta = new File("downloads");
                File[] arquivos = pasta.listFiles((dir, name) -> name.endsWith(".pdf"));

                if (arquivos == null || arquivos.length == 0) {
                    System.out.println("Nenhum arquivo para compactar.");
                    return;
                }

                try (FileOutputStream fos = new FileOutputStream(ZIP_FILE);
                     ZipOutputStream zos = new ZipOutputStream(fos)) {

                    for (File arquivo : arquivos) {
                        adicionarArquivoAoZip(arquivo, zos);
                    }
                }

                System.out.println("Compactação concluída: " + ZIP_FILE);
            } catch (IOException e) {
                System.out.println("Erro ao compactar arquivos: " + e.getMessage());
            }
        }

        private static void adicionarArquivoAoZip(File arquivo, ZipOutputStream zos) throws IOException {
            try (FileInputStream fis = new FileInputStream(arquivo)) {
                ZipEntry zipEntry = new ZipEntry(arquivo.getName());
                zos.putNextEntry(zipEntry);

                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    zos.write(buffer, 0, bytesRead);
                }

                zos.closeEntry();
                System.out.println("Arquivo adicionado ao ZIP: " + arquivo.getName());
            }
        }
    }
