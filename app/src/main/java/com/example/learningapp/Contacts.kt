package com.example.learningapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Contacts(
    @DrawableRes val image: Int,
    @StringRes val titleResId: Int,
    @StringRes val numberResId: Int
)
