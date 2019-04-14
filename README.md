# Movie-Info-Viewer
This is an android application which displays list of movies and their details from server API.

Introduction

This project is an Android Application Project which intents to implement the requirements mentioned in the Code Check Exercise. I have implemented MovieInfo Viewer android application.

For this I have used https://ghibliapi.herokuapp.com API which returns JSON response. To get the Json response, I have used Retrofit library.


Approach

Following key points have been considered –
•	Architecture – MVVM
•	Android Architecture Component – ViewModel, LiveData,
•	Networking – Retrofit2


MVVM Architecture -  

The project is logically divided into three modules.  Model, View and ViewModel.  

Model - The classes in the “repository” package represents the model and its helper classes to retrieve the model.  Here data is the list of Movies and details retrieved from the Server APIs.

View – All the classes in the “view” package.  These are basically the Activities–MovieListActivity and MovieDetailActivity . Adapters – MovieListAdapter.  

These classes are meant for showing the List of movies and details of movie in UI. For each movie there is options to make it Favourite or vice versa. This functionality is achieved using Shared preference based on MovieId. 

ViewModel - The classes in the “viewmodel” package are those classes which deals with the logic of retrieving the data and handing over to the registered view.  It encapsulates the details of how to retrieve the data and helps the view to focus on showing the data.

With MVVM the code is structured, modularised and readable.


Environment – 

•	Android Studio 3.3.2

Libraries – 

Couple of well adapted libraries has been used in this project.  
•	Retrofit2 – ver 2.3.0
•	Android support – 28.0.0

TODOs

•	Testing – include as many tests as possible – UI, UT etc.
•	Dependency Injection (Dagger).

Thank you for your time.

Shilpa Kathal
