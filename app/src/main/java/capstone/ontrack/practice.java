package capstone.ontrack;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Spinner;
import java.util.List;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;

public class practice extends Fragment {
    private Spinner weight;
    private Spinner distance;
    private ImageButton add;
    private List<View> myList = new ArrayList<>();
    private View view;


    public practice() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.fragment_practice, container, false);

        // Spinner element
        distance = (Spinner) view.findViewById(R.id.spinner2);
        String[] values =
                {"Seconds", "Minutes", "Meters", "Feet"};

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        distance.setAdapter(adapter);

        weight = (Spinner) view.findViewById(R.id.spinner);
        String[] w =
                {"Pounds", "Kilograms"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, w);
        adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        weight.setAdapter(adapter2);

        final LinearLayout Container = (LinearLayout)view.findViewById(R.id.container);

        add = (ImageButton) view.findViewById(R.id.add);
        add.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.practice, null);

                Spinner d = (Spinner) addView.findViewById(R.id.spinner2);
                String[] values =
                        {"Seconds", "Minutes", "Meters", "Feet"};

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                d.setAdapter(adapter);

                Spinner we = (Spinner) addView.findViewById(R.id.spinner);
                String[] w =
                        {"Pounds", "Kilograms"};
                ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, w);
                adapter2.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                we.setAdapter(adapter2);

                myList.add(addView);
                Button buttonRemove = (Button)addView.findViewById(R.id.delete);
                buttonRemove.setOnClickListener(new OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        myList.remove(addView);
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }});

                Container.addView(addView);
            }});

        Button create = (Button) view.findViewById(R.id.create);
        create.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Boolean error = false;
                EditText e = (EditText) view.findViewById(R.id.event);
                EditText r = (EditText) view.findViewById(R.id.reps);
                EditText date = (EditText) view.findViewById(R.id.editText2);
                if (e.getText().toString().trim().equalsIgnoreCase("")) {
                    e.setError("Enter event");
                    error = true;
                }
                if (r.getText().toString().trim().equalsIgnoreCase("")) {
                    r.setError("Enter the number of repetitions");
                    error = true;
                }
                if (date.getText().toString().trim().equalsIgnoreCase("")) {
                    date.setError("Enter date");
                    error = true;
                }

                for(View v: myList){
                    EditText reps = (EditText) v.findViewById(R.id.reps);
                    EditText events = (EditText) v.findViewById(R.id.event);
                    if (events.getText().toString().trim().equalsIgnoreCase("")) {
                        events.setError("Enter event");
                        error = true;
                    }
                    if (reps.getText().toString().trim().equalsIgnoreCase("")) {
                        reps.setError("Enter the number of repetitions");
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