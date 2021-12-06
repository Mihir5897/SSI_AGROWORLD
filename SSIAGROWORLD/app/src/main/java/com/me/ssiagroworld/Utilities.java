package com.me.ssiagroworld;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;

public class Utilities {

    public static SpannableString getErrorMessageForTextInputLayoutHeading(String errorMessage){
        SpannableString ss = new SpannableString(errorMessage);
        // SpannableStringBuilder ssb = new SpannableStringBuilder(errorMessage);

        ForegroundColorSpan fcsRed = new ForegroundColorSpan(Color.RED);
        ss.setSpan(fcsRed, errorMessage.length() - 1, errorMessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        //ssb.setSpan(fcsRed, errorMessage.length() - 1, errorMessage.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        return ss;
    }
}
