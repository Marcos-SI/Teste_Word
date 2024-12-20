package br.ufac.tate.service;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.stereotype.Service;

@Service
public class testeArquivo {
    public String lerArquivo(String caminhoArquivo) throws IOException {
        StringBuilder conteudo = new StringBuilder();
        try (FileInputStream arquivo = new FileInputStream(caminhoArquivo);
             XWPFDocument documento = new XWPFDocument(arquivo)) {

            System.out.println("Arquivo encontrado");
            // List<XWPFParagraph> parametro = documento.getParagraphs();
            // for (XWPFParagraph texto : parametro) {
            //     conteudo.append(texto.getText()).append("\n");
            // }

            List<XWPFTable> tabelas = documento.getTables();
            for (XWPFTable tabela : tabelas) {
                for (XWPFTableRow linha : tabela.getRows()) {
                    for (XWPFTableCell celula : linha.getTableCells()) {
                        conteudo.append(celula.getText()).append("\t");
                    }
                    conteudo.append("\n");
                }
                conteudo.append("\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
            throw e;
        }
        return conteudo.toString();
    }
    
}
