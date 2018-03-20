package vhp.com.jokeassemble

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*
import vhp.com.displayjoke.DisplayJokeActivity
import vhp.com.jokelib.JokeProducer

class MainActivity : AppCompatActivity() {

    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialise the admob sdk
        MobileAds.initialize(this, resources.getString(R.string.key_admob))

        // setting up the AdView to show the ad
        mAdView = this.findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        // display joke button button listener
        button_display_joke.setOnClickListener(){
            //initialize the JokeProducer class from java library
            val mjokeProducer = JokeProducer()
            // launch the displayjoke library activity to display the joke and
            // send the joke as extras
            val displayJokeIntent = Intent(this , DisplayJokeActivity::class.java)
            displayJokeIntent.putExtra("joke" , mjokeProducer.mosesJoke)
            startActivity(displayJokeIntent)
            // show the toast to display the  joke from JavaLibrary
            Toast.makeText(this , mjokeProducer.mosesJoke , Toast.LENGTH_LONG).show()
        }

    }
}
