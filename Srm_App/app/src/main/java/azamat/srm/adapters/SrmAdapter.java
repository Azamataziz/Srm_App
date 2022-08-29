package azamat.srm.adapters;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import azamat.srm.R;

public class SrmAdapter extends CursorAdapter {


    public SrmAdapter(Context context, Cursor cursor) {
        super(context, cursor, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_manage_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {


        TextView course_title = view.findViewById(R.id.course_group_name);
        TextView course = view.findViewById(R.id.course_name);
        TextView mentor = view.findViewById(R.id.mentor_name);

        course_title.setText(cursor.getString(1));
        course.setText(cursor.getString(2));
        mentor.setText(cursor.getString(3));

    }
}
