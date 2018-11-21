package lesson1.obstacles;

import lesson1.Competitors.Animal;
import lesson1.Competitors.Competitor;
import lesson1.Competitors.Team;

import java.util.Arrays;

public class Water extends Obstacle {
    private int distance;

    public Water(int distance) {
        this.distance = distance;
    }

    @Override
    public void doIt(Competitor competitor) {
        competitor.swim(distance);
    }

    @Override
    public void doIt(Team team) {
        Arrays.stream(team.getCompetitors())
                .forEach(this::doIt);
    }
}
