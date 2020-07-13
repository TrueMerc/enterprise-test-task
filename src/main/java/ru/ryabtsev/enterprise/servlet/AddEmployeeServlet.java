package ru.ryabtsev.enterprise.servlet;

import ru.ryabtsev.enterprise.entity.Address;
import ru.ryabtsev.enterprise.entity.Employee;
import ru.ryabtsev.enterprise.repository.AdministrativeUnitRepository;
import ru.ryabtsev.enterprise.repository.DistrictRepository;
import ru.ryabtsev.enterprise.repository.EmployeeRepository;
import ru.ryabtsev.enterprise.repository.WorkHoursRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addEmployee")
public class AddEmployeeServlet extends HttpServlet {

    @Inject
    private AdministrativeUnitRepository administrativeUnitRepository;

    @Inject
    private EmployeeRepository employeeRepository;

    @Inject
    private DistrictRepository districtRepository;

    @Inject
    private WorkHoursRepository workHoursRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee employee = new Employee();
        employee.setSecondName(req.getParameter("second_name"));
        employee.setFirstName(req.getParameter("first_name"));
        employee.setPatronymic(req.getParameter("patronymic"));
        employee.setAge(Short.valueOf(req.getParameter("age")));

        Address address = new Address();
        address.setName(req.getParameter("address"));
        address.setDistrict(districtRepository.get(Long.valueOf(req.getParameter("district"))));
        employee.setAddress(address);

        employee.setWorkHours(workHoursRepository.get(1L));

        employeeRepository.persist(employee);
        resp.sendRedirect("./employee?id=" +employee.getId());
    }
}
