package azamat.srm.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import azamat.srm.R;

public class AllStudentAdapter extends CursorAdapter {


    public AllStudentAdapter(Context context, Cursor cursor) {
        super(context, cursor, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_all_student_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        TextView student = view.findViewById(R.id.student_name);
        TextView number = view.findViewById(R.id.student_number);
        TextView course = view.findViewById(R.id.course_name);
        TextView title = view.findViewById(R.id.group_name);
        TextView mentor = view.findViewById(R.id.mentor_name);


        student.setText(cursor.getString(1));
        number.setText(cursor.getString(2));
        course.setText(cursor.getString(3));
        title.setText(cursor.getString(4));
        mentor.setText(cursor.getString(5));

    }
}
