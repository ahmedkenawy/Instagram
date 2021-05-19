package com.ahmedkenawy.instagram.Adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmedkenawy.instagram.Fragment.PostDetailFragment;
import com.ahmedkenawy.instagram.Model.Post;
import com.ahmedkenawy.instagram.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PhotosAdapter extends RecyclerView.Adapter<PhotosAdapter.PhotoViewHolder> {

    private Context mContext;
    private List<Post> posts;

    public PhotosAdapter(Context mContext, List<Post> posts) {
        this.mContext = mContext;
        this.posts = posts;
    }

    @NonNull
    @Override
    public PhotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.phot_item, null, false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PhotoViewHolder holder, int position) {
        Post post = posts.get(position);
        Glide.with(mContext).load(post.getPostimage()).into(holder.photoIV);
        holder.photoIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = mContext.getSharedPreferences("PREFS", Context.MODE_PRIVATE).edit();
                editor.putString("postid", post.getPostid());
                editor.apply();
                ((FragmentActivity) mContext).getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_container, new PostDetailFragment()).commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView photoIV;

        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            photoIV = itemView.findViewById(R.id.photoIV);
        }
    }
}
