package com.navin.snappfood.models

interface IMessageListener<T> {

    fun onSuccess(responseMessage: T);
    fun onFailure(errorResponseMessage: String)
}