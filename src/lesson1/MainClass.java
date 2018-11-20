package lesson1;

import lesson1.Competitors.*;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Wall;
import lesson1.obstacles.Water;

public class MainClass {
    public static void main(String[] args) {
        Competitor[] competitors = {new Human("Боб"), new Cat("Барсик"), new Dog("Бобик")};
        Obstacle[] obstacles = {new Cross(400), new Wall(2), new Water(1)};

        for (Competitor c: competitors){
            for (Obstacle o: obstacles){
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }

        System.out.println("========================");
        for (Competitor c: competitors){
            c.showResult();
        }
    }
}
