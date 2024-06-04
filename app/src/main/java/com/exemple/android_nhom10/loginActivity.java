package com.exemple.android_nhom10;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class loginActivity extends AppCompatActivity {
    Button btndangnhap;
    TextView registerlink;
    EditText edtmsv, edtmatkhau;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        getWidgetsControl();

        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLogin();
            }
        });
        registerlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(loginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void handleLogin() {;
        String studentId = edtmsv.getText().toString().trim();
        String password = edtmatkhau.getText().toString().trim();

        if (validateInput(studentId, password)) {
            // Thực hiện đăng ký
            performLogin(studentId, password);
        }
    }

    private boolean validateInput( String studentId, String password) {
        boolean isValid = true;

        // Kiểm tra mã sinh viên phải là số và có ít nhất 8 ký tự
        if (!studentId.matches("\\d{8,}")) {
            edtmsv.setError("Mã sinh viên không hợp lệ");
            isValid = false;
        } else {
            edtmsv.setError(null);
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

    private void performLogin(String studentId, String password) {
        //chuyển tạm sang đăng ký,đợi gộp code thì chuyển sang màn home
        Intent intent = new Intent(loginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
    private void getWidgetsControl() {
        btndangnhap = findViewById(R.id.btndangnhap);
        edtmsv = (EditText) findViewById(R.id.edtmsv);
        edtmatkhau = (EditText) findViewById(R.id.edtmatkhau);
        registerlink = (TextView) findViewById(R.id.registerlink);
    }
}