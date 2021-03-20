package fr.epsi.testepsi;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ImageActivity extends EpsiActivity {


    public static void displayActivity(EpsiActivity activity,String url,String title){
        Intent intent = new Intent(activity,ImageActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("title",title);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        showBack();

        String url = getIntent().getExtras().getString("url","");
        String title = getIntent().getExtras().getString("title","");

        setTitle(title);

        ImageView imageView = findViewById(R.id.image);
        Picasso.get().load(url).into(imageView);

    }
}