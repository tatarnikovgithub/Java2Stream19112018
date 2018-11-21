package lesson1.teams;

import lesson1.Competitors.Competitor;

public class TeamImpl implements Team {
    private final String name;
    private final Competitor[] competitors;

    public TeamImpl (String name, Competitor... competitorsArr) {
        this.name = name;
        this.competitors = competitorsArr;
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }

    public void showResults() {
        System.out.println("========================");
        System.out.println(String.format("Результаты %s", name));
        for (Competitor c: competitors){
            c.showResult();
        }
    }
}
