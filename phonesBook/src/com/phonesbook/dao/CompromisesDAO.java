package com.phonesbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.phonesbook.jdbc.ConnectionFactory;
import com.phonesbook.model.Compromise;
import com.phonesbook.util.DateConverter;

public class CompromisesDAO {
	private static ConnectionFactory CONNECTION;
	
	public CompromisesDAO() {
		this.CONNECTION = new ConnectionFactory();
	}
	
	public List<Compromise> listAll() {
		try {
			List<Compromise> compromises = new ArrayList<>();
			Connection connection = CONNECTION.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from compromises;");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Compromise compromise = new Compromise();
				compromise.setId(rs.getInt("id"));
				compromise.setTitle(rs.getString("title"));
				compromise.setType(rs.getString("type"));
				compromise.setDesc(rs.getString("desc"));
				compromise.setDate(DateConverter.stringTypeToDate(rs.getString("date")));
				compromise.setTime(DateConverter.stringTypeToTime(rs.getString("time")));
				compromises.add(compromise);
			}
			
			CONNECTION.closeConnection();
			return compromises;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Compromise getContactById(Integer id) {
		try {
			Compromise compromise = new Compromise();
			Connection connection = CONNECTION.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from compromises where id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				compromise.setId(rs.getInt("id"));
				compromise.setTitle(rs.getString("title"));
				compromise.setDesc(rs.getString("desc"));
				compromise.setType(rs.getString("type"));
				compromise.setDate(DateConverter.stringTypeToDate(rs.getString("date")));
				compromise.setTime(DateConverter.stringTypeToTime(rs.getString("time")));
			}
			
			return compromise;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Boolean addCompromise(Compromise compromise) {	
		try {
			Connection connection = CONNECTION.getConnection();
			String sql = "insert into `compromises` (`title`, `desc`, `type`, `date`, `time`) "
					+ "values (?, ?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, compromise.getTitle());
			ps.setString(2, compromise.getDesc());
			ps.setString(3, compromise.getType());
			ps.setString(4, DateConverter.dateTypeToString(compromise.getDate()));
			ps.setString(5, DateConverter.timeTypeToString(compromise.getTime()));
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Boolean editCompromise(Compromise compromise) {
		
		try {
			Connection connection = CONNECTION.getConnection();
			String sql = "update `compromises` set title = ?, desc = ?, type = ?, date = ?, "
					+ "time = ? where id = ? ;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, compromise.getTitle());
			ps.setString(2, compromise.getDesc());
			ps.setString(3, compromise.getType());
			ps.setString(4, DateConverter.dateTypeToString(compromise.getDate()));
			ps.setString(5,  DateConverter.timeTypeToString(compromise.getTime()));
			ps.setInt(6, compromise.getId());
			ps.executeUpdate();
			CONNECTION.closeConnection();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean delCompromise(Compromise compromise) {
		try {
			Connection connection = CONNECTION.getConnection();
			String sql = "delete from `compromises` where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, compromise.getId());
			ps.execute();
			CONNECTION.closeConnection();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
}
