package com.aghagor.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.aghagor.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Employee p) {
        String sql = "insert into Emp99(name,salary,destination) values('" + p.getName()
                + "'," + p.getSalary() + ",'" + p.getDestination() + "')";
//    String sql="insert into Emp99(name,salary,destination) values('Gor',100000,'Vanadzor')";
        return template.update(sql);
    }

    public int update(Employee p) {
        String sql = "update Emp99 set name='" + p.getName() + "', salary='" + p.getSalary()
                + "',destination='" + p.getDestination() + "' where id=" + p.getId() + "";
        return template.update(sql);
    }

    public int delete(int id) {
        String sql = "delete from Emp99 where id=" + id + "";
        return template.update(sql);
    }

    public Employee getEmpById(int id) {
        String sql = "select * from Emp99 where id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<Employee>(Employee.class));
    }

    public List<Employee> getEmployees() {
        return template.query("select * from Emp99", new RowMapper<Employee>() {
            public Employee mapRow(ResultSet rs, int row) throws SQLException {
                Employee e = new Employee();
                e.setId(rs.getInt(1));
                e.setName(rs.getString(2));
                e.setSalary(rs.getFloat(3));
                e.setDestination(rs.getString(4));
                return e;
            }
        });
    }
}  