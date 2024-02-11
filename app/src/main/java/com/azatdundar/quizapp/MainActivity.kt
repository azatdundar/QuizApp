package com.azatdundar.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.azatdundar.quizapp.databinding.ActivityMainBinding

class Question(var question: String, var answer : Button,var premierAnswer:String, var secondAnswer:String){

}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var problemText : TextView
    private lateinit var currQuestion: Question
    private lateinit var questionList : ArrayList<Question>
    private var questionIndex = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        problemText = binding.problemText
        val view = binding.root
        setContentView(view)

        var question1 = Question(
            "Who wrote Romeo and Juliet?",
            binding.answer2,
            "Jane Austen",
            "William Shakespeare"
        )

        var question2 = Question(
            "What is the capital of France?",
            binding.answer2,
            "Berlin",
            "Paris"
        )

        var question3 = Question(
            "Which planet is known as the Red Planet?",
            binding.answer1,
            "Mars",
            "Venus"
        )

        var question4 = Question(
            "Who painted the Mona Lisa?",
            binding.answer2,
            "Vincent van Gogh",
            "Leonardo da Vinci?"
        )

        var question5 = Question(
            "What is the largest mammal in the world?",
            binding.answer2,
            "Elephant",
            "Blue whale"
        )

        var question6 = Question(
            "Who is known as the father of modern physics?",
            binding.answer2,
            "Isaac Newton",
            "Albert Einstein"
        )

        var question7 = Question(
            "What is the currency of Japan?",
            binding.answer1,
            "Yen",
            "Won"
        )

        var question8 = Question(
            "What is the tallest mountain in the world?",
            binding.answer2,
            "K2",
            "Mount Everest"
        )
        questionList = ArrayList<Question>()

        questionList.add(question1)
        questionList.add(question2)
        questionList.add(question3)
        questionList.add(question4)
        questionList.add(question5)
        questionList.add(question6)
        questionList.add(question7)
        questionList.add(question8)

        currQuestion = questionList[questionIndex]
        problemText.text = currQuestion.question
        binding.answer1.text = currQuestion.premierAnswer
        binding.answer2.text = currQuestion.secondAnswer
        binding.prewQuestion.isEnabled = false

    }

    fun control1(view: View){
        //trueFalse1()
        if(currQuestion.answer == binding.answer1){
            Toast.makeText(this, "Your answer is correct", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Your answer is wrong",Toast.LENGTH_SHORT).show()
        }
    }

    fun control2(view: View){
        if(currQuestion.answer == binding.answer2){
            Toast.makeText(this, "Your answer is correct", Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this, "Your answer is wrong", Toast.LENGTH_SHORT).show()
        }
    }

    fun toPrew(view : View){
        currQuestion = questionList[questionIndex-1]
        problemText.text = currQuestion.question
        binding.answer1.text = currQuestion.premierAnswer
        binding.answer2.text = currQuestion.secondAnswer
        questionIndex--
        binding.nextQuestion.isEnabled = true
        if(questionIndex==0){
            binding.prewQuestion.isEnabled = false
        }
        else{
            binding.prewQuestion.isEnabled = true
        }
    }

    fun toNext(view: View){
        currQuestion = questionList[questionIndex+1]
        problemText.text = currQuestion.question
        binding.answer1.text = currQuestion.premierAnswer
        binding.answer2.text = currQuestion.secondAnswer
        questionIndex++
        binding.prewQuestion.isEnabled = true
        if(questionIndex == questionList.size -1 ){
            binding.nextQuestion.isEnabled = false
        }
        else{
            binding.nextQuestion.isEnabled = true
        }
    }


}