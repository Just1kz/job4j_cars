package ru.job4j.cars.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.job4j.cars.model.Model;
import ru.job4j.cars.service.Hbm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ModelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Model> list = (List<Model>) Hbm.instOf().allModel();
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(list);
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("json");
        resp.getWriter().write(string);
    }
}
