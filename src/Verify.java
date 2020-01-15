import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
public class Verify
{
	public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {    
        MessageDigest md = MessageDigest.getInstance("SHA-256");   
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
    
    public static String toHexString(byte[] hash) 
    { 
          
        BigInteger number = new BigInteger(1, hash);    
        StringBuilder hexString = new StringBuilder(number.toString(16));  
        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    }
	public static void main(String[] args)
	{
		try{
		String m="",r="",b="";
		File mfile=new File("C:/Users/Prudhvi/Desktop/Anish/data/input.txt");
		Scanner msc=new Scanner(mfile);
		while (msc.hasNextLine()) 
      		m=msc.nextLine();
      	File rnd=new File("C:/Users/Prudhvi/Desktop/Anish/data/solution.txt");
		Scanner rand=new Scanner(rnd);
		while (rand.hasNextLine()) 
      		r=rand.nextLine();
      	File bites=new File("C:/Users/Prudhvi/Desktop/Anish/data/target.txt");
		Scanner byt=new Scanner(bites);
		while (byt.hasNextLine()) 
      		b=byt.nextLine();
      	BigInteger bits=new BigInteger(b,2);
      	String h=m+r;
      	String hex=toHexString(getSHA(h));
		BigInteger bi1 =new BigInteger(hex,16);
      	if(bits.compareTo(bi1)==1 || bits.compareTo(bi1)==0)
		{
			
			System.out.println("1");
		}
		else
		{
			System.out.println("0");;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
