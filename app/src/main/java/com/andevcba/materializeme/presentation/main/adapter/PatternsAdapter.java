package com.andevcba.materializeme.presentation.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.andevcba.materializeme.R;
import com.andevcba.materializeme.presentation.main.fragment.PatternsFragment.OnListFragmentInteractionListener;
import com.andevcba.materializeme.domain.model.Pattern;
import com.squareup.picasso.Picasso;

import java.util.List;;

public class PatternsAdapter extends RecyclerView.Adapter<PatternsAdapter.ViewHolder> implements PatternsAdapterContract.View {

    private PatternsAdapterContract.Presenter presenter;
    private List<Pattern> patterns;
    private OnListFragmentInteractionListener listener;
    private Context context;

    public PatternsAdapter(Context context, List<Pattern> patterns, OnListFragmentInteractionListener listener) {
        this.presenter = new PatternsAdapterPresenter(this);
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
                presenter.patternSelected(listener, patterns.get(holder.getAdapterPosition()));
            }
        });

        Picasso.with(context).load(presenter.getDrawableForPattern(pattern)).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return patterns.size();
    }

    @Override
    public void patternSelected(Pattern pattern) {
        listener.onListFragmentInteraction(pattern);
    }

    @Override
    public int getNavDrawerDrawable() {
        return R.drawable.nav_drawer;
    }

    @Override
    public int getNavNestedDrawable() {
        return R.drawable.nav_nested;
    }

    @Override
    public int getNavExpandingDrawable() {
        return R.drawable.nav_expanding;
    }

    @Override
    public int getNavBottomDrawable() {
        return R.drawable.nav_bottom;
    }

    @Override
    public int getNavTabsDrawable() {
        return R.drawable.nav_tabs;
    }

    @Override
    public int getNavEmbeddedDrawable() {
        return R.drawable.nav_embedded;
    }

    @Override
    public int getNavGesturalDrawable() {
        return R.drawable.nav_gestural;
    }

    @Override
    public int getNavInContextDrawable() {
        return R.drawable.nav_incontext;
    }

    @Override
    public int getNavDrawerTabsDrawable() {
        return R.drawable.nav_drawer_tabs;
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
