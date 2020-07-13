package ru.ryabtsev.enterprise.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.ryabtsev.enterprise.entity.Address;
import ru.ryabtsev.enterprise.entity.District;
import ru.ryabtsev.enterprise.entity.Employee;
import ru.ryabtsev.enterprise.repository.DistrictRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/districtList")
public class DistrictServlet extends HttpServlet {

    @Inject
    private DistrictRepository districtRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        final Collection<District> districts = districtRepository.getAll();
        final JSONArray jsonArray = new JSONArray();

        for(District district: districts) {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", district.getId());
            jsonObject.put("name", district.getName());
            jsonArray.put(jsonObject);
        }

        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonArray.toString());
    }
}
