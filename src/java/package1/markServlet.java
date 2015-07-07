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
@WebServlet(name = "markServlet", urlPatterns = {"/markServlet"})
public class markServlet extends HttpServlet {

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
            String m = request.getParameter("txtMark");
            String grade = request.getParameter("gradeCheckBox");
            String point = request.getParameter("pointCheckBox");
            String ggrade;
            double pnt;
            double mark = Double.parseDouble(m);
            
            if(mark<60)
            {
                ggrade="F";
                pnt=0;
            }
            else if(mark<70)
            {
                ggrade="D";
                pnt=1;
            }
            else if( mark<80)
            {
                ggrade="C";
                pnt=2;
            }
            else if( mark<90)
            {
                ggrade="B"; 
                pnt=3;
            }
            else
            {
                ggrade="A"; 
                pnt=4;
            }
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet markServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet markServlet at " + request.getContextPath() + "</h1>");
            if(mark<0||mark>100)
            {
                out.println("invalid input! mark is between 0 to 100 only!");
            }
            else
            {
                out.println("Your Grade is ");
                if(grade==null&&point==null)
                {
                    out.println("please select atleast one!");
                }

                else if(grade!=null&&point==null)
                {
                    out.println("Grade : "+ggrade);
                }

                else if(grade==null && point!=null)
                {
                    out.println("Point : "+pnt);
                }
                else if( grade!=null&& point!=null)
                {
                    out.println("Grade : "+ggrade);
                    out.println("Point :"+pnt);
                }
            }
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
