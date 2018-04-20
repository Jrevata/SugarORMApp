package app.sugarorm.jrevata.sugarormapp.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import app.sugarorm.jrevata.sugarormapp.R;
import app.sugarorm.jrevata.sugarormapp.adapters.UserAdapter;
import app.sugarorm.jrevata.sugarormapp.models.User;
import app.sugarorm.jrevata.sugarormapp.repositories.UserRepository;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private static final int REGISTER_FORM_REQUEST = 100;

    private RecyclerView userList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList = findViewById(R.id.user_list);
        userList.setLayoutManager(new LinearLayoutManager(this));

        List<User> users = UserRepository.list();
        userList.setAdapter(new UserAdapter(users));
    }

    public void callRegisterForm(View view){
        startActivityForResult(new Intent(this, RegisterActivity.class), REGISTER_FORM_REQUEST);
    }

    // return from RegisterActivity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // refresh data
        UserAdapter adapter = (UserAdapter)userList.getAdapter();

        List<User> users = UserRepository.list();
        adapter.setUsers(users);
        adapter.notifyDataSetChanged();

    }


}
