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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    EpsiActivity activity;
    ArrayList<Product> products;

    public ProductAdapter(EpsiActivity activity, ArrayList<Product> products){
        this.activity=activity;
        this.products=products;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewDescription;
        private final ImageView imageViewProduct;
        private final View layoutCellProduct;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewName = view.findViewById(R.id.textViewName);
            textViewDescription = view.findViewById(R.id.textViewDescription);
            imageViewProduct = view.findViewById(R.id.imageViewProduct);
            layoutCellProduct = view.findViewById(R.id.layoutCellProduct);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getTextViewDescription() {
            return textViewDescription;
        }
        public ImageView getImageViewProduct() {
            return imageViewProduct;
        }
        public View getLayoutCellProduct() {
            return layoutCellProduct;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_product, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Product product=products.get(position);
        holder.getTextViewName().setText(product.getName());
        holder.getTextViewDescription().setText(product.getDescription());
        Picasso.get().load(product.getPicture_url()).into(holder.getImageViewProduct());
        holder.getLayoutCellProduct().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductActivity.displayActivity(activity,product.getPicture_url(),product.getDescription(), product.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
