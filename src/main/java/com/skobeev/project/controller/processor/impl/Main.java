package com.skobeev.project.controller.processor.impl;

import com.skobeev.project.controller.processor.Processor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Main implements Processor {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/main.jsp").forward(req, res);
    }
}
