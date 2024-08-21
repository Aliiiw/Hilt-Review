package ir.alirahimi.hilt

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dagger.hilt.android.AndroidEntryPoint
import ir.alirahimi.hilt.databinding.ActivityMainBinding
import ir.alirahimi.hilt.di.qualifier.UserFullName
import ir.alirahimi.hilt.util.Constants
import javax.inject.Inject
import javax.inject.Named

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

//    @Inject
//    @UserFullName
//    lateinit var username: String

//    @Inject
//    lateinit var username: String

//    @Inject
//    @Named(Constants.NAMED_USER_NAME)
//    lateinit var username: String

    @Inject
    @Named(Constants.NAMED_RES_STRING)
    lateinit var username: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.apply {
            infoText.text = username
        }
    }
}