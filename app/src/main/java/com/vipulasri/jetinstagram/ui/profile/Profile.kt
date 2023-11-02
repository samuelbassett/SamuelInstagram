package com.vipulasri.jetinstagram.ui.profile

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.TabRowDefaults
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.vipulasri.jetinstagram.R
import com.vipulasri.jetinstagram.data.PostsRepository
import com.vipulasri.jetinstagram.model.Post
import com.vipulasri.jetinstagram.model.User
import com.vipulasri.jetinstagram.ui.components.PostGrid

@Composable
fun Profile(
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit
) {
    val profile = PostsRepository.observePosts()

    val scaffoldState = rememberScaffoldState()
    val tabs = listOf(R.drawable.ic_grid, R.drawable.ic_tagged)

    Scaffold(
        modifier = Modifier.background(Color.Transparent),
        topBar = {
            Column {
                ProfileToolBar(profile = profile.value[1].user)
                ProfileInfo(profile)
                Spacer(modifier = Modifier.padding(8.dp))
                TabRow(selectedTabIndex = selectedTabIndex,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    indicator = { tabPositions ->
                        TabRowDefaults.Indicator(
                            Modifier.tabIndicatorOffset(tabPositions[selectedTabIndex])
                        )
                    },
                    backgroundColor = Color.Transparent,
                    tabs = {
                        tabs.map {
                            Tab(
                                selected = selectedTabIndex == tabs.indexOf(it),
                                onClick = { onTabSelected(tabs.indexOf(it)) },
                                modifier = Modifier
                                    .background(Color.Transparent),
                            ) {
                                Icon(
                                    ImageVector.vectorResource(it),
                                    contentDescription = ""
                                )
                            }
                        }
                    }
                )
            }
        }, scaffoldState = scaffoldState
    ) { innerPadding ->
        val modifier = Modifier.padding(innerPadding)
        Crossfade(
            modifier = modifier, targetState = selectedTabIndex
        ) { section ->
            when (section) {
                0 -> PostsScreen(profile.value)
                1 -> TaggedScreen()
            }
        }
    }
}

@Composable
fun TaggedScreen() {
    Box {
        Text("Tagged")
    }
}

@Composable
fun PostsScreen(
    posts: List<Post>
) {
    PostGrid(posts)
}

@Composable
fun ProfileInfo(profile: MutableState<List<Post>>) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp, start = 16.dp, end = 16.dp, bottom = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(90.dp)
                .background(color = Color.LightGray, shape = CircleShape)
                .clip(CircleShape)
        ) {
            Image(
                painter = rememberImagePainter(profile.value[1].user.image),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "10", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Text(
                text = "Posts", style = TextStyle(
                    fontSize = 14.sp

                )
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "54", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Text(
                text = "Followers", style = TextStyle(
                    fontSize = 14.sp

                )
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "81", style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Text(
                text = "Following", style = TextStyle(
                    fontSize = 14.sp

                )
            )
        }
    }
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier.padding(start = 8.dp)
    ) {
        Text(
            text = profile.value[1].user.name,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            ),
        )
        Text(
            text = "Personal Blog",
            style = TextStyle(
                fontWeight = FontWeight.Light,
                fontSize = 14.sp
            ),
        )
        Text(
            text = "Writer @Google\ngoogle.com",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp
            ),
        )
    }
}

@Composable
fun ProfileToolBar(profile: User) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = profile.username, style = TextStyle(
                color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 24.sp
            )
        )
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.ic_drawer),
                contentDescription = ""
            )
        }
    }
    Divider(color = Color.LightGray)
}

private enum class ProfileSection(
    val icon: Int,
    val selectedIcon: Int
) {
    Posts(R.drawable.ic_grid, R.drawable.ic_grid),
    Tagged(R.drawable.ic_tagged, R.drawable.ic_tagged),
}
