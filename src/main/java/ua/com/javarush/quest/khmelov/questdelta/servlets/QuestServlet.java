package ua.com.javarush.quest.khmelov.questdelta.servlets;

import ua.com.javarush.quest.khmelov.questdelta.data.QuestLevels;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@WebServlet(name = "QuestServlet", value="/quest")
public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get current session
        HttpSession currentSession = request.getSession();

        int currentLevel = Integer.parseInt(currentSession.getAttribute("level").toString());

//
//        try(PrintWriter out = response.getWriter()){
//            out.println(QuestLevels.selectLevel(currentLevel));
//        }

        currentSession.setAttribute("level", currentLevel++);


        response.sendRedirect("/quest.jsp");
        //getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);
    }
}
