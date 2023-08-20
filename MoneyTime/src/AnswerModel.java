public class AnswerModel {
    private final String ansTxt;
    private final int accuracy;

    public AnswerModel(String ansTxt, int accuracy) {
        this.ansTxt = ansTxt;
        this.accuracy = accuracy;
    }

    public String getAnsTxt() {
        return ansTxt;
    }

    public int getAccuracy() {
        return accuracy;
    }
}
