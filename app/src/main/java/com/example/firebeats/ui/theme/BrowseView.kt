package com.example.firebeats.ui.theme

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.firebeats.R

@Composable
fun BrowseView(){
    val configuration = LocalConfiguration.current
    LazyVerticalGrid(modifier = Modifier.padding(end = 16.dp),
        columns =
        if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE)
            GridCells.Fixed(4)
        else
            GridCells.Fixed(2)
        , content = {
        items(categories){
            BrowserItem(cat = it.name, drawable = it.drawable)
        }
        items(categories){
            BrowserItem(cat = it.name, drawable = it.drawable)
        }
    })
}
