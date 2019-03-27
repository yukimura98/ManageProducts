package com.example.phancanhhuu;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Main2Activity extends AppCompatActivity {
    EditText edtuser,edtpassword;
    Button btndangky,btndangnhap,btnthoat;
    String ten, mk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Anhxa();
        ControlButton();
    }

    private void ControlButton() {
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this,android.R.style.Theme_DeviceDefault_Light_Dialog);
                builder.setTitle("Bạn có chắc muốn thoát khỏi App");
                builder.setMessage("Hãy lựa chọn để xác nhận");
                builder.setIcon(android.R.drawable.ic_dialog_alert);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        onBackPressed();
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                    }
                });
                builder.show();
            }
        });
        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog=new Dialog(Main2Activity.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setCancelable(false);
                dialog.setContentView(R.layout.customdialog);

                final EditText edttk =(EditText)dialog.findViewById(R.id.edttk);
                final EditText edtmk =(EditText)dialog.findViewById(R.id.edtmk);

                Button btnhuy   = (Button)dialog.findViewById(R.id.buttonnhuy);
                Button btndongy   = (Button)dialog.findViewById(R.id.buttondongy);
                btndongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = edttk.getText().toString().trim();
                        mk = edtmk.getText().toString().trim();
                        edtuser.setText(ten);
                        edtpassword.setText(mk);
                        dialog.cancel();
                    }
                });
                btnhuy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();

            }
        });
        btndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtuser.getText().length()!=0 && edtpassword.getText().length()!=0){
                    if(edtuser.getText().toString().equals(ten) && edtpassword.getText().toString().equals(mk)){
                        Intent intent = new Intent(Main2Activity.this,Main3Activity.class);
                        startActivity(intent);
                        Toast.makeText(Main2Activity.this,"Bạn đã đăng nhập thành công",Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(Main2Activity.this,"Đăng nhập thất bại !",Toast.LENGTH_LONG).show();
                    }
                }else
                {
                    Toast.makeText(Main2Activity.this,"Vui lòng nhập đầy đủ thông tin",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void Anhxa() {
        edtuser= (EditText)findViewById(R.id.edittextuser);
        edtpassword= (EditText)findViewById(R.id.edittextpassword);
        btndangky=(Button)findViewById(R.id.buttondangky);
        btndangnhap=(Button)findViewById(R.id.buttondangnhap);
        btnthoat=(Button)findViewById(R.id.buttonthoat);
    }
}
