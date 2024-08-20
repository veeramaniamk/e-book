package com.saveetha.e_book;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.fragment.app.FragmentActivity;

public interface SF {

    static SharedPreferences getSignInSF(FragmentActivity activity) {
        return activity.getSharedPreferences(Constant.SIGN_IN_SF, Context.MODE_PRIVATE);
    }

}
