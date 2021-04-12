package ru.job4j.cars.controller;

import ru.job4j.cars.model.Item;
import ru.job4j.cars.model.User;
import ru.job4j.cars.repository.Hbm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BaseFiltersServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String filter = req.getParameter("filter");
        User user = (User) req.getSession().getAttribute("user");
        List<Item> rsl = new ArrayList<>();
        switch (filter) {
            case ("all"):
                rsl = (List<Item>) Hbm.instOf().allItem();
                break;
            case ("my"):
                rsl = (List<Item>) Hbm.instOf().myItem(user);
                break;
            case("noSold"):
                rsl = (List<Item>) Hbm.instOf().noSoldItem();
                break;
            case ("lastDay"):
                rsl = (List<Item>) Hbm.instOf().lastDay();
                break;
            case("withPhoto"):
                rsl = (List<Item>) Hbm.instOf().withPhoto();
            default:
        }
        req.setAttribute("items", rsl);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
