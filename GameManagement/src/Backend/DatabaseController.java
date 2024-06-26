package Backend;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


public class DatabaseController {
	

    public  static List<Game> games = new ArrayList<Game>();
    public static List<Player> players = new ArrayList<Player>();
    public static List<GameStat> stats = new ArrayList<GameStat>();

    //Database variables;
    static String myDriver = "oracle.jdbc.OracleDriver";
    static String myUrl = "jdbc:oracle:thin:@199.212.26.208:1521:SQLD";
    static Connection conn ;

    public static void InsertPlayer(Player newPlayer) {
        try {
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("Insert into player (first_name, last_name, address, postal_code, province, phone_number) values ('%s', '%s', '%s', '%s', '%s', '%s')", newPlayer.getFirstName(), newPlayer.getLastName(), newPlayer.getAddress(), newPlayer.getPostal_Code(), newPlayer.getProvince(), newPlayer.getPhone());

            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdatePlayersList();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
    
    public static void addNewGame(Game newGame) {
    	try {
    		OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("Insert into game (game_title) values('%s')", newGame.getTitle());

            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdateGamesList();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    		
    	}
    
    


    public static void UpdatePlayer(Player updatePlayer){

        try {
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("UPDATE player set first_name = '%s', last_name = '%s', address = '%s', postal_code = '%s', province = '%s', phone_number = '%s' WHERE player_id = %d", updatePlayer.getFirstName(), updatePlayer.getLastName(), updatePlayer.getAddress(), updatePlayer.getPostal_Code(), updatePlayer.getProvince(), updatePlayer.getPhone(), updatePlayer.getID());

            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdatePlayersList();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }

    }

    public static void InsertStat(GameStat newStat) {
        try {
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("Insert into playerandgame (game_id, player_id, playing_date, score) values (%d, %d, '%s', %s )", newStat.getGameID(), newStat.getPlayerID(), newStat.getPlayDate().toString(), Double.toString(newStat.getScore()));
            // execute the query, and get a java result set
            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdateGameStatsList();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }
    }
    


    public static void UpdateStat(GameStat stat){
        try{
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("UPDATE playerandgame SET score = %f WHERE player_game_id = %d", stat.getScore(), stat.getStatID());
            System.out.println(query);

            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdateGameStatsList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void DeleteStat(GameStat stat){
        try{
            OpenDatabaseConnection();

            Statement st = conn.createStatement();

            String query = String.format("DELETE FROM playerandgame WHERE player_game_id = %d", stat.getStatID());
            System.out.println(query);

            st.executeUpdate(query);

            CloseDatabaseConnection();

            UpdateGameStatsList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void InitialDataFetch(){

    }

    public static void testFetch(){
        UpdateGamesList();
        UpdatePlayersList();
        UpdateGameStatsList();
    }


    public static void OpenDatabaseConnection(){
        try {
            conn = DriverManager.getConnection(myUrl, "COMP228_m22_sl_31", "password");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void CloseDatabaseConnection(){
        try{
            conn.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    

    @SuppressWarnings("unchecked")
	public static void UpdateGamesList(){

        games = UpdateList("select * from game", DatabaseTypes.game);

    }

    @SuppressWarnings("unchecked")
	public static void UpdatePlayersList(){
        players = UpdateList("select * from player", DatabaseTypes.player);
    }

    @SuppressWarnings("unchecked")
	public static void UpdateGameStatsList(){
        stats = UpdateList("select * from playerandgame", DatabaseTypes.stats);

    }


    //method that returns generic list by fetching the database
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public static List UpdateList(String query, DatabaseTypes type){

        List databaseObjects = new ArrayList();

        try {

            OpenDatabaseConnection();


            // create the java statement
            Statement st = conn.createStatement();

            // execute the query, and get a java result set
            ResultSet rs = st.executeQuery(query);

            // Create object and add to array list
            while (rs.next()) {

                switch (type){
                    case game:
                        Game newGame = new Game(rs.getInt("game_id"), rs.getString("game_title"));
                        databaseObjects.add(newGame);
                        break;
                    case player:
                        Player newPlayer = new Player(rs.getInt("player_id"), rs.getString("first_name"), rs.getString("last_name"),rs.getString("address"),rs.getString("postal_code"),rs.getString("province"),rs.getString("phone_number"));
                        databaseObjects.add(newPlayer);
                        break;
                    case stats:
                        GameStat newStat = new GameStat(rs.getInt("player_game_id"), rs.getInt("player_id"), rs.getInt("game_id"), new SimpleDateFormat("yyyy-MM-dd").format(rs.getDate("playing_date")) , rs.getDouble("score"));
                        databaseObjects.add(newStat);
                        break;
                }
            }

            //close statement and result set
            rs.close();
            st.close();

            // close database connection
            CloseDatabaseConnection();

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        //return list of objects
        return databaseObjects;
    }
}
