package Classes;

import jakarta.persistence.*;

@Entity
@Table(name="Question")
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="QuestionId")
    private int questionId;
    @Column(name="DifficultyId")
    private int difficultyId;
    @Column(name="Question")
    private String question;
    @Column(name="CorrectAnswer")
    private String correctAnswer;
    @Column(name="WrongAnswerA")
    private String wrongAnswerA;
    @Column(name="WrongAnswerB")
    private String wrongAnswerB;
    @Column(name="WrongAnswerC")
    private String wrongAnswerC;

    public Question(){

    }

    public Question(int questionId, int difficultyId, String question, String correctAnswer, String wrongAnswerA, String wrongAnswerB, String wrongAnswerC){
        this.questionId = questionId;
        this.difficultyId = difficultyId;
        this.question = question;
        this.correctAnswer = correctAnswer;
        this.wrongAnswerA = wrongAnswerA;
        this.wrongAnswerB = wrongAnswerB;
        this.wrongAnswerC = wrongAnswerC;
    }

    public int getQuestionId() {
        return questionId;
    }

    public int getDifficultyId() {
        return difficultyId;
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getWrongAnswerA() {
        return wrongAnswerA;
    }

    public String getWrongAnswerB() {
        return wrongAnswerB;
    }

    public String getWrongAnswerC() {
        return wrongAnswerC;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setDifficultyId(int difficultyId) {
        this.difficultyId = difficultyId;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setWrongAnswerA(String wrongAnswerA) {
        this.wrongAnswerA = wrongAnswerA;
    }

    public void setWrongAnswerB(String wrongAnswerB) {
        this.wrongAnswerB = wrongAnswerB;
    }

    public void setWrongAnswerC(String wrongAnswerC) {
        this.wrongAnswerC = wrongAnswerC;
    }
}
