package com.aghagor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.aghagor.ConnectionFactory;
import com.aghagor.model.Employee;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public void save(Employee p) throws SQLException {
        String sql = "insert into Emp99(name,salary,destination) values(?,?,?);";
        try (Connection connection = ConnectionFactory.getInstance().openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, p.getName());
            preparedStatement.setFloat(2, p.getSalary());
            preparedStatement.setString(3, p.getDestination());
            preparedStatement.execute();
        }
    }

    public boolean update(Employee p) throws SQLException {
        String sql = "update Emp99 set name=?, salary=?,destination=? where id=?;";
        try (Connection connection = ConnectionFactory.getInstance().openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, p.getName());
            preparedStatement.setFloat(2, p.getSalary());
            preparedStatement.setString(3, p.getDestination());
            preparedStatement.setInt(4, p.getId());
            return preparedStatement.executeUpdate() > 0;
        }
    }

    public boolean delete(int id) throws SQLException {
        String sql = "delete from Emp99 where id=?";
        try (Connection connection = ConnectionFactory.getInstance().openConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate() > 0;
        }
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