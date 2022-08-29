package azamat.srm

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor

class DB private constructor(context: Context): DbHelper(context, "srm1.db") {

    companion object {
        @SuppressLint("StaticFieldLeak")
        private var noteDB: DB? = null

        fun init(context: Context) {
            if (noteDB==null)
                noteDB = DB(context)

        }

        fun getInstance(): DB? {
            return noteDB
        }
    }

    fun getInfo(): Cursor {
        return mDataBase.rawQuery("SELECT info._id, course.course_name, mentors.mentor_name, info.student_name from info, course, mentors WHERE info.course_name = course._id and info.mentor_name = mentors._id", emptyArray())
    }

    fun getStudents(index: Int): Cursor {
        return mDataBase.rawQuery("select students._id, students.studen_name, course.course_name, course.course_title from students, course where students.course_name = course._id and course._id=$index", emptyArray())
    }

    fun getCourse(): Cursor {
        return mDataBase.rawQuery("SELECT course._id, course.course_title, course.course_name, mentors.mentor_name FROM mentors, course WHERE course.mentor_name = mentors._id", emptyArray())
    }

    fun getAllStudents(): Cursor {
        return mDataBase.rawQuery("SELECT students._id, students.studen_name, students.number, course.course_title, course.course_name, mentors.mentor_name FROM students, course, mentors where students.course_name = course._id and students.mentor_name = mentors._id", emptyArray())
    }

    fun delSt(index: Int): Cursor {
        return mDataBase.rawQuery("DELETE FROM students WHERE students._id = $index", emptyArray())
    }


    fun addStudent(student: String, number: String, title: String, course: String, mentor: String ) {
        val contentValue = ContentValues()
        contentValue.put("studen_name", student)
        contentValue.put("number", number)
        contentValue.put("course_title", title)
        contentValue.put("course_name", course)
        contentValue.put("mentor_name", mentor)
        mDataBase.insert("students", null, contentValue)
    }


    fun addCourse(title: String,course: String, mentor: String) {
        val contentValue = ContentValues()
        contentValue.put("course_title", title)
        contentValue.put("course_name", course)
        contentValue.put("mentor_name", mentor)
        mDataBase.insert("course", null, contentValue)
    }

    fun deleteStudent(name: String): Cursor {
        return mDataBase.rawQuery("DELETE From students where studen_name='$name'", emptyArray())
    }




    fun getCourseId(index: Int): ArrayList<String> {
        val data = ArrayList<String>()
        val cursor = mDataBase.rawQuery("SELECT * from course WHERE course._id = $index", emptyArray())
        cursor.moveToFirst()
        data.add(cursor.getString(0))
        data.add(cursor.getString(2))
        data.add(cursor.getString(3))

        return data;
    }

}