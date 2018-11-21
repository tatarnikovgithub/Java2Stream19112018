package lesson1.teams;

import lesson1.Competitors.Competitor;

public class TeamImpl implements Team{
    private final Competitor[] competitors;

    public TeamImpl (Competitor... competitorsArr) {
        this.competitors = competitorsArr;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showResults() {
        System.out.println("========================");
        for (Competitor c: competitors){
            c.showResult();
        }
    }
}
