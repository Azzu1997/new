package Generic_libraries;

import java.util.Random;

public class JavaUtils 
{
	//A non static method
	public int getRandomno()
	{
	Random ran = new Random();
	int random = ran.nextInt(1000);
	return random;
		
	}
}
