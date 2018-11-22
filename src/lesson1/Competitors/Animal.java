package lesson1.Competitors;

public abstract class Animal implements Competitor{
  private String type;
  private String name;
  private int maxRunDistance;
  private int maxJumpHeight;
  private int maxSwimDistance;
  private boolean onDistance;

  public boolean isOnDistance() {
      return onDistance;
  }

  public Animal(String type, String name, int maxRunDistance, int maxJumpHeight, int maxSwimDistance) {
      this.type = type;
      this.name = name;
      this.maxRunDistance = maxRunDistance;
      this.maxJumpHeight = maxJumpHeight;
      this.maxSwimDistance = maxSwimDistance;
      this.onDistance = true;
  }

  public void run(int distance){
      if (distance <=maxRunDistance){
          System.out.println(type + " " + name + " " + " успешно справился с кросс");
      } else {
          System.out.println(type + " " + name + " " + " не смог преодолеть кросс");
          onDistance = false;
      }
  }

  public void jump(int height){
      if (height <=maxJumpHeight){
          System.out.println(type + " " + name + " " + " успешно справился с препятствием");
      } else {
          System.out.println(type + " " + name + " " + " не смог преодолеть препятствие");
          onDistance = false;
      }
  }

  public void swim(int distance){
      if (maxSwimDistance == 0){
          System.out.println(type + " " + name + " не умеет плавать");
          onDistance = false;
          return;
      }
      if (distance <=maxSwimDistance){
          System.out.println(type + " " + name + " " + " успешно проплыл дистанцию");
      } else {
          System.out.println(type + " " + name + " " + " не смог проплыть дистанцию");
          onDistance = false;
      }
  }

  public void showResult(){
      System.out.println(type + " " + name + ": " + onDistance);
  }

  public void showCompetitorInfo(){
      System.out.printf("%s %s может пробежать: %d, перепрыгнуть %d и проплыть %d%n",
          type, name, maxRunDistance, maxJumpHeight, maxSwimDistance);
  }
}
