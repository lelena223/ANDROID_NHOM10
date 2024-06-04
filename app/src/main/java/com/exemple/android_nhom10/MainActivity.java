package com.exemple.android_nhom10;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btndangky;
    EditText edthoten, edtmsv, edtemail, edtmatkhau;
    TextView loginlink;
    CheckBox checkBoxShowPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWidgetsControl();
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegister();
            }
        });
        edtmatkhau.setTransformationMethod(PasswordTransformationMethod.getInstance());
        loginlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, loginActivity.class);
                startActivity(intent);
            }
        });
        checkBoxShowPassword.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                handlePasswordVisibilityToggle(isChecked);
            }
        });
    }

    private void handlePasswordVisibilityToggle(boolean isChecked) {
        if (isChecked) {
            // Hiển thị mật khẩu
            edtmatkhau.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
        } else {
            // Ẩn mật khẩu
            edtmatkhau.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        // Di chuyển con trỏ đến cuối văn bản
        edtmatkhau.setSelection(edtmatkhau.getText().length());
    }
    private void handleRegister() {
        String fullName = edthoten.getText().toString().trim();
        String studentId = edtmsv.getText().toString().trim();
        String email = edtemail.getText().toString().trim();
        String password = edtmatkhau.getText().toString().trim();

        if (validateInput(fullName, studentId, email, password)) {
            // Thực hiện đăng ký
            performRegistration(fullName, studentId, email, password);
        }
    }

    private boolean validateInput(String fullName, String studentId, String email, String password) {
        boolean isValid = true;

        // Kiểm tra họ tên không được chứa số và ký tự đặc biệt
        String nameRegex = "^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ\\s]+$";

        if (!fullName.matches(nameRegex)) {
            edthoten.setError("Họ tên không hợp lệ");
            isValid = false;
        } else {
            edthoten.setError(null);
        }

        // Kiểm tra mã sinh viên phải là số và có ít nhất 8 ký tự
        if (!studentId.matches("\\d{8,}")) {
            edtmsv.setError("Mã sinh viên không hợp lệ");
            isValid = false;
        } else {
            edtmsv.setError(null);
        }

        // Kiểm tra định dạng của email
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            edtemail.setError("Email không hợp lệ");
            isValid = false;
        } else {
            edtemail.setError(null);
        }

        // Kiểm tra mật khẩu phải có ít nhất 8 ký tự, bao gồm ít nhất một chữ hoa, một chữ thường, và một số
        if (password.length() < 8 || !password.matches(".*\\d.*")) {
            edtmatkhau.setError("Mật khẩu phải tối thiểu nhất 8 ký tự và ít nhất một ký tự số");
            isValid = false;
        } else {
            edtmatkhau.setError(null);
        }
        return isValid;
    }

    private void performRegistration(String fullName, String studentId, String email, String password) {
        // Sau khi đăng ký thành công, chuyển sang màn hình đăng nhập
        Intent intent = new Intent(MainActivity.this, loginActivity.class);
        startActivity(intent);
        finish();
    }

    private void getWidgetsControl() {
        btndangky = findViewById(R.id.btndangky);
        edthoten = (EditText) findViewById(R.id.edthoten);
        edtmsv = (EditText) findViewById(R.id.edtmsv);
        edtemail = (EditText) findViewById(R.id.edtemail);
        edtmatkhau = (EditText) findViewById(R.id.edtmatkhau);
        loginlink = (TextView) findViewById(R.id.loginlink);
        checkBoxShowPassword = (CheckBox) findViewById(R.id.checkBoxShowPassword);
    }

}