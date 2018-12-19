package com.example.tanvi.myportfolio;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.bikomobile.circleindicatorpager.CircleIndicatorPager;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import lecho.lib.hellocharts.animation.ChartAnimationListener;
import lecho.lib.hellocharts.listener.LineChartOnValueSelectListener;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.model.ValueShape;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;
import lecho.lib.hellocharts.view.LineChartView;

public class AboutFragment extends Fragment {

    public AboutFragment() {
        // Required empty public constructor
    }

    public static AboutFragment newInstance(String param1, String param2) {
        AboutFragment fragment = new AboutFragment();
        return fragment;
    }

    private LineChartView chart;
    private LineChartData data;
    private int numberOfLines = 1;
    private int maxNumberOfLines = 4;
    private int numberOfPoints = 12;

    float[][] randomNumbersTab = new float[maxNumberOfLines][numberOfPoints];

    private boolean hasAxes = true;
    private boolean hasAxesNames = true;
    private boolean hasLines = true;
    private boolean hasPoints = true;
    private ValueShape shape = ValueShape.CIRCLE;
    private boolean isFilled = true;
    private boolean hasLabels = true;
    private boolean isCubic = false;
    private boolean hasLabelForSelected = true;
    private boolean pointsHaveDifferentColor = true;

    ViewPager viewPager;
    private int currentPage = 0;
    private Timer timer;
    final long DELAY_MS = 1500;
    final long PERIOD_MS = 3000;

    ArrayList<String> imagesList , titleList , textsList;
//    ArrayList<ViewPagerDataClass> viewPagerDataClasses = new ArrayList<>();
    ViewPagerDataClass viewPagerDataClasses;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_about, container, false);
        imagesList = new ArrayList<>();
        titleList = new ArrayList<>();
        textsList = new ArrayList<>();


        chart = (LineChartView) view.findViewById(R.id.chart);
        chart.setOnValueTouchListener(new ValueTouchListener());

        displayGraph();
        FirebaseApp.initializeApp(getContext());
        getFirebaseData(view , imagesList , titleList , textsList);

        return view;
    }

    private void getFirebaseData(final View view, final ArrayList<String> imagesList, final ArrayList<String> titleList, final ArrayList<String> textsList) {

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child("viewpagerItems").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot child : dataSnapshot.getChildren()){
                    viewPagerDataClasses = child.getValue(ViewPagerDataClass.class);
                    imagesList.add(viewPagerDataClasses.getImage());
                    titleList.add(viewPagerDataClasses.getTitle());
                    textsList.add(viewPagerDataClasses.getText());
                }
                setViewPager(imagesList,titleList,textsList,view);
                //hideProgressDialog();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });
    }

    private void displayGraph() {

        generateValues();
        generateData();
        toggleCubic();

        resetViewport();
    }

    private void generateValues() {
        for (int i = 0; i < maxNumberOfLines; ++i) {
            for (int j = 0; j < numberOfPoints; ++j) {
                randomNumbersTab[i][j] = (float) Math.random() * 100f;
            }
        }
    }

    private void resetViewport() {
        // Reset viewport height range to (0,100)
        final Viewport v = new Viewport(chart.getMaximumViewport());
        v.bottom = 0;
        v.top = 100;
        v.left = 0;
        v.right = numberOfPoints - 1;
        chart.setMaximumViewport(v);
        chart.setCurrentViewport(v);
    }

    private void toggleCubic() {
        isCubic = !isCubic;

        generateData();

        if (isCubic) {

            final Viewport v = new Viewport(chart.getMaximumViewport());
            v.bottom = -5;
            v.top = 105;
            chart.setMaximumViewport(v);
            chart.setCurrentViewportWithAnimation(v);
        } else {
            final Viewport v = new Viewport(chart.getMaximumViewport());
            v.bottom = 0;
            v.top = 100;
            chart.setViewportAnimationListener(new ChartAnimationListener() {

                @Override
                public void onAnimationStarted() {
                    // TODO Auto-generated method stub

                }

                @Override
                public void onAnimationFinished() {
                    chart.setMaximumViewport(v);
                    chart.setViewportAnimationListener(null);

                }
            });
            chart.setCurrentViewportWithAnimation(v);
        }

    }

    private void generateData() {

        List<Line> lines = new ArrayList<Line>();
        for (int i = 0; i < numberOfLines; ++i) {

            List<PointValue> values = new ArrayList<PointValue>();
            for (int j = 0; j < numberOfPoints; ++j) {
                values.add(new PointValue(j, randomNumbersTab[i][j]));
            }

            Line line = new Line(values);
            line.setColor(ChartUtils.COLORS[i + 4]);
            line.setShape(shape);
            line.setCubic(isCubic);
            line.setFilled(isFilled);
            line.setHasLabels(hasLabels);
            line.setHasLabelsOnlyForSelected(hasLabelForSelected);
            line.setHasLines(hasLines);
            line.setHasPoints(hasPoints);
            if (pointsHaveDifferentColor) {
                line.setPointColor(ChartUtils.COLORS[(i + 4) % ChartUtils.COLORS.length]);
            }
            lines.add(line);
        }

        data = new LineChartData(lines);

        if (hasAxes) {
            Axis axisX = new Axis();
            Axis axisY = new Axis();
            if (hasAxesNames) {
                axisX.setName("Years").setTextSize(13).setTextColor(R.color.black);
                axisY.setName("Performance").setTextSize(13).setTextColor(R.color.black);

            }
            data.setAxisXBottom(axisX);
//            data.setAxisYLeft(axisY);
        } else {
            data.setAxisXBottom(null);
            data.setAxisYLeft(null);
        }

//        data.setBaseValue(Float.NEGATIVE_INFINITY);
        chart.setLineChartData(data);

    }

    private class ValueTouchListener implements LineChartOnValueSelectListener {

        @Override
        public void onValueSelected(int lineIndex, int pointIndex, PointValue value) {
            Toast.makeText(getActivity(), "Selected: " + value, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onValueDeselected() {
            // TODO Auto-generated method stub

        }

    }

    //Setting up Viewpager to inflate images.
    private void setViewPager(ArrayList<String> images, ArrayList<String> titles, ArrayList<String> texts, View view) {
        viewPager = view.findViewById(R.id.view_pager_main);
        final ImagePagerAdapter adapter = new ImagePagerAdapter(AboutFragment.this, images, titles, texts);
        viewPager.setAdapter(adapter);

        if (viewPager != null) {
            viewPager.setAdapter(adapter);

            final Handler handler = new Handler();
            final Runnable Update = new Runnable() {
                public void run() {
                    if (currentPage == adapter.getCount()) {
                        currentPage = 0;
                    }
                    viewPager.setCurrentItem(currentPage++, true);
                }
            };

            timer = new Timer();
            timer.schedule(new TimerTask() { // task to be scheduled

                @Override
                public void run() {
                    handler.post(Update);
                }
            }, DELAY_MS, PERIOD_MS);

        }

//        //CircleIndicator
//        CircleIndicatorPager indicator = view.findViewById(R.id.circle_indicator_pager);
//        if (indicator != null) {
//            indicator.setViewPager(viewPager);
//        } else {
//            Log.wtf("TAG", "Indicator null");
//        }


    }
}

