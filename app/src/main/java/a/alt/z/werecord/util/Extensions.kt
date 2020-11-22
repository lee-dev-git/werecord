package a.alt.z.werecord.util

import android.view.LayoutInflater
import android.view.ViewGroup
import timber.log.Timber

val ViewGroup.layoutInflater get() = LayoutInflater.from(context)

fun debug(e: Exception? = null, message: () -> String) = Timber.tag("aaltz1993").d(e, message())