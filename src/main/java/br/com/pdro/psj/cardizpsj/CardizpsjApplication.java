package br.com.pdro.psj.cardizpsj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CardizpsjApplication {

//	@Autowired
//	private DizimistaService dizimistaService;

	public static void main(String[] args) {
		SpringApplication.run(CardizpsjApplication.class, args);
	}

//	@EventListener(ContextRefreshedEvent.class)
//	public void warmup() {
//		System.out.println("Carregando registros do DB Access para Postgres");
//		String databaseURL = "jdbc:ucanaccess://" + "C:\\Users\\pedro\\Downloads\\cardizpsj\\src\\main\\resources\\dizimistas.accdb";
//
//		try (Connection connection = DriverManager.getConnection(databaseURL)) {
//
//			String sql = "SELECT * FROM Dizimistas";
//
//			Statement statement = connection.createStatement();
//			ResultSet result = statement.executeQuery(sql);
//
//			while (result.next()) {
//
//				int id = result.getInt("COD");
//				String fullname = result.getString("NOME");
//
//				Dizimista dizimista = new Dizimista();
//				dizimista.setCod(Long.valueOf(id));
//				dizimista.setNome(fullname);
//
//				Dizimista saved = dizimistaService.save(dizimista);
//
//				System.out.println(saved.toString());
//
//			}
//
//		} catch (SQLException ex) {
//			System.out.println(ex.getMessage());
//		}
//	}

}
