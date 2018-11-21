package lesson1.obstacles;

import lesson1.Competitors.Animal;
import lesson1.Competitors.Competitor;
import lesson1.Competitors.Team;

public abstract class Obstacle {
    public abstract void doIt(Competitor competitor);
    public abstract void doIt(Team team);
}
