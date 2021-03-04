package com.assignmentone

import android.content.SharedPreferences.Editor
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.assignmentone.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var number: Count = Count()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.btnToast.setOnClickListener {
            showToast()
        }
        if (savedInstanceState == null) {
            binding.count = number
        } else {
            binding.count = number
        }
        binding.btnCountUp.setOnClickListener {
            countUp()
        }
        binding.btnCountDown.setOnClickListener {
            countDown()
        }
    }
    override fun onSaveInstanceState(outState: Bundle){
        super.onSaveInstanceState(outState)

        val num : String = number.num
        outState.putString("Num", num)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val num : String = savedInstanceState.getString("Num", "10")
        number.num = num
        binding.count = number
    }

    private fun countUp(){
        binding.apply {
            var temp = number.num.toInt()
            temp += 1
            number.num = temp.toString()
            binding.count = number
        }
    }
    private fun countDown(){
        binding.apply {
            var temp = number.num.toInt()
            temp -= 1
            number.num = temp.toString()
            binding.count = number
        }
    }

    private fun showToast(){
        Toast.makeText(applicationContext,"Your count is at ".plus(binding.textView.text.toString()),Toast.LENGTH_SHORT).show()
    }

}
