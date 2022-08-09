package com.abdurashidov.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.abdurashidov.todoapp.databinding.ActivityMainBinding
import com.abdurashidov.todoapp.ui.AddTodo
import com.abdurashidov.todoapp.ui.TodoListActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btn1.setOnClickListener {
            startActivity(Intent(this, TodoListActivity::class.java))
        }

        binding.btn2.setOnClickListener {
            startActivity(Intent(this, AddTodo::class.java))
        }


    }
}