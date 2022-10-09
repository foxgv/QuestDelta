package ua.com.javarush.quest.mogutov.questdelta.servlets;

import ua.com.javarush.quest.mogutov.questdelta.data.Quest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@WebServlet(name = "QuestServlet", value="/quest")
public class QuestServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get current session
        HttpSession currentSession = request.getSession();

        // get quest object or not - create it
        Quest quest = extractCurrentQuest(currentSession, request);

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

        //send redirect & response
        getServletContext().getRequestDispatcher("/quest.jsp").forward(request, response);

    }

    private Quest extractCurrentQuest(HttpSession currentSession, HttpServletRequest request) throws UnknownHostException {
        Object questAttribute = currentSession.getAttribute("quest");
        if(questAttribute == null){
            // create new quest object. args: user name, user ip address;
            questAttribute = new Quest(request.getParameter("userName"), InetAddress.getLocalHost());
        }
        if (Quest.class != questAttribute.getClass()) {
            currentSession.invalidate();
            throw new RuntimeException("Session is broken, try one more time");
        }
        return (Quest) questAttribute;
    }

}
