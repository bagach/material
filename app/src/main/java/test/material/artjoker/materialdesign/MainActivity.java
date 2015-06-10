package test.material.artjoker.materialdesign;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeader;
import com.mikepenz.materialdrawer.accountswitcher.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class MainActivity extends ActionBarActivity {

    private Toolbar toolbar;
    private Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        initializeDrawer();
    }

    @Override
    public void onBackPressed() {
        if (drawer != null && drawer.isDrawerOpen()) {
            drawer.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }

    private void initializeDrawer() {
        AccountHeader header = createAccountHeader();
        drawer = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(header)
                .withDisplayBelowToolbar(true)
                .withActionBarDrawerToggleAnimated(true)
                .addDrawerItems(initializeDrawerItems())
                .build();
    }

    private IDrawerItem[] initializeDrawerItems() {
        return new IDrawerItem[]{new PrimaryDrawerItem().withName(R.string.item1).withIdentifier(1).withIcon(R.drawable.ic_home_black_18dp),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withName(R.string.item2).withIcon(R.drawable.ic_add_shopping_cart_black_18dp),
                new SecondaryDrawerItem().withName(R.string.item3).withIcon(R.drawable.ic_note_add_black_18dp),
                new SecondaryDrawerItem().withName(R.string.item4).withIcon(R.drawable.ic_room_black_18dp),
                new SecondaryDrawerItem().withName(R.string.item5).withIcon(R.drawable.ic_announcement_black_18dp),
                new SecondaryDrawerItem().withName(R.string.item6).withIcon(R.drawable.ic_favorite_black_18dp),
                new DividerDrawerItem(),
                new SecondaryDrawerItem().withName(R.string.item7).withIcon(R.drawable.ic_exit_to_app_black_18dp)};
    }

    private AccountHeader createAccountHeader() {
        IProfile profile = new ProfileDrawerItem()
                .withName("Alexandr")
                .withEmail("bagach.alexandr@gmail.com")
                .withIcon(getResources().getDrawable(R.drawable.ic_face_black_18dp));

        return new AccountHeaderBuilder()
                    .withHeaderBackground(R.drawable.bcgrnd)
                    .withActivity(this)
                    .addProfiles(profile)
                    .build();
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
