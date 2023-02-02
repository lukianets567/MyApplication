package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMain2Binding
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by lazy { ViewModelProvider(this)[MainViewModel::class.java] }

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        registerForContextMenu(binding.contextMenu)

        binding.popupMenu.setOnClickListener() {
            popupMenu()
        }
        binding.appBarMenu.setOnClickListener() {
            intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

        binding.checkableMenu.setOnClickListener {

        }

        viewModel.text.observe(this, Observer<String> {newText -> binding.liveDataText.text = newText})

        binding.changeTextButton.setOnClickListener {
            viewModel.text.value = binding.editText.text.toString()
        }

    }

     override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         menuInflater.inflate(R.menu.checkable, menu)
         return true
     }
     override fun onOptionsItemSelected(item: MenuItem): Boolean {
         return when (item.itemId) {
             R.id.item0001 ->{
                // item.isChecked = !item.isChecked
                 //item.isChecked
                 Toast.makeText(applicationContext, "0001", Toast.LENGTH_SHORT).show()
             true
             }
             R.id.item0002 -> {
                 Toast.makeText(applicationContext, "0002", Toast.LENGTH_SHORT).show()
                 true
             }
             R.id.item0003 -> {
                 Toast.makeText(applicationContext, "0003", Toast.LENGTH_SHORT).show()
                 true
             }
             else -> super.onOptionsItemSelected(item)
         }
     }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.item001 -> {
                Toast.makeText(applicationContext, "001", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item002 -> {
                Toast.makeText(applicationContext, "002", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.item003 -> {
                Toast.makeText(applicationContext, "003", Toast.LENGTH_SHORT).show()
                true
            }
            else -> true
        }
        return super.onContextItemSelected(item)
    }


    fun popupMenu() {
        val popupMenu = PopupMenu(applicationContext, binding.popupMenu)
        popupMenu.inflate(R.menu.menu123)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.item1 -> {
                    Toast.makeText(applicationContext, "1", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item2 -> {
                    Toast.makeText(applicationContext, "2", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.item3 -> {
                    Toast.makeText(applicationContext, "3", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> true
            }
        }
       popupMenu.show()
    }

}