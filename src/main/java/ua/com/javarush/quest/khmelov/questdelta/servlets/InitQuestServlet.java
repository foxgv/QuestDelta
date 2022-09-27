package ua.com.javarush.quest.khmelov.questdelta.servlets;

import org.jetbrains.annotations.NotNull;
import ua.com.javarush.quest.khmelov.questdelta.data.QuestLevels;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "QuestServlet", value = "/start")
public class InitQuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // create new session
        HttpSession currentSession = req.getSession();
        currentSession.setAttribute("level", QuestLevels.LEVEL);

        try(PrintWriter out = resp.getWriter()){
            out.println(QuestLevels.selectLevel());
        }


        // redirect to INDEX.JSP
        getServletContext().getRequestDispatcher("/quest.jsp").forward(req, resp);
    }

//    private int getLevelSession(HttpSession session){
//        try{
//            return Integer.parseInt(session.getAttribute("level").toString());
//        }catch (Exception e){
//            return 0;
//        }
//    }
}
