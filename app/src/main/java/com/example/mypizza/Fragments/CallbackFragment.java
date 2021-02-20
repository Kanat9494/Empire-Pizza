package com.example.mypizza.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mypizza.R;
import com.example.mypizza.adapter.MainRecyclerAdapter;
import com.example.mypizza.model.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CallbackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CallbackFragment extends Fragment {

    View v;
    RecyclerView recyclerView;
    List<Model> mList;
    MainRecyclerAdapter mainRecyclerAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CallbackFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CallbackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CallbackFragment newInstance(String param1, String param2) {
        CallbackFragment fragment = new CallbackFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mList = new ArrayList<>();
        mList.add(new Model(R.drawable.news_image, "Title"));
        mList.add(new Model(R.drawable.news_image, "Title"));
        mList.add(new Model(R.drawable.news_image, "Title"));
        mList.add(new Model(R.drawable.news_image, "Title"));
        mList.add(new Model(R.drawable.news_image, "Title"));
        mList.add(new Model(R.drawable.news_image, "Title"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_callback, container, false);
        recyclerView=v.findViewById(R.id.rv);
        mainRecyclerAdapter = new MainRecyclerAdapter(mList, getContext());
        recyclerView.setAdapter(mainRecyclerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;

    }


}