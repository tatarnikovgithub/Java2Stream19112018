// Tasoev Batradz 22.11.2018

package lesson1;

public class MainClass {
    public static void main(String[] args) {
        Team team = new Team("Динамо");
        System.out.println("Команда " + team.name + " имеет следующий состав:");
        team.showTeam();

        System.out.println("======================================");
        Course course = new Course();
        course.doIt(team);
        System.out.println("======================================");
        team.teamResults();
    }

}
