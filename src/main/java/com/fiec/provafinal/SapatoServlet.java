package com.fiec.provafinal;

import com.fiec.provafinal.models.sapato;
import com.fiec.provafinal.models.SapatoRepositorio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/sapato")
public class SapatoServlet extends HttpServlet {

    private SapatoRepositorio sapatoRepositorio;
    private EntityManager em;

    public SapatoServlet(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("minhaUnidadeDePersistencia");
        this.em = entityManagerFactory.createEntityManager();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String preco = request.getParameter("preco");
        String imagem = request.getParameter("imagem");
        sapato p = sapato.builder()
                .nome(nome)
                .preco(Double.valueOf(preco))
                .imagemUrl(imagem)
                .build();



        response.setContentType("text/html");
        response.getWriter().println("Sapato Salvo");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        List<sapato> sapatos = sapatoRepositorio.ler();

        response.getWriter().println(sapatos.stream().map(sapato::toString).collect(Collectors.toList()));

    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = getId(request);


        response.setContentType("text/html");
        response.getWriter().println("Sapato Atualizado");

    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String id = getId(request);

        response.setContentType("text/html");
        response.getWriter().println("Sapato Deletado");
    }

    private static String getId(HttpServletRequest req){
        String path = req.getPathInfo();
        String[] paths = path.split("/");
        String id = paths[paths.length - 1];
        return id;
    }

}