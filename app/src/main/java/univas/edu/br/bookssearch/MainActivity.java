package univas.edu.br.bookssearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import univas.edu.br.bookssearch.web.WebTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        configureButtons();
    }

    private void configureButtons() {
        Button searchButton = (Button) super.findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //WebTask task = new WebTask(getApplicationContext(), textWeb);
                //task.execute();
            }
        });

        Button listLikedBooksBtn = (Button) super.findViewById(R.id.listLikedBooksBtn);
        listLikedBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListLikedBooksActivity.class);
                startActivity(intent);
            }
        });

        Button listUnlikedBooksBtn = (Button) super.findViewById(R.id.listUnlikedBooksBtn);
        listUnlikedBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListUnlikedBooksActivity.class);
                startActivity(intent);
            }
        });

        Button listFetchedBooksBtn = (Button) super.findViewById(R.id.listFetchedBooksBtn);
        listFetchedBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListFetchedBooksActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
