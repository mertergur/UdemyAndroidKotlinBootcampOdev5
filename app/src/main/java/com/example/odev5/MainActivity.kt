package com.example.odev5

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.odev5.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private var resultText = ""
    private var result = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        resultText = binding.textView.text.toString()

        numberWrite(binding.buttonPoint)
        numberWrite(binding.buttonZero)
        numberWrite(binding.buttonOne)
        numberWrite(binding.buttonTwo)
        numberWrite(binding.buttonThree)
        numberWrite(binding.buttonFour)
        numberWrite(binding.buttonFive)
        numberWrite(binding.buttonSix)
        numberWrite(binding.buttonSeven)
        numberWrite(binding.buttonEight)
        numberWrite(binding.buttonNine)

        binding.buttonPlus.setOnClickListener {
            if(resultText.isNotEmpty()) {
                binding.textView.text = binding.textView.text.toString() + binding.buttonPlus.text
                Log.e("result","btnPlus sonra: ${binding.textView.text}")
            }
        }


            binding.buttonBackSpace.setOnClickListener {
                if(binding.textView.text.isNotEmpty()) {
                    binding.textView.text =
                        binding.textView.text.substring(0, binding.textView.text.length - 1)
                }
                if(binding.textView.text == ""){
                    result = 0.0
                    resultText = "0.0"
                }
        }

        binding.buttonC.setOnClickListener {
            result = 0.0
            resultText = result.toString()
            binding.textView.text = resultText
            Log.e("result",binding.textView.text.toString())
            Log.e("result",resultText)
        }

        funcPlus(binding.buttonEquals)



    }

    fun numberWrite(btn: Button){
        btn.setOnClickListener {
            if(binding.textView.text.toString() == "0" || binding.textView.text.toString() == "0.0" || binding.textView.text.toString() == result.toString()){
                binding.textView.setText(btn.text.toString())

            }else{
                binding.textView.setText(binding.textView.text.toString() + btn.text.toString())
            }
            resultText = binding.textView.text.toString()
            Log.e("result", resultText)


        }
    }

    fun funcPlus (funcPlus: Button){
        if(resultText.isNotEmpty()) {
            funcPlus.setOnClickListener {
                result = 0.0
                Log.e("result","butona tıklandı $resultText")
                    var a = resultText.split("+")
                    for (i in a) {
                        result += i.toDouble()
                        binding.textView.text = result.toString()
                        Log.e("result","i: $i")
                        Log.e("result","result: $result")
                }
            }
        }
    }


}