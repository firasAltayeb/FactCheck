package MoneyTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class MTOnlineLink {

	public MTOnlineLink() throws IOException {

		URL dataLink = new URL("http://www.gamefaqs.com/gba/582399-who-wants-to-be-a-millionaire/faqs/40043");
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(dataLink.openStream(), "ISO-8859-1")));

		/* "startFinder" arrayList and "beginningLine" are going to be used in order to find the beginning 
		 of the the questions in the provided URL and then store the beginning Line in the int variable.*/
		int beginningLine = 0;
		ArrayList<String> startFinder = new ArrayList<String>();
		// the following for loop stores all the lines provided from the URl in an arrayList
		for(int i=0;i<1926;i++)
		{
			startFinder.add(in.nextLine());
		}
		/*the following for loop goes through all the lines in the startFinder arrayList
		 except for the lines which are empty and the lines which do not have at least have 5 characters.  
		 After finding the beginning line which starts with "---" the result will be stored in an int variable.
		  */
		for(int i=0;i<startFinder.size();i++)
		{	
			if(!(startFinder.get(i).isEmpty()||startFinder.get(i).length()<5))
			{
				//System.out.println(i+" "+startFinder.get(i));
				if(startFinder.get(i).substring(0,3).equals("---"))
				{
					beginningLine = i+1;
					break;
				}
			}
		}

		in.close();
		
		/*Using the following for loop UMData will contain all the questions and answers
		  provided by the URL, UMData stands for unmodified Data.*/
		ArrayList<String> UMData = new ArrayList<String>();
		for(int i=beginningLine;i<startFinder.size();i++)
		{	
			UMData.add(startFinder.get(i));
		}
		
		
		/*Using the following for loop MQuestions array list will contain all the modified questions which do not 
		  have the "#####" simple in their start, MQuestions stands for "modified questions".*/ 
		ArrayList<String> MQuestions = new ArrayList<String>();
		for(int i=0;i<=UMData.size();i+=10)
		{
			try
			{
				MQuestions.add("<html>"+UMData.get(i).substring(7,UMData.get(i).indexOf("?")+1)+"</html>");
			}
			catch(Exception e)
			{
				MQuestions.add("<html>"+UMData.get(i).substring(7,UMData.get(i).length())+UMData.get(i+1).substring(6, UMData.get(i+1).indexOf("?")+1)+"</html>");
				i++;
			}

		} 

		/*Using the following for loop MCorreectAnswers will contain all the modified CorreectAnswers that do not have the
		 "Answer: " String in their start, MCorreectAnswers stands for "modified CorreectAnswers".*/
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

		/*Using the following for loop MAnswersOptions will contain all the modified answersOptions
		  which are taken from the UNData arrayList, MAnswersOptions stands for "modified answersOptions".*/
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

		
		/*for(int i=0;i<UMData.size();i++)
		{
			System.out.println(i+" "+UMData.get(i));
		}
		for(int i=0;i<MQuestions.size();i++)
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

		new MTOMethods(MQuestions,MCorreectAnswers,MAnswersOptions);


	}

}
