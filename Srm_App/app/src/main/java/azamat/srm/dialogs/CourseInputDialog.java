package azamat.srm.dialogs;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import azamat.srm.DB;
import azamat.srm.R;
import azamat.srm.databinding.ManageAddViewBinding;

public class CourseInputDialog extends AlertDialog {

    private ManageAddViewBinding binding;
    private CourseSaveClickListener courseSaveClickListener;

    public void setCourseSaveClickListener(CourseSaveClickListener courseSaveClickListener) {
        this.courseSaveClickListener = courseSaveClickListener;
    }

    String course;
    String mentor;

    public CourseInputDialog(@NonNull Context context) {
        super(context);

        getWindow().getDecorView().setBackgroundColor(Color.TRANSPARENT);

        binding = ManageAddViewBinding.inflate(LayoutInflater.from(context), null, false);

        String[] array = {"Java Programming", "PHP","JavaScript", "Android", ".Net", "Data Science", "Java Backend"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, array);
        binding.inputCourse.setAdapter(adapter);


        binding.inputCourse.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {

                if (position==0){
                    course = "Java Programming";
                    String[] array = {"Muslima Kabirjanova", "Muhammadjon Fayziev"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, array);
                    binding.inputMentor.setAdapter(adapter);
                    binding.inputMentor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            if (position==0)
                                mentor = "2";
                            else
                                mentor = "6";

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

                else if (position==1){
                    course = "PHP";
                    String[] array = {"Husniddin To'gizov", "Samandar Nosirov"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, array);
                    binding.inputMentor.setAdapter(adapter);
                    binding.inputMentor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            if (position==0)
                                mentor = "7";
                            else
                                mentor = "3";

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

                else if (position==2){
                    course = "JavaScript";
                    String[] array = {"Ozodbek Oripjonov", "Husniddin To'gizov"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, array);
                    binding.inputMentor.setAdapter(adapter);
                    binding.inputMentor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            if (position==0)
                                mentor = "5";
                            else
                                mentor = "7";

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

                else if (position==3){
                    course = "Android";
                    String[] array = {"Fozilbek Imomov", "Muslima Kabirjanova"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, array);
                    binding.inputMentor.setAdapter(adapter);
                    binding.inputMentor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            if (position==0)
                            mentor = "1";
                            else
                                mentor = "2";

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

                else if (position==4){
                    course = ".Net";
                    String[] array = {"Muhammadjon Fayziev", "A'zamjon Ne'madaliev"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, array);
                    binding.inputMentor.setAdapter(adapter);
                    binding.inputMentor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            if (position==0)
                                mentor = "6";
                            else
                                mentor = "4";

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

                else if (position==5){
                    course = "Data Science";
                    String[] array = {"A'zamjon Ne'madaliev", "Fozilbek Imomov"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, array);
                    binding.inputMentor.setAdapter(adapter);
                    binding.inputMentor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            if (position==0)
                                mentor = "4";
                            else
                                mentor = "1";

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }

                else{
                    course = "Java Backend";
                    String[] array = {"Samandar Nosirov", "Muslima Kabirjonova"};
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, androidx.constraintlayout.widget.R.layout.support_simple_spinner_dropdown_item, array);
                    binding.inputMentor.setAdapter(adapter);
                    binding.inputMentor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                            if (position==0)
                                mentor = "3";
                            else
                                mentor = "2";

                        }
                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        setView(binding.getRoot());

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (courseSaveClickListener != null) {

                    String title = binding.inputName.getText().toString();

                    courseSaveClickListener.onSave(title, course, mentor);


                }
            }
        });

        binding.cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (courseSaveClickListener != null) {
                    courseSaveClickListener.onCancel();
                }
            }
        });

    }

    public interface CourseSaveClickListener {
        void onSave(String course, String mentor, String student);
        void onCancel();
    }
}
