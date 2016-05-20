package com.ixzus.xpro.ui.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.ixzus.xlib.imageloader.ImageLoader;
import com.ixzus.xlib.imageloader.ImageLoaderUtil;
import com.ixzus.xpro.R;
import com.ixzus.xpro.entity.HomeItem;
import com.ixzus.xpro.utils.StrUtils;

import org.byteam.superadapter.IMulItemViewType;
import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.internal.SuperViewHolder;

import java.util.List;

/**
 * Created by metro on 2016/5/20.
 * 描述:
 */
public class HomeItemAdapter extends SuperAdapter<HomeItem> {
    public HomeItemAdapter(Context context, List<HomeItem> items, IMulItemViewType<HomeItem> multiItemViewType) {
        super(context, items, multiItemViewType);
    }

    public void updateItem(List<HomeItem> items) {
        mList = items;
        notifyDataSetChanged();
    }
    public void addItem(List<HomeItem> items) {
        int position = mList.size();
        mList.addAll(items);
       notifyItemInserted(position);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, HomeItem item) {
        switch (viewType) {
            case 1:
                String url = item.getImgUrl();
                ImageLoader imageLoader = new ImageLoader.Builder().url(StrUtils.dealImgUrl(url)).imgView((ImageView) holder.getView(R.id.index_url_iv)).build();
                ImageLoaderUtil.getInstance().loadImage(mContext, imageLoader);
                break;
            case 2:
                String url2 = item.getImgUrl();
                ImageLoader imageLoader2 = new ImageLoader.Builder().url(StrUtils.dealImgUrl(url2)).imgView((ImageView) holder.getView(R.id.index_article_iv)).build();
                ImageLoaderUtil.getInstance().loadImage(mContext, imageLoader2);
//                holder.setText(R.id.index_article_title,item.getTitle());
                break;
            case 3:
                String url3 = item.getImgUrl();
                ImageLoader imageLoader3 = new ImageLoader.Builder().url(StrUtils.dealImgUrl(url3)).imgView((ImageView) holder.getView(R.id.index_opus_iv)).build();
                ImageLoaderUtil.getInstance().loadImage(mContext, imageLoader3);
//                holder.setText(R.id.index_opus_title,item.getTitle());
                break;
        }
    }

    @Override
    protected IMulItemViewType<HomeItem> offerMultiItemViewType() {
        return new IMulItemViewType<HomeItem>() {
            @Override
            public int getViewTypeCount() {
                return 3;
            }

            @Override
            public int getItemViewType(int position, HomeItem item) {
                return item.getType();
            }

            @Override
            public int getLayoutId(int viewType) {
                if (1 == viewType)
                    return R.layout.rv_index_url;
                else if (2 == viewType)
                    return R.layout.rv_index_article;
                else
                    return R.layout.rv_index_opus;
            }
        };
    }
}
