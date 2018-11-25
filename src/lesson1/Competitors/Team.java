package lesson1.Competitors;

public class Team {
    private String title;
    private Competitor[] competitors;

    public Team(String title, Competitor... competitors) {
        this.title = title;
        this.competitors = competitors;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showResults(){
        System.out.println("Team: " + title);
        for (Competitor o: competitors){
            if (o.isOnDistance()){
                o.showResult();
            }
        }
    }


}
