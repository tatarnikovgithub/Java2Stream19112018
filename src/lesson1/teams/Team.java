package lesson1.teams;

import lesson1.Competitors.Competitor;

public interface Team {
    Competitor[] getCompetitors();
    void showResults();
}
