package com.example.joel.ikeaapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    public static final String EXTRA_CATEGORY_PHOTO = "EXTRACATEGORY";

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    private static List<Furniture> FragmentItems = new ArrayList<>();

    private static String Bathroom = "Bathroom";
    private static String Kitchen = "Kitchen";
    private String Livingroom = "Livingroom";
    private String Bedroom = "Bedroom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_activity);

        Category categoryText = getIntent().getParcelableExtra(EXTRA_CATEGORY_PHOTO);
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter (getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        if (categoryText.getTitle().equals(Bathroom)){
            bathroomItems();
        } if(categoryText.getTitle().equals(Kitchen)) {
            kitchenItems();
        } if(categoryText.getTitle().equals(Livingroom)){
            livingroomItems();
        } if(categoryText.getTitle().equals(Bedroom)) {
            bedroomItems();
        }

        mSectionsPagerAdapter.notifyDataSetChanged();
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private Button sendBtn;
        private TextView title,price,madein,stock;

        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }
        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        //Populate the views

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.category_content, container, false);
            ImageView imageView = (ImageView) rootView.findViewById(R.id.fragmentImageView);
            title = (TextView) rootView.findViewById(R.id.titleTextView);
            price = (TextView) rootView.findViewById(R.id.priceTextView);
            madein = (TextView) rootView.findViewById(R.id.madeInTextView);
            stock = (TextView) rootView.findViewById(R.id.inStockTextView);
            sendBtn = (Button) rootView.findViewById(R.id.toCartBtn);
            title.setText(FragmentItems.get(getArguments().getInt(ARG_SECTION_NUMBER)).getmTitle());
            price.setText(FragmentItems.get(getArguments().getInt(ARG_SECTION_NUMBER)).getmPrice());
            madein.setText(FragmentItems.get(getArguments().getInt(ARG_SECTION_NUMBER)).getmMadeIn());
            stock.setText(FragmentItems.get(getArguments().getInt(ARG_SECTION_NUMBER)).getmInStock());

            Glide.
                    with(this)
                    .load(FragmentItems.get(getArguments().getInt(ARG_SECTION_NUMBER)).getmUrl())
                    .into(imageView);

            sendBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sendData();
                }
            });


            return rootView;
        }

        private void sendData()
        {
            //INTENT OBJ
            Intent intent = new Intent(getActivity().getBaseContext(),
                    CartActivity.class);
            //PACK DATA
            System.out.println(title.getText().toString());
            System.out.println(price.getText().toString());
            intent.putExtra("NAME_KEY", title.getText().toString());
            intent.putExtra("PRICE_KEY", price.getText().toString());

            //START ACTIVITY
            getActivity().startActivity(intent);
        }
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return FragmentItems.size();
        }
    }

    //Items and info


    public void bathroomItems() {
        FragmentItems.clear();
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1516147303597-2445c99ee744?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Showerhead", "20$", "Yes", "China"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1523471826770-c437b4636fe6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Towels", "20$", "Yes", "China"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1522874910040-9627b6af345d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Sink", "20$", "Yes", "China"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1523413651479-597eb2da0ad6?ixlib=rb-1.2.1&auto=format&fit=crop&w=500&q=60", "Sink", "20$", "Yes", "China"));
    }


    public void kitchenItems() {
        FragmentItems.clear();
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1504380939232-3781940dae8b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Blender and Spoon Set", "20$", "Yes", "China"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1530006498959-b7884e829a04?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Bowls", "25$", "Yes", "Japan"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1526434426615-1abe81efcb0b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Spoons", "3$", "Yes", "Japan"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1525480122447-64809d765ec4?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Mugs", "40$", "Yes", "Germany"));
    }

    public void bedroomItems() {
        FragmentItems.clear();
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1533090161767-e6ffed986c88?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Wooden clock", "100$", "Yes", "China"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1527694224012-be005121c774?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Ladder", "78$", "Yes", "China"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1512918580421-b2feee3b85a6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "White Bed", "200$", "Yes", "Germany"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1530334565651-210b286480b7?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Blue Bed", "200$", "Yes", "Germany"));
    }

    public void livingroomItems() {
        FragmentItems.clear();
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1518012312832-96aea3c91144?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Plant", "35$", "Yes", "China"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1461151304267-38535e780c79?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Television", "250$", "Yes", "Slovakia"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1531576856932-f93f21defbc1?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Table and Bench", "120$", "Yes", "Sweden"));
        FragmentItems.add(new Furniture("https://images.unsplash.com/photo-1522444195799-478538b28823?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60", "Small sofa and dogo", "420$", "Yes", "Sweden"));
    }

}
