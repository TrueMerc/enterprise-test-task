package ru.ryabtsev.enterprise.servlet;

import org.json.JSONArray;
import org.json.JSONObject;
import ru.ryabtsev.enterprise.entity.AdministrativeUnit;
import ru.ryabtsev.enterprise.entity.District;
import ru.ryabtsev.enterprise.repository.AdministrativeUnitRepository;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@WebServlet(urlPatterns = "/administrativeUnitList")
public class AdministrativeUnitServlet extends HttpServlet {
    @Inject
    private AdministrativeUnitRepository administrativeUnitRepository;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Collection<AdministrativeUnit> administrativeUnits = administrativeUnitRepository.getAll();
        final JSONArray jsonArray = new JSONArray();

        for(AdministrativeUnit unit: administrativeUnits) {
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", unit.getId());
            jsonObject.put("name", unit.getName());
            jsonArray.put(jsonObject);
        }

        resp.setContentType("application/json;charset=UTF-8");
        resp.getWriter().write(jsonArray.toString());
    }
}
