GifBrowser
Android Application sample based on MVVM, Koin, Paging, AndroidX Preference, and Coroutines. It requires a Giphy API Client ID which has to be added in Constants.kt.

It Contains
Home Page

Displays a list of images retrieved via the Giphy API.
Grid layout for efficient image display.
Inner Page

Full-width view of the selected image.
Detailed information retrieved from the API.
<div>
  <img src="splash screen.png" alt="Splash Screen" width="24%" style="float:left; margin-right:10px;">
  <img src="home page.png" alt="Home Page" width="24%" style="float:left; margin-right:10px;">
  <img src="single inner image.png" alt="Inner Page" width="24%" style="float:left; margin-right:10px;">
  <img src="app interface (2).gif" alt="App Interface" width="24%" style="float:left;">
</div>
Features
MVVM Architecture Pattern
Ensures a clean separation of concerns and enhances testability.
Retry Option
Allows users to retry network calls if they fail.
Responsive Design
Compatible with both phones and tablets.
Infinite Scroll
Implemented using Paging for seamless data loading.
Pull to Refresh
Refreshes the content with a swipe gesture.
Libraries Used
Android Architecture Components

ViewModel
Paging
Preference
Dependency Injection

Koin
Asynchronous Programming

Kotlin Coroutines
Image Loading

Glide
For more details, visit the GifBrowser Repository.
