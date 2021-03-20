package fr.epsi.testepsi;


import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class ProfilActivity extends EpsiActivity {


    public static void displayActivity(EpsiActivity activity,String url, String mail, String name){
        Intent intent = new Intent(activity,ProfilActivity.class);
        intent.putExtra("url",url);
        intent.putExtra("mail",mail);
        intent.putExtra("name",name);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        showBack();

        String url = getIntent().getExtras().getString("url","");
        String mail = getIntent().getExtras().getString("mail","");
        String name = getIntent().getExtras().getString("name","");


        setTitle("Profile");

        ImageView imageView = findViewById(R.id.image);
        Picasso.get().load(url).into(imageView);

        TextView textViewMail = findViewById(R.id.mail);
        textViewMail.setText(mail);

        TextView textViewName = findViewById(R.id.name);
        textViewName.setText(name);

    }
}