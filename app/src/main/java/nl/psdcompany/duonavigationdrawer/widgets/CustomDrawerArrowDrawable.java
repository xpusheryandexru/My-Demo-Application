package nl.psdcompany.duonavigationdrawer.widgets;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/**
 * Created by ovcst on 03.08.2017.
 */

public class CustomDrawerArrowDrawable extends BitmapDrawable implements DuoDrawerToggle.DrawerToggle {

    public CustomDrawerArrowDrawable(Resources res,
                                     Bitmap bitmap) {
        super(res, bitmap);
    }

    @Override
    public void setPosition(float position) {

    }

    @Override
    public float getPosition() {
        return 0;
    }
}
