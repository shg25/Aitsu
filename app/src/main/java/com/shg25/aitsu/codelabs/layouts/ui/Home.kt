package com.shg25.aitsu.codelabs.layouts.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Spa
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shg25.aitsu.R
import com.shg25.aitsu.ui.theme.AitsuTheme
import java.util.*

/**
 *
 * https://developer.android.com/codelabs/jetpack-compose-layouts?hl=ja
 */
@Composable
fun Home() {

}


/**
 * 4. 検索バー - 修飾子
 */
@Composable
fun SearchBar(
    modifier: Modifier = Modifier
) {
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        placeholder = {
            Text(stringResource(id = R.string.placeholder_search))
        },
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp)
    )
}

@Preview(
    name = "4. 検索バー - 修飾子",
    showBackground = true,
    backgroundColor = 0xFFF0EAE2
)
@Composable
fun SearchBarPreview() {
    AitsuTheme { SearchBar(Modifier.padding(8.dp)) }
}


/**
 * 5. Align your body - 位置揃え
 */
@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(text),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}

@Preview(
    name = "5. Align your body - 位置揃え",
    showBackground = true,
    backgroundColor = 0xFFF0EAE2
)
@Composable
fun AlignYourBodyElementPreview() {
    AitsuTheme {
        AlignYourBodyElement(
            text = R.string.ab1_inversions,
            drawable = R.drawable.ab1_inversions,
            modifier = Modifier.padding(8.dp)
        )
    }
}


/**
 * 6. Favorite collection カード - マテリアル サーフェス
 */
@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(192.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(56.dp)
            )
            Text(
                text = stringResource(text),
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }
}

@Preview(
    name = "6. Favorite collection カード - マテリアル サーフェス",
    showBackground = true,
    backgroundColor = 0xFFF0EAE2
)
@Composable
fun FavoriteCollectionCardPreview() {
    AitsuTheme {
        FavoriteCollectionCard(
            text = R.string.fc2_nature_meditations,
            drawable = R.drawable.fc2_nature_meditations,
            modifier = Modifier.padding(8.dp)
        )
    }
}


/**
 * 7. Align your body の行 - 配置
 */
@Composable
fun AlignYourBodyRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(alignYourBodyData) { item ->
            AlignYourBodyElement(item.drawable, item.text)
        }
    }
}

private val alignYourBodyData = listOf(
    R.drawable.ab1_inversions to R.string.ab1_inversions,
    R.drawable.ab2_quick_yoga to R.string.ab2_quick_yoga,
    R.drawable.ab3_stretching to R.string.ab3_stretching,
    R.drawable.ab4_tabata to R.string.ab4_tabata,
    R.drawable.ab5_hiit to R.string.ab5_hiit,
    R.drawable.ab6_pre_natal_yoga to R.string.ab6_pre_natal_yoga
).map { DrawableStringPair(it.first, it.second) }

@Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
@Composable
fun AlignYourBodyRowPreview() {
    AitsuTheme { AlignYourBodyRow() }
}


/**
 * 8. Favorite collections のグリッド - 遅延グリッド
 *
 * なぜか ↓ を import できないのでパス
 * import androidx.compose.foundation.lazy.grid.GridCells
 * import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
 * import androidx.compose.foundation.lazy.grid.items
 *
 */
//    @Composable
//    fun FavoriteCollectionsGrid(
//        modifier: Modifier = Modifier
//    ) {
//        LazyHorizontalGrid(
//            rows = GridCells.Fixed(2),
//            contentPadding = PaddingValues(horizontal = 16.dp),
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            verticalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = modifier.height(120.dp)
//        ) {
//            items(favoriteCollectionsData) { item ->
//                FavoriteCollectionCard(
//                    drawable = item.drawable,
//                    text = item.text,
//                    modifier = Modifier.height(56.dp)
//                )
//            }
//        }
//    }

private val favoriteCollectionsData = listOf(
    R.drawable.fc1_short_mantras to R.string.fc1_short_mantras,
    R.drawable.fc2_nature_meditations to R.string.fc2_nature_meditations,
    R.drawable.fc3_stress_and_anxiety to R.string.fc3_stress_and_anxiety,
    R.drawable.fc4_self_massage to R.string.fc4_self_massage,
    R.drawable.fc5_overwhelmed to R.string.fc5_overwhelmed,
    R.drawable.fc6_nightly_wind_down to R.string.fc6_nightly_wind_down
).map { DrawableStringPair(it.first, it.second) }

//    @Preview(showBackground = true, backgroundColor = 0xFFF0EAE2)
//    @Composable
//    fun FavoriteCollectionsGridPreview() {
//        AitsuTheme { FavoriteCollectionsGrid() }
//    }


/**
 * 9. ホーム セクション - スロット API
 */
@Composable
fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = stringResource(title).uppercase(Locale.getDefault()),
            style = MaterialTheme.typography.body1,
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Preview(
    name = "9. ホーム セクション - スロット API",
    showBackground = true,
    backgroundColor = 0xFFF0EAE2
)
@Composable
fun HomeSectionPreview() {
    AitsuTheme {
        HomeSection(R.string.align_your_body) {
            AlignYourBodyRow()
        }
    }
}


/**
 * 10. ホーム画面 - スクロール
 */
@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Column(
        modifier
            .verticalScroll(rememberScrollState())
            .padding(vertical = 16.dp)
    ) {
        SearchBar(Modifier.padding(horizontal = 16.dp))
        HomeSection(title = R.string.align_your_body) {
            AlignYourBodyRow()
        }
        HomeSection(title = R.string.favorite_collections) {
            AlignYourBodyRow() // ほんとは FavoriteCollectionsGrid() だけど実装できなかったので代わりに
        }
    }
}

@Preview(
    name = "10. ホーム画面 - スクロール",
    showBackground = true,
    backgroundColor = 0xFFF0EAE2,
//        heightDp = 180
)
@Composable
fun ScreenContentPreview() {
    AitsuTheme { HomeScreen() }
}


/**
 * 11. ボトム ナビゲーション - マテリアル
 */
@Composable
private fun SootheBottomNavigation(modifier: Modifier = Modifier) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.background,
        modifier = modifier
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Spa,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_home))
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(stringResource(R.string.bottom_navigation_profile))
            },
            selected = false,
            onClick = {}
        )
    }
}

@Preview(
    name = "11. ボトム ナビゲーション - マテリアル",
    showBackground = true,
    backgroundColor = 0xFFF0EAE2
)
@Composable
fun BottomNavigationPreview() {
    AitsuTheme { SootheBottomNavigation(Modifier.padding(top = 24.dp)) }
}


/**
 * 12. MySoothe アプリ - Scaffold
 */
@Composable
fun MySootheApp() {
    AitsuTheme {
        Scaffold(
            bottomBar = { SootheBottomNavigation() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Preview(
    name = "12. MySoothe アプリ - Scaffold",
    widthDp = 360,
    heightDp = 640
)
@Composable
fun MySoothePreview() {
    MySootheApp()
}


/**
 * 共通処理
 */

private data class DrawableStringPair(
    @DrawableRes val drawable: Int,
    @StringRes val text: Int
)


