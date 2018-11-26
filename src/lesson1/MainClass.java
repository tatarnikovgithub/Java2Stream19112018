package lesson1;

import lesson1.Competitors.Cat;
import lesson1.Competitors.Dog;
import lesson1.Competitors.Human;
import lesson1.Competitors.Team;
import lesson1.obstacles.Course;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Wall;
import lesson1.obstacles.Water;

public class MainClass {
    public static void main(String[] args) {
        Team team = new Team("Rocket",new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"));
        Course course =  new Course(new Cross(400), new Wall(2), new Water(1));
        course.doIt(team);
        team.showResults();

    }
}
