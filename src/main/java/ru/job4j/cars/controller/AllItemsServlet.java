package ru.job4j.cars.controller;

import ru.job4j.cars.repository.Hbm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AllItemsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("photo_name", "nullPhoto.jpg");
        req.setCharacterEncoding("UTF-8");
        req.setAttribute("items", Hbm.instOf().allItem());
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
