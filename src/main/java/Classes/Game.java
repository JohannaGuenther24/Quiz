package Classes;

import jakarta.persistence.*;

@Entity
@Table(name="Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="GameId")
    private int gameId;
    @Column(name="DifficultyId")
    private int difficultyId;
    @Column(name="Score")
    private int score;
    @Column(name="CorrectAnswers")
    private int CounterCorrectAnswers;
    @Column(name="WrongAnswers")
    private int CounterWrongAnswers;


    public Game(){

    }

    Game(int difficultyId){
        this.difficultyId = difficultyId;
    }


    public int getGameId() {
        return gameId;
    }

    public int getDifficultyId() {
        return difficultyId;
    }

    public int getScore() {
        return score;
    }

    public int getCorrectAnswers() {
        return CounterCorrectAnswers;
    }

    public int getWrongAnswers() {
        return CounterWrongAnswers;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setDifficultyId(int difficultyId) {
        this.difficultyId = difficultyId;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCorrectAnswers(int correctAnswers) {
        this.CounterCorrectAnswers = correctAnswers;
    }

    public void setWrongAnswers(int wrongAnswers) {
        this.CounterWrongAnswers = wrongAnswers;
    }
}
