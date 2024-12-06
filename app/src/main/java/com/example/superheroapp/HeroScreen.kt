package com.example.superheroapp

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.superheroapp.model.DataSource
import com.example.superheroapp.ui.theme.Shapes

@Composable
fun HeroCard(
    @StringRes name: Int, @StringRes descrip: Int,
    @DrawableRes img: Int, modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier.padding(start=16.dp, bottom=8.dp, end=16.dp)

    ) {
        Row(
            modifier = modifier.clip(Shapes.medium).padding(16.dp)
                .sizeIn(minHeight=72.dp).fillMaxWidth()

        ){
            Column(
                modifier.weight(1f)
            ){
                Text(
                    text = stringResource(name),
                    style = MaterialTheme.typography.displaySmall,
                )
                Text(
                    text = stringResource(descrip),
                    style = MaterialTheme.typography.bodyLarge,
                )
            }
            Box(
                modifier.padding(start=16.dp).clip(Shapes.small).size(72.dp)
            ){
                Image(
                    painter = painterResource(img),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }
}


@Composable
fun HeroList(modifier: Modifier=Modifier){
    LazyColumn {
        items(DataSource().loadHeroes()){hero->
            HeroCard(hero.name, hero.descrip, hero.img, modifier)
        }
    }
}
