package index;

public class WordEntry
{
	private String newWord; //Private as mandated
	private int[] newPages;
	
	public WordEntry(String word, int[] pages) //Simple constructor
	{
		this.newWord = word;
		this.newPages = pages;
	}
	
	public String getWord() //Simple getter
	{
		return newWord;
	}
	
	public int[] getPages() //Simple Page Array getter
	{
		return newPages;
	}
	
	public String stringPage() //Makes Index's toString much, much simpler
	{
		String pageString = "";
		
		for (int g : newPages)
		{
			pageString +=" "+g; //For each loop worked here when original for loop didn't
		} //Always a space before number, never after, perfect
		return pageString;
	}
}
