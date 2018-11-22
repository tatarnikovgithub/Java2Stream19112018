  package lesson1;

  import lesson1.Competitors.*;
  import lesson1.obstacles.*;

  public class MainClass {
    public static void main(String[] args) {
      Competitor[] competitors = {
          new Human("Боб"),
          new Human("Баб"),
          new Cat("Барсик"),
          new Dog("Бобик")
      };
      Obstacle[] obstacles = {
          new Cross(400),
          new Wall(2),
          new Water(1)
      };
      Team team1 = new Team("Первая", competitors);
      Course course1 = new Course(obstacles);

      System.out.printf("Состав команды \"%s\":%n", team1.getTeamName());
      team1.showTeamInfo();

      System.out.println();
      course1.doIt(team1);

      System.out.printf("%nРезультаты команды \"%s\":%n", team1.getTeamName());
      team1.showTeamResults();

      /*for (Competitor c: competitors){
          for (Obstacle o: obstacles){
              o.doIt(c);
              if (!c.isOnDistance()) break;
          }
      }

      System.out.println("========================");
      for (Competitor c: competitors){
        c.showResult();
      }*/
    }
  }
