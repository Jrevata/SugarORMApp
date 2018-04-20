package app.sugarorm.jrevata.sugarormapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import app.sugarorm.jrevata.sugarormapp.R;
import app.sugarorm.jrevata.sugarormapp.models.User;

/**
 * Created by JORDAN on 19/04/2018.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    private List<User> users;

    public UserAdapter(List<User> users){
        this.users = users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView picture;
        public TextView fullname;
        public TextView email;

        public ViewHolder(View itemView){
            super(itemView);
            picture = itemView.findViewById(R.id.picture_image);
            fullname = itemView.findViewById(R.id.fullname_text);
            email = itemView.findViewById(R.id.email_text);
        }


    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        User user = this.users.get(position);
        holder.fullname.setText(user.getFullname());
        holder.email.setText(user.getEmail());
    }

    @Override
    public int getItemCount() {
        return this.users.size();
    }


}
