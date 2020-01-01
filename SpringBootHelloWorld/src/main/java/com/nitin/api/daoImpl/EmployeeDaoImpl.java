/**
 * 
 */
package com.nitin.api.daoImpl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.nitin.api.dao.EmployeeDao;
import com.nitin.api.dto.EmployeeDTO;

@Repository
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public void insertEmployee(EmployeeDTO emp) {
		String sql = "INSERT INTO employee " + "( empName, date_of_birth) VALUES ( ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { emp.getEmpName(), emp.getDateOfBirth() });
	}

	@Override
	public void insertUpdateEmployee(EmployeeDTO emp) {
		String sql = "INSERT INTO employee "
				+ "( empName, date_of_birth) VALUES ( ?, ?)  ON DUPLICATE KEY UPDATE    " + " date_of_birth= ?";
		getJdbcTemplate().update(sql,
				new Object[] { emp.getEmpName(), emp.getDateOfBirth(), emp.getDateOfBirth() });
	}

	@Override
	public void insertEmployees(List<EmployeeDTO> employees) {
		String sql = "INSERT INTO employee " + "( empName, date_of_birth) VALUES ( ?, ?)";
		getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter() {
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				EmployeeDTO employee = employees.get(i);
				ps.setString(1, employee.getEmpName());
				ps.setDate(2, employee.getDateOfBirth());
			}

			public int getBatchSize() {
				return employees.size();
			}
		});

	}

	@Override
	public List<EmployeeDTO> getAllEmployees() {
		String sql = "SELECT * FROM employee";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<EmployeeDTO> result = new ArrayList<EmployeeDTO>();
		for (Map<String, Object> row : rows) {
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmpName((String) row.get("empName"));
			emp.setDateOfBirth((Date) row.get("date_of_birth"));
			result.add(emp);
		}

		return result;
	}


	@Override
	public EmployeeDTO getEmployeeByName(String empName) {
		String sql = "SELECT * FROM employee WHERE empName = ?";
		return (EmployeeDTO) getJdbcTemplate().queryForObject(sql, new Object[] { empName },
				new RowMapper<EmployeeDTO>() {
					@Override
					public EmployeeDTO mapRow(ResultSet rs, int rwNumber) throws SQLException {
						EmployeeDTO emp = new EmployeeDTO();
						emp.setEmpName(rs.getString("empName"));
						emp.setDateOfBirth(rs.getDate("date_of_birth"));
						return emp;
					}
				});
	}
}
