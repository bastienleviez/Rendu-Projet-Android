package fr.epsi.testepsi;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    EpsiActivity activity;
    ArrayList<Categories> categories;

    public CategoryAdapter(EpsiActivity activity, ArrayList<Categories> categories){
        this.activity=activity;
        this.categories=categories;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final View layoutCellCategory;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewName = view.findViewById(R.id.textViewName);
            layoutCellCategory = view.findViewById(R.id.layoutCellCategory);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public View getLayoutCellCategory() {
            return layoutCellCategory;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_category, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Categories category = categories.get(position);
        holder.getTextViewName().setText(category.getTitle());
        holder.getLayoutCellCategory().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductsWSActivity.displayActivity(activity,category.getProducts_url());
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }
}

