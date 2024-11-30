import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello") // Define a rota do endpoint
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Configura a resposta do servidor
        resp.setContentType("text/plain");
        resp.getWriter().write("Hello, Mari! Bem-vinda ao seu servlet!");
    }
}