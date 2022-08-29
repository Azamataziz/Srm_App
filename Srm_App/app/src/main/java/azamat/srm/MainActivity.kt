package azamat.srm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import azamat.srm.adapters.SrmAdapter
import azamat.srm.databinding.ActivityMainBinding
import azamat.srm.dialogs.CourseInputDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var srmAdapter: SrmAdapter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)

        srmAdapter = SrmAdapter(this, DB.getInstance()!!.getCourse())

        findViewById<ListView>(R.id.manage_listView).adapter = srmAdapter

        loadActions()

    }

    private fun loadActions() {

        findViewById<FloatingActionButton>(R.id.add_course).setOnClickListener {
            val dialog = CourseInputDialog(this)
            dialog.setCourseSaveClickListener(object : CourseInputDialog.CourseSaveClickListener{
                override fun onSave(title: String, course: String, mentor: String) {

                    DB.getInstance()!!.addCourse(title, course, mentor)
                    srmAdapter.changeCursor(DB.getInstance()!!.getCourse())
                    dialog.dismiss()
                }

                override fun onCancel() {
                    dialog.dismiss()
                }
            })
            dialog.show()
        }

        findViewById<ListView>(R.id.manage_listView).setOnItemClickListener { parent, view, p, l ->
            var intent = Intent(this, StudentActivity::class.java)
            intent.putExtra("id", l)
            startActivity(intent)

        }
    }
}