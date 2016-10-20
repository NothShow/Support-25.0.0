package com.chenenyu.support_2500;

import android.content.Context;

import org.byteam.superadapter.SuperAdapter;
import org.byteam.superadapter.SuperViewHolder;

import java.util.List;

/**
 * <p>
 * Created by Cheney on 2016/10/20.
 */
public class AppInfoAdapter extends SuperAdapter<AppInfo> {

    public AppInfoAdapter(Context context, List<AppInfo> items, int layoutResId) {
        super(context, items, layoutResId);
    }

    @Override
    public void onBind(SuperViewHolder holder, int viewType, int layoutPosition, AppInfo item) {
        holder.setImageDrawable(R.id.icon, item.icon);
        holder.setText(R.id.label, item.label);
        holder.setText(R.id.package_name, item.packageName);
    }
}
