package com.creditease.cemptyview;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Guideline;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.creditease.ctextview.CTextView;

/**
 * Created by zhxh on 2019/06/26
 */
public class CEmptyView extends ConstraintLayout {

    ImageView ivEmptyImg;
    Guideline lineEmpty;
    CTextView tvEmptyTitle;

    public CEmptyView(Context context) {
        super(context);
        initView(context);
    }

    public CEmptyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CEmptyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.cempty_view_layout, this);

        ivEmptyImg = rootView.findViewById(R.id.ivEmptyImg);
        lineEmpty = rootView.findViewById(R.id.lineEmpty);
        tvEmptyTitle = rootView.findViewById(R.id.tvEmptyTitle);
    }

    public CTextView getCText() {
        return tvEmptyTitle;
    }

    public CEmptyView withPos(float percent) {
        lineEmpty.setGuidelinePercent(percent);
        return this;
    }

    public CEmptyView withImg(int resId) {
        ivEmptyImg.setImageResource(resId);
        return this;
    }

    public CEmptyView withTxt(CharSequence title) {
        tvEmptyTitle.setText(title);
        return this;
    }

    public void withCallback(final CallbackFunction function) {
        ivEmptyImg.setOnClickListener(v -> function.invoke());
        tvEmptyTitle.setOnClickListener(v -> function.invoke());
    }

    public interface CallbackFunction {
        void invoke();
    }

}
