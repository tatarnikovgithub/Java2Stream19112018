package lesson1.Competitors;

public class Team {
  private String teamName;
  private Competitor[] competitors;

  public Team(String teamName, Competitor[] competitors){
    this.teamName = teamName;
    this.competitors = competitors;
  }

  public String getTeamName(){
    return teamName;
  }
  public Competitor[] getCompetitors(){
    return competitors;
  }
  public void showTeamResults(){
    for (Competitor c: competitors){
      if (c.isOnDistance()){
        c.showResult();
      }
    }
  }
  public void showTeamInfo(){
    for (Competitor c: competitors){
      c.showCompetitorInfo();
    }
  }
}
