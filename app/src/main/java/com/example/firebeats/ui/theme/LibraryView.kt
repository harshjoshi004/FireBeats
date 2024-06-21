package com.example.firebeats.ui.theme
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import com.example.firebeats.R
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun LibraryView(){
    Column {
        listOfDummies.forEach{
            LibraryItem(name = it.name, drawable = it.icon)
        }
    }
}

data class Dummy(val name:String, val icon: Int)

val listOfDummies = listOf<Dummy>(
    Dummy("Playlist",R.drawable.playlist), Dummy("Artists", R.drawable.artists),Dummy("Albums", R.drawable.album),Dummy("Songs", R.drawable.baseline_audiotrack_24), Dummy("Genre", R.drawable.baseline_music_video_24)
)

@Composable
fun LibraryItem(name:String, drawable:Int){
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 16.dp, top = 16.dp), shape = RoundedCornerShape(5.dp)) {
        Row (Modifier.fillMaxWidth().padding(start = 8.dp),verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            Row() {
                Icon(painter = painterResource(id = drawable), contentDescription = null)
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = name)
            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.KeyboardArrowRight, contentDescription = null)
            }
        }

    }
}