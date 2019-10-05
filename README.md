# Atto Android
An Architecture To Build Android Applications

Atto Is An Base Structure To Build Android Applications With RxJava And Clean Architecture

![](https://img.shields.io/badge/License-Apache%202.0-blue)
![](https://img.shields.io/badge/Version-1.0.6-green)
![](https://img.shields.io/badge/Android%20Status-AndroidX-green)
![](https://img.shields.io/badge/Language-Kotlin-orange)
![](https://img.shields.io/badge/Project%20Status-Beta%20Version-yellow)
[![Build Status](https://travis-ci.com/Atto-io/Atto-Android.svg?branch=master)](https://travis-ci.com/Atto-io/Atto-Android)

# Library Overview

In a lot of times you download all the Libraries and additions to be able to build your project in addition to that take a lot of time to build the base structure of your project and for this (Atto) facilitates the stage of building the infrastructure of the project with all the additions needed by any Android project and the library consists of 4 Layers and each layer contain their own settings

# Layers Description
1. UI Layer : At User Interface Layer You Can Declare Adapters , Screens (Activities) and Fragments With Firebase Implementation , Application Class With Utils For UI ... With Atto UI Implementation 

2. Data Layer : Includes All Api's Request And Response With Shared Prefrences For Full Project With Executers -> (Executers Is The Base Code For All Api To Handle The Request And Response At ViewModel)

3. Logic Layer : Is The ViewModel Layer TO Handle The Hole Logic At Application  Based On ViewModel With RxJava ... (Component Architecture)

4. Domain Layer : Have All Models At Application With UseCases For Every Request

# Library Basic Flow

![Basic Flow](https://user-images.githubusercontent.com/29167110/64063258-aca0e980-cbfa-11e9-90ae-1fb4e0099b08.png)


# Library Components

- [x] Application Configuration
- [x] Shared Preferences Configuration
- [x] Application Permissions Configuration
- [x] RxJava (Request With Response) Configuration
- [x] Clean Architecture Implementation
- [x] Application Logging (Crashlytics , Timber , Atto Logger , Request Logging)
- [x] ViewModel State Handler
- [x] Domain Layer Powered By UseCases
- [x] UseCases (Online , Offline)
- [x] Data Layer Configuration With Retrofit , Request Handler
- [x] UI Utils (Intent , Dialog , Toast , Keyboard , Network , Screens , etc ....)
- [x] Firebase (Notifications , Firestore , Auth)
- [x] Recycler View Adapter
- [x] Language Configuration
- [x] Image Loaders (Picasso , Fresco)
- [x] ViewModel Powered By RxJava
- [x] UI Configuration (Activities , Fragments)
- [ ] Annotation Processor For Business Logic
- [ ] Annotation Processor For UI Layer
- [ ] Application State (User Story Tracker)
 
# Setup 
1. Build.gradle
```
repositories {
    mavenCentral()
    maven { url  "https://dl.bintray.com/yt98/Atto" }
}
```

2. Dependencies 
```
dependencies {
    implementation "io.atto:atto-core-ktx:1.0.6"
    implementation "io.atto:atto-data-ktx:1.0.6"
    implementation "io.atto:atto-ui-ktx:1.0.6"
    implementation "io.atto:atto-extras-ktx:1.0.6"
    implementation "io.atto:atto-viewmodel-ktx:1.0.6"
    implementation "io.atto:atto-permissions-ktx:1.0.6"
    implementation "io.atto:atto-prefs-ktx:1.0.6"
}
```
[Bintray Package Status](https://bintray.com/yt98/Atto)

# Atto Example Implementation

[Android Example]

Example Stataus : Under Developement

# RoadMap
1. UserStory (Application State)
2. File Detectors (Audio , Video , Images)

# License

Copyright (C) 2019 Atto IO
Atto Android is An Open Source Library  (Licensed under the Apache License, Version 2.0)

