
package capstone.ontrack;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class meet extends Fragment {
    private Spinner spinner;
    private ImageButton add;
    private List<View> myList = new ArrayList<>();


    public meet() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final ViewGroup a = container;
        final View view = inflater.inflate(R.layout.fragment_meet, container, false);

        LayoutInflater layoutInflater =
                (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = layoutInflater.inflate(R.layout.event, null);

        // Spinner element
        spinner = (Spinner) v.findViewById(R.id.spinner);
        String[] values =
                {"Seconds", "Minutes", "Meters", "Feet"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(adapter);
        final LinearLayout Container = (LinearLayout)view.findViewById(R.id.container);

        Container.addView(v);
        myList.add(v);
        add = (ImageButton) view.findViewById(R.id.add);

        add.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.event, null);
                Spinner s = (Spinner) addView.findViewById(R.id.spinner);
                String[] values =
                        {"Seconds", "Minutes", "Meters", "Feet"};

               final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                s.setAdapter(adapter);

                myList.add(addView);

                Button buttonRemove = (Button)addView.findViewById(R.id.delete);
                buttonRemove.setOnClickListener(new OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        myList.remove(addView);
                        adapter.notifyDataSetChanged();
                        ((LinearLayout)addView.getParent()).removeView(addView);

                    }});

                Container.addView(addView);
            }});

        Button create = (Button) view.findViewById(R.id.create);
        create.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Boolean error = false;
                EditText meetName = (EditText) view.findViewById(R.id.editText);
                EditText meetDate = (EditText) view.findViewById(R.id.editText2);

                if (meetName.getText().toString().trim().equalsIgnoreCase("")) {
                    meetName.setError("Enter meet name");
                    error = true;
                }
                if (meetDate.getText().toString().trim().equalsIgnoreCase("")) {
                    meetDate.setError("Enter date");
                    error = true;
                }

                for(View v: myList){
                    EditText time = (EditText) v.findViewById(R.id.time);
                    EditText events = (EditText) v.findViewById(R.id.event);
                    if (events.getText().toString().trim().equalsIgnoreCase("")) {
                        events.setError("Enter event");
                        error = true;
                    }
                    if (time.getText().toString().trim().equalsIgnoreCase("")) {
                        time.setError("Enter your distance or time");
                        error = true;
                    }
                }
                if(error == false){
                    Intent intent = new Intent(getActivity(), home.class);
                    startActivity(intent);
                }
            }});

        return view;
    }
}



