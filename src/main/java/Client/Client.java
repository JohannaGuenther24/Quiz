package Client;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Client {
    public static void startGame() throws IOException, InterruptedException {
        Random random = new Random();
        int randomValueAnswer;
        Scanner sc = new Scanner(System.in);
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject;
        List<String> answers = new ArrayList<>();
        int max;
        int counterQuestion = 1;
        int maxQuestions = 0;
        boolean check = false;
        String answerOne;
        String answerTwo;
        String answerThree;
        String answerFour;
        Requests requests = new Requests();

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
                jsonArray = requests.getQuestionByDiffucultyId(answer);
                maxQuestions = jsonArray.length();
                check = true;
            } else if (answer == 0) {
                jsonArray = requests.getQuestions();
                maxQuestions = jsonArray.length();
                check = true;
            } else {
                System.out.println("Error: Falsche Eingabe!");
            }
        }



        while (counterQuestion <= maxQuestions) {

            max = jsonArray.length();
            int randomValueQuestion = random.nextInt(0, max);
            jsonObject = jsonArray.getJSONObject(randomValueQuestion);

            answers.add(jsonObject.getString("correctAnswer"));
            answers.add(jsonObject.getString("wrongAnswerA"));
            answers.add(jsonObject.getString("wrongAnswerB"));
            answers.add(jsonObject.getString("wrongAnswerC"));

            System.out.println("Frage: " + jsonObject.getString("question"));

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
                    evaluation(answerOne, jsonObject.getString("correctAnswer"));
                    break;
                case "B":
                    evaluation(answerTwo, jsonObject.getString("correctAnswer"));
                    break;
                case "C":
                    evaluation(answerThree, jsonObject.getString("correctAnswer"));
                    break;
                case "D":
                    evaluation(answerFour, jsonObject.getString("correctAnswer"));
                    break;
            }
            jsonArray.remove(randomValueQuestion);
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
