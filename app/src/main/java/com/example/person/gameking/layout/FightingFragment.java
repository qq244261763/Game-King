package com.example.person.gameking.layout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.person.gameking.R;
import com.example.person.gameking.base.BaseFragment;
import com.example.person.gameking.tools.Tools;
import com.example.person.gameking.view.BattleView;
import com.example.person.gameking.view.CardHeapView;
import com.example.person.gameking.view.CardView;

public class FightingFragment extends BaseFragment {

    @Override
    public int bindLayout() {
        return R.layout.view_fighting;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ViewGroup myCards = view.findViewById(R.id.myCards);
        addImage(myCards);
        addImage(myCards);
        addImage(myCards);
        addImage(myCards);
        addImage(myCards);

    }
    public void addImage(ViewGroup myCards){
        final ImageView imageView1 = new ImageView(getContext());
        imageView1.setLayoutParams(new ViewGroup.LayoutParams(100,80));
        imageView1.setImageResource(R.drawable.abcd);
        myCards.addView(imageView1);
        imageView1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                v.setTag(R.drawable.abcd);
                Tools.startDrag(v);
                imageView1.setVisibility(View.GONE);
                return false;
            }
        });
    }
}
