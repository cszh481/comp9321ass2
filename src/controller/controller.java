package controller;
import dto.*;
import exception.UserBannedException;
import exception.UserUnVerifiedException;
import service.*;

import java.awt.event.AdjustmentEvent;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
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
            nextPage = "registerDone.jsp";
        }
        else if(action.equals("login")){
            UserService userService = new UserService();
            User user = userService.makeUserbyRequest(request);
            if (userService.getUserByUsername(user.getUsername()) == null){
                nextPage = "noThisUser.jsp";
            }
            try {
                if ((user = userService.login(user.getUsername(),user.getPassword())) != null){
                    HttpSession session = request.getSession();
                    session.setAttribute("login","true");
                    session.setMaxInactiveInterval(60*60);
                    session.setAttribute("user", user);
                }
                else{
                    nextPage = "wrongpassword.jsp";
                }
            } catch (UserBannedException e) {
                nextPage = "userIsBanned.jsp";
            } catch (UserUnVerifiedException e) {
                nextPage = "notActivated.jsp";
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
            HttpSession session = request.getSession();
            User user = (User) session.getAttribute("user");
            user = userService.makeUserbyRequest(request ,user);
            try {
                userService.editProfile(user);
            } catch (MessagingException e) {
                e.printStackTrace();
            }
            user = userService.getUserById(user.getId());
            session.setAttribute("user", user);
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
        else if(action.equals("basicsearch")){
            ItemService itemService = new ItemService();
            List<Item> elements = itemService.basicSearch(request.getParameter("keyword"));
            request.setAttribute("elements", elements);
            nextPage = "result.jsp";
        }
        else if(action.equals("advsearch")){
            ItemService itemService = new ItemService();
            List<Item> elements = null;
            try {
                elements = itemService.advSearch(request);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            request.setAttribute("elements", elements);
            nextPage = "result.jsp";
        }
        else if(action.equals("rmshoppingcart")){
            CartService cartService = new CartService();
            String[] id_list = request.getParameterValues("pick");
            if (id_list !=null) {
                for (String temp_int : id_list) {
                    int id = Integer.parseInt(temp_int);
                    cartService.removeCart(id);
                }
            }
            nextPage = "shoppingcart.jsp";
        }
        else if(action.equals("makeorder")){
            CartService cartService = new CartService();
            OrderService orderService = new OrderService();
            String[] id_list = request.getParameterValues("pick");
            if (id_list != null) {
                List<Cart> cartList = new ArrayList<>();
                boolean outOrder = false;
                for (String temp_int : id_list) {
                    int id = Integer.parseInt(temp_int);
                    Cart cart = cartService.getCartById(id);
                    cartList.add(cart);
                    if (cart.getCount() > cart.getItem().getQuantity()) {
                        outOrder = true;
                    }
                }
                if (!outOrder || cartList.size() == 0) {
                    try {
                        orderService.createOrder(cartList);
                        nextPage = "shoppingcart.jsp";
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }
                } else {
                    nextPage = "outofOrder.jsp";
                }
            }
            nextPage = "shoppingcart.jsp";
        }
        else if(action.equals("adminlogin")){
            AdminService adminService = new AdminService();
            UserService userService = new UserService();
            User user = userService.makeUserbyRequest(request);
            Admin admin = adminService.login(user.getUsername(),user.getPassword());
            if (admin != null){
                HttpSession session = request.getSession();
                session.setAttribute("adminlogin","true");
                session.setMaxInactiveInterval(60*60);
                nextPage = "adminmain.jsp";
            }
            else {
                nextPage = "wrongpassword.jsp";
            }
        }
        else if(action.equals("checkbought")){
            int userId = Integer.parseInt(request.getParameter("id"));
            OrderService orderService = new OrderService();
            UserService userService = new UserService();
            String username = userService.getUserById(request.getParameter("id")).getUsername();
            request.setAttribute("username", username);
            List<Order> orders = orderService.getAllOrderByUserId(userId);
            List<OrderItem> result = new ArrayList<>();
            for (Order order : orders){
                List<OrderItem> temp = orderService.getAllOrderItemByOrderId(order.getId());
                result.addAll(temp);
            }
            request.setAttribute("elements", result);
            nextPage = "adminBought.jsp";
        }
        else if(action.equals("checkremoved")){
            CartService cartService = new CartService();
            UserService userService = new UserService();
            List<Cart> elements = cartService.getRemovedCart(Integer.parseInt(request.getParameter("id")));
            User userRmoved = userService.getUserById(request.getParameter("id"));
            request.setAttribute("username", userRmoved.getUsername());
            request.setAttribute("elements", elements);
            nextPage = "adminRemoved.jsp";
        }
        else if(action.equals("banuser")){
            UserService userService = new UserService();
            userService.banUser(request.getParameter("id"));
            nextPage = "adminUsers.jsp";
        }
        else if(action.equals("unbanuser")){
            UserService userService = new UserService();
            userService.unBanUser(request.getParameter("id"));
            nextPage = "adminUsers.jsp";
        }
        else if(action.equals("adminsearch")){
            ItemService itemService = new ItemService();
            List<Item> elements = null;
            try {
                elements = itemService.adminAdvSearch(request);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            request.setAttribute("elements", elements);
            nextPage = "adminItemSearchResult.jsp";
        }
        else if(action.equals("adminShowDetail")){
            ItemService itemService = new ItemService();
            Item item = itemService.getItemById(request.getParameter("id"));
            request.setAttribute("detail", item);
            nextPage = "adminDetail.jsp";
        }
        else if(action.equals("unbanitem")){
            ItemService itemService = new ItemService();
            itemService.unBanItem(request.getParameter("id"));
            nextPage = "adminmain.jsp";
        }
        else if(action.equals("banitem")){
            ItemService itemService = new ItemService();
            itemService.banItem(request.getParameter("id"));
            nextPage = "adminmain.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher("/"+nextPage);
        rd.forward(request, response);

    }
}

