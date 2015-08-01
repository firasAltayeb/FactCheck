package moneyTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MoneyTimeMain 
{
	public static void main(String[] args) throws IOException {
	
		
		URL kclLink = new URL("http://www.gamefaqs.com/gba/582399-who-wants-to-be-a-millionaire/faqs/40043");
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(kclLink.openStream(), "ISO-8859-1")));
		
		//UMData stands for unmodified Data
		ArrayList<String> UMData = new ArrayList<String>();
		for(int i=0;i<505;i++)
		{
			if(i<305)
			{
				in.nextLine();
			}
			else
			{
				UMData.add(in.nextLine());
			}
		}
		
		
		//System.out.println(UMData.get(20).substring(7,UMData.get(20).indexOf("?")+1));
	
		ArrayList<String> MQuestions = new ArrayList<String>();
		for(int i=0;i<=UMData.size();i+=10)
		{
			System.out.println(UMData.get(i));
			MQuestions.add(UMData.get(i).substring(7,UMData.get(i).indexOf("?")+1));
			
		}
		
		//System.out.println(MQuestions.get(1));
		//System.out.println(MQuestions.get(2));
		//String answerOption = UMData.get(3);
		//String correctAnswer= " *"+UMData.get(7).substring(UMData.get(7).indexOf(' ')+1, UMData.get(7).length());
		
		/*System.out.println(answerOption);
		System.out.println(correctAnswer);
		
		if(correctAnswer.equals(answerOption))
		{
			System.out.println("equal");
		}*/
		
		
		
		//MTMethods MTM = new MTMethods();
		//new MTStartScreen(MTM);


	}

}
