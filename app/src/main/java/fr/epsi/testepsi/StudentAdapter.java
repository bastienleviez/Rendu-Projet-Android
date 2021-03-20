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

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {
    EpsiActivity activity;
    ArrayList<Student> students;

    public StudentAdapter(EpsiActivity activity, ArrayList<Student> students){
        this.activity=activity;
        this.students=students;
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewName;
        private final TextView textViewEmail;
        private final ImageView imageViewStudent;
        private final View layoutCellStudent;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            textViewName = view.findViewById(R.id.textViewName);
            textViewEmail = view.findViewById(R.id.textViewEmail);
            imageViewStudent = view.findViewById(R.id.imageViewStudent);
            layoutCellStudent = view.findViewById(R.id.layoutCellStudent);
        }

        public TextView getTextViewName() {
            return textViewName;
        }
        public TextView getTextViewEmail() {
            return textViewEmail;
        }
        public ImageView getImageViewStudent() {
            return imageViewStudent;
        }
        public View getLayoutCellStudent() {
            return layoutCellStudent;
        }
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.cell_student, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Student student=students.get(position);
        holder.getTextViewName().setText(student.getName());
        holder.getTextViewEmail().setText(student.getEmail());
        Picasso.get().load(student.getUrl()).into(holder.getImageViewStudent());
        holder.getLayoutCellStudent().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfilActivity.displayActivity(activity,student.getUrl(),student.getEmail(), student.getName());
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
