package com.andevcba.materializeme.presentation.main.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.andevcba.materializeme.R;
import com.andevcba.materializeme.presentation.main.adapter.PatternsAdapter;
import com.andevcba.materializeme.domain.model.Pattern;

import java.util.List;

public class PatternsFragment extends Fragment implements PatternsFragmentContract.View {

    private static final String COLUMN_COUNT = "column-count";

    PatternsFragmentContract.Presenter presenter;

    private OnListFragmentInteractionListener listener;
    private RecyclerView recyclerView;
    private Context context;

    public PatternsFragment() {
    }

    @SuppressWarnings("unused")
    public static PatternsFragment newInstance(int columnCount) {
        PatternsFragment fragment = new PatternsFragment();
        Bundle args = new Bundle();
        args.putInt(COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);

        context = getContext();
        presenter = new PatternsFragmentPresenter(this);

        if (getArguments() != null) {
            presenter.setColumnCount(getArguments().getInt(COLUMN_COUNT));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item_list, container, false);

        if (view instanceof RecyclerView) {
            recyclerView = (RecyclerView) view;

            presenter.chooseLayoutColumns();

            presenter.loadData();
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            listener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void setAdapter(List<Pattern> patterns) {
        recyclerView.setAdapter(new PatternsAdapter(context, patterns, listener));
    }

    @Override
    public void setLinearLayout() {
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
    }

    @Override
    public void setGridLayout(int columnCount) {
        recyclerView.setLayoutManager(new GridLayoutManager(context, columnCount));
    }

    @Override
    public int getLinearDrawable() {
        return R.drawable.ic_view_list;
    }

    @Override
    public int getGridDrawable() {
        return R.drawable.ic_view_grid;
    }

    public interface OnListFragmentInteractionListener {
        void onListFragmentInteraction(Pattern pattern);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main_activity, menu);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        menu.findItem(R.id.layout_state).setIcon(presenter.chooseMenuLayoutItemDrawable());

        super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.layout_state) {
            presenter.changeLayoutDesign();
            item.setIcon(presenter.chooseMenuLayoutItemDrawable());
        }

        return super.onOptionsItemSelected(item);
    }
}
