package com.vipulasri.jetinstagram.ui.favorite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.unit.dp
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.model.Story
import com.vipulasri.jetinstagram.ui.home.StoryImage

@Composable
fun FavoritesUI(stories: List<Story>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        itemsIndexed(stories) { index, story ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(vertical = 5.dp, horizontal = 6.dp)
                    .fillMaxSize()
            ) {
                RowItem(story)
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        ImageBitmap.imageResource(R.drawable.ic_outlined_favorite),
                        contentDescription = "")
                }
            }

//            if (index == stories.size.minus(1)) {
//                Spacer(modifier = Modifier.width(6.dp))
//            }
        }
    }
}

@Composable
fun RowItem(story: Story) {
    Row(horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically) {
        StoryImage(imageUrl = story.image)
        Text(
            text = story.name,
            style = MaterialTheme.typography.caption,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}