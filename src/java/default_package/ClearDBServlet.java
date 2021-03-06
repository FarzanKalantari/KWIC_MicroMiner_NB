package default_package;

import com.sql.db.SQLCreate;
import java.io.IOException;
import javax.servlet.RequestDispatcher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ClearDBServlet")
public class ClearDBServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public ClearDBServlet() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        Bean bean = (Bean) request.getSession().getAttribute("bean");
        if (bean != null) {
            bean.setInput(null);
            bean.setResults(null);
        }
        SQLCreate sqlCreate = SQLCreate.instance();

        sqlCreate.connect();
        sqlCreate.removeAllRecords();

        if (bean != null) {
            request.getSession().setAttribute("bean", bean);
        }
        request.getRequestDispatcher("SearchPage.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
