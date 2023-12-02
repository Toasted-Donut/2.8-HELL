package ru.myitschool.lab23;

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Bundle;
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.Toast

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider
import ru.myitschool.lab23.databinding.ContentMainBinding
import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var binding: ContentMainBinding
    lateinit var resVM: ResViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ContentMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        resVM = ViewModelProvider(this).get(ResViewModel::class.java)
        binding.calculate.setOnClickListener{
            val res: BigDecimal
            val a = binding.sideA.text.toString().toBigDecimal()
            val b = binding.sideB.text.toString().toBigDecimal()
            val c = binding.sideC.text.toString().toBigDecimal()
            res = when(binding.spinner.selectedItemPosition){
                0 -> a.add(b).add(c).multiply(BigDecimal(4))
                1 -> sqrt((a.pow(2) + b.pow(2) + c.pow(2)).toDouble()).toBigDecimal()
                2 -> a.multiply(b).add(b.multiply(c)).add(a.multiply(c)).multiply(BigDecimal(2))
                3 -> a.multiply(b).multiply(c)
                else -> {BigDecimal.ZERO}
            }
            resVM.res.value = res
        }
        resVM.res.observe(this){
            binding.solution.text = it.setScale(20,RoundingMode.HALF_UP).toPlainString()
        }

    }
}
