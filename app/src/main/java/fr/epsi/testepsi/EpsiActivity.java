package fr.epsi.testepsi;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class EpsiActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("tag","############## onCreate ################# :"+getClass().getSimpleName());
    }


    @Override
    public void finish() {
        super.finish();
        Log.d("tag","############## finish ################# :"+getClass().getSimpleName());
    }

    public void showBack(){
        ImageView imageView = findViewById(R.id.imageViewBack);
        if(imageView!=null){
            imageView.setVisibility(View.VISIBLE);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
        }
    }

    public void setTitle(String title){
        TextView textView=findViewById(R.id.textViewTitle);
        if(textView!=null){
            textView.setText(title);
        }
    }
}
