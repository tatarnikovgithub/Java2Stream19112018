// Tasoev Batradz 22.11.2018

package lesson1;

import lesson1.Competitors.Cat;
import lesson1.Competitors.Competitor;
import lesson1.Competitors.Dog;
import lesson1.Competitors.Human;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Wall;
import lesson1.obstacles.Water;

public class MainClass {
    public static void main(String[] args) {
        Competitor[]competitors={new Human("Боб"), new Cat("Мурка"), new Cat("Барсик"), new Dog("Бобик")};
        Team team = new Team("Динамо", competitors );
        System.out.println("Команда " + team.getName() + " имеет следующий состав:");
        team.showTeam();

        System.out.println("======================================");
        Course course = new Course(new Cross(400), new Wall(2), new Water(1));
        course.doIt(team);
        System.out.println("======================================");
        team.teamResults();
    }

}
