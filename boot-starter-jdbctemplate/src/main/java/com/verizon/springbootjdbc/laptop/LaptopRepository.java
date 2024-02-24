


package com.verizon.springbootjdbc.laptop;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

//@Repository
//public class LaptopRepository {
//
//    @Autowired
//    JdbcTemplate jdbcTemplate;
//
//    //get laptops by id
//    Laptop getLaptopById(Integer id) {
//        return jdbcTemplate.queryForObject("SELECT * FROM laptop WHERE id = ?", new LaptopMapper(), id);
//    }
//
//    List<Laptop> getAllLaptops() {
//        return jdbcTemplate.query("SELECT * FROM laptop", new LaptopMapper());
//    }
//
//    int createNewLaptop(Laptop laptop) {
//        String query = "INSERT INTO laptop (model, ram, cost) VALUES (?, ?, ?)";
//        return jdbcTemplate.update(query, laptop.getModel(), laptop.getRam(), laptop.getCost());
//    }
//    
//       
//    int updateLaptop(Integer id, Laptop laptop) {
//    	String query = "UPDATE laptop SET model = ?, ram = ?, cost = ? WHERE id = ?";
//        return jdbcTemplate.update(query, laptop.getModel(), laptop.getRam(), laptop.getCost(), id);   
//        }
//
//    int deleteLaptop(Integer id) {
//        String query = "DELETE FROM laptop WHERE id = ?";
//        return jdbcTemplate.update(query, id);
//    }
//    
//    
//	class LaptopMapper implements RowMapper<Laptop>{
//
//		@Override
//		public Laptop mapRow(ResultSet rs, int rowNum) throws SQLException {
//			Laptop laptop = new Laptop(rs.getString("model"),
//					rs.getInt("ram"),
//					rs.getInt("cost"));
//			
//						return laptop;
//		}
//		
//	}
//}

@Repository
public interface LaptopRepository extends CrudRepository<Laptop, Integer>{
	
}