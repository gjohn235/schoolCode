public class Owner
{
  private Car[] vehicles;

  public Owner()
  {
    vehicles = new Car[0];
  }
  public void buyCar(Car c)
  {
    int g;
    Car[] biggerGarage = new Car[vehicles.length + 1];
    
    for (g = 0; g < vehicles.length; g++)
    {
      biggerGarage[g] = vehicles[g];
    }
    biggerGarage[vehicles.length] = c;
    vehicles = biggerGarage;
  }
  public void printCars()
  {
    int g;
    
    for (g = 0; g < vehicles.length; g++)
    {
      System.out.println("Car #" + (g + 1) + ": " + vehicles[g].toString());
    }
  }
  public void removeCar(String make, int year)
  {
    int g, j;
    Car[] smallerGarage = new Car[vehicles.length - 1];
  }
  public static void main(String[] args)
  {
    Owner o= new Owner();

    o.buyCar(new Car("Dodge", 2010, 18000));
    o.buyCar(new SportCar("Maserati", 2009, 120000, 3.75, 180));
    o.buyCar(new Car("Ford", 2009, 23000));
    o.buyCar(new SportCar("Ferrari", 2007, 150000, 2.95, 175));
    o.buyCar(new Car("Toyota", 2005, 21500));

    o.printCars();
    System.out.println();

    o.removeCar("Maserati", 2009);
    o.removeCar("Dodge", 2010);
    o.removeCar("Toyota", 2005);
    o.printCars();
  }
}
