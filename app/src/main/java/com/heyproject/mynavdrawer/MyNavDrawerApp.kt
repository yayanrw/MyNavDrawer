package com.heyproject.mynavdrawer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.heyproject.mynavdrawer.ui.theme.MyNavDrawerTheme
import kotlinx.coroutines.launch

/**
Written by Yayan Rahmat Wijaya on 11/8/2022 13:16
Github : https://github.com/yayanrw
 **/

@Composable
fun MyNavDrawerApp() {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Scaffold(scaffoldState = scaffoldState, topBar = {
        MyTopBar(onMenuClick = {
            scope.launch {
                scaffoldState.drawerState.open()
            }
        })
    }, drawerContent = {
        Text(stringResource(R.string.hello_from_nav_drawer))
    }, drawerGesturesEnabled = scaffoldState.drawerState.isOpen
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Text(stringResource(R.string.hello_world))
        }
    }
}

@Composable
fun MyTopBar(onMenuClick: () -> Unit) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                onMenuClick()
            }) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = stringResource(R.string.menu)
                )
            }
        },
        title = {
            Text(stringResource(R.string.app_name))
        },
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyNavDrawerTheme {
        MyNavDrawerApp()
    }
}