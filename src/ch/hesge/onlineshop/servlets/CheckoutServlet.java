package ch.hesge.onlineshop.servlets;

import ch.hesge.onlineshop.models.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<Product, Integer> productsCaddy = (Map<Product, Integer>) req.getSession().getAttribute("caddy");
        req.setAttribute("productsCaddy", productsCaddy);
        resp.setContentType("text/html");
        req.getRequestDispatcher("/WEB-INF/checkout.jsp").forward(req, resp);
    }
}