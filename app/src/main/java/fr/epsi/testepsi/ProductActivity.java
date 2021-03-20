package fr.epsi.testepsi;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProductActivity extends EpsiActivity {


    public static void displayActivity(EpsiActivity activity,String url, String description, String name){
        Intent intent = new Intent(activity,ProductActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("description",description);
        intent.putExtra("name",name);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        showBack();

        String url = getIntent().getExtras().getString("url","");
        String description = getIntent().getExtras().getString("description","");
        String name = getIntent().getExtras().getString("name","");


        setTitle(name);

        ImageView imageView = findViewById(R.id.image);
        Picasso.get().load(url).into(imageView);

        TextView textViewMail = findViewById(R.id.description);
        textViewMail.setText(description);
    }
}