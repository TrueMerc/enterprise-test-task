package ru.ryabtsev.enterprise.servlet;

import org.json.JSONObject;
import ru.ryabtsev.enterprise.entity.Address;
import ru.ryabtsev.enterprise.entity.Employee;
import ru.ryabtsev.enterprise.repository.EmployeeRepository;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/employeeInfo")
public class EmployeeServlet extends HttpServlet {
    @Inject
    EmployeeRepository employeeRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        final Long id = Long.valueOf(req.getParameter("id"));
        final Employee employee = employeeRepository.get(id);

        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", employee.getId());
        jsonObject.put("name", employee.getFullName());
        final Address address = employee.getAddress();
        jsonObject.put("address", address.getName());
        jsonObject.put("district", address.getDistrict().getName());
        jsonObject.put("administrative_division", address.getDistrict().getAdministrativeUnit().getName());
        jsonObject.put("work_hours", employee.getWorkHours());
        jsonObject.put("age", employee.getAge());

        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonObject.toString());
    }
}
