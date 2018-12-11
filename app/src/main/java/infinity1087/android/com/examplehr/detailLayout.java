package infinity1087.android.com.examplehr;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import infinity1087.android.com.examplehr.adapter.RecyclerVeg;
import infinity1087.android.com.examplehr.model.ResponseDatum;

public class detailLayout extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerVeg mAdapter;
    private List<ResponseDatum> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_layout);
        Intent i = getIntent();
        mData = (List<ResponseDatum>) i.getSerializableExtra("yyy");
        Log.d("ttt", String.valueOf(mData));
        mRecyclerView = findViewById(R.id.recycler_view_detail);
        setUpRecyclerView(mData);

    }

    private void setUpRecyclerView(List<ResponseDatum> datumList) {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter=new RecyclerVeg(datumList);
        mRecyclerView.setAdapter(mAdapter);

    }
}
