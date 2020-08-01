package com.aghagor.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.aghagor.model.Employee;
import com.aghagor.dao.EmployeeDao;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao dao;


    @RequestMapping("/empform")
    public String showform(Model m) {
        m.addAttribute("command", new Employee());
        return "empform";
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("emp") Employee employee) {
        try {
            dao.save(employee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "redirect:/viewemp";
    }

    @RequestMapping("/viewemp")
    public String viewemp(Model m) {
        List<Employee> list = dao.getEmployees();
        m.addAttribute("list", list);
        return "viewemp";
    }

    @RequestMapping(value = "/editemp/{id}")
    public String edit(@PathVariable int id, Model m) {
        Employee employee = dao.getEmpById(id);
        m.addAttribute("command", employee);
        return "empeditform";
    }

    @RequestMapping(value = "{id}/editsave", method = RequestMethod.POST)
    public String editsave(@ModelAttribute("emp") Employee employee) {
        try {
            dao.update(employee);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "redirect:/viewemp";
    }


    @RequestMapping(value = "/deleteemp/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable int id) {
        try {
            dao.delete(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "redirect:/viewemp";
    }
}  