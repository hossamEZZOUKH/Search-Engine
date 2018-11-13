/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m2i;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.io.*;
import java.util.Iterator;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static m2i.recherche.rech;


//@WebServlet("/servlet0")
public class servlet0 extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
    	
      response.setContentType("text/html;charset=UTF-8");
      String url="";
        String text=request.getParameter("text1");
                String text9=request.getParameter("text1");
if(text.equals("")){
  RequestDispatcher re=request.getRequestDispatcher("/P1.jsp");
    re.forward(request, response);
                 }
        String lang1=request.getParameter("lang");
         String la=request.getParameter("mot");
        String lang2=request.getParameter("langRcherche");
            String trad=request.getParameter("tra");
            text=toknization.supprimmeMotVide(lang1,text);
         HashSet<String> tra=traduction.tra(text, lang1, lang2,la);
          HashSet<String> urel= new  HashSet<String>();
          
          if(trad.equals("Tr")){    Iterator<String> it=tra.iterator();
         while(it.hasNext()){
             String te=it.next();
             String[] yyy=rech(te, lang2,la.trim()).split("</br>");
             for(String g:yyy)
             urel.add(g);
         }
                
         
         
         
         for(String t:urel){url=url+""+t;}
        System.out.println(""+url);
           }else{
              url=rechercgeD.rech(text, lang1, lang2, la);
          }

          
          String a=Tradu.tra(text9.trim(), lang1, lang2);
              request.setAttribute("a", a);
        request.setAttribute("url", url);
    RequestDispatcher re=request.getRequestDispatcher("/P1.jsp");
    re.forward(request, response);
                 
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
     
        try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
     
        try {
			processRequest(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
