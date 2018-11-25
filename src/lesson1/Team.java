package lesson1;
import lesson1.Competitors.*;

public class Team {
    private String name;
    Competitor[] competitors;

    public String getName(){return name;}
    public Competitor[] getCompetitors(){return competitors;}

    public Team(String name, Competitor[] competitors){
        this.name = name;
        this.competitors = competitors;

    }

    public void teamResults(){
        for (Competitor c: competitors){
            if (c.isOnDistance())
                c.showResult();
        }
    }

    public void showTeam(){
        for (Competitor c: competitors){
            c.showCompetitor();
        }
    }
}
