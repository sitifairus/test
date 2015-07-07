/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author on
 */
@WebServlet(name = "surveyServlet", urlPatterns = {"/surveyServlet"})
public class surveyServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            double pnt;
            //double mark = Double.parseDouble(m);
            String fname = request.getParameter("fName");
            String lname = request.getParameter("lName");
            String email = request.getParameter("email");
            String contact = request.getParameter("contact");
            String day = request.getParameter("day");
            String ch[] = new String [6];
            ch[0]=request.getParameter("ch1");
            ch[1]=request.getParameter("ch2");
            ch[2]=request.getParameter("ch3");
            ch[3]=request.getParameter("ch4");
            ch[4]=request.getParameter("ch5");
            ch[5]=request.getParameter("ch6");
            String decade = request.getParameter("decade");
            String listen = request.getParameter("listen");
            String place[] = new String[3];
            place[0] = request.getParameter("place1");
            place[1] = request.getParameter("place2");
            place[2] = request.getParameter("place3");
            String comment = request.getParameter("comment");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet surveyServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>WARNARadio Survey Result</h1>"
                    + "Name of Participent: " + fname + " " + lname  
                    + "<br>Contact Number : " + contact
                    + "<br>Email : " + email
                    + "<br> Musical Preference:<br>");
            int l=1;
            for(int i=0;i<6;i++)
            {
                if(ch[i]!=null)
                {
                    out.println((l)+". "+ch[i]+"<br>");
                    l++;
                }
            }
            
            out.println("<br> Favorite Music Decade : "+decade);
            out.println("<br> prefer to listen to the radio on "+ day);
            out.println("<br> listen to WARNARadio "+ listen);
            out.println("<br> Prefer to Listen...<br> ");
            int k=1;
            for(int j=0; j<3; j++)
            {
                if(place[j]!=null)
                {
                    out.println((k)+". "+place[j]+"<br>");
                    k++;
                }
            }
            out.println("<br> Comment : <br> "+comment);
            out.println("</body>");
            out.println("</html>");
        }
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
