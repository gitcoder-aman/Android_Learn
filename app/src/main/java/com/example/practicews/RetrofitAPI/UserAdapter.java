package com.example.practicews.RetrofitAPI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.practicews.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserHolder> {

    Context context;
    List<UserModelOfAPI>allUserList;

    public UserAdapter(Context context, List<UserModelOfAPI> allUserList) {
        this.context = context;
        this.allUserList = allUserList;
    }

    @NonNull
    @Override
    public UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserHolder(LayoutInflater.from(context).inflate(R.layout.item_user_for_api,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserHolder holder, int position) {

        holder.textView.setText(allUserList.get(position).getTitle());
    }


    @Override
    public int getItemCount() {
        return allUserList.size();
    }
    class UserHolder extends RecyclerView.ViewHolder{

        TextView textView;
        public UserHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.itemText);

        }
    }
}
