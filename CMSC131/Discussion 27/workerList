import java.util.ArrayList;
import java.util.Iterator;
public class WorkerList
{
  private ArrayList<Worker> workers;

  public WorkerList()
  {
    workers = new ArrayList<Worker>();
  }
  public void addWorker(Worker newMember)
  {
    workers.add(newMember);
  }
  public int numWorkers() 
  {
    return workers.size();
  }
  public int getWorker(String name)
  {
    int them = 0, it = -1;
    for(int g = 0; them < 1; g++)
    {
      if (name.equals(workers.get(g).getName()));
      {
        it = g;
        them++;
      }
    }
    return it;
  }
  public void giveRaises()
  {
    for(int g = 0; g < workers.size(); g++)
    {
      workers.get(g).acceptRaise(1000);
    }
  }
  public int getTotalOfSalaries()
  {
    int total = 0;
    for(int g = 0; g < workers.size(); g++)
    {
      total += workers.get(g).getSalary();
    }
    return total;
  }
  public int countNames(String name)
  {
    int person = 0;
    
    for (int g = 0; g < workers.size(); g++)
    {
      if (name.equals(workers.get(g).getName()))
      {
        person++;
      }
    }
    return person;
  }
  public ArrayList<Instructor> topWorkers(int money)
  {
    ArrayList<Instructor> topWorkers = new ArrayList<Instructor>();
    Iterator<Worker> it = workers.iterator();
    
    while(it.hasNext())
    {
      Instructor inst = (Instructor) it.next();
      if (inst.getSalary() >= money)
      {
        topWorkers.add(inst);
      }
    }
    return topWorkers;
  }
}
