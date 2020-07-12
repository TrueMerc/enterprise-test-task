package ru.ryabtsev.enterprise.servlet;

import ru.ryabtsev.enterprise.entity.Employee;
import ru.ryabtsev.enterprise.repository.EmployeeRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;


@WebServlet(urlPatterns = {"/message"})
public class MainPageServlet extends HttpServlet {

    @Inject
    private EmployeeRepository employeeRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html;charset=UTF-8");
        Collection<Employee> employees = employeeRepository.getAll();
        if(employees.isEmpty()) {
            resp.getWriter().write("No data to show");
        }
        else {
            resp.getWriter().write( employees.size() + " employee entries found.");
        }
    }
}
