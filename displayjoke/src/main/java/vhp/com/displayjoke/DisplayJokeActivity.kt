package vhp.com.displayjoke

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_display_joke.*

class DisplayJokeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_joke)

        /* get the info from intent */
        var jokeToDisplay  = intent.getStringExtra("joke")
        /* display the joke in textview */
        textView_display_joke.text = jokeToDisplay
    }
}
