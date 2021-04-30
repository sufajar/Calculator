package com.sufajar.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.sufajar.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity(),ProsessCalculator {
    private lateinit var binding : ActivityMainBinding;
    var lastDot: Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root);

    }

    override fun onDigit(view: View) {
        if (binding.txtHasil.text.toString().trim() == "0") binding.txtHasil.text = ""
        binding.txtHasil.append((view as Button).text.toString())
    }

    override fun onOperator(view: View) {
        binding.txtHasil.append("${(view as Button).text}")
    }

    override fun onClear(view: View) {
        binding.txtHasil.text = "0"
    }

    override fun onEqual(view: View) {


        try {
            val text = binding.txtHasil.text.toString() //to string
            val eval = ExpressionBuilder(text).build()
            val res =eval.evaluate()
            binding.txtHasil.text = res.toString()

        } catch (e : Exception) {
             e.printStackTrace()
            Toast.makeText(this,"Operasi penjumlahan tidak dapat dijalankan",Toast.LENGTH_SHORT).show()

        }
    }

    override fun onBreaketStart(view: View) {
        binding.txtHasil.append("(")
    }

    override fun onBreaketEnd(view: View) {
        binding.txtHasil.append(")")
    }

    override fun onDecimal(view: View) {
        binding.txtHasil.append(".")
    }

    override fun onDelete(view: View) {
       val resultafterDelete:String = binding.txtHasil.text.toString()
        if (resultafterDelete.isNotEmpty()) {
            binding.txtHasil.text = resultafterDelete.dropLast(1)
        } else binding.txtHasil.text = "0"
    }
}