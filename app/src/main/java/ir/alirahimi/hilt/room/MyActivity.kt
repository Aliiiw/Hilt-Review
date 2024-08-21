package ir.alirahimi.hilt.room

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.alirahimi.hilt.R
import ir.alirahimi.hilt.databinding.ActivityMyBinding
import ir.alirahimi.hilt.room.db.User
import ir.alirahimi.hilt.room.db.UserDatabase
import ir.alirahimi.hilt.room.repository.DatabaseRepository
import javax.inject.Inject

@AndroidEntryPoint
class MyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyBinding

    @Inject
    lateinit var adapter: UserAdapter

    @Inject
    lateinit var repository: DatabaseRepository

    @Inject
    lateinit var user: User
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {

            button.setOnClickListener {
                user.id = 0
                user.name = editTextText.text.toString()
                repository.saveUser(user)
                editTextText.setText("")
                adapter.differ.submitList(repository.getAllUsers())
            }

            adapter.differ.submitList(repository.getAllUsers())
            recycler.layoutManager = LinearLayoutManager(this@MyActivity)
            recycler.adapter = adapter

        }

        adapter.setOnItemClickListener {
            Toast.makeText(this, "id: ${it.id} and name: ${it.name}", Toast.LENGTH_SHORT).show()
        }
    }
}