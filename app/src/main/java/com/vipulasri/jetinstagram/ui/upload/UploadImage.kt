package com.vipulasri.jetinstagram.ui.upload

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.data.PostsRepository
import com.vipulasri.jetinstagram.model.Post
import com.vipulasri.jetinstagram.ui.components.PostGrid

@Composable
fun UploadPost() {
    val posts by PostsRepository.posts
    Column {
        InstagramUploadAppBar()
        Divider()
        PostImagePreview(posts)
        Divider()
        PostGrid(posts)
    }
}

@Composable
fun InstagramUploadAppBar() {
    TopAppBar(
        title = { Text(
            text = "New Post",
            fontSize = 16.sp
            ) },
        navigationIcon = {
            IconButton(onClick = { /* Handle close action */ }) {
                Icon(Icons.Filled.Close, contentDescription = "Close")
            }
        },
        actions = {
            TextButton(onClick = { /* Handle share action */ }) {
                Text("Share",
                    fontSize = 16.sp,
                    color = Color.Black)
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black
    )
}

@Composable
fun PostImagePreview(posts: List<Post>) {
    Box(
        modifier = Modifier
            .height(250.dp)
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = rememberImagePainter(posts[0].image),
            contentDescription = null,
            modifier = Modifier.fillMaxSize()
        )
    }
}
