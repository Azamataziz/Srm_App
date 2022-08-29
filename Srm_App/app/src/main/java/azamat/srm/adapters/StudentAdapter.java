package azamat.srm.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;

import java.util.Objects;

import azamat.srm.DB;
import azamat.srm.R;

public class StudentAdapter extends CursorAdapter {

    private OnDeleteStudentClick onDeleteStudentClick;

    public void setOnDeleteStudentClick(OnDeleteStudentClick onDeleteStudentClick) {
        this.onDeleteStudentClick = onDeleteStudentClick;
    }

    private int time = 2;

    public StudentAdapter(Context context, Cursor cursor) {
        super(context, cursor, false);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        return LayoutInflater.from(context).inflate(R.layout.item_student_view, parent, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {



        CardView cardView = view.findViewById(R.id.student_rr);
        ImageView delete = view.findViewById(R.id.delete_student);
        TextView student = view.findViewById(R.id.student_name);
        cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                delete.setVisibility(View.VISIBLE);
                CountDownTimer countDownTimer = new CountDownTimer(2000, 1000) {
                    @Override
                    public void onTick(long l) {



                        time--;

                    }

                    @Override
                    public void onFinish() {
                        delete.setVisibility(View.GONE);
                    }
                };
                countDownTimer.start();
                return true;
            }
        });


        cardView.setTag(cursor.getInt(0));
        student.setTag(cursor.getInt(1));
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onDeleteStudentClick!=null)
                    onDeleteStudentClick.onDeleteClick((int) cardView.getTag(), student.getText().toString());

            }
        });

        TextView title = view.findViewById(R.id.title_name);
        TextView course = view.findViewById(R.id.course_name);



        title.setText(cursor.getString(3));
        course.setText(cursor.getString(2));
        student.setText(cursor.getString(1));

    }
}
