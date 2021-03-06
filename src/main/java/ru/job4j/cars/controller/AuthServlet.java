package ru.job4j.cars.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.Hbm;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    private final Logger logger = LoggerFactory.getLogger(Hbm.class.getName());

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        User user = User.of(email, password);
        User user2 = Hbm.instOf().findByEmailAndPasswordUser(user.getEmail(), user.getPassword());
        if (user2 != null && user2.getPassword().equals(password)) {
            HttpSession sc = req.getSession();
            sc.setAttribute("user", user2);
            resp.sendRedirect(req.getContextPath() + "/allItem");
        } else {
            req.setAttribute("error", "Не верный email или password");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }
}
