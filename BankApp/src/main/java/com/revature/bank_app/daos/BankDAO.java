package com.revature.bank_app.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import com.revature.bank_app.models.Bank;
import com.revature.bank_app.models.User;
import com.revature.bank_app.util.collections.List;
import com.revature.bank_app.util.datasource.ConnectionFactory;

public class BankDAO implements CrudDAO<Bank> {
	
	
	//create bank account
	public Bank create(Bank newBank) {
		
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			newBank.setBankId(UUID.randomUUID().toString());
			
			String sql = "insert into bank(bank_id, bank_balance, bank_type, creator_id) values (?, ?, ?, ?)";
			
		
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, newBank.getBankId());
			ps.setDouble(2, newBank.getBalance());
			ps.setString(3, newBank.getType());
			ps.setString(4, newBank.getCreator().getUserId());
			
			System.out.println(newBank.getCreator().getEmail());
			System.out.println(newBank.getCreator().getUserId());
			
			
			
			int rI = ps.executeUpdate();
			
			if(rI != 0) {
				return newBank;
			}
		
			
		} catch (SQLException e ) {
			e.printStackTrace();
		}
		
		return null;
	
	}

	//find bank account by id
	@Override
	public Bank findById(String creator_id) {
		
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			
			String sql = "select * from bank where creator_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1,  creator_id);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Bank bank = new Bank();
				
				
				bank.setUserId(rs.getString("bank_id"));
				bank.setType(rs.getString("bank_type"));
				bank.setBalance(rs.getDouble("bank_balance"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bank> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	

	//updating bank account balance
	public boolean update(Double updateBalance, String BankId) {
		try (Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "update bank set bank_balance = ? where bank_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setDouble(1,  updateBalance);
			ps.setString(2, BankId);
			
			
			int rU = ps.executeUpdate();
			if(rU != 0) {
				System.out.println("Balance Updated");
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return false;
		
	}
	

	@Override
	public boolean delete(String id) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String sql = "delete from bank where bank_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			ps.setString(1, id);
			
			int rowsDelete = ps.executeUpdate();
			
			if(rowsDelete != 0) {
				return true;
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}

	public double getBalance(String bankId) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String sql = "select bank_balance from bank where bank_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, bankId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Bank newBank = new Bank();
				
				newBank.setBalance(rs.getDouble("bank_balance"));

				return newBank.getBalance();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	@Override
	public boolean update(Bank updateObj) {
		// TODO Auto-generated method stub
		return false;
	}

}
