package info.androidhive.materialdesign.helper;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import java.util.ArrayList;

import info.androidhive.materialdesign.R;
import info.androidhive.materialdesign.app.AppController;

/**
 * Created by YIYA SERVER on 5/14/2016.
 */
public class UniversityListAdapter extends BaseAdapter implements Filterable {
    //private Activity activity;
    Context context;
    //private LayoutInflater inflater;
    //private List<UniversityActivity> UniversityActivity;
    //private List<UniversityActivity> mStringFilterList;
    private ArrayList<University> University;
    private ArrayList<University> mStringFilterList;
    ValueFilter valueFilter;

    ImageLoader imageLoader = AppController.getInstance().getImageLoader();

    public UniversityListAdapter(Context context, ArrayList<University> feedItems) {
        this.context = context;
        this.University = feedItems;
        mStringFilterList = feedItems;
    }

    @Override
    public int getCount() {
        return University.size();
    }

    @Override
    public Object getItem(int location) {
        return University.get(location);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        //if (inflater == null) inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //if (convertView == null) convertView = inflater.inflate(R.layout.list_item_product, null);
        if (convertView == null) convertView = mInflater.inflate(R.layout.list_item_product, null);
        if (imageLoader == null) imageLoader = AppController.getInstance().getImageLoader();

        TextView cid = (TextView) convertView.findViewById(R.id.cid);
        TextView diseases = (TextView) convertView.findViewById(R.id.diseases);
        //TextView pests = (TextView) convertView.findViewById(R.id.pests);
        //TextView pest_symptoms = (TextView) convertView.findViewById(R.id.pest_symptoms);
        //TextView right_pesticides = (TextView) convertView.findViewById(R.id.right_pesticides);
        //TextView right_place_to_buy = (TextView) convertView.findViewById(R.id.right_place_to_buy);
        //TextView bad_practices = (TextView) convertView.findViewById(R.id.bad_practices);
        //TextView good_practices = (TextView) convertView.findViewById(R.id.good_practices);
        //TextView created_on = (TextView) convertView.findViewById(R.id.created_on);
        //remove this after
        //TextView imageme =(TextView) convertView.findViewById(R.id.image);

        NetworkImageView image = (NetworkImageView) convertView.findViewById(R.id.productImage);

        //final UniversityActivity crop= UniversityActivity.get(position);
        University crop = University.get(position);

        cid.setText(crop.getidUniversity());
        diseases.setText(crop.getname());
        //pests.setText(crop.getPests());
        //pest_symptoms.setText(crop.getPest_symptoms());
        //right_pesticides.setText(crop.getRight_pesticides());
        //right_place_to_buy.setText(crop.getRight_place_to_buy());
        //bad_practices.setText(crop.getBad_practices());
        //good_practices.setText(crop.getGood_practices());
        //created_on.setText(crop.getCreated_on());
        ////remove after
        //imageme.setText(crop.getImage());
        // user profile pic
        image.setImageUrl(crop.getImage(), imageLoader);


        return convertView;
    }

    @Override
    public Filter getFilter() {
        if (valueFilter == null) {
            valueFilter = new ValueFilter();
        }
        return valueFilter;
    }

    private class ValueFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();

            if (constraint != null && constraint.length() > 0) {
                ArrayList<University> filterList = new ArrayList<University>();
                for (int i = 0; i < mStringFilterList.size(); i++) {
                    if ((mStringFilterList.get(i).getname().toUpperCase())
                            .contains(constraint.toString().toUpperCase())) {

                        University country = new University(mStringFilterList.get(i)
                                .getidUniversity(), mStringFilterList.get(i)
                                .getname(), mStringFilterList.get(i)
                                .getcontact(), mStringFilterList.get(i)
                                .getaddress(), mStringFilterList.get(i)
                                .getdetails(), mStringFilterList.get(i)
                                .getImage());

                        filterList.add(country);
                    }
                }
                results.count = filterList.size();
                results.values = filterList;
            } else {
                results.count = mStringFilterList.size();
                results.values = mStringFilterList;
            }
            return results;

        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            University = (ArrayList<University>) results.values;
            notifyDataSetChanged();
        }

    }
}



