package com.system.newtikisystem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.system.newtikisystem.controller.RecyclerAdapterSubCategory;
import com.system.newtikisystem.dao.CategoryDAO;
import com.system.newtikisystem.entity.Subcategories;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link listSubCategory#newInstance} factory method to
 * create an instance of this fragment.
 */
public class listSubCategory extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public listSubCategory() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment catogory_right.
     */
    // TODO: Rename and change types and number of parameters
    public static listSubCategory newInstance(String param1, String param2) {
        listSubCategory fragment = new listSubCategory();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_category_right, container, false);
    }

    RecyclerView recyclerView;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recyclerViewSubCategory);
        CategoryDAO categoryDAO = new CategoryDAO();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int cId = bundle.getInt("cId");
            ArrayList<Subcategories> categories = categoryDAO.getListSubCategoryByCategoryID(cId);
            RecyclerAdapterSubCategory adapter = new RecyclerAdapterSubCategory(categories);
            recyclerView.setAdapter(adapter);
            GridLayoutManager layoutManager = new GridLayoutManager(view.getContext(), 3);
            recyclerView.setLayoutManager(layoutManager);
        }
    }
}