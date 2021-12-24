package com.amjad.school.adapter;

import android.content.Context;
import android.icu.util.ULocale;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.amjad.school.R;
import com.amjad.school.ui.fragment.Category;

import java.util.ArrayList;
import java.util.Locale;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.VweHolder> {



    private Context context;
    private ArrayList<Category> categoryArrayList;

    public CategoryAdapter(Context context, ArrayList<Category> categoryArrayList) {
        this.context = context;
        this.categoryArrayList = categoryArrayList;
    }

    public CategoryAdapter(Object context, ArrayList<Category> categoryArrayList) {
    }

    @NonNull
    @Override
    public CategoryAdapter.VweHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.category_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.VweHolder holder, int position) {
        Category currentCategry = categoryArrayList.get(position);
    holder.image.setImageResource(currentCategry.getImange());
    holder.title.setText(currentCategry.getTittle());
    holder.subtitle.setText(currentCategry.getSupTitle());
    }

    @Override
    public int getItemCount()
    {
        return categoryArrayList.size();
    }

    public class VweHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title,subtitle;

        public VweHolder(@NonNull View itemView) {

            super(itemView);
            image = itemView.findViewById(R.id.imageView_category);
            title = itemView.findViewById(R.id.textView_title);
            subtitle = itemView.findViewById(R.id.textView_sub_title);
        }
        }
        }
    }
}