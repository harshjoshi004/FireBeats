package com.example.firebeats.ui.theme

import androidx.annotation.DrawableRes
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.firebeats.R

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeView() {
    LazyColumn(){
        grouped.forEach{
            stickyHeader {
                Text(text = it.value[0], modifier = Modifier.padding(16.dp))
                LazyRow(){
                    items(categories){cat->
                        BrowserItem(cat.name, cat.drawable)
                    }
                }
            }
        }   
    }
}

val categories = listOf<CardData>(
    CardData("Hits", drawable = R.drawable.hits),
    CardData("TGIF", drawable = R.drawable.tgif),
    CardData("Happy", drawable = R.drawable.happy),
    CardData("Workout", drawable = R.drawable.workout),
    CardData("Yoga", drawable = R.drawable.yoga),
)
val grouped = listOf("New Releases", "Favourites", "Top Rated").groupBy { it[0] }

@Composable
fun BrowserItem(cat:String, drawable:Int){
    Card(modifier = Modifier
        .padding(top = 16.dp, start = 16.dp)
        .height(200.dp).width(170.dp),
        onClick = {},
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp)
    ) {
        Column(Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween, horizontalAlignment = Alignment.CenterHorizontally) {
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
                .paint(painterResource(id = drawable), contentScale = ContentScale.FillBounds)
            )
            Text(text = cat)
        }
    }
}

data class CardData(val name:String, @DrawableRes val drawable:Int)