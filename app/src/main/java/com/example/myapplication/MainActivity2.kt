package com.example.myapplication

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    lateinit var radioGroup: RadioGroup
    lateinit var textView: TextView

    private val viewModel: MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }


    var radioInt1: Int = 0
    var radioInt2: Int = 0
    var radioInt3: Int = 0
    var textViewInt: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMain2Binding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        textView = binding.radioTextView
        radioGroup = binding.radioGroup1


//        viewModel.savedState.observe(this) {
//            if (it.isNotEmpty()) {
//                binding.firstRadioButton.text = it[KEY1].toString()
//                binding.secondRadioButton.text = it[KEY2].toString()
//                binding.thirdRadioButton.text = it[KEY3].toString()
//                textView.text = it[KEY4].toString()
//            }
//            Log.d("MAP",  viewModel.savedState.value?.values.toString())
//        }
        if (viewModel.savedState.value?.isNotEmpty() == true) {
            viewModel.savedState.value?.also {
                binding.firstRadioButton.text = it[KEY1].toString()
                binding.secondRadioButton.text = it[KEY2].toString()
                binding.thirdRadioButton.text = it[KEY3].toString()
                textView.text = it[KEY4].toString()
            }

        }
        Log.d("MAP",  viewModel.savedState.value?.values.toString())

        changeTextViewIntAndSaveRadioInts()
        //textViewInt = binding.radioTextView.text.toString().toInt()

        //Записати у числову змінну значення з текстового поля


        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            findViewById<RadioButton>(checkedId)?.apply {
                textView.text = text
                textViewInt = text.toString().toInt()
                //Присвоїти числовій змінній таке ж значення
                viewModel.saveSt(radioInt1, radioInt2, radioInt3, textViewInt)
            }
        }

    }

    /*
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(KEY1, radioInt1)
        outState.putInt(KEY2, radioInt2)
        outState.putInt(KEY3, radioInt3)
        outState.putInt(KEY4, textViewInt)
        //Запам'ятати числову змінну

        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        if (savedInstanceState != null){
            binding.firstRadioButton.text = savedInstanceState.getInt(KEY1).toString()
            binding.secondRadioButton.text = savedInstanceState.getInt(KEY2).toString()
            binding.thirdRadioButton.text = savedInstanceState.getInt(KEY3).toString()
            binding.radioTextView.text  = savedInstanceState.getInt(KEY4).toString()
            //Вписати числову змінну у текстове поле

        }
        super.onRestoreInstanceState(savedInstanceState)
    }*/
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item1 -> {
                binding.firstRadioButton.text = "10"
                binding.secondRadioButton.text = "20"
                binding.thirdRadioButton.text = "30"
                changeTextViewIntAndSaveRadioInts()
                true
            }
            R.id.item2 -> {
                binding.firstRadioButton.text = "40"
                binding.secondRadioButton.text = "50"
                binding.thirdRadioButton.text = "60"
                changeTextViewIntAndSaveRadioInts()
                true
            }
            R.id.item3 -> {
                binding.firstRadioButton.text = "70"
                binding.secondRadioButton.text = "80"
                binding.thirdRadioButton.text = "90"
                changeTextViewIntAndSaveRadioInts()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

//     fun saveRadioInts() {
//        radioInt1 = binding.firstRadioButton.text.toString().toInt()
//        radioInt2 = binding.secondRadioButton.text.toString().toInt()
//        radioInt3 = binding.thirdRadioButton.text.toString().toInt()
//        textViewInt = binding.radioTextView.text.toString().toInt()
//    }

    fun changeTextViewIntAndSaveRadioInts() {
        textView.text = radioGroup.findViewById<RadioButton>(radioGroup.checkedRadioButtonId).text
        radioInt1 = binding.firstRadioButton.text.toString().toInt()
        radioInt2 = binding.secondRadioButton.text.toString().toInt()
        radioInt3 = binding.thirdRadioButton.text.toString().toInt()
        textViewInt = binding.radioTextView.text.toString().toInt()
        viewModel.saveSt(radioInt1, radioInt2, radioInt3, textViewInt)
    }

    companion object {
        const val KEY1 = "RADIO_1"
        const val KEY2 = "RADIO_2"
        const val KEY3 = "RADIO_3"
        const val KEY4 = "TEXT_1"
    }

}
