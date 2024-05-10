package com.example.labexam04

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.labexam04.databinding.ActivityAddBinding
import com.example.labexam04.databinding.ActivityMainBinding

class AddActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddBinding
    private lateinit var db: TaskDBHelper
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDBHelper(this)

        binding.saveBtn.setOnClickListener{
            val title = binding.titleEditText.text.toString()
            val description = binding.descriptionEditText.text.toString()
            val task = Task(0, title, description)
            db.insertTask(task)
            finish()
            Toast.makeText(this, "Task Saved", Toast.LENGTH_SHORT).show()
        }



    }
}