package bancoDados;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoriesDao {

	private Connection connection;
	
	//função construtora
		public CategoriesDao() {
			this.connection = new ConnectionFactory().getConnection();
		}
		
		//inserir uma categoria diferente
		public void inserir(CategoriesModel categories) {
			String sql = "INSERT INTO categories (id,name,description) VALUES(?,?,?)";
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setInt(1, categories.getId());
				stmt.setString(2, categories.getName());
				stmt.setString(3, categories.getDescription());
				stmt.execute();
				stmt.close();
				System.out.println("Output log: Categoria criada!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//selecionar todos registros de users
		public void selectAll() {
			String sql = """
					SELECT * from categories
					""";
			try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			int i = 1;
			while(rs.next()) {
				i++;
				CategoriesModel categories = new CategoriesModel(); 
				categories.setId(rs.getInt("id"));
				categories.setName(rs.getString("name"));
				categories.setDescription(rs.getString("description"));
				System.out.println("");
				System.out.println("---------Register " + i + "----------");
				categories.showData();
			}
			stmt.close();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		public CategoriesModel selectById(int id) {
			String sql = """
					SELECT * from categories WHERE id=?
					""";
			CategoriesModel categories = new CategoriesModel(); 
			try {
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
			categories.setId(rs.getInt("id"));
			categories.setName(rs.getString("name"));
			categories.setDescription(rs.getString("description"));
			System.out.println("---------Category found, id=" + id);
			System.out.println("Name: " + categories.getName());
			}
			else {
				return null;
			}
			stmt.close();
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
			return categories;
		}
		
		//Atualizar pelo id
		public void updateById(CategoriesModel categories) {
			String sql = """
					UPDATE categories set name=?, description=?
					WHERE id=? 
					""";
			
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, categories.getName());
				stmt.setString(2, categories.getDescription());
				stmt.setInt(3, categories.getId());
				stmt.execute();
				stmt.close();
				System.out.println("Output log: Categoria atualizada!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//deletar pelo id
		public void deleteById(CategoriesModel categories) {
			String sql = """
					DELETE FROM categories
					WHERE id=? 
					""";
			try {
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setInt(1, categories.getId());
				stmt.execute();
				stmt.close();
				System.out.println("Output log: Categoria deletada!");
			}catch(SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
}
