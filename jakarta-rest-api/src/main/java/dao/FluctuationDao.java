package dao;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import entities.Fluctuation;
import dao.GestionConnexion;
import java.sql.*;
import java.util.ArrayList;

@Singleton
public class FluctuationDao {

	private static FluctuationDao fluctuationDao;
	private Connection conn;
	private static List<Fluctuation> fluctuations = new ArrayList<Fluctuation>();
	private static Fluctuation uneFluctuation;

	/*
	private static final List<Fluctuation> fluctuations = Stream.of(
		new Fluctuation( 10, 4),
		new Fluctuation(50, 40)
	).collect(Collectors.toList());
*/

	public static void addFluctuation(double prix, double modif){
		Fluctuation uneFluctuation = new Fluctuation(prix, modif);
		fluctuations.add(uneFluctuation);
	}

	public Fluctuation get(long id) {
		return null;//Fluctuations.stream().filter(Fluctuation -> Fluctuation.getId() == id).findAny().orElse(null);
	}

	public Fluctuation getByName(String name) {
		return null;//Fluctuations.stream().filter(Fluctuation -> Fluctuation.getName().equals(name)).findAny().orElse(null);
	}

	public List<Fluctuation> getLast() {
		/*
		System.out.println("avant connection");
		try{
			
			ArrayList<Fluctuation> mesFluctuation = new ArrayList<Fluctuation>();
			System.out.println("avant connection2");
			conn = GestionConnexion.getConnection();
			System.out.println("après connexion");
			String sql = "SELECT * FROM fluctuation";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				Fluctuation uneFluctuation = new Fluctuation(rs.getDouble("prix"), rs.getDouble("modif"));
				mesFluctuation.add(uneFluctuation);
			}

			//List<Fluctuation> fluctuationStream = mesFluctuation.stream().collect(Collectors.toList());
			//return Collections.unmodifiableList(mesFluctuation);
			return Collections.unmodifiableList(fluctuations);
		}catch(Exception e){
			//e.printStackTrace();
		}
		*/
		
		return uneFluctuation;
		
	}

	public void create(Fluctuation entity) {
		//Fluctuations.add(entity);
	}

	public void update(Fluctuation entity) {
		/*
		Fluctuation oldFluctuation = Fluctuations.stream().filter(Fluctuation -> entity.getId() == Fluctuation.getId()).findAny().orElse(null);
		if (oldFluctuation != null) {
			Fluctuations.remove((int) entity.getId());
			Fluctuations.add(entity);
		}
		*/
	}

	public void delete(Fluctuation entity) {
		//Fluctuations.remove((int) entity.getId());
	}

}
