package com.myproject.medina;
 
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery ;
import android.widget.ImageView;
import android.widget.Toast;
 
@SuppressWarnings("deprecation")
public class TasteTunisianFood extends Activity {
    
    //the images to display
    Integer[] imageIDs = {
    R.drawable.img1,
    R.drawable.img2,
    R.drawable.img3,
    R.drawable.img4,
    R.drawable.img5,
    R.drawable.img6,
    R.drawable.img7,
    R.drawable.img8,
    R.drawable.img9,
    R.drawable.img10,
    R.drawable.img11,
    R.drawable.img12,
    R.drawable.img13,
    R.drawable.img14,
    R.drawable.img15,
    R.drawable.img16,
    R.drawable.img17,
    R.drawable.img18,
    R.drawable.img19,
    R.drawable.img20,
    R.drawable.img21,
    R.drawable.img22,
    R.drawable.img23,
    R.drawable.img24,
    R.drawable.img25,
    R.drawable.img26,
    R.drawable.img27,
    R.drawable.img28,
    R.drawable.img29,
    R.drawable.img30,
   };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.food);
        
            // Note that Gallery view is deprecated in Android 4.1---
            Gallery gallery = (Gallery) findViewById(R.id.gallery1);
            gallery.setAdapter(new ImageAdapter(this));
            gallery.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> parent, View v, int position,long id)
        {//on crée un tableau de chaine des noms des plats
                    Toast.makeText(getBaseContext(),"pic" + (position + 1) + " selected",
                            Toast.LENGTH_SHORT).show();
                    // display the images selected
                    ImageView imageView = (ImageView) findViewById(R.id.image1);
                    imageView.setImageResource(imageIDs[position]);
            }
        });
    }
 
    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c;
            // sets a grey background; wraps around the images
            TypedArray a =obtainStyledAttributes(R.styleable.MyGallery);
            itemBackground = a.getResourceId(R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }
        // returns the number of images
        public int getCount() {
            return imageIDs.length;
        }
        // returns the ID of an item
        public Object getItem(int position) {
            return position;
        }
        // returns the ID of an item
        public long getItemId(int position) {
            return position;
        }
        // returns an ImageView view
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]);
            imageView.setLayoutParams(new Gallery.LayoutParams(300, 300));
            imageView.setBackgroundResource(itemBackground);
            return imageView;
        }
    }
}