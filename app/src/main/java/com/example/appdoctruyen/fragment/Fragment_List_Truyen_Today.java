package com.example.appdoctruyen.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.appdoctruyen.R;
import com.example.appdoctruyen.activity.ListTruyenTodayActivity;
import com.example.appdoctruyen.adapter.ListTruyenTodayAdapter;
import com.example.appdoctruyen.model.ListTruyenToday;
import com.example.appdoctruyen.service.ApiService;
import com.example.appdoctruyen.service.DataService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Fragment_List_Truyen_Today extends Fragment {

    View view;
    ListView listView;
    TextView textView;
    ListTruyenTodayAdapter listTruyenTodayAdapter;
    ArrayList<ListTruyenToday> listTruyenToday;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_list_truyen_today,container,false);
        listView = view.findViewById(R.id.lvListTruyenToday);
        textView = view.findViewById(R.id.tvAllListTruyenToday);
        getData();
        return view;
    }

    private void getData() {
        DataService dataService = ApiService.getService();

        Call<List<ListTruyenToday>> callBack = dataService.getListTruyenToday();

        callBack.enqueue(new Callback<List<ListTruyenToday>>() {
            @Override
            public void onResponse(Call<List<ListTruyenToday>> call, Response<List<ListTruyenToday>> response) {
                listTruyenToday  = (ArrayList<ListTruyenToday>) response.body();
                //Log.d("BBB",listTruyenToday.get(0).getTen());
                textView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), ListTruyenTodayActivity.class);
                        startActivity(intent);
                    }
                });
                listTruyenTodayAdapter = new ListTruyenTodayAdapter(getActivity(),android.R.layout.simple_list_item_1,listTruyenToday);
                listView.setAdapter(listTruyenTodayAdapter);
                //set lai chieu cao list vieww
                setListViewHeightBasedOnChildren(listView);
            }

            @Override
            public void onFailure(Call<List<ListTruyenToday>> call, Throwable t) {

            }
        });
    }
    public void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = listView.getPaddingTop() + listView.getPaddingBottom();
        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.AT_MOST);
        for (int i = 0; i < listAdapter.getCount(); i++) {
            View listItem = listAdapter.getView(i, null, listView);

            if(listItem != null){
                // This next line is needed before you call measure or else you won't get measured height at all. The listitem needs to be drawn first to know the height.
                listItem.setLayoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
                listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
                totalHeight += listItem.getMeasuredHeight();

            }
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
    }
}