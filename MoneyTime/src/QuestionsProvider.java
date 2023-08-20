import java.util.ArrayList;
import java.util.List;

public class QuestionsProvider {
    public static List<QuestionModel> getQuizQuestions() {
        List<QuestionModel> questions = new ArrayList<>();

        questions.add(new QuestionModel(
                "Which disease devastated livestock across the UK during 2001?",
                new ArrayList<>() {{
                    add(new AnswerModel("Hand-and-foot", 0));
                    add(new AnswerModel("Foot-in-mouth", 1));
                    add(new AnswerModel("Hand-to-mouth", 0));
                    add(new AnswerModel("Foot-and-mouth", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these kills its victims by constriction?",
                new ArrayList<>() {{
                    add(new AnswerModel("Andalucia", 0));
                    add(new AnswerModel("Anaconda", 1));
                    add(new AnswerModel("Andypandy", 0));
                    add(new AnswerModel("Annerobinson", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these might be used in underwater naval operations?",
                new ArrayList<>() {{
                    add(new AnswerModel("Frogmen", 1));
                    add(new AnswerModel("Newtmen", 0));
                    add(new AnswerModel("Protos", 0));
                    add(new AnswerModel("Lamborghini", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "A 'cuppa' is an informal term for what?",
                new ArrayList<>() {{
                    add(new AnswerModel("Policeman", 0));
                    add(new AnswerModel("Cup of tea", 1));
                    add(new AnswerModel("2p coin", 0));
                    add(new AnswerModel("Smoked herring", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "What is the meaning of the colloquial expression 'in the bag'?",
                new ArrayList<>() {{
                    add(new AnswerModel("Almost certain", 1));
                    add(new AnswerModel("Newly bought", 0));
                    add(new AnswerModel("Freshly cooked", 0));
                    add(new AnswerModel("Recently stolen", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which activity would you most associate with a mole?",
                new ArrayList<>() {{
                    add(new AnswerModel("Burrowing", 1));
                    add(new AnswerModel("Climbing", 0));
                    add(new AnswerModel("Swimming", 0));
                    add(new AnswerModel("Flying", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "What is the name of the instrument panel in a car?",
                new ArrayList<>() {{
                    add(new AnswerModel("Chargeboard", 0));
                    add(new AnswerModel("Sprintboard", 0));
                    add(new AnswerModel("Dashboard", 1));
                    add(new AnswerModel("Jogboard", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "What type of protective headgear do motorcyclists wear?",
                new ArrayList<>() {{
                    add(new AnswerModel("Bash helmet", 0));
                    add(new AnswerModel("Crash helmet", 1));
                    add(new AnswerModel("Mash helmet", 0));
                    add(new AnswerModel("Flash helmet", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these refers to an alcoholic drink served with ice?",
                new ArrayList<>() {{
                    add(new AnswerModel("Shingled", 0));
                    add(new AnswerModel("On the rocks", 1));
                    add(new AnswerModel("Pebbledashed", 0));
                    add(new AnswerModel("Stoned", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these is an obstruction built across a river?",
                new ArrayList<>() {{
                    add(new AnswerModel("Seer", 0));
                    add(new AnswerModel("Rear", 0));
                    add(new AnswerModel("Fear", 0));
                    add(new AnswerModel("Weir", 1));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these is an adolescent romantic attachment?",
                new ArrayList<>() {{
                    add(new AnswerModel("Puppy love", 1));
                    add(new AnswerModel("Kitten love", 0));
                    add(new AnswerModel("Bunny love", 0));
                    add(new AnswerModel("Piggy love", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these is a slang term for 'excellent'?",
                new ArrayList<>() {{
                    add(new AnswerModel("Joker", 0));
                    add(new AnswerModel("Queen", 0));
                    add(new AnswerModel("Jack", 0));
                    add(new AnswerModel("Ace", 1));
                }}
        ));
        questions.add(new QuestionModel(
                "What are you said to break, when you make friends with a stranger?",
                new ArrayList<>() {{
                    add(new AnswerModel("The ice", 1));
                    add(new AnswerModel("The snow", 0));
                    add(new AnswerModel("The hail", 0));
                    add(new AnswerModel("The frost", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Two very different things are said to be like 'chalk and ...'?",
                new ArrayList<>() {{
                    add(new AnswerModel("Chipmunks", 0));
                    add(new AnswerModel("Cheese", 1));
                    add(new AnswerModel("Chestnuts", 0));
                    add(new AnswerModel("Chopsticks", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these is a type of puzzle often found in newspapers?",
                new ArrayList<>() {{
                    add(new AnswerModel("Crossword", 1));
                    add(new AnswerModel("Madword", 0));
                    add(new AnswerModel("Angryword", 0));
                    add(new AnswerModel("Snappyword", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "What is Double Gloucester?",
                new ArrayList<>() {{
                    add(new AnswerModel("Card game", 0));
                    add(new AnswerModel("Cheese", 1));
                    add(new AnswerModel("Very thick hedge", 0));
                    add(new AnswerModel("Thatched roof", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these first came on the market in 1937?",
                new ArrayList<>() {{
                    add(new AnswerModel("Posh Spice", 0));
                    add(new AnswerModel("Scary Spice", 0));
                    add(new AnswerModel("Baby Spice", 0));
                    add(new AnswerModel("Old Spice", 1));
                }}
        ));
        questions.add(new QuestionModel(
                "A person who slavishly buys the latest clothes is a 'fashion ...'?",
                new ArrayList<>() {{
                    add(new AnswerModel("Witness", 0));
                    add(new AnswerModel("Culprit", 0));
                    add(new AnswerModel("Suspect", 0));
                    add(new AnswerModel("Victim", 1));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these is TV personality Jamie Oliver most likely to use?",
                new ArrayList<>() {{
                    add(new AnswerModel("Magic wand", 0));
                    add(new AnswerModel("Food blender", 1));
                    add(new AnswerModel("Garden spade", 0));
                    add(new AnswerModel("Paint roller", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which word describes a film that is a financial success?",
                new ArrayList<>() {{
                    add(new AnswerModel("Gangbuster", 0));
                    add(new AnswerModel("Filibuster", 0));
                    add(new AnswerModel("Blockbuster", 1));
                    add(new AnswerModel("Dambuster", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "What name is given to the projecting part of the face of a dog?",
                new ArrayList<>() {{
                    add(new AnswerModel("Muddle", 0));
                    add(new AnswerModel("Muggle", 0));
                    add(new AnswerModel("Muzzle", 1));
                    add(new AnswerModel("Muffle", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "If you live in seclusion, what sort of 'tower' are you said to be in?",
                new ArrayList<>() {{
                    add(new AnswerModel("Diamond", 0));
                    add(new AnswerModel("Gold", 0));
                    add(new AnswerModel("Silver", 0));
                    add(new AnswerModel("Ivory", 1));
                }}
        ));
        questions.add(new QuestionModel(
                "According to the proverb, what does a watched pot never do?",
                new ArrayList<>() {{
                    add(new AnswerModel("Fill", 0));
                    add(new AnswerModel("Spill", 0));
                    add(new AnswerModel("Boil", 1));
                    add(new AnswerModel("Empty", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Who does not receive wool from the black sheep in the nursery rhyme?",
                new ArrayList<>() {{
                    add(new AnswerModel("Monk", 1));
                    add(new AnswerModel("Dame", 0));
                    add(new AnswerModel("Little boy", 0));
                    add(new AnswerModel("Master", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these is a 2003 Disney computer-animated film?",
                new ArrayList<>() {{
                    add(new AnswerModel("Locating Remo", 0));
                    add(new AnswerModel("Discovering Lemo", 0));
                    add(new AnswerModel("Unearthing Zemo", 0));
                    add(new AnswerModel("Finding Nemo", 1));
                }}
        ));
        questions.add(new QuestionModel(
                "Which popular soul singer died aged 58, in July 2003?",
                new ArrayList<>() {{
                    add(new AnswerModel("Barry Blue", 0));
                    add(new AnswerModel("Barry Black", 0));
                    add(new AnswerModel("Barry White", 1));
                    add(new AnswerModel("Barry Green", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Who released an album called 'Justified' in 2003?",
                new ArrayList<>() {{
                    add(new AnswerModel("Britney Spears", 0));
                    add(new AnswerModel("Justin Timberlake", 1));
                    add(new AnswerModel("Gareth Gates", 0));
                    add(new AnswerModel("Victoria Beckham", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "The name of which group is Gaelic for 'family'?",
                new ArrayList<>() {{
                    add(new AnswerModel("Aswad", 0));
                    add(new AnswerModel("The Pogues", 0));
                    add(new AnswerModel("Clannad", 1));
                    add(new AnswerModel("Scritti Politti", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "In music, which symbols indicate relative loudness?",
                new ArrayList<>() {{
                    add(new AnswerModel("Pneumonics", 0));
                    add(new AnswerModel("Histrionics", 0));
                    add(new AnswerModel("Dynamics", 1));
                    add(new AnswerModel("Ceramics", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Complete the name of the band, the Travelling ...?",
                new ArrayList<>() {{
                    add(new AnswerModel("Bilberrys", 0));
                    add(new AnswerModel("Blackberrys", 0));
                    add(new AnswerModel("Wilburys", 1));
                    add(new AnswerModel("Strawberries", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which is a seabird with a deeply forked tail?",
                new ArrayList<>() {{
                    add(new AnswerModel("Destroyer bird", 0));
                    add(new AnswerModel("Cruiser bird", 0));
                    add(new AnswerModel("Frigate bird", 1));
                    add(new AnswerModel("Corvette bird", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "In which 2003 film is Jim Carrey granted divine powers by God?",
                new ArrayList<>() {{
                    add(new AnswerModel("Harry the Holy", 0));
                    add(new AnswerModel("Al Omnipotent", 0));
                    add(new AnswerModel("Gordon Plays God", 0));
                    add(new AnswerModel("Bruce Almighty", 1));
                }}
        ));
        questions.add(new QuestionModel(
                "Who asked 'Are You Ready for Love?' in the title of a 2003 hit?",
                new ArrayList<>() {{
                    add(new AnswerModel("Elton John", 1));
                    add(new AnswerModel("Billy Bob Thornton", 0));
                    add(new AnswerModel("Cher", 0));
                    add(new AnswerModel("Zsa Zsa Gabor", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which was a battle in the American War of Independence?",
                new ArrayList<>() {{
                    add(new AnswerModel("Fairway Hill", 0));
                    add(new AnswerModel("Green Hill", 0));
                    add(new AnswerModel("Bunker Hill", 1));
                    add(new AnswerModel("Rough Hill", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "In which town are the administrative headquarters of the Vale of Glamorgan?",
                new ArrayList<>() {{
                    add(new AnswerModel("Thomas", 0));
                    add(new AnswerModel("Barry", 1));
                    add(new AnswerModel("Gareth", 0));
                    add(new AnswerModel("Alun", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "In which English county is the town of St Austell?",
                new ArrayList<>() {{
                    add(new AnswerModel("Devon", 0));
                    add(new AnswerModel("Cornwall", 1));
                    add(new AnswerModel("Somerset", 0));
                    add(new AnswerModel("Dorset", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "What would you normally do with a mai tai?",
                new ArrayList<>() {{
                    add(new AnswerModel("Eat it", 0));
                    add(new AnswerModel("Wear it", 0));
                    add(new AnswerModel("Drink it", 1));
                    add(new AnswerModel("Sing it", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "In which sport does red weigh 25 kg and yellow weigh 15 kg?",
                new ArrayList<>() {{
                    add(new AnswerModel("Horse racing", 0));
                    add(new AnswerModel("Judo", 0));
                    add(new AnswerModel("Weightlifting", 1));
                    add(new AnswerModel("Croquet", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "How was James VII of Scotland known in England?",
                new ArrayList<>() {{
                    add(new AnswerModel("James I", 0));
                    add(new AnswerModel("Lord Protector", 0));
                    add(new AnswerModel("James II", 1));
                    add(new AnswerModel("Young Pretender", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which of these deserts is in the USA?",
                new ArrayList<>() {{
                    add(new AnswerModel("Atacama Desert", 0));
                    add(new AnswerModel("Gobi Desert", 0));
                    add(new AnswerModel("Sahara Desert", 0));
                    add(new AnswerModel("Mojave Desert", 1));
                }}
        ));
        questions.add(new QuestionModel(
                "Of which US state is Des Moines the capital?",
                new ArrayList<>() {{
                    add(new AnswerModel("Nebraska", 0));
                    add(new AnswerModel("Iowa", 1));
                    add(new AnswerModel("Montana", 0));
                    add(new AnswerModel("Idaho", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "In which US state is the city of Tucson?",
                new ArrayList<>() {{
                    add(new AnswerModel("Arizona", 1));
                    add(new AnswerModel("Kansas", 0));
                    add(new AnswerModel("Texas", 0));
                    add(new AnswerModel("Colorado", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which sport was originally called 'mintonette'?",
                new ArrayList<>() {{
                    add(new AnswerModel("Basketball", 0));
                    add(new AnswerModel("Badminton", 0));
                    add(new AnswerModel("Volleyball", 1));
                    add(new AnswerModel("Curling", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "In sumo wrestling, what is the dohyo?",
                new ArrayList<>() {{
                    add(new AnswerModel("Referee", 0));
                    add(new AnswerModel("Code of practice", 0));
                    add(new AnswerModel("Champion", 0));
                    add(new AnswerModel("Ring", 1));
                }}
        ));
        questions.add(new QuestionModel(
                "In which sport is the Sam Maguire Cup annually contested?",
                new ArrayList<>() {{
                    add(new AnswerModel("Ice hockey", 0));
                    add(new AnswerModel("Gaelic football", 1));
                    add(new AnswerModel("Curling", 0));
                    add(new AnswerModel("Bowls", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "To which group of Greek islands does Kalymnos belong?",
                new ArrayList<>() {{
                    add(new AnswerModel("Cyclades", 0));
                    add(new AnswerModel("Dodecanese", 1));
                    add(new AnswerModel("Ionian", 0));
                    add(new AnswerModel("Sporades", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Which film festival celebrated its 60th anniversary in 2003?",
                new ArrayList<>() {{
                    add(new AnswerModel("Venice", 1));
                    add(new AnswerModel("London", 0));
                    add(new AnswerModel("Berlin", 0));
                    add(new AnswerModel("Cannes", 0));
                }}
        ));
        questions.add(new QuestionModel(
                "Alnwick Castle is the stately home of the Dukes of where?",
                new ArrayList<>() {{
                    add(new AnswerModel("Sutherland", 0));
                    add(new AnswerModel("Somerset", 0));
                    add(new AnswerModel("Northumberland", 1));
                    add(new AnswerModel("Norfolk", 0));
                }}
        ));

        return questions;
    }
}
