package com.example.phonebookapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.phonebookapp.databinding.ProfileItemBinding;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context context;
    
    private List<User> user;
    
    public MyAdapter(Context context, List<User> user) {
        this.context = context;
        this.user = user;
    }
    
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder( 
                ProfileItemBinding.inflate(LayoutInflater.from(context), parent, false)
        );
    }

    
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            User getUser = user.get(position);
            holder.profileItemBinding.setUser(getUser);
    }

    
    @Override
    public int getItemCount() {
        if (user != null) {
            return user.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private final ProfileItemBinding profileItemBinding;
        
        public MyViewHolder(ProfileItemBinding profileItemBinding) {
            super(profileItemBinding.getRoot());
            this.profileItemBinding = profileItemBinding;
        }
    }
}
