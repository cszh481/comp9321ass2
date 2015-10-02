package controller;
import dto.User;
import exception.UserBannedException;
import exception.UserUnVerifiedException;
import service.UserService;

import java.io.IOException;
import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//Servlet implementation class ControlServlet
@WebServlet(urlPatterns="/control",displayName="ControlServlet")
public class controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public controller() {
        super();
        // TODO Auto-generated constructor stub
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doPost(request,response);
    }
    //    @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = new String("");
        if (request.getParameter("action") != null){
            action = request.getParameter("action");
        }
        String nextPage = "home.jsp";
        if (action.equals("registration")){
            UserService userService = new UserService();
            User user = userService.makeUserbyRequest(request);
            try {
                userService.register(user);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
        }
        else if(action.equals("login")){
            UserService userService = new UserService();
            User user = userService.makeUserbyRequest(request);
            try {
                if (userService.login(user.getUsername(),user.getPassword()) != null){
                    nextPage = "#";
                    request.setAttribute("login","true");
                }
            } catch (UserBannedException e) {
                e.printStackTrace();
            } catch (UserUnVerifiedException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher rd = request.getRequestDispatcher("/"+nextPage);
        rd.forward(request, response);
        //        try {
//            if (action.equals("search")) {
//                service.basic_search(request);
//                nextPage = "result.jsp";
//            } else if (action.equals("addtocart")) {
//                service.addShoppingCart(request);
//                nextPage = "shoppingcart.jsp";
//            } else if (action.equals("removeFromCart")) {
//                service.removeShoppingCart(request);
//                nextPage = "shoppingcart.jsp";
//            } else if (action.equals("advSearch")) {
//                service.advSearch(request);
//                nextPage = "result.jsp";
//            } else if (action.equals("changpage")) {
//                service.handlePageChange(request);
//                nextPage = "result.jsp";
//            } else  if(action.equals("showDetail")){
//                service.showDetail(request);
//                nextPage = "detail.jsp";
//            }
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        } catch (SAXException e) {
//            e.printStackTrace();
//        }
    }
}

