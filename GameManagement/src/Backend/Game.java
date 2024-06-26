package Backend;

public class Game {

    public int ID;
    String Title;

    //getters and Setters
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }


    //Constructor
    public Game(int id, String title){
        ID = id;
        Title = title;
    }


    public Game(String title) {
    	Title = title;
	}

	@Override
    public String toString() {
        return Title;
    }
}
