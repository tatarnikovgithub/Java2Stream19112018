package lesson1.courses;

import lesson1.Competitors.Competitor;
import lesson1.obstacles.Obstacle;
import lesson1.teams.Team;

public class CourseImpl implements Course {
    private final Obstacle[] obstacles;

    public CourseImpl(Obstacle... obstaclesArr) {
        this.obstacles = obstaclesArr;
    }

    public void doIt(Team team) {
        for (Competitor c: team.getCompetitors()){
            for (Obstacle o: obstacles){
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }
    }
}
