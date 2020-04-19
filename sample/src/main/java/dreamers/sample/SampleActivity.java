package dreamers.sample;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;

import codetail.graphics.drawables.DrawableHotspotTouch;
import codetail.graphics.drawables.LollipopDrawable;
import codetail.graphics.drawables.LollipopDrawablesCompat;

public class SampleActivity extends Activity {

    private ListView mListView;
    private FloatingActionButton mActionButton;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        mListView = (ListView) findViewById(R.id.list);
        mListView.setSelector(getDrawable2(R.drawable.list_selector));
        mListView.setAdapter(new ListAdapter());

        mActionButton = (FloatingActionButton) findViewById(R.id.fab);
        mActionButton.setBackgroundDrawable(getDrawable2(R.drawable.fab_background));
        mActionButton.setClickable(true);

        mActionButton.setOnTouchListener(
                new DrawableHotspotTouch((LollipopDrawable) mActionButton.getBackground()));
    }

    /**
     * {@link #getDrawable(int)} is already taken by Android API
     * and method is final, so we need to give another name :(
     */
    public Drawable getDrawable2(int id){
        return LollipopDrawablesCompat.getDrawable(getResources(), id, getTheme());
    }

    static class ListAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 100;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null){
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item, parent, false);
            }

            return convertView;
        }
    }

}
