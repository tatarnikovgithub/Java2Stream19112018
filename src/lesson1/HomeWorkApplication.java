package lesson1;

import lesson1.Competitors.Cat;
import lesson1.Competitors.Dog;
import lesson1.Competitors.Human;
import lesson1.courses.Course;
import lesson1.courses.CourseImpl;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Wall;
import lesson1.obstacles.Water;
import lesson1.teams.Team;
import lesson1.teams.TeamImpl;

public class HomeWorkApplication {
    public static void main(String[] args) {
        Team team = new TeamImpl("Команда А", new Human("Боб"), new Cat("Барсик"), new Dog("Бобик"), new Cat("Котопес"));
        Course course = new CourseImpl(new Cross(400), new Wall(2), new Water(1));

        course.doIt(team);
        team.showResults();
    }
}
