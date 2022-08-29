package azamat.srm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import azamat.srm.databinding.ActivityMainBinding
import azamat.srm.databinding.ActivityMenuBinding
class MenuActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        binding = ActivityMenuBinding.inflate(layoutInflater)

        findViewById<TextView>(R.id.manage).setOnClickListener {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        findViewById<TextView>(R.id.show).setOnClickListener {
            var intent = Intent(this, AllStudentsActivity::class.java)
            startActivity(intent)
        }


    }
}