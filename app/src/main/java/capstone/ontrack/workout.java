package capstone.ontrack;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


public class workout extends Fragment {
    private Spinner spinner;
    private ImageButton add;
    private List<View> myList = new ArrayList<>();


    public workout() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_workout, container, false);

        final LinearLayout Container = (LinearLayout)view.findViewById(R.id.container);
        LayoutInflater layoutInflater =
                (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View initialView = layoutInflater.inflate(R.layout.exercise, null);
        Container.addView(initialView);
        myList.add(initialView);

        final LinearLayout Container2 = (LinearLayout)view.findViewById(R.id.containerRep);

        add = (ImageButton) view.findViewById(R.id.add);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.workout, null);
                Spinner s = (Spinner) addView.findViewById(R.id.spinner3);
                String[] values =
                        {"Pounds", "Kilograms"};

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                s.setAdapter(adapter);

                myList.add(addView);

                ImageButton buttonRemove = (ImageButton)addView.findViewById(R.id.delete);
                buttonRemove.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }});

                Container2.addView(addView);
            }});

        Button create = (Button) view.findViewById(R.id.create);
        create.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Boolean error = false;
                EditText date = (EditText) view.findViewById(R.id.date);
                EditText exercise = (EditText) view.findViewById(R.id.exercise);
                if (date.getText().toString().trim().equalsIgnoreCase("")) {
                    date.setError("Enter meet name");
                    error = true;
                }

                for(View v: myList){
                    EditText reps = (EditText) v.findViewById(R.id.reps);
                    EditText weight = (EditText) v.findViewById(R.id.weight);
                    EditText event = (EditText) v.findViewById(R.id.event);
                    if (event.getText().toString().trim().equalsIgnoreCase("")) {
                        event.setError("Enter event");
                        error = true;
                    }
                    if (reps.getText().toString().trim().equalsIgnoreCase("")) {
                        reps.setError("Enter reps");
                        error = true;
                    }
                    if (weight.getText().toString().trim().equalsIgnoreCase("")) {
                        weight.setError("Enter weight");
                        error = true;
                    }
                }
                if(error == false){
                    Intent intent = new Intent(getActivity(), home.class);
                    startActivity(intent);
                }
            }});
        Button exercise= (Button) view.findViewById(R.id.addExercise);

        exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.exercise, null);
                ImageButton a =(ImageButton) addView.findViewById(R.id.add);
                final LinearLayout C = (LinearLayout)addView.findViewById(R.id.containerRep);

                a.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View arg0) {
                        LayoutInflater layoutInflater =
                                (LayoutInflater) getActivity().getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                        final View addView = layoutInflater.inflate(R.layout.workout, null);
                        Spinner s = (Spinner) addView.findViewById(R.id.spinner3);
                        String[] values =
                                {"Pounds", "Kilograms"};

                        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, values);
                        adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
                        s.setAdapter(adapter);

                        myList.add(addView);

                        ImageButton buttonRemove = (ImageButton)addView.findViewById(R.id.delete);
                        buttonRemove.setOnClickListener(new View.OnClickListener(){

                            @Override
                            public void onClick(View v) {
                                myList.remove(addView);
                                ((LinearLayout)addView.getParent()).removeView(addView);
                            }});

                        C.addView(addView);
                    }});
                myList.add(addView);

                ImageButton buttonRemove = (ImageButton)addView.findViewById(R.id.delete);
                buttonRemove.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        myList.remove(addView);
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }});

                Container.addView(addView);
            }});


        return view;

    }
}