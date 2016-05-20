package com.ixzus.xpro.ui.fragment;

import android.app.Fragment;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ixzus.xpro.R;
import com.ixzus.xpro.entity.HomeItem;
import com.ixzus.xpro.http.HttpMethods;
import com.ixzus.xpro.http.subscribers.ProgressSubscriber;
import com.ixzus.xpro.http.subscribers.SubscriberOnNextListener;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class NetFragment extends Fragment {

    private SubscriberOnNextListener subscriberOnNext;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    @Bind(R.id.tv_info)
    TextView tvInfo;

    private String mParam1;
    private String mParam2;

    private OnNetFragmentInteractionListener mListener;

    public NetFragment() {
        // Required empty public constructor
    }

    public static NetFragment newInstance(String param1, String param2) {
        NetFragment fragment = new NetFragment();
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
        View view = inflater.inflate(R.layout.fragment_net, container, false);
        ButterKnife.bind(this, view);
        getHomeItem();
        return view;
    }

    //进行网络请求
    private void getHomeItem(){
        subscriberOnNext = new SubscriberOnNextListener<List<HomeItem>>() {
            @Override
            public void onNext(List<HomeItem> subjects) {
                tvInfo.setText(subjects.get(0).getImgUrl());
            }
        };
        HttpMethods.getInstance().getHomeItem(new ProgressSubscriber(subscriberOnNext, getActivity()), 1, 1,20);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onNetFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnNetFragmentInteractionListener) {
            mListener = (OnNetFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public interface OnNetFragmentInteractionListener {
        // TODO: Update argument type and name
        void onNetFragmentInteraction(Uri uri);
    }
}
