package web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import user.user;
import userDao.userdao;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/submitservlet")
public class submitservlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    super.doPost(request, response);
    }
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    String candidatename = request.getParameter("candidatename");
    String foodname = request.getParameter("foodname");
    int price = Integer.parseInt(request.getParameter("price"));

    user u=new user();
    u.setName(candidatename);
    u.setFoodname(foodname);
    u.setPrice(price);
    int result=userdao.saveDetails(u);
    if (result>0){
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        out.print("<!DOCTYPE html>");
        out.print("<html>");
        out.print("<head>");
        out.print("<title>Add Status</title>");

        out.print("<style>");
        out.print("body { font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 0; }");
        out.print(".container { width: 50%; margin: auto; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); text-align: center; }");
        out.print("h2 { color: #4CAF50; }");  // Green color for success
        out.print(".btn-back { margin-top: 20px; background-color: #007bff; color: white; padding: 10px 15px; border: none; border-radius: 4px; cursor: pointer; text-decoration: none; display: inline-block; }");
        out.print(".btn-back:hover { background-color: #0056b3; }");
        out.print("</style>");

        out.print("</head>");
        out.print("<body>");

        out.print("<div class='container'>");
        out.print("<h2>Successfully Added!</h2>");
        out.print("<a href='viewServlet' class='btn-View'>Back</a>");
        out.print("</div>");

        out.print("</body>");
        out.print("</html>");
    }
    }
}
