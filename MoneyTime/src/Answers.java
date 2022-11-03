public class Answers {
	Questions qusListClass = new Questions();
	String[] qusList = qusListClass.createArray();
	/*The getCorrectAnswer method returns the current question's correct answer 
	 by comparing the current question with the qusList array strings, if the current question
	 matches a question in the qusList array the matched question's answer is returned as string*/
	public String getCorrectAnswer(String Question){
		String correctAnswer = "";
		if (Question.equals(qusList[0])){
			correctAnswer = "Foot-and-mouth";
		} 
		if (Question.equals(qusList[1])){
			correctAnswer = "Anaconda";
		}
		if (Question.equals(qusList[2])){
			correctAnswer = "Frogmen";
		}
		if (Question.equals(qusList[3])){
			correctAnswer = "Cup of tea";
		}
		if (Question.equals(qusList[4])){
			correctAnswer = "Almost certain";
		}
		if (Question.equals(qusList[5])){
			correctAnswer = "Burrowing";
		}
		if (Question.equals(qusList[6])){
			correctAnswer = "Dashboard";
		}
		if (Question.equals(qusList[7])){
			correctAnswer = "Crash helmet";
		}
		if (Question.equals(qusList[8])){
			correctAnswer = "On the rocks";
		}
		if (Question.equals(qusList[9])){
			correctAnswer = "Weir";
		}
		if (Question.equals(qusList[10])){
			correctAnswer = "Puppy love";
		}
		if (Question.equals(qusList[11])){
			correctAnswer = "Ace";
		}
		if (Question.equals(qusList[12])){
			correctAnswer = "The ice";
		} 
		if (Question.equals(qusList[13])){
			correctAnswer = "Cheese";
		}
		if (Question.equals(qusList[14])){
			correctAnswer = "Crossword";
		}
		if (Question.equals(qusList[15])){
			correctAnswer = "Cheese";
		}
		if (Question.equals(qusList[16])){
			correctAnswer = "Old Spice";
		} 
		if (Question.equals(qusList[17])){
			correctAnswer = "Victim";
		}
		if (Question.equals(qusList[18])){
			correctAnswer = "Food blender";
		}
		if (Question.equals(qusList[19])){
			correctAnswer = "Blockbuster";
		} 
		if (Question.equals(qusList[20])){
			correctAnswer = "Muzzle";
		}
		if (Question.equals(qusList[21])){
			correctAnswer = "Ivory";
		} 
		if (Question.equals(qusList[22])){
			correctAnswer = "Boil";
		}
		if (Question.equals(qusList[23])){
			correctAnswer = "Monk";
		}
		if (Question.equals(qusList[24])){
			correctAnswer = "Finding Nemo";
		} 
		if (Question.equals(qusList[25])){
			correctAnswer = "Barry White";
		}
		if (Question.equals(qusList[26])){
			correctAnswer = "Justin Timberlake";
		}
		if (Question.equals(qusList[27])){
			correctAnswer = "Clannad";
		} 
		if (Question.equals(qusList[28])){
			correctAnswer = "Dynamics";
		}
		if (Question.equals(qusList[29])){
			correctAnswer = "Wilburys";
		}
		if (Question.equals(qusList[30])){
			correctAnswer = "Frigate bird";
		} 
		if (Question.equals(qusList[31])){
			correctAnswer = "Bruce Almighty";
		}
		if (Question.equals(qusList[32])){
			correctAnswer = "Elton John";
		}
		if (Question.equals(qusList[33])){
			correctAnswer = "Bunker Hill";
		} 
		if (Question.equals(qusList[34])){
			correctAnswer = "Barry";
		}
		if (Question.equals(qusList[35])){
			correctAnswer = "Cornwall";
		}
		if (Question.equals(qusList[36])){
			correctAnswer = "Drink it";
		}
		if (Question.equals(qusList[37])){
			correctAnswer = "Weightlifting";
		}
		if (Question.equals(qusList[38])){ 
			correctAnswer = "James II";
		}
		if (Question.equals(qusList[39])){
			correctAnswer = "Mojave Desert";
		} 
		if (Question.equals(qusList[40])){
			correctAnswer = "Iowa";
		}
		if (Question.equals(qusList[41])){
			correctAnswer = "Arizona";
		}
		if (Question.equals(qusList[42])){
			correctAnswer = "Volleyball";
		} 
		if (Question.equals(qusList[43])){
			correctAnswer = "Ring";
		}
		if (Question.equals(qusList[44])){
			correctAnswer = "Gaelic football";
		}
		if (Question.equals(qusList[45])){
			correctAnswer = "Dodecanese";
		} 
		if (Question.equals(qusList[46])){
			correctAnswer = "Venice";
		}
		if (Question.equals(qusList[47])){
			correctAnswer = "Northumberland";
		}

		return correctAnswer;

	}
	//------------------------------------------------------------------------------------------------------------------------
	/*The getOptions method returns the current question's options
	 by comparing the current question with the qusList array strings, if the current question
	 matches a question in the qusList array the matched question's option is returned as an array*/
	public String[] getOptions(String Question){
		String ans1 = "";
		String ans2 = "";
		String ans3 = "";
		String ans4 = "";
		String[] options = new String[4];
		if (Question.equals(qusList[0])){
			ans1 = "Hand-and-foot";
			ans2 = "Foot-in-mouth";
			ans3 = "Hand-to-mouth";
			ans4 = "Foot-and-mouth";
		} 
		if (Question.equals(qusList[1])){
			ans1 = "Andalucia";
			ans2 = "Anaconda";
			ans3 = "Andypandy";
			ans4 = "Annerobinson";
		}
		if (Question.equals(qusList[2])){
			ans1 = "Frogmen";
			ans2 = "Newtmen";
			ans3 = "Protos";
			ans4 = "Lamborghini";
		}
		if (Question.equals(qusList[3])){
			ans1 = "Policeman";
			ans2 = "Cup of tea";
			ans3 = "2p coin";
			ans4 = "Smoked herring";
		}
		if (Question.equals(qusList[4])){
			ans1 = "Almost certain";
			ans2 = "Newly bought";
			ans3 = "Freshly cooked";
			ans4 = "Recently stolen";
		}
		if (Question.equals(qusList[5])){
			ans1 = "Burrowing";
			ans2 = "Climbing";
			ans3 = "Swimming";
			ans4 = "Flying";
		}
		if (Question.equals(qusList[6])){
			ans1 = "Chargeboard";
			ans2 = "Sprintboard";
			ans3 = "Dashboard";
			ans4 = "Jogboard";
		}
		if (Question.equals(qusList[7])){
			ans1 = "Bash helmet";
			ans2 = "Crash helmet";
			ans3 = "Mash helmet";
			ans4 = "Flash helmet";
		}
		if (Question.equals(qusList[8])){
			ans1 = "Shingled";
			ans2 = "On the rocks";
			ans3 = "Pebbledashed";
			ans4 = "Stoned";
		}
		if (Question.equals(qusList[9])){
			ans1 = "Seer";
			ans2 = "Rear";
			ans3 = "Fear";
			ans4 = "Weir";
		}
		if (Question.equals(qusList[10])){
			ans1 = "Puppy love";
			ans2 = "Kitten love";
			ans3 = "Bunny love";
			ans4 = "Piggy love";
		}
		if (Question.equals(qusList[11])){
			ans1 = "Joker";
			ans2 = "Queen";
			ans3 = "Jack";
			ans4 = "Ace";
		}
		if (Question.equals(qusList[12])){
			ans1 = "The ice";
			ans2 = "The snow";
			ans3 = "The hail";
			ans4 = "The frost";
		} 
		if (Question.equals(qusList[13])){
			ans1 = "Chipmunks";
			ans2 = "Cheese";
			ans3 = "Chestnuts";
			ans4 = "Chopsticks";
		}
		if (Question.equals(qusList[14])){
			ans1 = "Crossword";
			ans2 = "Madword";
			ans3 = "Angryword";
			ans4 = "Snappyword";
		}
		if (Question.equals(qusList[15])){
			ans1 = "Card game";
			ans2 = "Cheese";
			ans3 = "Very thick hedge";
			ans4 = "Thatched roof";
		}
		if (Question.equals(qusList[16])){
			ans1 = "Posh Spice";
			ans2 = "Scary Spice";
			ans3 = "Baby Spice";
			ans4 = "Old Spice";
		}
		if (Question.equals(qusList[17])){
			ans1 = "Witness";
			ans2 = "Culprit";
			ans3 = "Suspect";
			ans4 = "Victim";
		}
		if (Question.equals(qusList[18])){
			ans1 = "Magic wand";
			ans2 = "Food blender";
			ans3 = "Garden spade";
			ans4 = "Paint roller";
		}
		if (Question.equals(qusList[19])){
			ans1 = "Gangbuster";
			ans2 = "Filibuster";
			ans3 = "Blockbuster";
			ans4 = "Dambuster";
		} 
		if (Question.equals(qusList[20])){
			ans1 = "Muddle";
			ans2 = "Muggle";
			ans3 = "Muzzle";
			ans4 = "Muffle";
	
		}
		if (Question.equals(qusList[21])){
			ans1 = "Diamond";
			ans2 = "Gold";
			ans3 = "Silver";
			ans4 = "Ivory";
		} 
		if (Question.equals(qusList[22])){
			ans1 = "Fill";
			ans2 = "Spill";
			ans3 = "Boil";
			ans4 = "Empty";
		}
		if (Question.equals(qusList[23])){
			ans1 = "Monk";
			ans2 = "Dame";
			ans3 = "Little boy";
			ans4 = "Master";
		}
		if (Question.equals(qusList[24])){
			ans1 = "Locating Remo";
			ans2 = "Discovering Lemo";
			ans3 = "Unearthing Zemo";
			ans4 = "Finding Nemo";
		}
		if (Question.equals(qusList[25])){
			ans1 = "Barry Blue";
			ans2 = "Barry Black";
			ans3 = "Barry White";
			ans4 = "Barry Green";
		} 
		if (Question.equals(qusList[26])){
			ans1 = "Britney Spears";
			ans2 = "Justin Timberlake";
			ans3 = "Gareth Gates";
			ans4 = "Victoria Beckham";
		}
		if (Question.equals(qusList[27])){
			ans1 = "Aswad";
			ans2 = "The Pogues";
			ans3 = "Clannad";
			ans4 = "Scritti Politti";
		} 
		if (Question.equals(qusList[28])){
			ans1 = "Pneumonics";
			ans2 = "Histrionics";
			ans3 = "Dynamics";
			ans4 = "Ceramics";
		}
		if (Question.equals(qusList[29])){
			ans1 = "Bilberrys";
			ans2 = "Blackberrys";
			ans3 = "Wilburys";
			ans4 = "Strawberries";
		}
		if (Question.equals(qusList[30])){
			ans1 = "Destroyer bird";
			ans2 = "Cruiser bird";
			ans3 = "Frigate bird";
			ans4 = "Corvette bird";
		} 
		if (Question.equals(qusList[31])){
			ans1 = "Harry the Holy";
			ans2 = "Al Omnipotent";
			ans3 = "Gordon Plays God";
			ans4 = "Bruce Almighty";
		}
		if (Question.equals(qusList[32])){
			ans1 = "Elton John";
			ans2 = "Billy Bob Thornton";
			ans3 = "Cher";
			ans4 = "Zsa Zsa Gabor";
		}
		if (Question.equals(qusList[33])){
			ans1 = "Fairway Hill";
			ans2 = "Green Hill";
			ans3 = "Bunker Hill";
			ans4 = "Rough Hill";
		} 
		if (Question.equals(qusList[34])){
			ans1 = "Thomas";
			ans2 = "Barry";
			ans3 = "Gareth";
			ans4 = "Alun";
		}
		if (Question.equals(qusList[35])){
			ans1 = "Devon";
			ans2 = "Cornwall";
			ans3 = "Somerset";
			ans4 = "Dorset";
		}
		if (Question.equals(qusList[36])){
			ans1 = "Eat it";
			ans2 = "Wear it";
			ans3 = "Drink it";
			ans4 = "Sing it";
		} 
		if (Question.equals(qusList[37])){
			ans1 = "Horse racing";
			ans2 = "Judo";
			ans3 = "Weightlifting";
			ans4 = "Croquet";
		}
		if (Question.equals(qusList[38])){
			ans1 = "James I";
			ans2 = "Lord Protector";
			ans3 = "James II";
			ans4 = "Young Pretender";
		}
		if (Question.equals(qusList[39])){
			ans1 = "Atacama Desert";
			ans2 = "Gobi Desert";
			ans3 = "Sahara Desert";
			ans4 = "Mojave Desert";
		} 
		if (Question.equals(qusList[40])){
			ans1 = "Nebraska";
			ans2 = "Iowa";
			ans3 = "Montana";
			ans4 = "Idaho";
		}
		if (Question.equals(qusList[41])){
			ans1 = "Arizona";
			ans2 = "Kansas";
			ans3 = "Texas";
			ans4 = "Colorado";
		}
		if (Question.equals(qusList[42])){
			ans1 = "Basketball";
			ans2 = "Badminton";
			ans3 = "Volleyball";
			ans4 = "Curling";
		} 
		if (Question.equals(qusList[43])){
			ans1 = "Referee";
			ans2 = "Code of practice";
			ans3 = "Champion";
			ans4 = "Ring";
		}
		if (Question.equals(qusList[44])){
			ans1 = "Ice hockey";
			ans2 = "Gaelic football";
			ans3 = "Curling";
			ans4 = "Bowls";
		}
		if (Question.equals(qusList[45])){
			ans1 = "Cyclades";
			ans2 = "Dodecanese";
			ans3 = "Ionian";
			ans4 = "Sporades";
		}
		if (Question.equals(qusList[46])){
			ans1 = "Venice";
			ans2 = "London";
			ans3 = "Berlin";
			ans4 = "Cannes";
		}
		if (Question.equals(qusList[47])){
			ans1 = "Sutherland";
			ans2 = "Somerset";
			ans3 = "Northumberland";
			ans4 = "Norfolk";
		}



		options[0] = ans1;
		options[1] = ans2;
		options[2] = ans3;
		options[3] = ans4;

		return options;
	}

}

