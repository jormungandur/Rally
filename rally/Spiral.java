package rally;

public class Spiral 
{
	private int size;
	private int[][] spiral;
	//only accepts pos ints
	public Spiral(int toCountTo)
	{
		size = -1;
		setSize(toCountTo);
	}
	
	public void setSize(int toCountTo)
	{
		if(toCountTo > -1 )
		{
			this.size = toCountTo+1;	//toCountTo+1 is the ammount of numbers to be output
			createSpiral();
		}
	}
	
	private void createSpiral()
	{
		if(size < 1)
		{
			return;
		}
		//size needed to make spiral is the sqrt of the amount of numbers printed 
		int dimention = (int) Math.ceil(Math.sqrt(size));
		spiral = new int[dimention][dimention];
		for(int i = 0; i<dimention; i++)
		{
			for(int j = 0; j<dimention; j++)
			{
				spiral[i][j] = -1;
			}
		}
		
		//calculation to find the middle square of the spiral
		int middle = (dimention - (dimention/2))-1;
		
		//x, y cords of current position
		int x = middle;
		int y = middle;
		spiral[middle][middle] = 0;
		
		//direction flags
		int posNegDir = 1;
		boolean xDir = true;
		
		//layer of spiral
		int layer = 1;
		
		//loop that fills the spiral array
		for(int i = 1;i < size;)
		{
			if(xDir)
			{
				for(int j = 0; j<layer && i < size; j++, i++)
				{
					x+=posNegDir;
					spiral[x][y] = i;
				}
			}
			else
			{
				for(int j = 0; j<layer && i < size; j++, i++)
				{
					y+=posNegDir;
					spiral[x][y] = i;
				}
				posNegDir *= -1;	//change forward backward direction
				layer++;			
			}
			xDir = !xDir;			//change x y direction
		}
	}
	
	public String toHtmlString()
	{
		int dimention = (int) Math.ceil(Math.sqrt(size));
		if(size < 1)
		{
			return "";
		}
		String  spiralString = "<html><pre>";
		int numOfDigits = Integer.toString(size-1).length(); //for formatting
		
		
		for(int i = 0; i<dimention; i++)
		{
			for(int j = 0; j<dimention; j++)
			{
				spiralString += " "; // spacing between characters
				
				if(spiral[j][i] < 0) //for blank areas
				{
					for(int k = 0; k < numOfDigits; k++)
					{
						spiralString += " ";
					}
					continue;
				}
				//pad spaces so all strings are the same size
				for(int k = 0; k < (numOfDigits-Integer.toString(spiral[j][i]).length());k++)
				{
					spiralString += " ";
				}
				spiralString += Integer.toString(spiral[j][i]);
			}
			spiralString += "<br>";
		}
		spiralString += "</pre></html>";
		return spiralString;
	}
	
	@Override
	public String toString()
	{
		int dimention = (int) Math.ceil(Math.sqrt(size));
		if(size < 1)
		{
			return "";
		}
		String  spiralString = "";
		int numOfDigits = Integer.toString(size-1).length(); //for formatting
		
		
		for(int i = 0; i<dimention; i++)
		{
			for(int j = 0; j<dimention; j++)
			{
				spiralString += " "; // spacing between characters
				
				if(spiral[j][i] < 0) //for blank areas
				{
					for(int k = 0; k < numOfDigits; k++)
					{
						spiralString += " ";
					}
					continue;
				}
				//pad spaces so all strings are the same size
				for(int k = 0; k < (numOfDigits-Integer.toString(spiral[j][i]).length());k++)
				{
					spiralString += " ";
				}
				spiralString += Integer.toString(spiral[j][i]);
			}
			spiralString += "\n";
		}
		return spiralString;
	}
}
