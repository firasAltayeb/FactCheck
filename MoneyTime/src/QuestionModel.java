import java.util.List;

public class QuestionModel {
    private final List<AnswerModel> ansList;
    private final String qusTxt;

    public QuestionModel(String qusTxt, List<AnswerModel> ansList) {
        this.qusTxt = qusTxt;
        this.ansList = ansList;
    }

    public List<AnswerModel> getAnsList() {
        return ansList;
    }

    public AnswerModel getCorrectAnswer() {
        AnswerModel correctAnswer = null;
        for (AnswerModel answer : ansList) {
            if (answer.getAccuracy() ==1) {
                correctAnswer = answer;
                break;
            }
        }
        return correctAnswer;
    }

    public String getQusTxt() {
        return qusTxt;
    }
}
