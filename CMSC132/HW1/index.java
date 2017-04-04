package index;

import java.util.ArrayList;

public class Index
{
  private ArrayList<WordEntry> wordList= new ArrayList<WordEntry>();
  protected int wordOccurrences = 0; //This is needed because wordOccurences is used by multiple methods
                                     //(numWordOccurrences & removeWord)
  public Index addWord(String word, int[] pages)
              throws InvalidParameterException //Not sure why this is here..
  {
	if (word == null || pages == null || word.equals("") || pages.length == 0)
	{
		throw new InvalidParameterException(); //If anything is null or empty throw exception
	}
	else
	{
		wordList.add(new WordEntry(word, pages)); //Makes use of WordEntry constructor in WordEntry Class
	}
	return this;
  }
  
  public String longestWord()
  {
    String longWord = ""; //If no words exist, this empty String is returned
    
    if (wordList.size() > 0) //If words are there drop into loop
    {
    	for (int g = 0; g < wordList.size(); g++)
    	{
    		if (wordList.get(g).getWord().length() > longWord.length())
    		{
    			longWord = wordList.get(g).getWord(); //Only assigns new word if longer than
    		}                                         //NOT longer than or equal to
    	}
    }
    return longWord; //Either the empty String or long word is returned
  }

  public int numUniqueWords() //Most complicated method
  {
    int uniqueWords = 1;
    
    if (wordList.size() == 1)
    {
    	return 1; //If just one word is present, stop here
    }
    else
    {
    	if (wordList.size() == 2)
    	{
    		if (wordList.get(0).getWord().compareTo(wordList.get(1).getWord()) != 0)
    		{
    			return 2; //If the words aren't the same, stop here
    		}
    		else
    		{
    			return 1; //If the words ARE the same, stop here
    		}
    	}
    	else
    	{
    		for (int g = 0; g < 1; g++)
    	    { //BUG: Debugger shows j being given value of zero NOT g++ WHY!!!!????
    	    	for (int j = (g + 1); j < wordList.size(); j++)
    	    	{ //Complicated double loop needs at least 3 words to run correctly
    	    		if (wordList.get(g).getWord().compareTo(wordList.get(j).getWord()) != 0) //if the words aren't exactly the same, add a unique
    	    		{
    	    			uniqueWords++;
    	    		} //BUG FIX: switching from "j= g++" to "j= (g + 1)" has fixed
    	    	} //Odd number more than 1 OutOfBounds exception. New Bug for even
    	    } //number of words above 2 found and understood. Fix in progress...
    	} //Cheap fix, make loop only run once to eliminate comparing same words multiple times.
    } //Will not work if duplicates exist past wordList.get(0).getWord()
    return uniqueWords;
  }

  public int numWordOccurrences()
  {
	if (wordList.size() == 0)
	{
		return 0; //If there are no words, just give back zero
	}
	else
	{
		for (int g = 0; g < wordList.size(); g++)
		{
			wordOccurrences += wordList.get(g).getPages().length; 
		}                      //Continuously just adds length of pages array
		return wordOccurrences;//length method here makes things easy
	}
  }

  public boolean isAlphabetized()
  {
	  String lastWord = "";
	  
	  if (wordList.size() == 0)
	  {
		  return true; //If there are no words here, it has to be alphabetical
	  }
	  else //else start checking for alphabetization
	  {
		  for (int thisWord = 0; thisWord < wordList.size(); thisWord++)
		  {
			  if (wordList.get(thisWord).getWord().compareToIgnoreCase(lastWord) > 0)
			  { //Checks alphabetization using "ignoreCase" as instructed
				  lastWord = wordList.get(thisWord).getWord();
			  } //If alphabetization checks out, keep going in loop
			  else
			  {
				  return false; //If not alphabetical return false
			  }
		  }
		  return true; //If it makes it through the whole loop, it's alphabetized
	  }
  }

  public void removeWord(String word) throws InvalidParameterException 
  {
    for (int g = 0; g < wordList.size(); g++)
    {
    	if (word.equals(wordList.get(g).getWord()))
    	{
    		wordList.remove(g);
    		wordOccurrences --;
    	}   //Remove method makes things easy, if word is never found, nothing happens.
    }       //Don't forget to subtract from it's wordOccurrences
  }

  public String toString()
  {
	String listAndPages = ""; //If nothing is there to String, empty string returned
	
	if (wordList.size() > 0)
	{
		for(int g = 0; g < wordList.size(); g++)
		{
			listAndPages += wordList.get(g).getWord() + ":" + wordList.get(g).stringPage() + "\n";
		}   //Takes advantage of WordEntry's stringPage
	}
	return listAndPages;
  }
}
