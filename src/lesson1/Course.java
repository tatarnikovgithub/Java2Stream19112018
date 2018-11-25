package lesson1;

import lesson1.Competitors.Competitor;
import lesson1.obstacles.Cross;
import lesson1.obstacles.Obstacle;
import lesson1.obstacles.Wall;
import lesson1.obstacles.Water;

public class Course {
   private Obstacle[] obstacles;

   public Course(Obstacle... obstacles){
       this.obstacles = obstacles;
   }

    public void doIt(Team team){
        for (Competitor c: team.getCompetitors()){
            for (Obstacle o: obstacles){
                o.doIt(c);
                if (!c.isOnDistance()) break;
            }
        }

    }


}
