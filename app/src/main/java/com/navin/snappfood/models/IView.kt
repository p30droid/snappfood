package com.navin.snappfood.models

import android.telephony.SmsMessage
import okhttp3.ResponseBody

interface IView<in T> {

    fun onSuccess(responseMessage: T);
    fun onFailure(errorResponseMessage: String);
    fun onError(errorResponseMessage: String);

}