package br.ufac.tate.controller;

import org.springframework.web.bind.annotation.RestController;

import br.ufac.tate.service.testeArquivo;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/arquivo")
public class testeLerArquivo {
    @Autowired
    private testeArquivo testeArquivoService;

    @GetMapping("/ler")
    public String lerArquivo() {
        try {
            String conteudo = testeArquivoService.lerArquivo("C:\\Users\\marco\\Downloads\\ACÓRDÃO  2024 - 01 - DISTRIBUIDORA ALMEIDA LIMA LTDA  2016-93-15857.docx");
            return "Arquivo lido com sucesso!\n" + conteudo;
        } catch (IOException e) {
            return "Erro ao ler arquivo Word: " + e.getMessage();
        }
    }
}
