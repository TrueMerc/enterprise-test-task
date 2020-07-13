package ru.ryabtsev.enterprise.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.ryabtsev.enterprise.entity.Address;
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

@WebServlet(urlPatterns = {"/employeeList"})
public class EmployeeListServlet extends HttpServlet {

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
        final Collection<Employee> employees = employeeRepository.getAll();
        final JSONArray jsonArray = new JSONArray();

        for(Employee employee: employees) {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", employee.getId());
            jsonObject.put("name", employee.getFullName());
            final Address address = employee.getAddress();
            jsonObject.put("address", address.getName());
            jsonObject.put("district", address.getDistrict().getName());
            jsonObject.put("administrative_division", address.getDistrict().getAdministrativeDivision().getName());
            jsonObject.put("work_hours", employee.getWorkHours());
            jsonObject.put("age", employee.getAge());
            jsonArray.put(jsonObject);
        }

        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonArray.toString());
    }
}
