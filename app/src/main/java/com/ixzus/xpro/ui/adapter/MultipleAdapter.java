package com.ixzus.xpro.ui.adapter;

import android.content.Context;

import com.ixzus.xpro.R;
import com.ixzus.xpro.entity.XBean;

import org.byteam.superadapter.IMulItemViewType;
import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.internal.SuperViewHolder;

import java.util.List;

public class MultipleAdapter extends SuperAdapter<XBean> {
    public MultipleAdapter(Context context, List<XBean> list, IMulItemViewType<XBean> multiItemViewType) {
        super(context, list, multiItemViewType);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, XBean item) {
        switch (viewType) {
            case 0:
                holder.setText(R.id.tv_name, item.getName());
                holder.setText(R.id.tv_pwd, item.getPwd());
                break;
            case 1:
                holder.setText(R.id.tv_name, item.getName());
                holder.setText(R.id.tv_pwd, item.getPwd());
                holder.setImageResource(R.id.iv_avatar, R.mipmap.ic_launcher);

                break;
        }
    }

    @Override
    protected IMulItemViewType<XBean> offerMultiItemViewType() {
        return new IMulItemViewType<XBean>() {
            @Override
            public int getViewTypeCount() {
                return 2;
            }

            @Override
            public int getItemViewType(int position, XBean xBean) {
                if (position % 2 == 0) {
                    return 0;
                }
                return 1;
            }

            @Override
            public int getLayoutId(int viewType) {
//                if (viewType == 0) {
//                    return R.layout.item_type_xbean;
//                }
                return R.layout.item_type_xbean_img;
            }
        };
    }
}
