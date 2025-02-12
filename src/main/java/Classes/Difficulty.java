package Classes;

import jakarta.persistence.*;

@Entity
@Table(name="Difficulty")
public class Difficulty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DifficultyId")
    private int difficultyId;
    @Column(name="Difficulty")
    private String difficulty;

    public Difficulty(){

    }

    public int getDifficultyId() {
        return difficultyId;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficultyId(int difficultyId) {
        this.difficultyId = difficultyId;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
