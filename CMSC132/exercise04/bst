package bst;

public class BST
{
  private class Node
  {
    private int data;
    private Node left, right;

    public Node(int data)
    {
      this.data= data;
      this.left= this.right= null;
    }
  }

  private Node root;

  public boolean insert(int value)
  {
    if(root == null)
    {
      root = new Node(value);
      return true;
    }
    else
    {
      return insert(value, root);
    }
  }
  
  public boolean insert(int value, Node theNode)
  {
    if(value == root.data)
    {
      return false;
    }
    else
    {
      if(value < theNode.data)
      {
    	if(theNode.left == null)
    	{
        theNode.left = new Node(value);
        return true;
    	}
    	else
    	{
          return insert(value, theNode.left);
    	}
      }
      else
      {
        if(value > theNode.data)
        {
          if(theNode.right == null)
          {
            theNode.right = new Node(value);
            return true;
          }
          else
          {
            return insert(value, theNode.right);
          }
        }
      }
    }
    return false;
  }

  private String toString(Node travel)
  {
    String result= "", left, right;

    if (travel != null)
    {
      left= toString(travel.left);
      right= toString(travel.right);
      result += left + (left.equals("") ? "" : " ") + travel.data +
                       (right.equals("") ? "" : " ") + right;
    }
    return result;
  }

  public String toString()
  {
    return toString(root);
  }
}
