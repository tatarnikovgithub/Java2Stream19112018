package lesson1.Competitors;

import java.util.Arrays;

public class Team {

    String teamName;

    Competitor[] competitors = new Competitor[4];

    public Team(String teamName, Competitor competitor1, Competitor competitor2, Competitor competitor3, Competitor competitor4) {
        this.teamName = teamName;
        competitors[0] = competitor1;
        competitors[1] = competitor2;
        competitors[2] = competitor3;
        competitors[3] = competitor4;
    }

    public void printInfo() {
        System.out.println(teamName);
        for (Competitor c : competitors) {
            c.showInfo();
        }
    }

    public void showPassedResult() {
        Arrays.stream(competitors)
                .filter(Competitor::isOnDistance)
                .forEach(Competitor::showResult);
    }

    public Competitor[] getCompetitors() {
        return competitors;
    }
}
