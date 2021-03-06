package default_package;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public SearchServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String search = request.getParameter("search");
        Bean bean = (Bean) request.getSession().getAttribute("bean");
        if (bean == null) {
            bean = new Bean();
        }

        long startTime = System.currentTimeMillis();
        MinerSearch miner = new MinerSearch();
        ArrayList<String> results = null;
        try {
            results = miner.getOutputFromKeywords(search);
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (bean != null) {
            //set input to null if you don't want to see alphabetized output in top text area
            bean.setInput(null);
            bean.setResults(results);
        }

        long endTime = System.currentTimeMillis();
        System.out.println("\ntime to run prog: " + (endTime - startTime) + " milliseconds");

        //update beans and refresh page
        if (bean != null) {
            request.getSession().setAttribute("bean", bean);
        }
        request.setAttribute("output", results);
        request.setAttribute("search", search);
        request.getRequestDispatcher("SearchPage.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
