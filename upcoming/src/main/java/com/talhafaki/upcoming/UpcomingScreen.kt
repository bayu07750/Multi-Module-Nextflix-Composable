package com.talhafaki.upcoming

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.talhafaki.common.items.MovieItem
import com.talhafaki.common.theme.NextflixComposableTheme
import com.talhafaki.domain.entity.NetworkMovie

/**
 * Created by tfakioglu on 12.December.2021
 */
@Composable
fun UpcomingScreen() {

    val viewModel = hiltViewModel<UpcomingViewModel>()

    NextflixComposableTheme(darkTheme = true) {
        Column(Modifier.background(Color.DarkGray)) {
            UpcomingList(movieList = viewModel.upcomingList().collectAsLazyPagingItems())
        }
    }
}

@Composable
fun UpcomingList(movieList: LazyPagingItems<NetworkMovie>) {
    LazyColumn {
        items(movieList.itemCount) { index ->
            movieList[index]?.let {
                MovieItem(movie = it)
            }
        }
    }
}