package ru.job4j.cars.controller;

import ru.job4j.cars.model.User;
import ru.job4j.cars.service.Hbm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
//        User user = new User(name, email, password);
//        if (Hbm.instOf().findByEmailAndPasswordUser(user) != null) {
//            req.setAttribute("error", "Пользователь с указанным email уже зарегистрирован");
//            req.getRequestDispatcher("/reg.jsp").forward(req, resp);
//        } else {
//            Hbm.instOf().createUser(user);
//            resp.sendRedirect(req.getContextPath() + "/login.jsp");
//        }
    }
}
