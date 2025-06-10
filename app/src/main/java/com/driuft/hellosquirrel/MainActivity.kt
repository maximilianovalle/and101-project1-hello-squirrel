package com.driuft.hellosquirrel

import android.os.Build
import android.os.Bundle
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.content.res.AppCompatResources

// defines main screen shown when app launches
class MainActivity : AppCompatActivity() {

    // will point to elements in layout, "lateinit" means will be initialized later before use
    private lateinit var profileImage: ImageView
    private lateinit var profileName: TextView
    private lateinit var profileBio: TextView

    // called when activity starts
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configureViews()
        setupProfile()
    }

    // finds ui elements and binds to previously created elements
    private fun configureViews() {
        profileImage = findViewById(R.id.profile_image)
        profileName = findViewById(R.id.profile_name)
        profileBio = findViewById(R.id.profile_bio)
    }

    // calls helper methods
    private fun setupProfile() {
        configureImage()
        configureName()
    }

    // loads drawable and sets it as image for ImageView
    private fun configureImage() {
        // R.drawable.[res/drawable/filename]
        profileImage.setImageDrawable(AppCompatResources.getDrawable(this, R.drawable.avatar_10))
    }

    // gets strings from res/values/strings.xml
    private fun configureName() {
        profileName.text = getString(
            R.string.full_name,
            getString(R.string.first_name),
            getString(R.string.last_name)
        )
    }
}