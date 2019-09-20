package mvc.model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	public void adiciona(Nota nota) throws IOException {
		// MultipartFile filePart = usuario.getFoto();
		/*
		 * Rotina para salvar o arquivo no servidor if (!filePart.isEmpty()) { String
		 * fileName = filePart.getOriginalFilename(); File uploads = new File("/tmp");
		 * File file = new File(uploads, fileName); try (InputStream input =
		 * filePart.getInputStream()) { Files.copy(input, file.toPath()); } }
		 */
		try {
			String sql = "INSERT INTO nota (name, text, label) values(?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, nota.getName());
			stmt.setString(2, nota.getText());
			stmt.setString(3, nota.getLabel());
			// stmt.setBinaryStream(3, filePart.getInputStream());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
