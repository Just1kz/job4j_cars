package ru.job4j.cars.controller;

import ru.job4j.cars.model.Item;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.Hbm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SoldItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id_to_sold");
        User user = (User) req.getSession().getAttribute("user");
        Item item = Hbm.instOf().findByIdItem(Integer.parseInt(id));
        if (item.getUser().equals(user)) {
            Hbm.instOf().soldItem(Integer.parseInt(id));
            resp.sendRedirect(req.getContextPath() + "/allItem");
        } else {
            req.setAttribute("error", "Вы пытаетесь обратится не к своему объявлению, повторите попытку");
            req.setAttribute("filter", "my");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
