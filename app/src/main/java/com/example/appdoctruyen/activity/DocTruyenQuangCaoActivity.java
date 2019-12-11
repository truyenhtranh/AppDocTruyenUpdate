package com.example.appdoctruyen.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.appdoctruyen.R;
import com.example.appdoctruyen.service.ApiDocTruyenChapter;
import com.example.appdoctruyen.service.ApiDocTruyenQuangCaoChapter;
import com.example.appdoctruyen.service.layanhve;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class DocTruyenQuangCaoActivity extends AppCompatActivity implements layanhve {

    ArrayList<String> anh;
    ImageView imageView;
    TextView pre, next;
    int sotrangdangdoc, sotrang;
    String idChap;
    int khoangcach = 100,vantoc=100;

    GestureDetector gestureDetector;
    ScaleGestureDetector scaleGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_truyen);

        imageView = findViewById(R.id.imgAnhDocTruyen);

        Bundle b = getIntent().getBundleExtra("idChap");
        idChap = b.getString("idChap");

        Toast.makeText(this, "" + idChap, Toast.LENGTH_LONG).show();

        new ApiDocTruyenQuangCaoChapter(this, idChap).execute();

    }



    public void doctruyen(int i) {

        if (sotrang > 0) {
            sotrangdangdoc = sotrangdangdoc + i;
            if (sotrangdangdoc == 0) {
                sotrangdangdoc = 1;
            }
            if (sotrangdangdoc > sotrang) {
                sotrangdangdoc = sotrang;
            }
            Glide.with(this).load(anh.get(sotrangdangdoc - 1)).into(imageView);
        } else {
            Toast.makeText(this,"Chua Co chap",Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void ketThuc(String data) {

        try {
            anh = new ArrayList<>();
            JSONArray array = new JSONArray(data);
            for (int i = 0; i < array.length(); i++) {
                anh.add(array.getString(i));
            }
            sotrangdangdoc = 1;
            sotrang = anh.size();
            doctruyen(0);

            gestureDetector = new GestureDetector(this, new DocTruyenQuangCaoActivity.myGestrue());
            scaleGestureDetector = new ScaleGestureDetector(this,new DocTruyenQuangCaoActivity.myScale());

            imageView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {

                    gestureDetector.onTouchEvent(event);
                    // scaleGestureDetector.onTouchEvent(event);
                    return true;
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    class myGestrue extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getX() - e1.getX()>khoangcach && Math.abs(velocityX)>vantoc){
                doctruyen(-1);
            }
            if (e1.getX() - e2.getX()>khoangcach && Math.abs(velocityX)>vantoc){
                doctruyen(1);
            }

            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
    class myScale extends ScaleGestureDetector.SimpleOnScaleGestureListener{
        float scale = 1.0F , onstar = 0 , onand =0;
        @Override
        public boolean onScale(ScaleGestureDetector detector) {
            scale *=detector.getScaleFactor();
            imageView.setScaleX(scale);
            imageView.setScaleX(scale);
            return super.onScale(detector);
        }

        @Override
        public boolean onScaleBegin(ScaleGestureDetector detector) {
            onstar = scale;
            return super.onScaleBegin(detector);
        }

        @Override
        public void onScaleEnd(ScaleGestureDetector detector) {
            onand =scale;
            super.onScaleEnd(detector);
        }
    }

    @Override
    public void batdau() {

    }

    @Override
    public void biloi() {

    }
}