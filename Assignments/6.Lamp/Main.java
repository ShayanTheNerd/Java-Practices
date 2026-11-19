public class Main {
  public static void main(String[] args) {
    Lamp deskLamp = new Lamp("Desk Lamp");
    Lamp roomLamp = new Lamp("Room Lamp");

    deskLamp.turnOn();
    deskLamp.printStatus();
    roomLamp.printStatus();

    System.out.println("================================");

    deskLamp.turnOff();
    roomLamp.turnOn();
    deskLamp.printStatus();
    roomLamp.printStatus();
  }
}

class Lamp {
  private String name;
  private boolean isOn;

  public Lamp(String name) {
    this.name = name;
    this.isOn = false;
  }

  void turnOn() {
    this.isOn = true;
  }
  void turnOff() {
    this.isOn = false;
  }
  void printStatus() {
    System.out.println(this.name + " is " + (this.isOn ? "on" : "off"));
  }
}
