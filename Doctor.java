package com.hospital.yhcc;

//importing  

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Doctor {
	 private Connection connection;

	    public Doctor(Connection connection){
	        this.connection = connection;
	    }

	    public void viewDoctors() throws SQLException{
	        String query = "select * from doctors";
	      
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            ResultSet rs = preparedStatement.executeQuery();
	            System.out.println("Doctors: ");
	            System.out.println("+------------+--------------------+------------------+");
	            System.out.println("| Doctor Id  | Name               | Specialization   |");
	            System.out.println("+------------+--------------------+------------------+");
	            while(rs.next()){
	                int id = rs.getInt("id");
	                String name = rs.getString("name");
	                String specialization = rs.getString("specialization");
	                
	                System.out.println("+------------+--------------------+------------------+");
	            }

	        }

	    public boolean getDoctorById(int id) throws SQLException{
	        String query = "select * from doctors where id = ?";
	        
	            PreparedStatement preparedStatement = connection.prepareStatement(query);
	            preparedStatement.setInt(1, id);
	            ResultSet resultSet = preparedStatement.executeQuery();
	            if(resultSet.next()){
	                return true;
	            }else{
	                return false;
	            }
	    }

}
