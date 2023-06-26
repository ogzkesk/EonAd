package com.ogzkesk.eonad.ui

import android.view.View
import android.widget.TextView
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.ads.nativead.NativeAdView
import com.ogzkesk.eonad.R

@Composable
fun EonNativeAdView(
    nativeAdView: View?,
    darkModeSupport: Boolean,
    modifier: Modifier = Modifier
) {

    val background = rememberBackground(darkModeSupport)
    val contentColor = rememberForeground(darkModeSupport)

    nativeAdView?.let { mView ->
        AndroidView(
            modifier = modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .border(0.6.dp, Color(0xFF9C9C9C), RoundedCornerShape(8.dp))
                .windowInsetsPadding(WindowInsets.navigationBars)
                .windowInsetsPadding(WindowInsets.statusBars),
            factory = { mView as NativeAdView },
            update = { view ->
                try {
                    view.setBackgroundColor(background)
                    view.findViewById<TextView>(R.id.ad_headline).setTextColor(contentColor)
                    view.findViewById<TextView>(R.id.ad_body).setTextColor(contentColor)
                } catch (e: Exception) {

                }
            }
        )

        return
    } ?: ShimmerView()
}

@Composable
fun ShimmerView() {

}

