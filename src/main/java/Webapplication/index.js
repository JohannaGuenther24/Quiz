async function loadAllQuestions() {
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    const response = await fetch("http://localhost:8080/Questions", requestOptions);
    const body = await response.json();
    return body;
}


const QUESTIONS = [];
let correctAnswer;

async function start() {
    const questions = await loadAllQuestions();
    QUESTIONS.push(...questions);
    showNextQuestion();
    console.log("Started successfully");
}

function showNextQuestion(){
    const question = QUESTIONS.shift();
    document.getElementById("nextQuestionButton").disabled = true;
    correctAnswer = "A";
    document.getElementById("outputA").innerHTML = question.correctAnswer;
    document.getElementById("outputB").innerHTML = question.wrongAnswerA;
    document.getElementById("outputC").innerHTML = question.wrongAnswerB;
    document.getElementById("outputD").innerHTML = question.wrongAnswerC;
    document.getElementById("outputFrage").innerHTML = question.question;
}

function selectAnswer(answer) {
    if (answer === correctAnswer){
        document.getElementById("Loesung").innerHTML = "Richtig!"
    } else {
        document.getElementById("Loesung").innerHTML = "Falsch!"
    }
    document.getElementById("nextQuestionButton").disabled = false;
}

window.onload = start;

