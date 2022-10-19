
package com.example.cstgravience;

        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;
        import androidx.recyclerview.widget.LinearLayoutManager;
        import androidx.recyclerview.widget.RecyclerView;

        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DataSnapshot;
        import com.google.firebase.database.DatabaseError;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.google.firebase.database.Query;
        import com.google.firebase.database.ValueEventListener;

        import java.util.ArrayList;

public class Starred extends AppCompatActivity {
    ArrayList<StarredDataModel> GStarredList;
    private RecyclerView Starred_recyclerV;
    private StarredAdapter GStarred_Adapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starred);

       GStarredList = new ArrayList<>();
        Starred_recyclerV = findViewById(R.id.Starred_RecyclerV);
        Starred_recyclerV.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        GStarred_Adapter = new StarredAdapter(GStarredList);
        Starred_recyclerV.setAdapter(GStarred_Adapter);
        dataInitialize();

        Starred_recyclerV.setLayoutManager(mLayoutManager);

    }

    private void dataInitialize() {
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseUser cUser = FirebaseAuth.getInstance().getCurrentUser();

        String uID = cUser.getUid();
        String uEmail = cUser.getEmail();
        DatabaseReference A_databaseReference = firebaseDatabase.getReference("starred");
        Query query = A_databaseReference.orderByChild("cuEmail").equalTo(uEmail);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    StarredDataModel datamodel = dataSnapshot.getValue(com.example.cstgravience.StarredDataModel.class);
                    GStarredList.add(datamodel);
                }
                GStarred_Adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
