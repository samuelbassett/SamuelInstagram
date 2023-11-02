package com.vipulasri.jetinstagram.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.model.Post
import kotlin.math.min

@Composable
fun PostGrid(
    posts: List<Post>
) {
    // Calculate the number of rows needed for the grid
    val rows = if (posts.size % 3 == 0) posts.size / 3 else posts.size / 3 + 1

    LazyColumn(
        contentPadding = PaddingValues(2.dp),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        items(rows) { rowIndex ->
            // Take a subset of the list for each row
            val startIndex = rowIndex * 3
            val endIndex = min(startIndex + 3, posts.size)
            val rowPosts = posts.subList(startIndex, endIndex)

            Row(
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                // Create an item in the row for each post
                for (post in rowPosts) {
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .aspectRatio(1f)
                            .background(Color.Gray)
                    ) {
                        Image(
                            painter = rememberImagePainter(data = post.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }

                // If the last row has less than 3 items, fill the remaining space with empty boxes
                if (endIndex % 3 != 0) {
                    for (i in endIndex % 3 until 3) {
                        Spacer(
                            modifier = Modifier
                                .weight(1f)
                                .aspectRatio(1f)
                        )
                    }
                }
            }
        }
    }
}