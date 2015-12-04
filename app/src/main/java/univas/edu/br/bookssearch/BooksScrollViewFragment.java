package univas.edu.br.bookssearch;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by nicolas on 01/12/15.
 */
public class BooksScrollViewFragment extends Fragment {

    public static final String EXTRA_MESSAGE = "EXTRA_MESSAGE";

    public static final BooksScrollViewFragment newInstance(String message) {
        BooksScrollViewFragment f = new BooksScrollViewFragment();
        Bundle bdl = new Bundle(1);
        bdl.putString(EXTRA_MESSAGE, message);
        f.setArguments(bdl);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        String message = getArguments().getString(EXTRA_MESSAGE);
        View v = inflater.inflate(R.layout.books_informations, container, false);
        TextView messageTextView = (TextView) v.findViewById(R.id.textView);
        messageTextView.setText(message);
        return v;
    }
}
