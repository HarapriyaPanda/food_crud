package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import user.user;
import userDao.userdao;

@WebServlet("/viewServlet")
public class viewServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        userdao dao = new userdao();
        List<user> list = dao.viewDetails();
        response.setContentType("text/html");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Submitted Food Details</title>");

        out.print("<style>");
        out.print("table { width: 100%; border-collapse: collapse; margin: 20px 0; font-family: Arial, sans-serif; }");
        out.print("th, td { padding: 12px; text-align: left; border: 1px solid #ddd; }");
        out.print("th { background-color: #4CAF50; color: white; }");
        out.print("tr:nth-child(even) { background-color: #f2f2f2; }");
        out.print("tr:hover { background-color: #ddd; }");
        out.print("a { text-decoration: none; color: #4CAF50; }");
        out.print("a:hover { color: #45a049; }");
        out.print(".btn-back {");
        out.print("display: inline-block;");
        out.print("margin-top: 20px;");
        out.print("padding: 10px 15px;");
        out.print("background-color: #007bff;");
        out.print("color: white;");
        out.print("text-decoration: none;");
        out.print("border-radius: 5px;");
        out.print("text-align: center;");
        out.print("}");
        out.print(".btn-back:hover {");
        out.print("background-color: #0056b3;");
        out.print("}");
        out.print("</style>");

        out.print("</head>");
        out.print("<body>");

        out.print("<h2>Submitted Food Details</h2>");

        out.print("<table>");
        out.print("<tr>");
        out.print("<th>SL No</th>");
        out.print("<th>Candidate Name</th>");
        out.print("<th>Food Name</th>");
        out.print("<th>Price</th>");
        out.print("<th>Edit</th>");
        out.print("<th>Delete</th>");
        out.print("</tr>");

// Assuming 'list' is a list of food items
        for (user food : list) {
            out.print("<tr>");
            out.print("<td>" + food.getSlno() + "</td>");
            out.print("<td>" + food.getName() + "</td>");
            out.print("<td>" + food.getFoodname() + "</td>");
            out.print("<td>" + food.getPrice() + "</td>");
            out.print("<td><a href='usereditservlet?slno=" + food.getSlno() + "'>Edit</a></td>");
            out.print("<td><a href='deleteServlet?slno=" + food.getSlno() + "'>Delete</a></td>");
            out.print("</tr>");
        }

        out.print("</table>");

// Add a back button to navigate to the form page
        out.print("<a href='index.jsp' class='btn-back'>Back</a>");

        out.print("</body>");
        out.print("</html>");

    }

}
