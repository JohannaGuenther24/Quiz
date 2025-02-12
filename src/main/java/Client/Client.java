package Client;

import Classes.Question;
import Services.QuestionService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void startGame() {
        Random random = new Random();
        int randomValueAnswer;
        Scanner sc = new Scanner(System.in);
        List<Question> questions = new ArrayList<>();
        List<String> answers = new ArrayList<>();
        int max;
        int counterQuestion = 1;
        int maxQuestions = 0;
        boolean check = false;
        String answerOne;
        String answerTwo;
        String answerThree;
        String answerFour;

        while (!check) {
            System.out.println("""
                    Welchen Schwierigkeitsgrad möchtest du spielen?
                    1 - Leicht
                    2 - Mittel
                    3 - Schwer
                    0 - Gemischte Fragen
                    """);

            int answer = sc.nextInt();

            if (answer > 0 && answer <= 3) {
                questions = QuestionService.getAllQuestionsByDifficultyId(answer);
                maxQuestions = QuestionService.getAllQuestionsByDifficultyId(answer).size();
                check = true;
            } else if (answer == 0) {
                questions = QuestionService.getAllQuestions();
                maxQuestions = QuestionService.getAllQuestions().size();
                check = true;
            } else {
                System.out.println("Error: Falsche Eingabe!");
            }
        }


        while (counterQuestion <= maxQuestions) {
            max = questions.size();
            int randomValueQuestion = random.nextInt(0, max);
            Question question = questions.get(randomValueQuestion);

            answers.add(question.getCorrectAnswer());
            answers.add(question.getWrongAnswerA());
            answers.add(question.getWrongAnswerB());
            answers.add(question.getWrongAnswerC());

            System.out.println("Frage: " + question.getQuestion());

            randomValueAnswer = random.nextInt(0, 4);
            answerOne = answers.get(randomValueAnswer);
            answers.remove(randomValueAnswer);
            randomValueAnswer = random.nextInt(0, 3);
            answerTwo = answers.get(randomValueAnswer);
            answers.remove(randomValueAnswer);
            randomValueAnswer = random.nextInt(0, 2);
            answerThree = answers.get(randomValueAnswer);
            answers.remove(randomValueAnswer);
            randomValueAnswer = random.nextInt(0, 1);
            answerFour = answers.get(randomValueAnswer);

            answers.clear();


            System.out.println("A: " + answerOne +
                    "\nB: " + answerTwo +
                    "\nC: " + answerThree +
                    "\nD: " + answerFour +
                    "\nWaehle A, B, C oder D");

            String choose = sc.next();

            switch (choose.toUpperCase()) {
                case "A":
                    evaluation(answerOne, question.getCorrectAnswer());
                    break;
                case "B":
                    evaluation(answerTwo, question.getCorrectAnswer());
                    break;
                case "C":
                    evaluation(answerThree, question.getCorrectAnswer());
                    break;
                case "D":
                    evaluation(answerFour, question.getCorrectAnswer());
                    break;
            }


            questions.remove(randomValueQuestion);
            counterQuestion++;
        }

    }

    public static void evaluation(String input, String correctAnswer) {
        String red = "\u001B[31m";
        String reset = "\u001B[0m";
        String green = "\u001B[35m";

        if (input.equals(correctAnswer)) {
            System.out.println(green + "Richtig!" + reset);
        } else {
            System.out.println(red + "Falsch!" + reset);
        }
    }
}
