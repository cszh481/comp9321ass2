package controller;
import dto.Item;
import dto.User;
import exception.UserBannedException;
import exception.UserUnVerifiedException;
import service.CartService;
import service.ItemService;
import service.UserService;

import java.io.IOException;
import java.text.ParseException;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
                if ((user = userService.login(user.getUsername(),user.getPassword())) != null){
                    HttpSession session = request.getSession();
                    session.setAttribute("login","true");
                    session.setMaxInactiveInterval(60*60);
                    session.setAttribute("user", user);
                }
            } catch (UserBannedException e) {
                e.printStackTrace();
            } catch (UserUnVerifiedException e) {
                e.printStackTrace();
            }
        }
        else if(action.equals("logout")){
            HttpSession session = request.getSession();
            session.invalidate();
        }
        else if(action.equals("pauseItem")){
            ItemService itemService = new ItemService();
            itemService.pauseItem(request.getParameter("id"));
            nextPage = "store.jsp";
        }
        else if(action.equals("unPauseItem")){
            ItemService itemService = new ItemService();
            itemService.unPauseItem(request.getParameter("id"));
            nextPage = "store.jsp";
        }
        else if(action.equals("verify")){
            UserService userService = new UserService();
            userService.verifyUserEmail(request.getParameter("uuid"));
            nextPage = "emailConfirm.jsp";
        }
        else if(action.equals("addItem")){
            ItemService itemService = new ItemService();
            try {
                Item item = itemService.makeItemByRequest(request);
                itemService.saveOrUpdate(item);
                nextPage = "store.jsp";
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        else if(action.equals("editprofile")){
            UserService userService = new UserService();
            User user = userService.makeUserbyRequest(request);
            try {
                userService.editProfile(user);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            nextPage = "profile.jsp";
        }
        else if(action.equals("showDetail")){
            ItemService itemService = new ItemService();
            Item item = itemService.getItemById(request.getParameter("id"));
            request.setAttribute("detail", item);
            nextPage = "detail.jsp";
        }
        else if(action.equals("addtocart")){
            CartService cartService = new CartService();
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            int userId = user.getId();
            int itemId = Integer.parseInt(request.getParameter("itemId"));
            cartService.addToCart(userId,itemId);
            nextPage = "shoppingcart.jsp";
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

