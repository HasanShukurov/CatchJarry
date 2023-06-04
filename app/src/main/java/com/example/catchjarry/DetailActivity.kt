package com.example.catchjarry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.catchjarry.databinding.ActivityDetailBinding
import kotlin.random.Random

class DetailActivity : AppCompatActivity() {

    var runnable = Runnable {  }
    var handler = Handler()
    var imageArray = ArrayList<ImageView>()
    var score = 0

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        imageArray.add(binding.imageView1)
        imageArray.add(binding.imageView2)
        imageArray.add(binding.imageView3)
        imageArray.add(binding.imageView4)
        imageArray.add(binding.imageView5)
        imageArray.add(binding.imageView6)
        imageArray.add(binding.imageView7)
        imageArray.add(binding.imageView8)
        imageArray.add(binding.imageView9)
        imageArray.add(binding.imageView10)
        imageArray.add(binding.imageView11)
        imageArray.add(binding.imageView12)
        imageArray.add(binding.imageView13)
        imageArray.add(binding.imageView14)
        imageArray.add(binding.imageView15)
        imageArray.add(binding.imageView16)
        imageArray.add(binding.imageView17)
        imageArray.add(binding.imageView18)
        imageArray.add(binding.imageView19)
        imageArray.add(binding.imageView20)
        imageArray.add(binding.imageView21)
        imageArray.add(binding.imageView22)
        imageArray.add(binding.imageView23)
        imageArray.add(binding.imageView24)


        hideImages()


        // Count Down Timer

        object : CountDownTimer(30800,1000) {
            override fun onTick(p0: Long) {
                binding.timeText.text = "Time:" + p0/1000
            }

            override fun onFinish() {

                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                binding.timeText.text = "Time: 0"
                binding.scoreText.text = "Score: 0"

                handler.removeCallbacks(runnable)

                val alert = AlertDialog.Builder(this@DetailActivity)
                alert.setTitle("Game Over")
                alert.setMessage("Restart The Game")
                alert.setPositiveButton("Yes") {dialog, which ->
                    val intent = intent
                    finish()
                    startActivity(intent)
                }
                alert.setNegativeButton("No") {dialog, which ->
                    Toast.makeText(this@DetailActivity,"Game Over", Toast.LENGTH_LONG).show()

                    val intent = Intent(this@DetailActivity,MainActivity:: class.java)
                    startActivity(intent)
                }
                alert.show()
            }

        }.start()

    }

    fun hideImages () {

        runnable = object : Runnable {
            override fun run() {
                for (image in imageArray) {
                    image.visibility = View.INVISIBLE
                }
                val random = Random
                val randomindex = random.nextInt(24)
                imageArray[randomindex].visibility = View.VISIBLE

                handler.postDelayed(runnable,500)
            }

        }
        handler.post(runnable)


    }


    fun increaseScore (view: View) {
        score = score + 1
        binding.scoreText.text = "Score: $score"

    }

}