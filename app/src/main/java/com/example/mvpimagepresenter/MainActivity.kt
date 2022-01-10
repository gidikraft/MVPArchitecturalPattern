package com.example.mvpimagepresenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.mvpimagepresenter.models.Model
import com.example.mvpimagepresenter.presenter.Contract
import com.example.mvpimagepresenter.presenter.Presenter
import java.util.*

class MainActivity : AppCompatActivity(), Contract.View {
//    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var imageView: ImageView

    private var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        imageView = findViewById(R.id.imageView)

        // instantiating object of Presenter Interface
        presenter = Presenter(this, Model())

        this.button.setOnClickListener { presenter!!.onButtonClick() }
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter!!.onDestroy()
    }

    // method to display the Course Detail TextView
    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        imageView.visibility = View.INVISIBLE
    }

    // method to hide the Course Detail TextView
    override fun hideProgress() {
        progressBar.visibility = View.GONE
        imageView.visibility = View.VISIBLE
    }

    // method to set random string
    // in the Course Detail TextView
//    override fun setString(string: String?) {
//        textView.text = string
//    }

    override fun setImage(string: String?) {
        Glide.with(this)
            .load(string)
            .into(imageView)
    }


}