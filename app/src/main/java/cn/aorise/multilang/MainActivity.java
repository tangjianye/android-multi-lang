package cn.aorise.multilang;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void changeLocal(Locale local) {
        setAppLocal(local);
        restartApp();
    }

    private void restartApp() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        this.startActivity(intent);

        // 杀掉进程
        // android.os.Process.killProcess(android.os.Process.myPid());
        // System.exit(0);
    }

    private void setAppLocal(Locale local) {
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        Configuration config = resources.getConfiguration();
        // 应用用户选择语言
        config.locale = local;
        resources.updateConfiguration(config, dm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_lang, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.en_lang:
                changeLocal(Locale.ENGLISH);
                return true;
            case R.id.jp_lang:
                changeLocal(Locale.JAPANESE);
                return true;
            case R.id.ch_lang:
                changeLocal(Locale.SIMPLIFIED_CHINESE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

