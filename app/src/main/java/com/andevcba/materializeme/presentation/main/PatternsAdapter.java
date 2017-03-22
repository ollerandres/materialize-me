package com.andevcba.materializeme.presentation.main;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andevcba.materializeme.R;
import com.andevcba.materializeme.presentation.main.PatternsFragment.OnListFragmentInteractionListener;
import com.andevcba.materializeme.presentation.main.model.Pattern;

import java.util.List;

import static com.squareup.picasso.Picasso.*;

public class PatternsAdapter extends RecyclerView.Adapter<PatternsAdapter.ViewHolder> {

    private List<Pattern> patterns;
    private OnListFragmentInteractionListener listener;
    private Context context;

    public PatternsAdapter(Context context, List<Pattern> patterns, OnListFragmentInteractionListener listener) {
        this.patterns = patterns;
        this.listener = listener;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Pattern pattern = patterns.get(position);

        holder.name.setText(pattern.getName());
        holder.description.setText(pattern.getShortDescription());

        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onListFragmentInteraction(patterns.get(holder.getAdapterPosition()));
                }
            }
        });

        int drawable = 0;
        int backgroundColor = 0;

        switch (Integer.valueOf(pattern.getId())) {
            case 0:
                drawable = R.drawable.nav_drawer;
                backgroundColor = R.color.md_green_500;
                break;
            case 1:
                drawable = R.drawable.nav_nested;
                backgroundColor = R.color.md_light_blue_500;
                break;
            case 2:
                drawable = R.drawable.nav_expanding;
                backgroundColor = R.color.md_blue_grey_500;
                break;
            case 3:
                drawable = R.drawable.nav_bottom;
                backgroundColor = R.color.md_cyan_500;
                break;
            case 4:
                drawable = R.drawable.nav_tabs;
                backgroundColor = R.color.md_deep_orange_500;
                break;
            case 5:
                drawable = R.drawable.nav_embedded;
                backgroundColor = R.color.md_deep_purple_500;
                break;
            case 6:
                drawable = R.drawable.nav_gestural;
                backgroundColor = R.color.md_lime_500;
                break;
            case 7:
                drawable = R.drawable.navi_incontext;
                backgroundColor = R.color.md_purple_500;
                break;
            case 8:
                drawable = R.drawable.side_nav_bar;
                backgroundColor = R.color.md_light_green_500;
                break;
        }

        with(context).load(drawable).into(holder.image);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            holder.view.setBackgroundColor(context.getColor(backgroundColor));
        } else {
            holder.view.setBackgroundColor(context.getResources().getColor(backgroundColor));
        }
    }

    @Override
    public int getItemCount() {
        return patterns.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View view;
        public TextView name;
        public TextView description;
        public ImageView image;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            name = (TextView) view.findViewById(R.id.tv_name);
            description = (TextView) view.findViewById(R.id.tv_description);
            image = (ImageView) view.findViewById(R.id.iv_pattern);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + name.getText() + "'";
        }
    }
}
