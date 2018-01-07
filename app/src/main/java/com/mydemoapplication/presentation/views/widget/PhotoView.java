package com.mydemoapplication.presentation.views.widget;

import android.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.mydemoapplication.R;
import com.mydemoapplication.data.entity.yandex_fotki.Entry;
import com.mydemoapplication.data.entity.yandex_fotki.Img;
import com.mydemoapplication.presentation.contract.InteractiveModelView;
import com.mydemoapplication.presentation.views.dialog.DialogSelectSizePhoto;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Kras on 05.01.2018.
 */

public class PhotoView extends LinearLayout implements InteractiveModelView<Entry> {

    @BindView(R.id.widget_photo)    ImageView imageView;
    @BindView(R.id.widget_progress)    ProgressBar progressBar;

    public PhotoView(Context context) {
        super(context);
    }

    public PhotoView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PhotoView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public PhotoView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void setModel(final Entry model) {
        progressBar.setVisibility(VISIBLE);
        imageView.setVisibility(INVISIBLE);
        imageView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                imageView.getViewTreeObserver().removeOnPreDrawListener(this);
                try {
                    Img img=model.getImg().get(1);
                    //resize
                    float ratio=(float) imageView.getWidth()/(float) img.getWidth();
                    RelativeLayout.LayoutParams p= (RelativeLayout.LayoutParams) imageView.getLayoutParams();
                    p.height=(int) (img.getHeight()*ratio);
                    imageView.setLayoutParams(p);
                    //load
                    Picasso.with(getContext()).load(img.getHref()).error(R.drawable.ic_launcher_background).into(imageView,new com.squareup.picasso.Callback() {
                        @Override
                        public void onSuccess() {
                            progressBar.setVisibility(GONE);
                            imageView.setVisibility(VISIBLE);
                        }

                        @Override
                        public void onError() {

                        }
                    });
                }catch (Exception e){
                    Picasso.with(getContext()).load(R.drawable.ic_launcher_background).into(imageView);
                }

                return true;
            }
        });
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    new DialogSelectSizePhoto().setData(model.getImg()).show(((FragmentActivity) getContext()).getFragmentManager(),"qq");
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public Entry getModel() {
        return null;
    }

    @Override
    public void setListener(Listener listener) {

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        ButterKnife.bind(this);
    }
}
