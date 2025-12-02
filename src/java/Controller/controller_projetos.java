/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;


import DAO.ProjetosDAO;
import Model.Projetos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author proft
 */
@WebServlet(name = "controller_projetos", urlPatterns = {"/controller_projetos"})
public class controller_projetos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
            
            String op = request.getParameter("op");
            String Button = request.getParameter("Button");
            ProjetosDAO pdao = new ProjetosDAO();
            Projetos p = new Projetos();
            
            String idStr = request.getParameter("id");
            Integer id = null;
            if (idStr != null && !idStr.isEmpty()) {
                try {
                    id = Integer.parseInt(idStr);
                } catch (NumberFormatException e) {
                    // ...
                }
            }    
            
            
            if ("CADASTRAR".equals(op)) {
                String nome = request.getParameter("nome");
                String desc = request.getParameter("descricao");
                String cliente = request.getParameter("cliente");
                String Strdataincio = request.getParameter("dataInicio");
                String Strdatafim = request.getParameter("dataFim");
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date datainicio = sdf.parse(Strdataincio);
                    Date datafim = sdf.parse(Strdatafim);
                    String responsavel = request.getParameter("responsavel");
                    String status = request.getParameter("Status");
                    double orcamento = Double.parseDouble(request.getParameter("orcamento"));
                    String prioridade = request.getParameter("Prioridade");
                    p.setNome(nome);
                    p.setDescricao(desc);
                    p.setCliente(cliente);
                    p.setDatainicio(datainicio);
                    p.setDatafimprevista(datafim);
                    p.setResponsavel(responsavel);
                    p.setStatus(status);
                    p.setOrcamento(orcamento);
                    p.setPrioridade(prioridade);
                    String msg = "Cadastrar";
                    try {
                        pdao.cadastrar(p);
                        System.out.println("Cadastrado com sucesso!!");
                        request.setAttribute("message", msg);
                        //request.getRequestDispatcher("index.jsp").forward(request, response);
                    } catch (ClassNotFoundException | SQLException ex) {
                        System.out.println("Erro ClassNotFound: " + ex.getMessage());
                        request.setAttribute("message", msg);
                        //request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
   
                } catch (ParseException e) {
                    e.printStackTrace();
                }    
            }else if("DELETAR".equals(op)){
                if(id != null){
                    p.setId(id);
                    try {
                        pdao.deletar(p);
                        List<Projetos> lprod = pdao.consultarTodos();
                        request.setAttribute("lprod", lprod);
                    } catch (ClassNotFoundException | SQLException ex){
                        System.out.println("Erro ClassNotFound: " + ex.getMessage());
                    }
                }else {
                    request.setAttribute("message", "ID do projeto é necessário para deletar.");
                }    
            }else if("EDITAR".equals(Button)){
                p.setId(id);
                try {
                    p = pdao.consultarByID(p);
                    request.setAttribute("p", p);
                    request.getRequestDispatcher("atualizarProjetos.jsp").forward(request, response);
                }catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ClassNotFound: " + ex.getMessage());
                }
            }else if ("ATUALIZAR".equals(op)) {
                if(id != null){
                    p.setId(id);
                    String nome = request.getParameter("nome");
                    String desc = request.getParameter("descricao");
                    String cliente = request.getParameter("cliente");
                    String Strdataincio = request.getParameter("dataInicio");
                    String Strdatafim = request.getParameter("dataFim");
                    try {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date datainicio = sdf.parse(Strdataincio);
                    Date datafim = sdf.parse(Strdatafim);
                    String responsavel = request.getParameter("responsavel");
                    String status = request.getParameter("Status");
                    double orcamento = Double.parseDouble(request.getParameter("orcamento"));
                    String prioridade = request.getParameter("Prioridade");
                    p.setNome(nome);
                    p.setDescricao(desc);
                    p.setCliente(cliente);
                    p.setDatainicio(datainicio);
                    p.setDatafimprevista(datafim);
                    p.setResponsavel(responsavel);
                    p.setStatus(status);
                    p.setOrcamento(orcamento);
                    p.setPrioridade(prioridade);
                    String msg = "Atualizar";
                        try {
                            pdao.atualizar(p);
                            System.out.println("Atuaizado com sucesso!!");
                            request.setAttribute("message", msg);
                            //request.getRequestDispatcher("index.jsp").forward(request, response);
                        } catch (ClassNotFoundException | SQLException ex) {
                            System.out.println("Erro ClassNotFound: " + ex.getMessage());
                            request.setAttribute("message", msg);
                            //request.getRequestDispatcher("index.jsp").forward(request, response);
                        }
                    }catch (ParseException e) {
                        e.printStackTrace();
                    } 
                
                }
            }else if("PESQUISARID".equals(op)){
                String consultaIDStr = request.getParameter("InputID");
                List<Projetos> projetosEncontrados = new ArrayList<>();
                try{
                    int consultaID = Integer.parseInt(consultaIDStr);
                    p.setId(consultaID);
                    Projetos projetoBuscado = pdao.consultarByID(p);
                    if (projetoBuscado != null) {
                        projetosEncontrados.add(projetoBuscado);
                    } else {
                        request.setAttribute("message", "Projeto com ID " + consultaID + " não encontrado.");
                    }
                    
                    request.setAttribute("proj", projetosEncontrados);
                }catch (NumberFormatException e) {
                    request.setAttribute("message", "O ID de pesquisa deve ser um número válido.");
                    request.setAttribute("proj", new java.util.ArrayList<Projetos>()); // Passa lista vazia
                } catch (ClassNotFoundException | SQLException ex) {
                    System.out.println("Erro ao buscar projeto por ID: " + ex.getMessage());
                    request.setAttribute("message", "Erro ao acessar o banco de dados.");
                        request.setAttribute("proj", new java.util.ArrayList<Projetos>()); // Passa lista vazia
                }
                
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }
//     
            List<Projetos> proj = null;
            try {
              proj = pdao.consultarTodos();
              request.setAttribute("proj", proj);
            } catch (ClassNotFoundException | SQLException e) {
              e.printStackTrace();
              System.out.println("Erro ao consultar todos os projetos: " + e.getMessage());
              request.setAttribute("proj", null);
              request.setAttribute("message", "ERRO: Não foi possível carregar a lista de projetos.");
            }
            
            // Apenas 1 forward
            request.getRequestDispatcher("index.jsp").forward(request, response);
            
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
