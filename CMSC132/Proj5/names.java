package names;

import java.io.*;   //Between all this it would've been a lot of lines of just
import java.util.*; //imports. Just keeping it more digestable.
import java.util.Map.Entry;
import java.net.*;
/*
 * This class takes data from the ssa website and through them into a nested
 * hashmap. After the threads created and finally die the results are are
 * interpreted through the last four methods. Here I utilize an inner class
 * that implements runnabe which is how my threads are created.
 */
public class Names
{
  Map<Integer, Map<String, String>> mapAndMap =  //Leo suggested Hashmap within
    new HashMap<Integer, Map<String, String>>(); //another Hashmap
  
  int nameYear;
  int nameRank;
  int numNames;
  
  public void getNames(int startYear, int endYear, int numNames)
  { 
    for(int g = startYear; g <= endYear; g++)
    { //Loop to create my threads, one for every year as instructed
      Thread ns = new Thread(new NetworkingStuff(g, numNames));
      ns.run();
      try
      {
        ns.join();
      }
      catch(InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
  
  public class NetworkingStuff implements Runnable
  { //Easier than using a seperate class
	public NetworkingStuff(int year, int names)
	{
	  nameYear = year;
	  numNames = names;
	}
	
	public void run()
	{
	  try
	  {
	    URL ssa = new URL("http://www.ssa.gov/cgi-bin/popularnames.cgi");
		URLConnection connect = ssa.openConnection(); //Where names come from
		connect.setDoOutput(true); //Stuff BlackBoard said to do
		OutputStream output = connect.getOutputStream();
		OutputStreamWriter writer = new OutputStreamWriter(output);

		String webJargon; //Stuff that BB said my program would read
		String rank; //Inner map key
		String names; //Inner map value
		boolean desiredData = false;

	    writer.write("year=" + nameYear + "&top=" + numNames);
	    writer.flush();

		BufferedReader webStuff= //now assigned what is read in from ssa website
		new BufferedReader(new InputStreamReader(connect.getInputStream()));
		webJargon = webStuff.readLine();
        
		Map<String, String> innerMap = new HashMap<String, String>();

		while((webJargon = webStuff.readLine()) != null)
		{
		  if(webJargon.equals("<tr align=\"right\">")) //From blackboard
		  {
		    desiredData = true;
		  }
		  else
		  {
		    if(webJargon.equals("<tr><td colspan=\"3\"><small>"
					+ "Note: Rank 1 is the most popular,"))
		    {
			  desiredData = false;
			}
			if(desiredData && webJargon.contains("<td>")) //Key notifier
			{
			  webJargon = webJargon.replace("<td>", "");  //Delete all the
			  webJargon = webJargon.replace("</td>", ""); //excess
			  webJargon = webJargon.substring(1);//There's a blank space to skip
			  rank = webJargon.substring(0, webJargon.indexOf(" "));
			  names = webJargon.substring(webJargon.indexOf(" ") + 1,
						webJargon.length());
			  innerMap.put(rank, names);
			} //Rank will be the first thing seen, the names are after the next
		  }   //blank space
		}
		mapAndMap.put(nameYear, innerMap); //insert all the data
		webStuff.close();
	  }
	  catch(MalformedURLException e)
	  {
		e.getMessage();
	  }
	  catch(UnknownHostException e)
	  {
	    e.getMessage();
	  }
	  catch(IOException e)
	  {
	    e.getMessage();
	  }
	}
  }
  
  public String getGirlName(int year, int rank)
  {
    String bothNames = mapAndMap.get(year).get(rank);
	return bothNames.substring(bothNames.indexOf(" ") + 1, bothNames.length());
  } //Girl name comes second so we start AFTER first space

  public String getBoyName(int year, int rank)
  {
    String bothNames = mapAndMap.get(year).get(rank);
	return bothNames.substring(0, bothNames.indexOf(" "));
  } //Boy name comes first so subString is to first space

  public int getGirlRank(int year, String name)
  {
    for(Entry<String, String> entry : mapAndMap.get(year).entrySet())
	{ //for each loop checks all popular names from desired year
	  if(entry.getValue().contains(name))
	  { //if our value contains the name given...
	    return Integer.valueOf(entry.getKey());
	  } //Reach into inner map and pull out the rank
	}
	return -1;
  }

  public int getBoyRank(int year, String name)
  {
    for(Entry<String, String> entry : mapAndMap.get(year).entrySet())
    { //for each loop checks all popular names from desired year
	  if(entry.getValue().contains(name))
	  { //if our value contains the name given...
	    return Integer.valueOf(entry.getKey());
	  } //Reach into inner map and pull out the rank
	}
    return -1; //This code is identical for boys and girls since the rank is
  }
}
