package ru.job4j.cars.controller;

import ru.job4j.cars.model.Item;
import ru.job4j.cars.model.Mark;
import ru.job4j.cars.repository.Hbm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class MarksFilterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String filter = req.getParameter("mark");
        Mark mark = Mark.of(filter);
        List<Item> rsl = (List<Item>) Hbm.instOf().mark(mark);
        req.setAttribute("items", rsl);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
