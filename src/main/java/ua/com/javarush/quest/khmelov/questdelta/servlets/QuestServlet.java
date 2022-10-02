package ua.com.javarush.quest.khmelov.questdelta.servlets;

import ua.com.javarush.quest.khmelov.questdelta.data.Quest;
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
import java.util.Objects;


@WebServlet(name = "QuestServlet", value="/quest")
//@WebServlet("QuestServlet")
public class QuestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get current session
        HttpSession currentSession = request.getSession();

        // get quest object or not - create it
        Quest quest = extractCurrentQuest(currentSession);

        // select userName
        String userName = request.getParameter("userName");

        // get current quest level
        int level = quest.getLEVEL();

        //check what user is select
        if(request.getParameter("answer") != null) {
            // select user choice
            Integer selectNumber = Integer.parseInt(request.getParameter("answer"));
            if (quest.checkLose(selectNumber)){
                //send redirect to LOSE PAGE
                getServletContext().getRequestDispatcher("/losePage.jsp").forward(request, response);
            } else if(quest.checkWin(level)){
                //send redirect to Winner page
                getServletContext().getRequestDispatcher("/winner.jsp").forward(request, response);
            } else{
                // level up
                quest.setLEVEL(++level);
            }
        }

        // update session
        currentSession.setAttribute("quest", quest);
        currentSession.setAttribute("userName", userName);

        //send redirect & response
        getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private Quest extractCurrentQuest(HttpSession currentSession) {
        Object questAttribute = currentSession.getAttribute("quest");
        if(questAttribute == null){
            questAttribute = new Quest();
        }
        if (Quest.class != questAttribute.getClass()) {
            currentSession.invalidate();
            throw new RuntimeException("Session is broken, try one more time");
        }
        return (Quest) questAttribute;
    }

}
