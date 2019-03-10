package com.manumatnez.app.sbsettings.settings;

import android.view.View;

/**
 * Author: Kieron on 20/01/2018.
 */

public class TextSetting extends BaseSetting {

    View.OnClickListener onClickListener;
    String text;

    public TextSetting(String text, View.OnClickListener onClickListener) {
        this.text = text;
        this.onClickListener = onClickListener;
    }
}
