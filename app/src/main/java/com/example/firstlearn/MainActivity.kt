package com.example.firstlearn

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    
    lateinit var textView : TextView
    //some transient state for the activity instance
    var gameState : String? = null

    override fun onCreate(savedInstanceState : Bundle?) {

        //call the superclass onCreate to complete the creation of activity like the view hierarchy
        super.onCreate(savedInstanceState)

        //recovering the instance state
        gameState = savedInstanceState?.getString(GAME_STATE_KEY)

        //set the user interface layout for this activity
        setContentView(R.layout.activity_main)

        //initialize member TextView so we can manipulate it later
        textView = findViewById(R.id.text_view)

    }

    //This callback is called only when there is a saved instance that is previously saved by using
    //onSaveInstanceState(). We restore other state here, possible usable after onStart() has completed
    //The savedInstanceState Bundle is the same as the one used in onCreate()
    override fun onRestoreInstanceState(savedInstanceState: Bundle?){

        textView.text = savedInstanceState?.getString(TEXT_VIEW_KEY)
    }

    //invoked when the activity may be temporarily destroyed, save the instance state here
    override fun onSaveInstanceState(outState:Bundle?){
        outState?.run{
            putString(GAME_STATE_KEY,gameState)
            putString(TEXT_VIEW_KEY,gameState)

        }

        //call superclass to save any view hierachy
        super.onSaveInstanceState(outState)
    }
}