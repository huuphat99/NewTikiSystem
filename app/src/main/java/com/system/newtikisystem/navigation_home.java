package com.system.newtikisystem;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smarteist.autoimageslider.SliderView;
import com.system.newtikisystem.controller.ImageSliderAdapter;
import com.system.newtikisystem.controller.TopProductAdapter;
import com.system.newtikisystem.entity.ImageSliderModel;
import com.system.newtikisystem.entity.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link navigation_home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class navigation_home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    SliderView sliderView;
    List<ImageSliderModel> imageSliderModelList;

    //top sale
    RecyclerView topSaleRecyclerView;
    TopProductAdapter topSaleProductAdapter;
    List<Product> topSaleProductList;

    //top new
    RecyclerView topNewRecyclerView;
    TopProductAdapter topNewProductAdapter;
    List<Product> topNewProductList;

    //top selled
    RecyclerView topSellRecyclerView;
    TopProductAdapter topSellProductAdapter;
    List<Product> topSellProductList;
    //top selled 1
    RecyclerView topSell1RecyclerView;
    TopProductAdapter topSell1ProductAdapter;
    List<Product> topSell1ProductList;



    public navigation_home() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //ads auto slider
        imageSliderModelList = new ArrayList<>();
        sliderView = getView().findViewById(R.id.imageSlider);

        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideshow_1));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideshow_4));
        imageSliderModelList.add(new ImageSliderModel(R.drawable.slideshow_1));

        sliderView.setSliderAdapter(new ImageSliderAdapter(getActivity(),imageSliderModelList));

        //top sale
        topSaleRecyclerView = getView().findViewById(R.id.topSaleRecycler);

        topSaleProductList = new ArrayList<>();
        topSaleProductList.add(new Product(1,R.drawable.dell1));
        topSaleProductList.add(new Product(2,R.drawable.dell2));
        topSaleProductList.add(new Product(3,R.drawable.dell1));
        topSaleProductList.add(new Product(4,R.drawable.dell2));
        topSaleProductList.add(new Product(4,R.drawable.dell1));
        topSaleProductList.add(new Product(4,R.drawable.dell2));
        setTopSaleRecycler((ArrayList<Product>) topSaleProductList);

        //topNew
        topNewRecyclerView =  getView().findViewById(R.id.topNewRecycler);

        topNewProductList = new ArrayList<>();
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        topNewProductList.add(new Product(1,R.drawable.lenovo1));
        setTopNewRecycler((ArrayList<Product>) topNewProductList);

        //top Sell
        topSellRecyclerView = getView().findViewById(R.id.topSellRecycler);

        topSellProductList = new ArrayList<>();
        topSellProductList.add(new Product(1,R.drawable.msi1));
        topSellProductList.add(new Product(2,R.drawable.msi1));
        topSellProductList.add(new Product(3,R.drawable.msi1));
        topSellProductList.add(new Product(4,R.drawable.msi1));
        topSellProductList.add(new Product(4,R.drawable.msi1));
        topSellProductList.add(new Product(4,R.drawable.msi1));
        setTopSellRecycler((ArrayList<Product>) topSellProductList);

    }

    private void setTopSellRecycler(ArrayList<Product> topSellProductList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);//truot ngang hay doc
        topSellRecyclerView.setLayoutManager(layoutManager);
        topSellProductAdapter = new TopProductAdapter(getActivity(), topSellProductList);
        topSellRecyclerView.setAdapter(topSellProductAdapter);
    }

    private void setTopSell1Recycler(ArrayList<Product> topSellProductList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);//truot ngang hay doc
        topSell1RecyclerView.setLayoutManager(layoutManager);
        topSell1ProductAdapter = new TopProductAdapter(getActivity(), topSellProductList);
        topSell1RecyclerView.setAdapter(topSell1ProductAdapter);
    }

    private void setTopNewRecycler(ArrayList<Product> topNewproductList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);//truot ngang hay doc
        topNewRecyclerView.setLayoutManager(layoutManager);
        topNewProductAdapter = new TopProductAdapter(getActivity(), topNewproductList);
        topNewRecyclerView.setAdapter(topNewProductAdapter);
    }

    private void setTopSaleRecycler(ArrayList<Product> productList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);//truot ngang hay doc
        topSaleRecyclerView.setLayoutManager(layoutManager);
        topSaleProductAdapter = new TopProductAdapter(getActivity(), productList);
        topSaleRecyclerView.setAdapter(topSaleProductAdapter);
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment navigation_home.
     */
    // TODO: Rename and change types and number of parameters
    public static navigation_home newInstance(String param1, String param2) {
        navigation_home fragment = new navigation_home();
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
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navigation_home, container, false);
    }
}