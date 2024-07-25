# GifBrowser

<p>GifBrowser is an Android application designed to showcase GIFs using the Giphy API. Built with modern Android development practices, it incorporates the MVVM architecture, Koin for dependency injection, Paging for infinite scroll, and Kotlin Coroutines for asynchronous programming.</p>

## Prerequisites

- A Giphy API Client ID is required. Obtain one from [Giphy](https://giphy.com/) and add it to `Constants.kt`.

## Project Structure

### Home Page
- Displays a list of GIFs retrieved via the Giphy API.
- Uses a grid layout to present the images.
  
### Inner Page
- Shows a full-width view of the selected GIF.
- Displays detailed information retrieved from the API.

<div style="display: flex; flex-wrap: wrap; gap: 10px;">
  <img src="splash screen.png" alt="Splash Screen" width="24%">
  <img src="home page.png" alt="Home Page" width="24%">
  <img src="single inner image.png" alt="Inner Page" width="24%">
  <img src="app interface (2).gif" alt="App Interface" width="24%">
</div>

## Features

1. **MVVM Architecture Pattern**
   - Ensures a clean separation of concerns and enhances testability.
   - Divides the project into three main components: Model, View, and ViewModel.

2. **Retry Option**
   - Allows users to retry network calls if they fail.
   - Implements a user-friendly way to handle network errors.

3. **Responsive Design**
   - Compatible with both phones and tablets.
   - Ensures a consistent user experience across different screen sizes.

4. **Infinite Scroll**
   - Uses the Paging library to implement seamless data loading.
   - Efficiently loads data in chunks to improve performance and user experience.

5. **Pull to Refresh**
   - Refreshes the content with a swipe gesture.
   - Provides an intuitive way for users to update the displayed data.

## Libraries Used

<ul>
  <li><strong>Android Architecture Components</strong>
    <ul>
      <li>ViewModel: Manages UI-related data in a lifecycle-conscious way.</li>
      <li>Paging: Handles infinite scroll and efficient data loading.</li>
      <li>Preference: Manages user preferences.</li>
    </ul>
  </li>
  <li><strong>Dependency Injection</strong>
    <ul>
      <li>Koin: A lightweight dependency injection framework for Kotlin.</li>
    </ul>
  </li>
  <li><strong>Asynchronous Programming</strong>
    <ul>
      <li>Kotlin Coroutines: Simplifies asynchronous programming and provides a cleaner way to manage background tasks.</li>
    </ul>
  </li>
  <li><strong>Image Loading</strong>
    <ul>
      <li>Glide: An image loading and caching library for Android focused on smooth scrolling.</li>
    </ul>
  </li>
</ul>

## Getting Started

### Installation

1. **Clone the repository**
   ```sh
   git clone https://github.com/arunsinghrwt/GifBrowser.git
   cd GifBrowser
   ```

2. **Add Giphy API Key**
   - Open `Constants.kt` located in `GifBrowser/app/src/main/java/com/arun/gifbrowser/Application/Utility/Constants.kt`.
   - Add your Giphy API Client ID:
     ```kotlin
     const val GIPHY_API_KEY = "YOUR_GIPHY_API_KEY"
     ```

3. **Build the project**
   - Open the project in Android Studio.
   - Sync the project with Gradle files.
   - Build and run the project on an Android device or emulator.

## Usage

- **Home Page**: Scroll through the list of GIFs. Use the infinite scroll to load more GIFs.
- **Inner Page**: Tap on any GIF to view it in full screen along with additional details.
- **Pull to Refresh**: Swipe down on the home page to refresh the GIF list.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

For more details, visit the [GifBrowser Repository](https://github.com/arunsinghrwt/GifBrowser).

---
