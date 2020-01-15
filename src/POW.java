import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.lang.*;
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;
import java.security.*;
public class POW
{
	static String getRandomString(int n)  //random string generation
    { 
  
        int lowerLimit = 97;  //small letters ascii
        int upperLimit = 122; 
        Random random = new Random(); 
        StringBuffer r = new StringBuffer(n); 
        for (int i = 0; i < n; i++) 
        {  
            int nextRandomChar=lowerLimit+(int)(random.nextFloat()*(upperLimit - lowerLimit + 1)); 
            r.append((char)nextRandomChar); 
        } 
        return r.toString();  //string successfully generated
    }
    public static String hash256(String data) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(data.getBytes());
        
        return bytesToHex(md.digest());
    }
    public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }  
    
	public static void main(String[] args)
	{
		long starttime=System.currentTimeMillis();
		try{
		
		int n=0;
		boolean flag=true;
		boolean flag1=true;
		String st="",m="";
		File mfile=new File("C:/Users/Prudhvi/Desktop/Anish/data/input.txt");
		Scanner msc=new Scanner(mfile);
		while (msc.hasNextLine()) 
      		m=msc.nextLine();
		PrintWriter outputfile = new PrintWriter("C:/Users/Prudhvi/Desktop/Anish/data/target.txt");
		PrintWriter outputfile1 = new PrintWriter("C:/Users/Prudhvi/Desktop/Anish/data/solution.txt");
		Scanner sc=new Scanner(System.in);
		while(flag)
		{
			System.out.println("Enter the level of difficulty : ");
			n=sc.nextInt();
			if(n>=20 && n<=26)
			{
				flag=false;
			}
			else
			{
				flag=true;
				System.out.println("Level of difficulty should be between 20 and 26");
			}
		} 
		for(int i=0;i<n;i++)
		{
			st="0"+st;
		}
		for(int i=0;i<(256-n);i++)
		{
			st=st+"1";
		}

		outputfile.println(st);
		outputfile.close();
		BigInteger bites=new BigInteger(st,2);
		
		while(flag1)
		{
			String randomtext=getRandomString(8);
		String h=m+randomtext;
		//M number hex to decimal following 2 lines
		String hex=(hash256(h));

		BigInteger bi1 =new BigInteger(hex,16); //hash string to decimal (In java, hash to decimal is converted via string)
		if(bites.compareTo(bi1)==1 ||bites.compareTo(bi1)==0)
		{
			//System.out.println(randomtext);
			System.out.println("The hash code is : "+hex);
			outputfile1.println(randomtext);
			outputfile1.close();
			flag1=false;
		}
		else
		{
			flag1=true;
		}
		}
		
		
		
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		long endtime=System.currentTimeMillis();
		long time=endtime-starttime;
		System.out.println("The running time of the code is : "+time);

	}
}

