package lesson1.obstacles;

import lesson1.Competitors.Team;

import java.util.Arrays;

public class Course {
    Obstacle[] obstacles = new Obstacle[3];

    public Course(Obstacle obstacle1, Obstacle obstacle2, Obstacle obstacle3) {
        obstacles[0] = obstacle1;
        obstacles[1] = obstacle2;
        obstacles[2] = obstacle3;
    }

    public void doIt(Team team) {
        Arrays.stream(obstacles).forEach(obstacle -> obstacle.doIt(team));
    }

}
