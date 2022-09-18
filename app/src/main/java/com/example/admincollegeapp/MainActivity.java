package com.example.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.admincollegeapp.faculty.UpdateFaculty;
import com.example.admincollegeapp.notice.DeleteNoticeActivity;
import com.example.admincollegeapp.notice.UploadNotice;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private CardView uploadNotice,addGalleryImage,addEbook ,faculty,deleteNotice ,logout;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = this.getSharedPreferences("login",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (sharedPreferences.getString("isLogin", String.valueOf(false)).equals("false")){
            openLogin();
        }

        logout=findViewById(R.id.logout);
        logout.setOnClickListener(this);

        uploadNotice=findViewById(R.id.addNotice);
        uploadNotice.setOnClickListener(this);

        addGalleryImage=findViewById(R.id.addGalleryImage);
        addGalleryImage.setOnClickListener(this);

        addEbook=(CardView)findViewById(R.id.addEbook);
        addEbook.setOnClickListener(this);

        faculty = findViewById(R.id.faculty);
        faculty.setOnClickListener(this);

        deleteNotice=findViewById(R.id.deleteNotice);
        deleteNotice.setOnClickListener(this);
    }

    private void openLogin() {
        startActivity(new Intent(MainActivity.this,LoginActivity2.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){

            case R.id.addNotice:
                 intent=new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;
            case R.id.addGalleryImage:
                 intent=new Intent(MainActivity.this,UploadImage.class);
                startActivity(intent);
                break;
            case R.id.addEbook:
                intent=new Intent(MainActivity.this,UploadPdfActivity.class);
                startActivity(intent);
                break;
            case R.id.faculty:
                intent=new Intent(MainActivity.this, UpdateFaculty.class);
                startActivity(intent);
                break;
            case R.id.deleteNotice:
                intent=new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;
            case R.id.logout:
                editor.putString("isLogin","false");
                editor.commit();
               openLogin();
                break;

        }

    }
}