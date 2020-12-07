package com.gzeinnumer.imageslider.banner;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;

import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.IndicatorView.draw.controller.DrawController;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class InitBanner {

    private final Context context;
    private final SliderView sliderView;

    private List<SliderItem> sliderItemList = new ArrayList<>();
    private SliderAdapter adapter;

    public InitBanner(Context context, SliderView sliderView) {
        this.context = context;
        this.sliderView = sliderView;

        init();
    }

    private void init() {

        adapter.renewItems(sliderItemList);

        adapter = new SliderAdapter(context);
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(3);
        sliderView.setAutoCycle(true);
        sliderView.startAutoCycle();
    }

    public InitBanner setList(List<SliderItem> sliderItemList) {
        this.sliderItemList = sliderItemList;
        return this;
    }

    public void build() {
        adapter.renewItems(sliderItemList);

        sliderView.setOnIndicatorClickListener(new DrawController.ClickListener() {
            @Override
            public void onIndicatorClicked(int position) {
                Log.i("GGG", "onIndicatorClicked: " + sliderView.getCurrentPagePosition());
            }
        });
    }

    public void removeLastItem() {
        if (adapter.getCount() - 1 >= 0)
            adapter.deleteItem(adapter.getCount() - 1);
    }

    public void addNewItem(SliderItem sliderItem) {
        sliderItemList.add(sliderItem);
        adapter.addItem(sliderItem);
    }
}
