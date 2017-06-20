/**
 * 
 */
package cn.com.brilliance.risk.ext.controller;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import cn.com.brilliance.risk.ext.interfaces.DataManageController;

/**
 * @author pony
 * 
 */
public class DataManageControllerImpl extends JdbcDaoSupport implements
		DataManageController {

	private static final Logger logger = Logger
			.getLogger(DataManageControllerImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.brilliance.ums.ext.interfaces.DataManageController#delete(java.lang.String)
	 */
	public void delete(String sql) {
		// TODO Auto-generated method stub
		JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
		jdbcTemplate.execute(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.brilliance.ums.ext.interfaces.DataManageController#queryForList(java.lang.String)
	 */
	public List queryForList(String sql) {
		try {
			// TODO Auto-generated method stub
			JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
			return jdbcTemplate.queryForList(sql);
		} catch (EmptyResultDataAccessException eda) {
			eda.printStackTrace();
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.brilliance.ums.ext.interfaces.DataManageController#queryForMap(java.lang.String)
	 */
	public Map queryForMap(String sql) {
		try {
			JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
			return jdbcTemplate.queryForMap(sql);
		} catch (EmptyResultDataAccessException eda) {
			eda.printStackTrace();
			return null;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.com.brilliance.ums.ext.interfaces.DataManageController#update(java.lang.String)
	 */
	public int update(String sql) {
		JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
		return jdbcTemplate.update(sql);
	}
	
	public void execute(String sql) {
		JdbcTemplate jdbcTemplate = this.getJdbcTemplate();
		jdbcTemplate.execute(sql);
	}

}
