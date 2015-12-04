package univas.edu.br.bookssearch;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import univas.edu.br.bookssearch.model.Book;

/**
 * Created by nicolas on 01/12/15.
 */
public class ListFetchedBooksActivity extends FragmentActivity {

    private static final String TAG = ListFetchedBooksActivity.class.getSimpleName();

    private ViewPager mPager;

    private MyPageAdapter mPagerAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fetched_books);

        ArrayList<Book> booksList = getIntent().getParcelableArrayListExtra("books");

        List<Fragment> fragments = getFragments(booksList);
        mPagerAdapter = new MyPageAdapter(getSupportFragmentManager(), fragments);

        mPager = (ViewPager) findViewById(R.id.fetchedPager);
        mPager.setPageTransformer(true, new ZoomOutPageTransformer());
        mPager.setAdapter(mPagerAdapter);

        configureButtons();
    }


    private List<Fragment> getFragments(List<Book> booksList) {

        List<Fragment> fList = new ArrayList<Fragment>();

        for (Book book : booksList) {
            StringBuilder txtBook = new StringBuilder("");
            txtBook.append("Nome: " + book.getTitle());
            txtBook.append("\n\nNum. Páginas: " + (book.getPageCount() != null ? book.getPageCount() : "Sem Informações"));
            txtBook.append("\n\nEditora: " + (book.getPublisher() != null ? book.getPublisher() : "Sem Informações"));
            txtBook.append("\n\nLink :" + book.getInfoLink());
            fList.add(BooksScrollViewFragment.newInstance(txtBook.toString()));
        }

        return fList;
    }

    @Override
    public void onBackPressed() {
        if (mPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }

    private void configureButtons() {
        Button goHome = (Button) super.findViewById(R.id.fetched_to_homeBtn);
        goHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button like = (Button) super.findViewById(R.id.like);
        like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = getBookInView();
            }
        });

        Button unlike = (Button) super.findViewById(R.id.unlike);
        unlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = getBookInView();
            }
        });
    }

    private class MyPageAdapter extends FragmentPagerAdapter {
        private List<Fragment> fragments;

        public MyPageAdapter(FragmentManager fm, List<Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public Fragment getItem(int position) {
            return this.fragments.get(position);
        }

        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }

    private Book getBookInView(){
        TextView messageTextView = (TextView) findViewById(R.id.textView);
        Log.d(TAG, "Valores: " + messageTextView.getText());
        return null;
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
