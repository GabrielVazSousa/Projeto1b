package mvc.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NotaDAO {
	private Connection connection = null;

	public NotaDAO() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/spring", "root", "123456");
			// connection =
			// DriverManager.getConnection("jdbc:mysql://172.31.44.51:3306/089b6a3gdg26405dbf6cffd67d99c7g9",
			// "1605g7b39cb74904a7158d5369764d6f", "331g0bd126g148ffa363g3044d7658b3");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void adiciona(Nota nota, String login) throws IOException {
		// MultipartFile filePart = usuario.getFoto();
		/*
		 * Rotina para salvar o arquivo no servidor if (!filePart.isEmpty()) { String
		 * fileName = filePart.getOriginalFilename(); File uploads = new File("/tmp");
		 * File file = new File(uploads, fileName); try (InputStream input =
		 * filePart.getInputStream()) { Files.copy(input, file.toPath()); } }
		 */
		try {
			String sql = "INSERT INTO nota (name, text, label, login) values(?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nota.getName());
			stmt.setString(2, nota.getText());
			stmt.setString(3, nota.getLabel());
			stmt.setString(4, login);
			// stmt.setBinaryStream(3, filePart.getInputStream());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public List<Nota> getNotas(String usuario) throws ParseException {
		List<Nota> notas = new ArrayList<Nota>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM nota WHERE login=?");
			
			stmt.setString(1, usuario);
			}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			    Date parsedDate = dateFormat.parse(rs.getString("ts"));
			    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				Nota nota = new Nota();
				nota.setText(rs.getString("text"));
				nota.setName(rs.getString("name"));
				nota.setLabel(rs.getString("label"));
				nota.setTs(timestamp);
				nota.setId(rs.getInt("notaId"));
				notas.add(nota);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notas;
	}
	
	public List<Nota> deleteNota(int id, String usuario) throws ParseException, SQLException {
		PreparedStatement stmt = null;
		stmt = connection.prepareStatement("DELETE FROM nota WHERE notaId=?");
		stmt.setInt(1, id);
		stmt.executeUpdate();
		
		List<Nota> notas = new ArrayList<Nota>();
		
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM nota WHERE login=?");
			
			stmt.setString(1, usuario);
			}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			    Date parsedDate = dateFormat.parse(rs.getString("ts"));
			    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				Nota nota = new Nota();
				nota.setText(rs.getString("text"));
				nota.setName(rs.getString("name"));
				nota.setLabel(rs.getString("label"));
				nota.setTs(timestamp);
				nota.setId(rs.getInt("notaId"));
				notas.add(nota);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notas;
	}
	public boolean editaNota(Nota nota) throws ParseException, SQLException {
		PreparedStatement stmt = null;
		stmt = connection.prepareStatement("UPDATE nota SET name=?,label=?,text=? WHERE notaId=?");
		stmt.setString(1, nota.getName());
		stmt.setString(2, nota.getLabel());
		stmt.setString(3, nota.getText());
		stmt.setInt(4, nota.getId());
		stmt.executeUpdate();
		
		return true;
	}
	
	public Nota getNota(int id) throws ParseException, SQLException {
		PreparedStatement stmt = null;
		stmt = connection.prepareStatement("SELECT * FROM nota WHERE notaId=?");
		stmt.setInt(1, id);
		Nota nota = new Nota();
		ResultSet rs = null;
		rs = stmt.executeQuery();
		while (rs.next()) {
			nota.setText(rs.getString("text"));
			nota.setName(rs.getString("name"));
			nota.setLabel(rs.getString("label"));
			nota.setId(id);
		}
		return nota;
	}
	
	public List<Nota> getNotasFiltro(String usuario, Nota nota) throws ParseException {
		List<Nota> notas = new ArrayList<Nota>();
		PreparedStatement stmt = null;
		try {
			stmt = connection.
					prepareStatement("SELECT * FROM nota WHERE login=? AND name LIKE ?");
			
			stmt.setString(1, usuario);
			stmt.setString(2, ("%"+nota.getName()+"%"));
			}
		 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		 }
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery();
			
			while (rs.next()) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			    Date parsedDate = dateFormat.parse(rs.getString("ts"));
			    Timestamp timestamp = new java.sql.Timestamp(parsedDate.getTime());
				Nota _nota = new Nota();
				_nota.setText(rs.getString("text"));
				_nota.setName(rs.getString("name"));
				_nota.setLabel(rs.getString("label"));
				_nota.setTs(timestamp);
				_nota.setId(rs.getInt("notaId"));
				notas.add(_nota);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return notas;
	}

}
