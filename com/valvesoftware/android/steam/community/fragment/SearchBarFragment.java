package com.valvesoftware.android.steam.community.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.valvesoftware.android.steam.community.C0815R;
import com.valvesoftware.android.steam.community.activity.ActivityHelper;

public class SearchBarFragment extends Fragment {
    private EditText searchTextBox;
    private TextWatcher textWatcher;

    class C09121 implements OnClickListener {
        C09121() {
        }

        public void onClick(View view) {
            SearchBarFragment.this.closeSearch();
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(C0815R.layout.search_bar_fragment, container, false);
        Button closeButton = getCloseButton(fragmentView);
        this.searchTextBox = getSearchTextBox(fragmentView);
        if (this.textWatcher != null) {
            this.searchTextBox.addTextChangedListener(this.textWatcher);
        }
        closeButton.setOnClickListener(new C09121());
        return fragmentView;
    }

    public void openSearch() {
        setVisibility(0);
        this.searchTextBox.requestFocus();
        ActivityHelper.showKeyboard(getActivity());
    }

    public void closeSearch() {
        this.searchTextBox.setText("");
        setVisibility(8);
        ActivityHelper.hideKeyboard(getActivity());
    }

    private void setVisibility(int visibility) {
        View frameLayout = getView().findViewById(C0815R.id.list_search_bar);
        if (frameLayout != null) {
            frameLayout.setVisibility(visibility);
        } else {
            getView().setVisibility(visibility);
        }
    }

    public void setSearchTextChangedListener(TextWatcher textWatcher) {
        if (textWatcher != null) {
            this.textWatcher = textWatcher;
            if (this.searchTextBox != null) {
                this.searchTextBox.addTextChangedListener(this.textWatcher);
            }
        }
    }

    private EditText getSearchTextBox(View view) {
        return (EditText) view.findViewById(C0815R.id.search_bar_text);
    }

    private Button getCloseButton(View view) {
        return (Button) view.findViewById(C0815R.id.search_bar_close_button);
    }
}
