package com.example.vypt.demoimagelibrary;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    ImageView im1,im2;

    Button bt;
    String url = "https://firebasestorage.googleapis.com/v0/b/demo2-e9c97.appspot.com/o/images%2FthanhphanRoom.png?alt=media&token=fbb140ee-727d-4f5d-ac2f-feb454c18df7";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(MainActivity.this);
        setContentView(R.layout.activity_main);

        im1 = (ImageView) findViewById(R.id.im1);
        im2 = (ImageView) findViewById(R.id.im2);
        bt = (Button) findViewById(R.id.button);
        //im3 = (ImageView) findViewById(R.id.im3);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Glide.with(MainActivity.this)
                        .load(url)
                        .into(im1);

                Picasso.with(MainActivity.this)
                        .load(url)
                        .placeholder(R.mipmap.ic_launcher)
                        .into(im2);

                Uri imageUri = Uri.parse(url);
                SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.im3);
                draweeView.setImageURI(imageUri);
            }
        });
    }
}
