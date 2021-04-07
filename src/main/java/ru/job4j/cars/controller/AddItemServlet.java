package ru.job4j.cars.controller;

import ru.job4j.cars.model.*;
import ru.job4j.cars.service.Hbm;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String markReq = req.getParameter("mark");
        String modelReq = req.getParameter("model");
        String transmissionReq = req.getParameter("transmission");
        String driveReq = req.getParameter("drive");
        String typeBodyReq = req.getParameter("typeBody");
        String descriptionReq = req.getParameter("description");
        String photoNameReq = (String) req.getSession().getAttribute("photo_name");

        if (photoNameReq.equals("")) {
            photoNameReq = "nullPhoto.jpg";
        }

        Mark mark = Hbm.instOf().findByNameMark(markReq);
        Model model = Hbm.instOf().findByNameModel(modelReq);
        TypeBody typeBody = Hbm.instOf().findByNameTypeBody(typeBodyReq);
        Photo photo = Hbm.instOf().findByNamePhoto(photoNameReq);
        User user = (User) req.getSession().getAttribute("user");

        Item item = Item.of(mark, model, transmissionReq, driveReq, typeBody, photo, descriptionReq, user);
        Hbm.instOf().addItem(item);
        resp.sendRedirect(req.getContextPath() + "/allItem");
    }
}
