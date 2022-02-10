package com.revature.bank_app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.revature.bank_app.models.User;
import com.revature.bank_app.util.collections.LinkedList;
import com.revature.bank_app.util.collections.List;
import com.revature.bank_app.util.datasource.ConnectionFactory;



public class UserDAO implements CrudDAO<User> {
	
	
		@Override
		public User create(User newUser) {
		
			
			try {Connection conn = ConnectionFactory.getInstance().getConnection();
			
			
				newUser.setUserId(UUID.randomUUID().toString());
			
				String sql = "insert into users (user_id, first_name, last_name, email, username, password) values (?, ?, ?, ?, ?, ?)";
			
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, newUser.getId());
				ps.setString(2, newUser.getFirstName());
				ps.setString(3, newUser.getLastName());
				ps.setString(4, newUser.getEmail());
				ps.setString(5, newUser.getUsername());
				ps.setString(6, newUser.getPassword());
				
				
				//used to execute
				
				int rI = ps.executeUpdate();
				
				if(rI != 0) {
					System.out.println("Bank Account has been created");
					return newUser;
				}
			} catch (SQLException e) {
				// TODO verify desired result
				e.printStackTrace();
			}
			
			return null;
			
			
		}
	
		public Object findByUsername(String username) {
			
			
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
				
				
				String sql = "select * from users where username = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, username);
				ResultSet rs = ps.executeQuery();
	
				while (rs.next()) {
					User user = new User();
					//user.setUserId(rs.getString("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
	
					return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
	
			}
			return null;
		}
		
	
		public Object findByEmail(String email) {
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
				
				
				String sql = "select * from users where email = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ps.setString(1, email);
				ResultSet rs = ps.executeQuery();
	
				while (rs.next()) {
					User user = new User();
					//user.setUserId(rs.getString("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
	
					return user;
				}
			} catch (SQLException e) {
				e.printStackTrace();
	
			}
			return null;
		}
	
		public User findByUsernameAndPassword(String username, String password) {
			// TODO Auto-generated method stub
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
	
				String sql = "select * from users where username = ? and password = ?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, username);
				pstmt.setString(2, password);
				ResultSet rs = pstmt.executeQuery();
	
				while (rs.next()) {
					User user = new User();
					//user.setUserId(rs.getString("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
	
					return user;
				}
	
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
	
			return null;
			
		}
	
		@Override
		public List<User> findAll() {
			
			//create a list of all users
			List<User> usersList = new LinkedList<>();//import own collection
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
				//try connection 
				
				String sql = "select * from users"; //query to select all users
				
				PreparedStatement ps = conn.prepareStatement(sql);
				
				ResultSet rs = ps.executeQuery(sql);
	
				while (rs.next()) {
					User user = new User();
					//user.setUserId(rs.getString("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
	
					return usersList;//return the list of all users
				}
			} catch (SQLException e) {
				e.printStackTrace();
	
			}
			return null;
		}
	
		@Override
		public boolean delete(String id) {
				try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
				
				
				String sql = "delete from users where user_id = ?";
				PreparedStatement ps = conn.prepareStatement(sql);
					//log.info
				
				
				ps.setString(1, id);
				ResultSet rs = ps.executeQuery();
	
				while (rs.next()) {
					User user = new User();
					//user.setUserId(rs.getString("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
					
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
	
			}
			return false;
		}
	
		@Override
		public User findById(String id) {
			String sql = "SELECT * FROM USERS WHERE USER_ID = ?";
			//using movie example as guide
			try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
				//try connection
				PreparedStatement ps = conn.prepareStatement(sql);
	
			
				//log.info("Setting Up Values");
				ps.setString(1, id);
	
			
				ResultSet rs = ps.executeQuery();
	
				// Extract results out of ResultSet
				while (rs.next()) {
					User user = new User();
					//user.setUserId(rs.getString("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setUsername(rs.getString("username"));
					user.setPassword(rs.getString("password"));
				}
			
			} catch (SQLException e) {
				//log.error("Database Connection Issues";
				e.printStackTrace();
			}
			//logger.info("Problem with Setting Info");
			return null;
		}
	
		@Override
		public boolean update(User updateObjUser) {
				String sql = "UPDATE USERS SET first_name = ?,"
						   + " last_name = ?, "
						   + " email = ?, "
						   + " password = ?, "
						   + " id = ?, ";
				
				try (Connection conn = ConnectionFactory.getInstance().getConnection()){
					
					
					PreparedStatement ps = conn.prepareStatement(sql);
				
						ps.setString(1, updateObjUser.getFirstName());
						ps.setString(2, updateObjUser.getLastName());
						ps.setString(3, updateObjUser.getEmail());
						ps.setString(4, updateObjUser.getPassword());
						
						ResultSet rs = ps.executeQuery();
						
						while(rs.next()) {
							return true;
						}
						
						} catch (SQLException e) {
							//log.warn("Failed to Connect to Database"), e)
							e.printStackTrace();
						}
							   
					  
			return false;
		}

		@Override
		public boolean update(Double updateBalance, String BankId) {
			// TODO Auto-generated method stub
			return false;
		}
	
	
	}
