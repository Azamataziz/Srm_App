package azamat.srm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import azamat.srm.adapters.AllStudentAdapter
import azamat.srm.adapters.SrmAdapter
import azamat.srm.databinding.ActivityAllStudentsBinding
import azamat.srm.databinding.ActivityMainBinding

class AllStudentsActivity : AppCompatActivity() {

    private lateinit var allStudentsAdapter: AllStudentAdapter

    private lateinit var binding: ActivityAllStudentsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_students)

        binding = ActivityAllStudentsBinding.inflate(layoutInflater)

        allStudentsAdapter = AllStudentAdapter(this, DB.getInstance()!!.getAllStudents())

        findViewById<ListView>(R.id.manage_listView).adapter = allStudentsAdapter

    }
}