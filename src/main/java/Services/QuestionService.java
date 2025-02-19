package Services;

import Classes.Question;
import jakarta.annotation.PreDestroy;
import org.hibernate.Session;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Questions")
@CrossOrigin(origins = "*", maxAge = 3600)
public class QuestionService {

    QuestionService() {
    }

    static Session session = Connection.openSession();

    @GetMapping
    public static List<Question> getAllQuestions() {
        List<Question> liste;
        liste = session.createQuery("from Question", Question.class).list();
        return liste;
    }

    @GetMapping("/Difficulty/{id}")
    public static List<Question> getAllQuestionsByDifficultyId(@PathVariable(value = "id") int difficultyId) {
        List<Question> liste;
        liste = session.createQuery("from Question WHERE difficultyId = :difficultyId", Question.class)
                .setParameter("difficultyId", difficultyId)
                .list();
        return liste;
    }

    @GetMapping("/{id}")
    public static Question getQuestionById(@PathVariable(value = "id") int id) {
        return session.createQuery("from Question WHERE questionId = :id", Question.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @PreDestroy
    public void closeSession() {
        if (session != null && session.isOpen()) {
            Connection.disconnect(session);
        }
    }
}
