# GifBrowse
Android Application sample based on Mvvm, Koin, LiveData, Paging, AndroidX Preference & Coroutines. It requires an [giphy.com](https://giphy.com/) API Client ID which has to be added in [Constants.kt](GifBrowser/app/src/main/java/com/arun/gifbrowser/Application/Utility/Constants.kt)
## It contains
1. **Home Page**
  * List of the images retrieved via giphy Api
  * grid layout
2. **Inner page**
  * Full width view of selected image
  * view of details retried from api
  
  
  <div>
  <img float=left width=24% src="splash screen.png">
  <img float=left width=24% src="home page.png">
  <img float=left width=24% src="single inner image.png">
  <img float=left width=24% src="app interface (2).gif">
</div>

## Features
1. ***MVVM*** architecture pattern
2. Option to retry when network call fails
3. Design compatible to both phone and tablet
4. Infinite scroll via Paging
5. Pull to refersh 


## Libraries Used

 `Android Architecture Components`
* ViewModel
* Paging
* Preference

 `Dependency Injection`
* Koin

 `Asynchronous Programming`
* Kotlin Coroutines

`Image Loading`
* Glide
