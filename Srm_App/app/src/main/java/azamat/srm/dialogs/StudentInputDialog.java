package azamat.srm.dialogs;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import azamat.srm.databinding.ManageAddViewBinding;
import azamat.srm.databinding.StudentAddViewBinding;

public class StudentInputDialog extends AlertDialog {

    private StudentAddViewBinding binding;

    StudentSaveClick studentSaveClick;

    public void setStudentSaveClick(StudentSaveClick studentSaveClick) {
        this.studentSaveClick = studentSaveClick;
    }

    public StudentInputDialog(@NonNull Context context) {
        super(context);

        getWindow().getDecorView().setBackgroundColor(Color.TRANSPARENT);

        binding = StudentAddViewBinding.inflate(LayoutInflater.from(context), null, false);

        setView(binding.getRoot());

        binding.saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.inputName.getText().toString();
                String number = binding.inputNumber.getText().toString();

                if (studentSaveClick!=null){
                    studentSaveClick.onSave(name, number);
                }

            }
        });

    }

    public interface StudentSaveClick {
        void onSave(String name, String number);
        void onCancel();
    }
}
