package com.phonesbook.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.phonesbook.jdbc.ConnectionFactory;
import com.phonesbook.model.Contacts;

public class ContactsDAO {
	private static ConnectionFactory CONNECTION;
		
	public ContactsDAO() {
		this.CONNECTION = new ConnectionFactory();
	}
	
	public List<Contacts> listAll() {
		try {
			List<Contacts> contacts = new ArrayList<>();
			Connection connection = CONNECTION.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from contacts;");
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Contacts contact = new Contacts();
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail_address(rs.getString("email_address"));
				contact.setPhone_number(rs.getString("phone_number"));
				contact.setMobile_number(rs.getString("mobile_number"));
				contact.setIs_favorite(rs.getBoolean("is_favorite"));				
				contacts.add(contact);
			}
			
			CONNECTION.closeConnection();
			return contacts;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Contacts getContactById(Integer id) {
		try {
			Contacts contact = new Contacts();
			Connection connection = CONNECTION.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from contacts where id = ?;");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				contact.setId(rs.getInt("id"));
				contact.setName(rs.getString("name"));
				contact.setEmail_address(rs.getString("email_address"));
				contact.setPhone_number(rs.getString("phone_number"));
				contact.setMobile_number(rs.getString("mobile_number"));
				contact.setIs_favorite(rs.getBoolean("is_favorite"));
			}
			
			return contact;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean addContact(Contacts contact) {	
		try {
			Connection connection = CONNECTION.getConnection();
			String sql = "insert into `contacts` (`name`, `phone_number`, `mobile_number`, `email_address`) "
					+ "values (?, ?, ?, ?);";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getPhone_number());
			ps.setString(3, contact.getMobile_number());
			ps.setString(4, contact.getEmail_address());
			ps.execute();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	public Boolean editContact(Contacts contact) {
		
		try {
			Connection connection = CONNECTION.getConnection();
			String sql = "update `contacts` set name = ?, phone_number = ?, mobile_number = ?, "
					+ "email_address = ? where id = ? ;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getPhone_number());
			ps.setString(3, contact.getMobile_number());
			ps.setString(4, contact.getEmail_address());
			ps.setInt(5, contact.getId());
			ps.executeUpdate();
			CONNECTION.closeConnection();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public Boolean delContact(Contacts contact) {
		try {
			Connection connection = CONNECTION.getConnection();
			String sql = "delete from `contacts` where id = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, contact.getId());
			ps.execute();
			CONNECTION.closeConnection();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Boolean changeFavorite(Contacts contact) {
		try {
			Connection connection = CONNECTION.getConnection();
			String sql = "update `contacts` set is_favorite = ? where id = ?;";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setBoolean(1, contact.getIs_favorite());
			ps.setInt(2, contact.getId());
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
