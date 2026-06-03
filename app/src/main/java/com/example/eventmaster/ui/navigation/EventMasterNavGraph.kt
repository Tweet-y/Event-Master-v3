package com.example.eventmaster.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.eventmaster.presentation.auth.AuthViewModel
import com.example.eventmaster.ui.screens.AddCategoryScreen
import com.example.eventmaster.ui.screens.AddEventScreen
import com.example.eventmaster.ui.screens.CategoryEventsScreen
import com.example.eventmaster.ui.screens.EventDetailScreen
import com.example.eventmaster.ui.screens.HomeScreen
import com.example.eventmaster.ui.viewmodel.CategoryViewModel
import com.example.eventmaster.ui.viewmodel.EventViewModel

@Composable
fun EventMasterNavGraph(
    modifier: Modifier = Modifier,
) {
    val navController = rememberNavController()
    val eventViewModel: EventViewModel = hiltViewModel()
    val categoryViewModel: CategoryViewModel = hiltViewModel()
    val authViewModel: AuthViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = Screen.Home,
        modifier = modifier,
    ) {
        composable<Screen.Home> {
            HomeScreen(
                categoryViewModel = categoryViewModel,
                onCategoryClick = { categoryName ->
                    navController.navigate(Screen.CategoryEvents(categoryName))
                },
                onAddCategoryClick = {
                    navController.navigate(Screen.AddCategory)
                },
                onLogout = {
                    authViewModel.logout()
                },
            )
        }

        composable<Screen.CategoryEvents> { backStackEntry ->
            val route: Screen.CategoryEvents = backStackEntry.toRoute()
            CategoryEventsScreen(
                categoryName = route.categoryName,
                eventViewModel = eventViewModel,
                onBack = { navController.popBackStack() },
                onAddEventClick = { selectedCategory ->
                    navController.navigate(Screen.AddEvent(selectedCategory))
                },
                onEventDetailClick = { eventId ->
                    navController.navigate(Screen.EventDetail(eventId))
                },
            )
        }

        composable<Screen.AddCategory> {
            AddCategoryScreen(
                categoryViewModel = categoryViewModel,
                onBack = { navController.popBackStack() },
            )
        }

        composable<Screen.AddEvent> { backStackEntry ->
            val route: Screen.AddEvent = backStackEntry.toRoute()
            AddEventScreen(
                viewModel = eventViewModel,
                categoryName = route.categoryName,
                onBack = { navController.popBackStack() },
            )
        }

        composable<Screen.EventDetail> { backStackEntry ->
            val route: Screen.EventDetail = backStackEntry.toRoute()
            EventDetailScreen(
                event = eventViewModel.getEventById(route.eventId),
                onBack = { navController.popBackStack() },
            )
        }
    }
}