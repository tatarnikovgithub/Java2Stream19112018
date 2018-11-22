package lesson1;
import lesson1.Competitors.*;

public class Team {
    String name;
    Competitor[] competitors = {new Human("Боб"), new Cat("Мурка"), new Cat("Барсик"), new Dog("Бобик")};

    public Team(String name){
        this.name = name;
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
