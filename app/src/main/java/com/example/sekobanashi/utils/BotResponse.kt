package com.example.sekobanashi.utils


import com.example.sekobanashi.utils.Constants.OPEN_GALLERY
import com.example.sekobanashi.utils.Constants.OPEN_GOOGLE
import com.example.sekobanashi.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {
            //Open Google
            message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            message.contains("gallery")-> {
                OPEN_GALLERY
            }

            //Flips a coin
            message.contains("flip") && message.contains("coin") -> {
                val r = (0..1).random()
                val result = if (r == 0) "heads" else "tails"

                "I flipped a coin and it landed on $result"
            }

            //Math calculations
            message.contains("solve")-> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Sorry, I can't solve that."
                }
            }

            message.contains("commands") -> {
                ">I love you and your  greetings!!\nSo pweez do not forget  to greet me senpai  whenever we are starting  a chat or whether you  are leaving OwO\n>I can 'search' for  anything through google  or open 'google' and use  its functionalities\n>I can open your 'gallery'\n>I can play a 'game' or tell  a 'joke'\n>I can tell you what 'time'  or 'date' it is\n>I can 'solve' basic arithmetic  problems\n>I can 'flip a coin'\n>I am also learning many  new things OwO"
            }

            message.contains(" joke") -> {
                when (random) {
                    0 -> "What is sticky and brown? A stick!"
                    1 -> "I hate Russian dolls… they're so full of themselves!"
                    2 -> "What did one plate say to his friend? Tonight, dinner's on me!"
                    else -> "error" }
            }

            message.contains(" game")  -> {
                "Playing rock, paper, scissors\nI have chosen what to pull OwO\nNow you choose as :\npull 'Your Choice'"
            }

            message.contains("pull rock") ||  message.contains("pull paper") || message.contains("pull scissors") -> {
                when (random) {
                    0 -> "I chose rock!"
                    1 -> "I chose scissors!"
                    2 -> "I chose paper!"
                    else -> "error"
                }
            }

            //How are you?
            message.contains(" are you")-> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I am feeling happy to be able to talk with you senpai !"
                    2 -> " I am Pretty good! How about you?"
                    else -> "error"
                }
            }

            message.contains("bye") || message.contains("see you")-> {
                when (random) {
                    0 -> "awww! bye"
                    1 -> "See you again senpai !"
                    2 -> "Sayonara!"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time")|| message.contains("date")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy || HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }


            //Hello
            message.contains("hello") || message.contains("greetings")  -> {
                when (random) {
                    0 -> "Moshi Moshi!"
                    1 -> "Hajimemashite!"
                    2 -> "Konnichiwa!"
                    else -> "error" }
            }



            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different senpai uwu .."
                    2 -> "Idk"
                    else -> "error"
                }
            }
        }
    }
}