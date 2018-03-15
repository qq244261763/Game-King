package com.example.person.gameking.layout;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.example.person.gameking.R;
import com.example.person.gameking.base.BaseFragment;
import com.example.person.gameking.view.BattleView;
import com.example.person.gameking.view.CardHeapView;
import com.example.person.gameking.view.CardView;

public class FightingFragment extends BaseFragment {
    private CardHeapView cardHeapView1, cardHeapView2;
    private BattleView battleView;

    @Override
    public int bindLayout() {
        return R.layout.view_fighting;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        cardHeapView1 = view.findViewById(R.id.cardHeapView1);
//        cardHeapView2 = view.findViewById(R.id.cardHeapView2);
//        battleView = view.findViewById(R.id.battleArea1);

    }
}
