package mvc.model;

import java.io.*;
import java.sql.*;
import java.util.*;
import org.springframework.web.multipart.MultipartFile;

public class UsuarioDAO {
	private Connection connection = null;

	public UsuarioDAO() {
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

	public void adiciona(Usuario usuario) throws IOException {
		// MultipartFile filePart = usuario.getFoto();
		/*
		 * Rotina para salvar o arquivo no servidor if (!filePart.isEmpty()) { String
		 * fileName = filePart.getOriginalFilename(); File uploads = new File("/tmp");
		 * File file = new File(uploads, fileName); try (InputStream input =
		 * filePart.getInputStream()) { Files.copy(input, file.toPath()); } }
		 */
		try {
			String sql = "INSERT INTO usuario (login, senha) values(?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getLogin());
			stmt.setString(2, usuario.getSenha());
			// stmt.setBinaryStream(3, filePart.getInputStream());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public boolean existeUsuario(Usuario usuario) {
		boolean existe = false;
		try {
			PreparedStatement stmt = connection
					.prepareStatement("SELECT COUNT(*) FROM usuario WHERE login=? LIMIT 1");
			stmt.setString(1, usuario.getLogin());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				if (rs.getInt(1) != 0) {
					existe = true;
				}
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return existe;
	}

	public byte[] buscaFoto(String login) {
		byte[] imgData = null;
		try {
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM usuario WHERE login=? ");
			stmt.setString(1, login);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				Blob image = rs.getBlob("foto");
				imgData = image.getBytes(1, (int) image.length());
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return imgData;
	}
	
	public boolean validarUsuario(Usuario usuario) throws SQLException {
		boolean existe = false;
		PreparedStatement stmt = connection.prepareStatement("SELECT COUNT(*) FROM usuario WHERE login=? AND senha=? LIMIT 2");
		stmt.setString(1, usuario.getLogin());
		stmt.setString(2, usuario.getSenha());
		ResultSet rs = stmt.executeQuery();
		if (rs.next()) {
			if (rs.getInt(1) != 0) {
				existe = true;
			}
		}
	
		return existe;
	}
}