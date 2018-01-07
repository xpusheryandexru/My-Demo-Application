package com.mydemoapplication.presentation.views.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.mydemoapplication.R;
import com.mydemoapplication.app.environment.Constants;
import com.mydemoapplication.data.entity.yandex_fotki.Img;
import com.mydemoapplication.presentation.views.activity.FullscreenActivity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kras on 06.01.2018.
 */

public class DialogSelectSizePhoto extends DialogFragment implements Constants {
    private ArrayAdapter<String> arrayAdapter;
    private List<Img> img;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder adb = new AlertDialog.Builder(getActivity());
        adb.setTitle(R.string.title_select_size_photo);
        adb.setAdapter(arrayAdapter, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent=new Intent(getActivity(),FullscreenActivity.class);
                intent.putExtra(EXTRA_PARAM1,img.get(i));
                startActivity(intent);
                dismiss();
            }
        });
        return adb.create();
    }

    public DialogSelectSizePhoto setData(List<Img> img) {
        this.img=img;
        return this;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.select_dialog_singlechoice);
        Iterator<Img> imgIterator=img.iterator();
        while (imgIterator.hasNext())
            arrayAdapter.add(imgIterator.next().getSize());

    }
}
