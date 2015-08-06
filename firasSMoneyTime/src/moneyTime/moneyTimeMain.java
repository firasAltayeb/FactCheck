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
		
		/*UMData stands for unmodified Data, the unmodified data is the data which
		  contains all the lines in the URL*/
		ArrayList<String> UMData = new ArrayList<String>();
		for(int i=0;i<1120;i++)
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
		
		/*MQuestions stands for "modified questions", modified questions are the question
		  that do not have the "#####" code in their start */
		ArrayList<String> MQuestions = new ArrayList<String>();
		for(int i=0;i<=UMData.size();i+=10)
		{
			try
			{
				MQuestions.add(UMData.get(i).substring(7,UMData.get(i).indexOf("?")+1));
			}
			catch(Exception e)
			{
				MQuestions.add(UMData.get(i).substring(7,UMData.get(i).length())+UMData.get(i+1).substring(6, UMData.get(i+1).indexOf("?")+1));
				i++;
			}
			
		}
		
		/*MCorreectAnswers stands for "modified CorreectAnswers", modified CorreectAnswers are the CorreectAnswers
		  that do not have the "Answer: " String in their start */
		ArrayList<String> MCorreectAnswers = new ArrayList<String>();
		for(int i=7;i<=UMData.size();i+=10)
		{
			if(UMData.get(i).isEmpty())
			{
				i++;
				MCorreectAnswers.add(" *"+UMData.get(i).substring(UMData.get(i).indexOf(' ')+1, UMData.get(i).length()));
			}
			else
			{
				MCorreectAnswers.add(" *"+UMData.get(i).substring(UMData.get(i).indexOf(' ')+1, UMData.get(i).length()));
			}
		}
		
		//System.out.println(UMData.size());
		/*MAnswersOptions stands for "modified answersOptions", modified answersOptions arrayList contains
		  the answersOptions which are taken from the UNData arrayList */
		ArrayList<String> MAnswersOptions = new ArrayList<String>();
		for(int i=0;i<=UMData.size()-1;i++)
		{
			if(UMData.get(i).isEmpty())
			{}
			else if(UMData.get(i).charAt(1) == '*')
			{
				MAnswersOptions.add(UMData.get(i));
			}
			
		}
		
		/*for(int i=0;i<MQuestions.size();i++)
		{
			System.out.println(i+" "+MQuestions.get(i));
		}
			for(int i=0;i<MAnswersOptions.size();i++)
		{
			System.out.println(i+" "+MAnswersOptions.get(i));
		}
		for(int i=0;i<MCorreectAnswers.size();i++)
		{
			System.out.println(i+" "+MCorreectAnswers.get(i));
		}*/
		
		MTOMethods MTOM = new MTOMethods(MQuestions,MCorreectAnswers,MAnswersOptions);
		MTMethods MTM = new MTMethods();
		new MTStartScreen(MTM,MTOM);


	}

}
