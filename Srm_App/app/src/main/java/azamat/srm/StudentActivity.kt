package azamat.srm

import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import azamat.srm.adapters.OnDeleteStudentClick
import azamat.srm.adapters.StudentAdapter
import azamat.srm.databinding.ActivityStudentBinding
import azamat.srm.dialogs.StudentInputDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class StudentActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var binding: ActivityStudentBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)

        binding = ActivityStudentBinding.inflate(layoutInflater)

        var a = intent.getLongExtra("id", 0)

        val data = DB.getInstance()!!.getCourseId(a.toInt())

        studentAdapter = StudentAdapter(this, DB.getInstance()!!.getStudents(data[0].toInt()))

        findViewById<ListView>(R.id.student_listView).adapter = studentAdapter

        loadActions()

    }

    private fun loadActions() {

        val a = intent.getLongExtra("id", 0)
        val data = DB.getInstance()!!.getCourseId(a.toInt())



        studentAdapter.setOnDeleteStudentClick(object : OnDeleteStudentClick{
            override fun onDeleteClick(index: Int, name: String) {
                Toast.makeText(this@StudentActivity, name, Toast.LENGTH_SHORT).show()
                DB.getInstance()!!.delSt(index)
                DB.getInstance()?.deleteStudent(name)
            }

        })



        findViewById<FloatingActionButton>(R.id.add_student).setOnClickListener {
            println("AAAAAAAAAAAAAA:")
            val dialog = StudentInputDialog(this)
            dialog.setStudentSaveClick(object : StudentInputDialog.StudentSaveClick{

                override fun onSave(name: String, number: String) {
                    DB.getInstance()!!.addStudent(name, number, data[1], data[0], data[2])
                    studentAdapter.changeCursor(DB.getInstance()!!.getStudents(data[0].toInt()))
                    dialog.dismiss()
                }

                override fun onCancel() {
                    dialog.dismiss()
                }
            })
            dialog.show()

        }
        
    }
}